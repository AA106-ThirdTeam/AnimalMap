package heibernate_com.second_prodmsg.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.second_prod.model.Second_ProdVO;
import heibernate_com.second_prod.model.Second_ProdService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.second_prodmsg.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/second_prodmsg/second_prodmsg.do" })
public class Second_ProdMsgServlet extends HttpServlet {
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
			String str = req.getParameter("second_ProdMsg_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入二手商品留言編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/second_prodmsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String second_ProdMsg_Id = null;
			try {
				second_ProdMsg_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("二手商品留言編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/second_prodmsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
			Second_ProdMsgVO second_prodmsgVO = second_prodmsgSvc.getOneSecond_ProdMsg(second_ProdMsg_Id);
			if (second_prodmsgVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/second_prodmsg/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("second_prodmsgVO", second_prodmsgVO); // 資料庫取出的second_prodmsgVO物件,存入req
			String url = "/Heibernate_back-end/second_prodmsg/listOneSecond_ProdMsg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/second_prodmsg/select_page.jsp");
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
			String second_ProdMsg_Id = new String(req.getParameter("second_ProdMsg_Id"));
			/***************************2.開始查詢資料****************************************/
			Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
			Second_ProdMsgVO second_prodmsgVO = second_prodmsgSvc.getOneSecond_ProdMsg(second_ProdMsg_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("second_prodmsgVO", second_prodmsgVO); // 資料庫取出的second_prodmsgVO物件,存入req
			String url = "/Heibernate_back-end/second_prodmsg/update_second_prodmsg_input.jsp";
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
				String second_ProdMsg_Id = req.getParameter("second_ProdMsg_Id").trim();
				String second_Prod_Id = req.getParameter("second_Prod_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				String second_ProdMsg_Msg = req.getParameter("second_ProdMsg_Msg").trim();
				java.sql.Date second_ProdMsg_DATE = null;
				try {
					second_ProdMsg_DATE = java.sql.Date.valueOf(req.getParameter("second_ProdMsg_DATE").trim());
				} catch (IllegalArgumentException e) {
					second_ProdMsg_DATE=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date second_ProdMsg_adp_upDate = null;
				try {
					second_ProdMsg_adp_upDate = java.sql.Date.valueOf(req.getParameter("second_ProdMsg_adp_upDate").trim());
				} catch (IllegalArgumentException e) {
					second_ProdMsg_adp_upDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
			//==== VO設定部分 ====			
				Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();
				second_prodmsgVO.setSecond_ProdMsg_Id(second_ProdMsg_Id);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Second_ProdVO second_prodVO = new Second_ProdVO();
				second_prodVO.setSecond_Prod_Id(second_Prod_Id);
				second_prodmsgVO.setSecond_ProdVO(second_prodVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				second_prodmsgVO.setMemVO(memVO);
				second_prodmsgVO.setSecond_ProdMsg_Msg(second_ProdMsg_Msg);
				second_prodmsgVO.setSecond_ProdMsg_DATE(second_ProdMsg_DATE);
				second_prodmsgVO.setSecond_ProdMsg_adp_upDate(second_ProdMsg_adp_upDate);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("second_prodmsgVO", second_prodmsgVO); // 含有輸入格式錯誤的second_prodmsgVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/second_prodmsg/update_second_prodmsg_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
			second_prodmsgVO = second_prodmsgSvc.updateSecond_ProdMsg(
					second_ProdMsg_Id
					,second_Prod_Id
					,mem_Id
					,second_ProdMsg_Msg
					,second_ProdMsg_DATE
					,second_ProdMsg_adp_upDate
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/second_prodmsg/listSecond_ProdMsgs_BySecond_Prod_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/second_prodmsg/listAllSecond_ProdMsg.jsp")){
				//req.setAttribute("listSecond_ProdMsgs_BySecond_Prod_Id",second_prodmsgSvc.getSecond_ProdMsgsBySecond_Prod_Id(second_Prod_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/second_prodmsg/listSecond_ProdMsgs_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/second_prodmsg/listAllSecond_ProdMsg.jsp")){
				//req.setAttribute("listSecond_ProdMsgs_ByMem_Id",second_prodmsgSvc.getSecond_ProdMsgsByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/second_prodmsg/listSecond_ProdMsgs_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Second_ProdMsgVO> list  = second_prodmsgSvc.getAll(map);
				//req.setAttribute("listSecond_ProdMsgs_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/second_prodmsg/update_second_prodmsg_input.jsp");
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
               String second_Prod_Id = req.getParameter("second_Prod_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               String second_ProdMsg_Msg = req.getParameter("second_ProdMsg_Msg").trim();	
               java.sql.Date second_ProdMsg_DATE = null;
               try {
                   second_ProdMsg_DATE = java.sql.Date.valueOf(req.getParameter("second_ProdMsg_DATE").trim());
               } catch (IllegalArgumentException e) {
                   second_ProdMsg_DATE=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date second_ProdMsg_adp_upDate = null;
               try {
                   second_ProdMsg_adp_upDate = java.sql.Date.valueOf(req.getParameter("second_ProdMsg_adp_upDate").trim());
               } catch (IllegalArgumentException e) {
                   second_ProdMsg_adp_upDate=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Second_ProdVO second_prodVO = new Second_ProdVO();
				second_prodVO.setSecond_Prod_Id(second_Prod_Id);
				second_prodmsgVO.setSecond_ProdVO(second_prodVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				second_prodmsgVO.setMemVO(memVO);
				second_prodmsgVO.setSecond_ProdMsg_Msg(second_ProdMsg_Msg);
				second_prodmsgVO.setSecond_ProdMsg_DATE(second_ProdMsg_DATE);
				second_prodmsgVO.setSecond_ProdMsg_adp_upDate(second_ProdMsg_adp_upDate);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("second_prodmsgVO", second_prodmsgVO); // 含有輸入格式錯誤的second_prodmsgVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/second_prodmsg/addSecond_ProdMsg.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
               second_prodmsgVO = second_prodmsgSvc.addSecond_ProdMsg(
               	second_Prod_Id
               	,mem_Id
               	,second_ProdMsg_Msg
               	,second_ProdMsg_DATE
               	,second_ProdMsg_adp_upDate
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/second_prodmsg/listAllSecond_ProdMsg.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllSecond_ProdMsg.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/second_prodmsg/addSecond_ProdMsg.jsp");
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
			String second_ProdMsg_Id = new String(req.getParameter("second_ProdMsg_Id"));
			/***************************2.開始刪除資料***************************************/
			Second_ProdMsgService second_prodmsgSvc = new Second_ProdMsgService();
			Second_ProdMsgVO second_prodmsgVO = second_prodmsgSvc.getOneSecond_ProdMsg(second_ProdMsg_Id);
			second_prodmsgSvc.deleteSecond_ProdMsg(second_ProdMsg_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			Second_ProdService second_prodSvc = new Second_ProdService();
			if(requestURL.equals("/second_prod/listSecond_ProdMsgs_BySecond_Prod_Id.jsp") || requestURL.equals("/second_prod/listAllSecond_Prod.jsp")){
			  //req.setAttribute("listSecond_ProdMsgs_BySecond_Prod_Id",second_prodSvc.getSecond_ProdMsgsBySecond_Prod_Id(second_prodmsgVO.getSecond_Prod_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listSecond_ProdMsgs_BySecond_Prod_Id",second_prodSvc.getSecond_ProdMsgsBySecond_Prod_Id(second_prodmsgVO.getSecond_ProdVO().getSecond_Prod_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listSecond_ProdMsgs_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listSecond_ProdMsgs_ByMem_Id",memSvc.getSecond_ProdMsgsByMem_Id(second_prodmsgVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listSecond_ProdMsgs_ByMem_Id",memSvc.getSecond_ProdMsgsByMem_Id(second_prodmsgVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
