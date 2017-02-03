package com.offimsg.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.emp.model.*;
import com.offimsg.model.*;
/** 
 *表格名稱 : <br>
 *	中文:公告訊息<br>
 *	英文:offiMsg<br>
 */ 
@WebServlet(urlPatterns = { "/offimsg/offimsg.do" })
public class OffiMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("OffiMsg servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("offiMsg_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入訊息編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  offiMsg_Id = null;
				try {
					offiMsg_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("訊息編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				OffiMsgService offimsgSvc = new OffiMsgService();
				OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);
				if (offimsgVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("offimsgVO", offimsgVO); 
				String url = "/offimsg/listOneOffiMsg.jsp";
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
				String  offiMsg_Id = new String (req.getParameter("offiMsg_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				OffiMsgService offimsgSvc = new OffiMsgService();
				OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("offimsgVO", offimsgVO); 
				String url = "/offimsg/update_offimsg_input.jsp";
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
				String offiMsg_Id = req.getParameter("offiMsg_Id").trim();
				String offiMsg_empId = req.getParameter("offiMsg_empId").trim();
				String offiMsg_Title = req.getParameter("offiMsg_Title").trim();
				String offiMsg_Content = req.getParameter("offiMsg_Content").trim();
				java.sql.Date offiMsg_Date = null;
				try {
					offiMsg_Date = java.sql.Date.valueOf(req.getParameter("offiMsg_Date").trim());
				} catch (IllegalArgumentException e) {
					offiMsg_Date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				OffiMsgVO offimsgVO = new OffiMsgVO();
				offimsgVO.setOffiMsg_Id(offiMsg_Id);
				offimsgVO.setOffiMsg_empId(offiMsg_empId);
				offimsgVO.setOffiMsg_Title(offiMsg_Title);
				offimsgVO.setOffiMsg_Content(offiMsg_Content);
				offimsgVO.setOffiMsg_Date(offiMsg_Date);
				if (!errorMsgs.isEmpty()) {
					String url = "/offimsg/update_offimsg_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				OffiMsgService offimsgSvc = new OffiMsgService();
				offimsgVO = offimsgSvc.updateOffiMsg(offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,offiMsg_Date);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("offimsgVO", offimsgVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/offimsg/update_offimsg_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addOffiMsg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String offiMsg_empId = req.getParameter("offiMsg_empId").trim();
                String offiMsg_Title = req.getParameter("offiMsg_Title").trim();
                String offiMsg_Content = req.getParameter("offiMsg_Content").trim();
                java.sql.Date offiMsg_Date = null;
                try {
                    offiMsg_Date = java.sql.Date.valueOf(req.getParameter("offiMsg_Date").trim());
                } catch (IllegalArgumentException e) {
                    offiMsg_Date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                OffiMsgVO offimsgVO = new OffiMsgVO();
                offimsgVO.setOffiMsg_empId(offiMsg_empId);
                offimsgVO.setOffiMsg_Title(offiMsg_Title);
                offimsgVO.setOffiMsg_Content(offiMsg_Content);
                offimsgVO.setOffiMsg_Date(offiMsg_Date);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("offimsgVO", offimsgVO); // 含有輸入格式錯誤的offimsgVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/offimsg/addOffiMsg.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                OffiMsgService offimsgSvc = new OffiMsgService();
                offimsgVO = offimsgSvc.addOffiMsg(offiMsg_empId,offiMsg_Title,offiMsg_Content,offiMsg_Date); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/offimsg/listAllOffiMsg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/offimsg/addOffiMsg.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllOffiMsg.jsp 或  /dept/listOffiMsgs_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/offimsg/listAllOffiMsg.jsp】 或  【/dept/listOffiMsgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /offimsg/listOffiMsgs_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String offiMsg_Id = new String(req.getParameter("offiMsg_Id"));

                
                /***************************2.開始刪除資料***************************************/
                OffiMsgService offimsgSvc = new OffiMsgService();
                OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);
   
                offimsgSvc.deleteOffiMsg(offiMsg_Id);
             
                
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
