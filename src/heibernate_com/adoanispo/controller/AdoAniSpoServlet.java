package heibernate_com.adoanispo.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.adopt_ani.model.Adopt_AniVO;
import heibernate_com.adopt_ani.model.Adopt_AniService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.adoanispo.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/adoanispo/adoanispo.do" })
public class AdoAniSpoServlet extends HttpServlet {
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
			String str = req.getParameter("adoAniSpoNo");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入送養動物贊助編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adoanispo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String adoAniSpoNo = null;
			try {
				adoAniSpoNo = new String(str);
			} catch (Exception e) {
				errorMsgs.add("送養動物贊助編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adoanispo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
			AdoAniSpoVO adoanispoVO = adoanispoSvc.getOneAdoAniSpo(adoAniSpoNo);
			if (adoanispoVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adoanispo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("adoanispoVO", adoanispoVO); // 資料庫取出的adoanispoVO物件,存入req
			String url = "/Heibernate_back-end/adoanispo/listOneAdoAniSpo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adoanispo/select_page.jsp");
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
			String adoAniSpoNo = new String(req.getParameter("adoAniSpoNo"));
			/***************************2.開始查詢資料****************************************/
			AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
			AdoAniSpoVO adoanispoVO = adoanispoSvc.getOneAdoAniSpo(adoAniSpoNo);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("adoanispoVO", adoanispoVO); // 資料庫取出的adoanispoVO物件,存入req
			String url = "/Heibernate_back-end/adoanispo/update_adoanispo_input.jsp";
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
				String adoAniSpoNo = req.getParameter("adoAniSpoNo").trim();
				String adoAniSpoAniId = req.getParameter("adoAniSpoAniId").trim();
				String adoAniSpomem_Id = req.getParameter("adoAniSpomem_Id").trim();
				Integer adoAniSpoMoney = new Integer(req.getParameter("adoAniSpoMoney").trim());
				String adoAniSpoMat = req.getParameter("adoAniSpoMat").trim();
			//==== VO設定部分 ====			
				AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();
				adoanispoVO.setAdoAniSpoNo(adoAniSpoNo);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
				adopt_aniVO.setAdopt_Ani_Id(adoAniSpoAniId);
				adoanispoVO.setAdopt_AniVO(adopt_aniVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(adoAniSpomem_Id);
				adoanispoVO.setMemVO(memVO);
				adoanispoVO.setAdoAniSpoMoney(adoAniSpoMoney);
				adoanispoVO.setAdoAniSpoMat(adoAniSpoMat);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adoanispoVO", adoanispoVO); // 含有輸入格式錯誤的adoanispoVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adoanispo/update_adoanispo_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
			adoanispoVO = adoanispoSvc.updateAdoAniSpo(
					adoAniSpoNo
					,adoAniSpoAniId
					,adoAniSpomem_Id
					,adoAniSpoMoney
					,adoAniSpoMat
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/adoanispo/listAdoAniSpos_ByAdopt_Ani_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adoanispo/listAllAdoAniSpo.jsp")){
				//req.setAttribute("listAdoAniSpos_ByAdopt_Ani_Id",adoanispoSvc.getAdoAniSposByAdopt_Ani_Id(adoAniSpoAniId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adoanispo/listAdoAniSpos_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adoanispo/listAllAdoAniSpo.jsp")){
				//req.setAttribute("listAdoAniSpos_ByMem_Id",adoanispoSvc.getAdoAniSposByMem_Id(adoAniSpomem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adoanispo/listAdoAniSpos_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<AdoAniSpoVO> list  = adoanispoSvc.getAll(map);
				//req.setAttribute("listAdoAniSpos_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adoanispo/update_adoanispo_input.jsp");
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
               String adoAniSpoAniId = req.getParameter("adoAniSpoAniId").trim();	
               String adoAniSpomem_Id = req.getParameter("adoAniSpomem_Id").trim();	
               Integer adoAniSpoMoney = new Integer(req.getParameter("adoAniSpoMoney").trim());	
               String adoAniSpoMat = req.getParameter("adoAniSpoMat").trim();	
               AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
				adopt_aniVO.setAdopt_Ani_Id(adoAniSpoAniId);
				adoanispoVO.setAdopt_AniVO(adopt_aniVO);
				//以下3行程式碼因為要配合Hibernate的empVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(adoAniSpomem_Id);
				adoanispoVO.setMemVO(memVO);
				adoanispoVO.setAdoAniSpoMoney(adoAniSpoMoney);
				adoanispoVO.setAdoAniSpoMat(adoAniSpoMat);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("adoanispoVO", adoanispoVO); // 含有輸入格式錯誤的adoanispoVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/adoanispo/addAdoAniSpo.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
               adoanispoVO = adoanispoSvc.addAdoAniSpo(
               	adoAniSpoAniId
               	,adoAniSpomem_Id
               	,adoAniSpoMoney
               	,adoAniSpoMat
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/adoanispo/listAllAdoAniSpo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdoAniSpo.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adoanispo/addAdoAniSpo.jsp");
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
			String adoAniSpoNo = new String(req.getParameter("adoAniSpoNo"));
			/***************************2.開始刪除資料***************************************/
			AdoAniSpoService adoanispoSvc = new AdoAniSpoService();
			AdoAniSpoVO adoanispoVO = adoanispoSvc.getOneAdoAniSpo(adoAniSpoNo);
			adoanispoSvc.deleteAdoAniSpo(adoAniSpoNo);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			Adopt_AniService adopt_aniSvc = new Adopt_AniService();
			if(requestURL.equals("/adopt_ani/listAdoAniSpos_ByAdopt_Ani_Id.jsp") || requestURL.equals("/adopt_ani/listAllAdopt_Ani.jsp")){
			  //req.setAttribute("listAdoAniSpos_ByAdopt_Ani_Id",adopt_aniSvc.getAdoAniSposByAdopt_Ani_Id(adoanispoVO.getAdopt_Ani_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdoAniSpos_ByAdopt_Ani_Id",adopt_aniSvc.getAdoAniSposByAdopt_Ani_Id(adoanispoVO.getAdopt_AniVO().getAdopt_Ani_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listAdoAniSpos_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listAdoAniSpos_ByMem_Id",memSvc.getAdoAniSposByMem_Id(adoanispoVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdoAniSpos_ByMem_Id",memSvc.getAdoAniSposByMem_Id(adoanispoVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
