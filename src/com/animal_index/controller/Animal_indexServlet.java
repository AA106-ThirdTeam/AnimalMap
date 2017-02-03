package com.animal_index.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.animal_index.model.*;
/** 
 *表格名稱 : <br>
 *	中文:動物圖鑑<br>
 *	英文:animal_index<br>
 */ 
@WebServlet(urlPatterns = { "/animal_index/animal_index.do" })
public class Animal_indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Animal_index servlet運行成功 ");

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("animal_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入圖鑑編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  animal_No = null;
				try {
					animal_No = new String (str);
				} catch (Exception e) {
					errorMsgs.add("圖鑑編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				Animal_indexService animal_indexSvc = new Animal_indexService();
				Animal_indexVO animal_indexVO = animal_indexSvc.getOneAnimal_index(animal_No);
				if (animal_indexVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("animal_indexVO", animal_indexVO); 
				String url = "/animal_index/listOneAnimal_index.jsp";
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
				String  animal_No = new String (req.getParameter("animal_No").trim());

				/***************************2.開始查詢資料*****************************************/
				Animal_indexService animal_indexSvc = new Animal_indexService();
				Animal_indexVO animal_indexVO = animal_indexSvc.getOneAnimal_index(animal_No);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("animal_indexVO", animal_indexVO); 
				String url = "/animal_index/update_animal_index_input.jsp";
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
				String animal_No = req.getParameter("animal_No").trim();
				String animal_detail = req.getParameter("animal_detail").trim();
				String animal_class = req.getParameter("animal_class").trim();
				String animal_class_No = req.getParameter("animal_class_No").trim();

				Animal_indexVO animal_indexVO = new Animal_indexVO();
				animal_indexVO.setAnimal_No(animal_No);
				animal_indexVO.setAnimal_detail(animal_detail);
				animal_indexVO.setAnimal_class(animal_class);
				animal_indexVO.setAnimal_class_No(animal_class_No);
				if (!errorMsgs.isEmpty()) {
					String url = "/animal_index/update_animal_index_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				Animal_indexService animal_indexSvc = new Animal_indexService();
				animal_indexVO = animal_indexSvc.updateAnimal_index(animal_No,animal_detail,animal_class,animal_class_No);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("animal_indexVO", animal_indexVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/animal_index/update_animal_index_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addAnimal_index.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String animal_detail = req.getParameter("animal_detail").trim();
                String animal_class = req.getParameter("animal_class").trim();
                String animal_class_No = req.getParameter("animal_class_No").trim();

                Animal_indexVO animal_indexVO = new Animal_indexVO();
                animal_indexVO.setAnimal_detail(animal_detail);
                animal_indexVO.setAnimal_class(animal_class);
                animal_indexVO.setAnimal_class_No(animal_class_No);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("animal_indexVO", animal_indexVO); // 含有輸入格式錯誤的animal_indexVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/animal_index/addAnimal_index.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Animal_indexService animal_indexSvc = new Animal_indexService();
                animal_indexVO = animal_indexSvc.addAnimal_index(animal_detail,animal_class,animal_class_No); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/animal_index/listAllAnimal_index.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/animal_index/addAnimal_index.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllAnimal_index.jsp 或  /dept/listAnimal_indexs_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/animal_index/listAllAnimal_index.jsp】 或  【/dept/listAnimal_indexs_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /animal_index/listAnimal_indexs_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String animal_No = new String(req.getParameter("animal_No"));

                
                /***************************2.開始刪除資料***************************************/
                Animal_indexService animal_indexSvc = new Animal_indexService();
                Animal_indexVO animal_indexVO = animal_indexSvc.getOneAnimal_index(animal_No);
   
                animal_indexSvc.deleteAnimal_index(animal_No);
             
                
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