package com.charge.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.charge.model.*;
/** 
 *表格名稱 : <br>
 *	中文:儲值<br>
 *	英文:charge<br>
 */ 
@WebServlet(urlPatterns = { "/charge/charge.do" })
public class ChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Charge servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("charge_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入儲值編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  charge_no = null;
				try {
					charge_no = new String (str);
				} catch (Exception e) {
					errorMsgs.add("儲值編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				ChargeService chargeSvc = new ChargeService();
				ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);
				if (chargeVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("chargeVO", chargeVO); 
				String url = "/charge/listOneCharge.jsp";
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
				String  charge_no = new String (req.getParameter("charge_no").trim());

				/***************************2.開始查詢資料*****************************************/
				ChargeService chargeSvc = new ChargeService();
				ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("chargeVO", chargeVO); 
				String url = "/charge/update_charge_input.jsp";
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
				String charge_no = req.getParameter("charge_no").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				Integer charge_NUMBER = new Integer(req.getParameter("charge_NUMBER").trim());
				Integer pay = new Integer(req.getParameter("pay").trim());
				java.sql.Date applytime = null;
				try {
					applytime = java.sql.Date.valueOf(req.getParameter("applytime").trim());
				} catch (IllegalArgumentException e) {
					applytime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				ChargeVO chargeVO = new ChargeVO();
				chargeVO.setCharge_no(charge_no);
				chargeVO.setMem_Id(mem_Id);
				chargeVO.setCharge_NUMBER(charge_NUMBER);
				chargeVO.setPay(pay);
				chargeVO.setApplytime(applytime);
				if (!errorMsgs.isEmpty()) {
					String url = "/charge/update_charge_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				ChargeService chargeSvc = new ChargeService();
				chargeVO = chargeSvc.updateCharge(charge_no,mem_Id,charge_NUMBER,pay,applytime);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("chargeVO", chargeVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/charge/update_charge_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addCharge.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                Integer charge_NUMBER = new Integer(req.getParameter("charge_NUMBER").trim());
                Integer pay = new Integer(req.getParameter("pay").trim());
                java.sql.Date applytime = null;
                try {
                    applytime = java.sql.Date.valueOf(req.getParameter("applytime").trim());
                } catch (IllegalArgumentException e) {
                    applytime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                ChargeVO chargeVO = new ChargeVO();
                chargeVO.setMem_Id(mem_Id);
                chargeVO.setCharge_NUMBER(charge_NUMBER);
                chargeVO.setPay(pay);
                chargeVO.setApplytime(applytime);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("chargeVO", chargeVO); // 含有輸入格式錯誤的chargeVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/charge/addCharge.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                ChargeService chargeSvc = new ChargeService();
                chargeVO = chargeSvc.addCharge(mem_Id,charge_NUMBER,pay,applytime); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/charge/listAllCharge.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/charge/addCharge.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllCharge.jsp 或  /dept/listCharges_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/charge/listAllCharge.jsp】 或  【/dept/listCharges_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /charge/listCharges_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String charge_no = new String(req.getParameter("charge_no"));

                
                /***************************2.開始刪除資料***************************************/
                ChargeService chargeSvc = new ChargeService();
                ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);
   
                chargeSvc.deleteCharge(charge_no);
             
                
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
