	

package com.park.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.emp.model.*;

import com.park.model.*;
/** 
 *park : <br>
 *	公園<br>
 *	英文:park<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/park/park.do" })
public class ParkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Park servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("park_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("公園編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   park_Id = null;
				try {
					park_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("公園編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				ParkService parkSvc = new ParkService();
				ParkVO parkVO = parkSvc.getOnePark(park_Id);
				
				if (parkVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("parkVO", parkVO); 
				String url = "/back-end/park/listOnePark.jsp";
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
				String park_Id = new String(req.getParameter("park_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				ParkService parkSvc = new ParkService();
				ParkVO parkVO = parkSvc.getOnePark(park_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("parkVO", parkVO); 		
				String url = "/back-end/park/update_park_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_park_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_park_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String park_Id = req.getParameter("park_Id").trim();
				String emp_Id = req.getParameter("emp_Id").trim();
				String park_title = req.getParameter("park_title").trim();
				String park_content = req.getParameter("park_content").trim();
				byte[] park_pic = null;
				try {
					Part part = req.getPart("park_pic");
					InputStream in = part.getInputStream();
					park_pic = new byte[part.getInputStream().available()];
					in.read(park_pic);
					in.close();
				} catch (Exception e) {
					park_pic = null;
					//errorMsgs.add("公園照片請上傳照片.");
				}
				java.sql.Date adp_start_date = null;
				try {
					adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
				} catch (IllegalArgumentException e) {
					adp_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date adp_upDate = null;
				try {
					adp_upDate = java.sql.Date.valueOf(req.getParameter("adp_upDate").trim());
				} catch (IllegalArgumentException e) {
					adp_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String adp_city = req.getParameter("adp_city").trim();
				String park_town = req.getParameter("park_town").trim();
				String park_road = req.getParameter("park_road").trim();
				Double park_lon = null;
				try {
					park_lon = new Double(req.getParameter("park_lon").trim());
				} catch (NumberFormatException e) {
					park_lon = 0.0;
					errorMsgs.add("公園經度座標請填數字.");
				}
				Double park_lat = null;
				try {
					park_lat = new Double(req.getParameter("park_lat").trim());
				} catch (NumberFormatException e) {
					park_lat = 0.0;
					errorMsgs.add("緯度座標緯度座標請填數字.");
				}

				//==== VO設定部分 ====			
				ParkVO parkVO = new ParkVO();
				parkVO.setPark_Id(park_Id);
				parkVO.setEmp_Id(emp_Id);
				parkVO.setPark_title(park_title);
				parkVO.setPark_content(park_content);
				parkVO.setPark_pic(park_pic);
				parkVO.setAdp_start_date(adp_start_date);
				parkVO.setAdp_upDate(adp_upDate);
				parkVO.setAdp_city(adp_city);
				parkVO.setPark_town(park_town);
				parkVO.setPark_road(park_road);
				parkVO.setPark_lon(park_lon);
				parkVO.setPark_lat(park_lat);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("parkVO", parkVO); // 含有輸入格式錯誤的parkVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/park/update_park_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				ParkService parkSvc = new ParkService();
				parkVO = parkSvc.updatePark(
					park_Id
					,emp_Id
					,park_title
					,park_content
					,park_pic
					,adp_start_date
					,adp_upDate
					,adp_city
					,park_town
					,park_road
					,park_lon
					,park_lat
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/park/listParks_ByEmp_No.jsp") 
					|| requestURL.equals("/back-end/park/listAllPark.jsp")){
					req.setAttribute("listParks_ByEmp_No",parkSvc.getParksByEmp_No(emp_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/park/listParks_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ParkVO> list  = parkSvc.getAll(map);
					req.setAttribute("listParks_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/park/update_park_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addPark.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String emp_Id = req.getParameter("emp_Id").trim();	

                String park_title = req.getParameter("park_title").trim();	

                String park_content = req.getParameter("park_content").trim();	

                byte[] park_pic = null;
                try {
                    Part part = req.getPart("park_pic");
                    InputStream in = part.getInputStream();
                    park_pic = new byte[part.getInputStream().available()];
                    in.read(park_pic);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("公園照片請上傳照片.");
                    //e.printStackTrace();
                    park_pic = null;
                }	
	
                java.sql.Date adp_start_date = null;
                try {
                    adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
                } catch (IllegalArgumentException e) {
                    adp_start_date=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }
	
                java.sql.Date adp_upDate = null;
                try {
                    adp_upDate = java.sql.Date.valueOf(req.getParameter("adp_upDate").trim());
                } catch (IllegalArgumentException e) {
                    adp_upDate=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                String adp_city = req.getParameter("adp_city").trim();	

                String park_town = req.getParameter("park_town").trim();	

                String park_road = req.getParameter("park_road").trim();	
	
                Double park_lon = null;
                try {
                    park_lon = new Double(req.getParameter("park_lon").trim());
                } catch (NumberFormatException e) {
                    park_lon = 0.0;
                    errorMsgs.add("公園經度座標請填數字.");
                    e.printStackTrace();
                }
	
                Double park_lat = null;
                try {
                    park_lat = new Double(req.getParameter("park_lat").trim());
                } catch (NumberFormatException e) {
                    park_lat = 0.0;
                    errorMsgs.add("緯度座標緯度座標請填數字.");
                    e.printStackTrace();
                }

                ParkVO parkVO = new ParkVO();
 
                parkVO.setEmp_Id(emp_Id);
 
                parkVO.setPark_title(park_title);
 
                parkVO.setPark_content(park_content);
 
                parkVO.setPark_pic(park_pic);
 
                parkVO.setAdp_start_date(adp_start_date);
 
                parkVO.setAdp_upDate(adp_upDate);
 
                parkVO.setAdp_city(adp_city);
 
                parkVO.setPark_town(park_town);
 
                parkVO.setPark_road(park_road);
 
                parkVO.setPark_lon(park_lon);
 
                parkVO.setPark_lat(park_lat);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("parkVO", parkVO); // 含有輸入格式錯誤的parkVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/park/addPark.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                ParkService parkSvc = new ParkService();
                parkVO = parkSvc.addPark(
	
                	emp_Id
	
                	,park_title
	
                	,park_content
	
                	,park_pic
	
                	,adp_start_date
	
                	,adp_upDate
	
                	,adp_city
	
                	,park_town
	
                	,park_road
	
                	,park_lon
	
                	,park_lat
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/park/listAllPark.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPark.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/park/addPark.jsp");
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
                String park_Id = new String(req.getParameter("park_Id"));

				/***************************2.開始刪除資料***************************************/
				ParkService parkSvc = new ParkService();

				ParkVO parkVO = parkSvc.getOnePark(park_Id);
				parkSvc.deletePark(park_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/park/listParks_ByEmp_No.jsp") 
					|| requestURL.equals("/back-end/park/listAllPark.jsp")){
					req.setAttribute("listParks_ByEmp_No",parkSvc.getParksByEmp_No(parkVO.getEmp_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/park/listParks_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ParkVO> list  = parkSvc.getAll(map);
					req.setAttribute("listParks_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listParks_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                ParkService parkSvc = new ParkService();
                List<ParkVO> list  = parkSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listParks_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/park/listParks_ByCompositeQuery.jsp"); // 成功轉交listParks_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 park/listAllPark.jsp的請求
        if ("listParks_ByEmp_No_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String emp_Id = new String(req.getParameter("emp_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                ParkService parkSvc = new ParkService();
                Set<ParkVO> set = parkSvc.getParksByEmp_No(emp_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listParks_ByEmp_No", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listParks_ByEmp_No_A".equals(action))
                    url = "/back-end/park/listParks_ByEmp_No.jsp";        // 成功轉交 park/listParks_ByEmp_No.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }











	}
}
