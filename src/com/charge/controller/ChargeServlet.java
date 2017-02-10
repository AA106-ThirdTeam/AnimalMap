	

package com.charge.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mem.model.*;

import com.charge.model.*;
/** 
 *charge : <br>
 *	儲值<br>
 *	英文:charge<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/charge/charge.do" })
public class ChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Charge servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("charge_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("儲值編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   charge_no = null;
				try {
					charge_no = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("儲值編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				ChargeService chargeSvc = new ChargeService();
				ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);
				
				if (chargeVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("chargeVO", chargeVO); 
				String url = "/back-end/charge/listOneCharge.jsp";
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
				String charge_no = new String(req.getParameter("charge_no").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				ChargeService chargeSvc = new ChargeService();
				ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("chargeVO", chargeVO); 		
				String url = "/back-end/charge/update_charge_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_charge_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_charge_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String charge_no = req.getParameter("charge_no").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				Integer charge_NUMBER = new Integer(req.getParameter("charge_NUMBER").trim());
				Integer pay = new Integer(req.getParameter("pay").trim());
				java.sql.Date applytime = null;
				try {
					applytime = java.sql.Date.valueOf(req.getParameter("applytime").trim());
				} catch (IllegalArgumentException e) {
					applytime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				//==== VO設定部分 ====			
				ChargeVO chargeVO = new ChargeVO();
				chargeVO.setCharge_no(charge_no);
				chargeVO.setMem_Id(mem_Id);
				chargeVO.setCharge_NUMBER(charge_NUMBER);
				chargeVO.setPay(pay);
				chargeVO.setApplytime(applytime);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("chargeVO", chargeVO); // 含有輸入格式錯誤的chargeVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/charge/update_charge_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				ChargeService chargeSvc = new ChargeService();
				chargeVO = chargeSvc.updateCharge(
					charge_no
					,mem_Id
					,charge_NUMBER
					,pay
					,applytime
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/charge/listCharges_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/charge/listAllCharge.jsp")){
					req.setAttribute("listCharges_ByMem_Id",chargeSvc.getChargesByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/charge/listCharges_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ChargeVO> list  = chargeSvc.getAll(map);
					req.setAttribute("listCharges_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/charge/update_charge_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addCharge.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String mem_Id = req.getParameter("mem_Id").trim();	

                Integer charge_NUMBER = new Integer(req.getParameter("charge_NUMBER").trim());	

                Integer pay = new Integer(req.getParameter("pay").trim());	
	
                java.sql.Date applytime = null;
                try {
                    applytime = java.sql.Date.valueOf(req.getParameter("applytime").trim());
                } catch (IllegalArgumentException e) {
                    applytime=new java.sql.Date(System.currentTimeMillis());
                    errorMsgs.add("請輸入日期!");
                    e.printStackTrace();
                }

                ChargeVO chargeVO = new ChargeVO();
 
                chargeVO.setMem_Id(mem_Id);
 
                chargeVO.setCharge_NUMBER(charge_NUMBER);
 
                chargeVO.setPay(pay);
 
                chargeVO.setApplytime(applytime);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("chargeVO", chargeVO); // 含有輸入格式錯誤的chargeVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/charge/addCharge.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                ChargeService chargeSvc = new ChargeService();
                chargeVO = chargeSvc.addCharge(
	
                	mem_Id
	
                	,charge_NUMBER
	
                	,pay
	
                	,applytime
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/charge/listAllCharge.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllCharge.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/charge/addCharge.jsp");
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
                String charge_no = new String(req.getParameter("charge_no"));

				/***************************2.開始刪除資料***************************************/
				ChargeService chargeSvc = new ChargeService();

				ChargeVO chargeVO = chargeSvc.getOneCharge(charge_no);
				chargeSvc.deleteCharge(charge_no);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/charge/listCharges_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/charge/listAllCharge.jsp")){
					req.setAttribute("listCharges_ByMem_Id",chargeSvc.getChargesByMem_Id(chargeVO.getMem_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/charge/listCharges_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<ChargeVO> list  = chargeSvc.getAll(map);
					req.setAttribute("listCharges_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listCharges_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                ChargeService chargeSvc = new ChargeService();
                List<ChargeVO> list  = chargeSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listCharges_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/charge/listCharges_ByCompositeQuery.jsp"); // 成功轉交listCharges_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 charge/listAllCharge.jsp的請求
        if ("listCharges_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String mem_Id = new String(req.getParameter("mem_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                ChargeService chargeSvc = new ChargeService();
                Set<ChargeVO> set = chargeSvc.getChargesByMem_Id(mem_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listCharges_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listCharges_ByMem_Id_A".equals(action))
                    url = "/back-end/charge/listCharges_ByMem_Id.jsp";        // 成功轉交 charge/listCharges_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }




	}
}
