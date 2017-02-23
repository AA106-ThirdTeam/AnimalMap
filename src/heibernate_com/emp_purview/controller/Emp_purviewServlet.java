package heibernate_com.emp_purview.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.emp.model.EmpVO;
import heibernate_com.emp.model.EmpService;
import heibernate_com.purview.model.PurviewVO;
import heibernate_com.purview.model.PurviewService;
import heibernate_com.emp_purview.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/emp_purview/emp_purview.do" })
public class Emp_purviewServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp_purview.jsp 或  /dept/listEmp_purviews_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_emp_purview_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addEmp_purview.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllEmp_purview.jsp 或  /dept/listEmp_purviews_ByDeptno.jsp的請求
			delete(req, res);
		}
		if ("list_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
			list_ByCompositeQuery(req, res);
		}		
	}
	private void list_ByCompositeQuery(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
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
			Emp_purviewService emp_purviewSvc = new Emp_purviewService();
			List<Emp_purviewVO> list  = emp_purviewSvc.getAll(map);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listEmp_purviews_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/emp_purview/listEmp_purviews_ByCompositeQuery.jsp"); // 成功轉交listEmp_purviews_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emp_purview/select_page.jsp");
			failureView.forward(req, res);
		}
	}
	private void getOne_For_Display(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("emp_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入員工編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emp_purview/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String emp_No = null;
			try {
				emp_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emp_purview/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Emp_purviewService emp_purviewSvc = new Emp_purviewService();
			Emp_purviewVO emp_purviewVO = emp_purviewSvc.getOneEmp_purview(emp_No);
			if (emp_purviewVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emp_purview/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("emp_purviewVO", emp_purviewVO); // 資料庫取出的emp_purviewVO物件,存入req
			String url = "/Heibernate_back-end/emp_purview/listOneEmp_purview.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp_purview.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emp_purview/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	private void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/emp_purview/listAllEmp_purview.jsp】 或  【/dept/listEmp_purviews_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String emp_No = new String(req.getParameter("emp_No"));
			/***************************2.開始查詢資料****************************************/
			Emp_purviewService emp_purviewSvc = new Emp_purviewService();
			Emp_purviewVO emp_purviewVO = emp_purviewSvc.getOneEmp_purview(emp_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("emp_purviewVO", emp_purviewVO); // 資料庫取出的emp_purviewVO物件,存入req
			String url = "/Heibernate_back-end/emp_purview/update_emp_purview_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emp_purview_input.jsp
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
				String emp_No = req.getParameter("emp_No").trim();
				String purview_No = req.getParameter("purview_No").trim();
			//==== VO設定部分 ====			
				Emp_purviewVO emp_purviewVO = new Emp_purviewVO();
				//以下3行程式碼因為要配合Hibernate的emp_purviewVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				EmpVO empVO = new EmpVO();
				empVO.setEmp_No(emp_No);
				emp_purviewVO.setEmpVO(empVO);
				//以下3行程式碼因為要配合Hibernate的emp_purviewVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PurviewVO purviewVO = new PurviewVO();
				purviewVO.setPurview_No(purview_No);
				emp_purviewVO.setPurviewVO(purviewVO);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("emp_purviewVO", emp_purviewVO); // 含有輸入格式錯誤的emp_purviewVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emp_purview/update_emp_purview_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Emp_purviewService emp_purviewSvc = new Emp_purviewService();
			emp_purviewVO = emp_purviewSvc.updateEmp_purview(
					emp_No
					,purview_No
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/emp_purview/listEmp_purviews_ByEmp_No.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/emp_purview/listAllEmp_purview.jsp")){
				//req.setAttribute("listEmp_purviews_ByEmp_No",emp_purviewSvc.getEmp_purviewsByEmp_No(emp_No)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/emp_purview/listEmp_purviews_ByPurview_No.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/emp_purview/listAllEmp_purview.jsp")){
				//req.setAttribute("listEmp_purviews_ByPurview_No",emp_purviewSvc.getEmp_purviewsByPurview_No(purview_No)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/emp_purview/listEmp_purviews_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Emp_purviewVO> list  = emp_purviewSvc.getAll(map);
				//req.setAttribute("listEmp_purviews_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emp_purview/update_emp_purview_input.jsp");
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
               Emp_purviewVO emp_purviewVO = new Emp_purviewVO();
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("emp_purviewVO", emp_purviewVO); // 含有輸入格式錯誤的emp_purviewVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/emp_purview/addEmp_purview.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Emp_purviewService emp_purviewSvc = new Emp_purviewService();
               emp_purviewVO = emp_purviewSvc.addEmp_purview(
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/emp_purview/listAllEmp_purview.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp_purview.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emp_purview/addEmp_purview.jsp");
			failureView.forward(req, res);
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/emp_purview/listAllEmp_purview.jsp】 或  【/dept/listEmp_purviews_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String emp_No = new String(req.getParameter("emp_No"));
			/***************************2.開始刪除資料***************************************/
			Emp_purviewService emp_purviewSvc = new Emp_purviewService();
			Emp_purviewVO emp_purviewVO = emp_purviewSvc.getOneEmp_purview(emp_No);
			emp_purviewSvc.deleteEmp_purview(emp_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			EmpService empSvc = new EmpService();
			if(requestURL.equals("/emp/listEmp_purviews_ByEmp_No.jsp") || requestURL.equals("/emp/listAllEmp.jsp")){
			  //req.setAttribute("listEmp_purviews_ByEmp_No",empSvc.getEmp_purviewsByEmp_No(emp_purviewVO.getEmp_No())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listEmp_purviews_ByEmp_No",empSvc.getEmp_purviewsByEmp_No(emp_purviewVO.getEmpVO().getEmp_No())); // 資料庫取出的list物件,存入request
			}
			PurviewService purviewSvc = new PurviewService();
			if(requestURL.equals("/purview/listEmp_purviews_ByPurview_No.jsp") || requestURL.equals("/purview/listAllPurview.jsp")){
			  //req.setAttribute("listEmp_purviews_ByPurview_No",purviewSvc.getEmp_purviewsByPurview_No(emp_purviewVO.getPurview_No())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listEmp_purviews_ByPurview_No",purviewSvc.getEmp_purviewsByPurview_No(emp_purviewVO.getPurviewVO().getPurview_No())); // 資料庫取出的list物件,存入request
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
