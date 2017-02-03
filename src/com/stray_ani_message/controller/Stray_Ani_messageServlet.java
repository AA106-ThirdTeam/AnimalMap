package com.stray_ani_message.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.stray_ani.model.*;
import com.mem.model.*;
import com.stray_ani_message.model.*;
/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物留言<br>
 *	英文:stray_Ani_message<br>
 */ 
@WebServlet(urlPatterns = { "/stray_ani_message/stray_ani_message.do" })
public class Stray_Ani_messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Stray_Ani_message servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("str_Ani_Mes_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入流浪動物留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  str_Ani_Mes_No = null;
				try {
					str_Ani_Mes_No = new String (str);
				} catch (Exception e) {
					errorMsgs.add("流浪動物留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
				Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);
				if (stray_ani_messageVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); 
				String url = "/stray_ani_message/listOneStray_Ani_message.jsp";
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
				String  str_Ani_Mes_No = new String (req.getParameter("str_Ani_Mes_No").trim());

				/***************************2.開始查詢資料*****************************************/
				Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
				Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); 
				String url = "/stray_ani_message/update_stray_ani_message_input.jsp";
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
				String str_Ani_Mes_No = req.getParameter("str_Ani_Mes_No").trim();
				String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				java.sql.Date str_Ani_Mes_time = null;
				try {
					str_Ani_Mes_time = java.sql.Date.valueOf(req.getParameter("str_Ani_Mes_time").trim());
				} catch (IllegalArgumentException e) {
					str_Ani_Mes_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String str_Ani_Mes = req.getParameter("str_Ani_Mes").trim();

				Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
				stray_ani_messageVO.setStr_Ani_Mes_No(str_Ani_Mes_No);
				stray_ani_messageVO.setStray_Ani_Id(stray_Ani_Id);
				stray_ani_messageVO.setMem_Id(mem_Id);
				stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
				stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);
				if (!errorMsgs.isEmpty()) {
					String url = "/stray_ani_message/update_stray_ani_message_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
				stray_ani_messageVO = stray_ani_messageSvc.updateStray_Ani_message(str_Ani_Mes_No,stray_Ani_Id,mem_Id,str_Ani_Mes_time,str_Ani_Mes);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/stray_ani_message/update_stray_ani_message_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addStray_Ani_message.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();
                String mem_Id = req.getParameter("mem_Id").trim();
                java.sql.Date str_Ani_Mes_time = null;
                try {
                    str_Ani_Mes_time = java.sql.Date.valueOf(req.getParameter("str_Ani_Mes_time").trim());
                } catch (IllegalArgumentException e) {
                    str_Ani_Mes_time=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String str_Ani_Mes = req.getParameter("str_Ani_Mes").trim();

                Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
                stray_ani_messageVO.setStray_Ani_Id(stray_Ani_Id);
                stray_ani_messageVO.setMem_Id(mem_Id);
                stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
                stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); // 含有輸入格式錯誤的stray_ani_messageVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/stray_ani_message/addStray_Ani_message.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
                stray_ani_messageVO = stray_ani_messageSvc.addStray_Ani_message(stray_Ani_Id,mem_Id,str_Ani_Mes_time,str_Ani_Mes); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/stray_ani_message/listAllStray_Ani_message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/stray_ani_message/addStray_Ani_message.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllStray_Ani_message.jsp 或  /dept/listStray_Ani_messages_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/stray_ani_message/listAllStray_Ani_message.jsp】 或  【/dept/listStray_Ani_messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /stray_ani_message/listStray_Ani_messages_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String str_Ani_Mes_No = new String(req.getParameter("str_Ani_Mes_No"));

                
                /***************************2.開始刪除資料***************************************/
                Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
                Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);
   
                stray_ani_messageSvc.deleteStray_Ani_message(str_Ani_Mes_No);
             
                
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
