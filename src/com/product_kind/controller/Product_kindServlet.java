	

package com.product_kind.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.product_kind.model.*;
/** 
 *product_kind : <br>
 *	商品類別<br>
 *	英文:product_kind<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/product_kind/product_kind.do" })
public class Product_kindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Product_kind servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("product_kind_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("商品類別編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   product_kind_no = null;
				try {
					product_kind_no = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("商品類別編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				Product_kindService product_kindSvc = new Product_kindService();
				Product_kindVO product_kindVO = product_kindSvc.getOneProduct_kind(product_kind_no);
				
				if (product_kindVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("product_kindVO", product_kindVO); 
				String url = "/back-end/product_kind/listOneProduct_kind.jsp";
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
				String product_kind_no = new String(req.getParameter("product_kind_no").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Product_kindService product_kindSvc = new Product_kindService();
				Product_kindVO product_kindVO = product_kindSvc.getOneProduct_kind(product_kind_no);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("product_kindVO", product_kindVO); 		
				String url = "/back-end/product_kind/update_product_kind_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_product_kind_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_product_kind_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String product_kind_no = req.getParameter("product_kind_no").trim();
				String product_kind_name = req.getParameter("product_kind_name").trim();

				//==== VO設定部分 ====			
				Product_kindVO product_kindVO = new Product_kindVO();
				product_kindVO.setProduct_kind_no(product_kind_no);
				product_kindVO.setProduct_kind_name(product_kind_name);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("product_kindVO", product_kindVO); // 含有輸入格式錯誤的product_kindVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/product_kind/update_product_kind_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Product_kindService product_kindSvc = new Product_kindService();
				product_kindVO = product_kindSvc.updateProduct_kind(
					product_kind_no
					,product_kind_name
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				
				
				if(requestURL.equals("/back-end/product_kind/listProduct_kinds_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Product_kindVO> list  = product_kindSvc.getAll(map);
					req.setAttribute("listProduct_kinds_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/product_kind/update_product_kind_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addProduct_kind.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String product_kind_name = req.getParameter("product_kind_name").trim();	

                Product_kindVO product_kindVO = new Product_kindVO();
 
                product_kindVO.setProduct_kind_name(product_kind_name);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("product_kindVO", product_kindVO); // 含有輸入格式錯誤的product_kindVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/product_kind/addProduct_kind.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Product_kindService product_kindSvc = new Product_kindService();
                product_kindVO = product_kindSvc.addProduct_kind(
	
                	product_kind_name
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/product_kind/listAllProduct_kind.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllProduct_kind.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/product_kind/addProduct_kind.jsp");
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
                String product_kind_no = new String(req.getParameter("product_kind_no"));

				/***************************2.開始刪除資料***************************************/
				Product_kindService product_kindSvc = new Product_kindService();

				Product_kindVO product_kindVO = product_kindSvc.getOneProduct_kind(product_kind_no);
				product_kindSvc.deleteProduct_kind(product_kind_no);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				
				
				if(requestURL.equals("/back-end/product_kind/listProduct_kinds_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Product_kindVO> list  = product_kindSvc.getAll(map);
					req.setAttribute("listProduct_kinds_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listProduct_kinds_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Product_kindService product_kindSvc = new Product_kindService();
                List<Product_kindVO> list  = product_kindSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listProduct_kinds_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/product_kind/listProduct_kinds_ByCompositeQuery.jsp"); // 成功轉交listProduct_kinds_ByCompositeQuery.jsp
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
