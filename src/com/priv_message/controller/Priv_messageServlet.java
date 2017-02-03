package com.priv_message.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.mem.model.*;
import com.priv_message.model.*;
/** 
 *表格名稱 : <br>
 *	中文:私人訊息<br>
 *	英文:priv_message<br>
 */ 
@WebServlet(urlPatterns = { "/priv_message/priv_message.do" })
public class Priv_messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Priv_message servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("privMes_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入訊息編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  privMes_Id = null;
				try {
					privMes_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("訊息編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Priv_messageService priv_messageSvc = new Priv_messageService();
				Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMes_Id);
				if (priv_messageVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("priv_messageVO", priv_messageVO); 
				String url = "/priv_message/listOnePriv_message.jsp";
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
				String  privMes_Id = new String (req.getParameter("privMes_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Priv_messageService priv_messageSvc = new Priv_messageService();
				Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMes_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("priv_messageVO", priv_messageVO); 
				String url = "/priv_message/update_priv_message_input.jsp";
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
				String privMes_Id = req.getParameter("privMes_Id").trim();
				String privMesSend_MemId = req.getParameter("privMesSend_MemId").trim();
				String privMesRec_MemId = req.getParameter("privMesRec_MemId").trim();
				String privMes_content = req.getParameter("privMes_content").trim();
				java.sql.Date privMes_SendTime = null;
				try {
					privMes_SendTime = java.sql.Date.valueOf(req.getParameter("privMes_SendTime").trim());
				} catch (IllegalArgumentException e) {
					privMes_SendTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String privMes_type = req.getParameter("privMes_type").trim();

				Priv_messageVO priv_messageVO = new Priv_messageVO();
				priv_messageVO.setPrivMes_Id(privMes_Id);
				priv_messageVO.setPrivMesSend_MemId(privMesSend_MemId);
				priv_messageVO.setPrivMesRec_MemId(privMesRec_MemId);
				priv_messageVO.setPrivMes_content(privMes_content);
				priv_messageVO.setPrivMes_SendTime(privMes_SendTime);
				priv_messageVO.setPrivMes_type(privMes_type);
				if (!errorMsgs.isEmpty()) {
					String url = "/priv_message/update_priv_message_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Priv_messageService priv_messageSvc = new Priv_messageService();
				priv_messageVO = priv_messageSvc.updatePriv_message(privMes_Id,privMesSend_MemId,privMesRec_MemId,privMes_content,privMes_SendTime,privMes_type);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("priv_messageVO", priv_messageVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/priv_message/update_priv_message_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addPriv_message.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String privMesSend_MemId = req.getParameter("privMesSend_MemId").trim();
                String privMesRec_MemId = req.getParameter("privMesRec_MemId").trim();
                String privMes_content = req.getParameter("privMes_content").trim();
                java.sql.Date privMes_SendTime = null;
                try {
                    privMes_SendTime = java.sql.Date.valueOf(req.getParameter("privMes_SendTime").trim());
                } catch (IllegalArgumentException e) {
                    privMes_SendTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String privMes_type = req.getParameter("privMes_type").trim();

                Priv_messageVO priv_messageVO = new Priv_messageVO();
                priv_messageVO.setPrivMesSend_MemId(privMesSend_MemId);
                priv_messageVO.setPrivMesRec_MemId(privMesRec_MemId);
                priv_messageVO.setPrivMes_content(privMes_content);
                priv_messageVO.setPrivMes_SendTime(privMes_SendTime);
                priv_messageVO.setPrivMes_type(privMes_type);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("priv_messageVO", priv_messageVO); // 含有輸入格式錯誤的priv_messageVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/priv_message/addPriv_message.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Priv_messageService priv_messageSvc = new Priv_messageService();
                priv_messageVO = priv_messageSvc.addPriv_message(privMesSend_MemId,privMesRec_MemId,privMes_content,privMes_SendTime,privMes_type); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/priv_message/listAllPriv_message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/priv_message/addPriv_message.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllPriv_message.jsp 或  /dept/listPriv_messages_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/priv_message/listAllPriv_message.jsp】 或  【/dept/listPriv_messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /priv_message/listPriv_messages_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String privMes_Id = new String(req.getParameter("privMes_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Priv_messageService priv_messageSvc = new Priv_messageService();
                Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMes_Id);
   
                priv_messageSvc.deletePriv_message(privMes_Id);
             
                
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
