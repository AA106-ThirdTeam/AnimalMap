package com.orders.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.orders.model.*;
/** 
 *表格名稱 : <br>
 *	中文:訂單<br>
 *	英文:orders<br>
 */ 
@WebServlet(urlPatterns = { "/orders/orders.do" })
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Orders servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("orders_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入訂單編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  orders_no = null;
				try {
					orders_no = new String (str);
				} catch (Exception e) {
					errorMsgs.add("訂單編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				OrdersService ordersSvc = new OrdersService();
				OrdersVO ordersVO = ordersSvc.getOneOrders(orders_no);
				if (ordersVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("ordersVO", ordersVO); 
				String url = "/orders/listOneOrders.jsp";
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
				String  orders_no = new String (req.getParameter("orders_no").trim());

				/***************************2.開始查詢資料*****************************************/
				OrdersService ordersSvc = new OrdersService();
				OrdersVO ordersVO = ordersSvc.getOneOrders(orders_no);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("ordersVO", ordersVO); 
				String url = "/orders/update_orders_input.jsp";
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
				String orders_no = req.getParameter("orders_no").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String orders_receiver = req.getParameter("orders_receiver").trim();
				String post_no = req.getParameter("post_no").trim();
				String post_adp_city = req.getParameter("post_adp_city").trim();
				String post_town = req.getParameter("post_town").trim();
				String post_road = req.getParameter("post_road").trim();
				Integer orders_phone = new Integer(req.getParameter("orders_phone").trim());
				Integer collect_mode_no = new Integer(req.getParameter("collect_mode_no").trim());
				java.sql.Date orders_date = null;
				try {
					orders_date = java.sql.Date.valueOf(req.getParameter("orders_date").trim());
				} catch (IllegalArgumentException e) {
					orders_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date orders_ship_date = null;
				try {
					orders_ship_date = java.sql.Date.valueOf(req.getParameter("orders_ship_date").trim());
				} catch (IllegalArgumentException e) {
					orders_ship_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				Integer orders_total = new Integer(req.getParameter("orders_total").trim());
				Integer orders_status = new Integer(req.getParameter("orders_status").trim());
				Integer orders_credit = new Integer(req.getParameter("orders_credit").trim());

				OrdersVO ordersVO = new OrdersVO();
				ordersVO.setOrders_no(orders_no);
				ordersVO.setMem_Id(mem_Id);
				ordersVO.setOrders_receiver(orders_receiver);
				ordersVO.setPost_no(post_no);
				ordersVO.setPost_adp_city(post_adp_city);
				ordersVO.setPost_town(post_town);
				ordersVO.setPost_road(post_road);
				ordersVO.setOrders_phone(orders_phone);
				ordersVO.setCollect_mode_no(collect_mode_no);
				ordersVO.setOrders_date(orders_date);
				ordersVO.setOrders_ship_date(orders_ship_date);
				ordersVO.setOrders_total(orders_total);
				ordersVO.setOrders_status(orders_status);
				ordersVO.setOrders_credit(orders_credit);
				if (!errorMsgs.isEmpty()) {
					String url = "/orders/update_orders_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				OrdersService ordersSvc = new OrdersService();
				ordersVO = ordersSvc.updateOrders(orders_no,mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,orders_date,orders_ship_date,orders_total,orders_status,orders_credit);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("ordersVO", ordersVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/orders/update_orders_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addOrders.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                String orders_receiver = req.getParameter("orders_receiver").trim();
                String post_no = req.getParameter("post_no").trim();
                String post_adp_city = req.getParameter("post_adp_city").trim();
                String post_town = req.getParameter("post_town").trim();
                String post_road = req.getParameter("post_road").trim();
                Integer orders_phone = new Integer(req.getParameter("orders_phone").trim());
                Integer collect_mode_no = new Integer(req.getParameter("collect_mode_no").trim());
                java.sql.Date orders_date = null;
                try {
                    orders_date = java.sql.Date.valueOf(req.getParameter("orders_date").trim());
                } catch (IllegalArgumentException e) {
                    orders_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date orders_ship_date = null;
                try {
                    orders_ship_date = java.sql.Date.valueOf(req.getParameter("orders_ship_date").trim());
                } catch (IllegalArgumentException e) {
                    orders_ship_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                Integer orders_total = new Integer(req.getParameter("orders_total").trim());
                Integer orders_status = new Integer(req.getParameter("orders_status").trim());
                Integer orders_credit = new Integer(req.getParameter("orders_credit").trim());

                OrdersVO ordersVO = new OrdersVO();
                ordersVO.setMem_Id(mem_Id);
                ordersVO.setOrders_receiver(orders_receiver);
                ordersVO.setPost_no(post_no);
                ordersVO.setPost_adp_city(post_adp_city);
                ordersVO.setPost_town(post_town);
                ordersVO.setPost_road(post_road);
                ordersVO.setOrders_phone(orders_phone);
                ordersVO.setCollect_mode_no(collect_mode_no);
                ordersVO.setOrders_date(orders_date);
                ordersVO.setOrders_ship_date(orders_ship_date);
                ordersVO.setOrders_total(orders_total);
                ordersVO.setOrders_status(orders_status);
                ordersVO.setOrders_credit(orders_credit);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("ordersVO", ordersVO); // 含有輸入格式錯誤的ordersVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/orders/addOrders.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                OrdersService ordersSvc = new OrdersService();
                ordersVO = ordersSvc.addOrders(mem_Id,orders_receiver,post_no,post_adp_city,post_town,post_road,orders_phone,collect_mode_no,orders_date,orders_ship_date,orders_total,orders_status,orders_credit); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/orders/listAllOrders.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/orders/addOrders.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllOrders.jsp 或  /dept/listOrderss_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/orders/listAllOrders.jsp】 或  【/dept/listOrderss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /orders/listOrderss_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String orders_no = new String(req.getParameter("orders_no"));

                
                /***************************2.開始刪除資料***************************************/
                OrdersService ordersSvc = new OrdersService();
                OrdersVO ordersVO = ordersSvc.getOneOrders(orders_no);
   
                ordersSvc.deleteOrders(orders_no);
             
                
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
