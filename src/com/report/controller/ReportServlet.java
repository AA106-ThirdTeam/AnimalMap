package com.report.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adoptani.model.AdoptaniService;
import com.adoptani.model.AdoptaniVO;
import com.emg_H.model.Emg_HService;
import com.emg_H.model.Emg_HVO;
import com.hos.model.HosService;
import com.hos.model.HosVO;
import com.hosPhoto.model.HosPhotoVO;
import com.report.model.ReportService;
import com.report.model.ReportVO;

import heibernate_com.adopt_ani.model.Adopt_AniService;
import heibernate_com.emg_help.model.Emg_HelpService;
import heibernate_com.hos_comment.model.Hos_commentService;
import heibernate_com.vet_hospital.model.Vet_hospitalService;



public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		PrintWriter out=res.getWriter();

		//審核檢舉不通過
		if("Delete_Report_No".equals(action)){
			
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				/****************************** 1.接收請求參數  **********************/
				String report_No = req.getParameter("report_No");				
				
				
				/*************************** 2.開始delete資料 *****************************************/
				 ReportService reportSvc = new ReportService();						 
				 reportSvc.delete(report_No);
				 
				 
				/****************************** 3.刪除完成,準備轉交(Send the Success view) *************/
				
				String url = "/back-end/report/listAllReport.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); //轉交到listAllReport.jsp
				successView.forward(req, res);
				
			}catch(Exception e){
				errorMsgs.add("delete資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/report/listAllReport.jsp");
				failureView.forward(req, res);
			}
		}
		
		//檢舉通過時，更改status 被檢舉的物件 OR 刪除被檢舉的物件
		if("Update&Update_front_status".equals(action)){
			
			System.out.println(action);
					List<String> errorMsgs = new LinkedList<String>();
					req.setAttribute("errorMsgs", errorMsgs);
					ReportVO reportVO=new ReportVO();
					ReportVO reportVO2=new ReportVO();
			
			try {
				/******************************** 1.接收請求參數 **********************/

				String report_No = req.getParameter("report_No");				
				String report_status = req.getParameter("report_status");			
				String report_class = req.getParameter("report_class");			
				String report_class_No = req.getParameter("report_class_No");			
				String report_class_No_value = req.getParameter("report_class_No_value");
				String report_class_status = req.getParameter("report_class_status");
				
				
				/*************************** 2.開始修改資料 *****************************************/
				 ReportService reportSvc = new ReportService();
				 
				 //如果狀態是 0=尚未審核時
				 if(report_status.equals("0")){
					 
					 report_status="1";					 
				 	 reportVO = reportSvc.updateStatus(report_No, report_status);	 	 
				 		
/*==========================================<Update 前端的物件>=================================================*/
				 	 
//				 	 if(report_class_status.equals("emg_H_status="))	{ 
//				 		 
//				 		 //更改其他表格的檢舉狀態
//				 		 report_class_status="emg_H_status='已被檢舉'";	 
//				 		 reportVO2=reportSvc.update_Object(report_class, report_class_No, report_class_No_value, report_class_status);
//				 	 }	
//				 
				 }
				 
				 // 使用hibernate  cascade關係刪除 緊急求救的檢舉
				 
				 if(report_class.startsWith("emg_Help")){	
 System.out.println(report_class);
				 Emg_HelpService emg_HelpSvc=new Emg_HelpService();
 System.out.println(report_class_No_value);
 				 emg_HelpSvc.deleteEmg_Help(report_class_No_value);
				 
				 }
				// 使用hibernate  cascade關係刪除 動物檢舉
				 else if(report_class.startsWith("ADOPT_ANI")){
				 Adopt_AniService Adopt_AniSvc =new Adopt_AniService();
				 Adopt_AniSvc.deleteAdopt_Ani(report_class_No_value);
				 }
				// 使用hibernate  cascade關係刪除 醫院的檢舉
				 else if(report_class.startsWith("vet_hospital")){
System.out.println(report_class+" 111111111111111111");
System.out.println(report_class_No_value+" 222222222222222222222222222");

					 Vet_hospitalService vet_hospitalSvc=new Vet_hospitalService();
					 vet_hospitalSvc.deleteVet_hospital(report_class_No_value);	
				 }
				 
				 
 /*=========================================<Update 前端的物件>=================================================*/
				
				/****************************** 3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("reportVO", reportVO); // 資料庫update成功後,正確的的reportVO物件,存入req ,審核狀態
				req.setAttribute("reportVO2", reportVO2); // 資料庫update_Object成功後,正確的的reportVO2物件,存入req, 更改檢舉狀態欄位
				
				String url = "/back-end/report/listAllReport.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listAllReport.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
				} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/report/listAllReport.jsp");
				failureView.forward(req, res);
			}
		}
		
			//前端送來的檢舉
		if("InsertReport".equals(action)){
			
			
			List<String> errorMsgs=new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				
				/******************************** 1.接收請求參數 **********************/
				String report_name =req.getParameter("report_name").trim();
			
				if(report_name == null || report_name.trim().length() ==0){
					
					errorMsgs.add("請輸入標題");
				}
				String report_class =req.getParameter("report_class");
				String report_class_No =req.getParameter("report_class_No");
				String report_class_No_value =req.getParameter("report_class_No_value");
				String report_class_status =req.getParameter("report_class_status");
				String report_content =req.getParameter("report_content").trim();
				
				if(report_content == null || report_content.trim().length() ==0){
					
					errorMsgs.add("請輸入標題");
				}
				String report_status =req.getParameter("report_status");
				String mem_Id_active =req.getParameter("mem_Id_active");
				String mem_Id_passive =req.getParameter("mem_Id_passive");
				java.sql.Date  report_time=new java.sql.Date (System.currentTimeMillis());
				
				
				
				
				if(!errorMsgs.isEmpty()){
					
					RequestDispatcher failureView =req.getRequestDispatcher("/back-end/emp/select_page.jsp");
					failureView.forward(req,res);
					return;
				}
				
				/*************************** 2.開始新增資料 *****************************************/
				ReportService reportSvc = new ReportService();
				ReportVO reportVO =reportSvc.insert( report_name, report_class, report_class_No,report_class_No_value,report_content, report_status, mem_Id_active, mem_Id_passive, report_time,report_class_status);

				/****************************** 3.新增完成,準備轉交(Send the Success view) *************/
				// 傳回前端JQuery success view
				out.print(reportVO);
				
			

				/*************************** 其他可能的錯誤處理 *************************************/
			}catch(Exception e){
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView =req.getRequestDispatcher("/back-end/emp/select_page.jsp");
				failureView.forward(req,res);
				
			}
			
		}
		
		//查看被檢舉的物件
		if("Check_ReportData".equals(action)){

			
			String whosTable=req.getParameter("report_class").trim();
			String whosPK=req.getParameter("report_class_No_value").trim();
			
			//與開始的字符合的話
			
			//緊急求救
			if(whosTable.startsWith("emg_Help")){
				
				Emg_HService emg_HSvc=new Emg_HService();
				Emg_HVO  emg_HVO=emg_HSvc.getOneEmg_H(whosPK);
				req.setAttribute("emg_HVO", emg_HVO);
				
			}  //動物
			else if(whosTable.startsWith("ADOPT_ANI")){
				AdoptaniService adoptaniSvc=new AdoptaniService();
				AdoptaniVO adoptaniVO =adoptaniSvc.getOneAdoptani(whosPK);

				req.setAttribute("adoptaniVO", adoptaniVO);
				
			}  // 醫院
				else if(whosTable.startsWith("vet_hospital")){
				  HosService hosSvc=new HosService();
				  HosVO hosVO=hosSvc.getOneHos(whosPK);
				  Set<HosPhotoVO> listPhotos_ByHosId=hosSvc.getPhotosByHosId(whosPK);
				  
				  req.setAttribute("includeInfo", "includeInfo");
				  req.setAttribute("listPhotos_ByHosId", listPhotos_ByHosId);
				  req.setAttribute("hosVO", hosVO);
				}
//			}else if(whosTable.startsWith("")){
//				
//			}
			
			
			
			String url="/back-end/report/listAllReport.jsp";
			RequestDispatcher successView =req.getRequestDispatcher(url);
			successView.forward(req,res);
			
		}
		
		
			
		}
		
		
	}


