package com.offiMsg.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.offiMsg.model.*;

public class OffiMsgServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("action:"+ action);
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("offiMsg_Id");
//				System.out.println("str "+str);
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入訊息編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				String offiMsg_Id = null;
				System.out.println("offiMsg_Id:"+offiMsg_Id);
				try {
					offiMsg_Id = new String(str);
				} catch (Exception e) {
					errorMsgs.add("訊息編號格式不正確");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
					
				/***************************2.開始查詢資料*****************************************/
				OffiMsgService offiMsgSvc = new OffiMsgService();
				OffiMsgVO offiMsgVO = offiMsgSvc.getOneOffiMsg(offiMsg_Id);
				if (offiMsgVO == null) {
					errorMsgs.add("查無資料");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("offiMsgVO", offiMsgVO); // 資料庫取出的offiMsgVO物件,存入req
				String url = "/offiMsg/listOneOffiMsg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneOffiMsg.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllOffiMsg.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println("errorMsgs:"+errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/offiMsg/listAllOffiMsg.jsp】
			try {
				/***************************1.接收請求參數****************************************/
				String offiMsg_Id =new String(req.getParameter("offiMsg_Id"));
				System.out.println("offiMsg_Id:"+offiMsg_Id);
				/***************************2.開始查詢資料****************************************/
				OffiMsgService offiMsgSvc = new OffiMsgService();
				OffiMsgVO offiMsgVO = offiMsgSvc.getOneOffiMsg(offiMsg_Id);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("offiMsgVO", offiMsgVO);     // 資料庫取出的offiMsgVO物件,存入req
				String url = "/offiMsg/update_offiMsg_input.jsp";
				System.out.println("url:"+url);
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_offiMsg_input.jsp
				successView.forward(req, res);
				

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
		
		if ("update".equals(action)) { // 來自update_offiMsg_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println(errorMsgs);
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/offiMsg/listAllOffiMsg.jsp】
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String offiMsg_Id = req.getParameter("offiMsg_Id").trim();
				System.out.println(offiMsg_Id);
				String offiMsg_empId = req.getParameter("offiMsg_empId").trim();
				
				//offiMsg_Title文章標題錯誤判斷
				String offiMsg_Title = null;
				offiMsg_Title = new String(req.getParameter("offiMsg_Title").trim());
				if(offiMsg_Title.length() == 0) {
					errorMsgs.add("請輸入訊息標題!");
				}
				System.out.println("offiMsg_Title : "+offiMsg_Title);
				

				//訊息內容錯誤判斷
				String offiMsg_Content = null;
				offiMsg_Content = new String(req.getParameter("offiMsg_Content").trim());
				if (offiMsg_Content.length() == 0) {
					errorMsgs.add("請輸訊息內容!");
				}
				
				java.sql.Date offiMsg_Date = new java.sql.Date(System.currentTimeMillis());
//				try {
//					offiMsg_Date = java.sql.Date.valueOf(req.getParameter("offiMsg_Date").trim());
//				} catch (IllegalArgumentException e) {
//					offiMsg_Date=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
			
			
				OffiMsgVO offiMsgVO = new OffiMsgVO();
				offiMsgVO.setOffiMsg_Id(offiMsg_Id);
				offiMsgVO.setOffiMsg_empId(offiMsg_empId);
				offiMsgVO.setOffiMsg_Title(offiMsg_Title);
				offiMsgVO.setOffiMsg_Content(offiMsg_Content);
				offiMsgVO.setOffiMsg_Date(offiMsg_Date);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("offiMsgVO", offiMsgVO); // 含有輸入格式錯誤的offiMsgVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/offiMsg/update_offiMsg_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				OffiMsgService offiMsgSvc = new OffiMsgService();
				offiMsgVO = offiMsgSvc.updateOffiMsg(offiMsg_Id, offiMsg_empId, offiMsg_Title, offiMsg_Content, offiMsg_Date);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
//				PostService postSvc = new PostService();
//				
				req.setAttribute("offiMsgVO", offiMsgVO);     // 資料庫取出的offiMsgVO物件,存入req
				System.out.println(offiMsgVO);
				String url = requestURL;
				System.out.println(requestURL);
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/offiMsg/update_offiMsg_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("insert".equals(action)) { // 來自addOffiMsg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println(errorMsgs);	

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String offiMsg_empId = req.getParameter("offiMsg_empId").trim();
				System.out.println(offiMsg_empId);
				
				//offiMsg_Title文章標題錯誤判斷
				String offiMsg_Title = null;
				offiMsg_Title = new String(req.getParameter("offiMsg_Title").trim());
				if(offiMsg_Title.length() == 0) {
					errorMsgs.add("請輸入訊息標題!");
				}
				System.out.println("offiMsg_Title : "+offiMsg_Title);
				

				//訊息內容錯誤判斷
				String offiMsg_Content = null;
				offiMsg_Content = new String(req.getParameter("offiMsg_Content").trim());
				if (offiMsg_Content.length() == 0) {
					errorMsgs.add("請輸訊息內容!");
				}
				
				java.sql.Date offiMsg_Date = new java.sql.Date(System.currentTimeMillis());
				
				OffiMsgVO offiMsgVO = new OffiMsgVO();
				offiMsgVO.setOffiMsg_empId(offiMsg_empId);
				offiMsgVO.setOffiMsg_Title(offiMsg_Title);
				offiMsgVO.setOffiMsg_Content(offiMsg_Content);
				offiMsgVO.setOffiMsg_Date(offiMsg_Date);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("offiMsgVO", offiMsgVO); // 含有輸入格式錯誤的offiMsgVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/offiMsg/addOffiMsg.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				OffiMsgService offiMsgSvc = new OffiMsgService();
				offiMsgVO = offiMsgSvc.addOffiMsg(offiMsg_empId, offiMsg_Title, offiMsg_Content, offiMsg_Date);
			
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/offiMsg/listAllOffiMsg.jsp";
				System.out.println(url);
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOffiMsg.jsp
				successView.forward(req, res);		
			
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/offiMsg/addOffiMsg.jsp");
				failureView.forward(req, res);
			}
		}
		

		if ("delete".equals(action)) { // 來自listAllOffiMsg.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/offiMssg/listAllOffiMsg.jsp】
			
			try {
				/***************************1.接收請求參數***************************************/
				String offiMsg_Id =new String(req.getParameter("offiMsg_Id"));
				System.out.println(" offiMsg_Id : " + offiMsg_Id);
		
				/***************************2.開始刪除資料***************************************/
				OffiMsgService offiMsgSvc =new OffiMsgService();
				OffiMsgVO offiMsgVO = offiMsgSvc.getOneOffiMsg(offiMsg_Id);
				offiMsgSvc.deleteOffiMsg(offiMsg_Id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//				PostService postSvc = new PostService();
//				if(requestURL.equals("/post/listPost_Responses_ByPost_Id.jsp") || requestURL.equals("/post/listAllPost.jsp"))
//					req.setAttribute("listPost_Responses_ByPost_Id",postSvc.getPost_ResponsesByPost_Id(post_ResponseVO.getPost_Id())); // 資料庫取出的list物件,存入request
				
				
				String url =requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			}  catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);;
			}
		}
	}
}