	

package com.pet.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;

import com.pet.model.*;
/** 
 *pet : <br>
 *	自家寵物<br>
 *	英文:pet<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/pet/pet.do" })
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Pet servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("pet_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("寵物編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   pet_Id = null;
				try {
					pet_Id = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("寵物編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				PetService petSvc = new PetService();
				PetVO petVO = petSvc.getOnePet(pet_Id);
				
				if (petVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("petVO", petVO); 
				String url = "/back-end/pet/listOnePet.jsp";
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
				String pet_Id = new String(req.getParameter("pet_Id").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				PetService petSvc = new PetService();
				PetVO petVO = petSvc.getOnePet(pet_Id);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("petVO", petVO); 		
				String url = "/back-end/pet/update_pet_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_pet_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_pet_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String pet_Id = req.getParameter("pet_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String pet_name = req.getParameter("pet_name").trim();
				String pet_type = req.getParameter("pet_type").trim();
				String pet_gender = req.getParameter("pet_gender").trim();
				String pet_heal = req.getParameter("pet_heal").trim();
				String pet_Vac = req.getParameter("pet_Vac").trim();
				String pet_color = req.getParameter("pet_color").trim();
				String pet_body = req.getParameter("pet_body").trim();
				String pet_age = req.getParameter("pet_age").trim();
				String pet_Neu = req.getParameter("pet_Neu").trim();
				String pet_chip = req.getParameter("pet_chip").trim();
				java.sql.Date pet_birth = null;
				try {
					pet_birth = java.sql.Date.valueOf(req.getParameter("pet_birth").trim());
				} catch (IllegalArgumentException e) {
					pet_birth=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String pet_status = req.getParameter("pet_status").trim();
				java.sql.Date pet_CreDATE = null;
				try {
					pet_CreDATE = java.sql.Date.valueOf(req.getParameter("pet_CreDATE").trim());
				} catch (IllegalArgumentException e) {
					pet_CreDATE=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String pet_city = req.getParameter("pet_city").trim();
				String pet_town = req.getParameter("pet_town").trim();
				String pet_road = req.getParameter("pet_road").trim();
				Double pet_FinLat = null;
				try {
					pet_FinLat = new Double(req.getParameter("pet_FinLat").trim());
				} catch (NumberFormatException e) {
					pet_FinLat = 0.0;
					errorMsgs.add("送養地點經度請填數字.");
				}
				Double pet_FinLon = null;
				try {
					pet_FinLon = new Double(req.getParameter("pet_FinLon").trim());
				} catch (NumberFormatException e) {
					pet_FinLon = 0.0;
					errorMsgs.add("送養地點緯度請填數字.");
				}

				//==== VO設定部分 ====			
				PetVO petVO = new PetVO();
				petVO.setPet_Id(pet_Id);
				petVO.setMem_Id(mem_Id);
				petVO.setPet_name(pet_name);
				petVO.setPet_type(pet_type);
				petVO.setPet_gender(pet_gender);
				petVO.setPet_heal(pet_heal);
				petVO.setPet_Vac(pet_Vac);
				petVO.setPet_color(pet_color);
				petVO.setPet_body(pet_body);
				petVO.setPet_age(pet_age);
				petVO.setPet_Neu(pet_Neu);
				petVO.setPet_chip(pet_chip);
				petVO.setPet_birth(pet_birth);
				petVO.setPet_status(pet_status);
				petVO.setPet_CreDATE(pet_CreDATE);
				petVO.setPet_city(pet_city);
				petVO.setPet_town(pet_town);
				petVO.setPet_road(pet_road);
				petVO.setPet_FinLat(pet_FinLat);
				petVO.setPet_FinLon(pet_FinLon);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("petVO", petVO); // 含有輸入格式錯誤的petVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/pet/update_pet_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				PetService petSvc = new PetService();
				petVO = petSvc.updatePet(
					pet_Id
					,mem_Id
					,pet_name
					,pet_type
					,pet_gender
					,pet_heal
					,pet_Vac
					,pet_color
					,pet_body
					,pet_age
					,pet_Neu
					,pet_chip
					,pet_birth
					,pet_status
					,pet_CreDATE
					,pet_city
					,pet_town
					,pet_road
					,pet_FinLat
					,pet_FinLon
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/pet/listPets_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/pet/listAllPet.jsp")){
					req.setAttribute("listPets_ByMem_Id",petSvc.getPetsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/pet/listPets_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<PetVO> list  = petSvc.getAll(map);
					req.setAttribute("listPets_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/pet/update_pet_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addPet.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String mem_Id = req.getParameter("mem_Id").trim();	

                String pet_name = req.getParameter("pet_name").trim();	

                String pet_type = req.getParameter("pet_type").trim();	

                String pet_gender = req.getParameter("pet_gender").trim();	

                String pet_heal = req.getParameter("pet_heal").trim();	

                String pet_Vac = req.getParameter("pet_Vac").trim();	

                String pet_color = req.getParameter("pet_color").trim();	

                String pet_body = req.getParameter("pet_body").trim();	

                String pet_age = req.getParameter("pet_age").trim();	

                String pet_Neu = req.getParameter("pet_Neu").trim();	

                String pet_chip = req.getParameter("pet_chip").trim();	
	
                java.sql.Date pet_birth = null;
                try {
                    pet_birth = java.sql.Date.valueOf(req.getParameter("pet_birth").trim());
                } catch (IllegalArgumentException e) {
                    pet_birth=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                String pet_status = req.getParameter("pet_status").trim();	
	
                java.sql.Date pet_CreDATE = null;
                try {
                    pet_CreDATE = java.sql.Date.valueOf(req.getParameter("pet_CreDATE").trim());
                } catch (IllegalArgumentException e) {
                    pet_CreDATE=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                String pet_city = req.getParameter("pet_city").trim();	

                String pet_town = req.getParameter("pet_town").trim();	

                String pet_road = req.getParameter("pet_road").trim();	
	
                Double pet_FinLat = null;
                try {
                    pet_FinLat = new Double(req.getParameter("pet_FinLat").trim());
                } catch (NumberFormatException e) {
                    pet_FinLat = 0.0;
                    errorMsgs.add("送養地點經度請填數字.");
                    e.printStackTrace();
                }
	
                Double pet_FinLon = null;
                try {
                    pet_FinLon = new Double(req.getParameter("pet_FinLon").trim());
                } catch (NumberFormatException e) {
                    pet_FinLon = 0.0;
                    errorMsgs.add("送養地點緯度請填數字.");
                    e.printStackTrace();
                }

                PetVO petVO = new PetVO();
 
                petVO.setMem_Id(mem_Id);
 
                petVO.setPet_name(pet_name);
 
                petVO.setPet_type(pet_type);
 
                petVO.setPet_gender(pet_gender);
 
                petVO.setPet_heal(pet_heal);
 
                petVO.setPet_Vac(pet_Vac);
 
                petVO.setPet_color(pet_color);
 
                petVO.setPet_body(pet_body);
 
                petVO.setPet_age(pet_age);
 
                petVO.setPet_Neu(pet_Neu);
 
                petVO.setPet_chip(pet_chip);
 
                petVO.setPet_birth(pet_birth);
 
                petVO.setPet_status(pet_status);
 
                petVO.setPet_CreDATE(pet_CreDATE);
 
                petVO.setPet_city(pet_city);
 
                petVO.setPet_town(pet_town);
 
                petVO.setPet_road(pet_road);
 
                petVO.setPet_FinLat(pet_FinLat);
 
                petVO.setPet_FinLon(pet_FinLon);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("petVO", petVO); // 含有輸入格式錯誤的petVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/pet/addPet.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                PetService petSvc = new PetService();
                petVO = petSvc.addPet(
	
                	mem_Id
	
                	,pet_name
	
                	,pet_type
	
                	,pet_gender
	
                	,pet_heal
	
                	,pet_Vac
	
                	,pet_color
	
                	,pet_body
	
                	,pet_age
	
                	,pet_Neu
	
                	,pet_chip
	
                	,pet_birth
	
                	,pet_status
	
                	,pet_CreDATE
	
                	,pet_city
	
                	,pet_town
	
                	,pet_road
	
                	,pet_FinLat
	
                	,pet_FinLon
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/pet/listAllPet.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPet.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/pet/addPet.jsp");
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
                String pet_Id = new String(req.getParameter("pet_Id"));

				/***************************2.開始刪除資料***************************************/
				PetService petSvc = new PetService();

				PetVO petVO = petSvc.getOnePet(pet_Id);
				petSvc.deletePet(pet_Id);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/pet/listPets_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/pet/listAllPet.jsp")){
					req.setAttribute("listPets_ByMem_Id",petSvc.getPetsByMem_Id(petVO.getMem_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/pet/listPets_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<PetVO> list  = petSvc.getAll(map);
					req.setAttribute("listPets_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listPets_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                PetService petSvc = new PetService();
                List<PetVO> list  = petSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listPets_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/pet/listPets_ByCompositeQuery.jsp"); // 成功轉交listPets_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 pet/listAllPet.jsp的請求
        if ("listPets_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String mem_Id = new String(req.getParameter("mem_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                PetService petSvc = new PetService();
                Set<PetVO> set = petSvc.getPetsByMem_Id(mem_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listPets_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listPets_ByMem_Id_A".equals(action))
                    url = "/back-end/pet/listPets_ByMem_Id.jsp";        // 成功轉交 pet/listPets_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }



















	}
}
