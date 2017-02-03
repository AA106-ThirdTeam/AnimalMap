package com.petshop.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.petshop.model.*;
/** 
 *表格名稱 : <br>
 *	中文:寵物商店<br>
 *	英文:petShop<br>
 */ 
@WebServlet(urlPatterns = { "/petshop/petshop.do" })
public class PetShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("PetShop servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("shop_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入商家編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  shop_Id = null;
				try {
					shop_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("商家編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				PetShopService petshopSvc = new PetShopService();
				PetShopVO petshopVO = petshopSvc.getOnePetShop(shop_Id);
				if (petshopVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("petshopVO", petshopVO); 
				String url = "/petshop/listOnePetShop.jsp";
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
				String  shop_Id = new String (req.getParameter("shop_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				PetShopService petshopSvc = new PetShopService();
				PetShopVO petshopVO = petshopSvc.getOnePetShop(shop_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("petshopVO", petshopVO); 
				String url = "/petshop/update_petshop_input.jsp";
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
				String shop_Id = req.getParameter("shop_Id").trim();
				String shop_MemId = req.getParameter("shop_MemId").trim();
				String shop_name = req.getParameter("shop_name").trim();
				String shop_city = req.getParameter("shop_city").trim();
				String shop_town = req.getParameter("shop_town").trim();
				String shop_road = req.getParameter("shop_road").trim();
				Integer shop_Eval = new Integer(req.getParameter("shop_Eval").trim());
				String shop_URL = req.getParameter("shop_URL").trim();
				String shop_StartTime = req.getParameter("shop_StartTime").trim();
				String shop_EndTime = req.getParameter("shop_EndTime").trim();
				String shop_Tel = req.getParameter("shop_Tel").trim();
				String shop_Desc = req.getParameter("shop_Desc").trim();
				Double shop_Long = null;
				try {
					shop_Long = new Double(req.getParameter("shop_Long").trim());
				} catch (NumberFormatException e) {
					shop_Long = 0.0;
					errorMsgs.add("商家經度座標請填數字.");
				}
				Double shop_Lat = null;
				try {
					shop_Lat = new Double(req.getParameter("shop_Lat").trim());
				} catch (NumberFormatException e) {
					shop_Lat = 0.0;
					errorMsgs.add("商家緯度座標請填數字.");
				}
				java.sql.Date shop_CreateTime = null;
				try {
					shop_CreateTime = java.sql.Date.valueOf(req.getParameter("shop_CreateTime").trim());
				} catch (IllegalArgumentException e) {
					shop_CreateTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String shop_visible = req.getParameter("shop_visible").trim();

				PetShopVO petshopVO = new PetShopVO();
				petshopVO.setShop_Id(shop_Id);
				petshopVO.setShop_MemId(shop_MemId);
				petshopVO.setShop_name(shop_name);
				petshopVO.setShop_city(shop_city);
				petshopVO.setShop_town(shop_town);
				petshopVO.setShop_road(shop_road);
				petshopVO.setShop_Eval(shop_Eval);
				petshopVO.setShop_URL(shop_URL);
				petshopVO.setShop_StartTime(shop_StartTime);
				petshopVO.setShop_EndTime(shop_EndTime);
				petshopVO.setShop_Tel(shop_Tel);
				petshopVO.setShop_Desc(shop_Desc);
				petshopVO.setShop_Long(shop_Long);
				petshopVO.setShop_Lat(shop_Lat);
				petshopVO.setShop_CreateTime(shop_CreateTime);
				petshopVO.setShop_visible(shop_visible);
				if (!errorMsgs.isEmpty()) {
					String url = "/petshop/update_petshop_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				PetShopService petshopSvc = new PetShopService();
				petshopVO = petshopSvc.updatePetShop(shop_Id,shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,shop_StartTime,shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,shop_CreateTime,shop_visible);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("petshopVO", petshopVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/petshop/update_petshop_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addPetShop.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String shop_MemId = req.getParameter("shop_MemId").trim();
                String shop_name = req.getParameter("shop_name").trim();
                String shop_city = req.getParameter("shop_city").trim();
                String shop_town = req.getParameter("shop_town").trim();
                String shop_road = req.getParameter("shop_road").trim();
                Integer shop_Eval = new Integer(req.getParameter("shop_Eval").trim());
                String shop_URL = req.getParameter("shop_URL").trim();
                String shop_StartTime = req.getParameter("shop_StartTime").trim();
                String shop_EndTime = req.getParameter("shop_EndTime").trim();
                String shop_Tel = req.getParameter("shop_Tel").trim();
                String shop_Desc = req.getParameter("shop_Desc").trim();
                Double shop_Long = null;
                try {
                    shop_Long = new Double(req.getParameter("shop_Long").trim());
                } catch (NumberFormatException e) {
                    shop_Long = 0.0;
                    errorMsgs.add("商家經度座標請填數字.");
                    e.printStackTrace();
                }
                Double shop_Lat = null;
                try {
                    shop_Lat = new Double(req.getParameter("shop_Lat").trim());
                } catch (NumberFormatException e) {
                    shop_Lat = 0.0;
                    errorMsgs.add("商家緯度座標請填數字.");
                    e.printStackTrace();
                }
                java.sql.Date shop_CreateTime = null;
                try {
                    shop_CreateTime = java.sql.Date.valueOf(req.getParameter("shop_CreateTime").trim());
                } catch (IllegalArgumentException e) {
                    shop_CreateTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String shop_visible = req.getParameter("shop_visible").trim();

                PetShopVO petshopVO = new PetShopVO();
                petshopVO.setShop_MemId(shop_MemId);
                petshopVO.setShop_name(shop_name);
                petshopVO.setShop_city(shop_city);
                petshopVO.setShop_town(shop_town);
                petshopVO.setShop_road(shop_road);
                petshopVO.setShop_Eval(shop_Eval);
                petshopVO.setShop_URL(shop_URL);
                petshopVO.setShop_StartTime(shop_StartTime);
                petshopVO.setShop_EndTime(shop_EndTime);
                petshopVO.setShop_Tel(shop_Tel);
                petshopVO.setShop_Desc(shop_Desc);
                petshopVO.setShop_Long(shop_Long);
                petshopVO.setShop_Lat(shop_Lat);
                petshopVO.setShop_CreateTime(shop_CreateTime);
                petshopVO.setShop_visible(shop_visible);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("petshopVO", petshopVO); // 含有輸入格式錯誤的petshopVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/petshop/addPetShop.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                PetShopService petshopSvc = new PetShopService();
                petshopVO = petshopSvc.addPetShop(shop_MemId,shop_name,shop_city,shop_town,shop_road,shop_Eval,shop_URL,shop_StartTime,shop_EndTime,shop_Tel,shop_Desc,shop_Long,shop_Lat,shop_CreateTime,shop_visible); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/petshop/listAllPetShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/petshop/addPetShop.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllPetShop.jsp 或  /dept/listPetShops_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/petshop/listAllPetShop.jsp】 或  【/dept/listPetShops_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /petshop/listPetShops_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String shop_Id = new String(req.getParameter("shop_Id"));

                
                /***************************2.開始刪除資料***************************************/
                PetShopService petshopSvc = new PetShopService();
                PetShopVO petshopVO = petshopSvc.getOnePetShop(shop_Id);
   
                petshopSvc.deletePetShop(shop_Id);
             
                
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
