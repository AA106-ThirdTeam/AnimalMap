package com.joinlist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grp.model.GrpService;
import com.joinlist.model.JoinListService;
import com.joinlist.model.JoinListVO;
import com.rel_list.model.Rel_ListService;
import com.rel_list.model.Rel_ListVO;


public class JoinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("action="+action);
		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("joinList_GrpId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入活動編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  joinList_GrpId = null;
				try {
					joinList_GrpId = new String (str);
				} catch (Exception e) {
					errorMsgs.add("活動編號格式不正確");				}
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
				String url = "/joinlist/listOneJoinList.jsp";
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
				String  joinList_GrpId = new String (req.getParameter("joinList_GrpId").trim());

				/***************************2.開始查詢資料*****************************************/
				JoinListService joinlistSvc = new JoinListService();
				JoinListVO joinlistVO = joinlistSvc.getOneJoinList_By_joinList_GrpId(joinList_GrpId);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("joinlistVO", joinlistVO); 
				String url = "/joinlist/update_joinlist_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}

	
		
		
        if ("joinGrp".equals(action)) { // 來自addJoinList.jsp的請求  
			
        	PrintWriter out = res.getWriter();
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String joinList_GrpId = req.getParameter("grp_Id");
				String joinList_MemId = req.getParameter("joinList_MemId");
				String requestURL = req.getParameter("requestURL");
				
				
                JoinListVO joinlistVO = new JoinListVO();
                
                joinlistVO.setJoinList_GrpId(joinList_GrpId);
                joinlistVO.setJoinList_MemId(joinList_MemId);
                joinlistVO.setJoinList_isInvited("0");
                
                /***************************2.開始新增資料***************************************/
                JoinListService joinlistSvc = new JoinListService();
                joinlistVO = joinlistSvc.addJoinList(joinlistVO); 
                GrpService grpSvc =  new GrpService();

                int count = grpSvc.getCount(joinList_GrpId);
                out.print(count);
                System.out.println(count);
			/***************************其他可能的錯誤處理**********************************/
			
		}
        
        
        
        if ("cancelJoinGrp".equals(action)) { // 來自listAllJoinList.jsp 或  /dept/listJoinLists_ByDeptno.jsp的請求

        	PrintWriter out = res.getWriter();
            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/joinlist/listAllJoinList.jsp】 或  【/dept/listJoinLists_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /joinlist/listJoinLists_ByCompositeQuery.jsp】

          
                /***************************1.接收請求參數***************************************/
                String joinList_GrpId = req.getParameter("grp_Id");
                String joinList_MemId = req.getParameter("joinList_MemId");
                
                /***************************2.開始刪除資料***************************************/
                JoinListService joinlistSvc = new JoinListService();
                GrpService grpSvc =  new GrpService();
                
                
                
                joinlistSvc.delete(joinList_GrpId,joinList_MemId);
                int count = grpSvc.getCount(joinList_GrpId);
                
                out.print(count);
                
        }
        
        if ("listRelation_forInviteGrp".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1. ****************************************/
				String grp_MemId = req.getParameter("grp_MemId");
				String grp_Id = req.getParameter("grp_Id");
				/*************************** 2. ****************************************/
				Rel_ListService relSvc = new Rel_ListService();
				GrpService grpSvc = new GrpService();
				
				
				Set<JoinListVO> joinListSet = grpSvc.getJoinListByGrpId(grp_Id);
				Set<Rel_ListVO> relMemIdSet = relSvc.getRel_ListByRel_MemId(grp_MemId);
				/*************************** 3.(Send the Success view) ************/
				
				req.setAttribute("listJoinMem_ByGrpId", joinListSet);
				req.setAttribute("listRelation_ByMemId", relMemIdSet);  
				req.setAttribute("grp_Id", grp_Id);  
				
				String url = null;
				String requestURL = req.getParameter("requestURL");
				
				System.out.println("grp_MemId="+grp_MemId);
				System.out.println("grp_Id="+grp_Id);
				System.out.println("requestURL="+requestURL);
				
				
				 if ("/front-end/grp/listJoinMem_ByGrpId_FrontEnd.jsp".equals(requestURL))
					url = "/front-end/grp/listRelation_forInviteGrp.jsp";             

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z ***********************************/
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
        
        
        if ("inviteFriendToGrp".equals(action)) {
        	
        		
        		String grp_Id = req.getParameter("grp_Id");
        		String values[] = req.getParameterValues("invitedMemId");
        		Set<JoinListVO> inviteList = new LinkedHashSet<>();
        		JoinListVO joinListVO = null;
 System.out.println("req.getParameter(grp_Id)="+req.getParameter("grp_Id")); 		        		
        		for(String aMemId:values){
        			joinListVO = new JoinListVO();
        			joinListVO.setJoinList_GrpId(grp_Id);
        			joinListVO.setJoinList_MemId(aMemId);
        			joinListVO.setJoinList_isInvited("1");
        			inviteList.add(joinListVO);
        		}
        		
        		JoinListService jlSvc = new JoinListService();
        		
        		jlSvc.BatchInsert(inviteList);
        		
        		
        		Rel_ListService relSvc = new Rel_ListService();
        		GrpService grpSvc = new GrpService();
        		
        		
        		Set<JoinListVO> joinListSet = grpSvc.getJoinListByGrpId(grp_Id);
        		
        		req.setAttribute("listJoinMem_ByGrpId", joinListSet);
        		req.setAttribute("includeInfo", "includeInfo");  
        		req.setAttribute("grpVO", grpSvc.getOneGrp(grp_Id));  
        		
        		
        		
        		String url = null;
        		String requestURL = req.getParameter("requestURL");
        		
//        		System.out.println("grp_MemId="+grp_MemId);
        		System.out.println("grp_Id="+grp_Id);
        		System.out.println("requestURL="+requestURL);
        		
        		
        		if ("/front-end/grp/listRelation_forInviteGrp.jsp".equals(requestURL))
        			url = "/front-end/grp/listOneGrp_Index.jsp";             
        		
        		RequestDispatcher successView = req.getRequestDispatcher(url);
        		successView.forward(req, res);
        		
        		
        	
        }
        
        
        if("confirmJoinGrp".equals(action)){
        	String joinList_GrpId = req.getParameter("joinList_GrpId");
        	String joinList_MemId = req.getParameter("joinList_MemId");
        	
        	JoinListVO joinlistVO = new JoinListVO();
        	JoinListService jlSvc = new JoinListService();
        
        	joinlistVO.setJoinList_GrpId(joinList_GrpId);
        	joinlistVO.setJoinList_MemId(joinList_MemId);
        	joinlistVO.setJoinList_isInvited("0");
        	
        	jlSvc.update(joinlistVO);
        	
        	String url = null;
    		String requestURL = req.getParameter("requestURL");
System.out.println("requestURL===="+requestURL);
//    		if ("/front-end/mem_dream/listAllMem.jsp".equals(requestURL))
//    			url = "/front-end/mem_dream/listAllmem.jsp";             
//    		
//    		RequestDispatcher successView = req.getRequestDispatcher(url);
//    		successView.forward(req, res);
    		
        	
        }
        
        
        
	}
}
