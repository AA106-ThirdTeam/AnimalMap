package com.purview.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.EmpService;
import com.purview.model.PurviewService;
import com.purview.model.PurviewVO;


public class PurviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		String action=req.getParameter("action");
		
		if("getOne_For_Display".equals(action)){
			
			List<String> errorMsgs =new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/****************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String purview_No = req.getParameter("purview_No");

				if (purview_No == null || (purview_No.trim()).length() == 0) {
					errorMsgs.add("請輸入編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/purview/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}


				/*************************** 2.開始查詢資料 *****************************************/
				PurviewService purviewSvc = new PurviewService();
				PurviewVO purviewVO = purviewSvc.getOnePurview(purview_No);

				if (purviewVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/purview/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/****************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("purviewVO", purviewVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/purview/listOnePurview.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交
																				// listOnePurview.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/purview/select_page.jsp");
				failureView.forward(req, res);
			}
		
			
		}
		
		if("insert".equals(action)){
			
			List<String> errorMsgs=new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				//接受參數，錯誤處理
				String purview_name =req.getParameter("purview_name").trim();
				if(purview_name == null || purview_name.trim().length() ==0){
					
					errorMsgs.add("請輸入名稱");
				}
				
				PurviewVO purviewVO=new PurviewVO();
				purviewVO.setPurview_name(purview_name);
				
				if(!errorMsgs.isEmpty()){
					req.setAttribute("purviewVO", purviewVO);
					RequestDispatcher failureView =req.getRequestDispatcher("/back-end/purview/addPurview.jsp");
					failureView.forward(req,res);
					return;
				}
				
				//開始新增資料
				PurviewService purviewSvc =new PurviewService();
				purviewVO =purviewSvc.addPurview(purview_name);
				
				//新增完成，轉交成功頁面
				
				String url="/back-end/purview/listAllPurview.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交
				successView.forward(req, res);
				
				
				
				
				//其他可能的錯誤
			}catch(Exception e){
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView =req.getRequestDispatcher("/back-end/purview/addPurview.jsp");
				failureView.forward(req,res);
				
			}
			
		}
		
		
		if("delete".equals(action)){
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				
				String purview_No = req.getParameter("purview_No");

				/*************************** 2.開始刪除資料 ***************************************/
				PurviewService  purviewSvc = new  PurviewService();
				purviewSvc.deletePurview(purview_No);

				/******************************** 3.刪除完成,準備轉交(Send the Success view)***********/
				
				String url ="/back-end/purview/listAllPurview.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/purview/listAllPurview.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	}

}
