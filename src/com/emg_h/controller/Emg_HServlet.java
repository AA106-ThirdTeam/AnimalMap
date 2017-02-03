package com.emg_h.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.emg_h.model.*;
/** 
 *表格名稱 : <br>
 *	中文:緊急求救<br>
 *	英文:emg_H<br>
 */ 
@WebServlet(urlPatterns = { "/emg_h/emg_h.do" })
public class Emg_HServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Emg_H servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("emg_H_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入求救編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  emg_H_Id = null;
				try {
					emg_H_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("求救編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Emg_HService emg_hSvc = new Emg_HService();
				Emg_HVO emg_hVO = emg_hSvc.getOneEmg_H(emg_H_Id);
				if (emg_hVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_hVO", emg_hVO); 
				String url = "/emg_h/listOneEmg_H.jsp";
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
				String  emg_H_Id = new String (req.getParameter("emg_H_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				Emg_HService emg_hSvc = new Emg_HService();
				Emg_HVO emg_hVO = emg_hSvc.getOneEmg_H(emg_H_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_hVO", emg_hVO); 
				String url = "/emg_h/update_emg_h_input.jsp";
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
				String emg_H_Id = req.getParameter("emg_H_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				java.sql.Date emg_H_start_date = null;
				try {
					emg_H_start_date = java.sql.Date.valueOf(req.getParameter("emg_H_start_date").trim());
				} catch (IllegalArgumentException e) {
					emg_H_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date emg_H_end_date = null;
				try {
					emg_H_end_date = java.sql.Date.valueOf(req.getParameter("emg_H_end_date").trim());
				} catch (IllegalArgumentException e) {
					emg_H_end_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String emg_H_title = req.getParameter("emg_H_title").trim();
				String emg_H_content = req.getParameter("emg_H_content").trim();
				byte[] emg_H_Pic = null;
				try {
					Part part = req.getPart("emg_H_Pic");
					InputStream in = part.getInputStream();
					emg_H_Pic = new byte[part.getInputStream().available()];
					in.read(emg_H_Pic);
					in.close();
				} catch (Exception e) {
					emg_H_Pic = null;
					//errorMsgs.add("照片請上傳照片.");
				}
				String emg_H_Pic_format = req.getParameter("emg_H_Pic_format").trim();
				String emg_H_city = req.getParameter("emg_H_city").trim();
				String emg_H_town = req.getParameter("emg_H_town").trim();
				String emg_H_road = req.getParameter("emg_H_road").trim();
				Double emg_H_Lon = null;
				try {
					emg_H_Lon = new Double(req.getParameter("emg_H_Lon").trim());
				} catch (NumberFormatException e) {
					emg_H_Lon = 0.0;
					errorMsgs.add("緊急求救經度座標請填數字.");
				}
				Double emg_H_Lat = null;
				try {
					emg_H_Lat = new Double(req.getParameter("emg_H_Lat").trim());
				} catch (NumberFormatException e) {
					emg_H_Lat = 0.0;
					errorMsgs.add("緊急求救緯度座標請填數字.");
				}

				Emg_HVO emg_hVO = new Emg_HVO();
				emg_hVO.setEmg_H_Id(emg_H_Id);
				emg_hVO.setMem_Id(mem_Id);
				emg_hVO.setEmg_H_start_date(emg_H_start_date);
				emg_hVO.setEmg_H_end_date(emg_H_end_date);
				emg_hVO.setEmg_H_title(emg_H_title);
				emg_hVO.setEmg_H_content(emg_H_content);
				emg_hVO.setEmg_H_Pic(emg_H_Pic);
				emg_hVO.setEmg_H_Pic_format(emg_H_Pic_format);
				emg_hVO.setEmg_H_city(emg_H_city);
				emg_hVO.setEmg_H_town(emg_H_town);
				emg_hVO.setEmg_H_road(emg_H_road);
				emg_hVO.setEmg_H_Lon(emg_H_Lon);
				emg_hVO.setEmg_H_Lat(emg_H_Lat);
				if (!errorMsgs.isEmpty()) {
					String url = "/emg_h/update_emg_h_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Emg_HService emg_hSvc = new Emg_HService();
				emg_hVO = emg_hSvc.updateEmg_H(emg_H_Id,mem_Id,emg_H_start_date,emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_hVO", emg_hVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/emg_h/update_emg_h_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addEmg_H.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                java.sql.Date emg_H_start_date = null;
                try {
                    emg_H_start_date = java.sql.Date.valueOf(req.getParameter("emg_H_start_date").trim());
                } catch (IllegalArgumentException e) {
                    emg_H_start_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date emg_H_end_date = null;
                try {
                    emg_H_end_date = java.sql.Date.valueOf(req.getParameter("emg_H_end_date").trim());
                } catch (IllegalArgumentException e) {
                    emg_H_end_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String emg_H_title = req.getParameter("emg_H_title").trim();
                String emg_H_content = req.getParameter("emg_H_content").trim();
                byte[] emg_H_Pic = null;
                try {
                    Part part = req.getPart("emg_H_Pic");
                    InputStream in = part.getInputStream();
                    emg_H_Pic = new byte[part.getInputStream().available()];
                    in.read(emg_H_Pic);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("照片請上傳照片.");
                    //e.printStackTrace();
                    emg_H_Pic = null;
                }
                String emg_H_Pic_format = req.getParameter("emg_H_Pic_format").trim();
                String emg_H_city = req.getParameter("emg_H_city").trim();
                String emg_H_town = req.getParameter("emg_H_town").trim();
                String emg_H_road = req.getParameter("emg_H_road").trim();
                Double emg_H_Lon = null;
                try {
                    emg_H_Lon = new Double(req.getParameter("emg_H_Lon").trim());
                } catch (NumberFormatException e) {
                    emg_H_Lon = 0.0;
                    errorMsgs.add("緊急求救經度座標請填數字.");
                    e.printStackTrace();
                }
                Double emg_H_Lat = null;
                try {
                    emg_H_Lat = new Double(req.getParameter("emg_H_Lat").trim());
                } catch (NumberFormatException e) {
                    emg_H_Lat = 0.0;
                    errorMsgs.add("緊急求救緯度座標請填數字.");
                    e.printStackTrace();
                }

                Emg_HVO emg_hVO = new Emg_HVO();
                emg_hVO.setMem_Id(mem_Id);
                emg_hVO.setEmg_H_start_date(emg_H_start_date);
                emg_hVO.setEmg_H_end_date(emg_H_end_date);
                emg_hVO.setEmg_H_title(emg_H_title);
                emg_hVO.setEmg_H_content(emg_H_content);
                emg_hVO.setEmg_H_Pic(emg_H_Pic);
                emg_hVO.setEmg_H_Pic_format(emg_H_Pic_format);
                emg_hVO.setEmg_H_city(emg_H_city);
                emg_hVO.setEmg_H_town(emg_H_town);
                emg_hVO.setEmg_H_road(emg_H_road);
                emg_hVO.setEmg_H_Lon(emg_H_Lon);
                emg_hVO.setEmg_H_Lat(emg_H_Lat);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("emg_hVO", emg_hVO); // 含有輸入格式錯誤的emg_hVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/emg_h/addEmg_H.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Emg_HService emg_hSvc = new Emg_HService();
                emg_hVO = emg_hSvc.addEmg_H(mem_Id,emg_H_start_date,emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/emg_h/listAllEmg_H.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/emg_h/addEmg_H.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllEmg_H.jsp 或  /dept/listEmg_Hs_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emg_h/listAllEmg_H.jsp】 或  【/dept/listEmg_Hs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /emg_h/listEmg_Hs_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String emg_H_Id = new String(req.getParameter("emg_H_Id"));

                
                /***************************2.開始刪除資料***************************************/
                Emg_HService emg_hSvc = new Emg_HService();
                Emg_HVO emg_hVO = emg_hSvc.getOneEmg_H(emg_H_Id);
   
                emg_hSvc.deleteEmg_H(emg_H_Id);
             
                
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
