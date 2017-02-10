	

package com.adoanispo.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.adopt_ani.model.*;

import com.mem.model.*;

import com.adoanispo.model.*;
/** 
 *adoAniSpo : <br>
 *	送養動物領養人<br>
 *	英文:adoAniSpo<br>
 */ 
@WebServlet(urlPatterns = { "/back-end/adoanispo/adoanispo.do" })
public class AdoAniSpoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("AdoAniSpo servlet運行成功 ");
	


		//====getOne_For_Display====
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);		

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("adoAniSpoNo");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("送養動物贊助編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				String   adoAniSpoNo = null;
				try {
					adoAniSpoNo = new String  (str);
				} catch (Exception e) {
					errorMsgs.add("送養動物贊助編號格式不正確");				
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************2.開始查詢資料*****************************************/
	
				AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
				AdoAniSpoVO adoanispoVO = adoanispoSvc.getOneAdoAniSpo(adoAniSpoNo);
				
				if (adoanispoVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adoanispoVO", adoanispoVO); 
				String url = "/back-end/adoanispo/listOneAdoAniSpo.jsp";
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
				String adoAniSpoNo = new String(req.getParameter("adoAniSpoNo").trim());	
				
				/***************************2.開始查詢資料*****************************************/	
	
				AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
				AdoAniSpoVO adoanispoVO = adoanispoSvc.getOneAdoAniSpo(adoAniSpoNo);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adoanispoVO", adoanispoVO); 		
				String url = "/back-end/adoanispo/update_adoanispo_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_adoanispo_input.jsp
				successView.forward(req, res);
					
				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}	
		}													


    
		if ("update".equals(action)) { // 來自update_adoAniSpo_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				//==== getParameter設定 ====
				String adoAniSpoNo = req.getParameter("adoAniSpoNo").trim();
				String adoAniSpoAniId = req.getParameter("adoAniSpoAniId").trim();
				String adoAniSpomem_Id = req.getParameter("adoAniSpomem_Id").trim();
				Integer adoAniSpoMoney = new Integer(req.getParameter("adoAniSpoMoney").trim());
				String adoAniSpoMat = req.getParameter("adoAniSpoMat").trim();

				//==== VO設定部分 ====			
				AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();
				adoanispoVO.setAdoAniSpoNo(adoAniSpoNo);
				adoanispoVO.setAdoAniSpoAniId(adoAniSpoAniId);
				adoanispoVO.setAdoAniSpomem_Id(adoAniSpomem_Id);
				adoanispoVO.setAdoAniSpoMoney(adoAniSpoMoney);
				adoanispoVO.setAdoAniSpoMat(adoAniSpoMat);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("adoanispoVO", adoanispoVO); // 含有輸入格式錯誤的adoanispoVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/adoanispo/update_adoanispo_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/

				AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
				adoanispoVO = adoanispoSvc.updateAdoAniSpo(
					adoAniSpoNo
					,adoAniSpoAniId
					,adoAniSpomem_Id
					,adoAniSpoMoney
					,adoAniSpoMat
				);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				

				if(requestURL.equals("/back-end/adoanispo/listAdoAniSpos_ByAdopt_Ani_Id.jsp") 
					|| requestURL.equals("/back-end/adoanispo/listAllAdoAniSpo.jsp")){
					req.setAttribute("listAdoAniSpos_ByAdopt_Ani_Id",adoanispoSvc.getAdoAniSposByAdopt_Ani_Id(adoAniSpoAniId)); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/adoanispo/listAdoAniSpos_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/adoanispo/listAllAdoAniSpo.jsp")){
					req.setAttribute("listAdoAniSpos_ByMem_Id",adoanispoSvc.getAdoAniSposByMem_Id(adoAniSpomem_Id)); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/adoanispo/listAdoAniSpos_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<AdoAniSpoVO> list  = adoanispoSvc.getAll(map);
					req.setAttribute("listAdoAniSpos_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/adoanispo/update_adoanispo_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	
        if ("insert".equals(action)) { // 來自addAdoAniSpo.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

                String adoAniSpoAniId = req.getParameter("adoAniSpoAniId").trim();	

                String adoAniSpomem_Id = req.getParameter("adoAniSpomem_Id").trim();	

                Integer adoAniSpoMoney = new Integer(req.getParameter("adoAniSpoMoney").trim());	

                String adoAniSpoMat = req.getParameter("adoAniSpoMat").trim();	

                AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();
 
                adoanispoVO.setAdoAniSpoAniId(adoAniSpoAniId);
 
                adoanispoVO.setAdoAniSpomem_Id(adoAniSpomem_Id);
 
                adoanispoVO.setAdoAniSpoMoney(adoAniSpoMoney);
 
                adoanispoVO.setAdoAniSpoMat(adoAniSpoMat);
               
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("adoanispoVO", adoanispoVO); // 含有輸入格式錯誤的adoanispoVO物件,也存入req
                    RequestDispatcher failureView = req.getRequestDispatcher("/back-end/adoanispo/addAdoAniSpo.jsp");
                    failureView.forward(req, res);
                    return;
                }
                
                /***************************2.開始新增資料***************************************/
                AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
                adoanispoVO = adoanispoSvc.addAdoAniSpo(
	
                	adoAniSpoAniId
	
                	,adoAniSpomem_Id
	
                	,adoAniSpoMoney
	
                	,adoAniSpoMat
 
                ); 
                     
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/adoanispo/listAllAdoAniSpo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdoAniSpo.jsp
				successView.forward(req, res);				
				
			/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/adoanispo/addAdoAniSpo.jsp");
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
                String adoAniSpoNo = new String(req.getParameter("adoAniSpoNo"));

				/***************************2.開始刪除資料***************************************/
				AdoAniSpoService adoanispoSvc = new AdoAniSpoService();

				AdoAniSpoVO adoanispoVO = adoanispoSvc.getOneAdoAniSpo(adoAniSpoNo);
				adoanispoSvc.deleteAdoAniSpo(adoAniSpoNo);
				
				
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/

				if(requestURL.equals("/back-end/adoanispo/listAdoAniSpos_ByAdopt_Ani_Id.jsp") 
					|| requestURL.equals("/back-end/adoanispo/listAllAdoAniSpo.jsp")){
					req.setAttribute("listAdoAniSpos_ByAdopt_Ani_Id",adoanispoSvc.getAdoAniSposByAdopt_Ani_Id(adoanispoVO.getAdoAniSpoAniId())); // 資料庫取出的list物件,存入request
				}

				if(requestURL.equals("/back-end/adoanispo/listAdoAniSpos_ByMem_Id.jsp") 
					|| requestURL.equals("/back-end/adoanispo/listAllAdoAniSpo.jsp")){
					req.setAttribute("listAdoAniSpos_ByMem_Id",adoanispoSvc.getAdoAniSposByMem_Id(adoanispoVO.getAdoAniSpomem_Id())); // 資料庫取出的list物件,存入request
				}
				
				
				if(requestURL.equals("/back-end/adoanispo/listAdoAniSpos_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<AdoAniSpoVO> list  = adoanispoSvc.getAll(map);
					req.setAttribute("listAdoAniSpos_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
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
		
		
	
        if ("listAdoAniSpos_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
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
                AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
                List<AdoAniSpoVO> list  = adoanispoSvc.getAll(map);
                
                /***************************3.查詢完成,準備轉交(Send the Success view)************/
                req.setAttribute("listAdoAniSpos_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
                RequestDispatcher successView = req.getRequestDispatcher("/back-end/adoanispo/listAdoAniSpos_ByCompositeQuery.jsp"); // 成功轉交listAdoAniSpos_ByCompositeQuery.jsp
                successView.forward(req, res);
                
                /***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
                errorMsgs.add(e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }
	


        // 來自select_page.jsp的請求                                  // 來自 adoanispo/listAllAdoAniSpo.jsp的請求
        if ("listAdoAniSpos_ByAdopt_Ani_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String adoAniSpoAniId = new String(req.getParameter("adoAniSpoAniId"));

                /*************************** 2.開始查詢資料 ****************************************/
                AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
                Set<AdoAniSpoVO> set = adoanispoSvc.getAdoAniSposByAdopt_Ani_Id(adoAniSpoAniId);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listAdoAniSpos_ByAdopt_Ani_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listAdoAniSpos_ByAdopt_Ani_Id_A".equals(action))
                    url = "/back-end/adoanispo/listAdoAniSpos_ByAdopt_Ani_Id.jsp";        // 成功轉交 adoanispo/listAdoAniSpos_ByAdopt_Ani_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }


        // 來自select_page.jsp的請求                                  // 來自 adoanispo/listAllAdoAniSpo.jsp的請求
        if ("listAdoAniSpos_ByMem_Id_A".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);
            try {
                /*************************** 1.接收請求參數 ****************************************/
                String adoAniSpomem_Id = new String(req.getParameter("adoAniSpomem_Id"));

                /*************************** 2.開始查詢資料 ****************************************/
                AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
                Set<AdoAniSpoVO> set = adoanispoSvc.getAdoAniSposByMem_Id(adoAniSpomem_Id);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("listAdoAniSpos_ByMem_Id", set);    // 資料庫取出的list物件,存入request

                String url = null;
                if ("listAdoAniSpos_ByMem_Id_A".equals(action))
                    url = "/back-end/adoanispo/listAdoAniSpos_ByMem_Id.jsp";        // 成功轉交 adoanispo/listAdoAniSpos_ByMem_Id.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** 其他可能的錯誤處理 ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }



	}
}
