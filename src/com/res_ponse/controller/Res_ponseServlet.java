	

package com.res_ponse.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;

import com.post.model.*;

import com.res_ponse.model.*;
/** 
 *res_ponse : <br>
 *	討論區留言<br>
 *	英文:res_ponse<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/res_ponse/res_ponse.do" })
public class Res_ponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Res_ponse servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("res_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("留言(回覆)編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   res_Id = null;
				try {
					res_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("留言(回覆)編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				Res_ponseService res_ponseSvc = new Res_ponseService();
				Res_ponseVO res_ponseVO = res_ponseSvc.getOneRes_ponse(res_Id);
				
				if (res_ponseVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("res_ponseVO", res_ponseVO); 
				String url = "/back-end/res_ponse/listOneRes_ponse.jsp";
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
				String res_Id = new String(req.getParameter("res_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Res_ponseService res_ponseSvc = new Res_ponseService();
				Res_ponseVO res_ponseVO = res_ponseSvc.getOneRes_ponse(res_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("res_ponseVO", res_ponseVO); 		
				String url = "/back-end/res_ponse/update_res_ponse_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_res_ponse_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_res_ponse_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String res_Id = req.getParameter("res_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String post_Id = req.getParameter("post_Id").trim();
				String res_ponse_content = req.getParameter("res_ponse_content").trim();
				java.sql.Date post_time = null;
				try {
					post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
				} catch (IllegalArgumentException e) {
					post_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date res_ponse_upDate = null;
				try {
					res_ponse_upDate = java.sql.Date.valueOf(req.getParameter("res_ponse_upDate").trim());
				} catch (IllegalArgumentException e) {
					res_ponse_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				//==== VO設定部分 ====			
				Res_ponseVO res_ponseVO = new Res_ponseVO();
				res_ponseVO.setRes_Id(res_Id);
				res_ponseVO.setMem_Id(mem_Id);
				res_ponseVO.setPost_Id(post_Id);
				res_ponseVO.setRes_ponse_content(res_ponse_content);
				res_ponseVO.setPost_time(post_time);
				res_ponseVO.setRes_ponse_upDate(res_ponse_upDate);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("res_ponseVO", res_ponseVO); // 含有輸入格式錯誤的res_ponseVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/res_ponse/update_res_ponse_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Res_ponseService res_ponseSvc = new Res_ponseService();
				res_ponseVO = res_ponseSvc.updateRes_ponse(
					res_Id
					,mem_Id
					,post_Id
					,res_ponse_content
					,post_time
					,res_ponse_upDate
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/res_ponse/listRes_ponses_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/res_ponse/listAllRes_ponse.jsp")){
					req.setAttribute("listRes_ponses_ByMem_Id",res_ponseSvc.getRes_ponsesByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/res_ponse/listRes_ponses_ByPost_Id.jsp") 
					|| requestURL.equals("/back-end/res_ponse/listAllRes_ponse.jsp")){
					req.setAttribute("listRes_ponses_ByPost_Id",res_ponseSvc.getRes_ponsesByPost_Id(post_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/res_ponse/listRes_ponses_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Res_ponseVO> list  = res_ponseSvc.getAll(map);
					req.setAttribute("listRes_ponses_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/res_ponse/update_res_ponse_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addRes_ponse.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String mem_Id = req.getParameter("mem_Id").trim();	

                String post_Id = req.getParameter("post_Id").trim();	

                String res_ponse_content = req.getParameter("res_ponse_content").trim();	
	
                java.sql.Date post_time = null;
                try {
                    post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
                } catch (IllegalArgumentException e) {
                    post_time=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
	
                java.sql.Date res_ponse_upDate = null;
                try {
                    res_ponse_upDate = java.sql.Date.valueOf(req.getParameter("res_ponse_upDate").trim());
                } catch (IllegalArgumentException e) {
                    res_ponse_upDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                Res_ponseVO res_ponseVO = new Res_ponseVO();
 
                res_ponseVO.setMem_Id(mem_Id);
 
                res_ponseVO.setPost_Id(post_Id);
 
                res_ponseVO.setRes_ponse_content(res_ponse_content);
 
                res_ponseVO.setPost_time(post_time);
 
                res_ponseVO.setRes_ponse_upDate(res_ponse_upDate);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("res_ponseVO", res_ponseVO); // 含有輸入格式錯誤的res_ponseVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/res_ponse/addRes_ponse.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Res_ponseService res_ponseSvc = new Res_ponseService();
                res_ponseVO = res_ponseSvc.addRes_ponse(
	
                	mem_Id
	
                	,post_Id
	
                	,res_ponse_content
	
                	,post_time
	
                	,res_ponse_upDate
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/res_ponse/listAllRes_ponse.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllRes_ponse.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/res_ponse/addRes_ponse.jsp");
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
                String res_Id = new String(req.getParameter("res_Id"));

				/***************************2.開始刪除資料***************************************/
				Res_ponseService res_ponseSvc = new Res_ponseService();

				Res_ponseVO res_ponseVO = res_ponseSvc.getOneRes_ponse(res_Id);
				res_ponseSvc.deleteRes_ponse(res_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/res_ponse/listRes_ponses_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/res_ponse/listAllRes_ponse.jsp")){
					req.setAttribute("listRes_ponses_ByMem_Id",res_ponseSvc.getRes_ponsesByMem_Id(res_ponseVO.getMem_Id())); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/res_ponse/listRes_ponses_ByPost_Id.jsp") 
					|| requestURL.equals("/back-end/res_ponse/listAllRes_ponse.jsp")){
					req.setAttribute("listRes_ponses_ByPost_Id",res_ponseSvc.getRes_ponsesByPost_Id(res_ponseVO.getPost_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/res_ponse/listRes_ponses_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Res_ponseVO> list  = res_ponseSvc.getAll(map);
					req.setAttribute("listRes_ponses_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listRes_ponses_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Res_ponseService res_ponseSvc = new Res_ponseService();
                List<Res_ponseVO> list  = res_ponseSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listRes_ponses_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/res_ponse/listRes_ponses_ByCompositeQuery.jsp"); // 成功轉交listRes_ponses_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 res_ponse/listAllRes_ponse.jsp的請求
        if ("listRes_ponses_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String mem_Id = new String(req.getParameter("mem_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                Res_ponseService res_ponseSvc = new Res_ponseService();
                Set<Res_ponseVO> set = res_ponseSvc.getRes_ponsesByMem_Id(mem_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listRes_ponses_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listRes_ponses_ByMem_Id_A".equals(action))
                    url = "/back-end/res_ponse/listRes_ponses_ByMem_Id.jsp";        // 成功轉交 res_ponse/listRes_ponses_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }


        // 來自select_page.jsp的請求                                  // 來自 res_ponse/listAllRes_ponse.jsp的請求
        if ("listRes_ponses_ByPost_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String post_Id = new String(req.getParameter("post_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                Res_ponseService res_ponseSvc = new Res_ponseService();
                Set<Res_ponseVO> set = res_ponseSvc.getRes_ponsesByPost_Id(post_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listRes_ponses_ByPost_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listRes_ponses_ByPost_Id_A".equals(action))
                    url = "/back-end/res_ponse/listRes_ponses_ByPost_Id.jsp";        // 成功轉交 res_ponse/listRes_ponses_ByPost_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }




	}
}
