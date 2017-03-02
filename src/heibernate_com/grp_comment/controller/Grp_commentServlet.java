package heibernate_com.grp_comment.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.petgroup.model.PetGroupVO;
import heibernate_com.petgroup.model.PetGroupService;
import heibernate_com.grp_comment.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/grp_comment/grp_comment.do" })
public class Grp_commentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllGrp_comment.jsp 或  /dept/listGrp_comments_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_grp_comment_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addGrp_comment.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllGrp_comment.jsp 或  /dept/listGrp_comments_ByDeptno.jsp的請求
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
			Grp_commentService grp_commentSvc = new Grp_commentService();
			List<Grp_commentVO> list  = grp_commentSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listGrp_comments_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Grp_commentService grp_commentSvc = new Grp_commentService();
			List<Grp_commentVO> list  = grp_commentSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listGrp_comments_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/grp_comment/listGrp_comments_ByCompositeQuery.jsp"); // 成功轉交listGrp_comments_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/grp_comment/select_page.jsp");
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
			String str = req.getParameter("grpComment_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入揪團留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/grp_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String grpComment_Id = null;
			try {
				grpComment_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("揪團留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/grp_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Grp_commentService grp_commentSvc = new Grp_commentService();
			Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);
			if (grp_commentVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/grp_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("grp_commentVO", grp_commentVO); // 資料庫取出的grp_commentVO物件,存入req
			String url = "/Heibernate_back-end/grp_comment/listOneGrp_comment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneGrp_comment.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/grp_comment/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/grp_comment/listAllGrp_comment.jsp】 或  【/dept/listGrp_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String grpComment_Id = new String(req.getParameter("grpComment_Id"));
			/***************************2.開始查詢資料****************************************/
			Grp_commentService grp_commentSvc = new Grp_commentService();
			Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("grp_commentVO", grp_commentVO); // 資料庫取出的grp_commentVO物件,存入req
			String url = "/Heibernate_back-end/grp_comment/update_grp_comment_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_grp_comment_input.jsp
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
				String grpComment_Id = req.getParameter("grpComment_Id").trim();
				String grpComment_MemId = req.getParameter("grpComment_MemId").trim();
				String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
				String grpComment_content = req.getParameter("grpComment_content").trim();
				java.sql.Date grpComment_SendTime = null;
				try {
					grpComment_SendTime = java.sql.Date.valueOf(req.getParameter("grpComment_SendTime").trim());
				} catch (IllegalArgumentException e) {
					grpComment_SendTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				Grp_commentVO grp_commentVO = new Grp_commentVO();
				grp_commentVO.setGrpComment_Id(grpComment_Id);
				//以下3行程式碼因為要配合Hibernate的grp_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(grpComment_MemId);
				grp_commentVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的grp_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetGroupVO petgroupVO = new PetGroupVO();
				petgroupVO.setGrp_Id(grpComment_GrpId);
				grp_commentVO.setPetGroupVO(petgroupVO);
				grp_commentVO.setGrpComment_content(grpComment_content);
				grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("grp_commentVO", grp_commentVO); // 含有輸入格式錯誤的grp_commentVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/grp_comment/update_grp_comment_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Grp_commentService grp_commentSvc = new Grp_commentService();
			grp_commentVO = grp_commentSvc.updateGrp_comment(
					grpComment_Id
					,grpComment_MemId
					,grpComment_GrpId
					,grpComment_content
					,grpComment_SendTime
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/grp_comment/listGrp_comments_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/grp_comment/listAllGrp_comment.jsp")){
				//req.setAttribute("listGrp_comments_ByMem_Id",grp_commentSvc.getGrp_commentsByMem_Id(grpComment_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/grp_comment/listGrp_comments_ByGrp_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/grp_comment/listAllGrp_comment.jsp")){
				//req.setAttribute("listGrp_comments_ByGrp_Id",grp_commentSvc.getGrp_commentsByGrp_Id(grpComment_GrpId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/grp_comment/listGrp_comments_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Grp_commentVO> list  = grp_commentSvc.getAll(map);
				//req.setAttribute("listGrp_comments_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/grp_comment/update_grp_comment_input.jsp");
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
               String grpComment_MemId = req.getParameter("grpComment_MemId").trim();	
               String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();	
               String grpComment_content = req.getParameter("grpComment_content").trim();	
               java.sql.Date grpComment_SendTime = null;
               try {
                   grpComment_SendTime = java.sql.Date.valueOf(req.getParameter("grpComment_SendTime").trim());
               } catch (IllegalArgumentException e) {
                   grpComment_SendTime=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Grp_commentVO grp_commentVO = new Grp_commentVO();
				//以下3行程式碼因為要配合Hibernate的grp_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(grpComment_MemId);
				grp_commentVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的grp_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PetGroupVO petgroupVO = new PetGroupVO();
				petgroupVO.setGrp_Id(grpComment_GrpId);
				grp_commentVO.setPetGroupVO(petgroupVO);
				grp_commentVO.setGrpComment_content(grpComment_content);
				grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("grp_commentVO", grp_commentVO); // 含有輸入格式錯誤的grp_commentVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/grp_comment/addGrp_comment.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Grp_commentService grp_commentSvc = new Grp_commentService();
               grp_commentVO = grp_commentSvc.addGrp_comment(
               	grpComment_MemId
               	,grpComment_GrpId
               	,grpComment_content
               	,grpComment_SendTime
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/grp_comment/listAllGrp_comment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllGrp_comment.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/grp_comment/addGrp_comment.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/grp_comment/listAllGrp_comment.jsp】 或  【/dept/listGrp_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String grpComment_Id = new String(req.getParameter("grpComment_Id"));
			/***************************2.開始刪除資料***************************************/
			Grp_commentService grp_commentSvc = new Grp_commentService();
			Grp_commentVO grp_commentVO = grp_commentSvc.getOneGrp_comment(grpComment_Id);
			grp_commentSvc.deleteGrp_comment(grpComment_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listGrp_comments_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listGrp_comments_ByMem_Id",memSvc.getGrp_commentsByMem_Id(grp_commentVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listGrp_comments_ByMem_Id",memSvc.getGrp_commentsByMem_Id(grp_commentVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
			PetGroupService petgroupSvc = new PetGroupService();
			if(requestURL.equals("/petgroup/listGrp_comments_ByGrp_Id.jsp") || requestURL.equals("/petgroup/listAllPetGroup.jsp")){
			  //req.setAttribute("listGrp_comments_ByGrp_Id",petgroupSvc.getGrp_commentsByGrp_Id(grp_commentVO.getGrp_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listGrp_comments_ByGrp_Id",petgroupSvc.getGrp_commentsByGrp_Id(grp_commentVO.getPetGroupVO().getGrp_Id())); // 資料庫取出的list物件,存入request
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
