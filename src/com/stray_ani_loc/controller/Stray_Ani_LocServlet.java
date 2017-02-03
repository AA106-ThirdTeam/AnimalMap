package com.stray_ani_loc.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.stray_ani.model.*;
import com.mem.model.*;
import com.stray_ani_loc.model.*;
/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物出沒範圍<br>
 *	英文:stray_Ani_Loc<br>
 */ 
@WebServlet(urlPatterns = { "/stray_ani_loc/stray_ani_loc.do" })
public class Stray_Ani_LocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Stray_Ani_Loc servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("str_Ani_Loc_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入流浪動物出沒編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  str_Ani_Loc_No = null;
				try {
					str_Ani_Loc_No = new String (str);
				} catch (Exception e) {
					errorMsgs.add("流浪動物出沒編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
				Stray_Ani_LocVO stray_ani_locVO = stray_ani_locSvc.getOneStray_Ani_Loc(str_Ani_Loc_No);
				if (stray_ani_locVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_ani_locVO", stray_ani_locVO); 
				String url = "/stray_ani_loc/listOneStray_Ani_Loc.jsp";
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
				String  str_Ani_Loc_No = new String (req.getParameter("str_Ani_Loc_No").trim());

				/***************************2.開始查詢資料*****************************************/
				Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
				Stray_Ani_LocVO stray_ani_locVO = stray_ani_locSvc.getOneStray_Ani_Loc(str_Ani_Loc_No);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_ani_locVO", stray_ani_locVO); 
				String url = "/stray_ani_loc/update_stray_ani_loc_input.jsp";
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
				String str_Ani_Loc_No = req.getParameter("str_Ani_Loc_No").trim();
				String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				Double str_Ani_LocLat = null;
				try {
					str_Ani_LocLat = new Double(req.getParameter("str_Ani_LocLat").trim());
				} catch (NumberFormatException e) {
					str_Ani_LocLat = 0.0;
					errorMsgs.add("送養地點經度請填數字.");
				}
				Double str_Ani_LocLon = null;
				try {
					str_Ani_LocLon = new Double(req.getParameter("str_Ani_LocLon").trim());
				} catch (NumberFormatException e) {
					str_Ani_LocLon = 0.0;
					errorMsgs.add("送養地點緯度請填數字.");
				}

				Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
				stray_ani_locVO.setStr_Ani_Loc_No(str_Ani_Loc_No);
				stray_ani_locVO.setStray_Ani_Id(stray_Ani_Id);
				stray_ani_locVO.setMem_Id(mem_Id);
				stray_ani_locVO.setStr_Ani_LocLat(str_Ani_LocLat);
				stray_ani_locVO.setStr_Ani_LocLon(str_Ani_LocLon);
				if (!errorMsgs.isEmpty()) {
					String url = "/stray_ani_loc/update_stray_ani_loc_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
				stray_ani_locVO = stray_ani_locSvc.updateStray_Ani_Loc(str_Ani_Loc_No,stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_ani_locVO", stray_ani_locVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/stray_ani_loc/update_stray_ani_loc_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addStray_Ani_Loc.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();
                String mem_Id = req.getParameter("mem_Id").trim();
                Double str_Ani_LocLat = null;
                try {
                    str_Ani_LocLat = new Double(req.getParameter("str_Ani_LocLat").trim());
                } catch (NumberFormatException e) {
                    str_Ani_LocLat = 0.0;
                    errorMsgs.add("送養地點經度請填數字.");
                    e.printStackTrace();
                }
                Double str_Ani_LocLon = null;
                try {
                    str_Ani_LocLon = new Double(req.getParameter("str_Ani_LocLon").trim());
                } catch (NumberFormatException e) {
                    str_Ani_LocLon = 0.0;
                    errorMsgs.add("送養地點緯度請填數字.");
                    e.printStackTrace();
                }

                Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
                stray_ani_locVO.setStray_Ani_Id(stray_Ani_Id);
                stray_ani_locVO.setMem_Id(mem_Id);
                stray_ani_locVO.setStr_Ani_LocLat(str_Ani_LocLat);
                stray_ani_locVO.setStr_Ani_LocLon(str_Ani_LocLon);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("stray_ani_locVO", stray_ani_locVO); // 含有輸入格式錯誤的stray_ani_locVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/stray_ani_loc/addStray_Ani_Loc.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
                stray_ani_locVO = stray_ani_locSvc.addStray_Ani_Loc(stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/stray_ani_loc/listAllStray_Ani_Loc.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/stray_ani_loc/addStray_Ani_Loc.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllStray_Ani_Loc.jsp 或  /dept/listStray_Ani_Locs_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/stray_ani_loc/listAllStray_Ani_Loc.jsp】 或  【/dept/listStray_Ani_Locs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /stray_ani_loc/listStray_Ani_Locs_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String str_Ani_Loc_No = new String(req.getParameter("str_Ani_Loc_No"));

                
                /***************************2.開始刪除資料***************************************/
                Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
                Stray_Ani_LocVO stray_ani_locVO = stray_ani_locSvc.getOneStray_Ani_Loc(str_Ani_Loc_No);
   
                stray_ani_locSvc.deleteStray_Ani_Loc(str_Ani_Loc_No);
             
                
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
