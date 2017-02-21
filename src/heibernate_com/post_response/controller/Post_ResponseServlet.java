package heibernate_com.post_response.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.post.model.PostVO;
import heibernate_com.post.model.PostService;
import heibernate_com.post_response.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/post_response/post_response.do" })
public class Post_ResponseServlet extends HttpServlet {
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
			String str = req.getParameter("res_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入留言(回覆)編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/post_response/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String res_Id = null;
			try {
				res_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("留言(回覆)編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/post_response/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Post_ResponseService post_responseSvc = new Post_ResponseService();
			Post_ResponseVO post_responseVO = post_responseSvc.getOnePost_Response(res_Id);
			if (post_responseVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/post_response/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("post_responseVO", post_responseVO); // 資料庫取出的post_responseVO物件,存入req
			String url = "/Heibernate_back-end/post_response/listOnePost_Response.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/post_response/select_page.jsp");
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
			String res_Id = new String(req.getParameter("res_Id"));
			/***************************2.開始查詢資料****************************************/
			Post_ResponseService post_responseSvc = new Post_ResponseService();
			Post_ResponseVO post_responseVO = post_responseSvc.getOnePost_Response(res_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("post_responseVO", post_responseVO); // 資料庫取出的post_responseVO物件,存入req
			String url = "/Heibernate_back-end/post_response/update_post_response_input.jsp";
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
				String res_Id = req.getParameter("res_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String post_Id = req.getParameter("post_Id").trim();
				String post_Response_content = req.getParameter("post_Response_content").trim();
				java.sql.Date post_time = null;
				try {
					post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
				} catch (IllegalArgumentException e) {
					post_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date post_Response_upDate = null;
				try {
					post_Response_upDate = java.sql.Date.valueOf(req.getParameter("post_Response_upDate").trim());
				} catch (IllegalArgumentException e) {
					post_Response_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				Post_ResponseVO post_responseVO = new Post_ResponseVO();
				post_responseVO.setRes_Id(res_Id);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				post_responseVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PostVO postVO = new PostVO();
				postVO.setPost_Id(post_Id);
				post_responseVO.setPostVO(postVO);
				post_responseVO.setPost_Response_content(post_Response_content);
				post_responseVO.setPost_time(post_time);
				post_responseVO.setPost_Response_upDate(post_Response_upDate);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("post_responseVO", post_responseVO); // 含有輸入格式錯誤的post_responseVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/post_response/update_post_response_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Post_ResponseService post_responseSvc = new Post_ResponseService();
			post_responseVO = post_responseSvc.updatePost_Response(
					res_Id
					,mem_Id
					,post_Id
					,post_Response_content
					,post_time
					,post_Response_upDate
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/post_response/listPost_Responses_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/post_response/listAllPost_Response.jsp")){
				//req.setAttribute("listPost_Responses_ByMem_Id",post_responseSvc.getPost_ResponsesByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/post_response/listPost_Responses_ByPost_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/post_response/listAllPost_Response.jsp")){
				//req.setAttribute("listPost_Responses_ByPost_Id",post_responseSvc.getPost_ResponsesByPost_Id(post_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/post_response/listPost_Responses_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Post_ResponseVO> list  = post_responseSvc.getAll(map);
				//req.setAttribute("listPost_Responses_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/post_response/update_post_response_input.jsp");
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
               String post_Id = req.getParameter("post_Id").trim();	
               String post_Response_content = req.getParameter("post_Response_content").trim();	
               java.sql.Date post_time = null;
               try {
                   post_time = java.sql.Date.valueOf(req.getParameter("post_time").trim());
               } catch (IllegalArgumentException e) {
                   post_time=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date post_Response_upDate = null;
               try {
                   post_Response_upDate = java.sql.Date.valueOf(req.getParameter("post_Response_upDate").trim());
               } catch (IllegalArgumentException e) {
                   post_Response_upDate=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Post_ResponseVO post_responseVO = new Post_ResponseVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				post_responseVO.setMemVO(memVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				PostVO postVO = new PostVO();
				postVO.setPost_Id(post_Id);
				post_responseVO.setPostVO(postVO);
				post_responseVO.setPost_Response_content(post_Response_content);
				post_responseVO.setPost_time(post_time);
				post_responseVO.setPost_Response_upDate(post_Response_upDate);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("post_responseVO", post_responseVO); // 含有輸入格式錯誤的post_responseVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/post_response/addPost_Response.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Post_ResponseService post_responseSvc = new Post_ResponseService();
               post_responseVO = post_responseSvc.addPost_Response(
               	mem_Id
               	,post_Id
               	,post_Response_content
               	,post_time
               	,post_Response_upDate
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/post_response/listAllPost_Response.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPost_Response.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/post_response/addPost_Response.jsp");
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
			String res_Id = new String(req.getParameter("res_Id"));
			/***************************2.開始刪除資料***************************************/
			Post_ResponseService post_responseSvc = new Post_ResponseService();
			Post_ResponseVO post_responseVO = post_responseSvc.getOnePost_Response(res_Id);
			post_responseSvc.deletePost_Response(res_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listPost_Responses_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listPost_Responses_ByMem_Id",memSvc.getPost_ResponsesByMem_Id(post_responseVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPost_Responses_ByMem_Id",memSvc.getPost_ResponsesByMem_Id(post_responseVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
			}
			PostService postSvc = new PostService();
			if(requestURL.equals("/post/listPost_Responses_ByPost_Id.jsp") || requestURL.equals("/post/listAllPost.jsp")){
			  //req.setAttribute("listPost_Responses_ByPost_Id",postSvc.getPost_ResponsesByPost_Id(post_responseVO.getPost_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPost_Responses_ByPost_Id",postSvc.getPost_ResponsesByPost_Id(post_responseVO.getPostVO().getPost_Id())); // 資料庫取出的list物件,存入request
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
