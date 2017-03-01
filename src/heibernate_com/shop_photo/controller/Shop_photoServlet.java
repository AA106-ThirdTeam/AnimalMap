package heibernate_com.shop_photo.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.petshop.model.PetShopVO;
import heibernate_com.petshop.model.PetShopService;
import heibernate_com.shop_photo.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/shop_photo/shop_photo.do" })
public class Shop_photoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllShop_photo.jsp 或  /dept/listShop_photos_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_shop_photo_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addShop_photo.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllShop_photo.jsp 或  /dept/listShop_photos_ByDeptno.jsp的請求
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
			Shop_photoService shop_photoSvc = new Shop_photoService();
			List<Shop_photoVO> list  = shop_photoSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listShop_photos_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Shop_photoService shop_photoSvc = new Shop_photoService();
			List<Shop_photoVO> list  = shop_photoSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listShop_photos_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/shop_photo/listShop_photos_ByCompositeQuery.jsp"); // 成功轉交listShop_photos_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shop_photo/select_page.jsp");
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
						.getRequestDispatcher("/Heibernate_back-end/shop_photo/select_page.jsp");
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
						.getRequestDispatcher("/Heibernate_back-end/shop_photo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Shop_photoService shop_photoSvc = new Shop_photoService();
			Shop_photoVO shop_photoVO = shop_photoSvc.getOneShop_photo(shopPhoto_Id);
			if (shop_photoVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shop_photo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("shop_photoVO", shop_photoVO); // 資料庫取出的shop_photoVO物件,存入req
			String url = "/Heibernate_back-end/shop_photo/listOneShop_photo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneShop_photo.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shop_photo/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/shop_photo/listAllShop_photo.jsp】 或  【/dept/listShop_photos_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String shopPhoto_Id = new String(req.getParameter("shopPhoto_Id"));
			/***************************2.開始查詢資料****************************************/
			Shop_photoService shop_photoSvc = new Shop_photoService();
			Shop_photoVO shop_photoVO = shop_photoSvc.getOneShop_photo(shopPhoto_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("shop_photoVO", shop_photoVO); // 資料庫取出的shop_photoVO物件,存入req
			String url = "/Heibernate_back-end/shop_photo/update_shop_photo_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_shop_photo_input.jsp
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
				String SHOPPHOTO_EXTENTION = req.getParameter("SHOPPHOTO_EXTENTION").trim();
			//==== VO設定部分 ====			
				Shop_photoVO shop_photoVO = new Shop_photoVO();
				shop_photoVO.setShopPhoto_Id(shopPhoto_Id);
				//以下3行程式碼因為要配合Hibernate的shop_photoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetShopVO petshopVO = new PetShopVO();
				petshopVO.setShop_Id(shopPhoto_ShopId);
				shop_photoVO.setPetShopVO(petshopVO);
				shop_photoVO.setShopPhoto_photo(shopPhoto_photo);
				shop_photoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
				shop_photoVO.setShopPhoto_name(shopPhoto_name);
				shop_photoVO.setSHOPPHOTO_EXTENTION(SHOPPHOTO_EXTENTION);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shop_photoVO", shop_photoVO); // 含有輸入格式錯誤的shop_photoVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shop_photo/update_shop_photo_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Shop_photoService shop_photoSvc = new Shop_photoService();
			shop_photoVO = shop_photoSvc.updateShop_photo(
					shopPhoto_Id
					,shopPhoto_ShopId
					,shopPhoto_photo
					,isDisp_shopPhoto
					,shopPhoto_name
					,SHOPPHOTO_EXTENTION
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/shop_photo/listShop_photos_ByShop_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/shop_photo/listAllShop_photo.jsp")){
				//req.setAttribute("listShop_photos_ByShop_Id",shop_photoSvc.getShop_photosByShop_Id(shopPhoto_ShopId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/shop_photo/listShop_photos_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Shop_photoVO> list  = shop_photoSvc.getAll(map);
				//req.setAttribute("listShop_photos_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shop_photo/update_shop_photo_input.jsp");
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
               String SHOPPHOTO_EXTENTION = req.getParameter("SHOPPHOTO_EXTENTION").trim();	
               Shop_photoVO shop_photoVO = new Shop_photoVO();
				//以下3行程式碼因為要配合Hibernate的shop_photoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetShopVO petshopVO = new PetShopVO();
				petshopVO.setShop_Id(shopPhoto_ShopId);
				shop_photoVO.setPetShopVO(petshopVO);
				shop_photoVO.setShopPhoto_photo(shopPhoto_photo);
				shop_photoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
				shop_photoVO.setShopPhoto_name(shopPhoto_name);
				shop_photoVO.setSHOPPHOTO_EXTENTION(SHOPPHOTO_EXTENTION);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("shop_photoVO", shop_photoVO); // 含有輸入格式錯誤的shop_photoVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/shop_photo/addShop_photo.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Shop_photoService shop_photoSvc = new Shop_photoService();
               shop_photoVO = shop_photoSvc.addShop_photo(
               	shopPhoto_ShopId
               	,shopPhoto_photo
               	,isDisp_shopPhoto
               	,shopPhoto_name
               	,SHOPPHOTO_EXTENTION
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/shop_photo/listAllShop_photo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllShop_photo.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shop_photo/addShop_photo.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/shop_photo/listAllShop_photo.jsp】 或  【/dept/listShop_photos_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String shopPhoto_Id = new String(req.getParameter("shopPhoto_Id"));
			/***************************2.開始刪除資料***************************************/
			Shop_photoService shop_photoSvc = new Shop_photoService();
			Shop_photoVO shop_photoVO = shop_photoSvc.getOneShop_photo(shopPhoto_Id);
			shop_photoSvc.deleteShop_photo(shopPhoto_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			PetShopService petshopSvc = new PetShopService();
			if(requestURL.equals("/petshop/listShop_photos_ByShop_Id.jsp") || requestURL.equals("/petshop/listAllPetShop.jsp")){
			  //req.setAttribute("listShop_photos_ByShop_Id",petshopSvc.getShop_photosByShop_Id(shop_photoVO.getShop_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listShop_photos_ByShop_Id",petshopSvc.getShop_photosByShop_Id(shop_photoVO.getPetShopVO().getShop_Id())); // 資料庫取出的list物件,存入request
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
