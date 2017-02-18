package heibernate_com.emp.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.emp.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/emp/emp.do" })
public class EmpServlet extends HttpServlet {
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
			String str = req.getParameter("emp_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入員工編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emp/select_page.jsp");
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
						.getRequestDispatcher("/Heibernate_back-end/emp/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(emp_No);
			if (empVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emp/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
			String url = "/Heibernate_back-end/emp/listOneEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emp/select_page.jsp");
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
			String emp_No = new String(req.getParameter("emp_No"));
			/***************************2.開始查詢資料****************************************/
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(emp_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
			String url = "/Heibernate_back-end/emp/update_emp_input.jsp";
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
				String emp_No = req.getParameter("emp_No").trim();
				String emp_name = req.getParameter("emp_name").trim();
				String emp_Pw = req.getParameter("emp_Pw").trim();
				String emp_email = req.getParameter("emp_email").trim();
				String emp_identity_card = req.getParameter("emp_identity_card").trim();
				java.sql.Date emp_birthday = null;
				try {
					emp_birthday = java.sql.Date.valueOf(req.getParameter("emp_birthday").trim());
				} catch (IllegalArgumentException e) {
					emp_birthday=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String emp_phone = req.getParameter("emp_phone").trim();
				String emp_address = req.getParameter("emp_address").trim();
				String emp_status = req.getParameter("emp_status").trim();
				byte[] emp_picture = null;
				try {
					Part part = req.getPart("emp_picture");
					InputStream in = part.getInputStream();
					emp_picture = new byte[part.getInputStream().available()];
					in.read(emp_picture);
					in.close();
				} catch (Exception e) {
					emp_picture = null;
					//errorMsgs.add("員工照片請上傳照片.");
				}
				String emp_Pic_format = req.getParameter("emp_Pic_format").trim();
				java.sql.Date emp_hiredate = null;
				try {
					emp_hiredate = java.sql.Date.valueOf(req.getParameter("emp_hiredate").trim());
				} catch (IllegalArgumentException e) {
					emp_hiredate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date emp_firedate = null;
				try {
					emp_firedate = java.sql.Date.valueOf(req.getParameter("emp_firedate").trim());
				} catch (IllegalArgumentException e) {
					emp_firedate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				EmpVO empVO = new EmpVO();
				empVO.setEmp_No(emp_No);
				empVO.setEmp_name(emp_name);
				empVO.setEmp_Pw(emp_Pw);
				empVO.setEmp_email(emp_email);
				empVO.setEmp_identity_card(emp_identity_card);
				empVO.setEmp_birthday(emp_birthday);
				empVO.setEmp_phone(emp_phone);
				empVO.setEmp_address(emp_address);
				empVO.setEmp_status(emp_status);
				empVO.setEmp_picture(emp_picture);
				empVO.setEmp_Pic_format(emp_Pic_format);
				empVO.setEmp_hiredate(emp_hiredate);
				empVO.setEmp_firedate(emp_firedate);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/emp/update_emp_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			EmpService empSvc = new EmpService();
			empVO = empSvc.updateEmp(
					emp_No
					,emp_name
					,emp_Pw
					,emp_email
					,emp_identity_card
					,emp_birthday
					,emp_phone
					,emp_address
					,emp_status
					,emp_picture
					,emp_Pic_format
					,emp_hiredate
					,emp_firedate
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/emp/listEmps_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<EmpVO> list  = empSvc.getAll(map);
				//req.setAttribute("listEmps_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emp/update_emp_input.jsp");
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
               String emp_name = req.getParameter("emp_name").trim();	
               String emp_Pw = req.getParameter("emp_Pw").trim();	
               String emp_email = req.getParameter("emp_email").trim();	
               String emp_identity_card = req.getParameter("emp_identity_card").trim();	
               java.sql.Date emp_birthday = null;
               try {
                   emp_birthday = java.sql.Date.valueOf(req.getParameter("emp_birthday").trim());
               } catch (IllegalArgumentException e) {
                   emp_birthday=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String emp_phone = req.getParameter("emp_phone").trim();	
               String emp_address = req.getParameter("emp_address").trim();	
               String emp_status = req.getParameter("emp_status").trim();	
               byte[] emp_picture = null;
               try {
                   Part part = req.getPart("emp_picture");
                   InputStream in = part.getInputStream();
                   emp_picture = new byte[part.getInputStream().available()];
                   in.read(emp_picture);
                   in.close();
               } catch (Exception e) {
                   //errorMsgs.add("員工照片請上傳照片.");
                   //e.printStackTrace();
                   emp_picture = null;
               }	
               String emp_Pic_format = req.getParameter("emp_Pic_format").trim();	
               java.sql.Date emp_hiredate = null;
               try {
                   emp_hiredate = java.sql.Date.valueOf(req.getParameter("emp_hiredate").trim());
               } catch (IllegalArgumentException e) {
                   emp_hiredate=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date emp_firedate = null;
               try {
                   emp_firedate = java.sql.Date.valueOf(req.getParameter("emp_firedate").trim());
               } catch (IllegalArgumentException e) {
                   emp_firedate=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               EmpVO empVO = new EmpVO();
				empVO.setEmp_name(emp_name);
				empVO.setEmp_Pw(emp_Pw);
				empVO.setEmp_email(emp_email);
				empVO.setEmp_identity_card(emp_identity_card);
				empVO.setEmp_birthday(emp_birthday);
				empVO.setEmp_phone(emp_phone);
				empVO.setEmp_address(emp_address);
				empVO.setEmp_status(emp_status);
				empVO.setEmp_picture(emp_picture);
				empVO.setEmp_Pic_format(emp_Pic_format);
				empVO.setEmp_hiredate(emp_hiredate);
				empVO.setEmp_firedate(emp_firedate);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/emp/addEmp.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               EmpService empSvc = new EmpService();
               empVO = empSvc.addEmp(
               	emp_name
               	,emp_Pw
               	,emp_email
               	,emp_identity_card
               	,emp_birthday
               	,emp_phone
               	,emp_address
               	,emp_status
               	,emp_picture
               	,emp_Pic_format
               	,emp_hiredate
               	,emp_firedate
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/emp/listAllEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/emp/addEmp.jsp");
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
			String emp_No = new String(req.getParameter("emp_No"));
			/***************************2.開始刪除資料***************************************/
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(emp_No);
			empSvc.deleteEmp(emp_No);
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
