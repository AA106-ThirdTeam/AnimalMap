package heibernate_com.stray_ani_loc.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.stray_ani.model.Stray_AniVO;
import heibernate_com.stray_ani.model.Stray_AniService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.stray_ani_loc.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/stray_ani_loc/stray_ani_loc.do" })
public class Stray_Ani_LocServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp的請求
			delete(req, res);
		}
	}
	private void getOne_For_Display(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("str_Ani_Loc_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入流浪動物出沒編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/stray_ani_loc/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String str_Ani_Loc_No = null;
			try {
				str_Ani_Loc_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("流浪動物出沒編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/stray_ani_loc/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
			Stray_Ani_LocVO stray_ani_locVO = stray_ani_locSvc.getOneStray_Ani_Loc(str_Ani_Loc_No);
			if (stray_ani_locVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/stray_ani_loc/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("stray_ani_locVO", stray_ani_locVO); // 資料庫取出的stray_ani_locVO物件,存入req
			String url = "/Heibernate_back-end/stray_ani_loc/listOneStray_Ani_Loc.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/stray_ani_loc/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	private void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String str_Ani_Loc_No = new String(req.getParameter("str_Ani_Loc_No"));
			/***************************2.開始查詢資料****************************************/
			Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
			Stray_Ani_LocVO stray_ani_locVO = stray_ani_locSvc.getOneStray_Ani_Loc(str_Ani_Loc_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("stray_ani_locVO", stray_ani_locVO); // 資料庫取出的stray_ani_locVO物件,存入req
			String url = "/Heibernate_back-end/stray_ani_loc/update_stray_ani_loc_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emp_input.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher(requestURL);
			failureView.forward(req, res);
		}		
	}
	private void update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			//==== getParameter設定 ====
				String str_Ani_Loc_No = req.getParameter("str_Ani_Loc_No").trim();
				String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				Double str_Ani_LocLat = null;
				try {
					str_Ani_LocLat = new Double(req.getParameter("str_Ani_LocLat").trim());
				} catch (NumberFormatException e) {
					str_Ani_LocLat = 0.0;
					errorMsgs.add("送養地點經度請填數字.");
				}
				Double str_Ani_LocLon = null;
				try {
					str_Ani_LocLon = new Double(req.getParameter("str_Ani_LocLon").trim());
				} catch (NumberFormatException e) {
					str_Ani_LocLon = 0.0;
					errorMsgs.add("送養地點緯度請填數字.");
				}
			//==== VO設定部分 ====			
				Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
				stray_ani_locVO.setStr_Ani_Loc_No(str_Ani_Loc_No);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Stray_AniVO stray_aniVO = new Stray_AniVO();
				stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
				stray_ani_locVO.setStray_AniVO(stray_aniVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				stray_ani_locVO.setMemVO(memVO);
				stray_ani_locVO.setStr_Ani_LocLat(str_Ani_LocLat);
				stray_ani_locVO.setStr_Ani_LocLon(str_Ani_LocLon);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("stray_ani_locVO", stray_ani_locVO); // 含有輸入格式錯誤的stray_ani_locVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/stray_ani_loc/update_stray_ani_loc_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
			stray_ani_locVO = stray_ani_locSvc.updateStray_Ani_Loc(
					str_Ani_Loc_No
					,stray_Ani_Id
					,mem_Id
					,str_Ani_LocLat
					,str_Ani_LocLon
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/stray_ani_loc/listStray_Ani_Locs_ByStray_Ani_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/stray_ani_loc/listAllStray_Ani_Loc.jsp")){
				//req.setAttribute("listStray_Ani_Locs_ByStray_Ani_Id",stray_ani_locSvc.getStray_Ani_LocsByStray_Ani_Id(stray_Ani_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/stray_ani_loc/listStray_Ani_Locs_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/stray_ani_loc/listAllStray_Ani_Loc.jsp")){
				//req.setAttribute("listStray_Ani_Locs_ByMem_Id",stray_ani_locSvc.getStray_Ani_LocsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/stray_ani_loc/listStray_Ani_Locs_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Stray_Ani_LocVO> list  = stray_ani_locSvc.getAll(map);
				//req.setAttribute("listStray_Ani_Locs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/stray_ani_loc/update_stray_ani_loc_input.jsp");
			failureView.forward(req, res);
		}
	}
	private void insert(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
               String stray_Ani_Id = req.getParameter("stray_Ani_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               Double str_Ani_LocLat = null;
               try {
                   str_Ani_LocLat = new Double(req.getParameter("str_Ani_LocLat").trim());
               } catch (NumberFormatException e) {
                   str_Ani_LocLat = 0.0;
                   errorMsgs.add("送養地點經度請填數字.");
                   e.printStackTrace();
               }
               Double str_Ani_LocLon = null;
               try {
                   str_Ani_LocLon = new Double(req.getParameter("str_Ani_LocLon").trim());
               } catch (NumberFormatException e) {
                   str_Ani_LocLon = 0.0;
                   errorMsgs.add("送養地點緯度請填數字.");
                   e.printStackTrace();
               }
               Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Stray_AniVO stray_aniVO = new Stray_AniVO();
				stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
				stray_ani_locVO.setStray_AniVO(stray_aniVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				stray_ani_locVO.setMemVO(memVO);
				stray_ani_locVO.setStr_Ani_LocLat(str_Ani_LocLat);
				stray_ani_locVO.setStr_Ani_LocLon(str_Ani_LocLon);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("stray_ani_locVO", stray_ani_locVO); // 含有輸入格式錯誤的stray_ani_locVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/stray_ani_loc/addStray_Ani_Loc.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
               stray_ani_locVO = stray_ani_locSvc.addStray_Ani_Loc(
               	stray_Ani_Id
               	,mem_Id
               	,str_Ani_LocLat
               	,str_Ani_LocLon
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/stray_ani_loc/listAllStray_Ani_Loc.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllStray_Ani_Loc.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/stray_ani_loc/addStray_Ani_Loc.jsp");
			failureView.forward(req, res);
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String str_Ani_Loc_No = new String(req.getParameter("str_Ani_Loc_No"));
			/***************************2.開始刪除資料***************************************/
			Stray_Ani_LocService stray_ani_locSvc = new Stray_Ani_LocService();
			Stray_Ani_LocVO stray_ani_locVO = stray_ani_locSvc.getOneStray_Ani_Loc(str_Ani_Loc_No);
			stray_ani_locSvc.deleteStray_Ani_Loc(str_Ani_Loc_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			Stray_AniService stray_aniSvc = new Stray_AniService();
			if(requestURL.equals("/stray_ani/listStray_Ani_Locs_ByStray_Ani_Id.jsp") || requestURL.equals("/stray_ani/listAllStray_Ani.jsp")){
			  //req.setAttribute("listStray_Ani_Locs_ByStray_Ani_Id",stray_aniSvc.getStray_Ani_LocsByStray_Ani_Id(stray_ani_locVO.getStray_Ani_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listStray_Ani_Locs_ByStray_Ani_Id",stray_aniSvc.getStray_Ani_LocsByStray_Ani_Id(stray_ani_locVO.getStray_AniVO().getStray_Ani_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listStray_Ani_Locs_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listStray_Ani_Locs_ByMem_Id",memSvc.getStray_Ani_LocsByMem_Id(stray_ani_locVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listStray_Ani_Locs_ByMem_Id",memSvc.getStray_Ani_LocsByMem_Id(stray_ani_locVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
