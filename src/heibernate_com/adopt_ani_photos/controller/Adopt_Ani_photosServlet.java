package heibernate_com.adopt_ani_photos.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.adopt_ani.model.Adopt_AniVO;
import heibernate_com.adopt_ani.model.Adopt_AniService;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.adopt_ani_photos.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/adopt_ani_photos/adopt_ani_photos.do" })
public class Adopt_Ani_photosServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllAdopt_Ani_photos.jsp 或  /dept/listAdopt_Ani_photoss_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_adopt_ani_photos_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addAdopt_Ani_photos.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllAdopt_Ani_photos.jsp 或  /dept/listAdopt_Ani_photoss_ByDeptno.jsp的請求
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
			Adopt_Ani_photosService adopt_ani_photosSvc = new Adopt_Ani_photosService();
			List<Adopt_Ani_photosVO> list  = adopt_ani_photosSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listAdopt_Ani_photoss_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			Adopt_Ani_photosService adopt_ani_photosSvc = new Adopt_Ani_photosService();
			List<Adopt_Ani_photosVO> list  = adopt_ani_photosSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listAdopt_Ani_photoss_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/listAdopt_Ani_photoss_ByCompositeQuery.jsp"); // 成功轉交listAdopt_Ani_photoss_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/select_page.jsp");
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
			String str = req.getParameter("ado_Ani_Pic_No");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入送養動物相片編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String ado_Ani_Pic_No = null;
			try {
				ado_Ani_Pic_No = new String(str);
			} catch (Exception e) {
				errorMsgs.add("送養動物相片編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			Adopt_Ani_photosService adopt_ani_photosSvc = new Adopt_Ani_photosService();
			Adopt_Ani_photosVO adopt_ani_photosVO = adopt_ani_photosSvc.getOneAdopt_Ani_photos(ado_Ani_Pic_No);
			if (adopt_ani_photosVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("adopt_ani_photosVO", adopt_ani_photosVO); // 資料庫取出的adopt_ani_photosVO物件,存入req
			String url = "/Heibernate_back-end/adopt_ani_photos/listOneAdopt_Ani_photos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneAdopt_Ani_photos.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/adopt_ani_photos/listAllAdopt_Ani_photos.jsp】 或  【/dept/listAdopt_Ani_photoss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String ado_Ani_Pic_No = new String(req.getParameter("ado_Ani_Pic_No"));
			/***************************2.開始查詢資料****************************************/
			Adopt_Ani_photosService adopt_ani_photosSvc = new Adopt_Ani_photosService();
			Adopt_Ani_photosVO adopt_ani_photosVO = adopt_ani_photosSvc.getOneAdopt_Ani_photos(ado_Ani_Pic_No);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("adopt_ani_photosVO", adopt_ani_photosVO); // 資料庫取出的adopt_ani_photosVO物件,存入req
			String url = "/Heibernate_back-end/adopt_ani_photos/update_adopt_ani_photos_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_adopt_ani_photos_input.jsp
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
				String ado_Ani_Pic_No = req.getParameter("ado_Ani_Pic_No").trim();
				String adopt_Ani_Id = req.getParameter("adopt_Ani_Id").trim();
				String mem_Id = req.getParameter("mem_Id").trim();
				byte[] ado_Ani_Pic = null;
				try {
					Part part = req.getPart("ado_Ani_Pic");
					InputStream in = part.getInputStream();
					ado_Ani_Pic = new byte[part.getInputStream().available()];
					in.read(ado_Ani_Pic);
					in.close();
				} catch (Exception e) {
					ado_Ani_Pic = null;
					//errorMsgs.add("送養動物相片請上傳照片.");
				}
				String ado_Pic_name = req.getParameter("ado_Pic_name").trim();
				String ado_Pic_nameEX = req.getParameter("ado_Pic_nameEX").trim();
				java.sql.Date ado_Pic_time = null;
				try {
					ado_Pic_time = java.sql.Date.valueOf(req.getParameter("ado_Pic_time").trim());
				} catch (IllegalArgumentException e) {
					ado_Pic_time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String ado_Pic_type = req.getParameter("ado_Pic_type").trim();
			//==== VO設定部分 ====			
				Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();
				adopt_ani_photosVO.setAdo_Ani_Pic_No(ado_Ani_Pic_No);
				//以下3行程式碼因為要配合Hibernate的adopt_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
				adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
				adopt_ani_photosVO.setAdopt_AniVO(adopt_aniVO);
				//以下3行程式碼因為要配合Hibernate的adopt_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				adopt_ani_photosVO.setMemVO(memVO);
				adopt_ani_photosVO.setAdo_Ani_Pic(ado_Ani_Pic);
				adopt_ani_photosVO.setAdo_Pic_name(ado_Pic_name);
				adopt_ani_photosVO.setAdo_Pic_nameEX(ado_Pic_nameEX);
				adopt_ani_photosVO.setAdo_Pic_time(ado_Pic_time);
				adopt_ani_photosVO.setAdo_Pic_type(ado_Pic_type);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adopt_ani_photosVO", adopt_ani_photosVO); // 含有輸入格式錯誤的adopt_ani_photosVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/update_adopt_ani_photos_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			Adopt_Ani_photosService adopt_ani_photosSvc = new Adopt_Ani_photosService();
			adopt_ani_photosVO = adopt_ani_photosSvc.updateAdopt_Ani_photos(
					ado_Ani_Pic_No
					,adopt_Ani_Id
					,mem_Id
					,ado_Ani_Pic
					,ado_Pic_name
					,ado_Pic_nameEX
					,ado_Pic_time
					,ado_Pic_type
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/adopt_ani_photos/listAdopt_Ani_photoss_ByAdopt_Ani_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adopt_ani_photos/listAllAdopt_Ani_photos.jsp")){
				//req.setAttribute("listAdopt_Ani_photoss_ByAdopt_Ani_Id",adopt_ani_photosSvc.getAdopt_Ani_photossByAdopt_Ani_Id(adopt_Ani_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adopt_ani_photos/listAdopt_Ani_photoss_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/adopt_ani_photos/listAllAdopt_Ani_photos.jsp")){
				//req.setAttribute("listAdopt_Ani_photoss_ByMem_Id",adopt_ani_photosSvc.getAdopt_Ani_photossByMem_Id(mem_Id)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/adopt_ani_photos/listAdopt_Ani_photoss_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<Adopt_Ani_photosVO> list  = adopt_ani_photosSvc.getAll(map);
				//req.setAttribute("listAdopt_Ani_photoss_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/update_adopt_ani_photos_input.jsp");
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
               String adopt_Ani_Id = req.getParameter("adopt_Ani_Id").trim();	
               String mem_Id = req.getParameter("mem_Id").trim();	
               byte[] ado_Ani_Pic = null;
               try {
                   Part part = req.getPart("ado_Ani_Pic");
                   InputStream in = part.getInputStream();
                   ado_Ani_Pic = new byte[part.getInputStream().available()];
                   in.read(ado_Ani_Pic);
                   in.close();
               } catch (Exception e) {
                   //errorMsgs.add("送養動物相片請上傳照片.");
                   //e.printStackTrace();
                   ado_Ani_Pic = null;
               }	
               String ado_Pic_name = req.getParameter("ado_Pic_name").trim();	
               String ado_Pic_nameEX = req.getParameter("ado_Pic_nameEX").trim();	
               java.sql.Date ado_Pic_time = null;
               try {
                   ado_Pic_time = java.sql.Date.valueOf(req.getParameter("ado_Pic_time").trim());
               } catch (IllegalArgumentException e) {
                   ado_Pic_time=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String ado_Pic_type = req.getParameter("ado_Pic_type").trim();	
               Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();
				//以下3行程式碼因為要配合Hibernate的adopt_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
				adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
				adopt_ani_photosVO.setAdopt_AniVO(adopt_aniVO);
				//以下3行程式碼因為要配合Hibernate的adopt_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(mem_Id);
				adopt_ani_photosVO.setMemVO(memVO);
				adopt_ani_photosVO.setAdo_Ani_Pic(ado_Ani_Pic);
				adopt_ani_photosVO.setAdo_Pic_name(ado_Pic_name);
				adopt_ani_photosVO.setAdo_Pic_nameEX(ado_Pic_nameEX);
				adopt_ani_photosVO.setAdo_Pic_time(ado_Pic_time);
				adopt_ani_photosVO.setAdo_Pic_type(ado_Pic_type);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("adopt_ani_photosVO", adopt_ani_photosVO); // 含有輸入格式錯誤的adopt_ani_photosVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/addAdopt_Ani_photos.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               Adopt_Ani_photosService adopt_ani_photosSvc = new Adopt_Ani_photosService();
               adopt_ani_photosVO = adopt_ani_photosSvc.addAdopt_Ani_photos(
               	adopt_Ani_Id
               	,mem_Id
               	,ado_Ani_Pic
               	,ado_Pic_name
               	,ado_Pic_nameEX
               	,ado_Pic_time
               	,ado_Pic_type
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/adopt_ani_photos/listAllAdopt_Ani_photos.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdopt_Ani_photos.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/adopt_ani_photos/addAdopt_Ani_photos.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/adopt_ani_photos/listAllAdopt_Ani_photos.jsp】 或  【/dept/listAdopt_Ani_photoss_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String ado_Ani_Pic_No = new String(req.getParameter("ado_Ani_Pic_No"));
			/***************************2.開始刪除資料***************************************/
			Adopt_Ani_photosService adopt_ani_photosSvc = new Adopt_Ani_photosService();
			Adopt_Ani_photosVO adopt_ani_photosVO = adopt_ani_photosSvc.getOneAdopt_Ani_photos(ado_Ani_Pic_No);
			adopt_ani_photosSvc.deleteAdopt_Ani_photos(ado_Ani_Pic_No);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			Adopt_AniService adopt_aniSvc = new Adopt_AniService();
			if(requestURL.equals("/adopt_ani/listAdopt_Ani_photoss_ByAdopt_Ani_Id.jsp") || requestURL.equals("/adopt_ani/listAllAdopt_Ani.jsp")){
			  //req.setAttribute("listAdopt_Ani_photoss_ByAdopt_Ani_Id",adopt_aniSvc.getAdopt_Ani_photossByAdopt_Ani_Id(adopt_ani_photosVO.getAdopt_Ani_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdopt_Ani_photoss_ByAdopt_Ani_Id",adopt_aniSvc.getAdopt_Ani_photossByAdopt_Ani_Id(adopt_ani_photosVO.getAdopt_AniVO().getAdopt_Ani_Id())); // 資料庫取出的list物件,存入request
			}
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listAdopt_Ani_photoss_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listAdopt_Ani_photoss_ByMem_Id",memSvc.getAdopt_Ani_photossByMem_Id(adopt_ani_photosVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listAdopt_Ani_photoss_ByMem_Id",memSvc.getAdopt_Ani_photossByMem_Id(adopt_ani_photosVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
