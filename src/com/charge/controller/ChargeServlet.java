package com.charge.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charge.model.ChargeService;
import com.charge.model.ChargeVO;
import heibernate_com.mem.model.MemService;

public class ChargeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		//====TEST====
//		if ("test".equals(action)) {
//			heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)req.getSession().getAttribute("account");
//			
//			//建立svc
//			heibernate_com.mem.model.MemDAO dao = new heibernate_com.mem.model.MemDAO();
//			account.setMem_balance(account.getMem_balance() + charge_number);
//			dao.update(account);
//		}
		
//一：查詢=============================================================
		
		if("getOne_For_Display".equals(action)){
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("charge_no");
				System.out.println("~~~"+str);
				if (str == null || (str.trim()).length() == 0 ){
					errorMsgs.add("輸入儲值編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String charge_no = null;
				try {
					charge_no = new String(str);
				} catch (Exception e) {
					errorMsgs.add("格式不正確");
				}
				// Send the use back to the form, if there were errors				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				/***************************2.開始查詢資料*****************************************/
				ChargeService chargeSvc = new ChargeService();
				ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);
				if(chargeVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("chargeVO", chargeVO);//資料庫取出VO物件存入req
				String url = "/back-end/charge/listOneCharge.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/select_page.jsp");
				failureView.forward(req, res);
			}
		}
////二、Update=============================================================
		if ("getOne_For_Update".equals(action)){
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL");
			
			try{
				/***************************1.接收請求參數****************************************/
				String charge_no = req.getParameter("charge_no");
				/***************************2.開始查詢資料****************************************/
				ChargeService chargeSvc = new ChargeService();
				ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("charge_no", charge_no);
				String url = "/back-end/charge/update_charge_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				/***************************其他可能的錯誤處理************************************/

			}  catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
////三、Update=============================================================
		
		if("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String requestURL = req.getParameter("requestURL"); 			
			try{
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String charge_no = req.getParameter("charge_no").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				
				//儲值金額
				Integer charge_number = null;
				try{
					 charge_number = new Integer(req.getParameter("charge_number").trim());
				} catch(NumberFormatException e){
					charge_number = 0;
					errorMsgs.add("金額請填數字");
				}
				//付款方式
				Integer pay = null;
				try{
					 pay = new Integer(req.getParameter("pay").trim());
				} catch(NumberFormatException e){
					pay = 0;
					errorMsgs.add("付款方式請選擇");
				}
				//付款日期
				java.sql.Date applytime = null;
				try {
					applytime = java.sql.Date.valueOf(req.getParameter("applytime").trim());
				} catch (IllegalArgumentException e) {
					applytime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				ChargeVO chargeVO = new ChargeVO();
				chargeVO.setCharge_no(charge_no);
				chargeVO.setMem_id(mem_Id);
				chargeVO.setCharge_number(charge_number);
				chargeVO.setPay(pay);
				chargeVO.setApplytime(applytime);
				
				if (!errorMsgs.isEmpty()){
					req.setAttribute("chargeVO", chargeVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/charge/update_charge_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				/***************************2.開始修改資料*****************************************/
				ChargeService chargeSvc = new ChargeService();
				chargeVO = chargeSvc.updateCharge(charge_no, mem_Id, charge_number, pay, applytime);
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				MemService memSvc = new MemService();
				if(requestURL.equals("/back-end/mem/listCharges_ByMem_id.jsp")||requestURL.equals("/back-end/mem/listAllMem.jsp"))
					req.setAttribute("listCharges_ByMem_id", memSvc.getOneMem(mem_Id));
				
				if(requestURL.equals("/back-end/charge/listCharges_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ChargeVO> list = chargeSvc.getAll(map);
					req.setAttribute("listCharges_ByCompositeQuery", list);
				}
				String url = requestURL;
				RequestDispatcher successViewDispatcher = req.getRequestDispatcher(url);
				successViewDispatcher.forward(req, res);
				
				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗"+e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/charge/update_charge_input.jsp");
				failureView.forward(req, res);
			}
		}
//四、insert=============================================================
		if ("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				String mem_Id = new String(req.getParameter("mem_Id").trim());
				System.out.println("A");
				heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)req.getSession().getAttribute("account");
				String mem_Id = account.getMem_Id();
				System.out.println("B");
				System.out.println(mem_Id);
				//儲值金額
				Integer charge_number = null;
				try{
					 charge_number = new Integer(req.getParameter("charge_number").trim());
				} catch(NumberFormatException e){
					charge_number = 0;
					errorMsgs.add("金額請填數字");
				}
				//付款方式
				Integer pay = null;
				try{
					 pay = new Integer(req.getParameter("pay").trim());
				} catch(NumberFormatException e){
					pay = 0;
					errorMsgs.add("付款方式請選擇");
				}
				//付款日期
				java.sql.Date applytime = null;
				try {
					applytime = java.sql.Date.valueOf(req.getParameter("applytime").trim());
				} catch (IllegalArgumentException e) {
					applytime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				ChargeVO chargeVO = new ChargeVO();
				chargeVO.setMem_id(mem_Id);
				chargeVO.setCharge_number(charge_number);
				chargeVO.setPay(pay);
				chargeVO.setApplytime(applytime);
				
				
				if(!errorMsgs.isEmpty()){
					req.setAttribute("chargeVO", chargeVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/charge/Charge.jsp");
					failureView.forward(req, res);
					return;
				}
				/***************************2.開始新增資料***************************************/
				
				ChargeService chargeSvc = new ChargeService();
				chargeVO = chargeSvc.addCharge(mem_Id, charge_number, pay, applytime);
				
				
//				heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)req.getSession().getAttribute("account");
				//建立svc
				heibernate_com.mem.model.MemDAO dao = new heibernate_com.mem.model.MemDAO();
				account.setMem_balance(account.getMem_balance() + charge_number);
				dao.update(account);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/charge/listAllCharge.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				/***************************其他可能的錯誤處理**********************************/

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/charge/addCharge.jsp");
				failureView.forward(req, res);
			}	
		}
////五、delete=============================================================		
		if("delete".equals(action)){
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL");
			
			try {
				/***************************1.接收請求參數***************************************/
				String charge_no = req.getParameter("charge_no");
				/***************************2.開始刪除資料***************************************/
				ChargeService chargeSvc = new ChargeService();
				ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);
				chargeSvc.deleteCharge(charge_no);
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				MemService MemSvc = new MemService();
				if(requestURL.equals("/back-end/charge/listCharges_ByMem_id.jsp") 
						|| requestURL.equals("/back-end/mem/listAllMem.jsp"))
					req.setAttribute("listCharges_ByMem_id",chargeSvc.getChargesByMem_Id(chargeVO.getMem_Id()));
				if(requestURL.equals("/back-end/charge/listCharges_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ChargeVO> list = chargeSvc.getAll(map);
					req.setAttribute("listCharges_ByCompositeQuery", list);		
				}
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				/***************************其他可能的錯誤處理**********************************/

			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
////五、ByCompositeQuery=============================================================		
		if("listCharges_ByCompositeQuery".equals(action)){
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				/***************************1.將輸入資料轉為Map**********************************/ 
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				if (req.getParameter("whichPage") == null){
					HashMap<String, String[]> map1 = (HashMap<String, String[]>)req.getParameterMap();
					HashMap<String, String[]> map2 = new HashMap<String, String[]>();
					map2 = (HashMap<String, String[]>)map1.clone();
					session.setAttribute("map", map2);
					map = (HashMap<String, String[]>)req.getParameterMap();
				}
				/***************************2.開始複合查詢***************************************/
				ChargeService chargeSvc = new ChargeService();
				List<ChargeVO> list = chargeSvc.getAll(map);
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("listCharges_ByCompositeQuery", list);
				RequestDispatcher successView = req.getRequestDispatcher("/back-end/charge/listCharges_ByCompositeQuery.jsp");
				successView.forward(req, res);
				/***************************其他可能的錯誤處理**********************************/
				
			} catch (Exception e){
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/select_page.jsp");
				failureView.forward(req, res);
			}
		}
	}
}

		
	

