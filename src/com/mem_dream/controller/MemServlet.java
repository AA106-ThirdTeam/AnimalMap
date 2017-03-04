package com.mem_dream.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.grp.model.GrpService;
import com.joinlist.model.JoinListService;
import com.joinlist.model.JoinListVO;
import com.mem_dream.model.MemService;
import com.mem_dream.model.MemVO;
import com.priv_message.model.Priv_messageService;
import com.priv_message.model.Priv_messageVO;
import com.rel_list.model.Rel_ListService;
import com.rel_list.model.Rel_ListVO;
/** 
 *表格名稱 : <br>
 *	中文:一般會員<br>
 *	英文:mem<br>
 */ 
@WebServlet(urlPatterns = { "/mem_dream/mem.do" })
public class MemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
        res.setContentType("text/html; charset=UTF-8");


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("mem_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入會員編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  mem_Id = null;
				try {
					mem_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("會員編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(mem_Id);
				if (memVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memVO", memVO); 
				String url = "/mem_dream/listOneMem.jsp";
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
				String  mem_Id = new String (req.getParameter("mem_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(mem_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memVO", memVO); 
				String url = "/mem_dream/update_mem_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		//====update====
		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL"); 
			try {

				/***************************1.接收請求參數****************************************/
				String mem_Id = req.getParameter("mem_Id").trim();
				String mem_account = req.getParameter("mem_account").trim();
				String mem_Psw = req.getParameter("mem_Psw").trim();
				String mem_nick_name = req.getParameter("mem_nick_name").trim();
				String mem_name = req.getParameter("mem_name").trim();
				String mem_gender = req.getParameter("mem_gender").trim();
				String mem_Tw_Id = req.getParameter("mem_Tw_Id").trim();
				java.sql.Date mem_birth_date = null;
				try {
					mem_birth_date = java.sql.Date.valueOf(req.getParameter("mem_birth_date").trim());
				} catch (IllegalArgumentException e) {
					mem_birth_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String mem_phone = req.getParameter("mem_phone").trim();
				String mem_Intro = req.getParameter("mem_Intro").trim();
				String mem_profile = req.getParameter("mem_profile").trim();
				String mem_black_list = req.getParameter("mem_black_list").trim();
				String mem_permission = req.getParameter("mem_permission").trim();
				String mem_setting = req.getParameter("mem_setting").trim();
				Integer mem_balance = new Integer(req.getParameter("mem_balance").trim());

				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				memVO.setMem_account(mem_account);
				memVO.setMem_Psw(mem_Psw);
				memVO.setMem_nick_name(mem_nick_name);
				memVO.setMem_name(mem_name);
				memVO.setMem_gender(mem_gender);
				memVO.setMem_Tw_Id(mem_Tw_Id);
				memVO.setMem_birth_date(mem_birth_date);
				memVO.setMem_phone(mem_phone);
				memVO.setMem_Intro(mem_Intro);
				memVO.setMem_profile(mem_profile);
				memVO.setMem_black_list(mem_black_list);
				memVO.setMem_permission(mem_permission);
				memVO.setMem_setting(mem_setting);
				memVO.setMem_balance(mem_balance);
				if (!errorMsgs.isEmpty()) {
					String url = "/mem_dream/update_mem_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				MemService memSvc = new MemService();
				memVO = memSvc.updateMem(mem_Id,mem_account,mem_Psw,mem_nick_name,mem_name,mem_gender,mem_Tw_Id,mem_birth_date,mem_phone,mem_Intro,mem_profile,mem_black_list,mem_permission,mem_setting,mem_balance);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memVO", memVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/mem_dream/update_mem_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addMem.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_account = req.getParameter("mem_account").trim();
                String mem_Psw = req.getParameter("mem_Psw").trim();
                String mem_nick_name = req.getParameter("mem_nick_name").trim();
                String mem_name = req.getParameter("mem_name").trim();
                String mem_gender = req.getParameter("mem_gender").trim();
                String mem_Tw_Id = req.getParameter("mem_Tw_Id").trim();
                java.sql.Date mem_birth_date = null;
                try {
                    mem_birth_date = java.sql.Date.valueOf(req.getParameter("mem_birth_date").trim());
                } catch (IllegalArgumentException e) {
                    mem_birth_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String mem_phone = req.getParameter("mem_phone").trim();
                String mem_Intro = req.getParameter("mem_Intro").trim();
                String mem_profile = req.getParameter("mem_profile").trim();
                String mem_black_list = req.getParameter("mem_black_list").trim();
                String mem_permission = req.getParameter("mem_permission").trim();
                String mem_setting = req.getParameter("mem_setting").trim();
                Integer mem_balance = new Integer(req.getParameter("mem_balance").trim());

                MemVO memVO = new MemVO();
                memVO.setMem_account(mem_account);
                memVO.setMem_Psw(mem_Psw);
                memVO.setMem_nick_name(mem_nick_name);
                memVO.setMem_name(mem_name);
                memVO.setMem_gender(mem_gender);
                memVO.setMem_Tw_Id(mem_Tw_Id);
                memVO.setMem_birth_date(mem_birth_date);
                memVO.setMem_phone(mem_phone);
                memVO.setMem_Intro(mem_Intro);
                memVO.setMem_profile(mem_profile);
                memVO.setMem_black_list(mem_black_list);
                memVO.setMem_permission(mem_permission);
                memVO.setMem_setting(mem_setting);
                memVO.setMem_balance(mem_balance);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的memVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/mem_dream/addMem.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                MemService memSvc = new MemService();
                memVO = memSvc.addMem(mem_account,mem_Psw,mem_nick_name,mem_name,mem_gender,mem_Tw_Id,mem_birth_date,mem_phone,mem_Intro,mem_profile,mem_black_list,mem_permission,mem_setting,mem_balance); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/mem_dream/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/mem_dream/addMem.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllMem.jsp 或  /dept/listMems_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/mem_dream/listAllMem.jsp】 或  【/dept/listMems_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /mem_dream/listMems_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String mem_Id = new String(req.getParameter("mem_Id"));
                
                
                /***************************2.開始刪除資料***************************************/
                MemService memSvc = new MemService();
                MemVO memVO = memSvc.getOneMem(mem_Id);
   
                memSvc.deleteMem(mem_Id);
             
                
                /***************************3.刪除完成,準備轉交(Send the Success view)***********/             
                String url = requestURL;
                RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功後,轉交回送出刪除的來源網頁
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add("刪除資料失敗:"+e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher(requestURL);
                failureView.forward(req, res);
            }
        }
        
        
        if ("listRelation_ByMemId".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1. ****************************************/
				String rel_MemId = req.getParameter("rel_MemId");
				
				/*************************** 2. ****************************************/
				Rel_ListService relSvc = new Rel_ListService();
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(rel_MemId);
				String added_MemId = memVO.getMem_Id();
				
				Set<Rel_ListVO> addedMemIdSet = relSvc.getRel_ListByAdded_MemId(added_MemId);
				Set<Rel_ListVO> relMemIdSet = relSvc.getRel_ListByRel_MemId(rel_MemId);
				/*************************** 3.(Send the Success view) ************/
				
				req.setAttribute("rel_list_memVO", memVO);
				req.setAttribute("listRelation_ByAddedMemId", addedMemIdSet);
				req.setAttribute("listRelation_ByMemId", relMemIdSet);    // request
				req.setAttribute("listRelation", "listRelation");    // request
				
//System.out.println("rel_MemId="+rel_MemId);
//System.out.println("memVO.getOneMem="+memVO.getMem_Id());
			
				
				String url = null;
				 if ("listRelation_ByMemId".equals(action))
					url = "/front-end/mem_dream/listAllMem.jsp";             

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z ***********************************/
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
        
        //假LOGIN
        
        if ("login".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
			
				String loginMemId = req.getParameter("loginMemId");
								
				String url = null;
				
				req.getSession().setAttribute("loginMemId", loginMemId);
				
				url = "/front-end/mem_dream/listAllMem.jsp";         

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}	
        
        if ("listPrivMsg_ByMemId".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			
				/*************************** 1 ****************************************/
				String privMsgSend_MemId = req.getParameter("privMsgSend_MemId");
				String privMsgRec_MemId =req.getParameter("privMsgRec_MemId");
				
				Rel_ListService relSvc = new Rel_ListService();
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(privMsgRec_MemId);
				String added_MemId = memVO.getMem_Id();
				
				Set<Rel_ListVO> addedMemIdSet = relSvc.getRel_ListByAdded_MemId(added_MemId);
//因為需要  看到邀請成為好友的人 所以要LISTRELATION
				req.setAttribute("rel_list_memVO", memVO);
				req.setAttribute("listRelation_ByAddedMemId", addedMemIdSet);
				/*************************** 2. ****************************************/
				Priv_messageService privMsgSvc = new Priv_messageService();
										
				Set<Priv_messageVO> listPrivMsg_ByRecMemId = privMsgSvc.getPriv_MessageByRec_MemId(privMsgRec_MemId);
				Set<Priv_messageVO> listPrivMsg_BySendMemId = privMsgSvc.getPriv_MessageBySend_MemId(privMsgRec_MemId);
				/*************************** 3.(Send the Success view) ************/
				
				
//寄送訊息的清單
				req.setAttribute("listPrivMsg_ByRecMemId", listPrivMsg_ByRecMemId);
				req.setAttribute("listPrivMsg_BySendMemId", listPrivMsg_BySendMemId);    
				req.setAttribute("listPrivMsg", "listPrivMsg");   
				
				
				GrpService grpSvc = new GrpService();
				Set<JoinListVO> listGrps_ByMemId = grpSvc.getJoinListByMemId(privMsgRec_MemId);
				
				
//加入揪團的清單(未加入只被邀請的也含在內)
				req.setAttribute("listGrps_ByMemId", listGrps_ByMemId);
				
				
				

				
				String url = null;
				 if ("listPrivMsg_ByMemId".equals(action))
					url = "/front-end/mem_dream/listAllMem.jsp";          

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			
		}
        
        if ("getStartChatMsg".equals(action)) {
        	
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			PrintWriter out = res.getWriter();
			
				/*************************** 1 ****************************************/
				String privMsgSend_MemId = req.getParameter("privMsgSend_MemId");
				String privMsgRec_MemId = req.getParameter("privMsgRec_MemId");
				
				/*************************** 2. ****************************************/
				Priv_messageService privMsgSvc = new Priv_messageService();
				
				
				Set<Priv_messageVO> listPrivMsg_ByMemId = privMsgSvc.getAllPriv_MessageByMem_Id(privMsgSend_MemId,privMsgRec_MemId);
				
				/*************************** 3.(Send the Success view) ************/
				JsonArrayBuilder privMsgArrayBuilder = Json.createArrayBuilder();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
				String sendTime=null;
				
				MemService memSvc = new MemService();
				MemVO memVO = null;
				String userName = null;
				String memPhoto = null;
				for(Priv_messageVO aPrivMsgVO : listPrivMsg_ByMemId){
					
					memVO = memSvc.getOneMem(aPrivMsgVO.getPrivMsgSend_MemId());
					userName = memVO.getMem_nick_name();
					sendTime = sdf.format(new java.util.Date(aPrivMsgVO.getPrivMsg_SendTime().getTime()));	
					memPhoto = memVO.getMem_profile();
					privMsgArrayBuilder.add(Json.createObjectBuilder()
												.add("memPhoto", memPhoto)
												.add("userName",userName)
												.add("message",aPrivMsgVO.getPrivMsg_content())
												.add("sendTime",sendTime)
												.add("privMsgSend_MemId", aPrivMsgVO.getPrivMsgSend_MemId()));
				}
								
				
				 JsonArray privMsgArray = privMsgArrayBuilder.build();
				 
//				 System.out.println(privMsgArray.toString());
				 out.print( "{\"recievedJsonArray\":"+privMsgArray+"}");
				 Priv_messageService privSvc = new Priv_messageService();
				 
				 
				 
				 for(Priv_messageVO aPriv_messageVO:listPrivMsg_ByMemId){
					 aPriv_messageVO.setPrivMsg_type("1");
				 }
				 
				 
				 privSvc.batchUpdate(listPrivMsg_ByMemId);
				 
				 System.out.println(privMsgArray);
				 
		}
        
        if("getUnreadMsgCount".equals(action)){
        	
        	PrintWriter out = res.getWriter();
        	
        	int counter=0;        	
        	String mem_Id = req.getParameter("mem_Id");
        	String requestURL = req.getParameter("requestURL");
        	Priv_messageService privMsgSvc = new Priv_messageService();
        	Rel_ListService relSvc = new Rel_ListService();
        	JoinListService joinSvc = new JoinListService();
        	
        	Set<Priv_messageVO> privMsgSet = privMsgSvc.getPriv_MessageByRec_MemId(mem_Id);
        	Set<Rel_ListVO> relSet = relSvc.getRel_ListByAdded_MemId(mem_Id);
        	Set<JoinListVO> joinSet = joinSvc.getJoinListByMemId(mem_Id);
        	
        	String msgSender="";
        	
        	if(privMsgSet!=null){
	        	for(Priv_messageVO aPriv_messageVO:privMsgSet){
	        		if(!msgSender.equals(aPriv_messageVO.getPrivMsgSend_MemId())){
		        		if(aPriv_messageVO.getPrivMsg_type().equals("0")){
		        			counter++;
		        		}
	        		}
	        		msgSender=aPriv_messageVO.getPrivMsgSend_MemId();
	        	}
        	}
        	
        	if(relSet!=null){
	        	for(Rel_ListVO aRel_ListVO:relSet){
	        		if(aRel_ListVO.getIsInvited().equals("1")){
	        			counter++;
	        		}
	        	}
        	}
        	
        	if(joinSet!=null){
        		for(JoinListVO aJoinListVO:joinSet){
        			if(aJoinListVO.getJoinList_isInvited().equals("1")){
        				counter++;
        			}
        		}
        	}
        	
        	System.out.println("counter="+counter);
        	System.out.println("GET UNREAD MSG COUNT mem_Id="+mem_Id);
        	
        	out.print(counter);
        	
        }
        
        
        
        
        
	}
}
