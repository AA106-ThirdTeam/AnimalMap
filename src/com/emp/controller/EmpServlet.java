package com.emp.controller;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;
import com.tools.method.MailService;
import com.tools.method.PwCreate;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
	

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/****************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String emp_No = req.getParameter("emp_No");

				if (emp_No == null || (emp_No.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

			

				/*************************** 2.開始查詢資料 *****************************************/
				EmpService empSvc = new EmpService();
				EmpVO empVO = empSvc.getOneEmp(emp_No);

				if (empVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/****************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/emp/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交
																				// listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 接收 listAllEmp.jsp URL
			

			try {
				/*************************** 1.接收請求參數 ****************************************/
				String emp_No = new String(req.getParameter("emp_No"));

				/*************************** 2.開始查詢資料 ****************************************/
				EmpService empSvc = new EmpService();
				EmpVO empVO = empSvc.getOneEmp(emp_No);

				/******************************** 3.查詢完成,準備轉交(Send the Success view)************/
				
				if(requestURL.equals("/back-end/emp/listAllEmp.jsp")||requestURL.equals("/back-end/emp/select_pageForView.jsp") ){
				
				req.setAttribute("empVO",empVO); // 資料庫取出的list物件,存入request
				String url = "/back-end/emp/update_emp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);
				}
				
				if(requestURL.equals("/back-end/emp/select_page.jsp")){
					
				req.setAttribute("empVO",empVO); // 資料庫取出的list物件,存入request
				String url = "/back-end/emp/update_empMyself.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);
				}

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
		
System.out.println(action);
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL");
		
			
			try {
				/******************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

				String emp_No = req.getParameter("emp_No").trim();
			
				String emp_name = req.getParameter("emp_name").trim();
				String emp_Pw = req.getParameter("emp_Pw").trim();
				if (emp_Pw == null || (emp_Pw.trim()).length() == 0) {

					errorMsgs.add("請輸入密碼!");
				}
				
				String emp_email = req.getParameter("emp_email").trim();
				
				if (emp_email == null || (emp_email.trim()).length() == 0) {

					errorMsgs.add("請輸入EMAIL!");
				}
				
				String emp_Id = req.getParameter("emp_Id").trim();
				if (emp_Id == null || (emp_Id.trim()).length() == 0) {

					errorMsgs.add("請輸入ID!");
				}

				java.sql.Date emp_birthday = null;
				try {
					emp_birthday = java.sql.Date.valueOf(req.getParameter("emp_birthday").trim());
				} catch (IllegalArgumentException e) {
					emp_birthday = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				String emp_phone = req.getParameter("emp_phone").trim();
				String emp_address = req.getParameter("emp_address").trim();
System.out.println(emp_address+"222222222222");
				if (emp_address == null || (emp_address.trim()).length() == 0) {

					errorMsgs.add("請輸入住址");
				}
				
				String emp_status = req.getParameter("emp_status");
				
System.out.println(emp_status);
				
				Collection<Part> parts = null;
				byte[] emp_picture =null;	
							
				//修改圖片
				try{
					for (Part part : parts) {
						parts=req.getParts();
						if ("emp_picture".equals(part.getName())) {
							InputStream in = part.getInputStream();
							emp_picture = new byte[in.available()];
							in.read(emp_picture);
							in.close();
						}
					}
				}catch(Exception e){
				
					//修改密碼是用Ajax form 送回來，picture 要用parts來接，利用try catch做處理，給一個零長度的byte[]
					emp_picture=new byte[0];
					System.out.println("111111111111111111111111111111");
				}
		
   System.out.println("7777777777777777777777777777777777s");
	
				java.sql.Date emp_hiredate = null;

				try {
					emp_hiredate = java.sql.Date.valueOf(req.getParameter("emp_hiredate"));
	System.out.println(emp_hiredate);	
				} catch (IllegalArgumentException e) {
					emp_hiredate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");

	System.out.println(emp_hiredate);
					
					
				}
				java.sql.Date emp_firedate = null;

				if (emp_status.equals("0")) {

					try {
						emp_firedate = java.sql.Date.valueOf(req.getParameter("emp_firedate"));
					} catch (IllegalArgumentException e) {
						emp_firedate = new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
					}
				}
				
	System.out.println(emp_firedate);				
				
				EmpVO empVO = new EmpVO();
				empVO.setEmp_No(emp_No);
				empVO.setEmp_name(emp_name);
				empVO.setEmp_Pw(emp_Pw);
				empVO.setEmp_email(emp_email);
				empVO.setEmp_Id(emp_Id);
				empVO.setEmp_birthday(emp_birthday);
				empVO.setEmp_phone(emp_phone);
				empVO.setEmp_address(emp_address);
				empVO.setEmp_status(emp_status);
				empVO.setEmp_picture(emp_picture);					
				empVO.setEmp_hiredate(emp_hiredate);
				empVO.setEmp_firedate(emp_firedate);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
System.out.println(errorMsgs);
					req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/update_emp_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
			System.out.println("5555555555555555555555555");
				
				EmpService empSvc = new EmpService();
				empVO = empSvc.updateEmp(emp_No, emp_name, emp_Pw, emp_email, emp_Id, emp_birthday, emp_phone,
						emp_address, emp_status,emp_picture,emp_hiredate, emp_firedate);
				
				/****************************** 3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("empVO", empVO); // 資料庫update成功後,正確的的empVO物件,存入req
			
				
				if(requestURL.equals("/back-end/emp/listAllEmp.jsp")){

				 String url="/back-end/emp/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				}
				if(requestURL.equals("/back-end/emp/select_pageForView.jsp")){
				
					String url="/back-end/emp/select_pageForView.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					}
				

				/*************************** 其他可能的錯誤處理 *************************************/
				} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/update_emp_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/**************************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

				String emp_name = req.getParameter("emp_name").trim();

				
/*=======================================<寄E-mail 傳送密碼>============================================*/
				
				String emp_Pw = PwCreate.randomPW((int) (Math.random() * 5) + 5); // 呼叫方法產生密碼亂數

				String emp_email = req.getParameter("emp_email").trim();

				if (emp_email == null || (emp_email.trim()).length() == 0) {

					errorMsgs.add("請輸入EMAIL!");
				}
				
				 String to = emp_email;			      
			     String subject = "密碼通知";	   
			    
			     String messageText = "HELLO, " + emp_name + " 請謹記此密碼: " + emp_Pw + "\n" +" (已經啟用)"; 
			       
			        MailService mailService = new MailService();
			        mailService.sendMail(to, subject, messageText);
			      
 /*=======================================<寄E-mail 傳送密碼>============================================*/				
				
				String emp_Id = req.getParameter("emp_Id").trim();

				if (emp_Id == null || (emp_Id.trim()).length() == 0) {

					errorMsgs.add("請輸入ID!");
				}
				
				//新增圖片
				Collection<Part> parts = req.getParts();
				byte[] emp_picture = null;
				for (Part part : parts) {
					if ("emp_picture".equals(part.getName())) {
						InputStream in = part.getInputStream();
						emp_picture = new byte[in.available()];
						in.read(emp_picture);
						in.close();
					}

				}

				java.sql.Date emp_birthday = null;
				try {
					emp_birthday = java.sql.Date.valueOf(req.getParameter("emp_birthday").trim());
				} catch (IllegalArgumentException e) {
					emp_birthday = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				String emp_phone = req.getParameter("emp_phone").trim();

				if (!emp_phone.matches("\\d{10}")) { // String 裡的matches method
														// 使用正則符號
					errorMsgs.add("請輸入正確號碼");
				}

				String emp_address = req.getParameter("emp_address").trim();
				String emp_status = req.getParameter("emp_status");

				if (emp_status == null) {
					errorMsgs.add("請輸入狀態!");
				}

				java.sql.Date emp_hiredate = null;
				try {
					emp_hiredate = java.sql.Date.valueOf(req.getParameter("emp_hiredate").trim());
				} catch (IllegalArgumentException e) {
					emp_hiredate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");

				}

				EmpVO empVO = new EmpVO();

				empVO.setEmp_name(emp_name);
				empVO.setEmp_Pw(emp_Pw);
				empVO.setEmp_email(emp_email);
				empVO.setEmp_Id(emp_Id);
				empVO.setEmp_birthday(emp_birthday);
				empVO.setEmp_phone(emp_phone);
				empVO.setEmp_address(emp_address);
				empVO.setEmp_picture(emp_picture);
				empVO.setEmp_status(emp_status);
				empVO.setEmp_hiredate(emp_hiredate);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/addEmp.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始新增資料 ***************************************/
				EmpService empSvc = new EmpService();
				empVO = empSvc.addEmp(emp_name, emp_Pw, emp_email, emp_Id, emp_birthday, emp_phone, emp_address,
						emp_status, emp_picture, emp_hiredate);

				/******************************* 3.新增完成,準備轉交(Send the Success view) ***********/
				//String url = "/back-end/emp/listAllEmp.jsp";
				
				//MapView 用
				String url = "/back-end/emp/select_pageForView.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/addEmp.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				String emp_No = new String(req.getParameter("emp_No"));

				/*************************** 2.開始刪除資料 ***************************************/
				EmpService empSvc = new EmpService();
				empSvc.deleteEmp(emp_No);

				/******************************** 3.刪除完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/emp/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/listAllEmp.jsp");
				failureView.forward(req, res);
			}

		}
	}
	
	
}
