package heibernate_com.anihome_msg.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.anihome.model.AniHomeVO;
import heibernate_com.anihome.model.AniHomeService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.anihome_msg.model.*;

@WebServlet(urlPatterns = { "/back-end/anihome_msg/anihome_msg.do" })
public class AniHome_MsgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp的請求
			delete(req, res);
		}
	}
	private void getOne_For_Display(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("aniHome_Msg_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入動物之家留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/anihome_msg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String aniHome_Msg_Id = null;
			try {
				aniHome_Msg_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("動物之家留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/anihome_msg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
			AniHome_MsgVO anihome_msgVO = anihome_msgSvc.getOneAniHome_Msg(aniHome_Msg_Id);
			if (anihome_msgVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/anihome_msg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("anihome_msgVO", anihome_msgVO); // 資料庫取出的anihome_msgVO物件,存入req
			String url = "/back-end/anihome_msg/listOneAniHome_Msg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/back-end/anihome_msg/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	private void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String aniHome_Msg_Id = new String(req.getParameter("aniHome_Msg_Id"));
			/***************************2.開始查詢資料****************************************/
			AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
			AniHome_MsgVO anihome_msgVO = anihome_msgSvc.getOneAniHome_Msg(aniHome_Msg_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("anihome_msgVO", anihome_msgVO); // 資料庫取出的anihome_msgVO物件,存入req
			String url = "/back-end/anihome_msg/update_anihome_msg_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emp_input.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher(requestURL);
			failureView.forward(req, res);
		}		
	}
	private void update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			//==== getParameter設定 ====
				String aniHome_Msg_Id = req.getParameter("aniHome_Msg_Id").trim();
				String aniHome_Id = req.getParameter("aniHome_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String aniHome_Msg = req.getParameter("aniHome_Msg").trim();
				java.sql.Date adp_start_date = null;
				try {
					adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
				} catch (IllegalArgumentException e) {
					adp_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
				anihome_msgVO.setAniHome_Msg_Id(aniHome_Msg_Id);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AniHomeVO anihomeVO = new AniHomeVO();
				anihomeVO.setAniHome_Id(aniHome_Id);
				anihome_msgVO.setAniHomeVO(anihomeVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				anihome_msgVO.setMemVO(memVO);
				anihome_msgVO.setAniHome_Msg(aniHome_Msg);
				anihome_msgVO.setAdp_start_date(adp_start_date);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("anihome_msgVO", anihome_msgVO); // 含有輸入格式錯誤的anihome_msgVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/anihome_msg/update_anihome_msg_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
			anihome_msgVO = anihome_msgSvc.updateAniHome_Msg(
					aniHome_Msg_Id
					,aniHome_Id
					,mem_Id
					,aniHome_Msg
					,adp_start_date
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/back-end/anihome_msg/listAniHome_Msgs_ByAniHome_Id.jsp") 
				//|| requestURL.equals("/back-end/anihome_msg/listAllAniHome_Msg.jsp")){
				//req.setAttribute("listAniHome_Msgs_ByAniHome_Id",anihome_msgSvc.getAniHome_MsgsByAniHome_Id(aniHome_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/back-end/anihome_msg/listAniHome_Msgs_ByMem_Id.jsp") 
				//|| requestURL.equals("/back-end/anihome_msg/listAllAniHome_Msg.jsp")){
				//req.setAttribute("listAniHome_Msgs_ByMem_Id",anihome_msgSvc.getAniHome_MsgsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/back-end/anihome_msg/listAniHome_Msgs_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<AniHome_MsgVO> list  = anihome_msgSvc.getAll(map);
				//req.setAttribute("listAniHome_Msgs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/back-end/anihome_msg/update_anihome_msg_input.jsp");
			failureView.forward(req, res);
		}
	}
	private void insert(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
               String aniHome_Id = req.getParameter("aniHome_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               String aniHome_Msg = req.getParameter("aniHome_Msg").trim();	
               java.sql.Date adp_start_date = null;
               try {
                   adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
               } catch (IllegalArgumentException e) {
                   adp_start_date=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AniHomeVO anihomeVO = new AniHomeVO();
				anihomeVO.setAniHome_Id(aniHome_Id);
				anihome_msgVO.setAniHomeVO(anihomeVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				anihome_msgVO.setMemVO(memVO);
				anihome_msgVO.setAniHome_Msg(aniHome_Msg);
				anihome_msgVO.setAdp_start_date(adp_start_date);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("anihome_msgVO", anihome_msgVO); // 含有輸入格式錯誤的anihome_msgVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/back-end/anihome_msg/addAniHome_Msg.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
               anihome_msgVO = anihome_msgSvc.addAniHome_Msg(
               	aniHome_Id
               	,mem_Id
               	,aniHome_Msg
               	,adp_start_date
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/back-end/anihome_msg/listAllAniHome_Msg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAniHome_Msg.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/back-end/anihome_msg/addAniHome_Msg.jsp");
			failureView.forward(req, res);
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String aniHome_Msg_Id = new String(req.getParameter("aniHome_Msg_Id"));
			/***************************2.開始刪除資料***************************************/
			AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
			AniHome_MsgVO anihome_msgVO = anihome_msgSvc.getOneAniHome_Msg(aniHome_Msg_Id);
			anihome_msgSvc.deleteAniHome_Msg(aniHome_Msg_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			AniHomeService anihomeSvc = new AniHomeService();
			if(requestURL.equals("/anihome/listAniHome_Msgs_ByAniHome_Id.jsp") || requestURL.equals("/anihome/listAllAniHome.jsp")){
			  //req.setAttribute("listAniHome_Msgs_ByAniHome_Id",anihomeSvc.getAniHome_MsgsByAniHome_Id(anihome_msgVO.getAniHome_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAniHome_Msgs_ByAniHome_Id",anihomeSvc.getAniHome_MsgsByAniHome_Id(anihome_msgVO.getAniHomeVO().getAniHome_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listAniHome_Msgs_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listAniHome_Msgs_ByMem_Id",memSvc.getAniHome_MsgsByMem_Id(anihome_msgVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAniHome_Msgs_ByMem_Id",memSvc.getAniHome_MsgsByMem_Id(anihome_msgVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
