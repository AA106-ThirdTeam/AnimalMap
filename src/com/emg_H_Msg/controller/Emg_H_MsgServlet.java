package com.emg_H_Msg.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emg_H.model.*;
import com.emg_H_Msg.model.*;


public class Emg_H_MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      
	 
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		String action=req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) { // 來自/front-end/emg_Hselect_page.jsp的請求

			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String emg_H_Msg_Id = req.getParameter("emg_H_Msg_Id");
				if (emg_H_Msg_Id == null || (emg_H_Msg_Id.trim()).length() == 0) {
					errorMsgs.add("請輸入留言編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H_Msg/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				
				
				/***************************2.開始查詢資料*****************************************/
				
				Emg_H_MsgService emg_H_MsgSvc = new Emg_H_MsgService();
				Emg_H_MsgVO emg_H_MsgVO = emg_H_MsgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);
				if (emg_H_MsgVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H_Msg/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_H_MsgVO", emg_H_MsgVO); // 資料庫取出的empVO物件,存入req
				
			 
			   
				String url = "/front-end/emg_H_Msg/listOneEmg_H_Msg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H_Msg/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自/emg_H_Msg/listAllEmg_H_Msg.jsp 或  /emg_H/listEmg_H_Msg_ByEmg_H_Id.jsp 的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emg_H_Msg/listAllEmg_H_Msg.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
			
			try {
				/***************************1.接收請求參數****************************************/
				String emg_H_Msg_Id = req.getParameter("emg_H_Msg_Id");
				
				/***************************2.開始查詢資料*****************************************/
				Emg_H_MsgService emg_H_MsgSvc = new Emg_H_MsgService();
				Emg_H_MsgVO emg_H_MsgVO = emg_H_MsgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);
				
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_H_MsgVO", emg_H_MsgVO); // 資料庫取出的empVO物件,存入req
				req.setAttribute("emg_H_Msg_Id", emg_H_Msg_Id); // 帶emg_H_Msg_Id 存入req, 	※include 時  getParameter的方式 原資料會不見!	// 

				String url = "/front-end/emg_H_Msg/update_emg_H_Msg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emg_H_Msg.jsp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H_Msg/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		if ("insert_Emg_MsgByEmg_H".equals(action)) { // /Emg_H/listAllEmg_H.jsp 的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑:  emg_H/listAllEmg_H.jsp	
			
			try {
				/***************************1.接收請求參數****************************************/
				String emg_H_Id = req.getParameter("emg_H_Id");

				
				/***************************2.開始查詢資料*****************************************/
				Emg_HService emg_HSvc = new Emg_HService();
				Emg_HVO emg_HVO = emg_HSvc.getOneEmg_H(emg_H_Id);
				
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_HVO", emg_HVO); // 資料庫取出的empVO物件,存入req
				req.setAttribute("emg_H_Id", emg_H_Id); // 帶emg_H_Id 存入req, 	◎include 時  getParameter的方式 原資料會不見!
				
				String url = "/front-end/emg_H_Msg/addEmg_H_Msg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交/emg_H_Msg/addEmg_H_Msg.jsp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H/listAllEmg_H.jsp");
				failureView.forward(req, res);
			}
		}
				
				
			if ("insert".equals(action)) { // 來自addEmg_H_Msg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL");
			
			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				
				String mem_Id = req.getParameter("mem_Id");
				
				String emg_H_Id = req.getParameter("emg_H_Id").trim();	
					
				
				java.sql.Timestamp  emg_H_Msg_start=new java.sql.Timestamp (System.currentTimeMillis());
					
				
				String emg_H_Msg_content =req.getParameter("emg_H_Msg_content").trim();
				
				if(emg_H_Msg_content==null||(emg_H_Msg_content.trim()).length()==0){
					errorMsgs.add("請輸入內容");
				}
				
				
				Emg_H_MsgVO emg_H_MsgVO = new Emg_H_MsgVO();
				emg_H_MsgVO.setMem_Id(mem_Id);
				emg_H_MsgVO.setEmg_H_Id(emg_H_Id);
				emg_H_MsgVO.setEmg_H_Msg_start(emg_H_Msg_start);
				emg_H_MsgVO.setEmg_H_Msg_content(emg_H_Msg_content);
		

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("emg_H_MsgVO", emg_H_MsgVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H_Msg/addEmg_H_Msg.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Emg_H_MsgService emg_H_MsgSvc = new Emg_H_MsgService();
				emg_H_MsgVO = emg_H_MsgSvc.addEmg_H_Msg(mem_Id, emg_H_Id, emg_H_Msg_start, emg_H_Msg_content);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "/front-end/emg_H_Msg/listAllEmg_H_Msg.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmg_H_Msg.jsp
//				successView.forward(req, res);	
				
				req.setAttribute("emg_H_Id", emg_H_Id); // 帶emg_H_Id 存入req, 	◎include 時  getParameter的方式 的原資料會不見!
				
				Emg_HService emg_HSvc = new Emg_HService();
				
				if( requestURL.equals("/front-end/emg_H/listOneEmg_H.jsp")||requestURL.equals("/front-end/emg_H/listAllEmg_H.jsp"))
					req.setAttribute("listEmg_H_Msg_ByEmg_H_Id",emg_HSvc.getEmg_H_MsgByEmg_H_Id(emg_H_Id)); // 資料庫取出的list物件,存入request

				String url = requestURL;

				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);
				
				
				
				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H_Msg/addEmg_H_Msg.jsp");
				failureView.forward(req, res);
			}
		}
				
			if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
				
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				
				String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emg_H/listEmg_H_Msg_ByEmg_H_Id.jsp】 或 【 /emg_H/listAllEmg_H.jsp】
			
				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
										
					String emg_H_Msg_Id = req.getParameter("emg_H_Msg_Id");	
					
					String mem_Id = req.getParameter("mem_Id");
								
					String emg_H_Id = req.getParameter("emg_H_Id");

					java.sql.Timestamp emg_H_Msg_start= new java.sql.Timestamp (System.currentTimeMillis());
	
					String emg_H_Msg_content = req.getParameter("emg_H_Msg_content").trim();
						
					if(emg_H_Msg_content==null||(emg_H_Msg_content.trim()).length()==0){
						errorMsgs.add("請輸入內容");
					}

					Emg_H_MsgVO emg_H_MsgVO = new Emg_H_MsgVO();
					emg_H_MsgVO.setEmg_H_Msg_Id(emg_H_Msg_Id);					
					emg_H_MsgVO.setEmg_H_Id(emg_H_Id);					
					emg_H_MsgVO.setMem_Id(mem_Id);					
					emg_H_MsgVO.setEmg_H_Msg_start(emg_H_Msg_start);
					emg_H_MsgVO.setEmg_H_Msg_content(emg_H_Msg_content);
		
				
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("emg_H_MsgVO", emg_H_MsgVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/emg_H_Msg/update_emg_H_Msg.jsp");
						failureView.forward(req, res);
						return; //程式中斷
					}
					
					/***************************2.開始修改資料*****************************************/
					Emg_H_MsgService emg_H_MsgSvc = new Emg_H_MsgService();
															 //與mem_Id 綁定問題???
					emg_H_MsgVO= emg_H_MsgSvc.updateEmg_H_Msg( mem_Id, emg_H_Id, emg_H_Msg_Id, emg_H_Msg_start, emg_H_Msg_content);
					req.setAttribute("emg_H_Id", emg_H_Id);
					
					/***************************3.修改完成,準備轉交(Send the Success view)*************/				
					Emg_HService emg_HSvc = new Emg_HService();
					
					if(requestURL.equals("/front-end/emg_H/listEmg_H_Msg_ByEmg_H_Id.jsp") || requestURL.equals("/front-end/emg_H/listAllEmg_H.jsp")|| requestURL.equals("/front-end/emg_H/listOneEmg_H.jsp"))
						req.setAttribute("listEmg_H_Msg_ByEmg_H_Id",emg_HSvc.getEmg_H_MsgByEmg_H_Id(emg_H_Id)); // 資料庫取出的list物件,存入request

	                String url = requestURL;

					RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
					successView.forward(req, res);

					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/emg_H_Msg/update_emg_H_Msg.jsp");
					failureView.forward(req, res);
				}
			}
			
			
				if ("delete".equals(action)) { // 來自listAllEmg_H_Msg.jsp 或  /dept/listEmps_ByDeptno.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				
				String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emg_H_Msg/listAllEmg_H_Msg.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】

				try {
					/***************************1.接收請求參數***************************************/
					String emg_H_Msg_Id = req.getParameter("emg_H_Msg_Id");
					String emg_H_Id = req.getParameter("emg_H_Id");

					
					/***************************2.開始刪除資料***************************************/
					Emg_H_MsgService emg_H_MsgSvc = new Emg_H_MsgService();
					Emg_H_MsgVO emg_H_MsgVO = emg_H_MsgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);

					emg_H_MsgSvc.delete(emg_H_Msg_Id);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/
					
					req.setAttribute("emg_H_Id", emg_H_Id); // 帶emg_H_Msg_Id 存入req ◎include 時  getParameter的方式 的原資料會不見!

					Emg_HService emg_HSvc = new Emg_HService();
					if(requestURL.equals("/front-end/emg_H/listEmg_H_Msg_ByEmg_H_Id.jsp") || requestURL.equals("/front-end/emg_H/listAllEmg_H.jsp")|| requestURL.equals("/front-end/emg_H/listOneEmg_H.jsp"))
						req.setAttribute("listEmg_H_Msg_ByEmg_H_Id",emg_HSvc.getEmg_H_MsgByEmg_H_Id(emg_H_MsgVO.getEmg_H_Id())); // 資料庫取出的list物件,存入request
	
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

	
	
}
