package heibernate_com.pet.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.pet.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/pet/pet.do" })
public class PetServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllPet.jsp 或  /dept/listPets_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_pet_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addPet.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllPet.jsp 或  /dept/listPets_ByDeptno.jsp的請求
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
			PetService petSvc = new PetService();
			List<PetVO> list  = petSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPets_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			PetService petSvc = new PetService();
			List<PetVO> list  = petSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPets_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/pet/listPets_ByCompositeQuery.jsp"); // 成功轉交listPets_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet/select_page.jsp");
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
			String str = req.getParameter("pet_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入寵物編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String pet_Id = null;
			try {
				pet_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("寵物編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			PetService petSvc = new PetService();
			PetVO petVO = petSvc.getOnePet(pet_Id);
			if (petVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("petVO", petVO); // 資料庫取出的petVO物件,存入req
			String url = "/Heibernate_back-end/pet/listOnePet.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOnePet.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/pet/listAllPet.jsp】 或  【/dept/listPets_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String pet_Id = new String(req.getParameter("pet_Id"));
			/***************************2.開始查詢資料****************************************/
			PetService petSvc = new PetService();
			PetVO petVO = petSvc.getOnePet(pet_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("petVO", petVO); // 資料庫取出的petVO物件,存入req
			String url = "/Heibernate_back-end/pet/update_pet_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_pet_input.jsp
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
				String pet_Id = req.getParameter("pet_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String pet_name = req.getParameter("pet_name").trim();
				String pet_type = req.getParameter("pet_type").trim();
				String pet_gender = req.getParameter("pet_gender").trim();
				String pet_heal = req.getParameter("pet_heal").trim();
				String pet_Vac = req.getParameter("pet_Vac").trim();
				String pet_color = req.getParameter("pet_color").trim();
				String pet_body = req.getParameter("pet_body").trim();
				String pet_age = req.getParameter("pet_age").trim();
				String pet_Neu = req.getParameter("pet_Neu").trim();
				String pet_chip = req.getParameter("pet_chip").trim();
				java.sql.Timestamp pet_birth = null;
				try {
					pet_birth = java.sql.Timestamp.valueOf(req.getParameter("pet_birth").trim());
				} catch (IllegalArgumentException e) {
					pet_birth=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String pet_status = req.getParameter("pet_status").trim();
				java.sql.Timestamp pet_CreDATE = null;
				try {
					pet_CreDATE = java.sql.Timestamp.valueOf(req.getParameter("pet_CreDATE").trim());
				} catch (IllegalArgumentException e) {
					pet_CreDATE=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String pet_city = req.getParameter("pet_city").trim();
				String pet_town = req.getParameter("pet_town").trim();
				String pet_road = req.getParameter("pet_road").trim();
				Double pet_FinLat = null;
				try {
					pet_FinLat = new Double(req.getParameter("pet_FinLat").trim());
				} catch (NumberFormatException e) {
					pet_FinLat = 0.0;
					errorMsgs.add("送養地點經度請填數字.");
				}
				Double pet_FinLon = null;
				try {
					pet_FinLon = new Double(req.getParameter("pet_FinLon").trim());
				} catch (NumberFormatException e) {
					pet_FinLon = 0.0;
					errorMsgs.add("送養地點緯度請填數字.");
				}
				Integer pet_like = new Integer(req.getParameter("pet_like").trim());
			//==== VO設定部分 ====			
				PetVO petVO = new PetVO();
				petVO.setPet_Id(pet_Id);
				//以下3行程式碼因為要配合Hibernate的petVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				petVO.setMemVO(memVO);
				petVO.setPet_name(pet_name);
				petVO.setPet_type(pet_type);
				petVO.setPet_gender(pet_gender);
				petVO.setPet_heal(pet_heal);
				petVO.setPet_Vac(pet_Vac);
				petVO.setPet_color(pet_color);
				petVO.setPet_body(pet_body);
				petVO.setPet_age(pet_age);
				petVO.setPet_Neu(pet_Neu);
				petVO.setPet_chip(pet_chip);
				petVO.setPet_birth(pet_birth);
				petVO.setPet_status(pet_status);
				petVO.setPet_CreDATE(pet_CreDATE);
				petVO.setPet_city(pet_city);
				petVO.setPet_town(pet_town);
				petVO.setPet_road(pet_road);
				petVO.setPet_FinLat(pet_FinLat);
				petVO.setPet_FinLon(pet_FinLon);
				petVO.setPet_like(pet_like);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("petVO", petVO); // 含有輸入格式錯誤的petVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet/update_pet_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			PetService petSvc = new PetService();
			petVO = petSvc.updatePet(
					pet_Id
					,mem_Id
					,pet_name
					,pet_type
					,pet_gender
					,pet_heal
					,pet_Vac
					,pet_color
					,pet_body
					,pet_age
					,pet_Neu
					,pet_chip
					,pet_birth
					,pet_status
					,pet_CreDATE
					,pet_city
					,pet_town
					,pet_road
					,pet_FinLat
					,pet_FinLon
					,pet_like
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/pet/listPets_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/pet/listAllPet.jsp")){
				//req.setAttribute("listPets_ByMem_Id",petSvc.getPetsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/pet/listPets_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<PetVO> list  = petSvc.getAll(map);
				//req.setAttribute("listPets_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet/update_pet_input.jsp");
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
               String pet_name = req.getParameter("pet_name").trim();	
               String pet_type = req.getParameter("pet_type").trim();	
               String pet_gender = req.getParameter("pet_gender").trim();	
               String pet_heal = req.getParameter("pet_heal").trim();	
               String pet_Vac = req.getParameter("pet_Vac").trim();	
               String pet_color = req.getParameter("pet_color").trim();	
               String pet_body = req.getParameter("pet_body").trim();	
               String pet_age = req.getParameter("pet_age").trim();	
               String pet_Neu = req.getParameter("pet_Neu").trim();	
               String pet_chip = req.getParameter("pet_chip").trim();	
               java.sql.Timestamp pet_birth = null;
               try {
                   pet_birth = java.sql.Timestamp.valueOf(req.getParameter("pet_birth").trim());
               } catch (IllegalArgumentException e) {
                   pet_birth=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String pet_status = req.getParameter("pet_status").trim();	
               java.sql.Timestamp pet_CreDATE = null;
               try {
                   pet_CreDATE = java.sql.Timestamp.valueOf(req.getParameter("pet_CreDATE").trim());
               } catch (IllegalArgumentException e) {
                   pet_CreDATE=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String pet_city = req.getParameter("pet_city").trim();	
               String pet_town = req.getParameter("pet_town").trim();	
               String pet_road = req.getParameter("pet_road").trim();	
               Double pet_FinLat = null;
               try {
                   pet_FinLat = new Double(req.getParameter("pet_FinLat").trim());
               } catch (NumberFormatException e) {
                   pet_FinLat = 0.0;
                   errorMsgs.add("送養地點經度請填數字.");
                   e.printStackTrace();
               }
               Double pet_FinLon = null;
               try {
                   pet_FinLon = new Double(req.getParameter("pet_FinLon").trim());
               } catch (NumberFormatException e) {
                   pet_FinLon = 0.0;
                   errorMsgs.add("送養地點緯度請填數字.");
                   e.printStackTrace();
               }
               Integer pet_like = new Integer(req.getParameter("pet_like").trim());	
               PetVO petVO = new PetVO();
				//以下3行程式碼因為要配合Hibernate的petVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				petVO.setMemVO(memVO);
				petVO.setPet_name(pet_name);
				petVO.setPet_type(pet_type);
				petVO.setPet_gender(pet_gender);
				petVO.setPet_heal(pet_heal);
				petVO.setPet_Vac(pet_Vac);
				petVO.setPet_color(pet_color);
				petVO.setPet_body(pet_body);
				petVO.setPet_age(pet_age);
				petVO.setPet_Neu(pet_Neu);
				petVO.setPet_chip(pet_chip);
				petVO.setPet_birth(pet_birth);
				petVO.setPet_status(pet_status);
				petVO.setPet_CreDATE(pet_CreDATE);
				petVO.setPet_city(pet_city);
				petVO.setPet_town(pet_town);
				petVO.setPet_road(pet_road);
				petVO.setPet_FinLat(pet_FinLat);
				petVO.setPet_FinLon(pet_FinLon);
				petVO.setPet_like(pet_like);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("petVO", petVO); // 含有輸入格式錯誤的petVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/pet/addPet.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               PetService petSvc = new PetService();
               petVO = petSvc.addPet(
               	mem_Id
               	,pet_name
               	,pet_type
               	,pet_gender
               	,pet_heal
               	,pet_Vac
               	,pet_color
               	,pet_body
               	,pet_age
               	,pet_Neu
               	,pet_chip
               	,pet_birth
               	,pet_status
               	,pet_CreDATE
               	,pet_city
               	,pet_town
               	,pet_road
               	,pet_FinLat
               	,pet_FinLon
               	,pet_like
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/pet/listAllPet.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPet.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet/addPet.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/pet/listAllPet.jsp】 或  【/dept/listPets_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String pet_Id = new String(req.getParameter("pet_Id"));
			/***************************2.開始刪除資料***************************************/
			PetService petSvc = new PetService();
			PetVO petVO = petSvc.getOnePet(pet_Id);
			petSvc.deletePet(pet_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listPets_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listPets_ByMem_Id",memSvc.getPetsByMem_Id(petVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPets_ByMem_Id",memSvc.getPetsByMem_Id(petVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
