package heibernate_com.offimsg.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.emp.model.EmpVO;
import heibernate_com.emp.model.EmpService;
import heibernate_com.offimsg.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/offimsg/offimsg.do" })
public class OffiMsgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllOffiMsg.jsp 或  /dept/listOffiMsgs_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_offimsg_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addOffiMsg.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllOffiMsg.jsp 或  /dept/listOffiMsgs_ByDeptno.jsp的請求
			delete(req, res);
		}
		if ("list_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
			list_ByCompositeQuery(req, res,false);//預設複合查詢有Like
		}	
	}
	//===========================================【前端 - list_ByCompositeQuery】================================================ 		
	public void front_end_list_ByCompositeQuery(HttpServletRequest req, HttpServletResponse res,boolean ableLike)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***************************1.將輸入資料轉為Map**********************************/ 
			//採用Map<String,String[]> getParameterMap()的方法 
			//注意:an immutable java.util.Map 
			//Map<String, String[]> map = req.getParameterMap();
			HttpSession session = req.getSession();
			Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
			if (req.getParameter("whichPage") == null){
				HashMap<String, String[]> map1 = (HashMap<String, String[]>)req.getParameterMap();
				HashMap<String, String[]> map2 = new HashMap<String, String[]>();
				map2 = (HashMap<String, String[]>)map1.clone();
				session.setAttribute("map",map2);
				map = (HashMap<String, String[]>)req.getParameterMap();
			} 
			/***************************2.開始複合查詢***************************************/
			OffiMsgService offimsgSvc = new OffiMsgService();
			List<OffiMsgVO> list  = offimsgSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listOffiMsgs_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
		}
	}	
	public void list_ByCompositeQuery(HttpServletRequest req, HttpServletResponse res,boolean ableLike)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***************************1.將輸入資料轉為Map**********************************/ 
			//採用Map<String,String[]> getParameterMap()的方法 
			//注意:an immutable java.util.Map 
			//Map<String, String[]> map = req.getParameterMap();
			HttpSession session = req.getSession();
			Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
			if (req.getParameter("whichPage") == null){
				HashMap<String, String[]> map1 = (HashMap<String, String[]>)req.getParameterMap();
				HashMap<String, String[]> map2 = new HashMap<String, String[]>();
				map2 = (HashMap<String, String[]>)map1.clone();
				session.setAttribute("map",map2);
				map = (HashMap<String, String[]>)req.getParameterMap();
			} 
			/***************************2.開始複合查詢***************************************/
			OffiMsgService offimsgSvc = new OffiMsgService();
			List<OffiMsgVO> list  = offimsgSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listOffiMsgs_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/offimsg/listOffiMsgs_ByCompositeQuery.jsp"); // 成功轉交listOffiMsgs_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/offimsg/select_page.jsp");
			failureView.forward(req, res);
		}
	}
	public void getOne_For_Display(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("offiMsg_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訊息編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/offimsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String offiMsg_Id = null;
			try {
				offiMsg_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("訊息編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/offimsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			OffiMsgService offimsgSvc = new OffiMsgService();
			OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);
			if (offimsgVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/offimsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("offimsgVO", offimsgVO); // 資料庫取出的offimsgVO物件,存入req
			String url = "/Heibernate_back-end/offimsg/listOneOffiMsg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneOffiMsg.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/offimsg/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/offimsg/listAllOffiMsg.jsp】 或  【/dept/listOffiMsgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String offiMsg_Id = new String(req.getParameter("offiMsg_Id"));
			/***************************2.開始查詢資料****************************************/
			OffiMsgService offimsgSvc = new OffiMsgService();
			OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("offimsgVO", offimsgVO); // 資料庫取出的offimsgVO物件,存入req
			String url = "/Heibernate_back-end/offimsg/update_offimsg_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_offimsg_input.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher(requestURL);
			failureView.forward(req, res);
		}		
	}
	public void update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			//==== getParameter設定 ====
				String offiMsg_Id = req.getParameter("offiMsg_Id").trim();
				String OFFIMSG_EMPID = req.getParameter("OFFIMSG_EMPID").trim();
				String offiMsg_Title = req.getParameter("offiMsg_Title").trim();
				String offiMsg_Content = req.getParameter("offiMsg_Content").trim();
				java.sql.Timestamp offiMsg_Date = null;
				try {
					offiMsg_Date = java.sql.Timestamp.valueOf(req.getParameter("offiMsg_Date").trim());
				} catch (IllegalArgumentException e) {
					offiMsg_Date=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				OffiMsgVO offimsgVO = new OffiMsgVO();
				offimsgVO.setOffiMsg_Id(offiMsg_Id);
				//以下3行程式碼因為要配合Hibernate的offimsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				EmpVO empVO = new EmpVO();
				empVO.setEmp_No(OFFIMSG_EMPID);
				offimsgVO.setEmpVO(empVO);
				offimsgVO.setOffiMsg_Title(offiMsg_Title);
				offimsgVO.setOffiMsg_Content(offiMsg_Content);
				offimsgVO.setOffiMsg_Date(offiMsg_Date);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("offimsgVO", offimsgVO); // 含有輸入格式錯誤的offimsgVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/offimsg/update_offimsg_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			OffiMsgService offimsgSvc = new OffiMsgService();
			offimsgVO = offimsgSvc.updateOffiMsg(
					offiMsg_Id
					,OFFIMSG_EMPID
					,offiMsg_Title
					,offiMsg_Content
					,offiMsg_Date
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/offimsg/listOffiMsgs_ByEmp_No.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/offimsg/listAllOffiMsg.jsp")){
				//req.setAttribute("listOffiMsgs_ByEmp_No",offimsgSvc.getOffiMsgsByEmp_No(OFFIMSG_EMPID)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/offimsg/listOffiMsgs_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<OffiMsgVO> list  = offimsgSvc.getAll(map);
				//req.setAttribute("listOffiMsgs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/offimsg/update_offimsg_input.jsp");
			failureView.forward(req, res);
		}
	}
	public void insert(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
               String OFFIMSG_EMPID = req.getParameter("OFFIMSG_EMPID").trim();	
               String offiMsg_Title = req.getParameter("offiMsg_Title").trim();	
               String offiMsg_Content = req.getParameter("offiMsg_Content").trim();	
               java.sql.Timestamp offiMsg_Date = null;
               try {
                   offiMsg_Date = java.sql.Timestamp.valueOf(req.getParameter("offiMsg_Date").trim());
               } catch (IllegalArgumentException e) {
                   offiMsg_Date=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               OffiMsgVO offimsgVO = new OffiMsgVO();
				//以下3行程式碼因為要配合Hibernate的offimsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				EmpVO empVO = new EmpVO();
				empVO.setEmp_No(OFFIMSG_EMPID);
				offimsgVO.setEmpVO(empVO);
				offimsgVO.setOffiMsg_Title(offiMsg_Title);
				offimsgVO.setOffiMsg_Content(offiMsg_Content);
				offimsgVO.setOffiMsg_Date(offiMsg_Date);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("offimsgVO", offimsgVO); // 含有輸入格式錯誤的offimsgVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/offimsg/addOffiMsg.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               OffiMsgService offimsgSvc = new OffiMsgService();
               offimsgVO = offimsgSvc.addOffiMsg(
               	OFFIMSG_EMPID
               	,offiMsg_Title
               	,offiMsg_Content
               	,offiMsg_Date
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/offimsg/listAllOffiMsg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOffiMsg.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/offimsg/addOffiMsg.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/offimsg/listAllOffiMsg.jsp】 或  【/dept/listOffiMsgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String offiMsg_Id = new String(req.getParameter("offiMsg_Id"));
			/***************************2.開始刪除資料***************************************/
			OffiMsgService offimsgSvc = new OffiMsgService();
			OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);
			offimsgSvc.deleteOffiMsg(offiMsg_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			EmpService empSvc = new EmpService();
			if(requestURL.equals("/emp/listOffiMsgs_ByEmp_No.jsp") || requestURL.equals("/emp/listAllEmp.jsp")){
			  //req.setAttribute("listOffiMsgs_ByEmp_No",empSvc.getOffiMsgsByEmp_No(offimsgVO.getEmp_No())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listOffiMsgs_ByEmp_No",empSvc.getOffiMsgsByEmp_No(offimsgVO.getEmpVO().getEmp_No())); // 資料庫取出的list物件,存入request
			}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add("刪除資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher(requestURL);
			failureView.forward(req, res);
		}		
	}
}
