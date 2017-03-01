package heibernate_com.emg_h_msg.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.emg_help.model.Emg_HelpVO;
import heibernate_com.emg_help.model.Emg_HelpService;
import heibernate_com.emg_h_msg.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/emg_h_msg/emg_h_msg.do" })
public class Emg_H_MsgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmg_H_Msg.jsp 或  /dept/listEmg_H_Msgs_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_emg_h_msg_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addEmg_H_Msg.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllEmg_H_Msg.jsp 或  /dept/listEmg_H_Msgs_ByDeptno.jsp的請求
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
			Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
			List<Emg_H_MsgVO> list  = emg_h_msgSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listEmg_H_Msgs_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
			List<Emg_H_MsgVO> list  = emg_h_msgSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listEmg_H_Msgs_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/listEmg_H_Msgs_ByCompositeQuery.jsp"); // 成功轉交listEmg_H_Msgs_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/select_page.jsp");
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
			String str = req.getParameter("emg_H_Msg_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入緊急求救留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String emg_H_Msg_Id = null;
			try {
				emg_H_Msg_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("緊急求救留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
			Emg_H_MsgVO emg_h_msgVO = emg_h_msgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);
			if (emg_h_msgVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("emg_h_msgVO", emg_h_msgVO); // 資料庫取出的emg_h_msgVO物件,存入req
			String url = "/Heibernate_back-end/emg_h_msg/listOneEmg_H_Msg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmg_H_Msg.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/emg_h_msg/listAllEmg_H_Msg.jsp】 或  【/dept/listEmg_H_Msgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String emg_H_Msg_Id = new String(req.getParameter("emg_H_Msg_Id"));
			/***************************2.開始查詢資料****************************************/
			Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
			Emg_H_MsgVO emg_h_msgVO = emg_h_msgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("emg_h_msgVO", emg_h_msgVO); // 資料庫取出的emg_h_msgVO物件,存入req
			String url = "/Heibernate_back-end/emg_h_msg/update_emg_h_msg_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emg_h_msg_input.jsp
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
				String emg_H_Msg_Id = req.getParameter("emg_H_Msg_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String emg_H_Id = req.getParameter("emg_H_Id").trim();
				java.sql.Timestamp emg_H_Msg_start = null;
				try {
					emg_H_Msg_start = java.sql.Timestamp.valueOf(req.getParameter("emg_H_Msg_start").trim());
				} catch (IllegalArgumentException e) {
					emg_H_Msg_start=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String emg_H_Msg_content = req.getParameter("emg_H_Msg_content").trim();
			//==== VO設定部分 ====			
				Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();
				emg_h_msgVO.setEmg_H_Msg_Id(emg_H_Msg_Id);
				//以下3行程式碼因為要配合Hibernate的emg_h_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				emg_h_msgVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的emg_h_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Emg_HelpVO emg_helpVO = new Emg_HelpVO();
				emg_helpVO.setEmg_H_Id(emg_H_Id);
				emg_h_msgVO.setEmg_HelpVO(emg_helpVO);
				emg_h_msgVO.setEmg_H_Msg_start(emg_H_Msg_start);
				emg_h_msgVO.setEmg_H_Msg_content(emg_H_Msg_content);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("emg_h_msgVO", emg_h_msgVO); // 含有輸入格式錯誤的emg_h_msgVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/update_emg_h_msg_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
			emg_h_msgVO = emg_h_msgSvc.updateEmg_H_Msg(
					emg_H_Msg_Id
					,mem_Id
					,emg_H_Id
					,emg_H_Msg_start
					,emg_H_Msg_content
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/emg_h_msg/listEmg_H_Msgs_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/emg_h_msg/listAllEmg_H_Msg.jsp")){
				//req.setAttribute("listEmg_H_Msgs_ByMem_Id",emg_h_msgSvc.getEmg_H_MsgsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/emg_h_msg/listEmg_H_Msgs_ByEmg_H_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/emg_h_msg/listAllEmg_H_Msg.jsp")){
				//req.setAttribute("listEmg_H_Msgs_ByEmg_H_Id",emg_h_msgSvc.getEmg_H_MsgsByEmg_H_Id(emg_H_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/emg_h_msg/listEmg_H_Msgs_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Emg_H_MsgVO> list  = emg_h_msgSvc.getAll(map);
				//req.setAttribute("listEmg_H_Msgs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/update_emg_h_msg_input.jsp");
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
               String mem_Id = req.getParameter("mem_Id").trim();	
               String emg_H_Id = req.getParameter("emg_H_Id").trim();	
               java.sql.Timestamp emg_H_Msg_start = null;
               try {
                   emg_H_Msg_start = java.sql.Timestamp.valueOf(req.getParameter("emg_H_Msg_start").trim());
               } catch (IllegalArgumentException e) {
                   emg_H_Msg_start=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String emg_H_Msg_content = req.getParameter("emg_H_Msg_content").trim();	
               Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();
				//以下3行程式碼因為要配合Hibernate的emg_h_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				emg_h_msgVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的emg_h_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Emg_HelpVO emg_helpVO = new Emg_HelpVO();
				emg_helpVO.setEmg_H_Id(emg_H_Id);
				emg_h_msgVO.setEmg_HelpVO(emg_helpVO);
				emg_h_msgVO.setEmg_H_Msg_start(emg_H_Msg_start);
				emg_h_msgVO.setEmg_H_Msg_content(emg_H_Msg_content);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("emg_h_msgVO", emg_h_msgVO); // 含有輸入格式錯誤的emg_h_msgVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/addEmg_H_Msg.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
               emg_h_msgVO = emg_h_msgSvc.addEmg_H_Msg(
               	mem_Id
               	,emg_H_Id
               	,emg_H_Msg_start
               	,emg_H_Msg_content
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/emg_h_msg/listAllEmg_H_Msg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmg_H_Msg.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emg_h_msg/addEmg_H_Msg.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/emg_h_msg/listAllEmg_H_Msg.jsp】 或  【/dept/listEmg_H_Msgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String emg_H_Msg_Id = new String(req.getParameter("emg_H_Msg_Id"));
			/***************************2.開始刪除資料***************************************/
			Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
			Emg_H_MsgVO emg_h_msgVO = emg_h_msgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);
			emg_h_msgSvc.deleteEmg_H_Msg(emg_H_Msg_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listEmg_H_Msgs_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listEmg_H_Msgs_ByMem_Id",memSvc.getEmg_H_MsgsByMem_Id(emg_h_msgVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listEmg_H_Msgs_ByMem_Id",memSvc.getEmg_H_MsgsByMem_Id(emg_h_msgVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
			Emg_HelpService emg_helpSvc = new Emg_HelpService();
			if(requestURL.equals("/emg_help/listEmg_H_Msgs_ByEmg_H_Id.jsp") || requestURL.equals("/emg_help/listAllEmg_Help.jsp")){
			  //req.setAttribute("listEmg_H_Msgs_ByEmg_H_Id",emg_helpSvc.getEmg_H_MsgsByEmg_H_Id(emg_h_msgVO.getEmg_H_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listEmg_H_Msgs_ByEmg_H_Id",emg_helpSvc.getEmg_H_MsgsByEmg_H_Id(emg_h_msgVO.getEmg_HelpVO().getEmg_H_Id())); // 資料庫取出的list物件,存入request
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
