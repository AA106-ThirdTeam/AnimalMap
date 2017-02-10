	

package com.offimsg.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.emp.model.*;

import com.offimsg.model.*;
/** 
 *offiMsg : <br>
 *	公告訊息<br>
 *	英文:offiMsg<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/offimsg/offimsg.do" })
public class OffiMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("OffiMsg servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("offiMsg_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("訊息編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   offiMsg_Id = null;
				try {
					offiMsg_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("訊息編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				OffiMsgService offimsgSvc = new OffiMsgService();
				OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);
				
				if (offimsgVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("offimsgVO", offimsgVO); 
				String url = "/back-end/offimsg/listOneOffiMsg.jsp";
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
				String offiMsg_Id = new String(req.getParameter("offiMsg_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				OffiMsgService offimsgSvc = new OffiMsgService();
				OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("offimsgVO", offimsgVO); 		
				String url = "/back-end/offimsg/update_offimsg_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_offimsg_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_offiMsg_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String offiMsg_Id = req.getParameter("offiMsg_Id").trim();
				String offiMsg_empId = req.getParameter("offiMsg_empId").trim();
				String offiMsg_Title = req.getParameter("offiMsg_Title").trim();
				String offiMsg_Content = req.getParameter("offiMsg_Content").trim();
				java.sql.Date offiMsg_Date = null;
				try {
					offiMsg_Date = java.sql.Date.valueOf(req.getParameter("offiMsg_Date").trim());
				} catch (IllegalArgumentException e) {
					offiMsg_Date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				//==== VO設定部分 ====			
				OffiMsgVO offimsgVO = new OffiMsgVO();
				offimsgVO.setOffiMsg_Id(offiMsg_Id);
				offimsgVO.setOffiMsg_empId(offiMsg_empId);
				offimsgVO.setOffiMsg_Title(offiMsg_Title);
				offimsgVO.setOffiMsg_Content(offiMsg_Content);
				offimsgVO.setOffiMsg_Date(offiMsg_Date);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("offimsgVO", offimsgVO); // 含有輸入格式錯誤的offimsgVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/offimsg/update_offimsg_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				OffiMsgService offimsgSvc = new OffiMsgService();
				offimsgVO = offimsgSvc.updateOffiMsg(
					offiMsg_Id
					,offiMsg_empId
					,offiMsg_Title
					,offiMsg_Content
					,offiMsg_Date
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/offimsg/listOffiMsgs_ByEmp_No.jsp") 
					|| requestURL.equals("/back-end/offimsg/listAllOffiMsg.jsp")){
					req.setAttribute("listOffiMsgs_ByEmp_No",offimsgSvc.getOffiMsgsByEmp_No(offiMsg_empId)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/offimsg/listOffiMsgs_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<OffiMsgVO> list  = offimsgSvc.getAll(map);
					req.setAttribute("listOffiMsgs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/offimsg/update_offimsg_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addOffiMsg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String offiMsg_empId = req.getParameter("offiMsg_empId").trim();	

                String offiMsg_Title = req.getParameter("offiMsg_Title").trim();	

                String offiMsg_Content = req.getParameter("offiMsg_Content").trim();	
	
                java.sql.Date offiMsg_Date = null;
                try {
                    offiMsg_Date = java.sql.Date.valueOf(req.getParameter("offiMsg_Date").trim());
                } catch (IllegalArgumentException e) {
                    offiMsg_Date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                OffiMsgVO offimsgVO = new OffiMsgVO();
 
                offimsgVO.setOffiMsg_empId(offiMsg_empId);
 
                offimsgVO.setOffiMsg_Title(offiMsg_Title);
 
                offimsgVO.setOffiMsg_Content(offiMsg_Content);
 
                offimsgVO.setOffiMsg_Date(offiMsg_Date);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("offimsgVO", offimsgVO); // 含有輸入格式錯誤的offimsgVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/offimsg/addOffiMsg.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                OffiMsgService offimsgSvc = new OffiMsgService();
                offimsgVO = offimsgSvc.addOffiMsg(
	
                	offiMsg_empId
	
                	,offiMsg_Title
	
                	,offiMsg_Content
	
                	,offiMsg_Date
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/offimsg/listAllOffiMsg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOffiMsg.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/offimsg/addOffiMsg.jsp");
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
                String offiMsg_Id = new String(req.getParameter("offiMsg_Id"));

				/***************************2.開始刪除資料***************************************/
				OffiMsgService offimsgSvc = new OffiMsgService();

				OffiMsgVO offimsgVO = offimsgSvc.getOneOffiMsg(offiMsg_Id);
				offimsgSvc.deleteOffiMsg(offiMsg_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/offimsg/listOffiMsgs_ByEmp_No.jsp") 
					|| requestURL.equals("/back-end/offimsg/listAllOffiMsg.jsp")){
					req.setAttribute("listOffiMsgs_ByEmp_No",offimsgSvc.getOffiMsgsByEmp_No(offimsgVO.getOffiMsg_empId())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/offimsg/listOffiMsgs_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<OffiMsgVO> list  = offimsgSvc.getAll(map);
					req.setAttribute("listOffiMsgs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listOffiMsgs_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                OffiMsgService offimsgSvc = new OffiMsgService();
                List<OffiMsgVO> list  = offimsgSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listOffiMsgs_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/offimsg/listOffiMsgs_ByCompositeQuery.jsp"); // 成功轉交listOffiMsgs_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 offimsg/listAllOffiMsg.jsp的請求
        if ("listOffiMsgs_ByEmp_No_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String offiMsg_empId = new String(req.getParameter("offiMsg_empId"));

                /*************************** 2.開始查詢資料 ****************************************/
                OffiMsgService offimsgSvc = new OffiMsgService();
                Set<OffiMsgVO> set = offimsgSvc.getOffiMsgsByEmp_No(offiMsg_empId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listOffiMsgs_ByEmp_No", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listOffiMsgs_ByEmp_No_A".equals(action))
                    url = "/back-end/offimsg/listOffiMsgs_ByEmp_No.jsp";        // 成功轉交 offimsg/listOffiMsgs_ByEmp_No.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }




	}
}
