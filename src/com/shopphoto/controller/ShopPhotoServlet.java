package com.shopphoto.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.petshop.model.*;
import com.shopphoto.model.*;
/** 
 *表格名稱 : <br>
 *	中文:商家相片<br>
 *	英文:shopPhoto<br>
 */ 
@WebServlet(urlPatterns = { "/shopphoto/shopphoto.do" })
public class ShopPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("ShopPhoto servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("shopPhoto_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入相片編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  shopPhoto_Id = null;
				try {
					shopPhoto_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("相片編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				ShopPhotoService shopphotoSvc = new ShopPhotoService();
				ShopPhotoVO shopphotoVO = shopphotoSvc.getOneShopPhoto(shopPhoto_Id);
				if (shopphotoVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("shopphotoVO", shopphotoVO); 
				String url = "/shopphoto/listOneShopPhoto.jsp";
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
				String  shopPhoto_Id = new String (req.getParameter("shopPhoto_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				ShopPhotoService shopphotoSvc = new ShopPhotoService();
				ShopPhotoVO shopphotoVO = shopphotoSvc.getOneShopPhoto(shopPhoto_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("shopphotoVO", shopphotoVO); 
				String url = "/shopphoto/update_shopphoto_input.jsp";
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
				String shopPhoto_Id = req.getParameter("shopPhoto_Id").trim();
				String shopPhoto_ShopId = req.getParameter("shopPhoto_ShopId").trim();
				byte[] shopPhoto_photo = null;
				try {
					Part part = req.getPart("shopPhoto_photo");
					InputStream in = part.getInputStream();
					shopPhoto_photo = new byte[part.getInputStream().available()];
					in.read(shopPhoto_photo);
					in.close();
				} catch (Exception e) {
					shopPhoto_photo = null;
					//errorMsgs.add("相片請上傳照片.");
				}
				String isDisp_shopPhoto = req.getParameter("isDisp_shopPhoto").trim();
				String shopPhoto_name = req.getParameter("shopPhoto_name").trim();
				String shopPhoto_extent = req.getParameter("shopPhoto_extent").trim();

				ShopPhotoVO shopphotoVO = new ShopPhotoVO();
				shopphotoVO.setShopPhoto_Id(shopPhoto_Id);
				shopphotoVO.setShopPhoto_ShopId(shopPhoto_ShopId);
				shopphotoVO.setShopPhoto_photo(shopPhoto_photo);
				shopphotoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
				shopphotoVO.setShopPhoto_name(shopPhoto_name);
				shopphotoVO.setShopPhoto_extent(shopPhoto_extent);
				if (!errorMsgs.isEmpty()) {
					String url = "/shopphoto/update_shopphoto_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				ShopPhotoService shopphotoSvc = new ShopPhotoService();
				shopphotoVO = shopphotoSvc.updateShopPhoto(shopPhoto_Id,shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("shopphotoVO", shopphotoVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/shopphoto/update_shopphoto_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addShopPhoto.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String shopPhoto_ShopId = req.getParameter("shopPhoto_ShopId").trim();
                byte[] shopPhoto_photo = null;
                try {
                    Part part = req.getPart("shopPhoto_photo");
                    InputStream in = part.getInputStream();
                    shopPhoto_photo = new byte[part.getInputStream().available()];
                    in.read(shopPhoto_photo);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("相片請上傳照片.");
                    //e.printStackTrace();
                    shopPhoto_photo = null;
                }
                String isDisp_shopPhoto = req.getParameter("isDisp_shopPhoto").trim();
                String shopPhoto_name = req.getParameter("shopPhoto_name").trim();
                String shopPhoto_extent = req.getParameter("shopPhoto_extent").trim();

                ShopPhotoVO shopphotoVO = new ShopPhotoVO();
                shopphotoVO.setShopPhoto_ShopId(shopPhoto_ShopId);
                shopphotoVO.setShopPhoto_photo(shopPhoto_photo);
                shopphotoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
                shopphotoVO.setShopPhoto_name(shopPhoto_name);
                shopphotoVO.setShopPhoto_extent(shopPhoto_extent);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("shopphotoVO", shopphotoVO); // 含有輸入格式錯誤的shopphotoVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/shopphoto/addShopPhoto.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                ShopPhotoService shopphotoSvc = new ShopPhotoService();
                shopphotoVO = shopphotoSvc.addShopPhoto(shopPhoto_ShopId,shopPhoto_photo,isDisp_shopPhoto,shopPhoto_name,shopPhoto_extent); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/shopphoto/listAllShopPhoto.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shopphoto/addShopPhoto.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllShopPhoto.jsp 或  /dept/listShopPhotos_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/shopphoto/listAllShopPhoto.jsp】 或  【/dept/listShopPhotos_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /shopphoto/listShopPhotos_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String shopPhoto_Id = new String(req.getParameter("shopPhoto_Id"));

                
                /***************************2.開始刪除資料***************************************/
                ShopPhotoService shopphotoSvc = new ShopPhotoService();
                ShopPhotoVO shopphotoVO = shopphotoSvc.getOneShopPhoto(shopPhoto_Id);
   
                shopphotoSvc.deleteShopPhoto(shopPhoto_Id);
             
                
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
