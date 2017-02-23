package heibernate_com.animal_index.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.animal_index.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/animal_index/animal_index.do" })
public class Animal_indexServlet extends HttpServlet {
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
			String str = req.getParameter("animal_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入圖鑑編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/animal_index/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String animal_No = null;
			try {
				animal_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("圖鑑編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/animal_index/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Animal_indexService animal_indexSvc = new Animal_indexService();
			Animal_indexVO animal_indexVO = animal_indexSvc.getOneAnimal_index(animal_No);
			if (animal_indexVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/animal_index/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("animal_indexVO", animal_indexVO); // 資料庫取出的animal_indexVO物件,存入req
			String url = "/Heibernate_back-end/animal_index/listOneAnimal_index.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/animal_index/select_page.jsp");
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
			String animal_No = new String(req.getParameter("animal_No"));
			/***************************2.開始查詢資料****************************************/
			Animal_indexService animal_indexSvc = new Animal_indexService();
			Animal_indexVO animal_indexVO = animal_indexSvc.getOneAnimal_index(animal_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("animal_indexVO", animal_indexVO); // 資料庫取出的animal_indexVO物件,存入req
			String url = "/Heibernate_back-end/animal_index/update_animal_index_input.jsp";
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
				String animal_No = req.getParameter("animal_No").trim();
				String animal_detail = req.getParameter("animal_detail").trim();
				String animal_class = req.getParameter("animal_class").trim();
				String animal_class_No = req.getParameter("animal_class_No").trim();
			//==== VO設定部分 ====			
				Animal_indexVO animal_indexVO = new Animal_indexVO();
				animal_indexVO.setAnimal_No(animal_No);
				animal_indexVO.setAnimal_detail(animal_detail);
				animal_indexVO.setAnimal_class(animal_class);
				animal_indexVO.setAnimal_class_No(animal_class_No);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("animal_indexVO", animal_indexVO); // 含有輸入格式錯誤的animal_indexVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/animal_index/update_animal_index_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Animal_indexService animal_indexSvc = new Animal_indexService();
			animal_indexVO = animal_indexSvc.updateAnimal_index(
					animal_No
					,animal_detail
					,animal_class
					,animal_class_No
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/animal_index/listAnimal_indexs_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Animal_indexVO> list  = animal_indexSvc.getAll(map);
				//req.setAttribute("listAnimal_indexs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/animal_index/update_animal_index_input.jsp");
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
               String animal_detail = req.getParameter("animal_detail").trim();	
               String animal_class = req.getParameter("animal_class").trim();	
               String animal_class_No = req.getParameter("animal_class_No").trim();	
               Animal_indexVO animal_indexVO = new Animal_indexVO();
				animal_indexVO.setAnimal_detail(animal_detail);
				animal_indexVO.setAnimal_class(animal_class);
				animal_indexVO.setAnimal_class_No(animal_class_No);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("animal_indexVO", animal_indexVO); // 含有輸入格式錯誤的animal_indexVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/animal_index/addAnimal_index.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Animal_indexService animal_indexSvc = new Animal_indexService();
               animal_indexVO = animal_indexSvc.addAnimal_index(
               	animal_detail
               	,animal_class
               	,animal_class_No
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/animal_index/listAllAnimal_index.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAnimal_index.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/animal_index/addAnimal_index.jsp");
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
			String animal_No = new String(req.getParameter("animal_No"));
			/***************************2.開始刪除資料***************************************/
			Animal_indexService animal_indexSvc = new Animal_indexService();
			Animal_indexVO animal_indexVO = animal_indexSvc.getOneAnimal_index(animal_No);
			animal_indexSvc.deleteAnimal_index(animal_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
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
