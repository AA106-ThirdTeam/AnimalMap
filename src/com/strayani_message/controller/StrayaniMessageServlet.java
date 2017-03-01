package com.strayani_message.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.strayani_message.model.StrayaniMessageService;
import com.strayani_message.model.StrayaniMessageVO;




public class StrayaniMessageServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("action: "+action);
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("str_Ani_Mes_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入送養動物留言編號ex.42000001");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				String str_Ani_Mes_No = null;
				try {
					str_Ani_Mes_No = new String(str);
				} catch (Exception e) {
					errorMsgs.add("送養動物留言編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				StrayaniMessageService strayaniMessageSvc = new StrayaniMessageService();
				StrayaniMessageVO strayaniMessageVO = strayaniMessageSvc.getOneStrayaniMessage(str_Ani_Mes_No);
				if (strayaniMessageVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("strayaniMessageVO", strayaniMessageVO); // 資料庫取出的strayaniVO物件,存入req
				
					String url = "/front-end/strayani_message/listOneStrayaniMessage.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneStrayani.jsp
					successView.forward(req, res);
			
				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/strayani_message/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOneAni_For_DisplayAll".equals(action)	|| "getOne_For_Display_AllMessage_FromlistOneStrayaniView.jsp".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String stray_Ani_Id = req.getParameter("stray_Ani_Id");
				if (stray_Ani_Id == null || (stray_Ani_Id.trim()).length() == 0) {
					errorMsgs.add("請輸入送養動物編號ex.40000001");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				System.out.println("stray_Ani_Id: "+stray_Ani_Id);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				StrayaniMessageService strayaniMessageSvc = new StrayaniMessageService();
				List<StrayaniMessageVO> strayaniMessagelist = strayaniMessageSvc.getOneStrayaniAllMessage(stray_Ani_Id);
				if (strayaniMessagelist == null) {
					errorMsgs.add("查無資料");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("stray_Ani_Id", stray_Ani_Id);
				req.setAttribute("strayaniMessagelist", strayaniMessagelist); // 資料庫取出的strayaniVO物件,存入req
				if("getOneAni_For_DisplayAll".equals(action)){
					String url = "/front-end/strayani_message/listOneStrayaniAllMessage.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneStrayani.jsp
					successView.forward(req, res);
				}else if("getOne_For_Display_AllMessage_FromlistOneStrayaniView.jsp".equals(action)){
					String url = "/front-end/strayani_message/listOneStrayaniAllMessageForView.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneStrayani.jsp
					successView.forward(req, res);
				}
				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/strayani_message/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		
		 if ("insert".equals(action) || "insert_From_listOneStrayaniAllMessageForView.jsp".equals(action)) { // 來自addStrayani.jsp的請求。 insert寫在前面比較好看。
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to send the ErrorPage view.
				
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					String mem_Id = null;
					try {
						System.out.println(req.getParameter("mem_Id"));
						int mem_Id2 = Integer.parseInt(req.getParameter("mem_Id"));
						mem_Id = req.getParameter("mem_Id");	
					} catch (Exception e) {
						errorMsgs.add("請輸入正確會員編號");
					}
					
					String stray_Ani_Id = null;
					try {
						System.out.println(req.getParameter("stray_Ani_Id"));
						int stray_Ani_Id2 = Integer.parseInt(req.getParameter("stray_Ani_Id"));
						stray_Ani_Id = req.getParameter("stray_Ani_Id");	
					} catch (Exception e) {
						errorMsgs.add("請輸入正確送養動物編號");
					}
					
					String str_Ani_Mes = req.getParameter("str_Ani_Mes");
					if (str_Ani_Mes == null || (str_Ani_Mes.trim()).length() == 0) {
						errorMsgs.add("請輸入留言。");
					}
					
					
					
					
					

					StrayaniMessageVO strayaniMessageVO = new StrayaniMessageVO();
						strayaniMessageVO.setMem_Id(mem_Id);
						strayaniMessageVO.setStray_Ani_Id(stray_Ani_Id);
						strayaniMessageVO.setStr_Ani_Mes(str_Ani_Mes);
					
					
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						if("insert".equals(action)){
							req.setAttribute("strayaniMessageVO", strayaniMessageVO); // 含有輸入格式錯誤的empVO物件,也存入req
							RequestDispatcher failureView = req
									.getRequestDispatcher("/front-end/strayani_message/addStrayaniMessage.jsp");
							failureView.forward(req, res);
							return;
						}else if("insert_From_listOneStrayaniAllMessageForView.jsp".equals(action)){
							req.setAttribute("strayaniMessageVO", strayaniMessageVO); // 含有輸入格式錯誤的empVO物件,也存入req
							RequestDispatcher failureView = req
									.getRequestDispatcher("/front-end/strayani_message/listOneStrayaniAllMessageForView.jsp");
							failureView.forward(req, res);
							return;	
						}
					}
					
					/***************************2.開始新增資料***************************************/
					StrayaniMessageService strayaniMessageSvc = new StrayaniMessageService();
					strayaniMessageVO = strayaniMessageSvc.addStrayaniMessage(stray_Ani_Id, mem_Id, str_Ani_Mes);
					//Service的add方法會回傳VO。
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					if("insert".equals(action)){
						String url = "/front-end/strayani_message/listAllStrayaniMessage.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllStrayani.jsp
						successView.forward(req, res);
					}else if("insert_From_listOneStrayaniAllMessageForView.jsp".equals(action)){
						String url = "/front-end/strayani_message/listOneStrayaniAllMessageForView.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllStrayani.jsp
						successView.forward(req, res);	
					}
					
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/addStrayaniMessage.jsp");
					failureView.forward(req, res);
				}
			}

			
			if ("update".equals(action) ) { // 來自update_strayani_input.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				String requestURL = req.getParameter("requestURL");
				
				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String str_Ani_Mes_No = req.getParameter("str_Ani_Mes_No");
					String str_Ani_Mes = req.getParameter("str_Ani_Mes");
					

					StrayaniMessageVO strayaniMessageVO = new StrayaniMessageVO();
						strayaniMessageVO.setStr_Ani_Mes_No(str_Ani_Mes_No);
						strayaniMessageVO.setStr_Ani_Mes(str_Ani_Mes);

						
						// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						
						req.setAttribute("strayaniMessageVO", strayaniMessageVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/strayani_message/update_strayaniMessage_input.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始修改資料*****************************************/
					System.out.println("開始修改資料:"+str_Ani_Mes);
					
					req.setAttribute("strayaniMessageVO", strayaniMessageVO);
					StrayaniMessageService strayaniMessageSvc = new StrayaniMessageService();
					strayaniMessageVO = strayaniMessageSvc.updateStrayaniMessage(str_Ani_Mes_No, str_Ani_Mes);
					
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					System.out.println("修改完成,準備轉交");
					req.setAttribute("strayaniMessageVO", strayaniMessageVO); // 資料庫update成功後,正確的的strayaniMessageVO物件,存入request scope中。
					String url = requestURL;
					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交
					successView.forward(req, res);

					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					System.out.println("修改資料失敗");
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/update_strayaniMessage_input.jsp");
					failureView.forward(req, res);
				}
			}

			if ("getOne_For_Update".equals(action) ) { // 來自listAllStrayani.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				
				String requestURL = req.getParameter("requestURL");
				
				try {
					/***************************1.接收請求參數****************************************/
					String str_Ani_Mes_No = new String(req.getParameter("str_Ani_Mes_No").trim());
					
					/***************************2.開始查詢資料****************************************/
					StrayaniMessageService strayaniMessageSvc = new StrayaniMessageService();
					StrayaniMessageVO strayaniMessageVO = strayaniMessageSvc.getOneStrayaniMessage(str_Ani_Mes_No);
					
				
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					req.setAttribute("strayaniMessageVO", strayaniMessageVO);         // 資料庫取出的strayaniVO物件,存入req
					String url = "/front-end/strayani_message/update_strayaniMessage_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_strayani_input.jsp
					successView.forward(req, res);

					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/listAllStrayaniMessage.jsp");
					failureView.forward(req, res);
				}
			}
		 
			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
		
				try {
					/***************************1.接收請求參數***************************************/
					String str_Ani_Mes_No = req.getParameter("str_Ani_Mes_No");
					
					/***************************2.開始刪除資料***************************************/
					StrayaniMessageService strayaniMessageSvc = new StrayaniMessageService();
					strayaniMessageSvc.deleteStrayaniMessage(str_Ani_Mes_No);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/front-end/strayani_message/listAllStrayaniMessage.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("刪除資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_message/listAllStrayaniMessage.jsp");
					failureView.forward(req, res);
				}
			}		 
	}

}
