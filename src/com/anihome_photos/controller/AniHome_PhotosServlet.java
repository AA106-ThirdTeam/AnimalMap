package com.anihome_photos.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.anihome.model.*;
import com.anihome_photos.model.*;
/** 
 *表格名稱 : <br>
 *	中文:動物之家相簿<br>
 *	英文:aniHome_Photos<br>
 */ 
@WebServlet(urlPatterns = { "/anihome_photos/anihome_photos.do" })
public class AniHome_PhotosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("AniHome_Photos servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("aniHome_Photos_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入相片編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  aniHome_Photos_Id = null;
				try {
					aniHome_Photos_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("相片編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
				AniHome_PhotosVO anihome_photosVO = anihome_photosSvc.getOneAniHome_Photos(aniHome_Photos_Id);
				if (anihome_photosVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihome_photosVO", anihome_photosVO); 
				String url = "/anihome_photos/listOneAniHome_Photos.jsp";
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
				String  aniHome_Photos_Id = new String (req.getParameter("aniHome_Photos_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
				AniHome_PhotosVO anihome_photosVO = anihome_photosSvc.getOneAniHome_Photos(aniHome_Photos_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihome_photosVO", anihome_photosVO); 
				String url = "/anihome_photos/update_anihome_photos_input.jsp";
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
				String aniHome_Photos_Id = req.getParameter("aniHome_Photos_Id").trim();
				String aniHome_Id = req.getParameter("aniHome_Id").trim();
				byte[] aniHome_Photos_pic = null;
				try {
					Part part = req.getPart("aniHome_Photos_pic");
					InputStream in = part.getInputStream();
					aniHome_Photos_pic = new byte[part.getInputStream().available()];
					in.read(aniHome_Photos_pic);
					in.close();
				} catch (Exception e) {
					aniHome_Photos_pic = null;
					//errorMsgs.add("動物之家照片請上傳照片.");
				}

				AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
				anihome_photosVO.setAniHome_Photos_Id(aniHome_Photos_Id);
				anihome_photosVO.setAniHome_Id(aniHome_Id);
				anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);
				if (!errorMsgs.isEmpty()) {
					String url = "/anihome_photos/update_anihome_photos_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
				anihome_photosVO = anihome_photosSvc.updateAniHome_Photos(aniHome_Photos_Id,aniHome_Id,aniHome_Photos_pic);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("anihome_photosVO", anihome_photosVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/anihome_photos/update_anihome_photos_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addAniHome_Photos.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String aniHome_Id = req.getParameter("aniHome_Id").trim();
                byte[] aniHome_Photos_pic = null;
                try {
                    Part part = req.getPart("aniHome_Photos_pic");
                    InputStream in = part.getInputStream();
                    aniHome_Photos_pic = new byte[part.getInputStream().available()];
                    in.read(aniHome_Photos_pic);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("動物之家照片請上傳照片.");
                    //e.printStackTrace();
                    aniHome_Photos_pic = null;
                }

                AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
                anihome_photosVO.setAniHome_Id(aniHome_Id);
                anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("anihome_photosVO", anihome_photosVO); // 含有輸入格式錯誤的anihome_photosVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/anihome_photos/addAniHome_Photos.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
                anihome_photosVO = anihome_photosSvc.addAniHome_Photos(aniHome_Id,aniHome_Photos_pic); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/anihome_photos/listAllAniHome_Photos.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/anihome_photos/addAniHome_Photos.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllAniHome_Photos.jsp 或  /dept/listAniHome_Photoss_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/anihome_photos/listAllAniHome_Photos.jsp】 或  【/dept/listAniHome_Photoss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /anihome_photos/listAniHome_Photoss_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String aniHome_Photos_Id = new String(req.getParameter("aniHome_Photos_Id"));

                
                /***************************2.開始刪除資料***************************************/
                AniHome_PhotosService anihome_photosSvc = new AniHome_PhotosService();
                AniHome_PhotosVO anihome_photosVO = anihome_photosSvc.getOneAniHome_Photos(aniHome_Photos_Id);
   
                anihome_photosSvc.deleteAniHome_Photos(aniHome_Photos_Id);
             
                
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
