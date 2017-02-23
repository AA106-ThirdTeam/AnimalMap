package heibernate_com.anihome.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.anihome.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/anihome/anihome.do" })
public class AniHomeServlet extends HttpServlet {
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
			String str = req.getParameter("aniHome_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入動物之家編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/anihome/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String aniHome_Id = null;
			try {
				aniHome_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("動物之家編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/anihome/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			AniHomeService anihomeSvc = new AniHomeService();
			AniHomeVO anihomeVO = anihomeSvc.getOneAniHome(aniHome_Id);
			if (anihomeVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/anihome/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("anihomeVO", anihomeVO); // 資料庫取出的anihomeVO物件,存入req
			String url = "/Heibernate_back-end/anihome/listOneAniHome.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/anihome/select_page.jsp");
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
			String aniHome_Id = new String(req.getParameter("aniHome_Id"));
			/***************************2.開始查詢資料****************************************/
			AniHomeService anihomeSvc = new AniHomeService();
			AniHomeVO anihomeVO = anihomeSvc.getOneAniHome(aniHome_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("anihomeVO", anihomeVO); // 資料庫取出的anihomeVO物件,存入req
			String url = "/Heibernate_back-end/anihome/update_anihome_input.jsp";
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
				String aniHome_Id = req.getParameter("aniHome_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String aniHome_title = req.getParameter("aniHome_title").trim();
				String aniHome_content = req.getParameter("aniHome_content").trim();
				java.sql.Date aniHome_start_date = null;
				try {
					aniHome_start_date = java.sql.Date.valueOf(req.getParameter("aniHome_start_date").trim());
				} catch (IllegalArgumentException e) {
					aniHome_start_date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date aniHome_upDate = null;
				try {
					aniHome_upDate = java.sql.Date.valueOf(req.getParameter("aniHome_upDate").trim());
				} catch (IllegalArgumentException e) {
					aniHome_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String aniHome_city = req.getParameter("aniHome_city").trim();
				String aniHome_town = req.getParameter("aniHome_town").trim();
				String aniHome_road = req.getParameter("aniHome_road").trim();
				String aniHome_addr = req.getParameter("aniHome_addr").trim();
				Double aniHome_lon = null;
				try {
					aniHome_lon = new Double(req.getParameter("aniHome_lon").trim());
				} catch (NumberFormatException e) {
					aniHome_lon = 0.0;
					errorMsgs.add("動物之家經度座標請填數字.");
				}
				Double aniHome_lat = null;
				try {
					aniHome_lat = new Double(req.getParameter("aniHome_lat").trim());
				} catch (NumberFormatException e) {
					aniHome_lat = 0.0;
					errorMsgs.add("緯度座標緯度座標請填數字.");
				}
				String aniHome_pic = req.getParameter("aniHome_pic").trim();
			//==== VO設定部分 ====			
				AniHomeVO anihomeVO = new AniHomeVO();
				anihomeVO.setAniHome_Id(aniHome_Id);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				anihomeVO.setMemVO(memVO);
				anihomeVO.setAniHome_title(aniHome_title);
				anihomeVO.setAniHome_content(aniHome_content);
				anihomeVO.setAniHome_start_date(aniHome_start_date);
				anihomeVO.setAniHome_upDate(aniHome_upDate);
				anihomeVO.setAniHome_city(aniHome_city);
				anihomeVO.setAniHome_town(aniHome_town);
				anihomeVO.setAniHome_road(aniHome_road);
				anihomeVO.setAniHome_addr(aniHome_addr);
				anihomeVO.setAniHome_lon(aniHome_lon);
				anihomeVO.setAniHome_lat(aniHome_lat);
				anihomeVO.setAniHome_pic(aniHome_pic);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("anihomeVO", anihomeVO); // 含有輸入格式錯誤的anihomeVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/anihome/update_anihome_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			AniHomeService anihomeSvc = new AniHomeService();
			anihomeVO = anihomeSvc.updateAniHome(
					aniHome_Id
					,mem_Id
					,aniHome_title
					,aniHome_content
					,aniHome_start_date
					,aniHome_upDate
					,aniHome_city
					,aniHome_town
					,aniHome_road
					,aniHome_addr
					,aniHome_lon
					,aniHome_lat
					,aniHome_pic
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/anihome/listAniHomes_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/anihome/listAllAniHome.jsp")){
				//req.setAttribute("listAniHomes_ByMem_Id",anihomeSvc.getAniHomesByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/anihome/listAniHomes_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<AniHomeVO> list  = anihomeSvc.getAll(map);
				//req.setAttribute("listAniHomes_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/anihome/update_anihome_input.jsp");
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
               String mem_Id = req.getParameter("mem_Id").trim();	
               String aniHome_title = req.getParameter("aniHome_title").trim();	
               String aniHome_content = req.getParameter("aniHome_content").trim();	
               java.sql.Date aniHome_start_date = null;
               try {
                   aniHome_start_date = java.sql.Date.valueOf(req.getParameter("aniHome_start_date").trim());
               } catch (IllegalArgumentException e) {
                   aniHome_start_date=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date aniHome_upDate = null;
               try {
                   aniHome_upDate = java.sql.Date.valueOf(req.getParameter("aniHome_upDate").trim());
               } catch (IllegalArgumentException e) {
                   aniHome_upDate=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String aniHome_city = req.getParameter("aniHome_city").trim();	
               String aniHome_town = req.getParameter("aniHome_town").trim();	
               String aniHome_road = req.getParameter("aniHome_road").trim();	
               String aniHome_addr = req.getParameter("aniHome_addr").trim();	
               Double aniHome_lon = null;
               try {
                   aniHome_lon = new Double(req.getParameter("aniHome_lon").trim());
               } catch (NumberFormatException e) {
                   aniHome_lon = 0.0;
                   errorMsgs.add("動物之家經度座標請填數字.");
                   e.printStackTrace();
               }
               Double aniHome_lat = null;
               try {
                   aniHome_lat = new Double(req.getParameter("aniHome_lat").trim());
               } catch (NumberFormatException e) {
                   aniHome_lat = 0.0;
                   errorMsgs.add("緯度座標緯度座標請填數字.");
                   e.printStackTrace();
               }
               String aniHome_pic = req.getParameter("aniHome_pic").trim();	
               AniHomeVO anihomeVO = new AniHomeVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				anihomeVO.setMemVO(memVO);
				anihomeVO.setAniHome_title(aniHome_title);
				anihomeVO.setAniHome_content(aniHome_content);
				anihomeVO.setAniHome_start_date(aniHome_start_date);
				anihomeVO.setAniHome_upDate(aniHome_upDate);
				anihomeVO.setAniHome_city(aniHome_city);
				anihomeVO.setAniHome_town(aniHome_town);
				anihomeVO.setAniHome_road(aniHome_road);
				anihomeVO.setAniHome_addr(aniHome_addr);
				anihomeVO.setAniHome_lon(aniHome_lon);
				anihomeVO.setAniHome_lat(aniHome_lat);
				anihomeVO.setAniHome_pic(aniHome_pic);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("anihomeVO", anihomeVO); // 含有輸入格式錯誤的anihomeVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/anihome/addAniHome.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               AniHomeService anihomeSvc = new AniHomeService();
               anihomeVO = anihomeSvc.addAniHome(
               	mem_Id
               	,aniHome_title
               	,aniHome_content
               	,aniHome_start_date
               	,aniHome_upDate
               	,aniHome_city
               	,aniHome_town
               	,aniHome_road
               	,aniHome_addr
               	,aniHome_lon
               	,aniHome_lat
               	,aniHome_pic
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/anihome/listAllAniHome.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAniHome.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/anihome/addAniHome.jsp");
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
			String aniHome_Id = new String(req.getParameter("aniHome_Id"));
			/***************************2.開始刪除資料***************************************/
			AniHomeService anihomeSvc = new AniHomeService();
			AniHomeVO anihomeVO = anihomeSvc.getOneAniHome(aniHome_Id);
			anihomeSvc.deleteAniHome(aniHome_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listAniHomes_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listAniHomes_ByMem_Id",memSvc.getAniHomesByMem_Id(anihomeVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAniHomes_ByMem_Id",memSvc.getAniHomesByMem_Id(anihomeVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
