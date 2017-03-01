package com.product_kind.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.product_kind.model.*;
import com.product.model.*;

public class Product_kindServlet extends HttpServlet {

	// 課本Pg30 doGet
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		
		// 來自select_page.jsp的請求                                  // 來自 product_kind/listAllProduct_kind.jsp的請求
				if ("listProducts_ByProduct_kind_no_A".equals(action) || "listProducts_ByProduct_kind_no_B".equals(action)) {

					List<String> errorMsgs = new LinkedList<String>();
					req.setAttribute("errorMsgs", errorMsgs);
					
					try {
						/*************************** 1.接收請求參數 ****************************************/
						String product_kind_no = req.getParameter("product_kind_no");
						/*************************** 2.開始查詢資料 ****************************************/
						Product_kindService product_kindSvc = new Product_kindService();
						Set<ProductVO> set = product_kindSvc.getProductsByProduct_kind_no(product_kind_no);

						/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
						req.setAttribute("listProducts_ByProduct_kind_no", set);    // 資料庫取出的list物件,存入request

						String url = null;
						if ("listProducts_ByProduct_kind_no_A".equals(action))
							url = "/back-end/product_kind/listProducts_ByProduct_kind_no.jsp";        // 成功轉交 product_kind/listProducts_ByProduct_kind_no.jsp
						else if ("listProducts_ByProduct_kind_no_B".equals(action))
							url = "/back-end/product_kind/listAllProduct_kind.jsp";              // 成功轉交 product_kind/listAllProduct_kind.jsp

						RequestDispatcher successView = req.getRequestDispatcher(url);
						successView.forward(req, res);

						/*************************** 其他可能的錯誤處理 ***********************************/
					} catch (Exception e) {
						throw new ServletException(e);
					}
				}
				if ("delete_Product_kind".equals(action)) { // 來自/dept/listAllDept.jsp的請求

					List<String> errorMsgs = new LinkedList<String>();
					req.setAttribute("errorMsgs", errorMsgs);
			
					try {
						/***************************1.接收請求參數***************************************/
						String product_kind_no = new String(req.getParameter("product_kind_no"));
						
						/***************************2.開始刪除資料***************************************/
						Product_kindService product_kindSvc = new Product_kindService();
						product_kindSvc.deleteProduct_kind(product_kind_no);
						
						/***************************3.刪除完成,準備轉交(Send the Success view)***********/
						String url = "/back-end/product_kind/listAllProduct_kind.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後, 成功轉交 回到 /product_kind/listAllProduct.jsp
						successView.forward(req, res);
						
						/***************************其他可能的錯誤處理***********************************/
					} catch (Exception e) {
						errorMsgs.add("刪除資料失敗:"+e.getMessage());
						RequestDispatcher failureView = req
								.getRequestDispatcher("/back-end/dept/listAllProduct_kind.jsp");
						failureView.forward(req, res);
					}
				}

			}
		}