package com.shop_comment.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.petshop.model.*;
import com.shop_comment.model.*;
/** 
 *表格名稱 : <br>
 *	中文:商家留言<br>
 *	英文:shop_comment<br>
 */ 
@WebServlet(urlPatterns = { "/shop_comment/shop_comment.do" })
public class Shop_commentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Shop_comment servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("shopComm_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入診所留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  shopComm_Id = null;
				try {
					shopComm_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("診所留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Shop_commentService shop_commentSvc = new Shop_commentService();
				Shop_commentVO shop_commentVO = shop_commentSvc.getOneShop_comment(shopComm_Id);
				if (shop_commentVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("shop_commentVO", shop_commentVO); 
				String url = "/shop_comment/listOneShop_comment.jsp";
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
				String  shopComm_Id = new String (req.getParameter("shopComm_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Shop_commentService shop_commentSvc = new Shop_commentService();
				Shop_commentVO shop_commentVO = shop_commentSvc.getOneShop_comment(shopComm_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("shop_commentVO", shop_commentVO); 
				String url = "/shop_comment/update_shop_comment_input.jsp";
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
				String shopComm_Id = req.getParameter("shopComm_Id").trim();
				String shopComm_MemId = req.getParameter("shopComm_MemId").trim();
				String shopComm_ShopId = req.getParameter("shopComm_ShopId").trim();
				String shopComm_content = req.getParameter("shopComm_content").trim();
				java.sql.Date shopComm_SendTime = null;
				try {
					shopComm_SendTime = java.sql.Date.valueOf(req.getParameter("shopComm_SendTime").trim());
				} catch (IllegalArgumentException e) {
					shopComm_SendTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				Shop_commentVO shop_commentVO = new Shop_commentVO();
				shop_commentVO.setShopComm_Id(shopComm_Id);
				shop_commentVO.setShopComm_MemId(shopComm_MemId);
				shop_commentVO.setShopComm_ShopId(shopComm_ShopId);
				shop_commentVO.setShopComm_content(shopComm_content);
				shop_commentVO.setShopComm_SendTime(shopComm_SendTime);
				if (!errorMsgs.isEmpty()) {
					String url = "/shop_comment/update_shop_comment_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Shop_commentService shop_commentSvc = new Shop_commentService();
				shop_commentVO = shop_commentSvc.updateShop_comment(shopComm_Id,shopComm_MemId,shopComm_ShopId,shopComm_content,shopComm_SendTime);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("shop_commentVO", shop_commentVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/shop_comment/update_shop_comment_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addShop_comment.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String shopComm_MemId = req.getParameter("shopComm_MemId").trim();
                String shopComm_ShopId = req.getParameter("shopComm_ShopId").trim();
                String shopComm_content = req.getParameter("shopComm_content").trim();
                java.sql.Date shopComm_SendTime = null;
                try {
                    shopComm_SendTime = java.sql.Date.valueOf(req.getParameter("shopComm_SendTime").trim());
                } catch (IllegalArgumentException e) {
                    shopComm_SendTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                Shop_commentVO shop_commentVO = new Shop_commentVO();
                shop_commentVO.setShopComm_MemId(shopComm_MemId);
                shop_commentVO.setShopComm_ShopId(shopComm_ShopId);
                shop_commentVO.setShopComm_content(shopComm_content);
                shop_commentVO.setShopComm_SendTime(shopComm_SendTime);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("shop_commentVO", shop_commentVO); // 含有輸入格式錯誤的shop_commentVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/shop_comment/addShop_comment.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Shop_commentService shop_commentSvc = new Shop_commentService();
                shop_commentVO = shop_commentSvc.addShop_comment(shopComm_MemId,shopComm_ShopId,shopComm_content,shopComm_SendTime); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/shop_comment/listAllShop_comment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop_comment/addShop_comment.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllShop_comment.jsp 或  /dept/listShop_comments_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/shop_comment/listAllShop_comment.jsp】 或  【/dept/listShop_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /shop_comment/listShop_comments_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String shopComm_Id = new String(req.getParameter("shopComm_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Shop_commentService shop_commentSvc = new Shop_commentService();
                Shop_commentVO shop_commentVO = shop_commentSvc.getOneShop_comment(shopComm_Id);
   
                shop_commentSvc.deleteShop_comment(shopComm_Id);
             
                
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
