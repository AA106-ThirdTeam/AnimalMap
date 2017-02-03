package com.adopt_ani_sponsor.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.adopt_ani.model.*;
import com.mem.model.*;
import com.adopt_ani_sponsor.model.*;
/** 
 *表格名稱 : <br>
 *	中文:送養動物贊助<br>
 *	英文:adopt_Ani_sponsor<br>
 */ 
@WebServlet(urlPatterns = { "/adopt_ani_sponsor/adopt_ani_sponsor.do" })
public class Adopt_Ani_sponsorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Adopt_Ani_sponsor servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("ado_Ani_Spo_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入送養動物贊助編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  ado_Ani_Spo_No = null;
				try {
					ado_Ani_Spo_No = new String (str);
				} catch (Exception e) {
					errorMsgs.add("送養動物贊助編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Adopt_Ani_sponsorService adopt_ani_sponsorSvc = new Adopt_Ani_sponsorService();
				Adopt_Ani_sponsorVO adopt_ani_sponsorVO = adopt_ani_sponsorSvc.getOneAdopt_Ani_sponsor(ado_Ani_Spo_No);
				if (adopt_ani_sponsorVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adopt_ani_sponsorVO", adopt_ani_sponsorVO); 
				String url = "/adopt_ani_sponsor/listOneAdopt_Ani_sponsor.jsp";
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
				String  ado_Ani_Spo_No = new String (req.getParameter("ado_Ani_Spo_No").trim());

				/***************************2.開始查詢資料*****************************************/
				Adopt_Ani_sponsorService adopt_ani_sponsorSvc = new Adopt_Ani_sponsorService();
				Adopt_Ani_sponsorVO adopt_ani_sponsorVO = adopt_ani_sponsorSvc.getOneAdopt_Ani_sponsor(ado_Ani_Spo_No);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adopt_ani_sponsorVO", adopt_ani_sponsorVO); 
				String url = "/adopt_ani_sponsor/update_adopt_ani_sponsor_input.jsp";
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
				String ado_Ani_Spo_No = req.getParameter("ado_Ani_Spo_No").trim();
				String adopt_Ani_Id = req.getParameter("adopt_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				Integer ado_Ani_Spo_money = new Integer(req.getParameter("ado_Ani_Spo_money").trim());
				String adoAniSpoMat = req.getParameter("adoAniSpoMat").trim();

				Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();
				adopt_ani_sponsorVO.setAdo_Ani_Spo_No(ado_Ani_Spo_No);
				adopt_ani_sponsorVO.setAdopt_Ani_Id(adopt_Ani_Id);
				adopt_ani_sponsorVO.setMem_Id(mem_Id);
				adopt_ani_sponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money);
				adopt_ani_sponsorVO.setAdoAniSpoMat(adoAniSpoMat);
				if (!errorMsgs.isEmpty()) {
					String url = "/adopt_ani_sponsor/update_adopt_ani_sponsor_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Adopt_Ani_sponsorService adopt_ani_sponsorSvc = new Adopt_Ani_sponsorService();
				adopt_ani_sponsorVO = adopt_ani_sponsorSvc.updateAdopt_Ani_sponsor(ado_Ani_Spo_No,adopt_Ani_Id,mem_Id,ado_Ani_Spo_money,adoAniSpoMat);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adopt_ani_sponsorVO", adopt_ani_sponsorVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/adopt_ani_sponsor/update_adopt_ani_sponsor_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addAdopt_Ani_sponsor.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String adopt_Ani_Id = req.getParameter("adopt_Ani_Id").trim();
                String mem_Id = req.getParameter("mem_Id").trim();
                Integer ado_Ani_Spo_money = new Integer(req.getParameter("ado_Ani_Spo_money").trim());
                String adoAniSpoMat = req.getParameter("adoAniSpoMat").trim();

                Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();
                adopt_ani_sponsorVO.setAdopt_Ani_Id(adopt_Ani_Id);
                adopt_ani_sponsorVO.setMem_Id(mem_Id);
                adopt_ani_sponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money);
                adopt_ani_sponsorVO.setAdoAniSpoMat(adoAniSpoMat);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("adopt_ani_sponsorVO", adopt_ani_sponsorVO); // 含有輸入格式錯誤的adopt_ani_sponsorVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/adopt_ani_sponsor/addAdopt_Ani_sponsor.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Adopt_Ani_sponsorService adopt_ani_sponsorSvc = new Adopt_Ani_sponsorService();
                adopt_ani_sponsorVO = adopt_ani_sponsorSvc.addAdopt_Ani_sponsor(adopt_Ani_Id,mem_Id,ado_Ani_Spo_money,adoAniSpoMat); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/adopt_ani_sponsor/listAllAdopt_Ani_sponsor.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/adopt_ani_sponsor/addAdopt_Ani_sponsor.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllAdopt_Ani_sponsor.jsp 或  /dept/listAdopt_Ani_sponsors_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/adopt_ani_sponsor/listAllAdopt_Ani_sponsor.jsp】 或  【/dept/listAdopt_Ani_sponsors_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /adopt_ani_sponsor/listAdopt_Ani_sponsors_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String ado_Ani_Spo_No = new String(req.getParameter("ado_Ani_Spo_No"));

                
                /***************************2.開始刪除資料***************************************/
                Adopt_Ani_sponsorService adopt_ani_sponsorSvc = new Adopt_Ani_sponsorService();
                Adopt_Ani_sponsorVO adopt_ani_sponsorVO = adopt_ani_sponsorSvc.getOneAdopt_Ani_sponsor(ado_Ani_Spo_No);
   
                adopt_ani_sponsorSvc.deleteAdopt_Ani_sponsor(ado_Ani_Spo_No);
             
                
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
