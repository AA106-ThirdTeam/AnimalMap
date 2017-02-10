	

package com.grp_comment.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;

import com.pet_group.model.*;

import com.grp_comment.model.*;
/** 
 *grp_comment : <br>
 *	揪團留言<br>
 *	英文:grp_comment<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/grp_comment/grp_comment.do" })
public class Grp_commentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Grp_comment servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("grpComment_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("揪團留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   grpComment_Id = null;
				try {
					grpComment_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("揪團留言編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				Grp_commentService grp_commentSvc = new Grp_commentService();
				Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);
				
				if (grp_commentVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("grp_commentVO", grp_commentVO); 
				String url = "/back-end/grp_comment/listOneGrp_comment.jsp";
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
				String grpComment_Id = new String(req.getParameter("grpComment_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Grp_commentService grp_commentSvc = new Grp_commentService();
				Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("grp_commentVO", grp_commentVO); 		
				String url = "/back-end/grp_comment/update_grp_comment_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_grp_comment_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_grp_comment_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String grpComment_Id = req.getParameter("grpComment_Id").trim();
				String grpComment_MemId = req.getParameter("grpComment_MemId").trim();
				String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
				String grpComment_content = req.getParameter("grpComment_content").trim();
				java.sql.Date grpComment_SendTime = null;
				try {
					grpComment_SendTime = java.sql.Date.valueOf(req.getParameter("grpComment_SendTime").trim());
				} catch (IllegalArgumentException e) {
					grpComment_SendTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				//==== VO設定部分 ====			
				Grp_commentVO grp_commentVO = new Grp_commentVO();
				grp_commentVO.setGrpComment_Id(grpComment_Id);
				grp_commentVO.setGrpComment_MemId(grpComment_MemId);
				grp_commentVO.setGrpComment_GrpId(grpComment_GrpId);
				grp_commentVO.setGrpComment_content(grpComment_content);
				grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("grp_commentVO", grp_commentVO); // 含有輸入格式錯誤的grp_commentVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/grp_comment/update_grp_comment_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Grp_commentService grp_commentSvc = new Grp_commentService();
				grp_commentVO = grp_commentSvc.updateGrp_comment(
					grpComment_Id
					,grpComment_MemId
					,grpComment_GrpId
					,grpComment_content
					,grpComment_SendTime
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/grp_comment/listGrp_comments_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/grp_comment/listAllGrp_comment.jsp")){
					req.setAttribute("listGrp_comments_ByMem_Id",grp_commentSvc.getGrp_commentsByMem_Id(grpComment_MemId)); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/grp_comment/listGrp_comments_ByGrp_Id.jsp") 
					|| requestURL.equals("/back-end/grp_comment/listAllGrp_comment.jsp")){
					req.setAttribute("listGrp_comments_ByGrp_Id",grp_commentSvc.getGrp_commentsByGrp_Id(grpComment_GrpId)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/grp_comment/listGrp_comments_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Grp_commentVO> list  = grp_commentSvc.getAll(map);
					req.setAttribute("listGrp_comments_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/grp_comment/update_grp_comment_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addGrp_comment.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String grpComment_MemId = req.getParameter("grpComment_MemId").trim();	

                String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();	

                String grpComment_content = req.getParameter("grpComment_content").trim();	
	
                java.sql.Date grpComment_SendTime = null;
                try {
                    grpComment_SendTime = java.sql.Date.valueOf(req.getParameter("grpComment_SendTime").trim());
                } catch (IllegalArgumentException e) {
                    grpComment_SendTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                Grp_commentVO grp_commentVO = new Grp_commentVO();
 
                grp_commentVO.setGrpComment_MemId(grpComment_MemId);
 
                grp_commentVO.setGrpComment_GrpId(grpComment_GrpId);
 
                grp_commentVO.setGrpComment_content(grpComment_content);
 
                grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("grp_commentVO", grp_commentVO); // 含有輸入格式錯誤的grp_commentVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/grp_comment/addGrp_comment.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Grp_commentService grp_commentSvc = new Grp_commentService();
                grp_commentVO = grp_commentSvc.addGrp_comment(
	
                	grpComment_MemId
	
                	,grpComment_GrpId
	
                	,grpComment_content
	
                	,grpComment_SendTime
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/grp_comment/listAllGrp_comment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllGrp_comment.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/grp_comment/addGrp_comment.jsp");
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
                String grpComment_Id = new String(req.getParameter("grpComment_Id"));

				/***************************2.開始刪除資料***************************************/
				Grp_commentService grp_commentSvc = new Grp_commentService();

				Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);
				grp_commentSvc.deleteGrp_comment(grpComment_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/grp_comment/listGrp_comments_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/grp_comment/listAllGrp_comment.jsp")){
					req.setAttribute("listGrp_comments_ByMem_Id",grp_commentSvc.getGrp_commentsByMem_Id(grp_commentVO.getGrpComment_MemId())); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/grp_comment/listGrp_comments_ByGrp_Id.jsp") 
					|| requestURL.equals("/back-end/grp_comment/listAllGrp_comment.jsp")){
					req.setAttribute("listGrp_comments_ByGrp_Id",grp_commentSvc.getGrp_commentsByGrp_Id(grp_commentVO.getGrpComment_GrpId())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/grp_comment/listGrp_comments_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Grp_commentVO> list  = grp_commentSvc.getAll(map);
					req.setAttribute("listGrp_comments_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listGrp_comments_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Grp_commentService grp_commentSvc = new Grp_commentService();
                List<Grp_commentVO> list  = grp_commentSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listGrp_comments_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/grp_comment/listGrp_comments_ByCompositeQuery.jsp"); // 成功轉交listGrp_comments_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 grp_comment/listAllGrp_comment.jsp的請求
        if ("listGrp_comments_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String grpComment_MemId = new String(req.getParameter("grpComment_MemId"));

                /*************************** 2.開始查詢資料 ****************************************/
                Grp_commentService grp_commentSvc = new Grp_commentService();
                Set<Grp_commentVO> set = grp_commentSvc.getGrp_commentsByMem_Id(grpComment_MemId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listGrp_comments_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listGrp_comments_ByMem_Id_A".equals(action))
                    url = "/back-end/grp_comment/listGrp_comments_ByMem_Id.jsp";        // 成功轉交 grp_comment/listGrp_comments_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }


        // 來自select_page.jsp的請求                                  // 來自 grp_comment/listAllGrp_comment.jsp的請求
        if ("listGrp_comments_ByGrp_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String grpComment_GrpId = new String(req.getParameter("grpComment_GrpId"));

                /*************************** 2.開始查詢資料 ****************************************/
                Grp_commentService grp_commentSvc = new Grp_commentService();
                Set<Grp_commentVO> set = grp_commentSvc.getGrp_commentsByGrp_Id(grpComment_GrpId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listGrp_comments_ByGrp_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listGrp_comments_ByGrp_Id_A".equals(action))
                    url = "/back-end/grp_comment/listGrp_comments_ByGrp_Id.jsp";        // 成功轉交 grp_comment/listGrp_comments_ByGrp_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }



	}
}
