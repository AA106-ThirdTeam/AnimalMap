package heibernate_com.adpphotos.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.adp.model.AdpVO;
import heibernate_com.adp.model.AdpService;
import heibernate_com.adpphotos.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/adpphotos/adpphotos.do" })
public class AdpPhotosServlet extends HttpServlet {
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
			String str = req.getParameter("adpPhotos_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入領養活動相簿編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adpphotos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String adpPhotos_Id = null;
			try {
				adpPhotos_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("領養活動相簿編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adpphotos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			AdpPhotosService adpphotosSvc = new AdpPhotosService();
			AdpPhotosVO adpphotosVO = adpphotosSvc.getOneAdpPhotos(adpPhotos_Id);
			if (adpphotosVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adpphotos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("adpphotosVO", adpphotosVO); // 資料庫取出的adpphotosVO物件,存入req
			String url = "/Heibernate_back-end/adpphotos/listOneAdpPhotos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adpphotos/select_page.jsp");
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
			String adpPhotos_Id = new String(req.getParameter("adpPhotos_Id"));
			/***************************2.開始查詢資料****************************************/
			AdpPhotosService adpphotosSvc = new AdpPhotosService();
			AdpPhotosVO adpphotosVO = adpphotosSvc.getOneAdpPhotos(adpPhotos_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("adpphotosVO", adpphotosVO); // 資料庫取出的adpphotosVO物件,存入req
			String url = "/Heibernate_back-end/adpphotos/update_adpphotos_input.jsp";
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
				String adpPhotos_Id = req.getParameter("adpPhotos_Id").trim();
				String adp_Id = req.getParameter("adp_Id").trim();
				byte[] adpPhotosPic = null;
				try {
					Part part = req.getPart("adpPhotosPic");
					InputStream in = part.getInputStream();
					adpPhotosPic = new byte[part.getInputStream().available()];
					in.read(adpPhotosPic);
					in.close();
				} catch (Exception e) {
					adpPhotosPic = null;
					//errorMsgs.add("領養活動照片請上傳照片.");
				}
			//==== VO設定部分 ====			
				AdpPhotosVO adpphotosVO = new AdpPhotosVO();
				adpphotosVO.setAdpPhotos_Id(adpPhotos_Id);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AdpVO adpVO = new AdpVO();
				adpVO.setAdp_Id(adp_Id);
				adpphotosVO.setAdpVO(adpVO);
				adpphotosVO.setAdpPhotosPic(adpPhotosPic);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adpphotosVO", adpphotosVO); // 含有輸入格式錯誤的adpphotosVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adpphotos/update_adpphotos_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			AdpPhotosService adpphotosSvc = new AdpPhotosService();
			adpphotosVO = adpphotosSvc.updateAdpPhotos(
					adpPhotos_Id
					,adp_Id
					,adpPhotosPic
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/adpphotos/listAdpPhotoss_ByAdp_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adpphotos/listAllAdpPhotos.jsp")){
				//req.setAttribute("listAdpPhotoss_ByAdp_Id",adpphotosSvc.getAdpPhotossByAdp_Id(adp_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adpphotos/listAdpPhotoss_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<AdpPhotosVO> list  = adpphotosSvc.getAll(map);
				//req.setAttribute("listAdpPhotoss_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adpphotos/update_adpphotos_input.jsp");
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
               String adp_Id = req.getParameter("adp_Id").trim();	
               byte[] adpPhotosPic = null;
               try {
                   Part part = req.getPart("adpPhotosPic");
                   InputStream in = part.getInputStream();
                   adpPhotosPic = new byte[part.getInputStream().available()];
                   in.read(adpPhotosPic);
                   in.close();
               } catch (Exception e) {
                   //errorMsgs.add("領養活動照片請上傳照片.");
                   //e.printStackTrace();
                   adpPhotosPic = null;
               }	
               AdpPhotosVO adpphotosVO = new AdpPhotosVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				AdpVO adpVO = new AdpVO();
				adpVO.setAdp_Id(adp_Id);
				adpphotosVO.setAdpVO(adpVO);
				adpphotosVO.setAdpPhotosPic(adpPhotosPic);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("adpphotosVO", adpphotosVO); // 含有輸入格式錯誤的adpphotosVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/adpphotos/addAdpPhotos.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               AdpPhotosService adpphotosSvc = new AdpPhotosService();
               adpphotosVO = adpphotosSvc.addAdpPhotos(
               	adp_Id
               	,adpPhotosPic
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/adpphotos/listAllAdpPhotos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdpPhotos.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adpphotos/addAdpPhotos.jsp");
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
			String adpPhotos_Id = new String(req.getParameter("adpPhotos_Id"));
			/***************************2.開始刪除資料***************************************/
			AdpPhotosService adpphotosSvc = new AdpPhotosService();
			AdpPhotosVO adpphotosVO = adpphotosSvc.getOneAdpPhotos(adpPhotos_Id);
			adpphotosSvc.deleteAdpPhotos(adpPhotos_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			AdpService adpSvc = new AdpService();
			if(requestURL.equals("/adp/listAdpPhotoss_ByAdp_Id.jsp") || requestURL.equals("/adp/listAllAdp.jsp")){
			  //req.setAttribute("listAdpPhotoss_ByAdp_Id",adpSvc.getAdpPhotossByAdp_Id(adpphotosVO.getAdp_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdpPhotoss_ByAdp_Id",adpSvc.getAdpPhotossByAdp_Id(adpphotosVO.getAdpVO().getAdp_Id())); // 資料庫取出的list物件,存入request
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
