package com.orders.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.orders_item.model.*;
import com.shopping.model.CartVO;
import com.orders.model.*;

public class OrdersServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
//一：查詢=============================================================
		if("listOrders_items_ByOrders_no_A".equals(action) || "listOrders_items_ByOrders_no_B".equals(action)){
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/*************************** 1.接收請求參數 ****************************************/
				String orders_no = req.getParameter("orders_no");
				/*************************** 2.開始查詢資料 ****************************************/
				OrdersService ordersSvc = new OrdersService();
				Set<Orders_itemVO> set = ordersSvc.getOrders_itemByOrders_no(orders_no);
				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("listOrders_item", set);    // 資料庫取出的list物件,存入request
				
				String url = null;
				if ("listOrders_items_ByOrders_no_A".equals(action))
					url = "/front-end/orders/listOrders_item.jsp";        // 成功轉交 product_kind/listProducts_ByProduct_kind_no.jsp
				else if ("listOrders_items_ByOrders_no_B".equals(action))
					url = "/front-end/orders/listMyOrders.jsp"; // 成功轉交 product_kind/listAllProduct_kind.jsp
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				/*************************** 其他可能的錯誤處理 ***********************************/
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
//一：delete=============================================================
		if ("delete_Orders".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				/***************************1.接收請求參數***************************************/
				String orders_no = req.getParameter("orders_no");
				/***************************2.開始刪除資料***************************************/
				OrdersService ordersSvc = new OrdersService();
				ordersSvc.deleteOrders(orders_no);
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/orders/listAllOrders.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後, 成功轉交 回到 /product_kind/listAllProduct.jsp
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理***********************************/
			} catch(Exception e) {
				errorMsgs .add("刪除資料失敗："+e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orders/listAllOrders.jsp");
				failureView.forward(req, res);
			}
		}
//三、insert=============================================================

		if ("insertNewOrd".equals(action)){
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println("insertNewOrd");
			
//			try{
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)req.getSession().getAttribute("account");
//				//建立svc
//				heibernate_com.mem.model.MemDAO dao = new heibernate_com.mem.model.MemDAO();
				
//				String mem_id = account.getMem_Id();
//				System.out.println("mem_id===================" + mem_id);
				String mem_id = req.getParameter("mem_id").trim();
				String orders_receiver = req.getParameter("orders_receiver").trim();
				String post_no = req.getParameter("post_no").trim();
				String post_adp_city = req.getParameter("post_adp_city").trim();
				String post_town = req.getParameter("post_town").trim();
				String post_road = req.getParameter("post_road").trim();
				String orders_phone = req.getParameter("orders_phone").trim();
				
//				String product_no = req.getParameter("product_no").trim();
//				Integer commodities_amount = new Integer(req.getParameter("commodities_amount").trim());
//				Integer selling_price = new Integer(req.getParameter("selling_price").trim());

				//付款方式
				Integer collect_mode_no = null;
				try{
					collect_mode_no = new Integer (req.getParameter("collect_mode_no").trim());
				}catch (NumberFormatException e) {
					e.printStackTrace();
					collect_mode_no = 0;
					errorMsgs.add("請填入數字");
				}
				
				java.sql.Date orders_date = null;		
				try{
					orders_date =  java.sql.Date.valueOf(req.getParameter("orders_date").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					orders_date = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				java.sql.Date orders_ship_date = null;		
				try{
					orders_ship_date =  java.sql.Date.valueOf(req.getParameter("orders_ship_date").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					orders_ship_date = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				Integer orders_total = new Integer (req.getParameter("orders_total").trim());
				Integer orders_status = new Integer (req.getParameter("orders_status").trim());
				Integer orders_credit = new Integer (req.getParameter("orders_credit").trim());

				Vector<CartVO> cartlist = (Vector<CartVO>) req.getSession().getAttribute("shoppingcart");
				OrdersVO ordersVO = new OrdersVO();
				ordersVO.setMem_id(mem_id);
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
				
//				Orders_itemVO orders_itemVO = new Orders_itemVO();
//				orders_itemVO.setProduct_no(product_no);
//				orders_itemVO.setCommodities_amount(commodities_amount);
//				orders_itemVO.setSelling_price(selling_price);
				
				
				if(!errorMsgs.isEmpty()){
					req.setAttribute("ordersVO", ordersVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/orders/addProduct.jsp");
					failureView.forward(req, res);
					return;
				}
				
				
				/***************************2.開始新增資料***************************************/
				OrdersService ordersSvc = new OrdersService();
				System.out.println(mem_id + orders_receiver+post_no+post_adp_city+post_town+post_road+orders_phone+collect_mode_no+orders_date+orders_ship_date+orders_total+orders_status+orders_credit+cartlist);
				ordersVO = ordersSvc.addnewOrders(mem_id, orders_receiver, post_no, post_adp_city, post_town, post_road, orders_phone, collect_mode_no, orders_date, orders_ship_date, orders_total, orders_status, orders_credit,cartlist);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/front-end/orders/listMyOrders.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				cartlist.removeAllElements();//清空
				successView.forward(req, res);
				/***************************其他可能的錯誤處理**********************************/

//			} catch (Exception e) {
////				e.printStackTrace();
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/front-end/product/Checkout.jsp");
//				failureView.forward(req, res);
//			}	
		}
	}
}