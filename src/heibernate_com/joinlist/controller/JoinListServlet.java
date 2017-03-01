package heibernate_com.joinlist.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.petgroup.model.PetGroupVO;
import heibernate_com.petgroup.model.PetGroupService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.joinlist.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/joinlist/joinlist.do" })
public class JoinListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllJoinList.jsp 或  /dept/listJoinLists_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_joinlist_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addJoinList.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllJoinList.jsp 或  /dept/listJoinLists_ByDeptno.jsp的請求
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
			JoinListService joinlistSvc = new JoinListService();
			List<JoinListVO> list  = joinlistSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listJoinLists_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			JoinListService joinlistSvc = new JoinListService();
			List<JoinListVO> list  = joinlistSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listJoinLists_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/joinlist/listJoinLists_ByCompositeQuery.jsp"); // 成功轉交listJoinLists_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/joinlist/select_page.jsp");
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
			String str = req.getParameter("joinList_GrpId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/joinlist/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String joinList_GrpId = null;
			try {
				joinList_GrpId = new String(str);
			} catch (Exception e) {
				errorMsgs.add("活動編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/joinlist/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			JoinListService joinlistSvc = new JoinListService();
			JoinListVO joinlistVO = joinlistSvc.getOneJoinList(joinList_GrpId);
			if (joinlistVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/joinlist/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("joinlistVO", joinlistVO); // 資料庫取出的joinlistVO物件,存入req
			String url = "/Heibernate_back-end/joinlist/listOneJoinList.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneJoinList.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/joinlist/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/joinlist/listAllJoinList.jsp】 或  【/dept/listJoinLists_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String joinList_GrpId = new String(req.getParameter("joinList_GrpId"));
			/***************************2.開始查詢資料****************************************/
			JoinListService joinlistSvc = new JoinListService();
			JoinListVO joinlistVO = joinlistSvc.getOneJoinList(joinList_GrpId);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("joinlistVO", joinlistVO); // 資料庫取出的joinlistVO物件,存入req
			String url = "/Heibernate_back-end/joinlist/update_joinlist_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_joinlist_input.jsp
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
				String joinList_GrpId = req.getParameter("joinList_GrpId").trim();
				String joinList_MemId = req.getParameter("joinList_MemId").trim();
				String JOINLIST_ISINVITED = req.getParameter("JOINLIST_ISINVITED").trim();
			//==== VO設定部分 ====			
				JoinListVO joinlistVO = new JoinListVO();
				//以下3行程式碼因為要配合Hibernate的joinlistVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetGroupVO petgroupVO = new PetGroupVO();
				petgroupVO.setGrp_Id(joinList_GrpId);
				joinlistVO.setPetGroupVO(petgroupVO);
				//以下3行程式碼因為要配合Hibernate的joinlistVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(joinList_MemId);
				joinlistVO.setMemVO(memVO);
				joinlistVO.setJOINLIST_ISINVITED(JOINLIST_ISINVITED);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("joinlistVO", joinlistVO); // 含有輸入格式錯誤的joinlistVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/joinlist/update_joinlist_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			JoinListService joinlistSvc = new JoinListService();
			joinlistVO = joinlistSvc.updateJoinList(
					joinList_GrpId
					,joinList_MemId
					,JOINLIST_ISINVITED
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/joinlist/listJoinLists_ByGrp_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/joinlist/listAllJoinList.jsp")){
				//req.setAttribute("listJoinLists_ByGrp_Id",joinlistSvc.getJoinListsByGrp_Id(joinList_GrpId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/joinlist/listJoinLists_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/joinlist/listAllJoinList.jsp")){
				//req.setAttribute("listJoinLists_ByMem_Id",joinlistSvc.getJoinListsByMem_Id(joinList_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/joinlist/listJoinLists_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<JoinListVO> list  = joinlistSvc.getAll(map);
				//req.setAttribute("listJoinLists_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/joinlist/update_joinlist_input.jsp");
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
               String JOINLIST_ISINVITED = req.getParameter("JOINLIST_ISINVITED").trim();	
               JoinListVO joinlistVO = new JoinListVO();
				joinlistVO.setJOINLIST_ISINVITED(JOINLIST_ISINVITED);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("joinlistVO", joinlistVO); // 含有輸入格式錯誤的joinlistVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/joinlist/addJoinList.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               JoinListService joinlistSvc = new JoinListService();
               joinlistVO = joinlistSvc.addJoinList(
               	JOINLIST_ISINVITED
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/joinlist/listAllJoinList.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllJoinList.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/joinlist/addJoinList.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/joinlist/listAllJoinList.jsp】 或  【/dept/listJoinLists_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String joinList_GrpId = new String(req.getParameter("joinList_GrpId"));
			/***************************2.開始刪除資料***************************************/
			JoinListService joinlistSvc = new JoinListService();
			JoinListVO joinlistVO = joinlistSvc.getOneJoinList(joinList_GrpId);
			joinlistSvc.deleteJoinList(joinList_GrpId);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			PetGroupService petgroupSvc = new PetGroupService();
			if(requestURL.equals("/petgroup/listJoinLists_ByGrp_Id.jsp") || requestURL.equals("/petgroup/listAllPetGroup.jsp")){
			  //req.setAttribute("listJoinLists_ByGrp_Id",petgroupSvc.getJoinListsByGrp_Id(joinlistVO.getGrp_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listJoinLists_ByGrp_Id",petgroupSvc.getJoinListsByGrp_Id(joinlistVO.getPetGroupVO().getGrp_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listJoinLists_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listJoinLists_ByMem_Id",memSvc.getJoinListsByMem_Id(joinlistVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listJoinLists_ByMem_Id",memSvc.getJoinListsByMem_Id(joinlistVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
