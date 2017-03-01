package heibernate_com.shopphoto.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.petshop.model.PetShopVO;
import heibernate_com.petshop.model.PetShopService;
import heibernate_com.shopphoto.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/shopphoto/shopphoto.do" })
public class ShopPhotoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllShopPhoto.jsp 或  /dept/listShopPhotos_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_shopphoto_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addShopPhoto.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllShopPhoto.jsp 或  /dept/listShopPhotos_ByDeptno.jsp的請求
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
			ShopPhotoService shopphotoSvc = new ShopPhotoService();
			List<ShopPhotoVO> list  = shopphotoSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listShopPhotos_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			ShopPhotoService shopphotoSvc = new ShopPhotoService();
			List<ShopPhotoVO> list  = shopphotoSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listShopPhotos_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/shopphoto/listShopPhotos_ByCompositeQuery.jsp"); // 成功轉交listShopPhotos_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shopphoto/select_page.jsp");
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
			String str = req.getParameter("shopPhoto_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入相片編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shopphoto/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String shopPhoto_Id = null;
			try {
				shopPhoto_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("相片編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shopphoto/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			ShopPhotoService shopphotoSvc = new ShopPhotoService();
			ShopPhotoVO shopphotoVO = shopphotoSvc.getOneShopPhoto(shopPhoto_Id);
			if (shopphotoVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shopphoto/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("shopphotoVO", shopphotoVO); // 資料庫取出的shopphotoVO物件,存入req
			String url = "/Heibernate_back-end/shopphoto/listOneShopPhoto.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneShopPhoto.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shopphoto/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/shopphoto/listAllShopPhoto.jsp】 或  【/dept/listShopPhotos_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String shopPhoto_Id = new String(req.getParameter("shopPhoto_Id"));
			/***************************2.開始查詢資料****************************************/
			ShopPhotoService shopphotoSvc = new ShopPhotoService();
			ShopPhotoVO shopphotoVO = shopphotoSvc.getOneShopPhoto(shopPhoto_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("shopphotoVO", shopphotoVO); // 資料庫取出的shopphotoVO物件,存入req
			String url = "/Heibernate_back-end/shopphoto/update_shopphoto_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_shopphoto_input.jsp
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
				String shopPhoto_Id = req.getParameter("shopPhoto_Id").trim();
				String shopPhoto_ShopId = req.getParameter("shopPhoto_ShopId").trim();
				byte[] shopPhoto_photo = null;
				try {
					Part part = req.getPart("shopPhoto_photo");
					InputStream in = part.getInputStream();
					shopPhoto_photo = new byte[part.getInputStream().available()];
					in.read(shopPhoto_photo);
					in.close();
				} catch (Exception e) {
					shopPhoto_photo = null;
					//errorMsgs.add("相片請上傳照片.");
				}
				String isDisp_shopPhoto = req.getParameter("isDisp_shopPhoto").trim();
				String shopPhoto_name = req.getParameter("shopPhoto_name").trim();
				String shopPhoto_extent = req.getParameter("shopPhoto_extent").trim();
			//==== VO設定部分 ====			
				ShopPhotoVO shopphotoVO = new ShopPhotoVO();
				shopphotoVO.setShopPhoto_Id(shopPhoto_Id);
				//以下3行程式碼因為要配合Hibernate的shopphotoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetShopVO petshopVO = new PetShopVO();
				petshopVO.setShop_Id(shopPhoto_ShopId);
				shopphotoVO.setPetShopVO(petshopVO);
				shopphotoVO.setShopPhoto_photo(shopPhoto_photo);
				shopphotoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
				shopphotoVO.setShopPhoto_name(shopPhoto_name);
				shopphotoVO.setShopPhoto_extent(shopPhoto_extent);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shopphotoVO", shopphotoVO); // 含有輸入格式錯誤的shopphotoVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shopphoto/update_shopphoto_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			ShopPhotoService shopphotoSvc = new ShopPhotoService();
			shopphotoVO = shopphotoSvc.updateShopPhoto(
					shopPhoto_Id
					,shopPhoto_ShopId
					,shopPhoto_photo
					,isDisp_shopPhoto
					,shopPhoto_name
					,shopPhoto_extent
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/shopphoto/listShopPhotos_ByShop_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/shopphoto/listAllShopPhoto.jsp")){
				//req.setAttribute("listShopPhotos_ByShop_Id",shopphotoSvc.getShopPhotosByShop_Id(shopPhoto_ShopId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/shopphoto/listShopPhotos_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<ShopPhotoVO> list  = shopphotoSvc.getAll(map);
				//req.setAttribute("listShopPhotos_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shopphoto/update_shopphoto_input.jsp");
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
               String shopPhoto_ShopId = req.getParameter("shopPhoto_ShopId").trim();	
               byte[] shopPhoto_photo = null;
               try {
                   Part part = req.getPart("shopPhoto_photo");
                   InputStream in = part.getInputStream();
                   shopPhoto_photo = new byte[part.getInputStream().available()];
                   in.read(shopPhoto_photo);
                   in.close();
               } catch (Exception e) {
                   //errorMsgs.add("相片請上傳照片.");
                   //e.printStackTrace();
                   shopPhoto_photo = null;
               }	
               String isDisp_shopPhoto = req.getParameter("isDisp_shopPhoto").trim();	
               String shopPhoto_name = req.getParameter("shopPhoto_name").trim();	
               String shopPhoto_extent = req.getParameter("shopPhoto_extent").trim();	
               ShopPhotoVO shopphotoVO = new ShopPhotoVO();
				//以下3行程式碼因為要配合Hibernate的shopphotoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetShopVO petshopVO = new PetShopVO();
				petshopVO.setShop_Id(shopPhoto_ShopId);
				shopphotoVO.setPetShopVO(petshopVO);
				shopphotoVO.setShopPhoto_photo(shopPhoto_photo);
				shopphotoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
				shopphotoVO.setShopPhoto_name(shopPhoto_name);
				shopphotoVO.setShopPhoto_extent(shopPhoto_extent);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("shopphotoVO", shopphotoVO); // 含有輸入格式錯誤的shopphotoVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/shopphoto/addShopPhoto.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               ShopPhotoService shopphotoSvc = new ShopPhotoService();
               shopphotoVO = shopphotoSvc.addShopPhoto(
               	shopPhoto_ShopId
               	,shopPhoto_photo
               	,isDisp_shopPhoto
               	,shopPhoto_name
               	,shopPhoto_extent
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/shopphoto/listAllShopPhoto.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllShopPhoto.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shopphoto/addShopPhoto.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/shopphoto/listAllShopPhoto.jsp】 或  【/dept/listShopPhotos_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String shopPhoto_Id = new String(req.getParameter("shopPhoto_Id"));
			/***************************2.開始刪除資料***************************************/
			ShopPhotoService shopphotoSvc = new ShopPhotoService();
			ShopPhotoVO shopphotoVO = shopphotoSvc.getOneShopPhoto(shopPhoto_Id);
			shopphotoSvc.deleteShopPhoto(shopPhoto_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			PetShopService petshopSvc = new PetShopService();
			if(requestURL.equals("/petshop/listShopPhotos_ByShop_Id.jsp") || requestURL.equals("/petshop/listAllPetShop.jsp")){
			  //req.setAttribute("listShopPhotos_ByShop_Id",petshopSvc.getShopPhotosByShop_Id(shopphotoVO.getShop_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listShopPhotos_ByShop_Id",petshopSvc.getShopPhotosByShop_Id(shopphotoVO.getPetShopVO().getShop_Id())); // 資料庫取出的list物件,存入request
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
