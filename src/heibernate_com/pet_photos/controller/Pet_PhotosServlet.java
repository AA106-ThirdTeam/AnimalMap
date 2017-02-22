package heibernate_com.pet_photos.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.pet.model.PetVO;
import heibernate_com.pet.model.PetService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.pet_photos.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/pet_photos/pet_photos.do" })
public class Pet_PhotosServlet extends HttpServlet {
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
			String str = req.getParameter("pet_Pic_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入寵物相片編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String pet_Pic_No = null;
			try {
				pet_Pic_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("寵物相片編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
			Pet_PhotosVO pet_photosVO = pet_photosSvc.getOnePet_Photos(pet_Pic_No);
			if (pet_photosVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("pet_photosVO", pet_photosVO); // 資料庫取出的pet_photosVO物件,存入req
			String url = "/Heibernate_back-end/pet_photos/listOnePet_Photos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet_photos/select_page.jsp");
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
			String pet_Pic_No = new String(req.getParameter("pet_Pic_No"));
			/***************************2.開始查詢資料****************************************/
			Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
			Pet_PhotosVO pet_photosVO = pet_photosSvc.getOnePet_Photos(pet_Pic_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("pet_photosVO", pet_photosVO); // 資料庫取出的pet_photosVO物件,存入req
			String url = "/Heibernate_back-end/pet_photos/update_pet_photos_input.jsp";
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
				String pet_Pic_No = req.getParameter("pet_Pic_No").trim();
				String pet_Id = req.getParameter("pet_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				byte[] pet_Pic = null;
				try {
					Part part = req.getPart("pet_Pic");
					InputStream in = part.getInputStream();
					pet_Pic = new byte[part.getInputStream().available()];
					in.read(pet_Pic);
					in.close();
				} catch (Exception e) {
					pet_Pic = null;
					//errorMsgs.add("寵物相片請上傳照片.");
				}
				String pet_Pic_name = req.getParameter("pet_Pic_name").trim();
				String pet_Pic_nameEX = req.getParameter("pet_Pic_nameEX").trim();
				java.sql.Date pet_Pic_time = null;
				try {
					pet_Pic_time = java.sql.Date.valueOf(req.getParameter("pet_Pic_time").trim());
				} catch (IllegalArgumentException e) {
					pet_Pic_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String pet_Pic_type = req.getParameter("pet_Pic_type").trim();
			//==== VO設定部分 ====			
				Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();
				pet_photosVO.setPet_Pic_No(pet_Pic_No);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetVO petVO = new PetVO();
				petVO.setPet_Id(pet_Id);
				pet_photosVO.setPetVO(petVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				pet_photosVO.setMemVO(memVO);
				pet_photosVO.setPet_Pic(pet_Pic);
				pet_photosVO.setPet_Pic_name(pet_Pic_name);
				pet_photosVO.setPet_Pic_nameEX(pet_Pic_nameEX);
				pet_photosVO.setPet_Pic_time(pet_Pic_time);
				pet_photosVO.setPet_Pic_type(pet_Pic_type);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("pet_photosVO", pet_photosVO); // 含有輸入格式錯誤的pet_photosVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/pet_photos/update_pet_photos_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
			pet_photosVO = pet_photosSvc.updatePet_Photos(
					pet_Pic_No
					,pet_Id
					,mem_Id
					,pet_Pic
					,pet_Pic_name
					,pet_Pic_nameEX
					,pet_Pic_time
					,pet_Pic_type
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/pet_photos/listPet_Photoss_ByPet_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/pet_photos/listAllPet_Photos.jsp")){
				//req.setAttribute("listPet_Photoss_ByPet_Id",pet_photosSvc.getPet_PhotossByPet_Id(pet_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/pet_photos/listPet_Photoss_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/pet_photos/listAllPet_Photos.jsp")){
				//req.setAttribute("listPet_Photoss_ByMem_Id",pet_photosSvc.getPet_PhotossByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/pet_photos/listPet_Photoss_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Pet_PhotosVO> list  = pet_photosSvc.getAll(map);
				//req.setAttribute("listPet_Photoss_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet_photos/update_pet_photos_input.jsp");
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
               String pet_Id = req.getParameter("pet_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               byte[] pet_Pic = null;
               try {
                   Part part = req.getPart("pet_Pic");
                   InputStream in = part.getInputStream();
                   pet_Pic = new byte[part.getInputStream().available()];
                   in.read(pet_Pic);
                   in.close();
               } catch (Exception e) {
                   //errorMsgs.add("寵物相片請上傳照片.");
                   //e.printStackTrace();
                   pet_Pic = null;
               }	
               String pet_Pic_name = req.getParameter("pet_Pic_name").trim();	
               String pet_Pic_nameEX = req.getParameter("pet_Pic_nameEX").trim();	
               java.sql.Date pet_Pic_time = null;
               try {
                   pet_Pic_time = java.sql.Date.valueOf(req.getParameter("pet_Pic_time").trim());
               } catch (IllegalArgumentException e) {
                   pet_Pic_time=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String pet_Pic_type = req.getParameter("pet_Pic_type").trim();	
               Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetVO petVO = new PetVO();
				petVO.setPet_Id(pet_Id);
				pet_photosVO.setPetVO(petVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				pet_photosVO.setMemVO(memVO);
				pet_photosVO.setPet_Pic(pet_Pic);
				pet_photosVO.setPet_Pic_name(pet_Pic_name);
				pet_photosVO.setPet_Pic_nameEX(pet_Pic_nameEX);
				pet_photosVO.setPet_Pic_time(pet_Pic_time);
				pet_photosVO.setPet_Pic_type(pet_Pic_type);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("pet_photosVO", pet_photosVO); // 含有輸入格式錯誤的pet_photosVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/pet_photos/addPet_Photos.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
               pet_photosVO = pet_photosSvc.addPet_Photos(
               	pet_Id
               	,mem_Id
               	,pet_Pic
               	,pet_Pic_name
               	,pet_Pic_nameEX
               	,pet_Pic_time
               	,pet_Pic_type
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/pet_photos/listAllPet_Photos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPet_Photos.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/pet_photos/addPet_Photos.jsp");
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
			String pet_Pic_No = new String(req.getParameter("pet_Pic_No"));
			/***************************2.開始刪除資料***************************************/
			Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
			Pet_PhotosVO pet_photosVO = pet_photosSvc.getOnePet_Photos(pet_Pic_No);
			pet_photosSvc.deletePet_Photos(pet_Pic_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			PetService petSvc = new PetService();
			if(requestURL.equals("/pet/listPet_Photoss_ByPet_Id.jsp") || requestURL.equals("/pet/listAllPet.jsp")){
			  //req.setAttribute("listPet_Photoss_ByPet_Id",petSvc.getPet_PhotossByPet_Id(pet_photosVO.getPet_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPet_Photoss_ByPet_Id",petSvc.getPet_PhotossByPet_Id(pet_photosVO.getPetVO().getPet_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listPet_Photoss_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listPet_Photoss_ByMem_Id",memSvc.getPet_PhotossByMem_Id(pet_photosVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPet_Photoss_ByMem_Id",memSvc.getPet_PhotossByMem_Id(pet_photosVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
