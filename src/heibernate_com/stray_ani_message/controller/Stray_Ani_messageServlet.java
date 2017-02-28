package heibernate_com.stray_ani_message.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.stray_ani.model.Stray_AniVO;
import heibernate_com.stray_ani.model.Stray_AniService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.stray_ani_message.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/stray_ani_message/stray_ani_message.do" })
public class Stray_Ani_messageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllStray_Ani_message.jsp 或  /dept/listStray_Ani_messages_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_stray_ani_message_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addStray_Ani_message.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllStray_Ani_message.jsp 或  /dept/listStray_Ani_messages_ByDeptno.jsp的請求
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
			Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
			List<Stray_Ani_messageVO> list  = stray_ani_messageSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listStray_Ani_messages_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
			List<Stray_Ani_messageVO> list  = stray_ani_messageSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listStray_Ani_messages_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/listStray_Ani_messages_ByCompositeQuery.jsp"); // 成功轉交listStray_Ani_messages_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/select_page.jsp");
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
			String str = req.getParameter("str_Ani_Mes_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入流浪動物留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String str_Ani_Mes_No = null;
			try {
				str_Ani_Mes_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("流浪動物留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
			Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);
			if (stray_ani_messageVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); // 資料庫取出的stray_ani_messageVO物件,存入req
			String url = "/Heibernate_back-end/stray_ani_message/listOneStray_Ani_message.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneStray_Ani_message.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/stray_ani_message/listAllStray_Ani_message.jsp】 或  【/dept/listStray_Ani_messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String str_Ani_Mes_No = new String(req.getParameter("str_Ani_Mes_No"));
			/***************************2.開始查詢資料****************************************/
			Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
			Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); // 資料庫取出的stray_ani_messageVO物件,存入req
			String url = "/Heibernate_back-end/stray_ani_message/update_stray_ani_message_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_stray_ani_message_input.jsp
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
				String str_Ani_Mes_No = req.getParameter("str_Ani_Mes_No").trim();
				String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				java.sql.Timestamp str_Ani_Mes_time = null;
				try {
					str_Ani_Mes_time = java.sql.Timestamp.valueOf(req.getParameter("str_Ani_Mes_time").trim());
				} catch (IllegalArgumentException e) {
					str_Ani_Mes_time=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String str_Ani_Mes = req.getParameter("str_Ani_Mes").trim();
			//==== VO設定部分 ====			
				Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
				stray_ani_messageVO.setStr_Ani_Mes_No(str_Ani_Mes_No);
				//以下3行程式碼因為要配合Hibernate的stray_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Stray_AniVO stray_aniVO = new Stray_AniVO();
				stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
				stray_ani_messageVO.setStray_AniVO(stray_aniVO);
				//以下3行程式碼因為要配合Hibernate的stray_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				stray_ani_messageVO.setMemVO(memVO);
				stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
				stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); // 含有輸入格式錯誤的stray_ani_messageVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/update_stray_ani_message_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
			stray_ani_messageVO = stray_ani_messageSvc.updateStray_Ani_message(
					str_Ani_Mes_No
					,stray_Ani_Id
					,mem_Id
					,str_Ani_Mes_time
					,str_Ani_Mes
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/stray_ani_message/listStray_Ani_messages_ByStray_Ani_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/stray_ani_message/listAllStray_Ani_message.jsp")){
				//req.setAttribute("listStray_Ani_messages_ByStray_Ani_Id",stray_ani_messageSvc.getStray_Ani_messagesByStray_Ani_Id(stray_Ani_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/stray_ani_message/listStray_Ani_messages_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/stray_ani_message/listAllStray_Ani_message.jsp")){
				//req.setAttribute("listStray_Ani_messages_ByMem_Id",stray_ani_messageSvc.getStray_Ani_messagesByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/stray_ani_message/listStray_Ani_messages_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Stray_Ani_messageVO> list  = stray_ani_messageSvc.getAll(map);
				//req.setAttribute("listStray_Ani_messages_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/update_stray_ani_message_input.jsp");
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
               String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               java.sql.Timestamp str_Ani_Mes_time = null;
               try {
                   str_Ani_Mes_time = java.sql.Timestamp.valueOf(req.getParameter("str_Ani_Mes_time").trim());
               } catch (IllegalArgumentException e) {
                   str_Ani_Mes_time=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String str_Ani_Mes = req.getParameter("str_Ani_Mes").trim();	
               Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
				//以下3行程式碼因為要配合Hibernate的stray_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Stray_AniVO stray_aniVO = new Stray_AniVO();
				stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
				stray_ani_messageVO.setStray_AniVO(stray_aniVO);
				//以下3行程式碼因為要配合Hibernate的stray_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				stray_ani_messageVO.setMemVO(memVO);
				stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
				stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); // 含有輸入格式錯誤的stray_ani_messageVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/addStray_Ani_message.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
               stray_ani_messageVO = stray_ani_messageSvc.addStray_Ani_message(
               	stray_Ani_Id
               	,mem_Id
               	,str_Ani_Mes_time
               	,str_Ani_Mes
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/stray_ani_message/listAllStray_Ani_message.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllStray_Ani_message.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/stray_ani_message/addStray_Ani_message.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/stray_ani_message/listAllStray_Ani_message.jsp】 或  【/dept/listStray_Ani_messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String str_Ani_Mes_No = new String(req.getParameter("str_Ani_Mes_No"));
			/***************************2.開始刪除資料***************************************/
			Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
			Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);
			stray_ani_messageSvc.deleteStray_Ani_message(str_Ani_Mes_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			Stray_AniService stray_aniSvc = new Stray_AniService();
			if(requestURL.equals("/stray_ani/listStray_Ani_messages_ByStray_Ani_Id.jsp") || requestURL.equals("/stray_ani/listAllStray_Ani.jsp")){
			  //req.setAttribute("listStray_Ani_messages_ByStray_Ani_Id",stray_aniSvc.getStray_Ani_messagesByStray_Ani_Id(stray_ani_messageVO.getStray_Ani_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listStray_Ani_messages_ByStray_Ani_Id",stray_aniSvc.getStray_Ani_messagesByStray_Ani_Id(stray_ani_messageVO.getStray_AniVO().getStray_Ani_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listStray_Ani_messages_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listStray_Ani_messages_ByMem_Id",memSvc.getStray_Ani_messagesByMem_Id(stray_ani_messageVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listStray_Ani_messages_ByMem_Id",memSvc.getStray_Ani_messagesByMem_Id(stray_ani_messageVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
