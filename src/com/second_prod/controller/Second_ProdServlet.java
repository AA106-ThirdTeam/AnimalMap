package com.second_prod.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.second_prod.model.*;
/** 
 *表格名稱 : <br>
 *	中文:二手商品<br>
 *	英文:second_Prod<br>
 */ 
@WebServlet(urlPatterns = { "/second_prod/second_prod.do" })
public class Second_ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Second_Prod servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("second_Prod_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入二手商品編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  second_Prod_Id = null;
				try {
					second_Prod_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("二手商品編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Second_ProdService second_prodSvc = new Second_ProdService();
				Second_ProdVO second_prodVO = second_prodSvc.getOneSecond_Prod(second_Prod_Id);
				if (second_prodVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodVO", second_prodVO); 
				String url = "/second_prod/listOneSecond_Prod.jsp";
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
				String  second_Prod_Id = new String (req.getParameter("second_Prod_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Second_ProdService second_prodSvc = new Second_ProdService();
				Second_ProdVO second_prodVO = second_prodSvc.getOneSecond_Prod(second_Prod_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodVO", second_prodVO); 
				String url = "/second_prod/update_second_prod_input.jsp";
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
				String second_Prod_Id = req.getParameter("second_Prod_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String second_Prod_Title = req.getParameter("second_Prod_Title").trim();
				String second_Prod_Content = req.getParameter("second_Prod_Content").trim();
				java.sql.Date second_Prod_adp_start_date = null;
				try {
					second_Prod_adp_start_date = java.sql.Date.valueOf(req.getParameter("second_Prod_adp_start_date").trim());
				} catch (IllegalArgumentException e) {
					second_Prod_adp_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date second_Prod_adp_end_date = null;
				try {
					second_Prod_adp_end_date = java.sql.Date.valueOf(req.getParameter("second_Prod_adp_end_date").trim());
				} catch (IllegalArgumentException e) {
					second_Prod_adp_end_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date second_Prod_adp_upDate = null;
				try {
					second_Prod_adp_upDate = java.sql.Date.valueOf(req.getParameter("second_Prod_adp_upDate").trim());
				} catch (IllegalArgumentException e) {
					second_Prod_adp_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String second_Prod_adp_city = req.getParameter("second_Prod_adp_city").trim();
				String second_Prod_Town = req.getParameter("second_Prod_Town").trim();
				String second_Prod_Road = req.getParameter("second_Prod_Road").trim();
				Double second_Prod_Lon = null;
				try {
					second_Prod_Lon = new Double(req.getParameter("second_Prod_Lon").trim());
				} catch (NumberFormatException e) {
					second_Prod_Lon = 0.0;
					errorMsgs.add("二手商品經度座標請填數字.");
				}
				Double second_Prod_Lat = null;
				try {
					second_Prod_Lat = new Double(req.getParameter("second_Prod_Lat").trim());
				} catch (NumberFormatException e) {
					second_Prod_Lat = 0.0;
					errorMsgs.add("緯度座標緯度座標請填數字.");
				}

				Second_ProdVO second_prodVO = new Second_ProdVO();
				second_prodVO.setSecond_Prod_Id(second_Prod_Id);
				second_prodVO.setMem_Id(mem_Id);
				second_prodVO.setSecond_Prod_Title(second_Prod_Title);
				second_prodVO.setSecond_Prod_Content(second_Prod_Content);
				second_prodVO.setSecond_Prod_adp_start_date(second_Prod_adp_start_date);
				second_prodVO.setSecond_Prod_adp_end_date(second_Prod_adp_end_date);
				second_prodVO.setSecond_Prod_adp_upDate(second_Prod_adp_upDate);
				second_prodVO.setSecond_Prod_adp_city(second_Prod_adp_city);
				second_prodVO.setSecond_Prod_Town(second_Prod_Town);
				second_prodVO.setSecond_Prod_Road(second_Prod_Road);
				second_prodVO.setSecond_Prod_Lon(second_Prod_Lon);
				second_prodVO.setSecond_Prod_Lat(second_Prod_Lat);
				if (!errorMsgs.isEmpty()) {
					String url = "/second_prod/update_second_prod_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Second_ProdService second_prodSvc = new Second_ProdService();
				second_prodVO = second_prodSvc.updateSecond_Prod(second_Prod_Id,mem_Id,second_Prod_Title,second_Prod_Content,second_Prod_adp_start_date,second_Prod_adp_end_date,second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodVO", second_prodVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/second_prod/update_second_prod_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addSecond_Prod.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                String second_Prod_Title = req.getParameter("second_Prod_Title").trim();
                String second_Prod_Content = req.getParameter("second_Prod_Content").trim();
                java.sql.Date second_Prod_adp_start_date = null;
                try {
                    second_Prod_adp_start_date = java.sql.Date.valueOf(req.getParameter("second_Prod_adp_start_date").trim());
                } catch (IllegalArgumentException e) {
                    second_Prod_adp_start_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date second_Prod_adp_end_date = null;
                try {
                    second_Prod_adp_end_date = java.sql.Date.valueOf(req.getParameter("second_Prod_adp_end_date").trim());
                } catch (IllegalArgumentException e) {
                    second_Prod_adp_end_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date second_Prod_adp_upDate = null;
                try {
                    second_Prod_adp_upDate = java.sql.Date.valueOf(req.getParameter("second_Prod_adp_upDate").trim());
                } catch (IllegalArgumentException e) {
                    second_Prod_adp_upDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String second_Prod_adp_city = req.getParameter("second_Prod_adp_city").trim();
                String second_Prod_Town = req.getParameter("second_Prod_Town").trim();
                String second_Prod_Road = req.getParameter("second_Prod_Road").trim();
                Double second_Prod_Lon = null;
                try {
                    second_Prod_Lon = new Double(req.getParameter("second_Prod_Lon").trim());
                } catch (NumberFormatException e) {
                    second_Prod_Lon = 0.0;
                    errorMsgs.add("二手商品經度座標請填數字.");
                    e.printStackTrace();
                }
                Double second_Prod_Lat = null;
                try {
                    second_Prod_Lat = new Double(req.getParameter("second_Prod_Lat").trim());
                } catch (NumberFormatException e) {
                    second_Prod_Lat = 0.0;
                    errorMsgs.add("緯度座標緯度座標請填數字.");
                    e.printStackTrace();
                }

                Second_ProdVO second_prodVO = new Second_ProdVO();
                second_prodVO.setMem_Id(mem_Id);
                second_prodVO.setSecond_Prod_Title(second_Prod_Title);
                second_prodVO.setSecond_Prod_Content(second_Prod_Content);
                second_prodVO.setSecond_Prod_adp_start_date(second_Prod_adp_start_date);
                second_prodVO.setSecond_Prod_adp_end_date(second_Prod_adp_end_date);
                second_prodVO.setSecond_Prod_adp_upDate(second_Prod_adp_upDate);
                second_prodVO.setSecond_Prod_adp_city(second_Prod_adp_city);
                second_prodVO.setSecond_Prod_Town(second_Prod_Town);
                second_prodVO.setSecond_Prod_Road(second_Prod_Road);
                second_prodVO.setSecond_Prod_Lon(second_Prod_Lon);
                second_prodVO.setSecond_Prod_Lat(second_Prod_Lat);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("second_prodVO", second_prodVO); // 含有輸入格式錯誤的second_prodVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/second_prod/addSecond_Prod.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Second_ProdService second_prodSvc = new Second_ProdService();
                second_prodVO = second_prodSvc.addSecond_Prod(mem_Id,second_Prod_Title,second_Prod_Content,second_Prod_adp_start_date,second_Prod_adp_end_date,second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/second_prod/listAllSecond_Prod.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/second_prod/addSecond_Prod.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllSecond_Prod.jsp 或  /dept/listSecond_Prods_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/second_prod/listAllSecond_Prod.jsp】 或  【/dept/listSecond_Prods_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /second_prod/listSecond_Prods_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String second_Prod_Id = new String(req.getParameter("second_Prod_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Second_ProdService second_prodSvc = new Second_ProdService();
                Second_ProdVO second_prodVO = second_prodSvc.getOneSecond_Prod(second_Prod_Id);
   
                second_prodSvc.deleteSecond_Prod(second_Prod_Id);
             
                
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
