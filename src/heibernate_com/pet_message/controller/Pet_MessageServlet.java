package heibernate_com.pet_message.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.pet.model.PetVO;
import heibernate_com.pet.model.PetService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.pet_message.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/pet_message/pet_message.do" })
public class Pet_MessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllPet_Message.jsp 或  /dept/listPet_Messages_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_pet_message_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addPet_Message.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllPet_Message.jsp 或  /dept/listPet_Messages_ByDeptno.jsp的請求
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
			Pet_MessageService pet_messageSvc = new Pet_MessageService();
			List<Pet_MessageVO> list  = pet_messageSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPet_Messages_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Pet_MessageService pet_messageSvc = new Pet_MessageService();
			List<Pet_MessageVO> list  = pet_messageSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPet_Messages_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/pet_message/listPet_Messages_ByCompositeQuery.jsp"); // 成功轉交listPet_Messages_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet_message/select_page.jsp");
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
			String str = req.getParameter("pet_Mes_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入寵物留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String pet_Mes_No = null;
			try {
				pet_Mes_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("寵物留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Pet_MessageService pet_messageSvc = new Pet_MessageService();
			Pet_MessageVO pet_messageVO = pet_messageSvc.getOnePet_Message(pet_Mes_No);
			if (pet_messageVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet_message/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("pet_messageVO", pet_messageVO); // 資料庫取出的pet_messageVO物件,存入req
			String url = "/Heibernate_back-end/pet_message/listOnePet_Message.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOnePet_Message.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet_message/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/pet_message/listAllPet_Message.jsp】 或  【/dept/listPet_Messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String pet_Mes_No = new String(req.getParameter("pet_Mes_No"));
			/***************************2.開始查詢資料****************************************/
			Pet_MessageService pet_messageSvc = new Pet_MessageService();
			Pet_MessageVO pet_messageVO = pet_messageSvc.getOnePet_Message(pet_Mes_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("pet_messageVO", pet_messageVO); // 資料庫取出的pet_messageVO物件,存入req
			String url = "/Heibernate_back-end/pet_message/update_pet_message_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_pet_message_input.jsp
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
				String pet_Mes_No = req.getParameter("pet_Mes_No").trim();
				String pet_Id = req.getParameter("pet_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String pet_Mes = req.getParameter("pet_Mes").trim();
				java.sql.Timestamp pet_Mes_time = null;
				try {
					pet_Mes_time = java.sql.Timestamp.valueOf(req.getParameter("pet_Mes_time").trim());
				} catch (IllegalArgumentException e) {
					pet_Mes_time=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				Pet_MessageVO pet_messageVO = new Pet_MessageVO();
				pet_messageVO.setPet_Mes_No(pet_Mes_No);
				//以下3行程式碼因為要配合Hibernate的pet_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetVO petVO = new PetVO();
				petVO.setPet_Id(pet_Id);
				pet_messageVO.setPetVO(petVO);
				//以下3行程式碼因為要配合Hibernate的pet_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				pet_messageVO.setMemVO(memVO);
				pet_messageVO.setPet_Mes(pet_Mes);
				pet_messageVO.setPet_Mes_time(pet_Mes_time);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("pet_messageVO", pet_messageVO); // 含有輸入格式錯誤的pet_messageVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet_message/update_pet_message_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Pet_MessageService pet_messageSvc = new Pet_MessageService();
			pet_messageVO = pet_messageSvc.updatePet_Message(
					pet_Mes_No
					,pet_Id
					,mem_Id
					,pet_Mes
					,pet_Mes_time
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/pet_message/listPet_Messages_ByPet_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/pet_message/listAllPet_Message.jsp")){
				//req.setAttribute("listPet_Messages_ByPet_Id",pet_messageSvc.getPet_MessagesByPet_Id(pet_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/pet_message/listPet_Messages_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/pet_message/listAllPet_Message.jsp")){
				//req.setAttribute("listPet_Messages_ByMem_Id",pet_messageSvc.getPet_MessagesByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/pet_message/listPet_Messages_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Pet_MessageVO> list  = pet_messageSvc.getAll(map);
				//req.setAttribute("listPet_Messages_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet_message/update_pet_message_input.jsp");
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
               String pet_Id = req.getParameter("pet_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               String pet_Mes = req.getParameter("pet_Mes").trim();	
               java.sql.Timestamp pet_Mes_time = null;
               try {
                   pet_Mes_time = java.sql.Timestamp.valueOf(req.getParameter("pet_Mes_time").trim());
               } catch (IllegalArgumentException e) {
                   pet_Mes_time=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Pet_MessageVO pet_messageVO = new Pet_MessageVO();
				//以下3行程式碼因為要配合Hibernate的pet_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetVO petVO = new PetVO();
				petVO.setPet_Id(pet_Id);
				pet_messageVO.setPetVO(petVO);
				//以下3行程式碼因為要配合Hibernate的pet_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				pet_messageVO.setMemVO(memVO);
				pet_messageVO.setPet_Mes(pet_Mes);
				pet_messageVO.setPet_Mes_time(pet_Mes_time);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("pet_messageVO", pet_messageVO); // 含有輸入格式錯誤的pet_messageVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/pet_message/addPet_Message.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Pet_MessageService pet_messageSvc = new Pet_MessageService();
               pet_messageVO = pet_messageSvc.addPet_Message(
               	pet_Id
               	,mem_Id
               	,pet_Mes
               	,pet_Mes_time
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/pet_message/listAllPet_Message.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPet_Message.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet_message/addPet_Message.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/pet_message/listAllPet_Message.jsp】 或  【/dept/listPet_Messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String pet_Mes_No = new String(req.getParameter("pet_Mes_No"));
			/***************************2.開始刪除資料***************************************/
			Pet_MessageService pet_messageSvc = new Pet_MessageService();
			Pet_MessageVO pet_messageVO = pet_messageSvc.getOnePet_Message(pet_Mes_No);
			pet_messageSvc.deletePet_Message(pet_Mes_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			PetService petSvc = new PetService();
			if(requestURL.equals("/pet/listPet_Messages_ByPet_Id.jsp") || requestURL.equals("/pet/listAllPet.jsp")){
			  //req.setAttribute("listPet_Messages_ByPet_Id",petSvc.getPet_MessagesByPet_Id(pet_messageVO.getPet_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPet_Messages_ByPet_Id",petSvc.getPet_MessagesByPet_Id(pet_messageVO.getPetVO().getPet_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listPet_Messages_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listPet_Messages_ByMem_Id",memSvc.getPet_MessagesByMem_Id(pet_messageVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPet_Messages_ByMem_Id",memSvc.getPet_MessagesByMem_Id(pet_messageVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
