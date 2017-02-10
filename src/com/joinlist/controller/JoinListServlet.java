	

package com.joinlist.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.pet_group.model.*;

import com.mem.model.*;
	
import com.pet_group.model.*;
	
import com.mem.model.*;

import com.joinlist.model.*;
/** 
 *JoinList : <br>
 *	揪團參加名單<br>
 *	英文:JoinList<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/joinlist/joinlist.do" })
public class JoinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("JoinList servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("joinList_GrpId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("活動編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   joinList_GrpId = null;
				try {
					joinList_GrpId = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("活動編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				JoinListService joinlistSvc = new JoinListService();
				JoinListVO joinlistVO = joinlistSvc.getOneJoinList_By_joinList_GrpId(joinList_GrpId);
				
				if (joinlistVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("joinlistVO", joinlistVO); 
				String url = "/back-end/joinlist/listOneJoinList.jsp";
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
				String joinList_GrpId = new String(req.getParameter("joinList_GrpId").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				JoinListService joinlistSvc = new JoinListService();
				JoinListVO joinlistVO = joinlistSvc.getOneJoinList_By_joinList_GrpId(joinList_GrpId);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("joinlistVO", joinlistVO); 		
				String url = "/back-end/joinlist/update_joinlist_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_joinlist_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_JoinList_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String joinList_GrpId = req.getParameter("joinList_GrpId").trim();
				String joinList_MemId = req.getParameter("joinList_MemId").trim();

				//==== VO設定部分 ====			
				JoinListVO joinlistVO = new JoinListVO();
				joinlistVO.setJoinList_GrpId(joinList_GrpId);
				joinlistVO.setJoinList_MemId(joinList_MemId);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("joinlistVO", joinlistVO); // 含有輸入格式錯誤的joinlistVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/joinlist/update_joinlist_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				JoinListService joinlistSvc = new JoinListService();
				joinlistVO = joinlistSvc.updateJoinList(
					joinList_GrpId
					,joinList_MemId
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/joinlist/listJoinLists_ByGrp_Id.jsp") 
					|| requestURL.equals("/back-end/joinlist/listAllJoinList.jsp")){
					req.setAttribute("listJoinLists_ByGrp_Id",joinlistSvc.getJoinListsByGrp_Id(joinList_GrpId)); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/joinlist/listJoinLists_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/joinlist/listAllJoinList.jsp")){
					req.setAttribute("listJoinLists_ByMem_Id",joinlistSvc.getJoinListsByMem_Id(joinList_MemId)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/joinlist/listJoinLists_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<JoinListVO> list  = joinlistSvc.getAll(map);
					req.setAttribute("listJoinLists_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/joinlist/update_joinlist_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addJoinList.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                JoinListVO joinlistVO = new JoinListVO();
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("joinlistVO", joinlistVO); // 含有輸入格式錯誤的joinlistVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/joinlist/addJoinList.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                JoinListService joinlistSvc = new JoinListService();
                joinlistVO = joinlistSvc.addJoinList(
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/joinlist/listAllJoinList.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllJoinList.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/joinlist/addJoinList.jsp");
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
                String joinList_GrpId = new String(req.getParameter("joinList_GrpId"));

				/***************************2.開始刪除資料***************************************/
				JoinListService joinlistSvc = new JoinListService();

				JoinListVO joinlistVO = joinlistSvc.getOneJoinList_By_joinList_GrpId(joinList_GrpId);
				joinlistSvc.deleteJoinList_By_joinList_GrpId(joinList_GrpId);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/joinlist/listJoinLists_ByGrp_Id.jsp") 
					|| requestURL.equals("/back-end/joinlist/listAllJoinList.jsp")){
					req.setAttribute("listJoinLists_ByGrp_Id",joinlistSvc.getJoinListsByGrp_Id(joinlistVO.getJoinList_GrpId())); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/joinlist/listJoinLists_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/joinlist/listAllJoinList.jsp")){
					req.setAttribute("listJoinLists_ByMem_Id",joinlistSvc.getJoinListsByMem_Id(joinlistVO.getJoinList_MemId())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/joinlist/listJoinLists_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<JoinListVO> list  = joinlistSvc.getAll(map);
					req.setAttribute("listJoinLists_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listJoinLists_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                JoinListService joinlistSvc = new JoinListService();
                List<JoinListVO> list  = joinlistSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listJoinLists_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/joinlist/listJoinLists_ByCompositeQuery.jsp"); // 成功轉交listJoinLists_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	

        // 來自select_page.jsp的請求                                  // 來自 joinlist/listAllJoinList.jsp的請求
        if ("listJoinLists_ByGrp_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String joinList_GrpId = new String(req.getParameter("joinList_GrpId"));

                /*************************** 2.開始查詢資料 ****************************************/
                JoinListService joinlistSvc = new JoinListService();
                Set<JoinListVO> set = joinlistSvc.getJoinListsByGrp_Id(joinList_GrpId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listJoinLists_ByGrp_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listJoinLists_ByGrp_Id_A".equals(action))
                    url = "/back-end/joinlist/listJoinLists_ByGrp_Id.jsp";        // 成功轉交 joinlist/listJoinLists_ByGrp_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }


        // 來自select_page.jsp的請求                                  // 來自 joinlist/listAllJoinList.jsp的請求
        if ("listJoinLists_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String joinList_MemId = new String(req.getParameter("joinList_MemId"));

                /*************************** 2.開始查詢資料 ****************************************/
                JoinListService joinlistSvc = new JoinListService();
                Set<JoinListVO> set = joinlistSvc.getJoinListsByMem_Id(joinList_MemId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listJoinLists_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listJoinLists_ByMem_Id_A".equals(action))
                    url = "/back-end/joinlist/listJoinLists_ByMem_Id.jsp";        // 成功轉交 joinlist/listJoinLists_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }

	}
}
