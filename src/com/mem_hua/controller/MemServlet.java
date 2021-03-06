	

package com.mem_hua.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mem_hua.model.*;

import javax.servlet.annotation.WebServlet;
/** 
 *mem : <br>
 *	一般會員<br>
 *	英文:mem<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/mem/mem.do" })
public class MemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Mem servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("mem_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("會員編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   mem_Id = null;
				try {
					mem_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("會員編號格式不正確");				
				}
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
				String url = "/back-end/mem/listOneMem.jsp";
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
				String mem_Id = new String(req.getParameter("mem_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(mem_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memVO", memVO); 		
				String url = "/back-end/mem/update_mem_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_mem_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_mem_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
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

				//==== VO設定部分 ====			
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


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的memVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/mem/update_mem_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				MemService memSvc = new MemService();
				memVO = memSvc.updateMem(
					mem_Id
					,mem_account
					,mem_Psw
					,mem_nick_name
					,mem_name
					,mem_gender
					,mem_Tw_Id
					,mem_birth_date
					,mem_phone
					,mem_Intro
					,mem_profile
					,mem_black_list
					,mem_permission
					,mem_setting
					,mem_balance
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				
				
				if(requestURL.equals("/back-end/mem/listMems_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<MemVO> list  = memSvc.getAll(map);
					req.setAttribute("listMems_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/mem/update_mem_input.jsp");
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
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/mem/addMem.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                MemService memSvc = new MemService();
                memVO = memSvc.addMem(
	
                	mem_account
	
                	,mem_Psw
	
                	,mem_nick_name
	
                	,mem_name
	
                	,mem_gender
	
                	,mem_Tw_Id
	
                	,mem_birth_date
	
                	,mem_phone
	
                	,mem_Intro
	
                	,mem_profile
	
                	,mem_black_list
	
                	,mem_permission
	
                	,mem_setting
	
                	,mem_balance
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/mem/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllMem.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/mem/addMem.jsp");
				failureView.forward(req, res);
			}
		}			

		if ("delete".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
                String mem_Id = new String(req.getParameter("mem_Id"));

				/***************************2.開始刪除資料***************************************/
				MemService memSvc = new MemService();

				MemVO memVO = memSvc.getOneMem(mem_Id);
				memSvc.deleteMem(mem_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				
				
				if(requestURL.equals("/back-end/mem/listMems_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<MemVO> list  = memSvc.getAll(map);
					req.setAttribute("listMems_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("listMems_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                
                /***************************1.將輸入資料轉為Map**********************************/ 
                //採用Map<String,String[]> getParameterMap()的方法 
                //注意:an immutable java.util.Map 
                //Map<String, String[]> map = req.getParameterMap();
                HttpSession session = req.getSession();
                Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");

                if (req.getParameter("whichPage") == null){
                    HashMap<String, String[]> map1 = (HashMap<String, String[]>)req.getParameterMap();
                    HashMap<String, String[]> map2 = new HashMap<String, String[]>();
                    map2 = (HashMap<String, String[]>)map1.clone();
                    session.setAttribute("map",map2);
                    map = (HashMap<String, String[]>)req.getParameterMap();
                } 

                /***************************2.開始複合查詢***************************************/
                MemService memSvc = new MemService();
                List<MemVO> list  = memSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listMems_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/mem/listMems_ByCompositeQuery.jsp"); // 成功轉交listMems_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	















	}
}
