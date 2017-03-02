package heibernate_com.orders_item.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.orders.model.OrdersVO;
import heibernate_com.orders.model.OrdersService;
import heibernate_com.product.model.ProductVO;
import heibernate_com.product.model.ProductService;
import heibernate_com.orders_item.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/orders_item/orders_item.do" })
public class Orders_itemServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllOrders_item.jsp 或  /dept/listOrders_items_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_orders_item_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addOrders_item.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllOrders_item.jsp 或  /dept/listOrders_items_ByDeptno.jsp的請求
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
			Orders_itemService orders_itemSvc = new Orders_itemService();
			List<Orders_itemVO> list  = orders_itemSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listOrders_items_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Orders_itemService orders_itemSvc = new Orders_itemService();
			List<Orders_itemVO> list  = orders_itemSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listOrders_items_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/orders_item/listOrders_items_ByCompositeQuery.jsp"); // 成功轉交listOrders_items_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/orders_item/select_page.jsp");
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
						.getRequestDispatcher("/Heibernate_back-end/orders_item/select_page.jsp");
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
						.getRequestDispatcher("/Heibernate_back-end/orders_item/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Orders_itemService orders_itemSvc = new Orders_itemService();
			Orders_itemVO orders_itemVO = orders_itemSvc.getOneOrders_item(orders_no);
			if (orders_itemVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/orders_item/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("orders_itemVO", orders_itemVO); // 資料庫取出的orders_itemVO物件,存入req
			String url = "/Heibernate_back-end/orders_item/listOneOrders_item.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneOrders_item.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/orders_item/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/orders_item/listAllOrders_item.jsp】 或  【/dept/listOrders_items_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String orders_no = new String(req.getParameter("orders_no"));
			/***************************2.開始查詢資料****************************************/
			Orders_itemService orders_itemSvc = new Orders_itemService();
			Orders_itemVO orders_itemVO = orders_itemSvc.getOneOrders_item(orders_no);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("orders_itemVO", orders_itemVO); // 資料庫取出的orders_itemVO物件,存入req
			String url = "/Heibernate_back-end/orders_item/update_orders_item_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_orders_item_input.jsp
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
				String product_no = req.getParameter("product_no").trim();
				Integer commodities_amount = new Integer(req.getParameter("commodities_amount").trim());
				Integer selling_price = new Integer(req.getParameter("selling_price").trim());
			//==== VO設定部分 ====			
				Orders_itemVO orders_itemVO = new Orders_itemVO();
				//以下3行程式碼因為要配合Hibernate的orders_itemVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				OrdersVO ordersVO = new OrdersVO();
				ordersVO.setOrders_no(orders_no);
				orders_itemVO.setOrdersVO(ordersVO);
				//以下3行程式碼因為要配合Hibernate的orders_itemVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				ProductVO productVO = new ProductVO();
				productVO.setProduct_no(product_no);
				orders_itemVO.setProductVO(productVO);
				orders_itemVO.setCommodities_amount(commodities_amount);
				orders_itemVO.setSelling_price(selling_price);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("orders_itemVO", orders_itemVO); // 含有輸入格式錯誤的orders_itemVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/orders_item/update_orders_item_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Orders_itemService orders_itemSvc = new Orders_itemService();
			orders_itemVO = orders_itemSvc.updateOrders_item(
					orders_no
					,product_no
					,commodities_amount
					,selling_price
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/orders_item/listOrders_items_ByOrders_no.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/orders_item/listAllOrders_item.jsp")){
				//req.setAttribute("listOrders_items_ByOrders_no",orders_itemSvc.getOrders_itemsByOrders_no(orders_no)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/orders_item/listOrders_items_ByProduct_no.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/orders_item/listAllOrders_item.jsp")){
				//req.setAttribute("listOrders_items_ByProduct_no",orders_itemSvc.getOrders_itemsByProduct_no(product_no)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/orders_item/listOrders_items_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Orders_itemVO> list  = orders_itemSvc.getAll(map);
				//req.setAttribute("listOrders_items_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/orders_item/update_orders_item_input.jsp");
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
               Integer commodities_amount = new Integer(req.getParameter("commodities_amount").trim());	
               Integer selling_price = new Integer(req.getParameter("selling_price").trim());	
               Orders_itemVO orders_itemVO = new Orders_itemVO();
				orders_itemVO.setCommodities_amount(commodities_amount);
				orders_itemVO.setSelling_price(selling_price);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("orders_itemVO", orders_itemVO); // 含有輸入格式錯誤的orders_itemVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/orders_item/addOrders_item.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Orders_itemService orders_itemSvc = new Orders_itemService();
               orders_itemVO = orders_itemSvc.addOrders_item(
               	commodities_amount
               	,selling_price
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/orders_item/listAllOrders_item.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOrders_item.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/orders_item/addOrders_item.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/orders_item/listAllOrders_item.jsp】 或  【/dept/listOrders_items_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String orders_no = new String(req.getParameter("orders_no"));
			/***************************2.開始刪除資料***************************************/
			Orders_itemService orders_itemSvc = new Orders_itemService();
			Orders_itemVO orders_itemVO = orders_itemSvc.getOneOrders_item(orders_no);
			orders_itemSvc.deleteOrders_item(orders_no);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			OrdersService ordersSvc = new OrdersService();
			if(requestURL.equals("/orders/listOrders_items_ByOrders_no.jsp") || requestURL.equals("/orders/listAllOrders.jsp")){
			  //req.setAttribute("listOrders_items_ByOrders_no",ordersSvc.getOrders_itemsByOrders_no(orders_itemVO.getOrders_no())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listOrders_items_ByOrders_no",ordersSvc.getOrders_itemsByOrders_no(orders_itemVO.getOrdersVO().getOrders_no())); // 資料庫取出的list物件,存入request
			}
			ProductService productSvc = new ProductService();
			if(requestURL.equals("/product/listOrders_items_ByProduct_no.jsp") || requestURL.equals("/product/listAllProduct.jsp")){
			  //req.setAttribute("listOrders_items_ByProduct_no",productSvc.getOrders_itemsByProduct_no(orders_itemVO.getProduct_no())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listOrders_items_ByProduct_no",productSvc.getOrders_itemsByProduct_no(orders_itemVO.getProductVO().getProduct_no())); // 資料庫取出的list物件,存入request
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
