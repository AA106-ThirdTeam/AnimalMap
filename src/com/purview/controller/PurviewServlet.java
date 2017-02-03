package com.purview.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.purview.model.*;
/** 
 *表格名稱 : <br>
 *	中文:權限<br>
 *	英文:purview<br>
 */ 
@WebServlet(urlPatterns = { "/purview/purview.do" })
public class PurviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Purview servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("purview_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入權限編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  purview_No = null;
				try {
					purview_No = new String (str);
				} catch (Exception e) {
					errorMsgs.add("權限編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				PurviewService purviewSvc = new PurviewService();
				PurviewVO purviewVO = purviewSvc.getOnePurview(purview_No);
				if (purviewVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("purviewVO", purviewVO); 
				String url = "/purview/listOnePurview.jsp";
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
				String  purview_No = new String (req.getParameter("purview_No").trim());

				/***************************2.開始查詢資料*****************************************/
				PurviewService purviewSvc = new PurviewService();
				PurviewVO purviewVO = purviewSvc.getOnePurview(purview_No);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("purviewVO", purviewVO); 
				String url = "/purview/update_purview_input.jsp";
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
				String purview_No = req.getParameter("purview_No").trim();
				String pruview_name = req.getParameter("pruview_name").trim();

				PurviewVO purviewVO = new PurviewVO();
				purviewVO.setPurview_No(purview_No);
				purviewVO.setPruview_name(pruview_name);
				if (!errorMsgs.isEmpty()) {
					String url = "/purview/update_purview_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				PurviewService purviewSvc = new PurviewService();
				purviewVO = purviewSvc.updatePurview(purview_No,pruview_name);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("purviewVO", purviewVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/purview/update_purview_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addPurview.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String pruview_name = req.getParameter("pruview_name").trim();

                PurviewVO purviewVO = new PurviewVO();
                purviewVO.setPruview_name(pruview_name);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("purviewVO", purviewVO); // 含有輸入格式錯誤的purviewVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/purview/addPurview.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                PurviewService purviewSvc = new PurviewService();
                purviewVO = purviewSvc.addPurview(pruview_name); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/purview/listAllPurview.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/purview/addPurview.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllPurview.jsp 或  /dept/listPurviews_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/purview/listAllPurview.jsp】 或  【/dept/listPurviews_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /purview/listPurviews_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String purview_No = new String(req.getParameter("purview_No"));

                
                /***************************2.開始刪除資料***************************************/
                PurviewService purviewSvc = new PurviewService();
                PurviewVO purviewVO = purviewSvc.getOnePurview(purview_No);
   
                purviewSvc.deletePurview(purview_No);
             
                
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
