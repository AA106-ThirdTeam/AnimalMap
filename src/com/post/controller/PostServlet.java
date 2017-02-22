package com.post.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.post.model.*;
import com.post_Response.model.*;

public class PostServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		System.out.println("action:" + action);
		// 來自select_page.jsp的請求 // 來自 post/listAllPost.jsp的請求
		if ("listPost_Responses_ByPost_Id_A".equals(action) || "listPost_Responses_ByPost_Id_B".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*************************** 1.接收請求參數 ****************************************/
				String post_Id = (String) req.getParameter("post_Id");
				System.out.println(post_Id);

				/*************************** 2.開始查詢資料 ****************************************/
				PostService postSvc = new PostService();
				Set<Post_ResponseVO> set = postSvc.getPost_ResponsesByPost_Id(post_Id);
				// System.out.println("1");
				/***************************
				 * 3.查詢完成,準備轉交(Send the Success view)
				 ************/
				req.setAttribute("listPost_Responses_ByPost_Id", set); // 資料庫取出的set物件,存入request
				req.setAttribute("post_Id", post_Id);
				String url = null;
				if ("listPost_Responses_ByPost_Id_A".equals(action))
					url = "/post/listAllPost.jsp"; // 成功轉交
												// post/listPost_Responses_ByPost_Id.jsp
				else if ("listPost_Responses_ByPost_Id_B".equals(action))
					url = "/post/listPost_Responses_ByPost_Id.jsp"; // 成功轉交 post/listAllPost.jsp
				System.out.println(url);
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 ***********************************/
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		if ("delete_Post".equals(action)) { // 來自/post/listAllPost.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				String post_Id = new String(req.getParameter("post_Id"));

				/*************************** 2.開始刪除資料 ***************************************/
				PostService postSvc = new PostService();
				postSvc.deletePost(post_Id);

				/**************************** 3.刪除完成,準備轉交(Send the Success view)***********/
				String url = "/post/listAllPost.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,
																				// 成功轉交
																				// 回到
																				// /dept/listAllDept.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 ***********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/post/listAllPost.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/**************************** 1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("post_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請選擇文章編號!");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
				String post_Id = null;
				try {
					post_Id = new String(str);
				} catch (Exception e) {
					errorMsgs.add("文章編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
				/*************************** 2.開始查詢資料 *****************************************/
				PostService postSvc = new PostService();
				PostVO postVO = postSvc.getOnePost(post_Id);
				if (postVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
				/**************************** 3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("postVO", postVO); // 資料庫取出的empVO物件,存入req
				String url = "/post/listPost_Responses_ByPost_Id.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOnePost.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllPost.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/post_Response/listAllPost_Response.jsp】 或  【/post/listPost_Responses_ByPost_Id.jsp】 或 【 /post/listAllPost.jsp】		

			try {
				/***************************1.接收請求參數****************************************/
				String post_Id =new String(req.getParameter("post_Id"));
				
				/***************************2.開始查詢資料****************************************/
				PostService postSvc = new PostService();
				PostVO postVO = postSvc.getOnePost(post_Id);
				
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("postVO", postVO);     // 資料庫取出的postVO物件,存入req
				String url = "/post/update_post_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_post_input.jsp
				successView.forward(req, res);
				
				System.out.print("");
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
		
		
		if("update".equals(action)){	//來自update_post_input.jsp的請求
			System.out.println("action: "+ action);
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println("errorMsgs: "+errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); 
			
//			try{
			/**************************** 1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String post_Id =req.getParameter("post_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				
				
				String post_class_Id$post_class = req.getParameter("post_class_Id$post_class").trim();
				String post_class = post_class_Id$post_class.split("-")[1];
				String post_class_Id =post_class_Id$post_class.split("-")[0];
				System.out.println("post_class_Id$post_class:"+post_class_Id$post_class);
				
				//post_title文章標題錯誤判斷
				String post_title = null;
				post_title = new String(req.getParameter("post_title").trim());
				if(post_title.length() == 0) {
					errorMsgs.add("請輸入文章標題!");
				}
				System.out.println("post_title : "+post_title);
				
				//post_content文章內容錯誤判斷
				String post_content = null;
				post_content = new String(req.getParameter("post_content").trim());
				if(post_content.length() == 0){
					errorMsgs.add("請輸入文章內容!");
				}
				System.out.println("post_content : "+post_content);
				
				//post_time發布日期錯誤判斷
				java.sql.Date post_time = null;
				try{
					post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
				}catch (IllegalArgumentException e) {
						post_time = new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請輸入文章發佈日期!");
				} 
				System.out.println("time:"+ post_time);
				
				//post_upDate修改日期錯誤判斷
				java.sql.Date post_upDate = null;
				try {
					post_upDate = java.sql.Date.valueOf(req.getParameter("post_upDate").trim());
				} catch (IllegalArgumentException e) {
					post_upDate = new java.sql.Date(System.currentTimeMillis());	//取得現在時間!
					errorMsgs.add("請輸入修改日期!");
				}
				System.out.println("upDate: "+ post_upDate);
				
				Integer post_resNum = new Integer(req.getParameter("post_resNum").trim());
				System.out.println("res_Num:"+post_resNum);
				
				PostVO postVO = new PostVO();
				postVO.setPost_Id(post_Id);
				postVO.setMem_Id(mem_Id);
				postVO.setPost_class(post_class);
				postVO.setPost_class_Id(post_class_Id);
				postVO.setPost_title(post_title);
				postVO.setPost_content(post_content);
				postVO.setPost_time(post_time);
				postVO.setPost_upDate(post_upDate);
				postVO.setPost_resNum(post_resNum);
			
			if(!errorMsgs.isEmpty()){
				req.setAttribute("postVO", postVO);	//含有輸入格是錯誤postVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/post/update_post_input.jsp");
				failureView.forward(req, res);
				return;
				
			}
			
			/*************************** 2.開始查詢資料 *****************************************/
			PostService postSvc = new PostService();
			postVO = postSvc.updatePost(post_Id, mem_Id, post_class, post_class_Id, post_title, post_content,
					post_time, post_upDate, post_resNum);
	
			/**************************** 3.刪除完成,準備轉交(Send the Success view)***********/
			Post_ResponseService post_ResponseSvc = new Post_ResponseService();
			if(requestURL.equals("/post/listPost_Responses_ByPost_Id.jsp") || requestURL.equals("/post/listAllPost.jsp"))
				req.setAttribute("listPost_Responses_ByPost_Id",postSvc.getPost_ResponsesByPost_Id(post_Id)); // 資料庫取出的list物件,存入request
            
			
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);	//新增成功後轉交listAllPost.jsp
			successView.forward(req, res);
			/*************************** 其他可能的錯誤處理 *************************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得資料:" + e.getMessage());
//				RequestDispatcher failureView = req.getRequestDispatcher("/post/update_post_input.jsp");
//				failureView.forward(req, res);
//			}
		}
		
		
		
		
		
		
		
		
		if("insert".equals(action)){	//來自addPost.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println("errorMsgs:"+errorMsgs);
			
			try{
			/**************************** 1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String mem_Id = req.getParameter("mem_Id").trim();
			System.out.println("mem_Id:"+ mem_Id);
			
			String post_class_Id$post_class = req.getParameter("post_class_Id$post_class").trim();
			String post_class = post_class_Id$post_class.split("-")[1];
			String post_class_Id =post_class_Id$post_class.split("-")[0];
			System.out.println("post_class_Id$post_class:"+post_class_Id$post_class);
			
			//post_title文章標題錯誤判斷
			String post_title = null;
			post_title = new String(req.getParameter("post_title").trim());
			if(post_title.length() == 0) {
				errorMsgs.add("請輸入文章標題!");
			}
			System.out.println("post_title : "+post_title);
			
			//post_content文章內容錯誤判斷
			String post_content = null;
			post_content = new String(req.getParameter("post_content").trim());
			if(post_content.length() == 0){
				errorMsgs.add("請輸入文章內容!");
			}
			System.out.println("post_content : "+post_content);
			
			//post_time發布日期錯誤判斷
			java.sql.Date post_time = null;
			try{
				post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
			}catch (IllegalArgumentException e) {
					// TODO: handle exception
					post_time = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入文章發佈日期!");
			} 
			System.out.println("time:"+ post_time);
			
			//post_upDate修改日期錯誤判斷
			java.sql.Date post_upDate = null;
			try {
				post_upDate = java.sql.Date.valueOf(req.getParameter("post_upDate").trim());
			} catch (IllegalArgumentException e) {
				// TODO: handle exception
				post_upDate = new java.sql.Date(System.currentTimeMillis());	//取得現在時間!
				errorMsgs.add("請輸入修改日期!");
			}
			System.out.println("upDate: "+ post_upDate);
			
			Integer post_resNum = new Integer(req.getParameter("post_resNum").trim());
			System.out.println("res_Num:"+post_resNum);
			
			PostVO postVO = new PostVO();
			postVO.setMem_Id(mem_Id);
			postVO.setPost_class(post_class);
			postVO.setPost_class_Id(post_class_Id);
			postVO.setPost_title(post_title);
			postVO.setPost_content(post_content);
			postVO.setPost_time(post_time);
			postVO.setPost_upDate(post_upDate);
			postVO.setPost_resNum(post_resNum);
			
			 System.out.println("4");
			// Send the use back to the form, if there were errors
			if(!errorMsgs.isEmpty()){
				req.setAttribute("postVO", postVO);	//含有輸入格是錯誤postVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("post/addPost.jsp");
				failureView.forward(req, res);
				return;
				
			}
			System.out.println("dddd");
			
			/*************************** 2.開始查詢資料 *****************************************/
			PostService postSvc = new PostService();
			postVO = postSvc.addPost(mem_Id, post_class, post_class_Id, post_title, post_content,
					post_time,post_upDate ,post_resNum);
			
			/**************************** 3.刪除完成,準備轉交(Send the Success view)***********/
			String url = "/post/listAllPost.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);	//新增成功後轉交listAllPost.jsp
			successView.forward(req, res);
			/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/post/addPost.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("delete".equals(action)) { // 來自listAllPost_Response.jsp或  /post/listPost_Responses_ByPost_Id.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL");  // 送出修改的來源網頁路徑: 可能為【/post_Response/listAllPost_Response.jsp】 或  【/post/listPost_Responses_ByPost_Id.jsp】 或 【 /post/listAllPost.jsp】		
			
			try {
				/***************************1.接收請求參數***************************************/
				String post_Id =new String(req.getParameter("post_Id"));
		
				/***************************2.開始刪除資料***************************************/
				PostService postSvc = new PostService();
				PostVO postVO = postSvc.getOnePost(post_Id);
				postSvc.deletePost(post_Id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				Post_ResponseService post_ResponseSvc = new Post_ResponseService();
				if(requestURL.equals("/post/listPost_Responses_ByPost_Id.jsp") || requestURL.equals("/post/listAllPost.jsp"))
					req.setAttribute("listPost_Responses_ByPost_Id",postSvc.getPost_ResponsesByPost_Id(postVO.getPost_Id())); // 資料庫取出的list物件,存入request
				
				
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
