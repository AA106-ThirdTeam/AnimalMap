package heibernate_com.adopt_ani_message.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.adopt_ani.model.Adopt_AniVO;
import heibernate_com.adopt_ani.model.Adopt_AniService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.adopt_ani_message.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/adopt_ani_message/adopt_ani_message.do" })
public class Adopt_Ani_messageServlet extends HttpServlet {
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
			String str = req.getParameter("ado_Ani_Mes_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入送養動物留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adopt_ani_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String ado_Ani_Mes_No = null;
			try {
				ado_Ani_Mes_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("送養動物留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adopt_ani_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Adopt_Ani_messageService adopt_ani_messageSvc = new Adopt_Ani_messageService();
			Adopt_Ani_messageVO adopt_ani_messageVO = adopt_ani_messageSvc.getOneAdopt_Ani_message(ado_Ani_Mes_No);
			if (adopt_ani_messageVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adopt_ani_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("adopt_ani_messageVO", adopt_ani_messageVO); // 資料庫取出的adopt_ani_messageVO物件,存入req
			String url = "/Heibernate_back-end/adopt_ani_message/listOneAdopt_Ani_message.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adopt_ani_message/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	private void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String ado_Ani_Mes_No = new String(req.getParameter("ado_Ani_Mes_No"));
			/***************************2.開始查詢資料****************************************/
			Adopt_Ani_messageService adopt_ani_messageSvc = new Adopt_Ani_messageService();
			Adopt_Ani_messageVO adopt_ani_messageVO = adopt_ani_messageSvc.getOneAdopt_Ani_message(ado_Ani_Mes_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("adopt_ani_messageVO", adopt_ani_messageVO); // 資料庫取出的adopt_ani_messageVO物件,存入req
			String url = "/Heibernate_back-end/adopt_ani_message/update_adopt_ani_message_input.jsp";
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
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			//==== getParameter設定 ====
				String ado_Ani_Mes_No = req.getParameter("ado_Ani_Mes_No").trim();
				String adopt_Ani_Id = req.getParameter("adopt_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String ado_Ani_Mes = req.getParameter("ado_Ani_Mes").trim();
				java.sql.Date ado_Ani_Mes_time = null;
				try {
					ado_Ani_Mes_time = java.sql.Date.valueOf(req.getParameter("ado_Ani_Mes_time").trim());
				} catch (IllegalArgumentException e) {
					ado_Ani_Mes_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				Adopt_Ani_messageVO adopt_ani_messageVO = new Adopt_Ani_messageVO();
				adopt_ani_messageVO.setAdo_Ani_Mes_No(ado_Ani_Mes_No);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
				adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
				adopt_ani_messageVO.setAdopt_AniVO(adopt_aniVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				adopt_ani_messageVO.setMemVO(memVO);
				adopt_ani_messageVO.setAdo_Ani_Mes(ado_Ani_Mes);
				adopt_ani_messageVO.setAdo_Ani_Mes_time(ado_Ani_Mes_time);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adopt_ani_messageVO", adopt_ani_messageVO); // 含有輸入格式錯誤的adopt_ani_messageVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adopt_ani_message/update_adopt_ani_message_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Adopt_Ani_messageService adopt_ani_messageSvc = new Adopt_Ani_messageService();
			adopt_ani_messageVO = adopt_ani_messageSvc.updateAdopt_Ani_message(
					ado_Ani_Mes_No
					,adopt_Ani_Id
					,mem_Id
					,ado_Ani_Mes
					,ado_Ani_Mes_time
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/adopt_ani_message/listAdopt_Ani_messages_ByAdopt_Ani_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adopt_ani_message/listAllAdopt_Ani_message.jsp")){
				//req.setAttribute("listAdopt_Ani_messages_ByAdopt_Ani_Id",adopt_ani_messageSvc.getAdopt_Ani_messagesByAdopt_Ani_Id(adopt_Ani_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adopt_ani_message/listAdopt_Ani_messages_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adopt_ani_message/listAllAdopt_Ani_message.jsp")){
				//req.setAttribute("listAdopt_Ani_messages_ByMem_Id",adopt_ani_messageSvc.getAdopt_Ani_messagesByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adopt_ani_message/listAdopt_Ani_messages_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Adopt_Ani_messageVO> list  = adopt_ani_messageSvc.getAll(map);
				//req.setAttribute("listAdopt_Ani_messages_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adopt_ani_message/update_adopt_ani_message_input.jsp");
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
               String adopt_Ani_Id = req.getParameter("adopt_Ani_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               String ado_Ani_Mes = req.getParameter("ado_Ani_Mes").trim();	
               java.sql.Date ado_Ani_Mes_time = null;
               try {
                   ado_Ani_Mes_time = java.sql.Date.valueOf(req.getParameter("ado_Ani_Mes_time").trim());
               } catch (IllegalArgumentException e) {
                   ado_Ani_Mes_time=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Adopt_Ani_messageVO adopt_ani_messageVO = new Adopt_Ani_messageVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
				adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
				adopt_ani_messageVO.setAdopt_AniVO(adopt_aniVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				adopt_ani_messageVO.setMemVO(memVO);
				adopt_ani_messageVO.setAdo_Ani_Mes(ado_Ani_Mes);
				adopt_ani_messageVO.setAdo_Ani_Mes_time(ado_Ani_Mes_time);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("adopt_ani_messageVO", adopt_ani_messageVO); // 含有輸入格式錯誤的adopt_ani_messageVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/adopt_ani_message/addAdopt_Ani_message.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Adopt_Ani_messageService adopt_ani_messageSvc = new Adopt_Ani_messageService();
               adopt_ani_messageVO = adopt_ani_messageSvc.addAdopt_Ani_message(
               	adopt_Ani_Id
               	,mem_Id
               	,ado_Ani_Mes
               	,ado_Ani_Mes_time
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/adopt_ani_message/listAllAdopt_Ani_message.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdopt_Ani_message.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adopt_ani_message/addAdopt_Ani_message.jsp");
			failureView.forward(req, res);
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String ado_Ani_Mes_No = new String(req.getParameter("ado_Ani_Mes_No"));
			/***************************2.開始刪除資料***************************************/
			Adopt_Ani_messageService adopt_ani_messageSvc = new Adopt_Ani_messageService();
			Adopt_Ani_messageVO adopt_ani_messageVO = adopt_ani_messageSvc.getOneAdopt_Ani_message(ado_Ani_Mes_No);
			adopt_ani_messageSvc.deleteAdopt_Ani_message(ado_Ani_Mes_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			Adopt_AniService adopt_aniSvc = new Adopt_AniService();
			if(requestURL.equals("/adopt_ani/listAdopt_Ani_messages_ByAdopt_Ani_Id.jsp") || requestURL.equals("/adopt_ani/listAllAdopt_Ani.jsp")){
			  //req.setAttribute("listAdopt_Ani_messages_ByAdopt_Ani_Id",adopt_aniSvc.getAdopt_Ani_messagesByAdopt_Ani_Id(adopt_ani_messageVO.getAdopt_Ani_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdopt_Ani_messages_ByAdopt_Ani_Id",adopt_aniSvc.getAdopt_Ani_messagesByAdopt_Ani_Id(adopt_ani_messageVO.getAdopt_AniVO().getAdopt_Ani_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listAdopt_Ani_messages_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listAdopt_Ani_messages_ByMem_Id",memSvc.getAdopt_Ani_messagesByMem_Id(adopt_ani_messageVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdopt_Ani_messages_ByMem_Id",memSvc.getAdopt_Ani_messagesByMem_Id(adopt_ani_messageVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
