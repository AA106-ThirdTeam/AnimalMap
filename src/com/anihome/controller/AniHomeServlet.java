package com.anihome.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.anihome.model.*;
/** 
 *表格名稱 : <br>
 *	中文:動物之家<br>
 *	英文:aniHome<br>
 */ 
@WebServlet(urlPatterns = { "/anihome/anihome.do" })
public class AniHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("AniHome servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("aniHome_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入動物之家編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  aniHome_Id = null;
				try {
					aniHome_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("動物之家編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				AniHomeService anihomeSvc = new AniHomeService();
				AniHomeVO anihomeVO = anihomeSvc.getOneAniHome(aniHome_Id);
				if (anihomeVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihomeVO", anihomeVO); 
				String url = "/anihome/listOneAniHome.jsp";
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
				String  aniHome_Id = new String (req.getParameter("aniHome_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				AniHomeService anihomeSvc = new AniHomeService();
				AniHomeVO anihomeVO = anihomeSvc.getOneAniHome(aniHome_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihomeVO", anihomeVO); 
				String url = "/anihome/update_anihome_input.jsp";
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
				String aniHome_Id = req.getParameter("aniHome_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String aniHome_title = req.getParameter("aniHome_title").trim();
				String aniHome_content = req.getParameter("aniHome_content").trim();
				java.sql.Date aniHome_start_date = null;
				try {
					aniHome_start_date = java.sql.Date.valueOf(req.getParameter("aniHome_start_date").trim());
				} catch (IllegalArgumentException e) {
					aniHome_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date aniHome_upDate = null;
				try {
					aniHome_upDate = java.sql.Date.valueOf(req.getParameter("aniHome_upDate").trim());
				} catch (IllegalArgumentException e) {
					aniHome_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String aniHome_city = req.getParameter("aniHome_city").trim();
				String aniHome_town = req.getParameter("aniHome_town").trim();
				String aniHome_road = req.getParameter("aniHome_road").trim();
				Double aniHome_lon = null;
				try {
					aniHome_lon = new Double(req.getParameter("aniHome_lon").trim());
				} catch (NumberFormatException e) {
					aniHome_lon = 0.0;
					errorMsgs.add("動物之家經度座標請填數字.");
				}
				Double aniHome_lat = null;
				try {
					aniHome_lat = new Double(req.getParameter("aniHome_lat").trim());
				} catch (NumberFormatException e) {
					aniHome_lat = 0.0;
					errorMsgs.add("緯度座標緯度座標請填數字.");
				}

				AniHomeVO anihomeVO = new AniHomeVO();
				anihomeVO.setAniHome_Id(aniHome_Id);
				anihomeVO.setMem_Id(mem_Id);
				anihomeVO.setAniHome_title(aniHome_title);
				anihomeVO.setAniHome_content(aniHome_content);
				anihomeVO.setAniHome_start_date(aniHome_start_date);
				anihomeVO.setAniHome_upDate(aniHome_upDate);
				anihomeVO.setAniHome_city(aniHome_city);
				anihomeVO.setAniHome_town(aniHome_town);
				anihomeVO.setAniHome_road(aniHome_road);
				anihomeVO.setAniHome_lon(aniHome_lon);
				anihomeVO.setAniHome_lat(aniHome_lat);
				if (!errorMsgs.isEmpty()) {
					String url = "/anihome/update_anihome_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				AniHomeService anihomeSvc = new AniHomeService();
				anihomeVO = anihomeSvc.updateAniHome(aniHome_Id,mem_Id,aniHome_title,aniHome_content,aniHome_start_date,aniHome_upDate,aniHome_city,aniHome_town,aniHome_road,aniHome_lon,aniHome_lat);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihomeVO", anihomeVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/anihome/update_anihome_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addAniHome.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                String aniHome_title = req.getParameter("aniHome_title").trim();
                String aniHome_content = req.getParameter("aniHome_content").trim();
                java.sql.Date aniHome_start_date = null;
                try {
                    aniHome_start_date = java.sql.Date.valueOf(req.getParameter("aniHome_start_date").trim());
                } catch (IllegalArgumentException e) {
                    aniHome_start_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                java.sql.Date aniHome_upDate = null;
                try {
                    aniHome_upDate = java.sql.Date.valueOf(req.getParameter("aniHome_upDate").trim());
                } catch (IllegalArgumentException e) {
                    aniHome_upDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String aniHome_city = req.getParameter("aniHome_city").trim();
                String aniHome_town = req.getParameter("aniHome_town").trim();
                String aniHome_road = req.getParameter("aniHome_road").trim();
                Double aniHome_lon = null;
                try {
                    aniHome_lon = new Double(req.getParameter("aniHome_lon").trim());
                } catch (NumberFormatException e) {
                    aniHome_lon = 0.0;
                    errorMsgs.add("動物之家經度座標請填數字.");
                    e.printStackTrace();
                }
                Double aniHome_lat = null;
                try {
                    aniHome_lat = new Double(req.getParameter("aniHome_lat").trim());
                } catch (NumberFormatException e) {
                    aniHome_lat = 0.0;
                    errorMsgs.add("緯度座標緯度座標請填數字.");
                    e.printStackTrace();
                }

                AniHomeVO anihomeVO = new AniHomeVO();
                anihomeVO.setMem_Id(mem_Id);
                anihomeVO.setAniHome_title(aniHome_title);
                anihomeVO.setAniHome_content(aniHome_content);
                anihomeVO.setAniHome_start_date(aniHome_start_date);
                anihomeVO.setAniHome_upDate(aniHome_upDate);
                anihomeVO.setAniHome_city(aniHome_city);
                anihomeVO.setAniHome_town(aniHome_town);
                anihomeVO.setAniHome_road(aniHome_road);
                anihomeVO.setAniHome_lon(aniHome_lon);
                anihomeVO.setAniHome_lat(aniHome_lat);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("anihomeVO", anihomeVO); // 含有輸入格式錯誤的anihomeVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/anihome/addAniHome.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                AniHomeService anihomeSvc = new AniHomeService();
                anihomeVO = anihomeSvc.addAniHome(mem_Id,aniHome_title,aniHome_content,aniHome_start_date,aniHome_upDate,aniHome_city,aniHome_town,aniHome_road,aniHome_lon,aniHome_lat); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/anihome/listAllAniHome.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/anihome/addAniHome.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllAniHome.jsp 或  /dept/listAniHomes_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/anihome/listAllAniHome.jsp】 或  【/dept/listAniHomes_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /anihome/listAniHomes_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String aniHome_Id = new String(req.getParameter("aniHome_Id"));

                
                /***************************2.開始刪除資料***************************************/
                AniHomeService anihomeSvc = new AniHomeService();
                AniHomeVO anihomeVO = anihomeSvc.getOneAniHome(aniHome_Id);
   
                anihomeSvc.deleteAniHome(aniHome_Id);
             
                
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
