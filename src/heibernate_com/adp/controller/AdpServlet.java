package heibernate_com.adp.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.adp.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/adp/adp.do" })
public class AdpServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllAdp.jsp 或  /dept/listAdps_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_adp_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addAdp.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllAdp.jsp 或  /dept/listAdps_ByDeptno.jsp的請求
			delete(req, res);
		}
		if ("list_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
			list_ByCompositeQuery(req, res,false);//預設複合查詢有Like
		}	
	}
	//===========================================【前端 - list_ByCompositeQuery】================================================ 		
	public void front_end_list_ByCompositeQuery(HttpServletRequest req, HttpServletResponse res,boolean ableLike)throws ServletException, IOException {
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
			AdpService adpSvc = new AdpService();
			List<AdpVO> list  = adpSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listAdps_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
		}
	}	
	public void list_ByCompositeQuery(HttpServletRequest req, HttpServletResponse res,boolean ableLike)throws ServletException, IOException {
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
			AdpService adpSvc = new AdpService();
			List<AdpVO> list  = adpSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listAdps_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/adp/listAdps_ByCompositeQuery.jsp"); // 成功轉交listAdps_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adp/select_page.jsp");
			failureView.forward(req, res);
		}
	}
	public void getOne_For_Display(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("adp_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入領養活動編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adp/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String adp_Id = null;
			try {
				adp_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("領養活動編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adp/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			AdpService adpSvc = new AdpService();
			AdpVO adpVO = adpSvc.getOneAdp(adp_Id);
			if (adpVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adp/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("adpVO", adpVO); // 資料庫取出的adpVO物件,存入req
			String url = "/Heibernate_back-end/adp/listOneAdp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneAdp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adp/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/adp/listAllAdp.jsp】 或  【/dept/listAdps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String adp_Id = new String(req.getParameter("adp_Id"));
			/***************************2.開始查詢資料****************************************/
			AdpService adpSvc = new AdpService();
			AdpVO adpVO = adpSvc.getOneAdp(adp_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("adpVO", adpVO); // 資料庫取出的adpVO物件,存入req
			String url = "/Heibernate_back-end/adp/update_adp_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_adp_input.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher(requestURL);
			failureView.forward(req, res);
		}		
	}
	public void update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			//==== getParameter設定 ====
				String adp_Id = req.getParameter("adp_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String adp_title = req.getParameter("adp_title").trim();
				String adp_adp_content = req.getParameter("adp_adp_content").trim();
				java.sql.Date adp_start_date = null;
				try {
					adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
				} catch (IllegalArgumentException e) {
					adp_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date adp_end_date = null;
				try {
					adp_end_date = java.sql.Date.valueOf(req.getParameter("adp_end_date").trim());
				} catch (IllegalArgumentException e) {
					adp_end_date=new java.sql.Date(System.currentTimeMillis());
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
				String adp_town = req.getParameter("adp_town").trim();
				String adp_road = req.getParameter("adp_road").trim();
				Double adp_lon = null;
				try {
					adp_lon = new Double(req.getParameter("adp_lon").trim());
				} catch (NumberFormatException e) {
					adp_lon = 0.0;
					errorMsgs.add("領養活動經度座標請填數字.");
				}
				Double adp_lat = null;
				try {
					adp_lat = new Double(req.getParameter("adp_lat").trim());
				} catch (NumberFormatException e) {
					adp_lat = 0.0;
					errorMsgs.add("緯度座標緯度座標請填數字.");
				}
			//==== VO設定部分 ====			
				AdpVO adpVO = new AdpVO();
				adpVO.setAdp_Id(adp_Id);
				//以下3行程式碼因為要配合Hibernate的adpVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				adpVO.setMemVO(memVO);
				adpVO.setAdp_title(adp_title);
				adpVO.setAdp_adp_content(adp_adp_content);
				adpVO.setAdp_start_date(adp_start_date);
				adpVO.setAdp_end_date(adp_end_date);
				adpVO.setAdp_upDate(adp_upDate);
				adpVO.setAdp_city(adp_city);
				adpVO.setAdp_town(adp_town);
				adpVO.setAdp_road(adp_road);
				adpVO.setAdp_lon(adp_lon);
				adpVO.setAdp_lat(adp_lat);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adpVO", adpVO); // 含有輸入格式錯誤的adpVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adp/update_adp_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			AdpService adpSvc = new AdpService();
			adpVO = adpSvc.updateAdp(
					adp_Id
					,mem_Id
					,adp_title
					,adp_adp_content
					,adp_start_date
					,adp_end_date
					,adp_upDate
					,adp_city
					,adp_town
					,adp_road
					,adp_lon
					,adp_lat
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/adp/listAdps_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adp/listAllAdp.jsp")){
				//req.setAttribute("listAdps_ByMem_Id",adpSvc.getAdpsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adp/listAdps_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<AdpVO> list  = adpSvc.getAll(map);
				//req.setAttribute("listAdps_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adp/update_adp_input.jsp");
			failureView.forward(req, res);
		}
	}
	public void insert(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
               String mem_Id = req.getParameter("mem_Id").trim();	
               String adp_title = req.getParameter("adp_title").trim();	
               String adp_adp_content = req.getParameter("adp_adp_content").trim();	
               java.sql.Date adp_start_date = null;
               try {
                   adp_start_date = java.sql.Date.valueOf(req.getParameter("adp_start_date").trim());
               } catch (IllegalArgumentException e) {
                   adp_start_date=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date adp_end_date = null;
               try {
                   adp_end_date = java.sql.Date.valueOf(req.getParameter("adp_end_date").trim());
               } catch (IllegalArgumentException e) {
                   adp_end_date=new java.sql.Date(System.currentTimeMillis());
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
               String adp_town = req.getParameter("adp_town").trim();	
               String adp_road = req.getParameter("adp_road").trim();	
               Double adp_lon = null;
               try {
                   adp_lon = new Double(req.getParameter("adp_lon").trim());
               } catch (NumberFormatException e) {
                   adp_lon = 0.0;
                   errorMsgs.add("領養活動經度座標請填數字.");
                   e.printStackTrace();
               }
               Double adp_lat = null;
               try {
                   adp_lat = new Double(req.getParameter("adp_lat").trim());
               } catch (NumberFormatException e) {
                   adp_lat = 0.0;
                   errorMsgs.add("緯度座標緯度座標請填數字.");
                   e.printStackTrace();
               }
               AdpVO adpVO = new AdpVO();
				//以下3行程式碼因為要配合Hibernate的adpVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				adpVO.setMemVO(memVO);
				adpVO.setAdp_title(adp_title);
				adpVO.setAdp_adp_content(adp_adp_content);
				adpVO.setAdp_start_date(adp_start_date);
				adpVO.setAdp_end_date(adp_end_date);
				adpVO.setAdp_upDate(adp_upDate);
				adpVO.setAdp_city(adp_city);
				adpVO.setAdp_town(adp_town);
				adpVO.setAdp_road(adp_road);
				adpVO.setAdp_lon(adp_lon);
				adpVO.setAdp_lat(adp_lat);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("adpVO", adpVO); // 含有輸入格式錯誤的adpVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/adp/addAdp.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               AdpService adpSvc = new AdpService();
               adpVO = adpSvc.addAdp(
               	mem_Id
               	,adp_title
               	,adp_adp_content
               	,adp_start_date
               	,adp_end_date
               	,adp_upDate
               	,adp_city
               	,adp_town
               	,adp_road
               	,adp_lon
               	,adp_lat
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/adp/listAllAdp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdp.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adp/addAdp.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/adp/listAllAdp.jsp】 或  【/dept/listAdps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String adp_Id = new String(req.getParameter("adp_Id"));
			/***************************2.開始刪除資料***************************************/
			AdpService adpSvc = new AdpService();
			AdpVO adpVO = adpSvc.getOneAdp(adp_Id);
			adpSvc.deleteAdp(adp_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listAdps_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listAdps_ByMem_Id",memSvc.getAdpsByMem_Id(adpVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdps_ByMem_Id",memSvc.getAdpsByMem_Id(adpVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
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
}
