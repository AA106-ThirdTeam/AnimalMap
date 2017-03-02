package heibernate_com.adpmsg.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.adp.model.AdpVO;
import heibernate_com.adp.model.AdpService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.adpmsg.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/adpmsg/adpmsg.do" })
public class AdpMsgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllAdpMsg.jsp 或  /dept/listAdpMsgs_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_adpmsg_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addAdpMsg.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllAdpMsg.jsp 或  /dept/listAdpMsgs_ByDeptno.jsp的請求
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
			AdpMsgService adpmsgSvc = new AdpMsgService();
			List<AdpMsgVO> list  = adpmsgSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listAdpMsgs_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			AdpMsgService adpmsgSvc = new AdpMsgService();
			List<AdpMsgVO> list  = adpmsgSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listAdpMsgs_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/adpmsg/listAdpMsgs_ByCompositeQuery.jsp"); // 成功轉交listAdpMsgs_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adpmsg/select_page.jsp");
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
			String str = req.getParameter("adpMsg_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入領養活動留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adpmsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String adpMsg_Id = null;
			try {
				adpMsg_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("領養活動留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adpmsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			AdpMsgService adpmsgSvc = new AdpMsgService();
			AdpMsgVO adpmsgVO = adpmsgSvc.getOneAdpMsg(adpMsg_Id);
			if (adpmsgVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adpmsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("adpmsgVO", adpmsgVO); // 資料庫取出的adpmsgVO物件,存入req
			String url = "/Heibernate_back-end/adpmsg/listOneAdpMsg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneAdpMsg.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adpmsg/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/adpmsg/listAllAdpMsg.jsp】 或  【/dept/listAdpMsgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String adpMsg_Id = new String(req.getParameter("adpMsg_Id"));
			/***************************2.開始查詢資料****************************************/
			AdpMsgService adpmsgSvc = new AdpMsgService();
			AdpMsgVO adpmsgVO = adpmsgSvc.getOneAdpMsg(adpMsg_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("adpmsgVO", adpmsgVO); // 資料庫取出的adpmsgVO物件,存入req
			String url = "/Heibernate_back-end/adpmsg/update_adpmsg_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_adpmsg_input.jsp
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
				String adpMsg_Id = req.getParameter("adpMsg_Id").trim();
				String adp_Id = req.getParameter("adp_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String msg = req.getParameter("msg").trim();
				java.sql.Date adpMsgDate = null;
				try {
					adpMsgDate = java.sql.Date.valueOf(req.getParameter("adpMsgDate").trim());
				} catch (IllegalArgumentException e) {
					adpMsgDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date adpMsgadp_upDate = null;
				try {
					adpMsgadp_upDate = java.sql.Date.valueOf(req.getParameter("adpMsgadp_upDate").trim());
				} catch (IllegalArgumentException e) {
					adpMsgadp_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				AdpMsgVO adpmsgVO = new AdpMsgVO();
				adpmsgVO.setAdpMsg_Id(adpMsg_Id);
				//以下3行程式碼因為要配合Hibernate的adpmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AdpVO adpVO = new AdpVO();
				adpVO.setAdp_Id(adp_Id);
				adpmsgVO.setAdpVO(adpVO);
				//以下3行程式碼因為要配合Hibernate的adpmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				adpmsgVO.setMemVO(memVO);
				adpmsgVO.setMsg(msg);
				adpmsgVO.setAdpMsgDate(adpMsgDate);
				adpmsgVO.setAdpMsgadp_upDate(adpMsgadp_upDate);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adpmsgVO", adpmsgVO); // 含有輸入格式錯誤的adpmsgVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adpmsg/update_adpmsg_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			AdpMsgService adpmsgSvc = new AdpMsgService();
			adpmsgVO = adpmsgSvc.updateAdpMsg(
					adpMsg_Id
					,adp_Id
					,mem_Id
					,msg
					,adpMsgDate
					,adpMsgadp_upDate
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/adpmsg/listAdpMsgs_ByAdp_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adpmsg/listAllAdpMsg.jsp")){
				//req.setAttribute("listAdpMsgs_ByAdp_Id",adpmsgSvc.getAdpMsgsByAdp_Id(adp_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adpmsg/listAdpMsgs_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adpmsg/listAllAdpMsg.jsp")){
				//req.setAttribute("listAdpMsgs_ByMem_Id",adpmsgSvc.getAdpMsgsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adpmsg/listAdpMsgs_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<AdpMsgVO> list  = adpmsgSvc.getAll(map);
				//req.setAttribute("listAdpMsgs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adpmsg/update_adpmsg_input.jsp");
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
               String adp_Id = req.getParameter("adp_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               String msg = req.getParameter("msg").trim();	
               java.sql.Date adpMsgDate = null;
               try {
                   adpMsgDate = java.sql.Date.valueOf(req.getParameter("adpMsgDate").trim());
               } catch (IllegalArgumentException e) {
                   adpMsgDate=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date adpMsgadp_upDate = null;
               try {
                   adpMsgadp_upDate = java.sql.Date.valueOf(req.getParameter("adpMsgadp_upDate").trim());
               } catch (IllegalArgumentException e) {
                   adpMsgadp_upDate=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               AdpMsgVO adpmsgVO = new AdpMsgVO();
				//以下3行程式碼因為要配合Hibernate的adpmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AdpVO adpVO = new AdpVO();
				adpVO.setAdp_Id(adp_Id);
				adpmsgVO.setAdpVO(adpVO);
				//以下3行程式碼因為要配合Hibernate的adpmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				adpmsgVO.setMemVO(memVO);
				adpmsgVO.setMsg(msg);
				adpmsgVO.setAdpMsgDate(adpMsgDate);
				adpmsgVO.setAdpMsgadp_upDate(adpMsgadp_upDate);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("adpmsgVO", adpmsgVO); // 含有輸入格式錯誤的adpmsgVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/adpmsg/addAdpMsg.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               AdpMsgService adpmsgSvc = new AdpMsgService();
               adpmsgVO = adpmsgSvc.addAdpMsg(
               	adp_Id
               	,mem_Id
               	,msg
               	,adpMsgDate
               	,adpMsgadp_upDate
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/adpmsg/listAllAdpMsg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdpMsg.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adpmsg/addAdpMsg.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/adpmsg/listAllAdpMsg.jsp】 或  【/dept/listAdpMsgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String adpMsg_Id = new String(req.getParameter("adpMsg_Id"));
			/***************************2.開始刪除資料***************************************/
			AdpMsgService adpmsgSvc = new AdpMsgService();
			AdpMsgVO adpmsgVO = adpmsgSvc.getOneAdpMsg(adpMsg_Id);
			adpmsgSvc.deleteAdpMsg(adpMsg_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			AdpService adpSvc = new AdpService();
			if(requestURL.equals("/adp/listAdpMsgs_ByAdp_Id.jsp") || requestURL.equals("/adp/listAllAdp.jsp")){
			  //req.setAttribute("listAdpMsgs_ByAdp_Id",adpSvc.getAdpMsgsByAdp_Id(adpmsgVO.getAdp_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdpMsgs_ByAdp_Id",adpSvc.getAdpMsgsByAdp_Id(adpmsgVO.getAdpVO().getAdp_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listAdpMsgs_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listAdpMsgs_ByMem_Id",memSvc.getAdpMsgsByMem_Id(adpmsgVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdpMsgs_ByMem_Id",memSvc.getAdpMsgsByMem_Id(adpmsgVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
