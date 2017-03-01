package heibernate_com.hos_photo.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.vet_hospital.model.Vet_hospitalVO;
import heibernate_com.vet_hospital.model.Vet_hospitalService;
import heibernate_com.hos_photo.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/hos_photo/hos_photo.do" })
public class Hos_photoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllHos_photo.jsp 或  /dept/listHos_photos_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_hos_photo_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addHos_photo.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllHos_photo.jsp 或  /dept/listHos_photos_ByDeptno.jsp的請求
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
			Hos_photoService hos_photoSvc = new Hos_photoService();
			List<Hos_photoVO> list  = hos_photoSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listHos_photos_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Hos_photoService hos_photoSvc = new Hos_photoService();
			List<Hos_photoVO> list  = hos_photoSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listHos_photos_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/hos_photo/listHos_photos_ByCompositeQuery.jsp"); // 成功轉交listHos_photos_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/hos_photo/select_page.jsp");
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
			String str = req.getParameter("hosPhoto_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入相片編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/hos_photo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String hosPhoto_Id = null;
			try {
				hosPhoto_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("相片編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/hos_photo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Hos_photoService hos_photoSvc = new Hos_photoService();
			Hos_photoVO hos_photoVO = hos_photoSvc.getOneHos_photo(hosPhoto_Id);
			if (hos_photoVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/hos_photo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("hos_photoVO", hos_photoVO); // 資料庫取出的hos_photoVO物件,存入req
			String url = "/Heibernate_back-end/hos_photo/listOneHos_photo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneHos_photo.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/hos_photo/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/hos_photo/listAllHos_photo.jsp】 或  【/dept/listHos_photos_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String hosPhoto_Id = new String(req.getParameter("hosPhoto_Id"));
			/***************************2.開始查詢資料****************************************/
			Hos_photoService hos_photoSvc = new Hos_photoService();
			Hos_photoVO hos_photoVO = hos_photoSvc.getOneHos_photo(hosPhoto_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("hos_photoVO", hos_photoVO); // 資料庫取出的hos_photoVO物件,存入req
			String url = "/Heibernate_back-end/hos_photo/update_hos_photo_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_hos_photo_input.jsp
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
				String hosPhoto_Id = req.getParameter("hosPhoto_Id").trim();
				String hosPhoto_HosId = req.getParameter("hosPhoto_HosId").trim();
				byte[] hosPhoto_photo = null;
				try {
					Part part = req.getPart("hosPhoto_photo");
					InputStream in = part.getInputStream();
					hosPhoto_photo = new byte[part.getInputStream().available()];
					in.read(hosPhoto_photo);
					in.close();
				} catch (Exception e) {
					hosPhoto_photo = null;
					//errorMsgs.add("相片請上傳照片.");
				}
				String isDisp_HosPhoto = req.getParameter("isDisp_HosPhoto").trim();
				String hosPhoto_name = req.getParameter("hosPhoto_name").trim();
				String HOSPHOTO_EXTENTION = req.getParameter("HOSPHOTO_EXTENTION").trim();
			//==== VO設定部分 ====			
				Hos_photoVO hos_photoVO = new Hos_photoVO();
				hos_photoVO.setHosPhoto_Id(hosPhoto_Id);
				//以下3行程式碼因為要配合Hibernate的hos_photoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
				vet_hospitalVO.setHos_Id(hosPhoto_HosId);
				hos_photoVO.setVet_hospitalVO(vet_hospitalVO);
				hos_photoVO.setHosPhoto_photo(hosPhoto_photo);
				hos_photoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
				hos_photoVO.setHosPhoto_name(hosPhoto_name);
				hos_photoVO.setHOSPHOTO_EXTENTION(HOSPHOTO_EXTENTION);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("hos_photoVO", hos_photoVO); // 含有輸入格式錯誤的hos_photoVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/hos_photo/update_hos_photo_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Hos_photoService hos_photoSvc = new Hos_photoService();
			hos_photoVO = hos_photoSvc.updateHos_photo(
					hosPhoto_Id
					,hosPhoto_HosId
					,hosPhoto_photo
					,isDisp_HosPhoto
					,hosPhoto_name
					,HOSPHOTO_EXTENTION
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/hos_photo/listHos_photos_ByHos_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/hos_photo/listAllHos_photo.jsp")){
				//req.setAttribute("listHos_photos_ByHos_Id",hos_photoSvc.getHos_photosByHos_Id(hosPhoto_HosId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/hos_photo/listHos_photos_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Hos_photoVO> list  = hos_photoSvc.getAll(map);
				//req.setAttribute("listHos_photos_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/hos_photo/update_hos_photo_input.jsp");
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
               String hosPhoto_HosId = req.getParameter("hosPhoto_HosId").trim();	
               byte[] hosPhoto_photo = null;
               try {
                   Part part = req.getPart("hosPhoto_photo");
                   InputStream in = part.getInputStream();
                   hosPhoto_photo = new byte[part.getInputStream().available()];
                   in.read(hosPhoto_photo);
                   in.close();
               } catch (Exception e) {
                   //errorMsgs.add("相片請上傳照片.");
                   //e.printStackTrace();
                   hosPhoto_photo = null;
               }	
               String isDisp_HosPhoto = req.getParameter("isDisp_HosPhoto").trim();	
               String hosPhoto_name = req.getParameter("hosPhoto_name").trim();	
               String HOSPHOTO_EXTENTION = req.getParameter("HOSPHOTO_EXTENTION").trim();	
               Hos_photoVO hos_photoVO = new Hos_photoVO();
				//以下3行程式碼因為要配合Hibernate的hos_photoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
				vet_hospitalVO.setHos_Id(hosPhoto_HosId);
				hos_photoVO.setVet_hospitalVO(vet_hospitalVO);
				hos_photoVO.setHosPhoto_photo(hosPhoto_photo);
				hos_photoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
				hos_photoVO.setHosPhoto_name(hosPhoto_name);
				hos_photoVO.setHOSPHOTO_EXTENTION(HOSPHOTO_EXTENTION);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("hos_photoVO", hos_photoVO); // 含有輸入格式錯誤的hos_photoVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/hos_photo/addHos_photo.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Hos_photoService hos_photoSvc = new Hos_photoService();
               hos_photoVO = hos_photoSvc.addHos_photo(
               	hosPhoto_HosId
               	,hosPhoto_photo
               	,isDisp_HosPhoto
               	,hosPhoto_name
               	,HOSPHOTO_EXTENTION
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/hos_photo/listAllHos_photo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllHos_photo.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/hos_photo/addHos_photo.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/hos_photo/listAllHos_photo.jsp】 或  【/dept/listHos_photos_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String hosPhoto_Id = new String(req.getParameter("hosPhoto_Id"));
			/***************************2.開始刪除資料***************************************/
			Hos_photoService hos_photoSvc = new Hos_photoService();
			Hos_photoVO hos_photoVO = hos_photoSvc.getOneHos_photo(hosPhoto_Id);
			hos_photoSvc.deleteHos_photo(hosPhoto_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
			if(requestURL.equals("/vet_hospital/listHos_photos_ByHos_Id.jsp") || requestURL.equals("/vet_hospital/listAllVet_hospital.jsp")){
			  //req.setAttribute("listHos_photos_ByHos_Id",vet_hospitalSvc.getHos_photosByHos_Id(hos_photoVO.getHos_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listHos_photos_ByHos_Id",vet_hospitalSvc.getHos_photosByHos_Id(hos_photoVO.getVet_hospitalVO().getHos_Id())); // 資料庫取出的list物件,存入request
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
