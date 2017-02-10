	

package com.second_prod.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;

import com.second_prod.model.*;
/** 
 *second_Prod : <br>
 *	二手商品<br>
 *	英文:second_Prod<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/second_prod/second_prod.do" })
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
					errorMsgs.add("二手商品編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   second_Prod_Id = null;
				try {
					second_Prod_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("二手商品編號格式不正確");				
				}
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
				String url = "/back-end/second_prod/listOneSecond_Prod.jsp";
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
				String second_Prod_Id = new String(req.getParameter("second_Prod_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Second_ProdService second_prodSvc = new Second_ProdService();
				Second_ProdVO second_prodVO = second_prodSvc.getOneSecond_Prod(second_Prod_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodVO", second_prodVO); 		
				String url = "/back-end/second_prod/update_second_prod_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_second_prod_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_second_Prod_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
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

				//==== VO設定部分 ====			
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


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("second_prodVO", second_prodVO); // 含有輸入格式錯誤的second_prodVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/second_prod/update_second_prod_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Second_ProdService second_prodSvc = new Second_ProdService();
				second_prodVO = second_prodSvc.updateSecond_Prod(
					second_Prod_Id
					,mem_Id
					,second_Prod_Title
					,second_Prod_Content
					,second_Prod_adp_start_date
					,second_Prod_adp_end_date
					,second_Prod_adp_upDate
					,second_Prod_adp_city
					,second_Prod_Town
					,second_Prod_Road
					,second_Prod_Lon
					,second_Prod_Lat
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/second_prod/listSecond_Prods_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/second_prod/listAllSecond_Prod.jsp")){
					req.setAttribute("listSecond_Prods_ByMem_Id",second_prodSvc.getSecond_ProdsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/second_prod/listSecond_Prods_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Second_ProdVO> list  = second_prodSvc.getAll(map);
					req.setAttribute("listSecond_Prods_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/second_prod/update_second_prod_input.jsp");
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
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/second_prod/addSecond_Prod.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Second_ProdService second_prodSvc = new Second_ProdService();
                second_prodVO = second_prodSvc.addSecond_Prod(
	
                	mem_Id
	
                	,second_Prod_Title
	
                	,second_Prod_Content
	
                	,second_Prod_adp_start_date
	
                	,second_Prod_adp_end_date
	
                	,second_Prod_adp_upDate
	
                	,second_Prod_adp_city
	
                	,second_Prod_Town
	
                	,second_Prod_Road
	
                	,second_Prod_Lon
	
                	,second_Prod_Lat
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/second_prod/listAllSecond_Prod.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllSecond_Prod.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/second_prod/addSecond_Prod.jsp");
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
                String second_Prod_Id = new String(req.getParameter("second_Prod_Id"));

				/***************************2.開始刪除資料***************************************/
				Second_ProdService second_prodSvc = new Second_ProdService();

				Second_ProdVO second_prodVO = second_prodSvc.getOneSecond_Prod(second_Prod_Id);
				second_prodSvc.deleteSecond_Prod(second_Prod_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/second_prod/listSecond_Prods_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/second_prod/listAllSecond_Prod.jsp")){
					req.setAttribute("listSecond_Prods_ByMem_Id",second_prodSvc.getSecond_ProdsByMem_Id(second_prodVO.getMem_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/second_prod/listSecond_Prods_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Second_ProdVO> list  = second_prodSvc.getAll(map);
					req.setAttribute("listSecond_Prods_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listSecond_Prods_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Second_ProdService second_prodSvc = new Second_ProdService();
                List<Second_ProdVO> list  = second_prodSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listSecond_Prods_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/second_prod/listSecond_Prods_ByCompositeQuery.jsp"); // 成功轉交listSecond_Prods_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 second_prod/listAllSecond_Prod.jsp的請求
        if ("listSecond_Prods_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String mem_Id = new String(req.getParameter("mem_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                Second_ProdService second_prodSvc = new Second_ProdService();
                Set<Second_ProdVO> set = second_prodSvc.getSecond_ProdsByMem_Id(mem_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listSecond_Prods_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listSecond_Prods_ByMem_Id_A".equals(action))
                    url = "/back-end/second_prod/listSecond_Prods_ByMem_Id.jsp";        // 成功轉交 second_prod/listSecond_Prods_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }











	}
}
