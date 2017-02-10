	

package com.emg_help.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;

import com.emg_help.model.*;
/** 
 *emg_help : <br>
 *	緊急求救<br>
 *	英文:emg_help<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/emg_help/emg_help.do" })
public class Emg_helpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Emg_help servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("emg_H_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("求救編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   emg_H_Id = null;
				try {
					emg_H_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("求救編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				Emg_helpService emg_helpSvc = new Emg_helpService();
				Emg_helpVO emg_helpVO = emg_helpSvc.getOneEmg_help(emg_H_Id);
				
				if (emg_helpVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_helpVO", emg_helpVO); 
				String url = "/back-end/emg_help/listOneEmg_help.jsp";
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
				String emg_H_Id = new String(req.getParameter("emg_H_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Emg_helpService emg_helpSvc = new Emg_helpService();
				Emg_helpVO emg_helpVO = emg_helpSvc.getOneEmg_help(emg_H_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("emg_helpVO", emg_helpVO); 		
				String url = "/back-end/emg_help/update_emg_help_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emg_help_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_emg_help_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String emg_H_Id = req.getParameter("emg_H_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				java.sql.Date emg_H_start_date = null;
				try {
					emg_H_start_date = java.sql.Date.valueOf(req.getParameter("emg_H_start_date").trim());
				} catch (IllegalArgumentException e) {
					emg_H_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date emg_H_end_date = null;
				try {
					emg_H_end_date = java.sql.Date.valueOf(req.getParameter("emg_H_end_date").trim());
				} catch (IllegalArgumentException e) {
					emg_H_end_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String emg_H_title = req.getParameter("emg_H_title").trim();
				String emg_H_content = req.getParameter("emg_H_content").trim();
				byte[] emg_H_Pic = null;
				try {
					Part part = req.getPart("emg_H_Pic");
					InputStream in = part.getInputStream();
					emg_H_Pic = new byte[part.getInputStream().available()];
					in.read(emg_H_Pic);
					in.close();
				} catch (Exception e) {
					emg_H_Pic = null;
					//errorMsgs.add("照片請上傳照片.");
				}
				String emg_H_Pic_format = req.getParameter("emg_H_Pic_format").trim();
				String emg_H_city = req.getParameter("emg_H_city").trim();
				String emg_H_town = req.getParameter("emg_H_town").trim();
				String emg_H_road = req.getParameter("emg_H_road").trim();
				Double emg_H_Lon = null;
				try {
					emg_H_Lon = new Double(req.getParameter("emg_H_Lon").trim());
				} catch (NumberFormatException e) {
					emg_H_Lon = 0.0;
					errorMsgs.add("緊急求救經度座標請填數字.");
				}
				Double emg_H_Lat = null;
				try {
					emg_H_Lat = new Double(req.getParameter("emg_H_Lat").trim());
				} catch (NumberFormatException e) {
					emg_H_Lat = 0.0;
					errorMsgs.add("緊急求救緯度座標請填數字.");
				}

				//==== VO設定部分 ====			
				Emg_helpVO emg_helpVO = new Emg_helpVO();
				emg_helpVO.setEmg_H_Id(emg_H_Id);
				emg_helpVO.setMem_Id(mem_Id);
				emg_helpVO.setEmg_H_start_date(emg_H_start_date);
				emg_helpVO.setEmg_H_end_date(emg_H_end_date);
				emg_helpVO.setEmg_H_title(emg_H_title);
				emg_helpVO.setEmg_H_content(emg_H_content);
				emg_helpVO.setEmg_H_Pic(emg_H_Pic);
				emg_helpVO.setEmg_H_Pic_format(emg_H_Pic_format);
				emg_helpVO.setEmg_H_city(emg_H_city);
				emg_helpVO.setEmg_H_town(emg_H_town);
				emg_helpVO.setEmg_H_road(emg_H_road);
				emg_helpVO.setEmg_H_Lon(emg_H_Lon);
				emg_helpVO.setEmg_H_Lat(emg_H_Lat);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("emg_helpVO", emg_helpVO); // 含有輸入格式錯誤的emg_helpVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/emg_help/update_emg_help_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Emg_helpService emg_helpSvc = new Emg_helpService();
				emg_helpVO = emg_helpSvc.updateEmg_help(
					emg_H_Id
					,mem_Id
					,emg_H_start_date
					,emg_H_end_date
					,emg_H_title
					,emg_H_content
					,emg_H_Pic
					,emg_H_Pic_format
					,emg_H_city
					,emg_H_town
					,emg_H_road
					,emg_H_Lon
					,emg_H_Lat
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/emg_help/listEmg_helps_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/emg_help/listAllEmg_help.jsp")){
					req.setAttribute("listEmg_helps_ByMem_Id",emg_helpSvc.getEmg_helpsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/emg_help/listEmg_helps_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Emg_helpVO> list  = emg_helpSvc.getAll(map);
					req.setAttribute("listEmg_helps_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/emg_help/update_emg_help_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addEmg_help.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String mem_Id = req.getParameter("mem_Id").trim();	
	
                java.sql.Date emg_H_start_date = null;
                try {
                    emg_H_start_date = java.sql.Date.valueOf(req.getParameter("emg_H_start_date").trim());
                } catch (IllegalArgumentException e) {
                    emg_H_start_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
	
                java.sql.Date emg_H_end_date = null;
                try {
                    emg_H_end_date = java.sql.Date.valueOf(req.getParameter("emg_H_end_date").trim());
                } catch (IllegalArgumentException e) {
                    emg_H_end_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                String emg_H_title = req.getParameter("emg_H_title").trim();	

                String emg_H_content = req.getParameter("emg_H_content").trim();	

                byte[] emg_H_Pic = null;
                try {
                    Part part = req.getPart("emg_H_Pic");
                    InputStream in = part.getInputStream();
                    emg_H_Pic = new byte[part.getInputStream().available()];
                    in.read(emg_H_Pic);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("照片請上傳照片.");
                    //e.printStackTrace();
                    emg_H_Pic = null;
                }	

                String emg_H_Pic_format = req.getParameter("emg_H_Pic_format").trim();	

                String emg_H_city = req.getParameter("emg_H_city").trim();	

                String emg_H_town = req.getParameter("emg_H_town").trim();	

                String emg_H_road = req.getParameter("emg_H_road").trim();	
	
                Double emg_H_Lon = null;
                try {
                    emg_H_Lon = new Double(req.getParameter("emg_H_Lon").trim());
                } catch (NumberFormatException e) {
                    emg_H_Lon = 0.0;
                    errorMsgs.add("緊急求救經度座標請填數字.");
                    e.printStackTrace();
                }
	
                Double emg_H_Lat = null;
                try {
                    emg_H_Lat = new Double(req.getParameter("emg_H_Lat").trim());
                } catch (NumberFormatException e) {
                    emg_H_Lat = 0.0;
                    errorMsgs.add("緊急求救緯度座標請填數字.");
                    e.printStackTrace();
                }

                Emg_helpVO emg_helpVO = new Emg_helpVO();
 
                emg_helpVO.setMem_Id(mem_Id);
 
                emg_helpVO.setEmg_H_start_date(emg_H_start_date);
 
                emg_helpVO.setEmg_H_end_date(emg_H_end_date);
 
                emg_helpVO.setEmg_H_title(emg_H_title);
 
                emg_helpVO.setEmg_H_content(emg_H_content);
 
                emg_helpVO.setEmg_H_Pic(emg_H_Pic);
 
                emg_helpVO.setEmg_H_Pic_format(emg_H_Pic_format);
 
                emg_helpVO.setEmg_H_city(emg_H_city);
 
                emg_helpVO.setEmg_H_town(emg_H_town);
 
                emg_helpVO.setEmg_H_road(emg_H_road);
 
                emg_helpVO.setEmg_H_Lon(emg_H_Lon);
 
                emg_helpVO.setEmg_H_Lat(emg_H_Lat);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("emg_helpVO", emg_helpVO); // 含有輸入格式錯誤的emg_helpVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emg_help/addEmg_help.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Emg_helpService emg_helpSvc = new Emg_helpService();
                emg_helpVO = emg_helpSvc.addEmg_help(
	
                	mem_Id
	
                	,emg_H_start_date
	
                	,emg_H_end_date
	
                	,emg_H_title
	
                	,emg_H_content
	
                	,emg_H_Pic
	
                	,emg_H_Pic_format
	
                	,emg_H_city
	
                	,emg_H_town
	
                	,emg_H_road
	
                	,emg_H_Lon
	
                	,emg_H_Lat
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/emg_help/listAllEmg_help.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmg_help.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/emg_help/addEmg_help.jsp");
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
                String emg_H_Id = new String(req.getParameter("emg_H_Id"));

				/***************************2.開始刪除資料***************************************/
				Emg_helpService emg_helpSvc = new Emg_helpService();

				Emg_helpVO emg_helpVO = emg_helpSvc.getOneEmg_help(emg_H_Id);
				emg_helpSvc.deleteEmg_help(emg_H_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/emg_help/listEmg_helps_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/emg_help/listAllEmg_help.jsp")){
					req.setAttribute("listEmg_helps_ByMem_Id",emg_helpSvc.getEmg_helpsByMem_Id(emg_helpVO.getMem_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/emg_help/listEmg_helps_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Emg_helpVO> list  = emg_helpSvc.getAll(map);
					req.setAttribute("listEmg_helps_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listEmg_helps_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Emg_helpService emg_helpSvc = new Emg_helpService();
                List<Emg_helpVO> list  = emg_helpSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listEmg_helps_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/emg_help/listEmg_helps_ByCompositeQuery.jsp"); // 成功轉交listEmg_helps_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 emg_help/listAllEmg_help.jsp的請求
        if ("listEmg_helps_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String mem_Id = new String(req.getParameter("mem_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                Emg_helpService emg_helpSvc = new Emg_helpService();
                Set<Emg_helpVO> set = emg_helpSvc.getEmg_helpsByMem_Id(mem_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listEmg_helps_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listEmg_helps_ByMem_Id_A".equals(action))
                    url = "/back-end/emg_help/listEmg_helps_ByMem_Id.jsp";        // 成功轉交 emg_help/listEmg_helps_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }












	}
}
