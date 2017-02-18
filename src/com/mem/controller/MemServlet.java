package com.mem.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mem.model.MemService;
import com.mem.model.MemVO;
import com.rel_list.model.Rel_ListService;
import com.rel_list.model.Rel_ListVO;
/** 
 *表格名稱 : <br>
 *	中文:一般會員<br>
 *	英文:mem<br>
 */ 
@WebServlet(urlPatterns = { "/mem/mem.do" })
public class MemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		

		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("mem_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入會員編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String  mem_Id = null;
				try {
					mem_Id = new String (str);
				} catch (Exception e) {
					errorMsgs.add("會員編號格式不正確");				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(mem_Id);
				if (memVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memVO", memVO); 
				String url = "/mem/listOneMem.jsp";
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
				String  mem_Id = new String (req.getParameter("mem_Id").trim());

				/***************************2.開始查詢資料*****************************************/
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(mem_Id);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memVO", memVO); 
				String url = "/mem/update_mem_input.jsp";
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
				String mem_Id = req.getParameter("mem_Id").trim();
				String mem_account = req.getParameter("mem_account").trim();
				String mem_Psw = req.getParameter("mem_Psw").trim();
				String mem_nick_name = req.getParameter("mem_nick_name").trim();
				String mem_name = req.getParameter("mem_name").trim();
				String mem_gender = req.getParameter("mem_gender").trim();
				String mem_Tw_Id = req.getParameter("mem_Tw_Id").trim();
				java.sql.Date mem_birth_date = null;
				try {
					mem_birth_date = java.sql.Date.valueOf(req.getParameter("mem_birth_date").trim());
				} catch (IllegalArgumentException e) {
					mem_birth_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String mem_phone = req.getParameter("mem_phone").trim();
				String mem_Intro = req.getParameter("mem_Intro").trim();
				byte[] mem_profile = null;
				try {
					Part part = req.getPart("mem_profile");
					InputStream in = part.getInputStream();
					mem_profile = new byte[part.getInputStream().available()];
					in.read(mem_profile);
					in.close();
				} catch (Exception e) {
					mem_profile = null;
					//errorMsgs.add("大頭照請上傳照片.");
				}
				String mem_black_list = req.getParameter("mem_black_list").trim();
				String mem_permission = req.getParameter("mem_permission").trim();
				String mem_setting = req.getParameter("mem_setting").trim();
				Integer mem_balance = new Integer(req.getParameter("mem_balance").trim());

				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				memVO.setMem_account(mem_account);
				memVO.setMem_Psw(mem_Psw);
				memVO.setMem_nick_name(mem_nick_name);
				memVO.setMem_name(mem_name);
				memVO.setMem_gender(mem_gender);
				memVO.setMem_Tw_Id(mem_Tw_Id);
				memVO.setMem_birth_date(mem_birth_date);
				memVO.setMem_phone(mem_phone);
				memVO.setMem_Intro(mem_Intro);
				memVO.setMem_profile(mem_profile);
				memVO.setMem_black_list(mem_black_list);
				memVO.setMem_permission(mem_permission);
				memVO.setMem_setting(mem_setting);
				memVO.setMem_balance(mem_balance);
				if (!errorMsgs.isEmpty()) {
					String url = "/mem/update_mem_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				MemService memSvc = new MemService();
				memVO = memSvc.updateMem(mem_Id,mem_account,mem_Psw,mem_nick_name,mem_name,mem_gender,mem_Tw_Id,mem_birth_date,mem_phone,mem_Intro,mem_profile,mem_black_list,mem_permission,mem_setting,mem_balance);

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memVO", memVO); 
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/mem/update_mem_input.jsp");
				failureView.forward(req, res);
			}
		}
        if ("insert".equals(action)) { // 來自addMem.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
                String mem_account = req.getParameter("mem_account").trim();
                String mem_Psw = req.getParameter("mem_Psw").trim();
                String mem_nick_name = req.getParameter("mem_nick_name").trim();
                String mem_name = req.getParameter("mem_name").trim();
                String mem_gender = req.getParameter("mem_gender").trim();
                String mem_Tw_Id = req.getParameter("mem_Tw_Id").trim();
                java.sql.Date mem_birth_date = null;
                try {
                    mem_birth_date = java.sql.Date.valueOf(req.getParameter("mem_birth_date").trim());
                } catch (IllegalArgumentException e) {
                    mem_birth_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
                String mem_phone = req.getParameter("mem_phone").trim();
                String mem_Intro = req.getParameter("mem_Intro").trim();
                byte[] mem_profile = null;
                try {
                    Part part = req.getPart("mem_profile");
                    InputStream in = part.getInputStream();
                    mem_profile = new byte[part.getInputStream().available()];
                    in.read(mem_profile);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("大頭照請上傳照片.");
                    //e.printStackTrace();
                    mem_profile = null;
                }
                String mem_black_list = req.getParameter("mem_black_list").trim();
                String mem_permission = req.getParameter("mem_permission").trim();
                String mem_setting = req.getParameter("mem_setting").trim();
                Integer mem_balance = new Integer(req.getParameter("mem_balance").trim());

                MemVO memVO = new MemVO();
                memVO.setMem_account(mem_account);
                memVO.setMem_Psw(mem_Psw);
                memVO.setMem_nick_name(mem_nick_name);
                memVO.setMem_name(mem_name);
                memVO.setMem_gender(mem_gender);
                memVO.setMem_Tw_Id(mem_Tw_Id);
                memVO.setMem_birth_date(mem_birth_date);
                memVO.setMem_phone(mem_phone);
                memVO.setMem_Intro(mem_Intro);
                memVO.setMem_profile(mem_profile);
                memVO.setMem_black_list(mem_black_list);
                memVO.setMem_permission(mem_permission);
                memVO.setMem_setting(mem_setting);
                memVO.setMem_balance(mem_balance);
       
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的memVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/mem/addMem.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                MemService memSvc = new MemService();
                memVO = memSvc.addMem(mem_account,mem_Psw,mem_nick_name,mem_name,mem_gender,mem_Tw_Id,mem_birth_date,mem_phone,mem_Intro,mem_profile,mem_black_list,mem_permission,mem_setting,mem_balance); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/mem/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/mem/addMem.jsp");
				failureView.forward(req, res);
			}
		}
        if ("delete".equals(action)) { // 來自listAllMem.jsp 或  /dept/listMems_ByDeptno.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);
            
            String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/mem/listAllMem.jsp】 或  【/dept/listMems_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】 或 【 /mem/listMems_ByCompositeQuery.jsp】

            try {
                /***************************1.接收請求參數***************************************/
                String mem_Id = new String(req.getParameter("mem_Id"));
                
                
                /***************************2.開始刪除資料***************************************/
                MemService memSvc = new MemService();
                MemVO memVO = memSvc.getOneMem(mem_Id);
   
                memSvc.deleteMem(mem_Id);
             
                
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
        
        
        if ("listRelation_ByMemId".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String rel_MemId = req.getParameter("rel_MemId");
				
				/*************************** 2.�}�l�d�߸�� ****************************************/
				Rel_ListService relSvc = new Rel_ListService();
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(rel_MemId);
				String added_MemId = memVO.getMem_Id();
				
				
				Set<Rel_ListVO> addedMemIdSet = relSvc.getRel_ListByAdded_MemId(added_MemId);
				Set<Rel_ListVO> relMemIdSet = relSvc.getRel_ListByRel_MemId(rel_MemId);
				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				
				req.setAttribute("rel_list_memVO", memVO);
				req.setAttribute("listRelation_ByAddedMemId", addedMemIdSet);
				req.setAttribute("listRelation_ByMemId", relMemIdSet);    // ��Ʈw���X��set����,�s�Jrequest
//System.out.println("rel_MemId="+rel_MemId);
//System.out.println("memVO.getOneMem="+memVO.getMem_Id());
				
				String url = null;
				 if ("listRelation_ByMemId".equals(action))
					url = "/mem/listAllMem.jsp";              // ���\��� hos/listAllHos.jsp

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z ***********************************/
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
        
        
        
        
        
        
	}
}
