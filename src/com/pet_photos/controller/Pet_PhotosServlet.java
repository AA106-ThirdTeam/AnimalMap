package com.pet_photos.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.pet.model.*;
import com.mem.model.*;
import com.pet_photos.model.*;
/** 
 *表格名稱 : <br>
 *	中文:自家寵物相簿<br>
 *	英文:pet_Photos<br>
 */ 
@WebServlet(urlPatterns = { "/pet_photos/pet_photos.do" })
public class Pet_PhotosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Pet_Photos servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("pet_Pic_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入寵物相片編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  pet_Pic_No = null;
				try {
					pet_Pic_No = new String (str);
				} catch (Exception e) {
					errorMsgs.add("寵物相片編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
				Pet_PhotosVO pet_photosVO = pet_photosSvc.getOnePet_Photos(pet_Pic_No);
				if (pet_photosVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("pet_photosVO", pet_photosVO); 
				String url = "/pet_photos/listOnePet_Photos.jsp";
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
				String  pet_Pic_No = new String (req.getParameter("pet_Pic_No").trim());

				/***************************2.開始查詢資料*****************************************/
				Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
				Pet_PhotosVO pet_photosVO = pet_photosSvc.getOnePet_Photos(pet_Pic_No);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("pet_photosVO", pet_photosVO); 
				String url = "/pet_photos/update_pet_photos_input.jsp";
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
				String pet_Pic_No = req.getParameter("pet_Pic_No").trim();
				String pet_Id = req.getParameter("pet_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				byte[] pet_Pic = null;
				try {
					Part part = req.getPart("pet_Pic");
					InputStream in = part.getInputStream();
					pet_Pic = new byte[part.getInputStream().available()];
					in.read(pet_Pic);
					in.close();
				} catch (Exception e) {
					pet_Pic = null;
					//errorMsgs.add("寵物相片請上傳照片.");
				}
				String pet_Pic_name = req.getParameter("pet_Pic_name").trim();
				String pet_Pic_extent = req.getParameter("pet_Pic_extent").trim();
				java.sql.Date pet_Pic_time = null;
				try {
					pet_Pic_time = java.sql.Date.valueOf(req.getParameter("pet_Pic_time").trim());
				} catch (IllegalArgumentException e) {
					pet_Pic_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String pet_Pic_type = req.getParameter("pet_Pic_type").trim();

				Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();
				pet_photosVO.setPet_Pic_No(pet_Pic_No);
				pet_photosVO.setPet_Id(pet_Id);
				pet_photosVO.setMem_Id(mem_Id);
				pet_photosVO.setPet_Pic(pet_Pic);
				pet_photosVO.setPet_Pic_name(pet_Pic_name);
				pet_photosVO.setPet_Pic_extent(pet_Pic_extent);
				pet_photosVO.setPet_Pic_time(pet_Pic_time);
				pet_photosVO.setPet_Pic_type(pet_Pic_type);
				if (!errorMsgs.isEmpty()) {
					String url = "/pet_photos/update_pet_photos_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
				pet_photosVO = pet_photosSvc.updatePet_Photos(pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,pet_Pic_time,pet_Pic_type);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("pet_photosVO", pet_photosVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/pet_photos/update_pet_photos_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addPet_Photos.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String pet_Id = req.getParameter("pet_Id").trim();
                String mem_Id = req.getParameter("mem_Id").trim();
                byte[] pet_Pic = null;
                try {
                    Part part = req.getPart("pet_Pic");
                    InputStream in = part.getInputStream();
                    pet_Pic = new byte[part.getInputStream().available()];
                    in.read(pet_Pic);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("寵物相片請上傳照片.");
                    //e.printStackTrace();
                    pet_Pic = null;
                }
                String pet_Pic_name = req.getParameter("pet_Pic_name").trim();
                String pet_Pic_extent = req.getParameter("pet_Pic_extent").trim();
                java.sql.Date pet_Pic_time = null;
                try {
                    pet_Pic_time = java.sql.Date.valueOf(req.getParameter("pet_Pic_time").trim());
                } catch (IllegalArgumentException e) {
                    pet_Pic_time=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String pet_Pic_type = req.getParameter("pet_Pic_type").trim();

                Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();
                pet_photosVO.setPet_Id(pet_Id);
                pet_photosVO.setMem_Id(mem_Id);
                pet_photosVO.setPet_Pic(pet_Pic);
                pet_photosVO.setPet_Pic_name(pet_Pic_name);
                pet_photosVO.setPet_Pic_extent(pet_Pic_extent);
                pet_photosVO.setPet_Pic_time(pet_Pic_time);
                pet_photosVO.setPet_Pic_type(pet_Pic_type);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("pet_photosVO", pet_photosVO); // 含有輸入格式錯誤的pet_photosVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/pet_photos/addPet_Photos.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
                pet_photosVO = pet_photosSvc.addPet_Photos(pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,pet_Pic_time,pet_Pic_type); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/pet_photos/listAllPet_Photos.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/pet_photos/addPet_Photos.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllPet_Photos.jsp 或  /dept/listPet_Photoss_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/pet_photos/listAllPet_Photos.jsp】 或  【/dept/listPet_Photoss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /pet_photos/listPet_Photoss_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String pet_Pic_No = new String(req.getParameter("pet_Pic_No"));

                
                /***************************2.開始刪除資料***************************************/
                Pet_PhotosService pet_photosSvc = new Pet_PhotosService();
                Pet_PhotosVO pet_photosVO = pet_photosSvc.getOnePet_Photos(pet_Pic_No);
   
                pet_photosSvc.deletePet_Photos(pet_Pic_No);
             
                
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
