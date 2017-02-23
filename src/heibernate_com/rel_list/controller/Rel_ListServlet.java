package heibernate_com.rel_list.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.rel_list.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/rel_list/rel_list.do" })
public class Rel_ListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllRel_List.jsp 或  /dept/listRel_Lists_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_rel_list_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addRel_List.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllRel_List.jsp 或  /dept/listRel_Lists_ByDeptno.jsp的請求
			delete(req, res);
		}
		if ("list_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
			list_ByCompositeQuery(req, res);
		}		
	}
	private void list_ByCompositeQuery(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
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
			Rel_ListService rel_listSvc = new Rel_ListService();
			List<Rel_ListVO> list  = rel_listSvc.getAll(map);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listRel_Lists_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/rel_list/listRel_Lists_ByCompositeQuery.jsp"); // 成功轉交listRel_Lists_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/rel_list/select_page.jsp");
			failureView.forward(req, res);
		}
	}
	private void getOne_For_Display(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		try {
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("rel_MemId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入會員編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/rel_list/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String rel_MemId = null;
			try {
				rel_MemId = new String(str);
			} catch (Exception e) {
				errorMsgs.add("會員編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/rel_list/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Rel_ListService rel_listSvc = new Rel_ListService();
			Rel_ListVO rel_listVO = rel_listSvc.getOneRel_List(rel_MemId);
			if (rel_listVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/rel_list/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("rel_listVO", rel_listVO); // 資料庫取出的rel_listVO物件,存入req
			String url = "/Heibernate_back-end/rel_list/listOneRel_List.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneRel_List.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/rel_list/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	private void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/rel_list/listAllRel_List.jsp】 或  【/dept/listRel_Lists_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String rel_MemId = new String(req.getParameter("rel_MemId"));
			/***************************2.開始查詢資料****************************************/
			Rel_ListService rel_listSvc = new Rel_ListService();
			Rel_ListVO rel_listVO = rel_listSvc.getOneRel_List(rel_MemId);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("rel_listVO", rel_listVO); // 資料庫取出的rel_listVO物件,存入req
			String url = "/Heibernate_back-end/rel_list/update_rel_list_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_rel_list_input.jsp
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
				String rel_MemId = req.getParameter("rel_MemId").trim();
				String added_MemId = req.getParameter("added_MemId").trim();
				String isBlackList = req.getParameter("isBlackList").trim();
				String isInvited = req.getParameter("isInvited").trim();
			//==== VO設定部分 ====			
				Rel_ListVO rel_listVO = new Rel_ListVO();
				//以下3行程式碼因為要配合Hibernate的rel_listVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(rel_MemId);
				rel_listVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的rel_listVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				memVO = new MemVO();
				memVO.setMem_Id(added_MemId);
				rel_listVO.setMemVO(memVO);
				rel_listVO.setIsBlackList(isBlackList);
				rel_listVO.setIsInvited(isInvited);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("rel_listVO", rel_listVO); // 含有輸入格式錯誤的rel_listVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/rel_list/update_rel_list_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Rel_ListService rel_listSvc = new Rel_ListService();
			rel_listVO = rel_listSvc.updateRel_List(
					rel_MemId
					,added_MemId
					,isBlackList
					,isInvited
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/rel_list/listRel_Lists_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/rel_list/listAllRel_List.jsp")){
				//req.setAttribute("listRel_Lists_ByMem_Id",rel_listSvc.getRel_ListsByMem_Id(rel_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/rel_list/listRel_Lists_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/rel_list/listAllRel_List.jsp")){
				//req.setAttribute("listRel_Lists_ByMem_Id",rel_listSvc.getRel_ListsByMem_Id(added_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/rel_list/listRel_Lists_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Rel_ListVO> list  = rel_listSvc.getAll(map);
				//req.setAttribute("listRel_Lists_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/rel_list/update_rel_list_input.jsp");
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
               String isBlackList = req.getParameter("isBlackList").trim();	
               String isInvited = req.getParameter("isInvited").trim();	
               Rel_ListVO rel_listVO = new Rel_ListVO();
				rel_listVO.setIsBlackList(isBlackList);
				rel_listVO.setIsInvited(isInvited);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("rel_listVO", rel_listVO); // 含有輸入格式錯誤的rel_listVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/rel_list/addRel_List.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Rel_ListService rel_listSvc = new Rel_ListService();
               rel_listVO = rel_listSvc.addRel_List(
               	isBlackList
               	,isInvited
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/rel_list/listAllRel_List.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllRel_List.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/rel_list/addRel_List.jsp");
			failureView.forward(req, res);
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/rel_list/listAllRel_List.jsp】 或  【/dept/listRel_Lists_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String rel_MemId = new String(req.getParameter("rel_MemId"));
			/***************************2.開始刪除資料***************************************/
			Rel_ListService rel_listSvc = new Rel_ListService();
			Rel_ListVO rel_listVO = rel_listSvc.getOneRel_List(rel_MemId);
			rel_listSvc.deleteRel_List(rel_MemId);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listRel_Lists_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listRel_Lists_ByMem_Id",memSvc.getRel_ListsByMem_Id(rel_listVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listRel_Lists_ByMem_Id",memSvc.getRel_ListsByMem_Id(rel_listVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
			memSvc = new MemService();
			if(requestURL.equals("/mem/listRel_Lists_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listRel_Lists_ByMem_Id",memSvc.getRel_ListsByMem_Id(rel_listVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listRel_Lists_ByMem_Id",memSvc.getRel_ListsByMem_Id(rel_listVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
