	

package com.priv_message.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;

import com.mem.model.*;

import com.priv_message.model.*;
/** 
 *priv_message : <br>
 *	私人訊息<br>
 *	英文:priv_message<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/priv_message/priv_message.do" })
public class Priv_messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Priv_message servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("privMes_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("AdpPhotos");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   privMes_Id = null;
				try {
					privMes_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("AdpPhotos格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				Priv_messageService priv_messageSvc = new Priv_messageService();
				Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMes_Id);
				
				if (priv_messageVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("priv_messageVO", priv_messageVO); 
				String url = "/back-end/priv_message/listOnePriv_message.jsp";
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
				String privMes_Id = new String(req.getParameter("privMes_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Priv_messageService priv_messageSvc = new Priv_messageService();
				Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMes_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("priv_messageVO", priv_messageVO); 		
				String url = "/back-end/priv_message/update_priv_message_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_priv_message_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_priv_message_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String privMes_Id = req.getParameter("privMes_Id").trim();
				String privMesSend_MemId = req.getParameter("privMesSend_MemId").trim();
				String privMesRec_MemId = req.getParameter("privMesRec_MemId").trim();
				String privMes_content = req.getParameter("privMes_content").trim();
				java.sql.Date privMes_SendTime = null;
				try {
					privMes_SendTime = java.sql.Date.valueOf(req.getParameter("privMes_SendTime").trim());
				} catch (IllegalArgumentException e) {
					privMes_SendTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String privMes_type = req.getParameter("privMes_type").trim();

				//==== VO設定部分 ====			
				Priv_messageVO priv_messageVO = new Priv_messageVO();
				priv_messageVO.setPrivMes_Id(privMes_Id);
				priv_messageVO.setPrivMesSend_MemId(privMesSend_MemId);
				priv_messageVO.setPrivMesRec_MemId(privMesRec_MemId);
				priv_messageVO.setPrivMes_content(privMes_content);
				priv_messageVO.setPrivMes_SendTime(privMes_SendTime);
				priv_messageVO.setPrivMes_type(privMes_type);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("priv_messageVO", priv_messageVO); // 含有輸入格式錯誤的priv_messageVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/priv_message/update_priv_message_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Priv_messageService priv_messageSvc = new Priv_messageService();
				priv_messageVO = priv_messageSvc.updatePriv_message(
					privMes_Id
					,privMesSend_MemId
					,privMesRec_MemId
					,privMes_content
					,privMes_SendTime
					,privMes_type
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/priv_message/listPriv_messages_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/priv_message/listAllPriv_message.jsp")){
					req.setAttribute("listPriv_messages_ByMem_Id",priv_messageSvc.getPriv_messagesByMem_Id(privMesSend_MemId)); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/priv_message/listPriv_messages_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/priv_message/listAllPriv_message.jsp")){
					req.setAttribute("listPriv_messages_ByMem_Id",priv_messageSvc.getPriv_messagesByMem_Id(privMesRec_MemId)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/priv_message/listPriv_messages_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Priv_messageVO> list  = priv_messageSvc.getAll(map);
					req.setAttribute("listPriv_messages_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/priv_message/update_priv_message_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addPriv_message.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String privMesSend_MemId = req.getParameter("privMesSend_MemId").trim();	

                String privMesRec_MemId = req.getParameter("privMesRec_MemId").trim();	

                String privMes_content = req.getParameter("privMes_content").trim();	
	
                java.sql.Date privMes_SendTime = null;
                try {
                    privMes_SendTime = java.sql.Date.valueOf(req.getParameter("privMes_SendTime").trim());
                } catch (IllegalArgumentException e) {
                    privMes_SendTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                String privMes_type = req.getParameter("privMes_type").trim();	

                Priv_messageVO priv_messageVO = new Priv_messageVO();
 
                priv_messageVO.setPrivMesSend_MemId(privMesSend_MemId);
 
                priv_messageVO.setPrivMesRec_MemId(privMesRec_MemId);
 
                priv_messageVO.setPrivMes_content(privMes_content);
 
                priv_messageVO.setPrivMes_SendTime(privMes_SendTime);
 
                priv_messageVO.setPrivMes_type(privMes_type);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("priv_messageVO", priv_messageVO); // 含有輸入格式錯誤的priv_messageVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/priv_message/addPriv_message.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Priv_messageService priv_messageSvc = new Priv_messageService();
                priv_messageVO = priv_messageSvc.addPriv_message(
	
                	privMesSend_MemId
	
                	,privMesRec_MemId
	
                	,privMes_content
	
                	,privMes_SendTime
	
                	,privMes_type
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/priv_message/listAllPriv_message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPriv_message.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/priv_message/addPriv_message.jsp");
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
                String privMes_Id = new String(req.getParameter("privMes_Id"));

				/***************************2.開始刪除資料***************************************/
				Priv_messageService priv_messageSvc = new Priv_messageService();

				Priv_messageVO priv_messageVO = priv_messageSvc.getOnePriv_message(privMes_Id);
				priv_messageSvc.deletePriv_message(privMes_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/priv_message/listPriv_messages_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/priv_message/listAllPriv_message.jsp")){
					req.setAttribute("listPriv_messages_ByMem_Id",priv_messageSvc.getPriv_messagesByMem_Id(priv_messageVO.getPrivMesSend_MemId())); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/priv_message/listPriv_messages_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/priv_message/listAllPriv_message.jsp")){
					req.setAttribute("listPriv_messages_ByMem_Id",priv_messageSvc.getPriv_messagesByMem_Id(priv_messageVO.getPrivMesRec_MemId())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/priv_message/listPriv_messages_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Priv_messageVO> list  = priv_messageSvc.getAll(map);
					req.setAttribute("listPriv_messages_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listPriv_messages_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Priv_messageService priv_messageSvc = new Priv_messageService();
                List<Priv_messageVO> list  = priv_messageSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listPriv_messages_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/priv_message/listPriv_messages_ByCompositeQuery.jsp"); // 成功轉交listPriv_messages_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 priv_message/listAllPriv_message.jsp的請求
        if ("listPriv_messages_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String privMesSend_MemId = new String(req.getParameter("privMesSend_MemId"));

                /*************************** 2.開始查詢資料 ****************************************/
                Priv_messageService priv_messageSvc = new Priv_messageService();
                Set<Priv_messageVO> set = priv_messageSvc.getPriv_messagesByMem_Id(privMesSend_MemId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listPriv_messages_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listPriv_messages_ByMem_Id_A".equals(action))
                    url = "/back-end/priv_message/listPriv_messages_ByMem_Id.jsp";        // 成功轉交 priv_message/listPriv_messages_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }


        // 來自select_page.jsp的請求                                  // 來自 priv_message/listAllPriv_message.jsp的請求
        if ("listPriv_messages_ByMem_Id2_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String privMesRec_MemId = new String(req.getParameter("privMesRec_MemId"));

                /*************************** 2.開始查詢資料 ****************************************/
                Priv_messageService priv_messageSvc = new Priv_messageService();
                Set<Priv_messageVO> set = priv_messageSvc.getPriv_messagesByMem_Id(privMesRec_MemId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listPriv_messages_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listPriv_messages_ByMem_Id_A".equals(action))
                    url = "/back-end/priv_message/listPriv_messages_ByMem_Id2.jsp";        // 成功轉交 priv_message/listPriv_messages_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }




	}
}
