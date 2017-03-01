package com.adoptani_sponsor.controller;

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

import com.adoptani_sponsor.model.AdoptaniSponsorService;
import com.adoptani_sponsor.model.AdoptaniSponsorVO;






public class AdoptaniSponsorServlet extends HttpServlet {
       

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		System.out.println("Sponsor(C) action: "+action);
		
		if ("getOne_For_Display".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				
		//編號空值例外。
				String str = req.getParameter("ado_Ani_Spo_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入送養動物留言編號ex.42000001");
				}
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
		//編號非數字例外。	
				String ado_Ani_Spo_No = null;
				try {
					ado_Ani_Spo_No = new String(str);
				} catch (Exception e) {
					errorMsgs.add("送養動物贊助編號格式不正確");
				}
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始查詢資料*****************************************/
				AdoptaniSponsorService adoptaniSponsorgeSvc = new AdoptaniSponsorService();
				AdoptaniSponsorVO adoptaniSponsorVO = adoptaniSponsorgeSvc.getOneAdoptaniSponsor(ado_Ani_Spo_No);
				if (adoptaniSponsorVO == null) {
					errorMsgs.add("查無資料");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adoptaniSponsorVO", adoptaniSponsorVO); // 資料庫取出的adoptaniVO物件,存入req
				
					String url = "/front-end/adoptani_sponsor/listOneAdoptaniSponsor.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAdoptani.jsp
					successView.forward(req, res);
			
				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/adoptani_sponsor/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOneAni_For_DisplayAll".equals(action)	|| "getOne_For_Display_AllMessage_FromlistOneAdoptaniView.jsp".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String adopt_Ani_Id = req.getParameter("adopt_Ani_Id");
				if (adopt_Ani_Id == null || (adopt_Ani_Id.trim()).length() == 0) {
					errorMsgs.add("請輸入送養動物編號ex.40000001");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				System.out.println("adopt_Ani_Id: "+adopt_Ani_Id);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				AdoptaniSponsorService adoptaniSponsorgeSvc = new AdoptaniSponsorService();
				List<AdoptaniSponsorVO> adoptaniSponsorlist = adoptaniSponsorgeSvc.getOneAdoptaniAllSponsor(adopt_Ani_Id);
				Integer totalSponsorMoney =  adoptaniSponsorgeSvc.getOneAllMoney(adopt_Ani_Id);
				
				if (adoptaniSponsorlist == null) {
					errorMsgs.add("查無資料");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adopt_Ani_Id", adopt_Ani_Id);
				req.setAttribute("totalSponsorMoney", totalSponsorMoney);
				req.setAttribute("adoptaniSponsorlist", adoptaniSponsorlist); // 資料庫取出的adoptaniVO物件,存入req
				if("getOneAni_For_DisplayAll".equals(action)){
					String url = "/front-end/adoptani_sponsor/listOneAdoptaniAllSponsor.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAdoptani.jsp
					successView.forward(req, res);
				}else if("getOne_For_Display_AllMessage_FromlistOneAdoptaniView.jsp".equals(action)){
					String url = "/front-end/adoptani_sponsor/listOneAdoptaniAllSponsorForView.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAdoptani.jsp
					successView.forward(req, res);
				}
				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/adoptani_sponsor/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		
		 if ("insert".equals(action) || "insert_From_listOneAdoptaniAllSponsorForView.jsp".equals(action)) { // 來自addAdoptani.jsp的請求。 insert寫在前面比較好看。
			 System.out.println("AAAAAAAAA");
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to send the ErrorPage view.
				
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					String adopt_Ani_Id = null;
					
					try {
						System.out.println(req.getParameter("adopt_Ani_Id"));
						int adopt_Ani_Id2 = Integer.parseInt(req.getParameter("adopt_Ani_Id"));
						adopt_Ani_Id = req.getParameter("adopt_Ani_Id");	
					} catch (Exception e) {
						errorMsgs.add("請輸入正確送養動物編號");
					}
					
					
					String mem_Id = null;
					try {
						System.out.println(req.getParameter("mem_Id"));
						int mem_Id2 = Integer.parseInt(req.getParameter("mem_Id"));
						mem_Id = req.getParameter("mem_Id");	
					} catch (Exception e) {
						errorMsgs.add("請輸入正確會員編號");
					}
					

					
					String ado_Ani_Spo_thing = req.getParameter("ado_Ani_Spo_thing");
					if (ado_Ani_Spo_thing == null || (ado_Ani_Spo_thing.trim()).length() == 0) {
						ado_Ani_Spo_thing = "無";
					}
					
					
					String ado_Ani_Spo_money_str = req.getParameter("ado_Ani_Spo_money");
					
					if (ado_Ani_Spo_money_str == null || (ado_Ani_Spo_money_str.trim()).length() == 0) {
						ado_Ani_Spo_money_str = "0";
					}
					Integer ado_Ani_Spo_money2 = null;
					try {
						ado_Ani_Spo_money2 = Integer.parseInt(ado_Ani_Spo_money_str);
					} catch (Exception e) {
						errorMsgs.add("請輸入正確贊助金額(數字)");
					}
					
					if("無".equals(ado_Ani_Spo_thing) && ado_Ani_Spo_money2==0){
						errorMsgs.add("尚未贊助任何物資~");
						
					}
					
					
					
					
					

					AdoptaniSponsorVO adoptaniSponsorVO = new AdoptaniSponsorVO();
						adoptaniSponsorVO.setAdopt_Ani_Id(adopt_Ani_Id);
						adoptaniSponsorVO.setMem_Id(mem_Id);
						adoptaniSponsorVO.setAdo_Ani_Spo_thing(ado_Ani_Spo_thing) ;
						adoptaniSponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money2) ;
					
					
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("adoptaniSponsorVO", adoptaniSponsorVO); 
						if("insert".equals(action)){
							System.out.println("B");
							String url = "/front-end/adoptani_sponsor/addAdoptaniSponsor.jsp";
							RequestDispatcher successView = req.getRequestDispatcher(url); 
							successView.forward(req, res);
							return;//沒有return會劈腿。
						}else if("insert_From_listOneAdoptaniAllSponsorForView.jsp".equals(action)){
							System.out.println("C");
							String url = "/front-end/adoptani_sponsor/listOneAdoptaniAllSponsorForView.jsp";
							RequestDispatcher successView = req.getRequestDispatcher(url); 
							successView.forward(req, res);
							return;//沒有return會劈腿。
						}
					}
					
					/***************************2.開始新增資料***************************************/
					AdoptaniSponsorService adoptaniSponsorgeSvc = new AdoptaniSponsorService();
					adoptaniSponsorVO = adoptaniSponsorgeSvc.addAdoptaniSponsor(adopt_Ani_Id, mem_Id, ado_Ani_Spo_money2, ado_Ani_Spo_thing);
					//Service的add方法會回傳VO。
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					if("insert".equals(action)){
						String url = "/front-end/adoptani_sponsor/listAllAdoptaniSponsor.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); 
						successView.forward(req, res);
					}else if("insert_From_listOneAdoptaniAllSponsorForView.jsp".equals(action)){
						String url = "/front-end/adoptani_sponsor/listOneAdoptaniAllSponsorForView.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); 
						successView.forward(req, res);	
					}
					
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					
					errorMsgs.add(e.getMessage());
					if("insert".equals(action)){
						String url = "/front-end/adoptani_sponsor/addAdoptaniSponsor.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); 
						successView.forward(req, res);
					}else if("insert_From_listOneAdoptaniAllSponsorForView.jsp".equals(action)){
						String url = "/front-end/adoptani_sponsor/listOneAdoptaniAllSponsorForView.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); 
						successView.forward(req, res);	
					}
				}
			}

			
			if ("update".equals(action) ) { // 來自update_adoptani_input.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				String requestURL = req.getParameter("requestURL");
				
				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String adopt_Ani_Id = null;
					
					try {
						System.out.println(req.getParameter("adopt_Ani_Id"));
						int adopt_Ani_Id2 = Integer.parseInt(req.getParameter("adopt_Ani_Id"));
						adopt_Ani_Id = req.getParameter("adopt_Ani_Id");	
					} catch (Exception e) {
						errorMsgs.add("請輸入正確送養動物編號");
					}
					
					
					String mem_Id = null;
					try {
						System.out.println(req.getParameter("mem_Id"));
						int mem_Id2 = Integer.parseInt(req.getParameter("mem_Id"));
						mem_Id = req.getParameter("mem_Id");	
					} catch (Exception e) {
						errorMsgs.add("請輸入正確會員編號");
					}
					

					
					String ado_Ani_Spo_thing = req.getParameter("ado_Ani_Spo_thing");
					if (ado_Ani_Spo_thing == null || (ado_Ani_Spo_thing.trim()).length() == 0) {
						ado_Ani_Spo_thing = "無";
					}
					String ado_Ani_Spo_money_str = req.getParameter("ado_Ani_Spo_money");
					
					if (ado_Ani_Spo_money_str == null || (ado_Ani_Spo_money_str.trim()).length() == 0) {
						ado_Ani_Spo_money_str = "0";
					}
					
					Integer ado_Ani_Spo_money2 = null;
					try {
						ado_Ani_Spo_money2 = Integer.parseInt(ado_Ani_Spo_money_str);
					} catch (Exception e) {
						errorMsgs.add("請輸入正確贊助金額(數字)");
					}
					if("無".equals(ado_Ani_Spo_thing) && ado_Ani_Spo_money2==0){
						errorMsgs.add("尚未贊助任何物資~");
						
					}
					
					String ado_Ani_Spo_No = req.getParameter("ado_Ani_Spo_No");

					AdoptaniSponsorVO adoptaniSponsorVO = new AdoptaniSponsorVO();
						adoptaniSponsorVO.setAdopt_Ani_Id(adopt_Ani_Id);
						adoptaniSponsorVO.setMem_Id(mem_Id);
						adoptaniSponsorVO.setAdo_Ani_Spo_thing(ado_Ani_Spo_thing) ;
						adoptaniSponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money2) ;
						adoptaniSponsorVO.setAdo_Ani_Spo_No(ado_Ani_Spo_No) ;
						
						// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						
						req.setAttribute("adoptaniSponsorVO", adoptaniSponsorVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/adoptani_sponsor/update_adoptaniSponsor_input.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始修改資料*****************************************/
					
					req.setAttribute("adoptaniSponsorVO", adoptaniSponsorVO);
					AdoptaniSponsorService adoptaniSponsorgeSvc = new AdoptaniSponsorService();
					adoptaniSponsorVO = adoptaniSponsorgeSvc.updateAdoptaniSponsor(ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money2, ado_Ani_Spo_thing);
					
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					System.out.println("修改完成,準備轉交"+requestURL);
					req.setAttribute("adoptaniSponsorVO", adoptaniSponsorVO); // 資料庫update成功後,正確的的adoptaniSponsorVO物件,存入request scope中。
					String url = requestURL;
					RequestDispatcher successView = req.getRequestDispatcher("/front-end/adoptani_sponsor/listAllAdoptaniSponsor.jsp"); // 修改成功後,轉交
					successView.forward(req, res);

					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					System.out.println("修改資料失敗");
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/update_adoptaniSponsor_input.jsp");
					failureView.forward(req, res);
				}
			}

			if ("getOne_For_Update".equals(action) ) { 

				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				String requestURL = req.getParameter("requestURL");
				
				try {
					/***************************1.接收請求參數****************************************/
					String ado_Ani_Spo_No = new String(req.getParameter("ado_Ani_Spo_No").trim());
					
					/***************************2.開始查詢資料****************************************/
					AdoptaniSponsorService adoptaniSponsorgeSvc = new AdoptaniSponsorService();
					AdoptaniSponsorVO adoptaniSponsorVO = adoptaniSponsorgeSvc.getOneAdoptaniSponsor(ado_Ani_Spo_No);
				
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					req.setAttribute("adoptaniSponsorVO", adoptaniSponsorVO);         // 資料庫取出的adoptaniVO物件,存入req
					String url = "/front-end/adoptani_sponsor/update_adoptaniSponsor_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_adoptani_input.jsp
					successView.forward(req, res);

					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/listAllAdoptaniSponsor.jsp");
					failureView.forward(req, res);
				}
			}
		 
			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
System.out.println("into delete");
				try {
					/***************************1.接收請求參數***************************************/
					String ado_Ani_Spo_No = req.getParameter("ado_Ani_Spo_No");
					
					/***************************2.開始刪除資料***************************************/
					AdoptaniSponsorService adoptaniSponsorgeSvc = new AdoptaniSponsorService();
					adoptaniSponsorgeSvc.deleteAdoptaniSponsor(ado_Ani_Spo_No);
System.out.println("into delete>ado_Ani_Spo_No:"+ado_Ani_Spo_No);		
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/front-end/adoptani_sponsor/listAllAdoptaniSponsor.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("刪除資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_sponsor/listAllAdoptaniSponsor.jsp");
					failureView.forward(req, res);
				}
			}		 
	}

}
