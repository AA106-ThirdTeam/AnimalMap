package com.adp.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.adp.model.*;
/** 
 *表格名稱 : <br>
 *	中文:領養活動<br>
 *	英文:adp<br>
 */ 
@WebServlet(urlPatterns = { "/adp/adp.do" })
public class AdpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Adp servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("adp_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入領養活動編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  adp_Id = null;
				try {
					adp_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("領養活動編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				AdpService adpSvc = new AdpService();
				AdpVO adpVO = adpSvc.getOneAdp(adp_Id);
				if (adpVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpVO", adpVO); 
				String url = "/adp/listOneAdp.jsp";
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
				String  adp_Id = new String (req.getParameter("adp_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				AdpService adpSvc = new AdpService();
				AdpVO adpVO = adpSvc.getOneAdp(adp_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpVO", adpVO); 
				String url = "/adp/update_adp_input.jsp";
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
				String adp_Id = req.getParameter("adp_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String adp_title = req.getParameter("adp_title").trim();
				String adp_adp_content = req.getParameter("adp_adp_content").trim();
				java.sql.Date adp_start_date = null;
				try {
					adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
				} catch (IllegalArgumentException e) {
					adp_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date adp_end_date = null;
				try {
					adp_end_date = java.sql.Date.valueOf(req.getParameter("adp_end_date").trim());
				} catch (IllegalArgumentException e) {
					adp_end_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date adp_upDate = null;
				try {
					adp_upDate = java.sql.Date.valueOf(req.getParameter("adp_upDate").trim());
				} catch (IllegalArgumentException e) {
					adp_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String adp_city = req.getParameter("adp_city").trim();
				String adp_town = req.getParameter("adp_town").trim();
				String adp_road = req.getParameter("adp_road").trim();
				Double adp_lon = null;
				try {
					adp_lon = new Double(req.getParameter("adp_lon").trim());
				} catch (NumberFormatException e) {
					adp_lon = 0.0;
					errorMsgs.add("領養活動經度座標請填數字.");
				}
				Double adp_lat = null;
				try {
					adp_lat = new Double(req.getParameter("adp_lat").trim());
				} catch (NumberFormatException e) {
					adp_lat = 0.0;
					errorMsgs.add("緯度座標緯度座標請填數字.");
				}

				AdpVO adpVO = new AdpVO();
				adpVO.setAdp_Id(adp_Id);
				adpVO.setMem_Id(mem_Id);
				adpVO.setAdp_title(adp_title);
				adpVO.setAdp_adp_content(adp_adp_content);
				adpVO.setAdp_start_date(adp_start_date);
				adpVO.setAdp_end_date(adp_end_date);
				adpVO.setAdp_upDate(adp_upDate);
				adpVO.setAdp_city(adp_city);
				adpVO.setAdp_town(adp_town);
				adpVO.setAdp_road(adp_road);
				adpVO.setAdp_lon(adp_lon);
				adpVO.setAdp_lat(adp_lat);
				if (!errorMsgs.isEmpty()) {
					String url = "/adp/update_adp_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				AdpService adpSvc = new AdpService();
				adpVO = adpSvc.updateAdp(adp_Id,mem_Id,adp_title,adp_adp_content,adp_start_date,adp_end_date,adp_upDate,adp_city,adp_town,adp_road,adp_lon,adp_lat);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpVO", adpVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/adp/update_adp_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addAdp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                String adp_title = req.getParameter("adp_title").trim();
                String adp_adp_content = req.getParameter("adp_adp_content").trim();
                java.sql.Date adp_start_date = null;
                try {
                    adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
                } catch (IllegalArgumentException e) {
                    adp_start_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date adp_end_date = null;
                try {
                    adp_end_date = java.sql.Date.valueOf(req.getParameter("adp_end_date").trim());
                } catch (IllegalArgumentException e) {
                    adp_end_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date adp_upDate = null;
                try {
                    adp_upDate = java.sql.Date.valueOf(req.getParameter("adp_upDate").trim());
                } catch (IllegalArgumentException e) {
                    adp_upDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String adp_city = req.getParameter("adp_city").trim();
                String adp_town = req.getParameter("adp_town").trim();
                String adp_road = req.getParameter("adp_road").trim();
                Double adp_lon = null;
                try {
                    adp_lon = new Double(req.getParameter("adp_lon").trim());
                } catch (NumberFormatException e) {
                    adp_lon = 0.0;
                    errorMsgs.add("領養活動經度座標請填數字.");
                    e.printStackTrace();
                }
                Double adp_lat = null;
                try {
                    adp_lat = new Double(req.getParameter("adp_lat").trim());
                } catch (NumberFormatException e) {
                    adp_lat = 0.0;
                    errorMsgs.add("緯度座標緯度座標請填數字.");
                    e.printStackTrace();
                }

                AdpVO adpVO = new AdpVO();
                adpVO.setMem_Id(mem_Id);
                adpVO.setAdp_title(adp_title);
                adpVO.setAdp_adp_content(adp_adp_content);
                adpVO.setAdp_start_date(adp_start_date);
                adpVO.setAdp_end_date(adp_end_date);
                adpVO.setAdp_upDate(adp_upDate);
                adpVO.setAdp_city(adp_city);
                adpVO.setAdp_town(adp_town);
                adpVO.setAdp_road(adp_road);
                adpVO.setAdp_lon(adp_lon);
                adpVO.setAdp_lat(adp_lat);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("adpVO", adpVO); // 含有輸入格式錯誤的adpVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/adp/addAdp.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                AdpService adpSvc = new AdpService();
                adpVO = adpSvc.addAdp(mem_Id,adp_title,adp_adp_content,adp_start_date,adp_end_date,adp_upDate,adp_city,adp_town,adp_road,adp_lon,adp_lat); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/adp/listAllAdp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/adp/addAdp.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllAdp.jsp 或  /dept/listAdps_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/adp/listAllAdp.jsp】 或  【/dept/listAdps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /adp/listAdps_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String adp_Id = new String(req.getParameter("adp_Id"));

                
                /***************************2.開始刪除資料***************************************/
                AdpService adpSvc = new AdpService();
                AdpVO adpVO = adpSvc.getOneAdp(adp_Id);
   
                adpSvc.deleteAdp(adp_Id);
             
                
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
