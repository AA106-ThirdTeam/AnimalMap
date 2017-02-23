package heibernate_com.report.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.report.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/report/report.do" })
public class ReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllReport.jsp 或  /dept/listReports_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_report_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addReport.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllReport.jsp 或  /dept/listReports_ByDeptno.jsp的請求
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
			ReportService reportSvc = new ReportService();
			List<ReportVO> list  = reportSvc.getAll(map);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listReports_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/report/listReports_ByCompositeQuery.jsp"); // 成功轉交listReports_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/report/select_page.jsp");
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
			String str = req.getParameter("report_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入檢舉編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/report/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String report_No = null;
			try {
				report_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("檢舉編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/report/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			ReportService reportSvc = new ReportService();
			ReportVO reportVO = reportSvc.getOneReport(report_No);
			if (reportVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/report/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("reportVO", reportVO); // 資料庫取出的reportVO物件,存入req
			String url = "/Heibernate_back-end/report/listOneReport.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneReport.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/report/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	private void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/report/listAllReport.jsp】 或  【/dept/listReports_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String report_No = new String(req.getParameter("report_No"));
			/***************************2.開始查詢資料****************************************/
			ReportService reportSvc = new ReportService();
			ReportVO reportVO = reportSvc.getOneReport(report_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("reportVO", reportVO); // 資料庫取出的reportVO物件,存入req
			String url = "/Heibernate_back-end/report/update_report_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_report_input.jsp
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
				String report_No = req.getParameter("report_No").trim();
				String report_name = req.getParameter("report_name").trim();
				String report_class = req.getParameter("report_class").trim();
				String report_class_No = req.getParameter("report_class_No").trim();
				String report_class_No_value = req.getParameter("report_class_No_value").trim();
				String report_content = req.getParameter("report_content").trim();
				String report_status = req.getParameter("report_status").trim();
				String mem_Id_active = req.getParameter("mem_Id_active").trim();
				String mem_Id_passive = req.getParameter("mem_Id_passive").trim();
				java.sql.Date report_time = null;
				try {
					report_time = java.sql.Date.valueOf(req.getParameter("report_time").trim());
				} catch (IllegalArgumentException e) {
					report_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String report_class_status = req.getParameter("report_class_status").trim();
			//==== VO設定部分 ====			
				ReportVO reportVO = new ReportVO();
				reportVO.setReport_No(report_No);
				reportVO.setReport_name(report_name);
				reportVO.setReport_class(report_class);
				reportVO.setReport_class_No(report_class_No);
				reportVO.setReport_class_No_value(report_class_No_value);
				reportVO.setReport_content(report_content);
				reportVO.setReport_status(report_status);
				//以下3行程式碼因為要配合Hibernate的reportVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id_active);
				reportVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的reportVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				memVO = new MemVO();
				memVO.setMem_Id(mem_Id_passive);
				reportVO.setMemVO(memVO);
				reportVO.setReport_time(report_time);
				reportVO.setReport_class_status(report_class_status);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("reportVO", reportVO); // 含有輸入格式錯誤的reportVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/report/update_report_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			ReportService reportSvc = new ReportService();
			reportVO = reportSvc.updateReport(
					report_No
					,report_name
					,report_class
					,report_class_No
					,report_class_No_value
					,report_content
					,report_status
					,mem_Id_active
					,mem_Id_passive
					,report_time
					,report_class_status
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/report/listReports_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/report/listAllReport.jsp")){
				//req.setAttribute("listReports_ByMem_Id",reportSvc.getReportsByMem_Id(mem_Id_active)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/report/listReports_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/report/listAllReport.jsp")){
				//req.setAttribute("listReports_ByMem_Id",reportSvc.getReportsByMem_Id(mem_Id_passive)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/report/listReports_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<ReportVO> list  = reportSvc.getAll(map);
				//req.setAttribute("listReports_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/report/update_report_input.jsp");
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
               String report_name = req.getParameter("report_name").trim();	
               String report_class = req.getParameter("report_class").trim();	
               String report_class_No = req.getParameter("report_class_No").trim();	
               String report_class_No_value = req.getParameter("report_class_No_value").trim();	
               String report_content = req.getParameter("report_content").trim();	
               String report_status = req.getParameter("report_status").trim();	
               String mem_Id_active = req.getParameter("mem_Id_active").trim();	
               String mem_Id_passive = req.getParameter("mem_Id_passive").trim();	
               java.sql.Date report_time = null;
               try {
                   report_time = java.sql.Date.valueOf(req.getParameter("report_time").trim());
               } catch (IllegalArgumentException e) {
                   report_time=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String report_class_status = req.getParameter("report_class_status").trim();	
               ReportVO reportVO = new ReportVO();
				reportVO.setReport_name(report_name);
				reportVO.setReport_class(report_class);
				reportVO.setReport_class_No(report_class_No);
				reportVO.setReport_class_No_value(report_class_No_value);
				reportVO.setReport_content(report_content);
				reportVO.setReport_status(report_status);
				//以下3行程式碼因為要配合Hibernate的reportVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id_active);
				reportVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的reportVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				memVO = new MemVO();
				memVO.setMem_Id(mem_Id_passive);
				reportVO.setMemVO(memVO);
				reportVO.setReport_time(report_time);
				reportVO.setReport_class_status(report_class_status);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("reportVO", reportVO); // 含有輸入格式錯誤的reportVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/report/addReport.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               ReportService reportSvc = new ReportService();
               reportVO = reportSvc.addReport(
               	report_name
               	,report_class
               	,report_class_No
               	,report_class_No_value
               	,report_content
               	,report_status
               	,mem_Id_active
               	,mem_Id_passive
               	,report_time
               	,report_class_status
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/report/listAllReport.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllReport.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/report/addReport.jsp");
			failureView.forward(req, res);
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/report/listAllReport.jsp】 或  【/dept/listReports_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String report_No = new String(req.getParameter("report_No"));
			/***************************2.開始刪除資料***************************************/
			ReportService reportSvc = new ReportService();
			ReportVO reportVO = reportSvc.getOneReport(report_No);
			reportSvc.deleteReport(report_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listReports_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listReports_ByMem_Id",memSvc.getReportsByMem_Id(reportVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listReports_ByMem_Id",memSvc.getReportsByMem_Id(reportVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
			memSvc = new MemService();
			if(requestURL.equals("/mem/listReports_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listReports_ByMem_Id",memSvc.getReportsByMem_Id(reportVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listReports_ByMem_Id",memSvc.getReportsByMem_Id(reportVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
