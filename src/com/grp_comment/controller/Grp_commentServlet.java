package com.grp_comment.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.pet_group.model.*;
import com.grp_comment.model.*;
/** 
 *表格名稱 : <br>
 *	中文:揪團留言<br>
 *	英文:grp_comment<br>
 */ 
@WebServlet(urlPatterns = { "/grp_comment/grp_comment.do" })
public class Grp_commentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Grp_comment servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("grpComment_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入揪團留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  grpComment_Id = null;
				try {
					grpComment_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("揪團留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Grp_commentService grp_commentSvc = new Grp_commentService();
				Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);
				if (grp_commentVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("grp_commentVO", grp_commentVO); 
				String url = "/grp_comment/listOneGrp_comment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		//====getOne_For_Update====
		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL"); 
			try {

				/***************************1.接收請求參數****************************************/
				String  grpComment_Id = new String (req.getParameter("grpComment_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Grp_commentService grp_commentSvc = new Grp_commentService();
				Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("grp_commentVO", grp_commentVO); 
				String url = "/grp_comment/update_grp_comment_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		//====update====
		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL"); 
			try {

				/***************************1.接收請求參數****************************************/
				String grpComment_Id = req.getParameter("grpComment_Id").trim();
				String grpComment_MemId = req.getParameter("grpComment_MemId").trim();
				String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
				String grpComment_content = req.getParameter("grpComment_content").trim();
				java.sql.Date grpComment_SendTime = null;
				try {
					grpComment_SendTime = java.sql.Date.valueOf(req.getParameter("grpComment_SendTime").trim());
				} catch (IllegalArgumentException e) {
					grpComment_SendTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				Grp_commentVO grp_commentVO = new Grp_commentVO();
				grp_commentVO.setGrpComment_Id(grpComment_Id);
				grp_commentVO.setGrpComment_MemId(grpComment_MemId);
				grp_commentVO.setGrpComment_GrpId(grpComment_GrpId);
				grp_commentVO.setGrpComment_content(grpComment_content);
				grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);
				if (!errorMsgs.isEmpty()) {
					String url = "/grp_comment/update_grp_comment_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Grp_commentService grp_commentSvc = new Grp_commentService();
				grp_commentVO = grp_commentSvc.updateGrp_comment(grpComment_Id,grpComment_MemId,grpComment_GrpId,grpComment_content,grpComment_SendTime);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("grp_commentVO", grp_commentVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/grp_comment/update_grp_comment_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addGrp_comment.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String grpComment_MemId = req.getParameter("grpComment_MemId").trim();
                String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
                String grpComment_content = req.getParameter("grpComment_content").trim();
                java.sql.Date grpComment_SendTime = null;
                try {
                    grpComment_SendTime = java.sql.Date.valueOf(req.getParameter("grpComment_SendTime").trim());
                } catch (IllegalArgumentException e) {
                    grpComment_SendTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                Grp_commentVO grp_commentVO = new Grp_commentVO();
                grp_commentVO.setGrpComment_MemId(grpComment_MemId);
                grp_commentVO.setGrpComment_GrpId(grpComment_GrpId);
                grp_commentVO.setGrpComment_content(grpComment_content);
                grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("grp_commentVO", grp_commentVO); // 含有輸入格式錯誤的grp_commentVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/grp_comment/addGrp_comment.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Grp_commentService grp_commentSvc = new Grp_commentService();
                grp_commentVO = grp_commentSvc.addGrp_comment(grpComment_MemId,grpComment_GrpId,grpComment_content,grpComment_SendTime); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/grp_comment/listAllGrp_comment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/grp_comment/addGrp_comment.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllGrp_comment.jsp 或  /dept/listGrp_comments_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/grp_comment/listAllGrp_comment.jsp】 或  【/dept/listGrp_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /grp_comment/listGrp_comments_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String grpComment_Id = new String(req.getParameter("grpComment_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Grp_commentService grp_commentSvc = new Grp_commentService();
                Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);
   
                grp_commentSvc.deleteGrp_comment(grpComment_Id);
             
                
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
}
