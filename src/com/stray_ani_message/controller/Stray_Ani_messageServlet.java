	

package com.stray_ani_message.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.stray_ani.model.*;

import com.mem.model.*;

import com.stray_ani_message.model.*;
/** 
 *stray_Ani_message : <br>
 *	社區流浪動物留言<br>
 *	英文:stray_Ani_message<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/stray_ani_message/stray_ani_message.do" })
public class Stray_Ani_messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Stray_Ani_message servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("str_Ani_Mes_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("流浪動物留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   str_Ani_Mes_No = null;
				try {
					str_Ani_Mes_No = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("流浪動物留言編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
				Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);
				
				if (stray_ani_messageVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); 
				String url = "/back-end/stray_ani_message/listOneStray_Ani_message.jsp";
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
				String str_Ani_Mes_No = new String(req.getParameter("str_Ani_Mes_No").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
				Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); 		
				String url = "/back-end/stray_ani_message/update_stray_ani_message_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_stray_ani_message_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_stray_Ani_message_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String str_Ani_Mes_No = req.getParameter("str_Ani_Mes_No").trim();
				String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				java.sql.Date str_Ani_Mes_time = null;
				try {
					str_Ani_Mes_time = java.sql.Date.valueOf(req.getParameter("str_Ani_Mes_time").trim());
				} catch (IllegalArgumentException e) {
					str_Ani_Mes_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String str_Ani_Mes = req.getParameter("str_Ani_Mes").trim();

				//==== VO設定部分 ====			
				Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
				stray_ani_messageVO.setStr_Ani_Mes_No(str_Ani_Mes_No);
				stray_ani_messageVO.setStray_Ani_Id(stray_Ani_Id);
				stray_ani_messageVO.setMem_Id(mem_Id);
				stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
				stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); // 含有輸入格式錯誤的stray_ani_messageVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/stray_ani_message/update_stray_ani_message_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
				stray_ani_messageVO = stray_ani_messageSvc.updateStray_Ani_message(
					str_Ani_Mes_No
					,stray_Ani_Id
					,mem_Id
					,str_Ani_Mes_time
					,str_Ani_Mes
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/stray_ani_message/listStray_Ani_messages_ByStray_Ani_Id.jsp") 
					|| requestURL.equals("/back-end/stray_ani_message/listAllStray_Ani_message.jsp")){
					req.setAttribute("listStray_Ani_messages_ByStray_Ani_Id",stray_ani_messageSvc.getStray_Ani_messagesByStray_Ani_Id(stray_Ani_Id)); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/stray_ani_message/listStray_Ani_messages_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/stray_ani_message/listAllStray_Ani_message.jsp")){
					req.setAttribute("listStray_Ani_messages_ByMem_Id",stray_ani_messageSvc.getStray_Ani_messagesByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/stray_ani_message/listStray_Ani_messages_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Stray_Ani_messageVO> list  = stray_ani_messageSvc.getAll(map);
					req.setAttribute("listStray_Ani_messages_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/stray_ani_message/update_stray_ani_message_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addStray_Ani_message.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();	

                String mem_Id = req.getParameter("mem_Id").trim();	
	
                java.sql.Date str_Ani_Mes_time = null;
                try {
                    str_Ani_Mes_time = java.sql.Date.valueOf(req.getParameter("str_Ani_Mes_time").trim());
                } catch (IllegalArgumentException e) {
                    str_Ani_Mes_time=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                String str_Ani_Mes = req.getParameter("str_Ani_Mes").trim();	

                Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
 
                stray_ani_messageVO.setStray_Ani_Id(stray_Ani_Id);
 
                stray_ani_messageVO.setMem_Id(mem_Id);
 
                stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
 
                stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("stray_ani_messageVO", stray_ani_messageVO); // 含有輸入格式錯誤的stray_ani_messageVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/stray_ani_message/addStray_Ani_message.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
                stray_ani_messageVO = stray_ani_messageSvc.addStray_Ani_message(
	
                	stray_Ani_Id
	
                	,mem_Id
	
                	,str_Ani_Mes_time
	
                	,str_Ani_Mes
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/stray_ani_message/listAllStray_Ani_message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllStray_Ani_message.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/stray_ani_message/addStray_Ani_message.jsp");
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
                String str_Ani_Mes_No = new String(req.getParameter("str_Ani_Mes_No"));

				/***************************2.開始刪除資料***************************************/
				Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();

				Stray_Ani_messageVO stray_ani_messageVO = stray_ani_messageSvc.getOneStray_Ani_message(str_Ani_Mes_No);
				stray_ani_messageSvc.deleteStray_Ani_message(str_Ani_Mes_No);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/stray_ani_message/listStray_Ani_messages_ByStray_Ani_Id.jsp") 
					|| requestURL.equals("/back-end/stray_ani_message/listAllStray_Ani_message.jsp")){
					req.setAttribute("listStray_Ani_messages_ByStray_Ani_Id",stray_ani_messageSvc.getStray_Ani_messagesByStray_Ani_Id(stray_ani_messageVO.getStray_Ani_Id())); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/stray_ani_message/listStray_Ani_messages_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/stray_ani_message/listAllStray_Ani_message.jsp")){
					req.setAttribute("listStray_Ani_messages_ByMem_Id",stray_ani_messageSvc.getStray_Ani_messagesByMem_Id(stray_ani_messageVO.getMem_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/stray_ani_message/listStray_Ani_messages_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Stray_Ani_messageVO> list  = stray_ani_messageSvc.getAll(map);
					req.setAttribute("listStray_Ani_messages_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listStray_Ani_messages_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
                List<Stray_Ani_messageVO> list  = stray_ani_messageSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listStray_Ani_messages_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/stray_ani_message/listStray_Ani_messages_ByCompositeQuery.jsp"); // 成功轉交listStray_Ani_messages_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 stray_ani_message/listAllStray_Ani_message.jsp的請求
        if ("listStray_Ani_messages_ByStray_Ani_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String stray_Ani_Id = new String(req.getParameter("stray_Ani_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
                Set<Stray_Ani_messageVO> set = stray_ani_messageSvc.getStray_Ani_messagesByStray_Ani_Id(stray_Ani_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listStray_Ani_messages_ByStray_Ani_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listStray_Ani_messages_ByStray_Ani_Id_A".equals(action))
                    url = "/back-end/stray_ani_message/listStray_Ani_messages_ByStray_Ani_Id.jsp";        // 成功轉交 stray_ani_message/listStray_Ani_messages_ByStray_Ani_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }


        // 來自select_page.jsp的請求                                  // 來自 stray_ani_message/listAllStray_Ani_message.jsp的請求
        if ("listStray_Ani_messages_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String mem_Id = new String(req.getParameter("mem_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                Stray_Ani_messageService stray_ani_messageSvc = new Stray_Ani_messageService();
                Set<Stray_Ani_messageVO> set = stray_ani_messageSvc.getStray_Ani_messagesByMem_Id(mem_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listStray_Ani_messages_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listStray_Ani_messages_ByMem_Id_A".equals(action))
                    url = "/back-end/stray_ani_message/listStray_Ani_messages_ByMem_Id.jsp";        // 成功轉交 stray_ani_message/listStray_Ani_messages_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }



	}
}
