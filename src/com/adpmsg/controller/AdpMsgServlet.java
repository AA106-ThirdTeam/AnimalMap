package com.adpmsg.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.adp.model.*;
import com.mem.model.*;
import com.adpmsg.model.*;
/** 
 *表格名稱 : <br>
 *	中文:領養活動留言<br>
 *	英文:adpMsg<br>
 */ 
@WebServlet(urlPatterns = { "/adpmsg/adpmsg.do" })
public class AdpMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("AdpMsg servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("adpMsg_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入領養活動留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  adpMsg_Id = null;
				try {
					adpMsg_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("領養活動留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				AdpMsgService adpmsgSvc = new AdpMsgService();
				AdpMsgVO adpmsgVO = adpmsgSvc.getOneAdpMsg(adpMsg_Id);
				if (adpmsgVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpmsgVO", adpmsgVO); 
				String url = "/adpmsg/listOneAdpMsg.jsp";
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
				String  adpMsg_Id = new String (req.getParameter("adpMsg_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				AdpMsgService adpmsgSvc = new AdpMsgService();
				AdpMsgVO adpmsgVO = adpmsgSvc.getOneAdpMsg(adpMsg_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpmsgVO", adpmsgVO); 
				String url = "/adpmsg/update_adpmsg_input.jsp";
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
				String adpMsg_Id = req.getParameter("adpMsg_Id").trim();
				String adp_Id = req.getParameter("adp_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String msg = req.getParameter("msg").trim();
				java.sql.Date adpMsgDate = null;
				try {
					adpMsgDate = java.sql.Date.valueOf(req.getParameter("adpMsgDate").trim());
				} catch (IllegalArgumentException e) {
					adpMsgDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date adpMsgadp_upDate = null;
				try {
					adpMsgadp_upDate = java.sql.Date.valueOf(req.getParameter("adpMsgadp_upDate").trim());
				} catch (IllegalArgumentException e) {
					adpMsgadp_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				AdpMsgVO adpmsgVO = new AdpMsgVO();
				adpmsgVO.setAdpMsg_Id(adpMsg_Id);
				adpmsgVO.setAdp_Id(adp_Id);
				adpmsgVO.setMem_Id(mem_Id);
				adpmsgVO.setMsg(msg);
				adpmsgVO.setAdpMsgDate(adpMsgDate);
				adpmsgVO.setAdpMsgadp_upDate(adpMsgadp_upDate);
				if (!errorMsgs.isEmpty()) {
					String url = "/adpmsg/update_adpmsg_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				AdpMsgService adpmsgSvc = new AdpMsgService();
				adpmsgVO = adpmsgSvc.updateAdpMsg(adpMsg_Id,adp_Id,mem_Id,msg,adpMsgDate,adpMsgadp_upDate);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpmsgVO", adpmsgVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/adpmsg/update_adpmsg_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addAdpMsg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String adp_Id = req.getParameter("adp_Id").trim();
                String mem_Id = req.getParameter("mem_Id").trim();
                String msg = req.getParameter("msg").trim();
                java.sql.Date adpMsgDate = null;
                try {
                    adpMsgDate = java.sql.Date.valueOf(req.getParameter("adpMsgDate").trim());
                } catch (IllegalArgumentException e) {
                    adpMsgDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date adpMsgadp_upDate = null;
                try {
                    adpMsgadp_upDate = java.sql.Date.valueOf(req.getParameter("adpMsgadp_upDate").trim());
                } catch (IllegalArgumentException e) {
                    adpMsgadp_upDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                AdpMsgVO adpmsgVO = new AdpMsgVO();
                adpmsgVO.setAdp_Id(adp_Id);
                adpmsgVO.setMem_Id(mem_Id);
                adpmsgVO.setMsg(msg);
                adpmsgVO.setAdpMsgDate(adpMsgDate);
                adpmsgVO.setAdpMsgadp_upDate(adpMsgadp_upDate);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("adpmsgVO", adpmsgVO); // 含有輸入格式錯誤的adpmsgVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/adpmsg/addAdpMsg.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                AdpMsgService adpmsgSvc = new AdpMsgService();
                adpmsgVO = adpmsgSvc.addAdpMsg(adp_Id,mem_Id,msg,adpMsgDate,adpMsgadp_upDate); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/adpmsg/listAllAdpMsg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/adpmsg/addAdpMsg.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllAdpMsg.jsp 或  /dept/listAdpMsgs_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/adpmsg/listAllAdpMsg.jsp】 或  【/dept/listAdpMsgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /adpmsg/listAdpMsgs_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String adpMsg_Id = new String(req.getParameter("adpMsg_Id"));

                
                /***************************2.開始刪除資料***************************************/
                AdpMsgService adpmsgSvc = new AdpMsgService();
                AdpMsgVO adpmsgVO = adpmsgSvc.getOneAdpMsg(adpMsg_Id);
   
                adpmsgSvc.deleteAdpMsg(adpMsg_Id);
             
                
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
