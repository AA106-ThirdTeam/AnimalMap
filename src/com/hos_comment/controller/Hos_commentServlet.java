package com.hos_comment.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.vet_hospital.model.*;
import com.hos_comment.model.*;
/** 
 *表格名稱 : <br>
 *	中文:診所留言<br>
 *	英文:hos_comment<br>
 */ 
@WebServlet(urlPatterns = { "/hos_comment/hos_comment.do" })
public class Hos_commentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Hos_comment servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("hosComm_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入診所留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  hosComm_Id = null;
				try {
					hosComm_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("診所留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Hos_commentService hos_commentSvc = new Hos_commentService();
				Hos_commentVO hos_commentVO = hos_commentSvc.getOneHos_comment(hosComm_Id);
				if (hos_commentVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("hos_commentVO", hos_commentVO); 
				String url = "/hos_comment/listOneHos_comment.jsp";
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
				String  hosComm_Id = new String (req.getParameter("hosComm_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Hos_commentService hos_commentSvc = new Hos_commentService();
				Hos_commentVO hos_commentVO = hos_commentSvc.getOneHos_comment(hosComm_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("hos_commentVO", hos_commentVO); 
				String url = "/hos_comment/update_hos_comment_input.jsp";
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
				String hosComm_Id = req.getParameter("hosComm_Id").trim();
				String hosComm_MemId = req.getParameter("hosComm_MemId").trim();
				String hosComm_HosId = req.getParameter("hosComm_HosId").trim();
				String hosComm_content = req.getParameter("hosComm_content").trim();
				java.sql.Date hosComm_SendTime = null;
				try {
					hosComm_SendTime = java.sql.Date.valueOf(req.getParameter("hosComm_SendTime").trim());
				} catch (IllegalArgumentException e) {
					hosComm_SendTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				Hos_commentVO hos_commentVO = new Hos_commentVO();
				hos_commentVO.setHosComm_Id(hosComm_Id);
				hos_commentVO.setHosComm_MemId(hosComm_MemId);
				hos_commentVO.setHosComm_HosId(hosComm_HosId);
				hos_commentVO.setHosComm_content(hosComm_content);
				hos_commentVO.setHosComm_SendTime(hosComm_SendTime);
				if (!errorMsgs.isEmpty()) {
					String url = "/hos_comment/update_hos_comment_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Hos_commentService hos_commentSvc = new Hos_commentService();
				hos_commentVO = hos_commentSvc.updateHos_comment(hosComm_Id,hosComm_MemId,hosComm_HosId,hosComm_content,hosComm_SendTime);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("hos_commentVO", hos_commentVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hos_comment/update_hos_comment_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addHos_comment.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String hosComm_MemId = req.getParameter("hosComm_MemId").trim();
                String hosComm_HosId = req.getParameter("hosComm_HosId").trim();
                String hosComm_content = req.getParameter("hosComm_content").trim();
                java.sql.Date hosComm_SendTime = null;
                try {
                    hosComm_SendTime = java.sql.Date.valueOf(req.getParameter("hosComm_SendTime").trim());
                } catch (IllegalArgumentException e) {
                    hosComm_SendTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                Hos_commentVO hos_commentVO = new Hos_commentVO();
                hos_commentVO.setHosComm_MemId(hosComm_MemId);
                hos_commentVO.setHosComm_HosId(hosComm_HosId);
                hos_commentVO.setHosComm_content(hosComm_content);
                hos_commentVO.setHosComm_SendTime(hosComm_SendTime);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("hos_commentVO", hos_commentVO); // 含有輸入格式錯誤的hos_commentVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/hos_comment/addHos_comment.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Hos_commentService hos_commentSvc = new Hos_commentService();
                hos_commentVO = hos_commentSvc.addHos_comment(hosComm_MemId,hosComm_HosId,hosComm_content,hosComm_SendTime); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/hos_comment/listAllHos_comment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/hos_comment/addHos_comment.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllHos_comment.jsp 或  /dept/listHos_comments_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/hos_comment/listAllHos_comment.jsp】 或  【/dept/listHos_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /hos_comment/listHos_comments_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String hosComm_Id = new String(req.getParameter("hosComm_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Hos_commentService hos_commentSvc = new Hos_commentService();
                Hos_commentVO hos_commentVO = hos_commentSvc.getOneHos_comment(hosComm_Id);
   
                hos_commentSvc.deleteHos_comment(hosComm_Id);
             
                
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
