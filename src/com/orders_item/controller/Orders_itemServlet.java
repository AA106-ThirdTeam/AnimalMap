	

package com.orders_item.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.orders.model.*;

import com.product.model.*;
	
import com.orders.model.*;
	
import com.product.model.*;

import com.orders_item.model.*;
/** 
 *orders_item : <br>
 *	訂單明細<br>
 *	英文:orders_item<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/orders_item/orders_item.do" })
public class Orders_itemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Orders_item servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("orders_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("訂單編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   orders_no = null;
				try {
					orders_no = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("訂單編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				Orders_itemService orders_itemSvc = new Orders_itemService();
				Orders_itemVO orders_itemVO = orders_itemSvc.getOneOrders_item_By_orders_no(orders_no);
				
				if (orders_itemVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("orders_itemVO", orders_itemVO); 
				String url = "/back-end/orders_item/listOneOrders_item.jsp";
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
				String orders_no = new String(req.getParameter("orders_no").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Orders_itemService orders_itemSvc = new Orders_itemService();
				Orders_itemVO orders_itemVO = orders_itemSvc.getOneOrders_item_By_orders_no(orders_no);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("orders_itemVO", orders_itemVO); 		
				String url = "/back-end/orders_item/update_orders_item_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_orders_item_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_orders_item_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String orders_no = req.getParameter("orders_no").trim();
				String product_no = req.getParameter("product_no").trim();
				Integer commodities_amout = new Integer(req.getParameter("commodities_amout").trim());
				Integer selling_price = new Integer(req.getParameter("selling_price").trim());

				//==== VO設定部分 ====			
				Orders_itemVO orders_itemVO = new Orders_itemVO();
				orders_itemVO.setOrders_no(orders_no);
				orders_itemVO.setProduct_no(product_no);
				orders_itemVO.setCommodities_amout(commodities_amout);
				orders_itemVO.setSelling_price(selling_price);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("orders_itemVO", orders_itemVO); // 含有輸入格式錯誤的orders_itemVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/orders_item/update_orders_item_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Orders_itemService orders_itemSvc = new Orders_itemService();
				orders_itemVO = orders_itemSvc.updateOrders_item(
					orders_no
					,product_no
					,commodities_amout
					,selling_price
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/orders_item/listOrders_items_ByOrders_no.jsp") 
					|| requestURL.equals("/back-end/orders_item/listAllOrders_item.jsp")){
					req.setAttribute("listOrders_items_ByOrders_no",orders_itemSvc.getOrders_itemsByOrders_no(orders_no)); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/orders_item/listOrders_items_ByProduct_no.jsp") 
					|| requestURL.equals("/back-end/orders_item/listAllOrders_item.jsp")){
					req.setAttribute("listOrders_items_ByProduct_no",orders_itemSvc.getOrders_itemsByProduct_no(product_no)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/orders_item/listOrders_items_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Orders_itemVO> list  = orders_itemSvc.getAll(map);
					req.setAttribute("listOrders_items_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/orders_item/update_orders_item_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addOrders_item.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                Integer commodities_amout = new Integer(req.getParameter("commodities_amout").trim());	

                Integer selling_price = new Integer(req.getParameter("selling_price").trim());	

                Orders_itemVO orders_itemVO = new Orders_itemVO();
 
                orders_itemVO.setCommodities_amout(commodities_amout);
 
                orders_itemVO.setSelling_price(selling_price);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("orders_itemVO", orders_itemVO); // 含有輸入格式錯誤的orders_itemVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orders_item/addOrders_item.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Orders_itemService orders_itemSvc = new Orders_itemService();
                orders_itemVO = orders_itemSvc.addOrders_item(
	
                	commodities_amout
	
                	,selling_price
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/orders_item/listAllOrders_item.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOrders_item.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/orders_item/addOrders_item.jsp");
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
                String orders_no = new String(req.getParameter("orders_no"));

				/***************************2.開始刪除資料***************************************/
				Orders_itemService orders_itemSvc = new Orders_itemService();

				Orders_itemVO orders_itemVO = orders_itemSvc.getOneOrders_item_By_orders_no(orders_no);
				orders_itemSvc.deleteOrders_item_By_orders_no(orders_no);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/orders_item/listOrders_items_ByOrders_no.jsp") 
					|| requestURL.equals("/back-end/orders_item/listAllOrders_item.jsp")){
					req.setAttribute("listOrders_items_ByOrders_no",orders_itemSvc.getOrders_itemsByOrders_no(orders_itemVO.getOrders_no())); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/orders_item/listOrders_items_ByProduct_no.jsp") 
					|| requestURL.equals("/back-end/orders_item/listAllOrders_item.jsp")){
					req.setAttribute("listOrders_items_ByProduct_no",orders_itemSvc.getOrders_itemsByProduct_no(orders_itemVO.getProduct_no())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/orders_item/listOrders_items_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Orders_itemVO> list  = orders_itemSvc.getAll(map);
					req.setAttribute("listOrders_items_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listOrders_items_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Orders_itemService orders_itemSvc = new Orders_itemService();
                List<Orders_itemVO> list  = orders_itemSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listOrders_items_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/orders_item/listOrders_items_ByCompositeQuery.jsp"); // 成功轉交listOrders_items_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	

        // 來自select_page.jsp的請求                                  // 來自 orders_item/listAllOrders_item.jsp的請求
        if ("listOrders_items_ByOrders_no_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String orders_no = new String(req.getParameter("orders_no"));

                /*************************** 2.開始查詢資料 ****************************************/
                Orders_itemService orders_itemSvc = new Orders_itemService();
                Set<Orders_itemVO> set = orders_itemSvc.getOrders_itemsByOrders_no(orders_no);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listOrders_items_ByOrders_no", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listOrders_items_ByOrders_no_A".equals(action))
                    url = "/back-end/orders_item/listOrders_items_ByOrders_no.jsp";        // 成功轉交 orders_item/listOrders_items_ByOrders_no.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }


        // 來自select_page.jsp的請求                                  // 來自 orders_item/listAllOrders_item.jsp的請求
        if ("listOrders_items_ByProduct_no_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String product_no = new String(req.getParameter("product_no"));

                /*************************** 2.開始查詢資料 ****************************************/
                Orders_itemService orders_itemSvc = new Orders_itemService();
                Set<Orders_itemVO> set = orders_itemSvc.getOrders_itemsByProduct_no(product_no);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listOrders_items_ByProduct_no", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listOrders_items_ByProduct_no_A".equals(action))
                    url = "/back-end/orders_item/listOrders_items_ByProduct_no.jsp";        // 成功轉交 orders_item/listOrders_items_ByProduct_no.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }



	}
}
