	

package com.second_prodphotos.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.second_prod.model.*;

import com.second_prodphotos.model.*;
/** 
 *second_ProdPhotos : <br>
 *	二手商品相簿<br>
 *	英文:second_ProdPhotos<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/second_prodphotos/second_prodphotos.do" })
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
					errorMsgs.add("二手商品相簿編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   second_ProdPhotos_Id = null;
				try {
					second_ProdPhotos_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("二手商品相簿編號格式不正確");				
				}
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
				String url = "/back-end/second_prodphotos/listOneSecond_ProdPhotos.jsp";
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
				String second_ProdPhotos_Id = new String(req.getParameter("second_ProdPhotos_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
				Second_ProdPhotosVO second_prodphotosVO = second_prodphotosSvc.getOneSecond_ProdPhotos(second_ProdPhotos_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("second_prodphotosVO", second_prodphotosVO); 		
				String url = "/back-end/second_prodphotos/update_second_prodphotos_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_second_prodphotos_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_second_ProdPhotos_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String second_ProdPhotos_Id = req.getParameter("second_ProdPhotos_Id").trim();
				String second_Prod_Id = req.getParameter("second_Prod_Id").trim();

				//==== VO設定部分 ====			
				Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
				second_prodphotosVO.setSecond_ProdPhotos_Id(second_ProdPhotos_Id);
				second_prodphotosVO.setSecond_Prod_Id(second_Prod_Id);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("second_prodphotosVO", second_prodphotosVO); // 含有輸入格式錯誤的second_prodphotosVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/second_prodphotos/update_second_prodphotos_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
				second_prodphotosVO = second_prodphotosSvc.updateSecond_ProdPhotos(
					second_ProdPhotos_Id
					,second_Prod_Id
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/second_prodphotos/listSecond_ProdPhotoss_BySecond_Prod_Id.jsp") 
					|| requestURL.equals("/back-end/second_prodphotos/listAllSecond_ProdPhotos.jsp")){
					req.setAttribute("listSecond_ProdPhotoss_BySecond_Prod_Id",second_prodphotosSvc.getSecond_ProdPhotossBySecond_Prod_Id(second_Prod_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/second_prodphotos/listSecond_ProdPhotoss_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Second_ProdPhotosVO> list  = second_prodphotosSvc.getAll(map);
					req.setAttribute("listSecond_ProdPhotoss_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/second_prodphotos/update_second_prodphotos_input.jsp");
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
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/second_prodphotos/addSecond_ProdPhotos.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
                second_prodphotosVO = second_prodphotosSvc.addSecond_ProdPhotos(
	
                	second_Prod_Id
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/second_prodphotos/listAllSecond_ProdPhotos.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllSecond_ProdPhotos.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/second_prodphotos/addSecond_ProdPhotos.jsp");
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
                String second_ProdPhotos_Id = new String(req.getParameter("second_ProdPhotos_Id"));

				/***************************2.開始刪除資料***************************************/
				Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();

				Second_ProdPhotosVO second_prodphotosVO = second_prodphotosSvc.getOneSecond_ProdPhotos(second_ProdPhotos_Id);
				second_prodphotosSvc.deleteSecond_ProdPhotos(second_ProdPhotos_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/second_prodphotos/listSecond_ProdPhotoss_BySecond_Prod_Id.jsp") 
					|| requestURL.equals("/back-end/second_prodphotos/listAllSecond_ProdPhotos.jsp")){
					req.setAttribute("listSecond_ProdPhotoss_BySecond_Prod_Id",second_prodphotosSvc.getSecond_ProdPhotossBySecond_Prod_Id(second_prodphotosVO.getSecond_Prod_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/second_prodphotos/listSecond_ProdPhotoss_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Second_ProdPhotosVO> list  = second_prodphotosSvc.getAll(map);
					req.setAttribute("listSecond_ProdPhotoss_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listSecond_ProdPhotoss_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
                List<Second_ProdPhotosVO> list  = second_prodphotosSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listSecond_ProdPhotoss_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/second_prodphotos/listSecond_ProdPhotoss_ByCompositeQuery.jsp"); // 成功轉交listSecond_ProdPhotoss_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 second_prodphotos/listAllSecond_ProdPhotos.jsp的請求
        if ("listSecond_ProdPhotoss_BySecond_Prod_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String second_Prod_Id = new String(req.getParameter("second_Prod_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                Second_ProdPhotosService second_prodphotosSvc = new Second_ProdPhotosService();
                Set<Second_ProdPhotosVO> set = second_prodphotosSvc.getSecond_ProdPhotossBySecond_Prod_Id(second_Prod_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listSecond_ProdPhotoss_BySecond_Prod_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listSecond_ProdPhotoss_BySecond_Prod_Id_A".equals(action))
                    url = "/back-end/second_prodphotos/listSecond_ProdPhotoss_BySecond_Prod_Id.jsp";        // 成功轉交 second_prodphotos/listSecond_ProdPhotoss_BySecond_Prod_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }

	}
}
