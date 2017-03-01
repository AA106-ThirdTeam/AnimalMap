package heibernate_com.shop_comment.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.petshop.model.PetShopVO;
import heibernate_com.petshop.model.PetShopService;
import heibernate_com.shop_comment.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/shop_comment/shop_comment.do" })
public class Shop_commentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllShop_comment.jsp 或  /dept/listShop_comments_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_shop_comment_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addShop_comment.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllShop_comment.jsp 或  /dept/listShop_comments_ByDeptno.jsp的請求
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
			Shop_commentService shop_commentSvc = new Shop_commentService();
			List<Shop_commentVO> list  = shop_commentSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listShop_comments_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Shop_commentService shop_commentSvc = new Shop_commentService();
			List<Shop_commentVO> list  = shop_commentSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listShop_comments_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/shop_comment/listShop_comments_ByCompositeQuery.jsp"); // 成功轉交listShop_comments_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shop_comment/select_page.jsp");
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
			String str = req.getParameter("shopComment_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入診所留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shop_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String shopComment_Id = null;
			try {
				shopComment_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("診所留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shop_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Shop_commentService shop_commentSvc = new Shop_commentService();
			Shop_commentVO shop_commentVO = shop_commentSvc.getOneShop_comment(shopComment_Id);
			if (shop_commentVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shop_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("shop_commentVO", shop_commentVO); // 資料庫取出的shop_commentVO物件,存入req
			String url = "/Heibernate_back-end/shop_comment/listOneShop_comment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneShop_comment.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shop_comment/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/shop_comment/listAllShop_comment.jsp】 或  【/dept/listShop_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String shopComment_Id = new String(req.getParameter("shopComment_Id"));
			/***************************2.開始查詢資料****************************************/
			Shop_commentService shop_commentSvc = new Shop_commentService();
			Shop_commentVO shop_commentVO = shop_commentSvc.getOneShop_comment(shopComment_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("shop_commentVO", shop_commentVO); // 資料庫取出的shop_commentVO物件,存入req
			String url = "/Heibernate_back-end/shop_comment/update_shop_comment_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_shop_comment_input.jsp
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
				String shopComment_Id = req.getParameter("shopComment_Id").trim();
				String shopComment_MemId = req.getParameter("shopComment_MemId").trim();
				String shopComment_ShopId = req.getParameter("shopComment_ShopId").trim();
				String shopComment_content = req.getParameter("shopComment_content").trim();
				java.sql.Timestamp shopComment_SendTime = null;
				try {
					shopComment_SendTime = java.sql.Timestamp.valueOf(req.getParameter("shopComment_SendTime").trim());
				} catch (IllegalArgumentException e) {
					shopComment_SendTime=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				Shop_commentVO shop_commentVO = new Shop_commentVO();
				shop_commentVO.setShopComment_Id(shopComment_Id);
				//以下3行程式碼因為要配合Hibernate的shop_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(shopComment_MemId);
				shop_commentVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的shop_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetShopVO petshopVO = new PetShopVO();
				petshopVO.setShop_Id(shopComment_ShopId);
				shop_commentVO.setPetShopVO(petshopVO);
				shop_commentVO.setShopComment_content(shopComment_content);
				shop_commentVO.setShopComment_SendTime(shopComment_SendTime);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shop_commentVO", shop_commentVO); // 含有輸入格式錯誤的shop_commentVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/shop_comment/update_shop_comment_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Shop_commentService shop_commentSvc = new Shop_commentService();
			shop_commentVO = shop_commentSvc.updateShop_comment(
					shopComment_Id
					,shopComment_MemId
					,shopComment_ShopId
					,shopComment_content
					,shopComment_SendTime
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/shop_comment/listShop_comments_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/shop_comment/listAllShop_comment.jsp")){
				//req.setAttribute("listShop_comments_ByMem_Id",shop_commentSvc.getShop_commentsByMem_Id(shopComment_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/shop_comment/listShop_comments_ByShop_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/shop_comment/listAllShop_comment.jsp")){
				//req.setAttribute("listShop_comments_ByShop_Id",shop_commentSvc.getShop_commentsByShop_Id(shopComment_ShopId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/shop_comment/listShop_comments_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Shop_commentVO> list  = shop_commentSvc.getAll(map);
				//req.setAttribute("listShop_comments_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shop_comment/update_shop_comment_input.jsp");
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
               String shopComment_MemId = req.getParameter("shopComment_MemId").trim();	
               String shopComment_ShopId = req.getParameter("shopComment_ShopId").trim();	
               String shopComment_content = req.getParameter("shopComment_content").trim();	
               java.sql.Timestamp shopComment_SendTime = null;
               try {
                   shopComment_SendTime = java.sql.Timestamp.valueOf(req.getParameter("shopComment_SendTime").trim());
               } catch (IllegalArgumentException e) {
                   shopComment_SendTime=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Shop_commentVO shop_commentVO = new Shop_commentVO();
				//以下3行程式碼因為要配合Hibernate的shop_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(shopComment_MemId);
				shop_commentVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的shop_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetShopVO petshopVO = new PetShopVO();
				petshopVO.setShop_Id(shopComment_ShopId);
				shop_commentVO.setPetShopVO(petshopVO);
				shop_commentVO.setShopComment_content(shopComment_content);
				shop_commentVO.setShopComment_SendTime(shopComment_SendTime);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("shop_commentVO", shop_commentVO); // 含有輸入格式錯誤的shop_commentVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/shop_comment/addShop_comment.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Shop_commentService shop_commentSvc = new Shop_commentService();
               shop_commentVO = shop_commentSvc.addShop_comment(
               	shopComment_MemId
               	,shopComment_ShopId
               	,shopComment_content
               	,shopComment_SendTime
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/shop_comment/listAllShop_comment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllShop_comment.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/shop_comment/addShop_comment.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/shop_comment/listAllShop_comment.jsp】 或  【/dept/listShop_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String shopComment_Id = new String(req.getParameter("shopComment_Id"));
			/***************************2.開始刪除資料***************************************/
			Shop_commentService shop_commentSvc = new Shop_commentService();
			Shop_commentVO shop_commentVO = shop_commentSvc.getOneShop_comment(shopComment_Id);
			shop_commentSvc.deleteShop_comment(shopComment_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listShop_comments_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listShop_comments_ByMem_Id",memSvc.getShop_commentsByMem_Id(shop_commentVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listShop_comments_ByMem_Id",memSvc.getShop_commentsByMem_Id(shop_commentVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
			PetShopService petshopSvc = new PetShopService();
			if(requestURL.equals("/petshop/listShop_comments_ByShop_Id.jsp") || requestURL.equals("/petshop/listAllPetShop.jsp")){
			  //req.setAttribute("listShop_comments_ByShop_Id",petshopSvc.getShop_commentsByShop_Id(shop_commentVO.getShop_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listShop_comments_ByShop_Id",petshopSvc.getShop_commentsByShop_Id(shop_commentVO.getPetShopVO().getShop_Id())); // 資料庫取出的list物件,存入request
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
