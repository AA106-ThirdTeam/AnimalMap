package com.vet_hospital.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.vet_hospital.model.*;
/** 
 *表格名稱 : <br>
 *	中文:診所<br>
 *	英文:vet_hospital<br>
 */ 
@WebServlet(urlPatterns = { "/vet_hospital/vet_hospital.do" })
public class Vet_hospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Vet_hospital servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("hos_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入診所編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  hos_Id = null;
				try {
					hos_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("診所編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
				Vet_hospitalVO vet_hospitalVO = vet_hospitalSvc.getOneVet_hospital(hos_Id);
				if (vet_hospitalVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("vet_hospitalVO", vet_hospitalVO); 
				String url = "/vet_hospital/listOneVet_hospital.jsp";
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
				String  hos_Id = new String (req.getParameter("hos_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
				Vet_hospitalVO vet_hospitalVO = vet_hospitalSvc.getOneVet_hospital(hos_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("vet_hospitalVO", vet_hospitalVO); 
				String url = "/vet_hospital/update_vet_hospital_input.jsp";
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
				String hos_Id = req.getParameter("hos_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String hos_name = req.getParameter("hos_name").trim();
				String hos_city = req.getParameter("hos_city").trim();
				String hos_town = req.getParameter("hos_town").trim();
				String hos_road = req.getParameter("hos_road").trim();
				Integer hos_Eval = new Integer(req.getParameter("hos_Eval").trim());
				String hos_URL = req.getParameter("hos_URL").trim();
				String hos_StartTime = req.getParameter("hos_StartTime").trim();
				String hos_EndTime = req.getParameter("hos_EndTime").trim();
				String hos_Tel = req.getParameter("hos_Tel").trim();
				String hos_Desc = req.getParameter("hos_Desc").trim();
				Double hos_Long = null;
				try {
					hos_Long = new Double(req.getParameter("hos_Long").trim());
				} catch (NumberFormatException e) {
					hos_Long = 0.0;
					errorMsgs.add("診所經度座標請填數字.");
				}
				Double hos_Lat = null;
				try {
					hos_Lat = new Double(req.getParameter("hos_Lat").trim());
				} catch (NumberFormatException e) {
					hos_Lat = 0.0;
					errorMsgs.add("診所緯度座標請填數字.");
				}
				java.sql.Date hos_CreateTime = null;
				try {
					hos_CreateTime = java.sql.Date.valueOf(req.getParameter("hos_CreateTime").trim());
				} catch (IllegalArgumentException e) {
					hos_CreateTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String hos_visible = req.getParameter("hos_visible").trim();

				Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
				vet_hospitalVO.setHos_Id(hos_Id);
				vet_hospitalVO.setMem_Id(mem_Id);
				vet_hospitalVO.setHos_name(hos_name);
				vet_hospitalVO.setHos_city(hos_city);
				vet_hospitalVO.setHos_town(hos_town);
				vet_hospitalVO.setHos_road(hos_road);
				vet_hospitalVO.setHos_Eval(hos_Eval);
				vet_hospitalVO.setHos_URL(hos_URL);
				vet_hospitalVO.setHos_StartTime(hos_StartTime);
				vet_hospitalVO.setHos_EndTime(hos_EndTime);
				vet_hospitalVO.setHos_Tel(hos_Tel);
				vet_hospitalVO.setHos_Desc(hos_Desc);
				vet_hospitalVO.setHos_Long(hos_Long);
				vet_hospitalVO.setHos_Lat(hos_Lat);
				vet_hospitalVO.setHos_CreateTime(hos_CreateTime);
				vet_hospitalVO.setHos_visible(hos_visible);
				if (!errorMsgs.isEmpty()) {
					String url = "/vet_hospital/update_vet_hospital_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
				vet_hospitalVO = vet_hospitalSvc.updateVet_hospital(hos_Id,mem_Id,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,hos_StartTime,hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,hos_CreateTime,hos_visible);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("vet_hospitalVO", vet_hospitalVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/vet_hospital/update_vet_hospital_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addVet_hospital.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                String hos_name = req.getParameter("hos_name").trim();
                String hos_city = req.getParameter("hos_city").trim();
                String hos_town = req.getParameter("hos_town").trim();
                String hos_road = req.getParameter("hos_road").trim();
                Integer hos_Eval = new Integer(req.getParameter("hos_Eval").trim());
                String hos_URL = req.getParameter("hos_URL").trim();
                String hos_StartTime = req.getParameter("hos_StartTime").trim();
                String hos_EndTime = req.getParameter("hos_EndTime").trim();
                String hos_Tel = req.getParameter("hos_Tel").trim();
                String hos_Desc = req.getParameter("hos_Desc").trim();
                Double hos_Long = null;
                try {
                    hos_Long = new Double(req.getParameter("hos_Long").trim());
                } catch (NumberFormatException e) {
                    hos_Long = 0.0;
                    errorMsgs.add("診所經度座標請填數字.");
                    e.printStackTrace();
                }
                Double hos_Lat = null;
                try {
                    hos_Lat = new Double(req.getParameter("hos_Lat").trim());
                } catch (NumberFormatException e) {
                    hos_Lat = 0.0;
                    errorMsgs.add("診所緯度座標請填數字.");
                    e.printStackTrace();
                }
                java.sql.Date hos_CreateTime = null;
                try {
                    hos_CreateTime = java.sql.Date.valueOf(req.getParameter("hos_CreateTime").trim());
                } catch (IllegalArgumentException e) {
                    hos_CreateTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String hos_visible = req.getParameter("hos_visible").trim();

                Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
                vet_hospitalVO.setMem_Id(mem_Id);
                vet_hospitalVO.setHos_name(hos_name);
                vet_hospitalVO.setHos_city(hos_city);
                vet_hospitalVO.setHos_town(hos_town);
                vet_hospitalVO.setHos_road(hos_road);
                vet_hospitalVO.setHos_Eval(hos_Eval);
                vet_hospitalVO.setHos_URL(hos_URL);
                vet_hospitalVO.setHos_StartTime(hos_StartTime);
                vet_hospitalVO.setHos_EndTime(hos_EndTime);
                vet_hospitalVO.setHos_Tel(hos_Tel);
                vet_hospitalVO.setHos_Desc(hos_Desc);
                vet_hospitalVO.setHos_Long(hos_Long);
                vet_hospitalVO.setHos_Lat(hos_Lat);
                vet_hospitalVO.setHos_CreateTime(hos_CreateTime);
                vet_hospitalVO.setHos_visible(hos_visible);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("vet_hospitalVO", vet_hospitalVO); // 含有輸入格式錯誤的vet_hospitalVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/vet_hospital/addVet_hospital.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
                vet_hospitalVO = vet_hospitalSvc.addVet_hospital(mem_Id,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,hos_StartTime,hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,hos_CreateTime,hos_visible); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/vet_hospital/listAllVet_hospital.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/vet_hospital/addVet_hospital.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllVet_hospital.jsp 或  /dept/listVet_hospitals_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/vet_hospital/listAllVet_hospital.jsp】 或  【/dept/listVet_hospitals_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /vet_hospital/listVet_hospitals_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String hos_Id = new String(req.getParameter("hos_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
                Vet_hospitalVO vet_hospitalVO = vet_hospitalSvc.getOneVet_hospital(hos_Id);
   
                vet_hospitalSvc.deleteVet_hospital(hos_Id);
             
                
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
