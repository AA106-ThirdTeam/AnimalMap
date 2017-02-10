	

package com.pet_group.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;

import com.pet_group.model.*;
/** 
 *pet_group : <br>
 *	揪團<br>
 *	英文:pet_group<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/pet_group/pet_group.do" })
public class Pet_groupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Pet_group servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("grp_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("活動編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   grp_Id = null;
				try {
					grp_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("活動編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				Pet_groupService pet_groupSvc = new Pet_groupService();
				Pet_groupVO pet_groupVO = pet_groupSvc.getOnePet_group(grp_Id);
				
				if (pet_groupVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("pet_groupVO", pet_groupVO); 
				String url = "/back-end/pet_group/listOnePet_group.jsp";
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
				String grp_Id = new String(req.getParameter("grp_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				Pet_groupService pet_groupSvc = new Pet_groupService();
				Pet_groupVO pet_groupVO = pet_groupSvc.getOnePet_group(grp_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("pet_groupVO", pet_groupVO); 		
				String url = "/back-end/pet_group/update_pet_group_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_pet_group_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_pet_group_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String grp_Id = req.getParameter("grp_Id").trim();
				String grp_MemId = req.getParameter("grp_MemId").trim();
				String grp_name = req.getParameter("grp_name").trim();
				String grp_city = req.getParameter("grp_city").trim();
				String grp_Addr = req.getParameter("grp_Addr").trim();
				String grp_road = req.getParameter("grp_road").trim();
				String grp_StartTime = req.getParameter("grp_StartTime").trim();
				String grp_EndTime = req.getParameter("grp_EndTime").trim();
				String grp_Desc = req.getParameter("grp_Desc").trim();
				Double grp_Long = null;
				try {
					grp_Long = new Double(req.getParameter("grp_Long").trim());
				} catch (NumberFormatException e) {
					grp_Long = 0.0;
					errorMsgs.add("商家經度座標請填數字.");
				}
				Double grp_Lat = null;
				try {
					grp_Lat = new Double(req.getParameter("grp_Lat").trim());
				} catch (NumberFormatException e) {
					grp_Lat = 0.0;
					errorMsgs.add("商家緯度座標請填數字.");
				}
				java.sql.Date grp_CreateTime = null;
				try {
					grp_CreateTime = java.sql.Date.valueOf(req.getParameter("grp_CreateTime").trim());
				} catch (IllegalArgumentException e) {
					grp_CreateTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String grp_visible = req.getParameter("grp_visible").trim();
				byte[] grp_photo = null;
				try {
					Part part = req.getPart("grp_photo");
					InputStream in = part.getInputStream();
					grp_photo = new byte[part.getInputStream().available()];
					in.read(grp_photo);
					in.close();
				} catch (Exception e) {
					grp_photo = null;
					//errorMsgs.add("請上傳照片.");
				}

				//==== VO設定部分 ====			
				Pet_groupVO pet_groupVO = new Pet_groupVO();
				pet_groupVO.setGrp_Id(grp_Id);
				pet_groupVO.setGrp_MemId(grp_MemId);
				pet_groupVO.setGrp_name(grp_name);
				pet_groupVO.setGrp_city(grp_city);
				pet_groupVO.setGrp_Addr(grp_Addr);
				pet_groupVO.setGrp_road(grp_road);
				pet_groupVO.setGrp_StartTime(grp_StartTime);
				pet_groupVO.setGrp_EndTime(grp_EndTime);
				pet_groupVO.setGrp_Desc(grp_Desc);
				pet_groupVO.setGrp_Long(grp_Long);
				pet_groupVO.setGrp_Lat(grp_Lat);
				pet_groupVO.setGrp_CreateTime(grp_CreateTime);
				pet_groupVO.setGrp_visible(grp_visible);
				pet_groupVO.setGrp_photo(grp_photo);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("pet_groupVO", pet_groupVO); // 含有輸入格式錯誤的pet_groupVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/pet_group/update_pet_group_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				Pet_groupService pet_groupSvc = new Pet_groupService();
				pet_groupVO = pet_groupSvc.updatePet_group(
					grp_Id
					,grp_MemId
					,grp_name
					,grp_city
					,grp_Addr
					,grp_road
					,grp_StartTime
					,grp_EndTime
					,grp_Desc
					,grp_Long
					,grp_Lat
					,grp_CreateTime
					,grp_visible
					,grp_photo
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/pet_group/listPet_groups_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/pet_group/listAllPet_group.jsp")){
					req.setAttribute("listPet_groups_ByMem_Id",pet_groupSvc.getPet_groupsByMem_Id(grp_MemId)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/pet_group/listPet_groups_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Pet_groupVO> list  = pet_groupSvc.getAll(map);
					req.setAttribute("listPet_groups_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/pet_group/update_pet_group_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addPet_group.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String grp_MemId = req.getParameter("grp_MemId").trim();	

                String grp_name = req.getParameter("grp_name").trim();	

                String grp_city = req.getParameter("grp_city").trim();	

                String grp_Addr = req.getParameter("grp_Addr").trim();	

                String grp_road = req.getParameter("grp_road").trim();	

                String grp_StartTime = req.getParameter("grp_StartTime").trim();	

                String grp_EndTime = req.getParameter("grp_EndTime").trim();	

                String grp_Desc = req.getParameter("grp_Desc").trim();	
	
                Double grp_Long = null;
                try {
                    grp_Long = new Double(req.getParameter("grp_Long").trim());
                } catch (NumberFormatException e) {
                    grp_Long = 0.0;
                    errorMsgs.add("商家經度座標請填數字.");
                    e.printStackTrace();
                }
	
                Double grp_Lat = null;
                try {
                    grp_Lat = new Double(req.getParameter("grp_Lat").trim());
                } catch (NumberFormatException e) {
                    grp_Lat = 0.0;
                    errorMsgs.add("商家緯度座標請填數字.");
                    e.printStackTrace();
                }
	
                java.sql.Date grp_CreateTime = null;
                try {
                    grp_CreateTime = java.sql.Date.valueOf(req.getParameter("grp_CreateTime").trim());
                } catch (IllegalArgumentException e) {
                    grp_CreateTime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                String grp_visible = req.getParameter("grp_visible").trim();	

                byte[] grp_photo = null;
                try {
                    Part part = req.getPart("grp_photo");
                    InputStream in = part.getInputStream();
                    grp_photo = new byte[part.getInputStream().available()];
                    in.read(grp_photo);
                    in.close();
                } catch (Exception e) {
                    //errorMsgs.add("請上傳照片.");
                    //e.printStackTrace();
                    grp_photo = null;
                }	

                Pet_groupVO pet_groupVO = new Pet_groupVO();
 
                pet_groupVO.setGrp_MemId(grp_MemId);
 
                pet_groupVO.setGrp_name(grp_name);
 
                pet_groupVO.setGrp_city(grp_city);
 
                pet_groupVO.setGrp_Addr(grp_Addr);
 
                pet_groupVO.setGrp_road(grp_road);
 
                pet_groupVO.setGrp_StartTime(grp_StartTime);
 
                pet_groupVO.setGrp_EndTime(grp_EndTime);
 
                pet_groupVO.setGrp_Desc(grp_Desc);
 
                pet_groupVO.setGrp_Long(grp_Long);
 
                pet_groupVO.setGrp_Lat(grp_Lat);
 
                pet_groupVO.setGrp_CreateTime(grp_CreateTime);
 
                pet_groupVO.setGrp_visible(grp_visible);
 
                pet_groupVO.setGrp_photo(grp_photo);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("pet_groupVO", pet_groupVO); // 含有輸入格式錯誤的pet_groupVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/pet_group/addPet_group.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                Pet_groupService pet_groupSvc = new Pet_groupService();
                pet_groupVO = pet_groupSvc.addPet_group(
	
                	grp_MemId
	
                	,grp_name
	
                	,grp_city
	
                	,grp_Addr
	
                	,grp_road
	
                	,grp_StartTime
	
                	,grp_EndTime
	
                	,grp_Desc
	
                	,grp_Long
	
                	,grp_Lat
	
                	,grp_CreateTime
	
                	,grp_visible
	
                	,grp_photo
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/pet_group/listAllPet_group.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPet_group.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/pet_group/addPet_group.jsp");
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
                String grp_Id = new String(req.getParameter("grp_Id"));

				/***************************2.開始刪除資料***************************************/
				Pet_groupService pet_groupSvc = new Pet_groupService();

				Pet_groupVO pet_groupVO = pet_groupSvc.getOnePet_group(grp_Id);
				pet_groupSvc.deletePet_group(grp_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/pet_group/listPet_groups_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/pet_group/listAllPet_group.jsp")){
					req.setAttribute("listPet_groups_ByMem_Id",pet_groupSvc.getPet_groupsByMem_Id(pet_groupVO.getGrp_MemId())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/pet_group/listPet_groups_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Pet_groupVO> list  = pet_groupSvc.getAll(map);
					req.setAttribute("listPet_groups_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listPet_groups_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                Pet_groupService pet_groupSvc = new Pet_groupService();
                List<Pet_groupVO> list  = pet_groupSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listPet_groups_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/pet_group/listPet_groups_ByCompositeQuery.jsp"); // 成功轉交listPet_groups_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 pet_group/listAllPet_group.jsp的請求
        if ("listPet_groups_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String grp_MemId = new String(req.getParameter("grp_MemId"));

                /*************************** 2.開始查詢資料 ****************************************/
                Pet_groupService pet_groupSvc = new Pet_groupService();
                Set<Pet_groupVO> set = pet_groupSvc.getPet_groupsByMem_Id(grp_MemId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listPet_groups_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listPet_groups_ByMem_Id_A".equals(action))
                    url = "/back-end/pet_group/listPet_groups_ByMem_Id.jsp";        // 成功轉交 pet_group/listPet_groups_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }













	}
}
