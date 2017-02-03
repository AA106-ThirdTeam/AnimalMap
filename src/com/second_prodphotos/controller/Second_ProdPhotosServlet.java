package com.second_prodphotos.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.second_prod.model.*;
import com.second_prodphotos.model.*;
/** 
 *表格名稱 : <br>
 *	中文:二手商品相簿<br>
 *	英文:second_ProdPhotos<br>
 */ 
@WebServlet(urlPatterns = { "/second_prodphotos/second_prodphotos.do" })
public class Second_ProdPhotosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Second_ProdPhotos servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("second_ProdPhotos_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入二手商品相簿編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  second_ProdPhotos_Id = null;
				try {
					second_ProdPhotos_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("二手商品相簿編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
				Second_ProdPhotosVO second_prodphotosVO = second_prodphotosSvc.getOneSecond_ProdPhotos(second_ProdPhotos_Id);
				if (second_prodphotosVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodphotosVO", second_prodphotosVO); 
				String url = "/second_prodphotos/listOneSecond_ProdPhotos.jsp";
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
				String  second_ProdPhotos_Id = new String (req.getParameter("second_ProdPhotos_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
				Second_ProdPhotosVO second_prodphotosVO = second_prodphotosSvc.getOneSecond_ProdPhotos(second_ProdPhotos_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodphotosVO", second_prodphotosVO); 
				String url = "/second_prodphotos/update_second_prodphotos_input.jsp";
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
				String second_ProdPhotos_Id = req.getParameter("second_ProdPhotos_Id").trim();
				String second_Prod_Id = req.getParameter("second_Prod_Id").trim();

				Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
				second_prodphotosVO.setSecond_ProdPhotos_Id(second_ProdPhotos_Id);
				second_prodphotosVO.setSecond_Prod_Id(second_Prod_Id);
				if (!errorMsgs.isEmpty()) {
					String url = "/second_prodphotos/update_second_prodphotos_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
				second_prodphotosVO = second_prodphotosSvc.updateSecond_ProdPhotos(second_ProdPhotos_Id,second_Prod_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodphotosVO", second_prodphotosVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/second_prodphotos/update_second_prodphotos_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addSecond_ProdPhotos.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String second_Prod_Id = req.getParameter("second_Prod_Id").trim();

                Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
                second_prodphotosVO.setSecond_Prod_Id(second_Prod_Id);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("second_prodphotosVO", second_prodphotosVO); // 含有輸入格式錯誤的second_prodphotosVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/second_prodphotos/addSecond_ProdPhotos.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
                second_prodphotosVO = second_prodphotosSvc.addSecond_ProdPhotos(second_Prod_Id); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/second_prodphotos/listAllSecond_ProdPhotos.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/second_prodphotos/addSecond_ProdPhotos.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllSecond_ProdPhotos.jsp 或  /dept/listSecond_ProdPhotoss_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/second_prodphotos/listAllSecond_ProdPhotos.jsp】 或  【/dept/listSecond_ProdPhotoss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /second_prodphotos/listSecond_ProdPhotoss_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String second_ProdPhotos_Id = new String(req.getParameter("second_ProdPhotos_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
                Second_ProdPhotosVO second_prodphotosVO = second_prodphotosSvc.getOneSecond_ProdPhotos(second_ProdPhotos_Id);
   
                second_prodphotosSvc.deleteSecond_ProdPhotos(second_ProdPhotos_Id);
             
                
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
