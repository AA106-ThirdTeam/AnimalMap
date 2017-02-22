package com.emg_H.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.emg_H.model.*;
import com.emg_H_Msg.model.Emg_H_MsgVO;




@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class Emg_HServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		
				//來自 emg_H_Msg/select_page.jsp                    //來自於  emg_H/listAllEmg_H.jsp
		if ("listEmg_H_Msg_ByEmg_H_Id_B".equals(action)) {	

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL");
			
			try {
			/*************************** 1.接收請求參數 ****************************************/
			String  emg_H_Id = req.getParameter("emg_H_Id");
			
			/*************************** 2.開始查詢資料 ****************************************/
			
			
			Emg_HService Emg_HSvc = new Emg_HService();
			Set<Emg_H_MsgVO> set = Emg_HSvc.getEmg_H_MsgByEmg_H_Id(emg_H_Id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("emg_H_Id", emg_H_Id); // 帶emg_H_Id 存入req, 	※include 時  getParameter的方式 原資料會不見!	// 
			
			if(requestURL.equals("/front-end/emg_H/listOneEmg_H.jsp") || requestURL.equals("/front-end/emg_H/listAllEmg_H.jsp"))
				req.setAttribute("listEmg_H_Msg_ByEmg_H_Id",set);
			
			String url = requestURL;
			
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
			/*************************** 其他可能的錯誤處理 ***********************************/
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
		
		
		if ("delete_Emg_H".equals(action)) { // 來自/emg_H/listAllEmg_H.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
		
			
			try {
				/***************************1.接收請求參數***************************************/
				String  emg_H_Id = req.getParameter("emg_H_Id");

				
				/***************************2.開始刪除資料***************************************/
				Emg_HService Emg_HSvc = new Emg_HService();
				Emg_HSvc.delete(emg_H_Id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				String url = "/front-end/emg_H/listAllEmg_H.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後, 成功轉交 回到/emg_H/listAllEmg_H.jsp
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理***********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/emg_H/listAllEmg_H.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("listEmg_H_Msg_ByEmg_H_Id_A".equals(action) ) {	

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			
			try {
			/*************************** 1.接收請求參數 ****************************************/
			String  emg_H_Id = req.getParameter("emg_H_Id");
			
			/*************************** 2.開始查詢資料 ****************************************/
			
			
			Emg_HService Emg_HSvc = new Emg_HService();
			Emg_HVO  emg_HVO= Emg_HSvc.getOneEmg_H(emg_H_Id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("emg_HVO", emg_HVO);    // 資料庫取出的emg_HVO物件,存入request
			
			req.setAttribute("emg_H_Id", emg_H_Id); // 帶emg_H_Id 存入req, 	※include 時  getParameter的方式 原資料會不見! 
			
			String url = "/front-end/emg_H/listOneEmg_H.jsp"; // 成功轉交 emg_H/listOneEmg_H.jsp

			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

			/*************************** 其他可能的錯誤處理 ***********************************/
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
		
		
		if ("delete_Emg_H".equals(action)) { // 來自/emg_H/listAllEmg_H.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				String  emg_H_Id = req.getParameter("emg_H_Id");

				
				/***************************2.開始刪除資料***************************************/
				Emg_HService Emg_HSvc = new Emg_HService();
				Emg_HSvc.delete(emg_H_Id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				String url = "/front-end/emg_H/listAllEmg_H.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後, 成功轉交 回到/emg_H/listAllEmg_H.jsp
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理***********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/emg_H/listAllEmg_H.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/**************************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/


				String mem_Id = req.getParameter("mem_Id").trim();

				if (mem_Id == null || (mem_Id.trim()).length() == 0) {

					errorMsgs.add("會員輸入");
				}
				
				java.sql.Timestamp  emg_H_start_date=new java.sql.Timestamp (System.currentTimeMillis());
				
				// 排程器排定刪除?
				int dayCount=3*(24*60*60*1000);  //增加天數
				java.sql.Timestamp  emg_H_end_date=new java.sql.Timestamp (System.currentTimeMillis()+dayCount);				
						

				String emg_H_title = req.getParameter("emg_H_title").trim();

				if (emg_H_title == null || (emg_H_title.trim()).length() == 0) {

					errorMsgs.add("請輸入Title");
				}

				String emg_H_content = req.getParameter("emg_H_content").trim();

				if (emg_H_content == null || (emg_H_content.trim()).length() == 0) {

					errorMsgs.add("請輸入內容!");
				}
				
				//新增圖片
				Collection<Part> parts = req.getParts();
				byte[] emg_H_pic = null;
				for (Part part : parts) {
					if ("emg_H_pic".equals(part.getName())) {
						InputStream in = part.getInputStream();
						emg_H_pic = new byte[in.available()];
						in.read(emg_H_pic);
						in.close();
					}

				}

				String emg_H_city = req.getParameter("emg_H_city").trim();
			
				if (emg_H_city == null || (emg_H_city.trim()).length() == 0) {

					errorMsgs.add("請輸入縣市");
				}
				
				String emg_H_town = req.getParameter("emg_H_town").trim();
			
				if (emg_H_town == null || (emg_H_town.trim()).length() == 0) {

					errorMsgs.add("請輸入鄉鎮地區");
				}
				String emg_H_road = req.getParameter("emg_H_road").trim();
			
				if (emg_H_road == null || (emg_H_road.trim()).length() == 0) {
					
					errorMsgs.add("請輸入路名街道");
				}
				
				String str = req.getParameter("emg_H_Lon");
			
				if (str == null || (str.trim()).length() == 0) {
					
					errorMsgs.add("請輸入經度");
				}
				
				Double emg_H_Lon=null;
				try {
					emg_H_Lon = new Double(str);
				} catch (Exception e) {
					errorMsgs.add("經度格式不正確");
				}

				String str2 =req.getParameter("emg_H_Lat");
			
				if (str2 == null || (str2.trim()).length() == 0) {
					
					errorMsgs.add("請輸入緯度");
				}
				
				Double emg_H_Lat=null;
				try {
					emg_H_Lat = new Double(str2);
				} catch (Exception e) {
					errorMsgs.add("緯度格式不正確");
				}

				Emg_HVO emg_HVO = new Emg_HVO();

				emg_HVO.setMem_Id(mem_Id);
				emg_HVO.setEmg_H_title(emg_H_title);
				emg_HVO.setEmg_H_content(emg_H_content);
				emg_HVO.setEmg_H_city(emg_H_city);
				emg_HVO.setEmg_H_road(emg_H_road);
				emg_HVO.setEmg_H_town(emg_H_town);
				emg_HVO.setEmg_H_Lon(emg_H_Lon);
				emg_HVO.setEmg_H_Lat(emg_H_Lat);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("emg_HVO", emg_HVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H/addEmg_H.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始新增資料 ***************************************/
				Emg_HService emg_HSvc = new Emg_HService();
				emg_HVO = emg_HSvc.addEmg_H( mem_Id, emg_H_start_date, emg_H_end_date, emg_H_title, emg_H_content, emg_H_pic, emg_H_city, emg_H_town, emg_H_road, emg_H_Lon, emg_H_Lat);

				/******************************* 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/front-end/emg_H/listAllEmg_H.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmg_H.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/emg_H/addEmg_H.jsp");
				failureView.forward(req, res);
			}
		}

	}

}

