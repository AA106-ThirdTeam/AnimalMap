package com.emg_h_msg.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.emg_h.model.*;
import com.emg_h_msg.model.*;
/** 
 *表格名稱 : <br>
 *	中文:緊急求救留言<br>
 *	英文:emg_H_Msg<br>
 */ 
@WebServlet(urlPatterns = { "/emg_h_msg/emg_h_msg.do" })
public class Emg_H_MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Emg_H_Msg servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("emg_H_Msg_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入緊急求救留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  emg_H_Msg_Id = null;
				try {
					emg_H_Msg_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("緊急求救留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
				Emg_H_MsgVO emg_h_msgVO = emg_h_msgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);
				if (emg_h_msgVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_h_msgVO", emg_h_msgVO); 
				String url = "/emg_h_msg/listOneEmg_H_Msg.jsp";
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
				String  emg_H_Msg_Id = new String (req.getParameter("emg_H_Msg_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
				Emg_H_MsgVO emg_h_msgVO = emg_h_msgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_h_msgVO", emg_h_msgVO); 
				String url = "/emg_h_msg/update_emg_h_msg_input.jsp";
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
				String emg_H_Msg_Id = req.getParameter("emg_H_Msg_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String emg_H_Id = req.getParameter("emg_H_Id").trim();
				java.sql.Date emg_H_Msg_start = null;
				try {
					emg_H_Msg_start = java.sql.Date.valueOf(req.getParameter("emg_H_Msg_start").trim());
				} catch (IllegalArgumentException e) {
					emg_H_Msg_start=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String emg_H_Msg_content = req.getParameter("emg_H_Msg_content").trim();

				Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();
				emg_h_msgVO.setEmg_H_Msg_Id(emg_H_Msg_Id);
				emg_h_msgVO.setMem_Id(mem_Id);
				emg_h_msgVO.setEmg_H_Id(emg_H_Id);
				emg_h_msgVO.setEmg_H_Msg_start(emg_H_Msg_start);
				emg_h_msgVO.setEmg_H_Msg_content(emg_H_Msg_content);
				if (!errorMsgs.isEmpty()) {
					String url = "/emg_h_msg/update_emg_h_msg_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
				emg_h_msgVO = emg_h_msgSvc.updateEmg_H_Msg(emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_h_msgVO", emg_h_msgVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/emg_h_msg/update_emg_h_msg_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addEmg_H_Msg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                String emg_H_Id = req.getParameter("emg_H_Id").trim();
                java.sql.Date emg_H_Msg_start = null;
                try {
                    emg_H_Msg_start = java.sql.Date.valueOf(req.getParameter("emg_H_Msg_start").trim());
                } catch (IllegalArgumentException e) {
                    emg_H_Msg_start=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String emg_H_Msg_content = req.getParameter("emg_H_Msg_content").trim();

                Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();
                emg_h_msgVO.setMem_Id(mem_Id);
                emg_h_msgVO.setEmg_H_Id(emg_H_Id);
                emg_h_msgVO.setEmg_H_Msg_start(emg_H_Msg_start);
                emg_h_msgVO.setEmg_H_Msg_content(emg_H_Msg_content);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("emg_h_msgVO", emg_h_msgVO); // 含有輸入格式錯誤的emg_h_msgVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/emg_h_msg/addEmg_H_Msg.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
                emg_h_msgVO = emg_h_msgSvc.addEmg_H_Msg(mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/emg_h_msg/listAllEmg_H_Msg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/emg_h_msg/addEmg_H_Msg.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllEmg_H_Msg.jsp 或  /dept/listEmg_H_Msgs_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emg_h_msg/listAllEmg_H_Msg.jsp】 或  【/dept/listEmg_H_Msgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /emg_h_msg/listEmg_H_Msgs_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String emg_H_Msg_Id = new String(req.getParameter("emg_H_Msg_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Emg_H_MsgService emg_h_msgSvc = new Emg_H_MsgService();
                Emg_H_MsgVO emg_h_msgVO = emg_h_msgSvc.getOneEmg_H_Msg(emg_H_Msg_Id);
   
                emg_h_msgSvc.deleteEmg_H_Msg(emg_H_Msg_Id);
             
                
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
