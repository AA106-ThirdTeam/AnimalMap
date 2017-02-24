package heibernate_com.post.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.post.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/post/post.do" })
public class PostServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllPost.jsp 或  /dept/listPosts_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_post_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addPost.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllPost.jsp 或  /dept/listPosts_ByDeptno.jsp的請求
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
			PostService postSvc = new PostService();
			List<PostVO> list  = postSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPosts_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			PostService postSvc = new PostService();
			List<PostVO> list  = postSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPosts_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/post/listPosts_ByCompositeQuery.jsp"); // 成功轉交listPosts_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/post/select_page.jsp");
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
			String str = req.getParameter("post_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入文章編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/post/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String post_Id = null;
			try {
				post_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("文章編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/post/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			PostService postSvc = new PostService();
			PostVO postVO = postSvc.getOnePost(post_Id);
			if (postVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/post/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("postVO", postVO); // 資料庫取出的postVO物件,存入req
			String url = "/Heibernate_back-end/post/listOnePost.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOnePost.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/post/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/post/listAllPost.jsp】 或  【/dept/listPosts_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String post_Id = new String(req.getParameter("post_Id"));
			/***************************2.開始查詢資料****************************************/
			PostService postSvc = new PostService();
			PostVO postVO = postSvc.getOnePost(post_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("postVO", postVO); // 資料庫取出的postVO物件,存入req
			String url = "/Heibernate_back-end/post/update_post_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_post_input.jsp
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
				String post_Id = req.getParameter("post_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String post_class = req.getParameter("post_class").trim();
				String post_class_Id = req.getParameter("post_class_Id").trim();
				String post_title = req.getParameter("post_title").trim();
				String post_content = req.getParameter("post_content").trim();
				java.sql.Date post_time = null;
				try {
					post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
				} catch (IllegalArgumentException e) {
					post_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date post_upDate = null;
				try {
					post_upDate = java.sql.Date.valueOf(req.getParameter("post_upDate").trim());
				} catch (IllegalArgumentException e) {
					post_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				Integer post_resNum = new Integer(req.getParameter("post_resNum").trim());
			//==== VO設定部分 ====			
				PostVO postVO = new PostVO();
				postVO.setPost_Id(post_Id);
				//以下3行程式碼因為要配合Hibernate的postVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				postVO.setMemVO(memVO);
				postVO.setPost_class(post_class);
				postVO.setPost_class_Id(post_class_Id);
				postVO.setPost_title(post_title);
				postVO.setPost_content(post_content);
				postVO.setPost_time(post_time);
				postVO.setPost_upDate(post_upDate);
				postVO.setPost_resNum(post_resNum);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("postVO", postVO); // 含有輸入格式錯誤的postVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/post/update_post_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			PostService postSvc = new PostService();
			postVO = postSvc.updatePost(
					post_Id
					,mem_Id
					,post_class
					,post_class_Id
					,post_title
					,post_content
					,post_time
					,post_upDate
					,post_resNum
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/post/listPosts_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/post/listAllPost.jsp")){
				//req.setAttribute("listPosts_ByMem_Id",postSvc.getPostsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/post/listPosts_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<PostVO> list  = postSvc.getAll(map);
				//req.setAttribute("listPosts_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/post/update_post_input.jsp");
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
               String post_class = req.getParameter("post_class").trim();	
               String post_class_Id = req.getParameter("post_class_Id").trim();	
               String post_title = req.getParameter("post_title").trim();	
               String post_content = req.getParameter("post_content").trim();	
               java.sql.Date post_time = null;
               try {
                   post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
               } catch (IllegalArgumentException e) {
                   post_time=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date post_upDate = null;
               try {
                   post_upDate = java.sql.Date.valueOf(req.getParameter("post_upDate").trim());
               } catch (IllegalArgumentException e) {
                   post_upDate=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Integer post_resNum = new Integer(req.getParameter("post_resNum").trim());	
               PostVO postVO = new PostVO();
				//以下3行程式碼因為要配合Hibernate的postVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				postVO.setMemVO(memVO);
				postVO.setPost_class(post_class);
				postVO.setPost_class_Id(post_class_Id);
				postVO.setPost_title(post_title);
				postVO.setPost_content(post_content);
				postVO.setPost_time(post_time);
				postVO.setPost_upDate(post_upDate);
				postVO.setPost_resNum(post_resNum);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("postVO", postVO); // 含有輸入格式錯誤的postVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/post/addPost.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               PostService postSvc = new PostService();
               postVO = postSvc.addPost(
               	mem_Id
               	,post_class
               	,post_class_Id
               	,post_title
               	,post_content
               	,post_time
               	,post_upDate
               	,post_resNum
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/post/listAllPost.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPost.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/post/addPost.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/post/listAllPost.jsp】 或  【/dept/listPosts_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String post_Id = new String(req.getParameter("post_Id"));
			/***************************2.開始刪除資料***************************************/
			PostService postSvc = new PostService();
			PostVO postVO = postSvc.getOnePost(post_Id);
			postSvc.deletePost(post_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listPosts_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listPosts_ByMem_Id",memSvc.getPostsByMem_Id(postVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPosts_ByMem_Id",memSvc.getPostsByMem_Id(postVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
