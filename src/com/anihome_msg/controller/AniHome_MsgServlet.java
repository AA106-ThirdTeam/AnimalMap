package com.anihome_msg.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.anihome.model.*;
import com.mem.model.*;
import com.anihome_msg.model.*;
/** 
 *表格名稱 : <br>
 *	中文:動物之家留言<br>
 *	英文:aniHome_Msg<br>
 */ 
@WebServlet(urlPatterns = { "/anihome_msg/anihome_msg.do" })
public class AniHome_MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("AniHome_Msg servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("aniHome_Msg_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入動物之家留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  aniHome_Msg_Id = null;
				try {
					aniHome_Msg_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("動物之家留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
				AniHome_MsgVO anihome_msgVO = anihome_msgSvc.getOneAniHome_Msg(aniHome_Msg_Id);
				if (anihome_msgVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihome_msgVO", anihome_msgVO); 
				String url = "/anihome_msg/listOneAniHome_Msg.jsp";
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
				String  aniHome_Msg_Id = new String (req.getParameter("aniHome_Msg_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
				AniHome_MsgVO anihome_msgVO = anihome_msgSvc.getOneAniHome_Msg(aniHome_Msg_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihome_msgVO", anihome_msgVO); 
				String url = "/anihome_msg/update_anihome_msg_input.jsp";
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
				String aniHome_Msg_Id = req.getParameter("aniHome_Msg_Id").trim();
				String aniHome_Id = req.getParameter("aniHome_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String aniHome_Msg = req.getParameter("aniHome_Msg").trim();
				java.sql.Date adp_start_date = null;
				try {
					adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
				} catch (IllegalArgumentException e) {
					adp_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
				anihome_msgVO.setAniHome_Msg_Id(aniHome_Msg_Id);
				anihome_msgVO.setAniHome_Id(aniHome_Id);
				anihome_msgVO.setMem_Id(mem_Id);
				anihome_msgVO.setAniHome_Msg(aniHome_Msg);
				anihome_msgVO.setAdp_start_date(adp_start_date);
				if (!errorMsgs.isEmpty()) {
					String url = "/anihome_msg/update_anihome_msg_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
				anihome_msgVO = anihome_msgSvc.updateAniHome_Msg(aniHome_Msg_Id,aniHome_Id,mem_Id,aniHome_Msg,adp_start_date);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihome_msgVO", anihome_msgVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/anihome_msg/update_anihome_msg_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addAniHome_Msg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String aniHome_Id = req.getParameter("aniHome_Id").trim();
                String mem_Id = req.getParameter("mem_Id").trim();
                String aniHome_Msg = req.getParameter("aniHome_Msg").trim();
                java.sql.Date adp_start_date = null;
                try {
                    adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
                } catch (IllegalArgumentException e) {
                    adp_start_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
                anihome_msgVO.setAniHome_Id(aniHome_Id);
                anihome_msgVO.setMem_Id(mem_Id);
                anihome_msgVO.setAniHome_Msg(aniHome_Msg);
                anihome_msgVO.setAdp_start_date(adp_start_date);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("anihome_msgVO", anihome_msgVO); // 含有輸入格式錯誤的anihome_msgVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/anihome_msg/addAniHome_Msg.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
                anihome_msgVO = anihome_msgSvc.addAniHome_Msg(aniHome_Id,mem_Id,aniHome_Msg,adp_start_date); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/anihome_msg/listAllAniHome_Msg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/anihome_msg/addAniHome_Msg.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllAniHome_Msg.jsp 或  /dept/listAniHome_Msgs_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/anihome_msg/listAllAniHome_Msg.jsp】 或  【/dept/listAniHome_Msgs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /anihome_msg/listAniHome_Msgs_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String aniHome_Msg_Id = new String(req.getParameter("aniHome_Msg_Id"));

                
                /***************************2.開始刪除資料***************************************/
                AniHome_MsgService anihome_msgSvc = new AniHome_MsgService();
                AniHome_MsgVO anihome_msgVO = anihome_msgSvc.getOneAniHome_Msg(aniHome_Msg_Id);
   
                anihome_msgSvc.deleteAniHome_Msg(aniHome_Msg_Id);
             
                
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
	}
}
