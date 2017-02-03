package com.hosphoto.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.vet_hospital.model.*;
import com.hosphoto.model.*;
/** 
 *表格名稱 : <br>
 *	中文:診所相片<br>
 *	英文:hosPhoto<br>
 */ 
@WebServlet(urlPatterns = { "/hosphoto/hosphoto.do" })
public class HosPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("HosPhoto servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("hosPhoto_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入相片編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  hosPhoto_Id = null;
				try {
					hosPhoto_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("相片編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				HosPhotoService hosphotoSvc = new HosPhotoService();
				HosPhotoVO hosphotoVO = hosphotoSvc.getOneHosPhoto(hosPhoto_Id);
				if (hosphotoVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("hosphotoVO", hosphotoVO); 
				String url = "/hosphoto/listOneHosPhoto.jsp";
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
				String  hosPhoto_Id = new String (req.getParameter("hosPhoto_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				HosPhotoService hosphotoSvc = new HosPhotoService();
				HosPhotoVO hosphotoVO = hosphotoSvc.getOneHosPhoto(hosPhoto_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("hosphotoVO", hosphotoVO); 
				String url = "/hosphoto/update_hosphoto_input.jsp";
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
				String hosPhoto_Id = req.getParameter("hosPhoto_Id").trim();
				String hosPhoto_HosId = req.getParameter("hosPhoto_HosId").trim();
				byte[] hosPhoto_photo = null;
				try {
					Part part = req.getPart("hosPhoto_photo");
					InputStream in = part.getInputStream();
					hosPhoto_photo = new byte[part.getInputStream().available()];
					in.read(hosPhoto_photo);
					in.close();
				} catch (Exception e) {
					hosPhoto_photo = null;
					//errorMsgs.add("相片請上傳照片.");
				}
				String isDisp_HosPhoto = req.getParameter("isDisp_HosPhoto").trim();
				String hosPhoto_name = req.getParameter("hosPhoto_name").trim();
				String hosPhoto_extent = req.getParameter("hosPhoto_extent").trim();

				HosPhotoVO hosphotoVO = new HosPhotoVO();
				hosphotoVO.setHosPhoto_Id(hosPhoto_Id);
				hosphotoVO.setHosPhoto_HosId(hosPhoto_HosId);
				hosphotoVO.setHosPhoto_photo(hosPhoto_photo);
				hosphotoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
				hosphotoVO.setHosPhoto_name(hosPhoto_name);
				hosphotoVO.setHosPhoto_extent(hosPhoto_extent);
				if (!errorMsgs.isEmpty()) {
					String url = "/hosphoto/update_hosphoto_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				HosPhotoService hosphotoSvc = new HosPhotoService();
				hosphotoVO = hosphotoSvc.updateHosPhoto(hosPhoto_Id,hosPhoto_HosId,hosPhoto_photo,isDisp_HosPhoto,hosPhoto_name,hosPhoto_extent);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("hosphotoVO", hosphotoVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hosphoto/update_hosphoto_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addHosPhoto.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String hosPhoto_HosId = req.getParameter("hosPhoto_HosId").trim();
                byte[] hosPhoto_photo = null;
                try {
                    Part part = req.getPart("hosPhoto_photo");
                    InputStream in = part.getInputStream();
                    hosPhoto_photo = new byte[part.getInputStream().available()];
                    in.read(hosPhoto_photo);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("相片請上傳照片.");
                    //e.printStackTrace();
                    hosPhoto_photo = null;
                }
                String isDisp_HosPhoto = req.getParameter("isDisp_HosPhoto").trim();
                String hosPhoto_name = req.getParameter("hosPhoto_name").trim();
                String hosPhoto_extent = req.getParameter("hosPhoto_extent").trim();

                HosPhotoVO hosphotoVO = new HosPhotoVO();
                hosphotoVO.setHosPhoto_HosId(hosPhoto_HosId);
                hosphotoVO.setHosPhoto_photo(hosPhoto_photo);
                hosphotoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
                hosphotoVO.setHosPhoto_name(hosPhoto_name);
                hosphotoVO.setHosPhoto_extent(hosPhoto_extent);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("hosphotoVO", hosphotoVO); // 含有輸入格式錯誤的hosphotoVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/hosphoto/addHosPhoto.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                HosPhotoService hosphotoSvc = new HosPhotoService();
                hosphotoVO = hosphotoSvc.addHosPhoto(hosPhoto_HosId,hosPhoto_photo,isDisp_HosPhoto,hosPhoto_name,hosPhoto_extent); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/hosphoto/listAllHosPhoto.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/hosphoto/addHosPhoto.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllHosPhoto.jsp 或  /dept/listHosPhotos_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/hosphoto/listAllHosPhoto.jsp】 或  【/dept/listHosPhotos_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /hosphoto/listHosPhotos_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String hosPhoto_Id = new String(req.getParameter("hosPhoto_Id"));

                
                /***************************2.開始刪除資料***************************************/
                HosPhotoService hosphotoSvc = new HosPhotoService();
                HosPhotoVO hosphotoVO = hosphotoSvc.getOneHosPhoto(hosPhoto_Id);
   
                hosphotoSvc.deleteHosPhoto(hosPhoto_Id);
             
                
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
