package com.adpphotos.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.adpphotos.model.*;
/** 
 *表格名稱 : <br>
 *	中文:領養活動相簿<br>
 *	英文:adpPhotos<br>
 */ 
@WebServlet(urlPatterns = { "/adpphotos/adpphotos.do" })
public class AdpPhotosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("AdpPhotos servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("adpPhotos_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入領養活動相簿編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  adpPhotos_Id = null;
				try {
					adpPhotos_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("領養活動相簿編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				AdpPhotosService adpphotosSvc = new AdpPhotosService();
				AdpPhotosVO adpphotosVO = adpphotosSvc.getOneAdpPhotos(adpPhotos_Id);
				if (adpphotosVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpphotosVO", adpphotosVO); 
				String url = "/adpphotos/listOneAdpPhotos.jsp";
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
				String  adpPhotos_Id = new String (req.getParameter("adpPhotos_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				AdpPhotosService adpphotosSvc = new AdpPhotosService();
				AdpPhotosVO adpphotosVO = adpphotosSvc.getOneAdpPhotos(adpPhotos_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpphotosVO", adpphotosVO); 
				String url = "/adpphotos/update_adpphotos_input.jsp";
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
				String adpPhotos_Id = req.getParameter("adpPhotos_Id").trim();
				String adp_Id = req.getParameter("adp_Id").trim();
				byte[] adpPhotosPic = null;
				try {
					Part part = req.getPart("adpPhotosPic");
					InputStream in = part.getInputStream();
					adpPhotosPic = new byte[part.getInputStream().available()];
					in.read(adpPhotosPic);
					in.close();
				} catch (Exception e) {
					adpPhotosPic = null;
					//errorMsgs.add("領養活動照片請上傳照片.");
				}

				AdpPhotosVO adpphotosVO = new AdpPhotosVO();
				adpphotosVO.setAdpPhotos_Id(adpPhotos_Id);
				adpphotosVO.setAdp_Id(adp_Id);
				adpphotosVO.setAdpPhotosPic(adpPhotosPic);
				if (!errorMsgs.isEmpty()) {
					String url = "/adpphotos/update_adpphotos_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				AdpPhotosService adpphotosSvc = new AdpPhotosService();
				adpphotosVO = adpphotosSvc.updateAdpPhotos(adpPhotos_Id,adp_Id,adpPhotosPic);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adpphotosVO", adpphotosVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/adpphotos/update_adpphotos_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addAdpPhotos.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String adp_Id = req.getParameter("adp_Id").trim();
                byte[] adpPhotosPic = null;
                try {
                    Part part = req.getPart("adpPhotosPic");
                    InputStream in = part.getInputStream();
                    adpPhotosPic = new byte[part.getInputStream().available()];
                    in.read(adpPhotosPic);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("領養活動照片請上傳照片.");
                    //e.printStackTrace();
                    adpPhotosPic = null;
                }

                AdpPhotosVO adpphotosVO = new AdpPhotosVO();
                adpphotosVO.setAdp_Id(adp_Id);
                adpphotosVO.setAdpPhotosPic(adpPhotosPic);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("adpphotosVO", adpphotosVO); // 含有輸入格式錯誤的adpphotosVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/adpphotos/addAdpPhotos.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                AdpPhotosService adpphotosSvc = new AdpPhotosService();
                adpphotosVO = adpphotosSvc.addAdpPhotos(adp_Id,adpPhotosPic); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/adpphotos/listAllAdpPhotos.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/adpphotos/addAdpPhotos.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllAdpPhotos.jsp 或  /dept/listAdpPhotoss_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/adpphotos/listAllAdpPhotos.jsp】 或  【/dept/listAdpPhotoss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /adpphotos/listAdpPhotoss_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String adpPhotos_Id = new String(req.getParameter("adpPhotos_Id"));

                
                /***************************2.開始刪除資料***************************************/
                AdpPhotosService adpphotosSvc = new AdpPhotosService();
                AdpPhotosVO adpphotosVO = adpphotosSvc.getOneAdpPhotos(adpPhotos_Id);
   
                adpphotosSvc.deleteAdpPhotos(adpPhotos_Id);
             
                
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
