package com.product.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.product_kind.model.Product_kindService;
import com.product.model.*;

public class ProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
//一：查詢=============================================================
		
		if("getOne_For_Display".equals(action)){  //來自select_page的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/

				String str = req.getParameter("product_no");
				if (str == null || (str.trim()).length() == 0 ){
					errorMsgs.add("輸入商品編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String product_no = null;
				try {
					product_no = new String(str);
				} catch (Exception e) {
					errorMsgs.add("格式不正確");
				}
				// Send the use back to the form, if there were errors				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				ProductService productSvc = new ProductService();
				ProductVO productVO = productSvc.getOneProduct(product_no);
				if(productVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("productVO", productVO);//資料庫取出VO物件存入req
				String url = "/back-end/product/listOneProduct.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/select_page.jsp");
				failureView.forward(req, res);
			}
		}
//二、Update=============================================================
		if ("getOne_For_Update".equals(action)){//來自listAllProduct.jsp或  /product_kind/listProducts_ByProduct_kind_no.jsp 的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
			
			try{
				/***************************1.接收請求參數****************************************/
				String product_no = req.getParameter("product_no");
				
				/***************************2.開始查詢資料****************************************/
				ProductService productSvc = new ProductService();
				ProductVO productVO = productSvc.getOneProduct(product_no);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("productVO", productVO);//資料庫取出productVO物件.存入req
				String url = "/back-end/product/update_product_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emp_input.jsp
				successView.forward(req, res);
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
//三、Update=============================================================
		
		if("update".equals(action)) {// 來自update_product_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /emp/listEmps_ByCompositeQuery.jsp】
			
				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String product_no = req.getParameter("product_no").trim();
					String product_name =req.getParameter("product_name").trim();
					String product_introduction = req.getParameter("product_introduction").trim();
					
					//商品價格
					Integer product_price = null;
					try{
						product_price = new Integer(req.getParameter("product_price").trim());
					} catch (NumberFormatException e){
						product_price = 0;
						errorMsgs.add("商品價格請填數字.");
					}
					//商品庫存量
					Integer product_stock = null;
					try{
						product_stock = new Integer(req.getParameter("product_stock").trim());
					} catch (NumberFormatException e){
						product_stock = 0;
						errorMsgs.add("商品庫存量請填數字.");
					}

					//商品圖片
					String product_picture_large = req.getParameter("product_picture_large");
					//商品圖片（縮圖）
					String product_picture_small = req.getParameter("product_picture_small");
					
					//商品上下架狀態
					Integer product_status = null;
					try{
						product_status = new Integer(req.getParameter("product_status").trim());
					} catch (NumberFormatException e){
						product_status = 0;
						errorMsgs.add("上下架狀態請填數字.");
					}
					
					//商品建立日期
					java.sql.Date product_create_date = null;
					try {
						product_create_date = java.sql.Date.valueOf(req.getParameter("product_create_date").trim());
					} catch (IllegalArgumentException e) {
						product_create_date=new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
					}
					
					//商品資訊
					String product_info = req.getParameter("product_info");
					
					String product_kind_no = req.getParameter("product_kind_no").trim();

					ProductVO productVO = new ProductVO();
					productVO.setProduct_no(product_no);
					productVO.setProduct_name(product_name);
					productVO.setProduct_introduction(product_introduction);
					productVO.setProduct_price(product_price);
					productVO.setProduct_stock(product_stock);
					productVO.setProduct_picture_large(product_picture_large);
					productVO.setProduct_picture_small(product_picture_small);
					productVO.setProduct_status(product_status);
					productVO.setProduct_create_date(product_create_date);
					productVO.setProduct_info(product_info);
					productVO.setProduct_kind_no(product_kind_no);
					
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()){
						req.setAttribute("productVO", productVO);
						RequestDispatcher failureView = req
								.getRequestDispatcher("/back-end/product/update_product_input.jsp");
						failureView.forward(req, res);
						return; //程式中斷
					}
					
					/***************************2.開始修改資料*****************************************/
					ProductService productSvc = new ProductService();
					productVO = productSvc.updateProduct(product_no,product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,product_create_date,product_info,product_kind_no);
					/***************************3.修改完成,準備轉交(Send the Success view)*************/				
					Product_kindService product_kindSvc = new Product_kindService();
					if(requestURL.equals("/back-end/product_kind/listProducts_ByProduct_kind_no.jsp")||requestURL.equals("/back-end/product_kind/listAllProduct_kind.jsp"))
						req.setAttribute("listProducts_ByProduct_kind_no", product_kindSvc.getProductsByProduct_kind_no(product_kind_no));
					
					if(requestURL.equals("/back-end/product/listProducts_ByCompositeQuery.jsp")){
						HttpSession session = req.getSession();
						Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
						List<ProductVO> list = productSvc.getAll(map);
						req.setAttribute("listProducts_ByCompositeQuery", list);
					}
					
					String url = requestURL;
					RequestDispatcher successViewDispatcher = req.getRequestDispatcher(url);
					successViewDispatcher.forward(req, res);
					
					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					errorMsgs.add("修改資料失敗"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/proudct/update_product_input.jsp");
					failureView.forward(req, res);
				}
								
		}
//四、insert=============================================================
		if ("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
			
			try	{
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				String product_no = req.getParameter("product_no").trim();
				String product_name = req.getParameter("product_name").trim();
				String product_introduction = req.getParameter("product_introduction").trim();
				String product_info = req.getParameter("product_info").trim();
				String product_picture_large = req.getParameter("product_picture_large").trim();
				String product_picture_small = req.getParameter("product_picture_small").trim();
				
				//
				java.sql.Date product_create_date = null;				
				try{
					product_create_date = java.sql.Date.valueOf(req.getParameter("product_create_date").trim());
				} catch (IllegalArgumentException e) {
					product_create_date = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				//價格
				Integer product_price = null;
				try{
					product_price = new Integer (req.getParameter("product_price").trim());
				}catch (NumberFormatException e) {
					product_price = 0;
					errorMsgs.add("價格請填入數字");
				}
				//上下架狀態
				Integer product_status = null;
				try{
					product_status = new Integer(req.getParameter("product_status").trim());
				} catch (NumberFormatException e) {
					product_status = 0;
					errorMsgs.add("上下架狀態請填數字");
				}
				//庫存量
				Integer product_stock = null;
				try{
					product_stock = new Integer(req.getParameter("product_stock").trim());
				} catch (NumberFormatException e) {
					product_stock = 0;
					errorMsgs.add("庫存量請填數字");
				}
				
				String product_kind_no = new String(req.getParameter("product_kind_no").trim());
				
				ProductVO productVO = new ProductVO();
//				productVO.setProduct_no(product_no);
				productVO.setProduct_name(product_name);
				productVO.setProduct_introduction(product_introduction);
				productVO.setProduct_price(product_price);
				productVO.setProduct_stock(product_stock);
				productVO.setProduct_status(product_status);
				productVO.setProduct_create_date(product_create_date);
				productVO.setProduct_info(product_info);
				productVO.setProduct_kind_no(product_kind_no);
				productVO.setProduct_picture_large(product_picture_large);
				productVO.setProduct_picture_small(product_picture_small);
				
				if(!errorMsgs.isEmpty()){
					req.setAttribute("productVO", productVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/product/addProduct.jsp");
					failureView.forward(req, res);
					return;
				}
				/***************************2.開始新增資料***************************************/
				ProductService productSvc = new ProductService();
				productVO = productSvc.addProduct(product_name,product_introduction,product_price,product_stock,product_picture_large,product_picture_small,product_status,product_create_date,product_info,product_kind_no);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/product/listAllProduct.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/product/addProduct.jsp");
				failureView.forward(req, res);
			}	
		}
//五、delete=============================================================
		if("delete".equals(action)){
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL");
			
			try {
				/***************************1.接收請求參數***************************************/
				String product_no = req.getParameter("product_no");
				/***************************2.開始刪除資料***************************************/
				ProductService productSvc = new ProductService();
				ProductVO productVO = productSvc.getOneProduct(product_no);
				productSvc.deleteProduct(product_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				Product_kindService product_kindSvc = new Product_kindService();
				if(requestURL.equals("/back-end/product/listProducts_ByProduct_kind_no.jsp") 
						|| requestURL.equals("/back-end/product_kind/listAllProduct_kind.jsp"))
					req.setAttribute("listProducts_ByProduct_kind_no",product_kindSvc.getProductsByProduct_kind_no(productVO.getProduct_kind_no()));
				if(requestURL.equals("/back-end/product/listProducts_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ProductVO> list = productSvc.getAll(map);
					req.setAttribute("listProducts_ByCompositeQuery", list);		
				}
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/

			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
		}
	}
//五、ByCompositeQuery=============================================================
		if("listProducts_ByCompositeQuery".equals(action)){
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				/***************************1.將輸入資料轉為Map**********************************/ 
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				if (req.getParameter("whichPage") == null){
					HashMap<String, String[]> map1 = (HashMap<String, String[]>)req.getParameterMap();
					HashMap<String, String[]> map2 = new HashMap<String, String[]>();
					map2 = (HashMap<String, String[]>)map1.clone();
					session.setAttribute("map", map2);
					map = (HashMap<String, String[]>)req.getParameterMap();
				}
				/***************************2.開始複合查詢***************************************/
				ProductService productSvc = new ProductService();
				List<ProductVO> list = productSvc.getAll(map);
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("listProducts_ByCompositeQuery", list);
				RequestDispatcher successView = req.getRequestDispatcher("/back-end/product/listProducts_ByCompositeQuery.jsp");
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
				
			} catch (Exception e){
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/select_page.jsp");
				failureView.forward(req, res);
			}
		}
	}	
}
