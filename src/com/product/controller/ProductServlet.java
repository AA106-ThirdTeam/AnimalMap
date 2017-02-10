	

package com.product.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.product.model.*;
/** 
 *product : <br>
 *	商品<br>
 *	英文:product<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/product/product.do" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Product servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("product_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("商品編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   product_no = null;
				try {
					product_no = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("商品編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				ProductService productSvc = new ProductService();
				ProductVO productVO = productSvc.getOneProduct(product_no);
				
				if (productVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("productVO", productVO); 
				String url = "/back-end/product/listOneProduct.jsp";
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
				String product_no = new String(req.getParameter("product_no").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				ProductService productSvc = new ProductService();
				ProductVO productVO = productSvc.getOneProduct(product_no);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("productVO", productVO); 		
				String url = "/back-end/product/update_product_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_product_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_product_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String product_no = req.getParameter("product_no").trim();
				String product_name = req.getParameter("product_name").trim();
				String product_introduction = req.getParameter("product_introduction").trim();
				Integer product_price = new Integer(req.getParameter("product_price").trim());
				Integer product_stock = new Integer(req.getParameter("product_stock").trim());
				byte[] product_picture_large = null;
				try {
					Part part = req.getPart("product_picture_large");
					InputStream in = part.getInputStream();
					product_picture_large = new byte[part.getInputStream().available()];
					in.read(product_picture_large);
					in.close();
				} catch (Exception e) {
					product_picture_large = null;
					//errorMsgs.add("商品圖片請上傳照片.");
				}
				byte[] product_picture_small = null;
				try {
					Part part = req.getPart("product_picture_small");
					InputStream in = part.getInputStream();
					product_picture_small = new byte[part.getInputStream().available()];
					in.read(product_picture_small);
					in.close();
				} catch (Exception e) {
					product_picture_small = null;
					//errorMsgs.add("商品圖片（縮圖）請上傳照片.");
				}
				Integer product_status = new Integer(req.getParameter("product_status").trim());
				java.sql.Date product_create_date = null;
				try {
					product_create_date = java.sql.Date.valueOf(req.getParameter("product_create_date").trim());
				} catch (IllegalArgumentException e) {
					product_create_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String product_info = req.getParameter("product_info").trim();
				Integer product_kind_no = new Integer(req.getParameter("product_kind_no").trim());

				//==== VO設定部分 ====			
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
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("productVO", productVO); // 含有輸入格式錯誤的productVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/product/update_product_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				ProductService productSvc = new ProductService();
				productVO = productSvc.updateProduct(
					product_no
					,product_name
					,product_introduction
					,product_price
					,product_stock
					,product_picture_large
					,product_picture_small
					,product_status
					,product_create_date
					,product_info
					,product_kind_no
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				
				
				if(requestURL.equals("/back-end/product/listProducts_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ProductVO> list  = productSvc.getAll(map);
					req.setAttribute("listProducts_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/product/update_product_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addProduct.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String product_name = req.getParameter("product_name").trim();	

                String product_introduction = req.getParameter("product_introduction").trim();	

                Integer product_price = new Integer(req.getParameter("product_price").trim());	

                Integer product_stock = new Integer(req.getParameter("product_stock").trim());	

                byte[] product_picture_large = null;
                try {
                    Part part = req.getPart("product_picture_large");
                    InputStream in = part.getInputStream();
                    product_picture_large = new byte[part.getInputStream().available()];
                    in.read(product_picture_large);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("商品圖片請上傳照片.");
                    //e.printStackTrace();
                    product_picture_large = null;
                }	

                byte[] product_picture_small = null;
                try {
                    Part part = req.getPart("product_picture_small");
                    InputStream in = part.getInputStream();
                    product_picture_small = new byte[part.getInputStream().available()];
                    in.read(product_picture_small);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("商品圖片（縮圖）請上傳照片.");
                    //e.printStackTrace();
                    product_picture_small = null;
                }	

                Integer product_status = new Integer(req.getParameter("product_status").trim());	
	
                java.sql.Date product_create_date = null;
                try {
                    product_create_date = java.sql.Date.valueOf(req.getParameter("product_create_date").trim());
                } catch (IllegalArgumentException e) {
                    product_create_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                String product_info = req.getParameter("product_info").trim();	

                Integer product_kind_no = new Integer(req.getParameter("product_kind_no").trim());	

                ProductVO productVO = new ProductVO();
 
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
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("productVO", productVO); // 含有輸入格式錯誤的productVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/product/addProduct.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                ProductService productSvc = new ProductService();
                productVO = productSvc.addProduct(
	
                	product_name
	
                	,product_introduction
	
                	,product_price
	
                	,product_stock
	
                	,product_picture_large
	
                	,product_picture_small
	
                	,product_status
	
                	,product_create_date
	
                	,product_info
	
                	,product_kind_no
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/product/listAllProduct.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllProduct.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/product/addProduct.jsp");
				failureView.forward(req, res);
			}
		}			

		if ("delete".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
                String product_no = new String(req.getParameter("product_no"));

				/***************************2.開始刪除資料***************************************/
				ProductService productSvc = new ProductService();

				ProductVO productVO = productSvc.getOneProduct(product_no);
				productSvc.deleteProduct(product_no);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				
				
				if(requestURL.equals("/back-end/product/listProducts_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ProductVO> list  = productSvc.getAll(map);
					req.setAttribute("listProducts_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("listProducts_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                
                /***************************1.將輸入資料轉為Map**********************************/ 
                //採用Map<String,String[]> getParameterMap()的方法 
                //注意:an immutable java.util.Map 
                //Map<String, String[]> map = req.getParameterMap();
                HttpSession session = req.getSession();
                Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");

                if (req.getParameter("whichPage") == null){
                    HashMap<String, String[]> map1 = (HashMap<String, String[]>)req.getParameterMap();
                    HashMap<String, String[]> map2 = new HashMap<String, String[]>();
                    map2 = (HashMap<String, String[]>)map1.clone();
                    session.setAttribute("map",map2);
                    map = (HashMap<String, String[]>)req.getParameterMap();
                } 

                /***************************2.開始複合查詢***************************************/
                ProductService productSvc = new ProductService();
                List<ProductVO> list  = productSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listProducts_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/product/listProducts_ByCompositeQuery.jsp"); // 成功轉交listProducts_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	











	}
}
