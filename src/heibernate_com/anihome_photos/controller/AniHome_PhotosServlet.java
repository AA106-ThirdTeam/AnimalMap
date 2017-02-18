package heibernate_com.anihome_photos.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.anihome.model.AniHomeVO;
import heibernate_com.anihome.model.AniHomeService;
import heibernate_com.anihome_photos.model.*;

@WebServlet(urlPatterns = { "/back-end/anihome_photos/anihome_photos.do" })
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
			String str = req.getParameter("aniHome_Photos_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入相片編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/anihome_photos/select_page.jsp");
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
						.getRequestDispatcher("/back-end/anihome_photos/select_page.jsp");
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
						.getRequestDispatcher("/back-end/anihome_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("anihome_photosVO", anihome_photosVO); // 資料庫取出的anihome_photosVO物件,存入req
			String url = "/back-end/anihome_photos/listOneAniHome_Photos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/back-end/anihome_photos/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	private void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String aniHome_Photos_Id = new String(req.getParameter("aniHome_Photos_Id"));
			/***************************2.開始查詢資料****************************************/
			AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
			AniHome_PhotosVO anihome_photosVO = anihome_photosSvc.getOneAniHome_Photos(aniHome_Photos_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("anihome_photosVO", anihome_photosVO); // 資料庫取出的anihome_photosVO物件,存入req
			String url = "/back-end/anihome_photos/update_anihome_photos_input.jsp";
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
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			//==== getParameter設定 ====
				String aniHome_Photos_Id = req.getParameter("aniHome_Photos_Id").trim();
				String aniHome_Id = req.getParameter("aniHome_Id").trim();
				byte[] aniHome_Photos_pic = null;
				try {
					Part part = req.getPart("aniHome_Photos_pic");
					InputStream in = part.getInputStream();
					aniHome_Photos_pic = new byte[part.getInputStream().available()];
					in.read(aniHome_Photos_pic);
					in.close();
				} catch (Exception e) {
					aniHome_Photos_pic = null;
					//errorMsgs.add("動物之家照片請上傳照片.");
				}
			//==== VO設定部分 ====			
				AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
				anihome_photosVO.setAniHome_Photos_Id(aniHome_Photos_Id);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AniHomeVO anihomeVO = new AniHomeVO();
				anihomeVO.setAniHome_Id(aniHome_Id);
				anihome_photosVO.setAniHomeVO(anihomeVO);
				anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("anihome_photosVO", anihome_photosVO); // 含有輸入格式錯誤的anihome_photosVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/anihome_photos/update_anihome_photos_input.jsp");
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
			//if(requestURL.equals("/back-end/anihome_photos/listAniHome_Photoss_ByAniHome_Id.jsp") 
				//|| requestURL.equals("/back-end/anihome_photos/listAllAniHome_Photos.jsp")){
				//req.setAttribute("listAniHome_Photoss_ByAniHome_Id",anihome_photosSvc.getAniHome_PhotossByAniHome_Id(aniHome_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/back-end/anihome_photos/listAniHome_Photoss_ByCompositeQuery.jsp")){
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
					.getRequestDispatcher("/back-end/anihome_photos/update_anihome_photos_input.jsp");
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
               String aniHome_Id = req.getParameter("aniHome_Id").trim();	
               byte[] aniHome_Photos_pic = null;
               try {
                   Part part = req.getPart("aniHome_Photos_pic");
                   InputStream in = part.getInputStream();
                   aniHome_Photos_pic = new byte[part.getInputStream().available()];
                   in.read(aniHome_Photos_pic);
                   in.close();
               } catch (Exception e) {
                   //errorMsgs.add("動物之家照片請上傳照片.");
                   //e.printStackTrace();
                   aniHome_Photos_pic = null;
               }	
               AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AniHomeVO anihomeVO = new AniHomeVO();
				anihomeVO.setAniHome_Id(aniHome_Id);
				anihome_photosVO.setAniHomeVO(anihomeVO);
				anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("anihome_photosVO", anihome_photosVO); // 含有輸入格式錯誤的anihome_photosVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/back-end/anihome_photos/addAniHome_Photos.jsp");
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
			String url = "/back-end/anihome_photos/listAllAniHome_Photos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAniHome_Photos.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/back-end/anihome_photos/addAniHome_Photos.jsp");
			failureView.forward(req, res);
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
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
