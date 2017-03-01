package heibernate_com.priv_message.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.priv_message.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/priv_message/priv_message.do" })
public class Priv_messageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllPriv_message.jsp 或  /dept/listPriv_messages_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_priv_message_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addPriv_message.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllPriv_message.jsp 或  /dept/listPriv_messages_ByDeptno.jsp的請求
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
			Priv_messageService priv_messageSvc = new Priv_messageService();
			List<Priv_messageVO> list  = priv_messageSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPriv_messages_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Priv_messageService priv_messageSvc = new Priv_messageService();
			List<Priv_messageVO> list  = priv_messageSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPriv_messages_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/priv_message/listPriv_messages_ByCompositeQuery.jsp"); // 成功轉交listPriv_messages_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/priv_message/select_page.jsp");
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
			String str = req.getParameter("privMsg_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入私人訊息編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/priv_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String privMsg_Id = null;
			try {
				privMsg_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("私人訊息編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/priv_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Priv_messageService priv_messageSvc = new Priv_messageService();
			Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMsg_Id);
			if (priv_messageVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/priv_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("priv_messageVO", priv_messageVO); // 資料庫取出的priv_messageVO物件,存入req
			String url = "/Heibernate_back-end/priv_message/listOnePriv_message.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOnePriv_message.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/priv_message/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/priv_message/listAllPriv_message.jsp】 或  【/dept/listPriv_messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String privMsg_Id = new String(req.getParameter("privMsg_Id"));
			/***************************2.開始查詢資料****************************************/
			Priv_messageService priv_messageSvc = new Priv_messageService();
			Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMsg_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("priv_messageVO", priv_messageVO); // 資料庫取出的priv_messageVO物件,存入req
			String url = "/Heibernate_back-end/priv_message/update_priv_message_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_priv_message_input.jsp
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
				String privMsg_Id = req.getParameter("privMsg_Id").trim();
				String privMsgSend_MemId = req.getParameter("privMsgSend_MemId").trim();
				String privMsgRec_MemId = req.getParameter("privMsgRec_MemId").trim();
				String privMsg_content = req.getParameter("privMsg_content").trim();
				java.sql.Timestamp privMsg_SendTime = null;
				try {
					privMsg_SendTime = java.sql.Timestamp.valueOf(req.getParameter("privMsg_SendTime").trim());
				} catch (IllegalArgumentException e) {
					privMsg_SendTime=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String privMsg_type = req.getParameter("privMsg_type").trim();
			//==== VO設定部分 ====			
				Priv_messageVO priv_messageVO = new Priv_messageVO();
				priv_messageVO.setPrivMsg_Id(privMsg_Id);
				//以下3行程式碼因為要配合Hibernate的priv_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(privMsgSend_MemId);
				priv_messageVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的priv_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				memVO = new MemVO();
				memVO.setMem_Id(privMsgRec_MemId);
				priv_messageVO.setMemVO(memVO);
				priv_messageVO.setPrivMsg_content(privMsg_content);
				priv_messageVO.setPrivMsg_SendTime(privMsg_SendTime);
				priv_messageVO.setPrivMsg_type(privMsg_type);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("priv_messageVO", priv_messageVO); // 含有輸入格式錯誤的priv_messageVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/priv_message/update_priv_message_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Priv_messageService priv_messageSvc = new Priv_messageService();
			priv_messageVO = priv_messageSvc.updatePriv_message(
					privMsg_Id
					,privMsgSend_MemId
					,privMsgRec_MemId
					,privMsg_content
					,privMsg_SendTime
					,privMsg_type
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/priv_message/listPriv_messages_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/priv_message/listAllPriv_message.jsp")){
				//req.setAttribute("listPriv_messages_ByMem_Id",priv_messageSvc.getPriv_messagesByMem_Id(privMsgSend_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/priv_message/listPriv_messages_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/priv_message/listAllPriv_message.jsp")){
				//req.setAttribute("listPriv_messages_ByMem_Id",priv_messageSvc.getPriv_messagesByMem_Id(privMsgRec_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/priv_message/listPriv_messages_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Priv_messageVO> list  = priv_messageSvc.getAll(map);
				//req.setAttribute("listPriv_messages_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/priv_message/update_priv_message_input.jsp");
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
               String privMsgSend_MemId = req.getParameter("privMsgSend_MemId").trim();	
               String privMsgRec_MemId = req.getParameter("privMsgRec_MemId").trim();	
               String privMsg_content = req.getParameter("privMsg_content").trim();	
               java.sql.Timestamp privMsg_SendTime = null;
               try {
                   privMsg_SendTime = java.sql.Timestamp.valueOf(req.getParameter("privMsg_SendTime").trim());
               } catch (IllegalArgumentException e) {
                   privMsg_SendTime=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String privMsg_type = req.getParameter("privMsg_type").trim();	
               Priv_messageVO priv_messageVO = new Priv_messageVO();
				//以下3行程式碼因為要配合Hibernate的priv_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(privMsgSend_MemId);
				priv_messageVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的priv_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				memVO = new MemVO();
				memVO.setMem_Id(privMsgRec_MemId);
				priv_messageVO.setMemVO(memVO);
				priv_messageVO.setPrivMsg_content(privMsg_content);
				priv_messageVO.setPrivMsg_SendTime(privMsg_SendTime);
				priv_messageVO.setPrivMsg_type(privMsg_type);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("priv_messageVO", priv_messageVO); // 含有輸入格式錯誤的priv_messageVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/priv_message/addPriv_message.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Priv_messageService priv_messageSvc = new Priv_messageService();
               priv_messageVO = priv_messageSvc.addPriv_message(
               	privMsgSend_MemId
               	,privMsgRec_MemId
               	,privMsg_content
               	,privMsg_SendTime
               	,privMsg_type
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/priv_message/listAllPriv_message.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPriv_message.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/priv_message/addPriv_message.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/priv_message/listAllPriv_message.jsp】 或  【/dept/listPriv_messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String privMsg_Id = new String(req.getParameter("privMsg_Id"));
			/***************************2.開始刪除資料***************************************/
			Priv_messageService priv_messageSvc = new Priv_messageService();
			Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMsg_Id);
			priv_messageSvc.deletePriv_message(privMsg_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listPriv_messages_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listPriv_messages_ByMem_Id",memSvc.getPriv_messagesByMem_Id(priv_messageVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPriv_messages_ByMem_Id",memSvc.getPriv_messagesByMem_Id(priv_messageVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
			memSvc = new MemService();
			if(requestURL.equals("/mem/listPriv_messages_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listPriv_messages_ByMem_Id",memSvc.getPriv_messagesByMem_Id(priv_messageVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPriv_messages_ByMem_Id",memSvc.getPriv_messagesByMem_Id(priv_messageVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
