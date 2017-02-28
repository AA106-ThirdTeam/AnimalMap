package heibernate_com.hos_comment.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.vet_hospital.model.Vet_hospitalVO;
import heibernate_com.vet_hospital.model.Vet_hospitalService;
import heibernate_com.hos_comment.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/hos_comment/hos_comment.do" })
public class Hos_commentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllHos_comment.jsp 或  /dept/listHos_comments_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_hos_comment_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addHos_comment.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllHos_comment.jsp 或  /dept/listHos_comments_ByDeptno.jsp的請求
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
			Hos_commentService hos_commentSvc = new Hos_commentService();
			List<Hos_commentVO> list  = hos_commentSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listHos_comments_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Hos_commentService hos_commentSvc = new Hos_commentService();
			List<Hos_commentVO> list  = hos_commentSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listHos_comments_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/hos_comment/listHos_comments_ByCompositeQuery.jsp"); // 成功轉交listHos_comments_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/hos_comment/select_page.jsp");
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
			String str = req.getParameter("hosComment_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入診所留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/hos_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String hosComment_Id = null;
			try {
				hosComment_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("診所留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/hos_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Hos_commentService hos_commentSvc = new Hos_commentService();
			Hos_commentVO hos_commentVO = hos_commentSvc.getOneHos_comment(hosComment_Id);
			if (hos_commentVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/hos_comment/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("hos_commentVO", hos_commentVO); // 資料庫取出的hos_commentVO物件,存入req
			String url = "/Heibernate_back-end/hos_comment/listOneHos_comment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneHos_comment.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/hos_comment/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/hos_comment/listAllHos_comment.jsp】 或  【/dept/listHos_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String hosComment_Id = new String(req.getParameter("hosComment_Id"));
			/***************************2.開始查詢資料****************************************/
			Hos_commentService hos_commentSvc = new Hos_commentService();
			Hos_commentVO hos_commentVO = hos_commentSvc.getOneHos_comment(hosComment_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("hos_commentVO", hos_commentVO); // 資料庫取出的hos_commentVO物件,存入req
			String url = "/Heibernate_back-end/hos_comment/update_hos_comment_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_hos_comment_input.jsp
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
				String hosComment_Id = req.getParameter("hosComment_Id").trim();
				String hosComment_MemId = req.getParameter("hosComment_MemId").trim();
				String hosComment_HosId = req.getParameter("hosComment_HosId").trim();
				String hosComment_content = req.getParameter("hosComment_content").trim();
				java.sql.Timestamp hosComment_SendTime = null;
				try {
					hosComment_SendTime = java.sql.Timestamp.valueOf(req.getParameter("hosComment_SendTime").trim());
				} catch (IllegalArgumentException e) {
					hosComment_SendTime=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				Hos_commentVO hos_commentVO = new Hos_commentVO();
				hos_commentVO.setHosComment_Id(hosComment_Id);
				//以下3行程式碼因為要配合Hibernate的hos_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(hosComment_MemId);
				hos_commentVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的hos_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
				vet_hospitalVO.setHos_Id(hosComment_HosId);
				hos_commentVO.setVet_hospitalVO(vet_hospitalVO);
				hos_commentVO.setHosComment_content(hosComment_content);
				hos_commentVO.setHosComment_SendTime(hosComment_SendTime);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("hos_commentVO", hos_commentVO); // 含有輸入格式錯誤的hos_commentVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/hos_comment/update_hos_comment_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Hos_commentService hos_commentSvc = new Hos_commentService();
			hos_commentVO = hos_commentSvc.updateHos_comment(
					hosComment_Id
					,hosComment_MemId
					,hosComment_HosId
					,hosComment_content
					,hosComment_SendTime
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/hos_comment/listHos_comments_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/hos_comment/listAllHos_comment.jsp")){
				//req.setAttribute("listHos_comments_ByMem_Id",hos_commentSvc.getHos_commentsByMem_Id(hosComment_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/hos_comment/listHos_comments_ByHos_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/hos_comment/listAllHos_comment.jsp")){
				//req.setAttribute("listHos_comments_ByHos_Id",hos_commentSvc.getHos_commentsByHos_Id(hosComment_HosId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/hos_comment/listHos_comments_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Hos_commentVO> list  = hos_commentSvc.getAll(map);
				//req.setAttribute("listHos_comments_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/hos_comment/update_hos_comment_input.jsp");
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
               String hosComment_MemId = req.getParameter("hosComment_MemId").trim();	
               String hosComment_HosId = req.getParameter("hosComment_HosId").trim();	
               String hosComment_content = req.getParameter("hosComment_content").trim();	
               java.sql.Timestamp hosComment_SendTime = null;
               try {
                   hosComment_SendTime = java.sql.Timestamp.valueOf(req.getParameter("hosComment_SendTime").trim());
               } catch (IllegalArgumentException e) {
                   hosComment_SendTime=new java.sql.Timestamp(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Hos_commentVO hos_commentVO = new Hos_commentVO();
				//以下3行程式碼因為要配合Hibernate的hos_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(hosComment_MemId);
				hos_commentVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的hos_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
				vet_hospitalVO.setHos_Id(hosComment_HosId);
				hos_commentVO.setVet_hospitalVO(vet_hospitalVO);
				hos_commentVO.setHosComment_content(hosComment_content);
				hos_commentVO.setHosComment_SendTime(hosComment_SendTime);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("hos_commentVO", hos_commentVO); // 含有輸入格式錯誤的hos_commentVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/hos_comment/addHos_comment.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Hos_commentService hos_commentSvc = new Hos_commentService();
               hos_commentVO = hos_commentSvc.addHos_comment(
               	hosComment_MemId
               	,hosComment_HosId
               	,hosComment_content
               	,hosComment_SendTime
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/hos_comment/listAllHos_comment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllHos_comment.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/hos_comment/addHos_comment.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/hos_comment/listAllHos_comment.jsp】 或  【/dept/listHos_comments_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String hosComment_Id = new String(req.getParameter("hosComment_Id"));
			/***************************2.開始刪除資料***************************************/
			Hos_commentService hos_commentSvc = new Hos_commentService();
			Hos_commentVO hos_commentVO = hos_commentSvc.getOneHos_comment(hosComment_Id);
			hos_commentSvc.deleteHos_comment(hosComment_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listHos_comments_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listHos_comments_ByMem_Id",memSvc.getHos_commentsByMem_Id(hos_commentVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listHos_comments_ByMem_Id",memSvc.getHos_commentsByMem_Id(hos_commentVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
			Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
			if(requestURL.equals("/vet_hospital/listHos_comments_ByHos_Id.jsp") || requestURL.equals("/vet_hospital/listAllVet_hospital.jsp")){
			  //req.setAttribute("listHos_comments_ByHos_Id",vet_hospitalSvc.getHos_commentsByHos_Id(hos_commentVO.getHos_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listHos_comments_ByHos_Id",vet_hospitalSvc.getHos_commentsByHos_Id(hos_commentVO.getVet_hospitalVO().getHos_Id())); // 資料庫取出的list物件,存入request
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
