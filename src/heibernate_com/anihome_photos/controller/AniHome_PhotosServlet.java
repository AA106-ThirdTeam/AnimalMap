package heibernate_com.anihome_photos.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.anihome.model.AniHomeVO;
import heibernate_com.anihome.model.AniHomeService;
import heibernate_com.anihome_photos.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/anihome_photos/anihome_photos.do" })
public class AniHome_PhotosServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllAniHome_Photos.jsp 或  /dept/listAniHome_Photoss_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_anihome_photos_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addAniHome_Photos.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllAniHome_Photos.jsp 或  /dept/listAniHome_Photoss_ByDeptno.jsp的請求
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
			AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
			List<AniHome_PhotosVO> list  = anihome_photosSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listAniHome_Photoss_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
			List<AniHome_PhotosVO> list  = anihome_photosSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listAniHome_Photoss_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/anihome_photos/listAniHome_Photoss_ByCompositeQuery.jsp"); // 成功轉交listAniHome_Photoss_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/anihome_photos/select_page.jsp");
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
			String str = req.getParameter("aniHome_Photos_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入相片編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/anihome_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String aniHome_Photos_Id = null;
			try {
				aniHome_Photos_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("相片編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/anihome_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
			AniHome_PhotosVO anihome_photosVO = anihome_photosSvc.getOneAniHome_Photos(aniHome_Photos_Id);
			if (anihome_photosVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/anihome_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("anihome_photosVO", anihome_photosVO); // 資料庫取出的anihome_photosVO物件,存入req
			String url = "/Heibernate_back-end/anihome_photos/listOneAniHome_Photos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneAniHome_Photos.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/anihome_photos/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/anihome_photos/listAllAniHome_Photos.jsp】 或  【/dept/listAniHome_Photoss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String aniHome_Photos_Id = new String(req.getParameter("aniHome_Photos_Id"));
			/***************************2.開始查詢資料****************************************/
			AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
			AniHome_PhotosVO anihome_photosVO = anihome_photosSvc.getOneAniHome_Photos(aniHome_Photos_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("anihome_photosVO", anihome_photosVO); // 資料庫取出的anihome_photosVO物件,存入req
			String url = "/Heibernate_back-end/anihome_photos/update_anihome_photos_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_anihome_photos_input.jsp
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
				String aniHome_Photos_Id = req.getParameter("aniHome_Photos_Id").trim();
				String aniHome_Id = req.getParameter("aniHome_Id").trim();
				String aniHome_Photos_pic = req.getParameter("aniHome_Photos_pic").trim();
			//==== VO設定部分 ====			
				AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
				anihome_photosVO.setAniHome_Photos_Id(aniHome_Photos_Id);
				//以下3行程式碼因為要配合Hibernate的anihome_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AniHomeVO anihomeVO = new AniHomeVO();
				anihomeVO.setAniHome_Id(aniHome_Id);
				anihome_photosVO.setAniHomeVO(anihomeVO);
				anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("anihome_photosVO", anihome_photosVO); // 含有輸入格式錯誤的anihome_photosVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/anihome_photos/update_anihome_photos_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
			anihome_photosVO = anihome_photosSvc.updateAniHome_Photos(
					aniHome_Photos_Id
					,aniHome_Id
					,aniHome_Photos_pic
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/anihome_photos/listAniHome_Photoss_ByAniHome_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/anihome_photos/listAllAniHome_Photos.jsp")){
				//req.setAttribute("listAniHome_Photoss_ByAniHome_Id",anihome_photosSvc.getAniHome_PhotossByAniHome_Id(aniHome_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/anihome_photos/listAniHome_Photoss_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<AniHome_PhotosVO> list  = anihome_photosSvc.getAll(map);
				//req.setAttribute("listAniHome_Photoss_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/anihome_photos/update_anihome_photos_input.jsp");
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
               String aniHome_Id = req.getParameter("aniHome_Id").trim();	
               String aniHome_Photos_pic = req.getParameter("aniHome_Photos_pic").trim();	
               AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
				//以下3行程式碼因為要配合Hibernate的anihome_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AniHomeVO anihomeVO = new AniHomeVO();
				anihomeVO.setAniHome_Id(aniHome_Id);
				anihome_photosVO.setAniHomeVO(anihomeVO);
				anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("anihome_photosVO", anihome_photosVO); // 含有輸入格式錯誤的anihome_photosVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/anihome_photos/addAniHome_Photos.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
               anihome_photosVO = anihome_photosSvc.addAniHome_Photos(
               	aniHome_Id
               	,aniHome_Photos_pic
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/anihome_photos/listAllAniHome_Photos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAniHome_Photos.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/anihome_photos/addAniHome_Photos.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/anihome_photos/listAllAniHome_Photos.jsp】 或  【/dept/listAniHome_Photoss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String aniHome_Photos_Id = new String(req.getParameter("aniHome_Photos_Id"));
			/***************************2.開始刪除資料***************************************/
			AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
			AniHome_PhotosVO anihome_photosVO = anihome_photosSvc.getOneAniHome_Photos(aniHome_Photos_Id);
			anihome_photosSvc.deleteAniHome_Photos(aniHome_Photos_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			AniHomeService anihomeSvc = new AniHomeService();
			if(requestURL.equals("/anihome/listAniHome_Photoss_ByAniHome_Id.jsp") || requestURL.equals("/anihome/listAllAniHome.jsp")){
			  //req.setAttribute("listAniHome_Photoss_ByAniHome_Id",anihomeSvc.getAniHome_PhotossByAniHome_Id(anihome_photosVO.getAniHome_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAniHome_Photoss_ByAniHome_Id",anihomeSvc.getAniHome_PhotossByAniHome_Id(anihome_photosVO.getAniHomeVO().getAniHome_Id())); // 資料庫取出的list物件,存入request
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
