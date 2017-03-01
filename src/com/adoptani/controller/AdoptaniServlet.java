package com.adoptani.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adoptani.model.AdoptaniService;
import com.adoptani.model.AdoptaniVO;




public class AdoptaniServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("action:"+action);
		
		if ("getOne_For_Display".equals(action)	|| "getOne_For_Display_FromView".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("adopt_Ani_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入送養動物編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				String adopt_Ani_Id = null;
				try {
					adopt_Ani_Id = new String(str);
				} catch (Exception e) {
					errorMsgs.add("送養動物編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				AdoptaniService adoptaniSvc = new AdoptaniService();
				AdoptaniVO adoptaniVO = adoptaniSvc.getOneAdoptani(adopt_Ani_Id);
				if (adoptaniVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adoptaniVO", adoptaniVO); // 資料庫取出的adoptaniVO物件,存入req
				if("getOne_For_Display".equals(action)){
					System.out.println("AdoptaniServlet>>getOne_For_Display>>查詢完成,準備轉交");
					String url = "/front-end/adoptani/listOneAdoptaniView.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAdoptani.jsp
					successView.forward(req, res);
				}else if("getOne_For_Display_FromView".equals(action)){
					String url = "/front-end/adoptani/listOneAdoptani.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAdoptani.jsp
					successView.forward(req, res);
				}
				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/adoptani/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		
		 if ("insert".equals(action) || "insert_fromMap".equals(action)) { // 來自addAdoptani.jsp的請求。 insert寫在前面比較好看。
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to send the ErrorPage view.
				
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					String Mem_Id = req.getParameter("Mem_Id");
					String Adopt_Ani_name = req.getParameter("Adopt_Ani_name");
//					String Adopt_Ani_type = req.getParameter("Adopt_Ani_type");
					String Adopt_Ani_gender = req.getParameter("Adopt_Ani_gender");
					String Adopt_Ani_heal = req.getParameter("Adopt_Ani_heal");
					String Adopt_Ani_Vac = req.getParameter("Adopt_Ani_Vac");
					String Adopt_Ani_color = req.getParameter("Adopt_Ani_color");
					String Adopt_Ani_body = req.getParameter("Adopt_Ani_body");
					String Adopt_Ani_age = req.getParameter("Adopt_Ani_age");
					String Adopt_Ani_Neu = req.getParameter("Adopt_Ani_Neu");
					String Adopt_Ani_chip = req.getParameter("Adopt_Ani_chip");
//					String Adopt_Ani_date = req.getParameter("Adopt_Ani_date");
					String Adopt_Ani_status = req.getParameter("Adopt_Ani_status");
//					String Adopt_Ani_CreDate = req.getParameter("Adopt_Ani_CreDate");
//					String Adopt_Ani_FinLat = req.getParameter("Adopt_Ani_FinLat");
//					String Adopt_Ani_FinLon = req.getParameter("Adopt_Ani_FinLon");
					String Adopt_Ani_city = req.getParameter("Adopt_Ani_city");
					String Adopt_Ani_town = req.getParameter("Adopt_Ani_town");
					String Adopt_Ani_road = req.getParameter("Adopt_Ani_road");
					
//					Integer Adopt_Ani_like = null;
//					try {
//						Adopt_Ani_like = Integer.parseInt(req.getParameter("Adopt_Ani_like"));
//					} catch (Exception e) {
//						errorMsgs.add("like數請輸入數字");
//					}
					
					
					String Adopt_Ani_type = req.getParameter("Adopt_Ani_type");
					if (Adopt_Ani_type == null || (Adopt_Ani_type.trim()).length() == 0) {
						errorMsgs.add("請輸入送養動物類型");
					}
					
					
					java.sql.Timestamp Adopt_Ani_date = null;
					try {
						String Adopt_Ani_date_from_jsp = req.getParameter("Adopt_Ani_date").trim();
						Adopt_Ani_date = java.sql.Timestamp.valueOf(Adopt_Ani_date_from_jsp);
					} catch (Exception e) {
						Adopt_Ani_date=new java.sql.Timestamp(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
					}
					Double Adopt_Ani_FinLat = null;
					try {
						
						Adopt_Ani_FinLat = new Double(req.getParameter("Adopt_Ani_FinLat").trim());
					} catch (NumberFormatException e) {
						Adopt_Ani_FinLat = 0.0;
						errorMsgs.add("請填寫Google map 經度 xxx.xxxxxx");
					}
					Double Adopt_Ani_FinLon = null;
					try {
						Adopt_Ani_FinLon = new Double(req.getParameter("Adopt_Ani_FinLon").trim());
					} catch (NumberFormatException e) {
						Adopt_Ani_FinLon = 0.0;
						errorMsgs.add("請填寫Google map 緯度 xxx.xxxxxx");
					}
					

					AdoptaniVO adoptaniVO = new AdoptaniVO();
						adoptaniVO.setMem_Id(Mem_Id);
						adoptaniVO.setAdopt_Ani_name(Adopt_Ani_name);
						adoptaniVO.setAdopt_Ani_type(Adopt_Ani_type);
						adoptaniVO.setAdopt_Ani_gender(Adopt_Ani_gender);
						adoptaniVO.setAdopt_Ani_heal(Adopt_Ani_heal);
						adoptaniVO.setAdopt_Ani_Vac(Adopt_Ani_Vac);
						adoptaniVO.setAdopt_Ani_color(Adopt_Ani_color);
						adoptaniVO.setAdopt_Ani_body(Adopt_Ani_body);
						adoptaniVO.setAdopt_Ani_age(Adopt_Ani_age);
						adoptaniVO.setAdopt_Ani_Neu(Adopt_Ani_Neu);
						adoptaniVO.setAdopt_Ani_chip(Adopt_Ani_chip);
						adoptaniVO.setAdopt_Ani_date(Adopt_Ani_date);
						adoptaniVO.setAdopt_Ani_status(Adopt_Ani_status);
						adoptaniVO.setAdopt_Ani_FinLat(Adopt_Ani_FinLat);
						adoptaniVO.setAdopt_Ani_FinLon(Adopt_Ani_FinLon);
						adoptaniVO.setAdopt_Ani_city(Adopt_Ani_city);
						adoptaniVO.setAdopt_Ani_town(Adopt_Ani_town);
						adoptaniVO.setAdopt_Ani_road(Adopt_Ani_road);
//						adoptaniVO.setAdopt_Ani_like(Adopt_Ani_like);
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("adoptaniVO", adoptaniVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/adoptani/addAdoptani.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始新增資料***************************************/
					AdoptaniService adoptaniSvc = new AdoptaniService();
					adoptaniVO = adoptaniSvc.addAdoptani(Mem_Id, Adopt_Ani_name, Adopt_Ani_type, Adopt_Ani_gender, Adopt_Ani_heal, Adopt_Ani_Vac, Adopt_Ani_color, Adopt_Ani_body, Adopt_Ani_age, Adopt_Ani_Neu, Adopt_Ani_chip, Adopt_Ani_date, Adopt_Ani_status, Adopt_Ani_date,Adopt_Ani_FinLat, Adopt_Ani_FinLon, Adopt_Ani_city, Adopt_Ani_town, Adopt_Ani_road );
					//物件建立時間(Adopt_Ani_Credate)的參數，暫時先用Adopt_Ani_date代替，其實用不到，因為sql是用sysdate建。
					String ID = adoptaniVO.getAdopt_Ani_Id();
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					if("insert".equals(action)){
						String url = "/front-end/adoptani/listAllAdoptani.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdoptani.jsp
						successView.forward(req, res);	
					}else if("insert_fromMap".equals(action)){
						String url = "/front-end/adoptani/adoptani.do?action=getOne_For_Display&adopt_Ani_Id="+ID;
						RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdoptani.jsp
						successView.forward(req, res);
						
					}
		
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani/addAdoptani.jsp");
					failureView.forward(req, res);
				}
			}

			
			if ("update".equals(action) || "update_formView".equals(action)) { // 來自update_adoptani_input.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				String requestURL = req.getParameter("requestURL");
				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String adopt_Ani_Id = req.getParameter("adopt_Ani_Id");
					String Mem_Id = req.getParameter("mem_Id");
					String Adopt_Ani_name = req.getParameter("Adopt_Ani_name");
					String Adopt_Ani_type = req.getParameter("Adopt_Ani_type");
					String Adopt_Ani_gender = req.getParameter("Adopt_Ani_gender");
					String Adopt_Ani_heal = req.getParameter("Adopt_Ani_heal");
					String Adopt_Ani_Vac = req.getParameter("Adopt_Ani_Vac");
					String Adopt_Ani_color = req.getParameter("Adopt_Ani_color");
					String Adopt_Ani_body = req.getParameter("Adopt_Ani_body");
					String Adopt_Ani_age = req.getParameter("Adopt_Ani_age");
					String Adopt_Ani_Neu = req.getParameter("Adopt_Ani_Neu");
					String Adopt_Ani_chip = req.getParameter("Adopt_Ani_chip");
//					String Adopt_Ani_date = req.getParameter("Adopt_Ani_date");
					String Adopt_Ani_status = req.getParameter("Adopt_Ani_status");
//					String Adopt_Ani_CreDate = req.getParameter("Adopt_Ani_CreDate");
//					String Adopt_Ani_FinLat = req.getParameter("Adopt_Ani_FinLat");
//					String Adopt_Ani_FinLon = req.getParameter("Adopt_Ani_FinLon");
					String Adopt_Ani_city = req.getParameter("Adopt_Ani_city");
					String Adopt_Ani_town = req.getParameter("Adopt_Ani_town");
					String Adopt_Ani_road = req.getParameter("Adopt_Ani_road");
					
//					Integer Adopt_Ani_like = null;
//					try {
//						Adopt_Ani_like = Integer.parseInt(req.getParameter("Adopt_Ani_like"));
//					} catch (Exception e) {
//						errorMsgs.add("like數請輸入數字");
//					}
					
					
					
					java.sql.Timestamp Adopt_Ani_date = null;
					try {
						
						Adopt_Ani_date = java.sql.Timestamp.valueOf(req.getParameter("Adopt_Ani_date").trim());
					} catch (Exception e) {
						Adopt_Ani_date=new java.sql.Timestamp(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
					}
					Double Adopt_Ani_FinLat = null;
					try {
						
						Adopt_Ani_FinLat = new Double(req.getParameter("Adopt_Ani_FinLat").trim());
					} catch (NumberFormatException e) {
						Adopt_Ani_FinLat = 0.0;
						errorMsgs.add("請填寫Google map 經度 xxx.xxxxxx");
					}
					System.out.println("here is \"update\" in Controller (3)");
					Double Adopt_Ani_FinLon = null;
					try {
						Adopt_Ani_FinLon = new Double(req.getParameter("Adopt_Ani_FinLon").trim());
					} catch (NumberFormatException e) {
						Adopt_Ani_FinLon = 0.0;
						errorMsgs.add("請填寫Google map 經度 xxx.xxxxxx");
					}
					
					
					AdoptaniVO adoptaniVO = new AdoptaniVO();
						adoptaniVO.setAdopt_Ani_Id(adopt_Ani_Id);
						adoptaniVO.setMem_Id(Mem_Id);
						adoptaniVO.setAdopt_Ani_name(Adopt_Ani_name);
						adoptaniVO.setAdopt_Ani_type(Adopt_Ani_type);
						adoptaniVO.setAdopt_Ani_gender(Adopt_Ani_gender);
						adoptaniVO.setAdopt_Ani_heal(Adopt_Ani_heal);
						adoptaniVO.setAdopt_Ani_Vac(Adopt_Ani_Vac);
						adoptaniVO.setAdopt_Ani_color(Adopt_Ani_color);
						adoptaniVO.setAdopt_Ani_body(Adopt_Ani_body);
						adoptaniVO.setAdopt_Ani_age(Adopt_Ani_age);
						adoptaniVO.setAdopt_Ani_Neu(Adopt_Ani_Neu);
						adoptaniVO.setAdopt_Ani_chip(Adopt_Ani_chip);
						adoptaniVO.setAdopt_Ani_date(Adopt_Ani_date);
						adoptaniVO.setAdopt_Ani_status(Adopt_Ani_status);
						adoptaniVO.setAdopt_Ani_FinLat(Adopt_Ani_FinLat);
						adoptaniVO.setAdopt_Ani_FinLon(Adopt_Ani_FinLon);
						adoptaniVO.setAdopt_Ani_city(Adopt_Ani_city);
						adoptaniVO.setAdopt_Ani_town(Adopt_Ani_town);
						adoptaniVO.setAdopt_Ani_road(Adopt_Ani_road);
//						adoptaniVO.setAdopt_Ani_like(Adopt_Ani_like);
						
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("adoptaniVO", adoptaniVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/adoptani/update_adoptani_input.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始修改資料*****************************************/
					req.setAttribute("adoptaniVO", adoptaniVO);
					AdoptaniService adoptaniSvc = new AdoptaniService();
					adoptaniVO = adoptaniSvc.updateAdoptani(adopt_Ani_Id ,Mem_Id, Adopt_Ani_name, Adopt_Ani_type, Adopt_Ani_gender, Adopt_Ani_heal, Adopt_Ani_Vac, Adopt_Ani_color, Adopt_Ani_body, Adopt_Ani_age, Adopt_Ani_Neu, Adopt_Ani_chip, Adopt_Ani_date, Adopt_Ani_status, Adopt_Ani_date,Adopt_Ani_FinLat, Adopt_Ani_FinLon, Adopt_Ani_city, Adopt_Ani_town, Adopt_Ani_road);
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					req.setAttribute("adoptaniVO", adoptaniVO); // 資料庫update成功後,正確的的empVO物件,存入req
					if("update".equals(action)){
						String url = requestURL;
						RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
						successView.forward(req, res);}
					if("update_formView".equals(action)){
						String url = requestURL;
						RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
						successView.forward(req, res);	
					}

					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani/update_adoptani_input.jsp");
					failureView.forward(req, res);
				}
			}

			if ("getOne_For_Update".equals(action) ) { // 來自listAllAdoptani.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				
				String requestURL = req.getParameter("requestURL");
				
				try {
					/***************************1.接收請求參數****************************************/
					String adopt_Ani_Id = new String(req.getParameter("adopt_Ani_Id").trim());
					
					/***************************2.開始查詢資料****************************************/
					AdoptaniService adoptaniSvc = new AdoptaniService();
					AdoptaniVO adoptaniVO = adoptaniSvc.getOneAdoptani(adopt_Ani_Id);
					
				
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					req.setAttribute("adoptaniVO", adoptaniVO);         // 資料庫取出的adoptaniVO物件,存入req
					String url = "/front-end/adoptani/update_adoptani_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_adoptani_input.jsp
					successView.forward(req, res);

					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani/listAllAdoptani.jsp");
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
					String str = req.getParameter("adopt_Ani_Id");
					System.out.println("adopt_Ani_Id:"+ str);
					/***************************2.開始刪除資料***************************************/
					AdoptaniService adoptaniSvc = new AdoptaniService();
					adoptaniSvc.deleteAdoptani(str);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/front-end/adoptani/listAllAdoptani.jsp";
					System.out.println("刪除完成");
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("刪除資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani/listAllAdoptani.jsp");
					failureView.forward(req, res);
				}
			}
			if ("changeLike".equals(action)) {
				String likeOrNot = req.getParameter("likeOrNot");
				String adopt_Ani_Id = req.getParameter("adopt_Ani_Id");
				System.out.println(likeOrNot+"+"+adopt_Ani_Id);
				AdoptaniService adoptaniSvc = new AdoptaniService();
				adoptaniSvc.changeLike(adopt_Ani_Id, likeOrNot);
			}
	}

}
