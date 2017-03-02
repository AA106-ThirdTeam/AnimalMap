package heibernate_com.orders.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.orders.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/orders/orders.do" })
public class OrdersServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllOrders.jsp 或  /dept/listOrderss_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_orders_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addOrders.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllOrders.jsp 或  /dept/listOrderss_ByDeptno.jsp的請求
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
			OrdersService ordersSvc = new OrdersService();
			List<OrdersVO> list  = ordersSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listOrderss_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			OrdersService ordersSvc = new OrdersService();
			List<OrdersVO> list  = ordersSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listOrderss_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/orders/listOrderss_ByCompositeQuery.jsp"); // 成功轉交listOrderss_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/orders/select_page.jsp");
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
			String str = req.getParameter("orders_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訂單編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/orders/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String orders_no = null;
			try {
				orders_no = new String(str);
			} catch (Exception e) {
				errorMsgs.add("訂單編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/orders/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			OrdersService ordersSvc = new OrdersService();
			OrdersVO ordersVO = ordersSvc.getOneOrders(orders_no);
			if (ordersVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/orders/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("ordersVO", ordersVO); // 資料庫取出的ordersVO物件,存入req
			String url = "/Heibernate_back-end/orders/listOneOrders.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneOrders.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/orders/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/orders/listAllOrders.jsp】 或  【/dept/listOrderss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String orders_no = new String(req.getParameter("orders_no"));
			/***************************2.開始查詢資料****************************************/
			OrdersService ordersSvc = new OrdersService();
			OrdersVO ordersVO = ordersSvc.getOneOrders(orders_no);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("ordersVO", ordersVO); // 資料庫取出的ordersVO物件,存入req
			String url = "/Heibernate_back-end/orders/update_orders_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_orders_input.jsp
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
				String orders_no = req.getParameter("orders_no").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String orders_receiver = req.getParameter("orders_receiver").trim();
				String post_no = req.getParameter("post_no").trim();
				String post_adp_city = req.getParameter("post_adp_city").trim();
				String post_town = req.getParameter("post_town").trim();
				String post_road = req.getParameter("post_road").trim();
				String orders_phone = req.getParameter("orders_phone").trim();
				Integer collect_mode_no = new Integer(req.getParameter("collect_mode_no").trim());
				java.sql.Timestamp orders_date = null;
				try {
					orders_date = java.sql.Timestamp.valueOf(req.getParameter("orders_date").trim());
				} catch (IllegalArgumentException e) {
					orders_date=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Timestamp orders_ship_date = null;
				try {
					orders_ship_date = java.sql.Timestamp.valueOf(req.getParameter("orders_ship_date").trim());
				} catch (IllegalArgumentException e) {
					orders_ship_date=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				Integer orders_total = new Integer(req.getParameter("orders_total").trim());
				Integer orders_status = new Integer(req.getParameter("orders_status").trim());
				Integer orders_credit = new Integer(req.getParameter("orders_credit").trim());
			//==== VO設定部分 ====			
				OrdersVO ordersVO = new OrdersVO();
				ordersVO.setOrders_no(orders_no);
				//以下3行程式碼因為要配合Hibernate的ordersVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				ordersVO.setMemVO(memVO);
				ordersVO.setOrders_receiver(orders_receiver);
				ordersVO.setPost_no(post_no);
				ordersVO.setPost_adp_city(post_adp_city);
				ordersVO.setPost_town(post_town);
				ordersVO.setPost_road(post_road);
				ordersVO.setOrders_phone(orders_phone);
				ordersVO.setCollect_mode_no(collect_mode_no);
				ordersVO.setOrders_date(orders_date);
				ordersVO.setOrders_ship_date(orders_ship_date);
				ordersVO.setOrders_total(orders_total);
				ordersVO.setOrders_status(orders_status);
				ordersVO.setOrders_credit(orders_credit);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("ordersVO", ordersVO); // 含有輸入格式錯誤的ordersVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/orders/update_orders_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			OrdersService ordersSvc = new OrdersService();
			ordersVO = ordersSvc.updateOrders(
					orders_no
					,mem_Id
					,orders_receiver
					,post_no
					,post_adp_city
					,post_town
					,post_road
					,orders_phone
					,collect_mode_no
					,orders_date
					,orders_ship_date
					,orders_total
					,orders_status
					,orders_credit
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/orders/listOrderss_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/orders/listAllOrders.jsp")){
				//req.setAttribute("listOrderss_ByMem_Id",ordersSvc.getOrderssByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/orders/listOrderss_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<OrdersVO> list  = ordersSvc.getAll(map);
				//req.setAttribute("listOrderss_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/orders/update_orders_input.jsp");
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
               String orders_receiver = req.getParameter("orders_receiver").trim();	
               String post_no = req.getParameter("post_no").trim();	
               String post_adp_city = req.getParameter("post_adp_city").trim();	
               String post_town = req.getParameter("post_town").trim();	
               String post_road = req.getParameter("post_road").trim();	
               String orders_phone = req.getParameter("orders_phone").trim();	
               Integer collect_mode_no = new Integer(req.getParameter("collect_mode_no").trim());	
               java.sql.Timestamp orders_date = null;
               try {
                   orders_date = java.sql.Timestamp.valueOf(req.getParameter("orders_date").trim());
               } catch (IllegalArgumentException e) {
                   orders_date=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Timestamp orders_ship_date = null;
               try {
                   orders_ship_date = java.sql.Timestamp.valueOf(req.getParameter("orders_ship_date").trim());
               } catch (IllegalArgumentException e) {
                   orders_ship_date=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Integer orders_total = new Integer(req.getParameter("orders_total").trim());	
               Integer orders_status = new Integer(req.getParameter("orders_status").trim());	
               Integer orders_credit = new Integer(req.getParameter("orders_credit").trim());	
               OrdersVO ordersVO = new OrdersVO();
				//以下3行程式碼因為要配合Hibernate的ordersVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				ordersVO.setMemVO(memVO);
				ordersVO.setOrders_receiver(orders_receiver);
				ordersVO.setPost_no(post_no);
				ordersVO.setPost_adp_city(post_adp_city);
				ordersVO.setPost_town(post_town);
				ordersVO.setPost_road(post_road);
				ordersVO.setOrders_phone(orders_phone);
				ordersVO.setCollect_mode_no(collect_mode_no);
				ordersVO.setOrders_date(orders_date);
				ordersVO.setOrders_ship_date(orders_ship_date);
				ordersVO.setOrders_total(orders_total);
				ordersVO.setOrders_status(orders_status);
				ordersVO.setOrders_credit(orders_credit);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("ordersVO", ordersVO); // 含有輸入格式錯誤的ordersVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/orders/addOrders.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               OrdersService ordersSvc = new OrdersService();
               ordersVO = ordersSvc.addOrders(
               	mem_Id
               	,orders_receiver
               	,post_no
               	,post_adp_city
               	,post_town
               	,post_road
               	,orders_phone
               	,collect_mode_no
               	,orders_date
               	,orders_ship_date
               	,orders_total
               	,orders_status
               	,orders_credit
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/orders/listAllOrders.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOrders.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/orders/addOrders.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/orders/listAllOrders.jsp】 或  【/dept/listOrderss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String orders_no = new String(req.getParameter("orders_no"));
			/***************************2.開始刪除資料***************************************/
			OrdersService ordersSvc = new OrdersService();
			OrdersVO ordersVO = ordersSvc.getOneOrders(orders_no);
			ordersSvc.deleteOrders(orders_no);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listOrderss_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listOrderss_ByMem_Id",memSvc.getOrderssByMem_Id(ordersVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listOrderss_ByMem_Id",memSvc.getOrderssByMem_Id(ordersVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
