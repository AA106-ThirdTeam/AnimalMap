package com.stray_ani.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.stray_ani.model.*;
/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物<br>
 *	英文:stray_Ani<br>
 */ 
@WebServlet(urlPatterns = { "/stray_ani/stray_ani.do" })
public class Stray_AniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Stray_Ani servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("stray_Ani_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入社區動物編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  stray_Ani_Id = null;
				try {
					stray_Ani_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("社區動物編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Stray_AniService stray_aniSvc = new Stray_AniService();
				Stray_AniVO stray_aniVO = stray_aniSvc.getOneStray_Ani(stray_Ani_Id);
				if (stray_aniVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_aniVO", stray_aniVO); 
				String url = "/stray_ani/listOneStray_Ani.jsp";
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
				String  stray_Ani_Id = new String (req.getParameter("stray_Ani_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Stray_AniService stray_aniSvc = new Stray_AniService();
				Stray_AniVO stray_aniVO = stray_aniSvc.getOneStray_Ani(stray_Ani_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_aniVO", stray_aniVO); 
				String url = "/stray_ani/update_stray_ani_input.jsp";
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
				String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String stray_Ani_name = req.getParameter("stray_Ani_name").trim();
				String stray_Ani_type = req.getParameter("stray_Ani_type").trim();
				String stray_Ani_gender = req.getParameter("stray_Ani_gender").trim();
				String stray_Ani_heal = req.getParameter("stray_Ani_heal").trim();
				String stray_Ani_Vac = req.getParameter("stray_Ani_Vac").trim();
				String stray_Ani_color = req.getParameter("stray_Ani_color").trim();
				String stray_Ani_body = req.getParameter("stray_Ani_body").trim();
				String stray_Ani_age = req.getParameter("stray_Ani_age").trim();
				String stray_Ani_Neu = req.getParameter("stray_Ani_Neu").trim();
				String stray_Ani_chip = req.getParameter("stray_Ani_chip").trim();
				java.sql.Date stray_Ani_date = null;
				try {
					stray_Ani_date = java.sql.Date.valueOf(req.getParameter("stray_Ani_date").trim());
				} catch (IllegalArgumentException e) {
					stray_Ani_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String stray_Ani_status = req.getParameter("stray_Ani_status").trim();
				java.sql.Date stray_Ani_CreDate = null;
				try {
					stray_Ani_CreDate = java.sql.Date.valueOf(req.getParameter("stray_Ani_CreDate").trim());
				} catch (IllegalArgumentException e) {
					stray_Ani_CreDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				Double stray_Ani_FinLat = null;
				try {
					stray_Ani_FinLat = new Double(req.getParameter("stray_Ani_FinLat").trim());
				} catch (NumberFormatException e) {
					stray_Ani_FinLat = 0.0;
					errorMsgs.add("流浪出沒地點經度請填數字.");
				}
				Double stray_Ani_FinLon = null;
				try {
					stray_Ani_FinLon = new Double(req.getParameter("stray_Ani_FinLon").trim());
				} catch (NumberFormatException e) {
					stray_Ani_FinLon = 0.0;
					errorMsgs.add("流浪出沒地點緯度請填數字.");
				}
				String stray_Ani_city = req.getParameter("stray_Ani_city").trim();
				String stray_Ani_town = req.getParameter("stray_Ani_town").trim();
				String stray_Ani_road = req.getParameter("stray_Ani_road").trim();

				Stray_AniVO stray_aniVO = new Stray_AniVO();
				stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
				stray_aniVO.setMem_Id(mem_Id);
				stray_aniVO.setStray_Ani_name(stray_Ani_name);
				stray_aniVO.setStray_Ani_type(stray_Ani_type);
				stray_aniVO.setStray_Ani_gender(stray_Ani_gender);
				stray_aniVO.setStray_Ani_heal(stray_Ani_heal);
				stray_aniVO.setStray_Ani_Vac(stray_Ani_Vac);
				stray_aniVO.setStray_Ani_color(stray_Ani_color);
				stray_aniVO.setStray_Ani_body(stray_Ani_body);
				stray_aniVO.setStray_Ani_age(stray_Ani_age);
				stray_aniVO.setStray_Ani_Neu(stray_Ani_Neu);
				stray_aniVO.setStray_Ani_chip(stray_Ani_chip);
				stray_aniVO.setStray_Ani_date(stray_Ani_date);
				stray_aniVO.setStray_Ani_status(stray_Ani_status);
				stray_aniVO.setStray_Ani_CreDate(stray_Ani_CreDate);
				stray_aniVO.setStray_Ani_FinLat(stray_Ani_FinLat);
				stray_aniVO.setStray_Ani_FinLon(stray_Ani_FinLon);
				stray_aniVO.setStray_Ani_city(stray_Ani_city);
				stray_aniVO.setStray_Ani_town(stray_Ani_town);
				stray_aniVO.setStray_Ani_road(stray_Ani_road);
				if (!errorMsgs.isEmpty()) {
					String url = "/stray_ani/update_stray_ani_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Stray_AniService stray_aniSvc = new Stray_AniService();
				stray_aniVO = stray_aniSvc.updateStray_Ani(stray_Ani_Id,mem_Id,stray_Ani_name,stray_Ani_type,stray_Ani_gender,stray_Ani_heal,stray_Ani_Vac,stray_Ani_color,stray_Ani_body,stray_Ani_age,stray_Ani_Neu,stray_Ani_chip,stray_Ani_date,stray_Ani_status,stray_Ani_CreDate,stray_Ani_FinLat,stray_Ani_FinLon,stray_Ani_city,stray_Ani_town,stray_Ani_road);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_aniVO", stray_aniVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/stray_ani/update_stray_ani_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addStray_Ani.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                String stray_Ani_name = req.getParameter("stray_Ani_name").trim();
                String stray_Ani_type = req.getParameter("stray_Ani_type").trim();
                String stray_Ani_gender = req.getParameter("stray_Ani_gender").trim();
                String stray_Ani_heal = req.getParameter("stray_Ani_heal").trim();
                String stray_Ani_Vac = req.getParameter("stray_Ani_Vac").trim();
                String stray_Ani_color = req.getParameter("stray_Ani_color").trim();
                String stray_Ani_body = req.getParameter("stray_Ani_body").trim();
                String stray_Ani_age = req.getParameter("stray_Ani_age").trim();
                String stray_Ani_Neu = req.getParameter("stray_Ani_Neu").trim();
                String stray_Ani_chip = req.getParameter("stray_Ani_chip").trim();
                java.sql.Date stray_Ani_date = null;
                try {
                    stray_Ani_date = java.sql.Date.valueOf(req.getParameter("stray_Ani_date").trim());
                } catch (IllegalArgumentException e) {
                    stray_Ani_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String stray_Ani_status = req.getParameter("stray_Ani_status").trim();
                java.sql.Date stray_Ani_CreDate = null;
                try {
                    stray_Ani_CreDate = java.sql.Date.valueOf(req.getParameter("stray_Ani_CreDate").trim());
                } catch (IllegalArgumentException e) {
                    stray_Ani_CreDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                Double stray_Ani_FinLat = null;
                try {
                    stray_Ani_FinLat = new Double(req.getParameter("stray_Ani_FinLat").trim());
                } catch (NumberFormatException e) {
                    stray_Ani_FinLat = 0.0;
                    errorMsgs.add("流浪出沒地點經度請填數字.");
                    e.printStackTrace();
                }
                Double stray_Ani_FinLon = null;
                try {
                    stray_Ani_FinLon = new Double(req.getParameter("stray_Ani_FinLon").trim());
                } catch (NumberFormatException e) {
                    stray_Ani_FinLon = 0.0;
                    errorMsgs.add("流浪出沒地點緯度請填數字.");
                    e.printStackTrace();
                }
                String stray_Ani_city = req.getParameter("stray_Ani_city").trim();
                String stray_Ani_town = req.getParameter("stray_Ani_town").trim();
                String stray_Ani_road = req.getParameter("stray_Ani_road").trim();

                Stray_AniVO stray_aniVO = new Stray_AniVO();
                stray_aniVO.setMem_Id(mem_Id);
                stray_aniVO.setStray_Ani_name(stray_Ani_name);
                stray_aniVO.setStray_Ani_type(stray_Ani_type);
                stray_aniVO.setStray_Ani_gender(stray_Ani_gender);
                stray_aniVO.setStray_Ani_heal(stray_Ani_heal);
                stray_aniVO.setStray_Ani_Vac(stray_Ani_Vac);
                stray_aniVO.setStray_Ani_color(stray_Ani_color);
                stray_aniVO.setStray_Ani_body(stray_Ani_body);
                stray_aniVO.setStray_Ani_age(stray_Ani_age);
                stray_aniVO.setStray_Ani_Neu(stray_Ani_Neu);
                stray_aniVO.setStray_Ani_chip(stray_Ani_chip);
                stray_aniVO.setStray_Ani_date(stray_Ani_date);
                stray_aniVO.setStray_Ani_status(stray_Ani_status);
                stray_aniVO.setStray_Ani_CreDate(stray_Ani_CreDate);
                stray_aniVO.setStray_Ani_FinLat(stray_Ani_FinLat);
                stray_aniVO.setStray_Ani_FinLon(stray_Ani_FinLon);
                stray_aniVO.setStray_Ani_city(stray_Ani_city);
                stray_aniVO.setStray_Ani_town(stray_Ani_town);
                stray_aniVO.setStray_Ani_road(stray_Ani_road);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("stray_aniVO", stray_aniVO); // 含有輸入格式錯誤的stray_aniVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/stray_ani/addStray_Ani.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Stray_AniService stray_aniSvc = new Stray_AniService();
                stray_aniVO = stray_aniSvc.addStray_Ani(mem_Id,stray_Ani_name,stray_Ani_type,stray_Ani_gender,stray_Ani_heal,stray_Ani_Vac,stray_Ani_color,stray_Ani_body,stray_Ani_age,stray_Ani_Neu,stray_Ani_chip,stray_Ani_date,stray_Ani_status,stray_Ani_CreDate,stray_Ani_FinLat,stray_Ani_FinLon,stray_Ani_city,stray_Ani_town,stray_Ani_road); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/stray_ani/listAllStray_Ani.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/stray_ani/addStray_Ani.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllStray_Ani.jsp 或  /dept/listStray_Anis_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/stray_ani/listAllStray_Ani.jsp】 或  【/dept/listStray_Anis_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /stray_ani/listStray_Anis_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String stray_Ani_Id = new String(req.getParameter("stray_Ani_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Stray_AniService stray_aniSvc = new Stray_AniService();
                Stray_AniVO stray_aniVO = stray_aniSvc.getOneStray_Ani(stray_Ani_Id);
   
                stray_aniSvc.deleteStray_Ani(stray_Ani_Id);
             
                
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
