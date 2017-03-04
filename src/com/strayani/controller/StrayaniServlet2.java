//package com.strayani.controller;
//
//import java.io.IOException;
//import java.util.LinkedList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.strayani.model.StrayaniVO;
//import com.strayani.model.StrayaniService;
//
//
//
//
//
//public class StrayaniServlet2 extends HttpServlet {
////	private static final long serialVersionUID = 1L;
//       
//
//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//		doPost(req, res);
//	}
//
//	public void doPost(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//
//		req.setCharacterEncoding("UTF-8");
//		String action = req.getParameter("action");
//		System.out.println(action);
//		
//		if ("getOne_For_Display".equals(action)	|| "getOne_For_Display_FromView".equals(action)) { // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				String str = req.getParameter("stray_Ani_Id");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入社區動物編號");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/front-end/strayani/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				String stray_Ani_Id = null;
//				try {
//					stray_Ani_Id = new String(str);
//				} catch (Exception e) {
//					errorMsgs.add("送養動物編號格式不正確");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/front-end/strayani/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************2.開始查詢資料*****************************************/
//				StrayaniService strayaniSvc = new StrayaniService();
//				StrayaniVO strayaniVO = strayaniSvc.getOneStrayani(stray_Ani_Id);
//				if (strayaniVO == null) {
//					errorMsgs.add("查無資料");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/front-end/strayani/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("strayaniVO", strayaniVO); // 資料庫取出的strayaniVO物件,存入req
//				if("getOne_For_Display".equals(action)){
//					System.out.println("StrayaniServlet>>getOne_For_Display>>查詢完成,準備轉交");
//					String url = "/front-end/strayani/listOneStrayaniView.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneStrayani.jsp
//					successView.forward(req, res);
//				}else if("getOne_For_Display_FromView".equals(action)){
//					String url = "/front-end/strayani/listOneStrayani.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneStrayani.jsp
//					successView.forward(req, res);
//				}
//				/***************************其他可能的錯誤處理*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得資料:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/front-end/strayani/select_page.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		
//		
//		 if ("insert".equals(action)) { // 來自addStrayani.jsp的請求。 insert寫在前面比較好看。
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				// Store this set in the request scope, in case we need to send the ErrorPage view.
//				
//				req.setAttribute("errorMsgs", errorMsgs);
//				
//				try {
//					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//					String Mem_Id = req.getParameter("Mem_Id");
//					String Stray_Ani_name = req.getParameter("Stray_Ani_name");
//					String Stray_Ani_type = req.getParameter("Stray_Ani_type");
//					String Stray_Ani_gender = req.getParameter("Stray_Ani_gender");
//					String Stray_Ani_heal = req.getParameter("Stray_Ani_heal");
//					String Stray_Ani_Vac = req.getParameter("Stray_Ani_Vac");
//					String Stray_Ani_color = req.getParameter("Stray_Ani_color");
//					String Stray_Ani_body = req.getParameter("Stray_Ani_body");
//					String Stray_Ani_age = req.getParameter("Stray_Ani_age");
//					String Stray_Ani_Neu = req.getParameter("Stray_Ani_Neu");
//					String Stray_Ani_chip = req.getParameter("Stray_Ani_chip");
////					String Stray_Ani_date = req.getParameter("Stray_Ani_date");
//					String Stray_Ani_status = req.getParameter("Stray_Ani_status");
////					String Stray_Ani_CreDate = req.getParameter("Stray_Ani_CreDate");
////					String Stray_Ani_FinLat = req.getParameter("Stray_Ani_FinLat");
////					String Stray_Ani_FinLon = req.getParameter("Stray_Ani_FinLon");
//					String Stray_Ani_city = req.getParameter("Stray_Ani_city");
//					String Stray_Ani_town = req.getParameter("Stray_Ani_town");
//					String Stray_Ani_road = req.getParameter("Stray_Ani_road");
//					
////					Integer Stray_Ani_like = null;
////					try {
////						Stray_Ani_like = Integer.parseInt(req.getParameter("Stray_Ani_like"));
////					} catch (Exception e) {
////						errorMsgs.add("like數請輸入數字");
////					}
//					
//					
//					
//					java.sql.Timestamp Stray_Ani_date = null;
//					try {
//						String Stray_Ani_date_from_jsp = req.getParameter("Stray_Ani_date").trim();
//						Stray_Ani_date = java.sql.Timestamp.valueOf(Stray_Ani_date_from_jsp);
//					} catch (Exception e) {
//						Stray_Ani_date=new java.sql.Timestamp(System.currentTimeMillis());
//						errorMsgs.add("請輸入日期!");
//					}
//					Double Stray_Ani_FinLat = null;
//					try {
//						
//						Stray_Ani_FinLat = new Double(req.getParameter("Stray_Ani_FinLat").trim());
//					} catch (NumberFormatException e) {
//						Stray_Ani_FinLat = 0.0;
//						errorMsgs.add("請填寫Google map 經度 xxx.xxxxxx");
//					}
//					Double Stray_Ani_FinLon = null;
//					try {
//						Stray_Ani_FinLon = new Double(req.getParameter("Stray_Ani_FinLon").trim());
//					} catch (NumberFormatException e) {
//						Stray_Ani_FinLon = 0.0;
//						errorMsgs.add("請填寫Google map 緯度 xxx.xxxxxx");
//					}
//					
//
//					StrayaniVO strayaniVO = new StrayaniVO();
//						strayaniVO.setMem_Id(Mem_Id);
//						strayaniVO.setStray_Ani_name(Stray_Ani_name);
//						strayaniVO.setStray_Ani_type(Stray_Ani_type);
//						strayaniVO.setStray_Ani_gender(Stray_Ani_gender);
//						strayaniVO.setStray_Ani_heal(Stray_Ani_heal);
//						strayaniVO.setStray_Ani_Vac(Stray_Ani_Vac);
//						strayaniVO.setStray_Ani_color(Stray_Ani_color);
//						strayaniVO.setStray_Ani_body(Stray_Ani_body);
//						strayaniVO.setStray_Ani_age(Stray_Ani_age);
//						strayaniVO.setStray_Ani_Neu(Stray_Ani_Neu);
//						strayaniVO.setStray_Ani_chip(Stray_Ani_chip);
//						strayaniVO.setStray_Ani_date(Stray_Ani_date);
//						strayaniVO.setStray_Ani_status(Stray_Ani_status);
//						strayaniVO.setStray_Ani_FinLat(Stray_Ani_FinLat);
//						strayaniVO.setStray_Ani_FinLon(Stray_Ani_FinLon);
//						strayaniVO.setStray_Ani_city(Stray_Ani_city);
//						strayaniVO.setStray_Ani_town(Stray_Ani_town);
//						strayaniVO.setStray_Ani_road(Stray_Ani_road);
////						strayaniVO.setStray_Ani_like(Stray_Ani_like);
//					// Send the use back to the form, if there were errors
//					if (!errorMsgs.isEmpty()) {
//						req.setAttribute("strayaniVO", strayaniVO); // 含有輸入格式錯誤的empVO物件,也存入req
//						RequestDispatcher failureView = req
//								.getRequestDispatcher("/front-end/strayani/addStrayani.jsp");
//						failureView.forward(req, res);
//						return;
//					}
//					
//					/***************************2.開始新增資料***************************************/
//					StrayaniService strayaniSvc = new StrayaniService();
//					strayaniVO = strayaniSvc.addStrayani(Mem_Id, Stray_Ani_name, Stray_Ani_type, Stray_Ani_gender, Stray_Ani_heal, Stray_Ani_Vac, Stray_Ani_color, Stray_Ani_body, Stray_Ani_age, Stray_Ani_Neu, Stray_Ani_chip, Stray_Ani_date, Stray_Ani_status, Stray_Ani_date,Stray_Ani_FinLat, Stray_Ani_FinLon, Stray_Ani_city, Stray_Ani_town, Stray_Ani_road );
//					//物件建立時間(Stray_Ani_Credate)的參數，暫時先用Stray_Ani_date代替，其實用不到，因為sql是用sysdate建。
//					
//					/***************************3.新增完成,準備轉交(Send the Success view)***********/
//					String url = "/front-end/strayani/listAllStrayani.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllStrayani.jsp
//					successView.forward(req, res);				
//					
//					/***************************其他可能的錯誤處理**********************************/
//				} catch (Exception e) {
//					
//					errorMsgs.add(e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/front-end/strayani/addStrayani.jsp");
//					failureView.forward(req, res);
//				}
//			}
//
//			
//			if ("update".equals(action) ) { // 來自update_strayani_input.jsp的請求
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				// Store this set in the request scope, in case we need to
//				// send the ErrorPage view.
//				req.setAttribute("errorMsgs", errorMsgs);
//				String requestURL = req.getParameter("requestURL");
//				try {
//					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//					String stray_Ani_Id = req.getParameter("stray_Ani_Id");
//					String Mem_Id = req.getParameter("Mem_Id");
//					String Stray_Ani_name = req.getParameter("Stray_Ani_name");
//					String Stray_Ani_type = req.getParameter("Stray_Ani_type");
//					String Stray_Ani_gender = req.getParameter("Stray_Ani_gender");
//					String Stray_Ani_heal = req.getParameter("Stray_Ani_heal");
//					String Stray_Ani_Vac = req.getParameter("Stray_Ani_Vac");
//					String Stray_Ani_color = req.getParameter("Stray_Ani_color");
//					String Stray_Ani_body = req.getParameter("Stray_Ani_body");
//					String Stray_Ani_age = req.getParameter("Stray_Ani_age");
//					String Stray_Ani_Neu = req.getParameter("Stray_Ani_Neu");
//					String Stray_Ani_chip = req.getParameter("Stray_Ani_chip");
////					String Stray_Ani_date = req.getParameter("Stray_Ani_date");
//					String Stray_Ani_status = req.getParameter("Stray_Ani_status");
////					String Stray_Ani_CreDate = req.getParameter("Stray_Ani_CreDate");
////					String Stray_Ani_FinLat = req.getParameter("Stray_Ani_FinLat");
////					String Stray_Ani_FinLon = req.getParameter("Stray_Ani_FinLon");
//					String Stray_Ani_city = req.getParameter("Stray_Ani_city");
//					String Stray_Ani_town = req.getParameter("Stray_Ani_town");
//					String Stray_Ani_road = req.getParameter("Stray_Ani_road");
//					
//					Integer Stray_Ani_like = null;
//					try {
//						Stray_Ani_like = Integer.parseInt(req.getParameter("Stray_Ani_like"));
//					} catch (Exception e) {
//						errorMsgs.add("like數請輸入數字");
//					}
//					
//					
//					
//					
//					java.sql.Timestamp Stray_Ani_date = null;
//					try {
//						
//						Stray_Ani_date = java.sql.Timestamp.valueOf(req.getParameter("Stray_Ani_date").trim());
//					} catch (Exception e) {
//						Stray_Ani_date=new java.sql.Timestamp(System.currentTimeMillis());
//						errorMsgs.add("請輸入日期!");
//					}
//					Double Stray_Ani_FinLat = null;
//					try {
//						
//						Stray_Ani_FinLat = new Double(req.getParameter("Stray_Ani_FinLat").trim());
//					} catch (NumberFormatException e) {
//						Stray_Ani_FinLat = 0.0;
//						errorMsgs.add("請填寫Google map 經度 xxx.xxxxxx");
//					}
//					System.out.println("here is \"update\" in Controller (3)");
//					Double Stray_Ani_FinLon = null;
//					try {
//						Stray_Ani_FinLon = new Double(req.getParameter("Stray_Ani_FinLon").trim());
//					} catch (NumberFormatException e) {
//						Stray_Ani_FinLon = 0.0;
//						errorMsgs.add("請填寫Google map 經度 xxx.xxxxxx");
//					}
//					
//					
//
//					StrayaniVO strayaniVO = new StrayaniVO();
//						strayaniVO.setStray_Ani_Id(stray_Ani_Id);
//						strayaniVO.setMem_Id(Mem_Id);
//						strayaniVO.setStray_Ani_name(Stray_Ani_name);
//						strayaniVO.setStray_Ani_type(Stray_Ani_type);
//						strayaniVO.setStray_Ani_gender(Stray_Ani_gender);
//						strayaniVO.setStray_Ani_heal(Stray_Ani_heal);
//						strayaniVO.setStray_Ani_Vac(Stray_Ani_Vac);
//						strayaniVO.setStray_Ani_color(Stray_Ani_color);
//						strayaniVO.setStray_Ani_body(Stray_Ani_body);
//						strayaniVO.setStray_Ani_age(Stray_Ani_age);
//						strayaniVO.setStray_Ani_Neu(Stray_Ani_Neu);
//						strayaniVO.setStray_Ani_chip(Stray_Ani_chip);
//						strayaniVO.setStray_Ani_date(Stray_Ani_date);
//						strayaniVO.setStray_Ani_status(Stray_Ani_status);
//						strayaniVO.setStray_Ani_FinLat(Stray_Ani_FinLat);
//						strayaniVO.setStray_Ani_FinLon(Stray_Ani_FinLon);
//						strayaniVO.setStray_Ani_city(Stray_Ani_city);
//						strayaniVO.setStray_Ani_town(Stray_Ani_town);
//						strayaniVO.setStray_Ani_road(Stray_Ani_road);
//						strayaniVO.setStray_Ani_like(Stray_Ani_like);
//						
//					// Send the use back to the form, if there were errors
//					if (!errorMsgs.isEmpty()) {
//						
//						req.setAttribute("strayaniVO", strayaniVO); // 含有輸入格式錯誤的empVO物件,也存入req
//						RequestDispatcher failureView = req
//								.getRequestDispatcher("/front-end/strayani/update_strayani_input.jsp");
//						failureView.forward(req, res);
//						return;
//					}
//					
//					/***************************2.開始修改資料*****************************************/
//					req.setAttribute("strayaniVO", strayaniVO);
//					StrayaniService strayaniSvc = new StrayaniService();
//					strayaniVO = strayaniSvc.updateStrayani(stray_Ani_Id ,Mem_Id, Stray_Ani_name, Stray_Ani_type, Stray_Ani_gender, Stray_Ani_heal, Stray_Ani_Vac, Stray_Ani_color, Stray_Ani_body, Stray_Ani_age, Stray_Ani_Neu, Stray_Ani_chip, Stray_Ani_date, Stray_Ani_status, Stray_Ani_date,Stray_Ani_FinLat, Stray_Ani_FinLon, Stray_Ani_city, Stray_Ani_town, Stray_Ani_road,Stray_Ani_like);
//					
//					/***************************3.修改完成,準備轉交(Send the Success view)*************/
//					req.setAttribute("strayaniVO", strayaniVO); // 資料庫update成功後,正確的的empVO物件,存入req
//					String url = requestURL;
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//					successView.forward(req, res);
//
//					/***************************其他可能的錯誤處理*************************************/
//				} catch (Exception e) {
//					errorMsgs.add("修改資料失敗:"+e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/front-end/strayani/update_strayani_input.jsp");
//					failureView.forward(req, res);
//				}
//			}
//
//			if ("getOne_For_Update".equals(action) ) { // 來自listAllStrayani.jsp的請求
//
//				List<String> errorMsgs = new LinkedList<String>();
//				// Store this set in the request scope, in case we need to
//				// send the ErrorPage view.
//				req.setAttribute("errorMsgs", errorMsgs);
//				
//				String requestURL = req.getParameter("requestURL");
//				
//				try {
//					/***************************1.接收請求參數****************************************/
//					String stray_Ani_Id = new String(req.getParameter("stray_Ani_Id").trim());
//					
//					/***************************2.開始查詢資料****************************************/
//					StrayaniService strayaniSvc = new StrayaniService();
//					StrayaniVO strayaniVO = strayaniSvc.getOneStrayani(stray_Ani_Id);
//					
//				
//					/***************************3.查詢完成,準備轉交(Send the Success view)************/
//					req.setAttribute("strayaniVO", strayaniVO);         // 資料庫取出的strayaniVO物件,存入req
//					String url = "/front-end/strayani/update_strayani_input.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_strayani_input.jsp
//					successView.forward(req, res);
//
//					/***************************其他可能的錯誤處理**********************************/
//				} catch (Exception e) {
//					errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/front-end/strayani/listAllStrayani.jsp");
//					failureView.forward(req, res);
//				}
//			}
//		 
//			if ("delete".equals(action)) { // 來自listAllEmp.jsp
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				// Store this set in the request scope, in case we need to
//				// send the ErrorPage view.
//				req.setAttribute("errorMsgs", errorMsgs);
//		
//				try {
//					/***************************1.接收請求參數***************************************/
//					String str = req.getParameter("stray_Ani_Id");
//					System.out.println("stray_Ani_Id:"+ str);
//					/***************************2.開始刪除資料***************************************/
//					StrayaniService strayaniSvc = new StrayaniService();
//					strayaniSvc.deleteStrayani(str);
//					
//					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//					String url = "/front-end/strayani/listAllStrayani.jsp";
//					System.out.println("刪除完成");
//					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//					successView.forward(req, res);
//					
//					/***************************其他可能的錯誤處理**********************************/
//				} catch (Exception e) {
//					errorMsgs.add("刪除資料失敗:"+e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/front-end/strayani/listAllStrayani.jsp");
//					failureView.forward(req, res);
//				}
//			}		 
//	}
//
//}
