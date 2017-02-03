package com.track.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;
import com.track.model.*;
/** 
 *表格名稱 : <br>
 *	中文:追蹤收藏<br>
 *	英文:track<br>
 */ 
@WebServlet(urlPatterns = { "/track/track.do" })
public class TrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Track servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("track_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入收藏編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  track_Id = null;
				try {
					track_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("收藏編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				TrackService trackSvc = new TrackService();
				TrackVO trackVO = trackSvc.getOneTrack(track_Id);
				if (trackVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("trackVO", trackVO); 
				String url = "/track/listOneTrack.jsp";
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
				String  track_Id = new String (req.getParameter("track_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				TrackService trackSvc = new TrackService();
				TrackVO trackVO = trackSvc.getOneTrack(track_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("trackVO", trackVO); 
				String url = "/track/update_track_input.jsp";
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
				String track_Id = req.getParameter("track_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String track_record_class = req.getParameter("track_record_class").trim();
				String track_record_class_Id = req.getParameter("track_record_class_Id").trim();

				TrackVO trackVO = new TrackVO();
				trackVO.setTrack_Id(track_Id);
				trackVO.setMem_Id(mem_Id);
				trackVO.setTrack_record_class(track_record_class);
				trackVO.setTrack_record_class_Id(track_record_class_Id);
				if (!errorMsgs.isEmpty()) {
					String url = "/track/update_track_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				TrackService trackSvc = new TrackService();
				trackVO = trackSvc.updateTrack(track_Id,mem_Id,track_record_class,track_record_class_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("trackVO", trackVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/track/update_track_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addTrack.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_Id = req.getParameter("mem_Id").trim();
                String track_record_class = req.getParameter("track_record_class").trim();
                String track_record_class_Id = req.getParameter("track_record_class_Id").trim();

                TrackVO trackVO = new TrackVO();
                trackVO.setMem_Id(mem_Id);
                trackVO.setTrack_record_class(track_record_class);
                trackVO.setTrack_record_class_Id(track_record_class_Id);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("trackVO", trackVO); // 含有輸入格式錯誤的trackVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/track/addTrack.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                TrackService trackSvc = new TrackService();
                trackVO = trackSvc.addTrack(mem_Id,track_record_class,track_record_class_Id); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/track/listAllTrack.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/track/addTrack.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllTrack.jsp 或  /dept/listTracks_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/track/listAllTrack.jsp】 或  【/dept/listTracks_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /track/listTracks_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String track_Id = new String(req.getParameter("track_Id"));

                
                /***************************2.開始刪除資料***************************************/
                TrackService trackSvc = new TrackService();
                TrackVO trackVO = trackSvc.getOneTrack(track_Id);
   
                trackSvc.deleteTrack(track_Id);
             
                
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
