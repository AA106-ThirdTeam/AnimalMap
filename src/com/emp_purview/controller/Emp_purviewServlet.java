package com.emp_purview.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;
import com.emp_purview.model.Emp_purviewService;
import com.emp_purview.model.Emp_purviewVO;


public class Emp_purviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Emp_purviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("updateEmp_Purview".equals(action)) { 
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/****************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String emp_No = req.getParameter("emp_No");
				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				

				/*************************** 2.開始查詢資料 *****************************************/
				
				Emp_purviewService emp_purviewSvc = new Emp_purviewService();
				Set<Emp_purviewVO>  set =emp_purviewSvc.Emp_purviewByEmp_no(emp_No);
				 
				
				 
				if (set == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/****************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("set", set); // 資料庫取出的empVO物件,存入req
				
				req.setAttribute("emp_No", emp_No); // 帶emp_No 存入req, 	※確保forward 值會在  

				String url = "/back-end/emp_purview/listEmp_purviewByEmp_No.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交
																				// listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		if("addEmp_Purview".equals(action)){
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			Emp_purviewService emp_purviewSvc=new Emp_purviewService();
			
			
			try {
				/****************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

				String emp_No = req.getParameter("emp_No");
				
				String values[]=req.getParameterValues("purview_No"); // 把所選的權限放到一個陣列裡面
				
				if(values!=null){	
					
					emp_purviewSvc.deleteEmp_purview(emp_No);  //先清空該員工的權限	
					for(int i=0;i<values.length;i++){					
										
				    emp_purviewSvc.addEmp_purview(emp_No, values[i]); //依照所選的權限再新增
					}
					
				}else{
					
					errorMsgs.add("請給予權限");
				}
				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp_purview/listEmp_purviewByEmp_No.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}


				/*************************** 2.開始查詢資料 *****************************************/
				
				
				
				Set<Emp_purviewVO> set =emp_purviewSvc.Emp_purviewByEmp_no(emp_No);				 
				
	 
				if (set == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/****************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("set", set); // 資料庫取出的empVO物件,存入req
				
				req.setAttribute("emp_No", emp_No); // 帶emp_No 存入req, 	※確保forward 值會在  

				String url = "/back-end/emp/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交
																				// listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
				} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/select_page.jsp");
				failureView.forward(req, res);
			}
		}

	}

}
