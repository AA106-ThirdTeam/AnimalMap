package com.second_prodmsg.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.second_prod.model.*;
import com.mem.model.*;
import com.second_prodmsg.model.*;
/** 
 *表格名稱 : <br>
 *	中文:二手商品留言<br>
 *	英文:second_ProdMsg<br>
 */ 
@WebServlet(urlPatterns = { "/second_prodmsg/second_prodmsg.do" })
public class Second_ProdMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Second_ProdMsg servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("second_ProdMsg_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入二手商品留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  second_ProdMsg_Id = null;
				try {
					second_ProdMsg_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("二手商品留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
				Second_ProdMsgVO second_prodmsgVO = second_prodmsgSvc.getOneSecond_ProdMsg(second_ProdMsg_Id);
				if (second_prodmsgVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodmsgVO", second_prodmsgVO); 
				String url = "/second_prodmsg/listOneSecond_ProdMsg.jsp";
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
				String  second_ProdMsg_Id = new String (req.getParameter("second_ProdMsg_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
				Second_ProdMsgVO second_prodmsgVO = second_prodmsgSvc.getOneSecond_ProdMsg(second_ProdMsg_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodmsgVO", second_prodmsgVO); 
				String url = "/second_prodmsg/update_second_prodmsg_input.jsp";
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
				String second_ProdMsg_Id = req.getParameter("second_ProdMsg_Id").trim();
				String second_Prod_Id = req.getParameter("second_Prod_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String second_ProdMsg_Msg = req.getParameter("second_ProdMsg_Msg").trim();
				java.sql.Date second_ProdMsg_DATE = null;
				try {
					second_ProdMsg_DATE = java.sql.Date.valueOf(req.getParameter("second_ProdMsg_DATE").trim());
				} catch (IllegalArgumentException e) {
					second_ProdMsg_DATE=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date second_ProdMsg_adp_upDate = null;
				try {
					second_ProdMsg_adp_upDate = java.sql.Date.valueOf(req.getParameter("second_ProdMsg_adp_upDate").trim());
				} catch (IllegalArgumentException e) {
					second_ProdMsg_adp_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();
				second_prodmsgVO.setSecond_ProdMsg_Id(second_ProdMsg_Id);
				second_prodmsgVO.setSecond_Prod_Id(second_Prod_Id);
				second_prodmsgVO.setMem_Id(mem_Id);
				second_prodmsgVO.setSecond_ProdMsg_Msg(second_ProdMsg_Msg);
				second_prodmsgVO.setSecond_ProdMsg_DATE(second_ProdMsg_DATE);
				second_prodmsgVO.setSecond_ProdMsg_adp_upDate(second_ProdMsg_adp_upDate);
				if (!errorMsgs.isEmpty()) {
					String url = "/second_prodmsg/update_second_prodmsg_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
				second_prodmsgVO = second_prodmsgSvc.updateSecond_ProdMsg(second_ProdMsg_Id,second_Prod_Id,mem_Id,second_ProdMsg_Msg,second_ProdMsg_DATE,second_ProdMsg_adp_upDate);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodmsgVO", second_prodmsgVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/second_prodmsg/update_second_prodmsg_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addSecond_ProdMsg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String second_Prod_Id = req.getParameter("second_Prod_Id").trim();
                String mem_Id = req.getParameter("mem_Id").trim();
                String second_ProdMsg_Msg = req.getParameter("second_ProdMsg_Msg").trim();
                java.sql.Date second_ProdMsg_DATE = null;
                try {
                    second_ProdMsg_DATE = java.sql.Date.valueOf(req.getParameter("second_ProdMsg_DATE").trim());
                } catch (IllegalArgumentException e) {
                    second_ProdMsg_DATE=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date second_ProdMsg_adp_upDate = null;
                try {
                    second_ProdMsg_adp_upDate = java.sql.Date.valueOf(req.getParameter("second_ProdMsg_adp_upDate").trim());
                } catch (IllegalArgumentException e) {
                    second_ProdMsg_adp_upDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();
                second_prodmsgVO.setSecond_Prod_Id(second_Prod_Id);
                second_prodmsgVO.setMem_Id(mem_Id);
                second_prodmsgVO.setSecond_ProdMsg_Msg(second_ProdMsg_Msg);
                second_prodmsgVO.setSecond_ProdMsg_DATE(second_ProdMsg_DATE);
                second_prodmsgVO.setSecond_ProdMsg_adp_upDate(second_ProdMsg_adp_upDate);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("second_prodmsgVO", second_prodmsgVO); // 含有輸入格式錯誤的second_prodmsgVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/second_prodmsg/addSecond_ProdMsg.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
                second_prodmsgVO = second_prodmsgSvc.addSecond_ProdMsg(second_Prod_Id,mem_Id,second_ProdMsg_Msg,second_ProdMsg_DATE,second_ProdMsg_adp_upDate); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/second_prodmsg/listAllSecond_ProdMsg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/second_prodmsg/addSecond_ProdMsg.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllSecond_ProdMsg.jsp 或  /dept/listSecond_ProdMsgs_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/second_prodmsg/listAllSecond_ProdMsg.jsp】 或  【/dept/listSecond_ProdMsgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /second_prodmsg/listSecond_ProdMsgs_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String second_ProdMsg_Id = new String(req.getParameter("second_ProdMsg_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
                Second_ProdMsgVO second_prodmsgVO = second_prodmsgSvc.getOneSecond_ProdMsg(second_ProdMsg_Id);
   
                second_prodmsgSvc.deleteSecond_ProdMsg(second_ProdMsg_Id);
             
                
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
