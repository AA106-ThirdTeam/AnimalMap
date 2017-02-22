package heibernate_com.second_prodphotos.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.second_prod.model.Second_ProdVO;
import heibernate_com.second_prod.model.Second_ProdService;
import heibernate_com.second_prodphotos.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/second_prodphotos/second_prodphotos.do" })
public class Second_ProdPhotosServlet extends HttpServlet {
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
			String str = req.getParameter("second_ProdPhotos_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入二手商品相簿編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/second_prodphotos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String second_ProdPhotos_Id = null;
			try {
				second_ProdPhotos_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("二手商品相簿編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/second_prodphotos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
			Second_ProdPhotosVO second_prodphotosVO = second_prodphotosSvc.getOneSecond_ProdPhotos(second_ProdPhotos_Id);
			if (second_prodphotosVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/second_prodphotos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("second_prodphotosVO", second_prodphotosVO); // 資料庫取出的second_prodphotosVO物件,存入req
			String url = "/Heibernate_back-end/second_prodphotos/listOneSecond_ProdPhotos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/second_prodphotos/select_page.jsp");
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
			String second_ProdPhotos_Id = new String(req.getParameter("second_ProdPhotos_Id"));
			/***************************2.開始查詢資料****************************************/
			Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
			Second_ProdPhotosVO second_prodphotosVO = second_prodphotosSvc.getOneSecond_ProdPhotos(second_ProdPhotos_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("second_prodphotosVO", second_prodphotosVO); // 資料庫取出的second_prodphotosVO物件,存入req
			String url = "/Heibernate_back-end/second_prodphotos/update_second_prodphotos_input.jsp";
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
				String second_ProdPhotos_Id = req.getParameter("second_ProdPhotos_Id").trim();
				String second_Prod_Id = req.getParameter("second_Prod_Id").trim();
			//==== VO設定部分 ====			
				Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
				second_prodphotosVO.setSecond_ProdPhotos_Id(second_ProdPhotos_Id);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Second_ProdVO second_prodVO = new Second_ProdVO();
				second_prodVO.setSecond_Prod_Id(second_Prod_Id);
				second_prodphotosVO.setSecond_ProdVO(second_prodVO);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("second_prodphotosVO", second_prodphotosVO); // 含有輸入格式錯誤的second_prodphotosVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/second_prodphotos/update_second_prodphotos_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
			second_prodphotosVO = second_prodphotosSvc.updateSecond_ProdPhotos(
					second_ProdPhotos_Id
					,second_Prod_Id
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/second_prodphotos/listSecond_ProdPhotoss_BySecond_Prod_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/second_prodphotos/listAllSecond_ProdPhotos.jsp")){
				//req.setAttribute("listSecond_ProdPhotoss_BySecond_Prod_Id",second_prodphotosSvc.getSecond_ProdPhotossBySecond_Prod_Id(second_Prod_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/second_prodphotos/listSecond_ProdPhotoss_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Second_ProdPhotosVO> list  = second_prodphotosSvc.getAll(map);
				//req.setAttribute("listSecond_ProdPhotoss_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/second_prodphotos/update_second_prodphotos_input.jsp");
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
               String second_Prod_Id = req.getParameter("second_Prod_Id").trim();	
               Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Second_ProdVO second_prodVO = new Second_ProdVO();
				second_prodVO.setSecond_Prod_Id(second_Prod_Id);
				second_prodphotosVO.setSecond_ProdVO(second_prodVO);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("second_prodphotosVO", second_prodphotosVO); // 含有輸入格式錯誤的second_prodphotosVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/second_prodphotos/addSecond_ProdPhotos.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
               second_prodphotosVO = second_prodphotosSvc.addSecond_ProdPhotos(
               	second_Prod_Id
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/second_prodphotos/listAllSecond_ProdPhotos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllSecond_ProdPhotos.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/second_prodphotos/addSecond_ProdPhotos.jsp");
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
			String second_ProdPhotos_Id = new String(req.getParameter("second_ProdPhotos_Id"));
			/***************************2.開始刪除資料***************************************/
			Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
			Second_ProdPhotosVO second_prodphotosVO = second_prodphotosSvc.getOneSecond_ProdPhotos(second_ProdPhotos_Id);
			second_prodphotosSvc.deleteSecond_ProdPhotos(second_ProdPhotos_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			Second_ProdService second_prodSvc = new Second_ProdService();
			if(requestURL.equals("/second_prod/listSecond_ProdPhotoss_BySecond_Prod_Id.jsp") || requestURL.equals("/second_prod/listAllSecond_Prod.jsp")){
			  //req.setAttribute("listSecond_ProdPhotoss_BySecond_Prod_Id",second_prodSvc.getSecond_ProdPhotossBySecond_Prod_Id(second_prodphotosVO.getSecond_Prod_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listSecond_ProdPhotoss_BySecond_Prod_Id",second_prodSvc.getSecond_ProdPhotossBySecond_Prod_Id(second_prodphotosVO.getSecond_ProdVO().getSecond_Prod_Id())); // 資料庫取出的list物件,存入request
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
