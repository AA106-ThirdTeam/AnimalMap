package com.pet_message.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.pet.model.*;
import com.mem.model.*;
import com.pet_message.model.*;
/** 
 *表格名稱 : <br>
 *	中文:自家寵物留言<br>
 *	英文:pet_Message<br>
 */ 
@WebServlet(urlPatterns = { "/pet_message/pet_message.do" })
public class Pet_MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Pet_Message servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("pet_Mes_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入寵物留言編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  pet_Mes_No = null;
				try {
					pet_Mes_No = new String (str);
				} catch (Exception e) {
					errorMsgs.add("寵物留言編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Pet_MessageService pet_messageSvc = new Pet_MessageService();
				Pet_MessageVO pet_messageVO = pet_messageSvc.getOnePet_Message(pet_Mes_No);
				if (pet_messageVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("pet_messageVO", pet_messageVO); 
				String url = "/pet_message/listOnePet_Message.jsp";
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
				String  pet_Mes_No = new String (req.getParameter("pet_Mes_No").trim());

				/***************************2.開始查詢資料*****************************************/
				Pet_MessageService pet_messageSvc = new Pet_MessageService();
				Pet_MessageVO pet_messageVO = pet_messageSvc.getOnePet_Message(pet_Mes_No);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("pet_messageVO", pet_messageVO); 
				String url = "/pet_message/update_pet_message_input.jsp";
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
				String pet_Mes_No = req.getParameter("pet_Mes_No").trim();
				String pet_Id = req.getParameter("pet_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String pet_Mes = req.getParameter("pet_Mes").trim();
				java.sql.Date pet_Mes_time = null;
				try {
					pet_Mes_time = java.sql.Date.valueOf(req.getParameter("pet_Mes_time").trim());
				} catch (IllegalArgumentException e) {
					pet_Mes_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				Pet_MessageVO pet_messageVO = new Pet_MessageVO();
				pet_messageVO.setPet_Mes_No(pet_Mes_No);
				pet_messageVO.setPet_Id(pet_Id);
				pet_messageVO.setMem_Id(mem_Id);
				pet_messageVO.setPet_Mes(pet_Mes);
				pet_messageVO.setPet_Mes_time(pet_Mes_time);
				if (!errorMsgs.isEmpty()) {
					String url = "/pet_message/update_pet_message_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Pet_MessageService pet_messageSvc = new Pet_MessageService();
				pet_messageVO = pet_messageSvc.updatePet_Message(pet_Mes_No,pet_Id,mem_Id,pet_Mes,pet_Mes_time);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("pet_messageVO", pet_messageVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/pet_message/update_pet_message_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addPet_Message.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String pet_Id = req.getParameter("pet_Id").trim();
                String mem_Id = req.getParameter("mem_Id").trim();
                String pet_Mes = req.getParameter("pet_Mes").trim();
                java.sql.Date pet_Mes_time = null;
                try {
                    pet_Mes_time = java.sql.Date.valueOf(req.getParameter("pet_Mes_time").trim());
                } catch (IllegalArgumentException e) {
                    pet_Mes_time=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                Pet_MessageVO pet_messageVO = new Pet_MessageVO();
                pet_messageVO.setPet_Id(pet_Id);
                pet_messageVO.setMem_Id(mem_Id);
                pet_messageVO.setPet_Mes(pet_Mes);
                pet_messageVO.setPet_Mes_time(pet_Mes_time);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("pet_messageVO", pet_messageVO); // 含有輸入格式錯誤的pet_messageVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/pet_message/addPet_Message.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Pet_MessageService pet_messageSvc = new Pet_MessageService();
                pet_messageVO = pet_messageSvc.addPet_Message(pet_Id,mem_Id,pet_Mes,pet_Mes_time); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/pet_message/listAllPet_Message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/pet_message/addPet_Message.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllPet_Message.jsp 或  /dept/listPet_Messages_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/pet_message/listAllPet_Message.jsp】 或  【/dept/listPet_Messages_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /pet_message/listPet_Messages_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String pet_Mes_No = new String(req.getParameter("pet_Mes_No"));

                
                /***************************2.開始刪除資料***************************************/
                Pet_MessageService pet_messageSvc = new Pet_MessageService();
                Pet_MessageVO pet_messageVO = pet_messageSvc.getOnePet_Message(pet_Mes_No);
   
                pet_messageSvc.deletePet_Message(pet_Mes_No);
             
                
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
