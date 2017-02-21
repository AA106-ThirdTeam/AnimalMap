package com.post_Response.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.post_Response.model.*;
import com.post.model.*;

public class Post_ResponseServlet extends HttpServlet {

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
				String str = req.getParameter("res_Id");
//				System.out.println("str "+str);
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入回復編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				String res_Id = null;
				System.out.println("res_Id:"+res_Id);
				try {
					res_Id = new String(str);
				} catch (Exception e) {
					errorMsgs.add("回覆編號格式不正確");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
					
				/***************************2.開始查詢資料*****************************************/
				Post_ResponseService post_ResponseSvc = new Post_ResponseService();
				Post_ResponseVO post_ResponseVO = post_ResponseSvc.getOnePost_Response(res_Id);
				if (post_ResponseVO == null) {
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
				req.setAttribute("post_ResponseVO", post_ResponseVO); // 資料庫取出的post_ResponseVO物件,存入req
				String url = "/post_Response/listOnePost_Response.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOnePost_Response.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllPost_Response.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/post_Response/listAllPost_Response.jsp】 或  【/post/listPost_Responses_ByPost_Id.jsp】 或 【 /post/listAllPost.jsp】		

			try {
				/***************************1.接收請求參數****************************************/
				String res_Id =new String(req.getParameter("res_Id"));
				
				/***************************2.開始查詢資料****************************************/
				Post_ResponseService post_ResponseSvc = new Post_ResponseService();
				Post_ResponseVO post_ResponseVO = post_ResponseSvc.getOnePost_Response(res_Id);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("post_ResponseVO", post_ResponseVO);     // 資料庫取出的post_ResponseVO物件,存入req
				String url = "/post_Response/update_post_Response_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_post_Response_input.jsp
				successView.forward(req, res);
				

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
		
		if ("update".equals(action)) { // 來自update_post_Response_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/post_Response/listAllPost_Response.jsp】 或  【/post/listPost_Responses_ByPost_Id.jsp】 或 【 /post/listAllPost.jsp】		
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String res_Id = req.getParameter("res_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String post_Id = req.getParameter("post_Id").trim();

				//回覆文章內容錯誤判斷
				String post_Response_content = null;
				post_Response_content = new String(req.getParameter("post_Response_content").trim());
				if (post_Response_content.length() == 0) {
					errorMsgs.add("請輸入文章內容!");
				}
				
				java.sql.Date post_time = null;
				try {
					post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
				} catch (IllegalArgumentException e) {
					post_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				java.sql.Date post_Response_upDate = null;
				try {
					post_Response_upDate = java.sql.Date.valueOf(req.getParameter("post_Response_upDate").trim());
				} catch (IllegalArgumentException e) {
					post_Response_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入修改日期!");
				}
				
				Post_ResponseVO post_ResponseVO = new Post_ResponseVO();
				post_ResponseVO.setRes_Id(res_Id);
				post_ResponseVO.setMem_Id(mem_Id);
				post_ResponseVO.setPost_Id(post_Id);
				post_ResponseVO.setPost_Response_content(post_Response_content);
				post_ResponseVO.setPost_time(post_time);
				post_ResponseVO.setPost_Response_upDate(post_Response_upDate);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("post_ResponseVO", post_ResponseVO); // 含有輸入格式錯誤的post_ResponseVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/post_Response/update_post_Response_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Post_ResponseService post_ResponseSvc = new Post_ResponseService();
				post_ResponseVO = post_ResponseSvc.updatePost_Response(res_Id, mem_Id, post_Id, post_Response_content, post_time,post_Response_upDate);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				PostService postSvc = new PostService();
				if(requestURL.equals("/post/listPost_Responses_ByPost_Id.jsp") || requestURL.equals("/post/listAllPost.jsp"))
					req.setAttribute("listPost_Responses_ByPost_Id",postSvc.getPost_ResponsesByPost_Id(post_Id)); // 資料庫取出的list物件,存入request
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/post_Response/update_post_Response_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("insert".equals(action)) { // 來自addPost_Response.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
				

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String mem_Id = req.getParameter("mem_Id").trim();
				String post_Id = req.getParameter("post_Id").trim();

				//回覆文章內容錯誤判斷
				String post_Response_content = null;
				post_Response_content = new String(req.getParameter("post_Response_content").trim());
				if (post_Response_content.length() == 0) {
					errorMsgs.add("請輸入文章內容!");
				}
				
				java.sql.Date post_time = null;
				try {
					post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
				} catch (IllegalArgumentException e) {
					post_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				java.sql.Date post_Response_upDate = null;
				try {
					post_Response_upDate = java.sql.Date.valueOf(req.getParameter("post_Response_upDate").trim());
				} catch (IllegalArgumentException e) {
					post_Response_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入修改日期!");
				}
				
				Post_ResponseVO post_ResponseVO = new Post_ResponseVO();
				post_ResponseVO.setMem_Id(mem_Id);
				post_ResponseVO.setPost_Id(post_Id);
				post_ResponseVO.setPost_Response_content(post_Response_content);
				post_ResponseVO.setPost_time(post_time);
				post_ResponseVO.setPost_Response_upDate(post_Response_upDate);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("post_ResponseVO", post_ResponseVO); // 含有輸入格式錯誤的post_ResponseVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/post_Response/addPost_Response.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Post_ResponseService post_ResponseSvc = new Post_ResponseService();
				post_ResponseVO = post_ResponseSvc.addPost_Response(mem_Id, post_Id, post_Response_content, post_time, post_Response_upDate);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/post_Response/listAllPost_Response.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPost_Response.jsp
				successView.forward(req, res);		
			
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/post_Response/addPost_Response.jsp");
				failureView.forward(req, res);
			}
		}
		

		if ("delete".equals(action)) { // 來自listAllPost_Response.jsp或  /post/listPost_Responses_ByPost_Id.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/post_Response/listAllPost_Response.jsp】 或  【/post/listPost_Responses_ByPost_Id.jsp】 或 【 /post/listAllPost.jsp】		
			
			try {
				/***************************1.接收請求參數***************************************/
				String res_Id =new String(req.getParameter("res_Id"));
//				System.out.println(" res_Id : " + res_Id);
		
				/***************************2.開始刪除資料***************************************/
				Post_ResponseService post_ResponseSvc = new Post_ResponseService();
				Post_ResponseVO post_ResponseVO = post_ResponseSvc.getOnePost_Response(res_Id);
				post_ResponseSvc.deletePost_Response(res_Id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				PostService postSvc = new PostService();
				if(requestURL.equals("/post/listPost_Responses_ByPost_Id.jsp") || requestURL.equals("/post/listAllPost.jsp"))
					req.setAttribute("listPost_Responses_ByPost_Id",postSvc.getPost_ResponsesByPost_Id(post_ResponseVO.getPost_Id())); // 資料庫取出的list物件,存入request
				
				
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