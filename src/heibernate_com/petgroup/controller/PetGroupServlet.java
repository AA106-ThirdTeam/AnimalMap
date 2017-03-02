package heibernate_com.petgroup.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.petgroup.model.*;

@WebServlet(urlPatterns = { "/Heibernate_back-end/petgroup/petgroup.do" })
public class PetGroupServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			getOne_For_Display(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllPetGroup.jsp 或  /dept/listPetGroups_ByDeptno.jsp 的請求
			getOne_For_Update(req, res);
		}
		if ("update".equals(action)) { // 來自update_petgroup_input.jsp的請求
			update(req, res);
		}
        if ("insert".equals(action)) { // 來自addPetGroup.jsp的請求  
        	insert(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllPetGroup.jsp 或  /dept/listPetGroups_ByDeptno.jsp的請求
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
			PetGroupService petgroupSvc = new PetGroupService();
			List<PetGroupVO> list  = petgroupSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPetGroups_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
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
			PetGroupService petgroupSvc = new PetGroupService();
			List<PetGroupVO> list  = petgroupSvc.getAll(map,ableLike);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("listPetGroups_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
			RequestDispatcher successView = req.getRequestDispatcher("/Heibernate_back-end/petgroup/listPetGroups_ByCompositeQuery.jsp"); // 成功轉交listPetGroups_ByCompositeQuery.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/petgroup/select_page.jsp");
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
			String str = req.getParameter("grp_Id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動編號編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/petgroup/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String grp_Id = null;
			try {
				grp_Id = new String(str);
			} catch (Exception e) {
				errorMsgs.add("活動編號編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/petgroup/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************2.開始查詢資料*****************************************/
			PetGroupService petgroupSvc = new PetGroupService();
			PetGroupVO petgroupVO = petgroupSvc.getOnePetGroup(grp_Id);
			if (petgroupVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/petgroup/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("petgroupVO", petgroupVO); // 資料庫取出的petgroupVO物件,存入req
			String url = "/Heibernate_back-end/petgroup/listOnePetGroup.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOnePetGroup.jsp
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/petgroup/select_page.jsp");
			failureView.forward(req, res);
		}		
	}
	public void getOne_For_Update(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁path: 可能為【/petgroup/listAllPetGroup.jsp】 或  【/dept/listPetGroups_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
		try {
			/***************************1.接收請求參數****************************************/
			String grp_Id = new String(req.getParameter("grp_Id"));
			/***************************2.開始查詢資料****************************************/
			PetGroupService petgroupSvc = new PetGroupService();
			PetGroupVO petgroupVO = petgroupSvc.getOnePetGroup(grp_Id);
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("petgroupVO", petgroupVO); // 資料庫取出的petgroupVO物件,存入req
			String url = "/Heibernate_back-end/petgroup/update_petgroup_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_petgroup_input.jsp
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
				String grp_Id = req.getParameter("grp_Id").trim();
				String grp_MemId = req.getParameter("grp_MemId").trim();
				String grp_name = req.getParameter("grp_name").trim();
				String grp_city = req.getParameter("grp_city").trim();
				String GRP_TOWN = req.getParameter("GRP_TOWN").trim();
				String grp_road = req.getParameter("grp_road").trim();
				java.sql.Date grp_EndTime = null;
				try {
					grp_EndTime = java.sql.Date.valueOf(req.getParameter("grp_EndTime").trim());
				} catch (IllegalArgumentException e) {
					grp_EndTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date grp_StartTime = null;
				try {
					grp_StartTime = java.sql.Date.valueOf(req.getParameter("grp_StartTime").trim());
				} catch (IllegalArgumentException e) {
					grp_StartTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				java.sql.Date grp_CreateTime = null;
				try {
					grp_CreateTime = java.sql.Date.valueOf(req.getParameter("grp_CreateTime").trim());
				} catch (IllegalArgumentException e) {
					grp_CreateTime=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String grp_Desc = req.getParameter("grp_Desc").trim();
				Double grp_Long = null;
				try {
					grp_Long = new Double(req.getParameter("grp_Long").trim());
				} catch (NumberFormatException e) {
					grp_Long = 0.0;
					errorMsgs.add("商家經度座標請填數字.");
				}
				Double grp_Lat = null;
				try {
					grp_Lat = new Double(req.getParameter("grp_Lat").trim());
				} catch (NumberFormatException e) {
					grp_Lat = 0.0;
					errorMsgs.add("商家緯度座標請填數字.");
				}
				String grp_visible = req.getParameter("grp_visible").trim();
				byte[] GRP_PHOTO = null;
				try {
					Part part = req.getPart("GRP_PHOTO");
					InputStream in = part.getInputStream();
					GRP_PHOTO = new byte[part.getInputStream().available()];
					in.read(GRP_PHOTO);
					in.close();
				} catch (Exception e) {
					GRP_PHOTO = null;
					//errorMsgs.add("揪團照片請上傳照片.");
				}
			//==== VO設定部分 ====			
				PetGroupVO petgroupVO = new PetGroupVO();
				petgroupVO.setGrp_Id(grp_Id);
				//以下3行程式碼因為要配合Hibernate的petgroupVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(grp_MemId);
				petgroupVO.setMemVO(memVO);
				petgroupVO.setGrp_name(grp_name);
				petgroupVO.setGrp_city(grp_city);
				petgroupVO.setGRP_TOWN(GRP_TOWN);
				petgroupVO.setGrp_road(grp_road);
				petgroupVO.setGrp_EndTime(grp_EndTime);
				petgroupVO.setGrp_StartTime(grp_StartTime);
				petgroupVO.setGrp_CreateTime(grp_CreateTime);
				petgroupVO.setGrp_Desc(grp_Desc);
				petgroupVO.setGrp_Long(grp_Long);
				petgroupVO.setGrp_Lat(grp_Lat);
				petgroupVO.setGrp_visible(grp_visible);
				petgroupVO.setGRP_PHOTO(GRP_PHOTO);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("petgroupVO", petgroupVO); // 含有輸入格式錯誤的petgroupVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Heibernate_back-end/petgroup/update_petgroup_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料*****************************************/
			PetGroupService petgroupSvc = new PetGroupService();
			petgroupVO = petgroupSvc.updatePetGroup(
					grp_Id
					,grp_MemId
					,grp_name
					,grp_city
					,GRP_TOWN
					,grp_road
					,grp_EndTime
					,grp_StartTime
					,grp_CreateTime
					,grp_Desc
					,grp_Long
					,grp_Lat
					,grp_visible
					,GRP_PHOTO
			);
			/***************************3.修改完成,準備轉交(Send the Success view)*************/				
			//if(requestURL.equals("/Heibernate_back-end/petgroup/listPetGroups_ByMem_Id.jsp") 
				//|| requestURL.equals("/Heibernate_back-end/petgroup/listAllPetGroup.jsp")){
				//req.setAttribute("listPetGroups_ByMem_Id",petgroupSvc.getPetGroupsByMem_Id(grp_MemId)); // 資料庫取出的list物件,存入request
			//}
			//if(requestURL.equals("/Heibernate_back-end/petgroup/listPetGroups_ByCompositeQuery.jsp")){
				//HttpSession session = req.getSession();
				//Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				//List<PetGroupVO> list  = petgroupSvc.getAll(map);
				//req.setAttribute("listPetGroups_ByCompositeQuery",list); //  複合查詢, 資料庫取出的list物件,存入request
			//}
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
			successView.forward(req, res);
			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("修改資料失敗:"+e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/petgroup/update_petgroup_input.jsp");
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
               String grp_MemId = req.getParameter("grp_MemId").trim();	
               String grp_name = req.getParameter("grp_name").trim();	
               String grp_city = req.getParameter("grp_city").trim();	
               String GRP_TOWN = req.getParameter("GRP_TOWN").trim();	
               String grp_road = req.getParameter("grp_road").trim();	
               java.sql.Date grp_EndTime = null;
               try {
                   grp_EndTime = java.sql.Date.valueOf(req.getParameter("grp_EndTime").trim());
               } catch (IllegalArgumentException e) {
                   grp_EndTime=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date grp_StartTime = null;
               try {
                   grp_StartTime = java.sql.Date.valueOf(req.getParameter("grp_StartTime").trim());
               } catch (IllegalArgumentException e) {
                   grp_StartTime=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               java.sql.Date grp_CreateTime = null;
               try {
                   grp_CreateTime = java.sql.Date.valueOf(req.getParameter("grp_CreateTime").trim());
               } catch (IllegalArgumentException e) {
                   grp_CreateTime=new java.sql.Date(System.currentTimeMillis());
                   errorMsgs.add("請輸入日期!");
               }
               String grp_Desc = req.getParameter("grp_Desc").trim();	
               Double grp_Long = null;
               try {
                   grp_Long = new Double(req.getParameter("grp_Long").trim());
               } catch (NumberFormatException e) {
                   grp_Long = 0.0;
                   errorMsgs.add("商家經度座標請填數字.");
                   e.printStackTrace();
               }
               Double grp_Lat = null;
               try {
                   grp_Lat = new Double(req.getParameter("grp_Lat").trim());
               } catch (NumberFormatException e) {
                   grp_Lat = 0.0;
                   errorMsgs.add("商家緯度座標請填數字.");
                   e.printStackTrace();
               }
               String grp_visible = req.getParameter("grp_visible").trim();	
               byte[] GRP_PHOTO = null;
               try {
                   Part part = req.getPart("GRP_PHOTO");
                   InputStream in = part.getInputStream();
                   GRP_PHOTO = new byte[part.getInputStream().available()];
                   in.read(GRP_PHOTO);
                   in.close();
               } catch (Exception e) {
                   //errorMsgs.add("揪團照片請上傳照片.");
                   //e.printStackTrace();
                   GRP_PHOTO = null;
               }	
               PetGroupVO petgroupVO = new PetGroupVO();
				//以下3行程式碼因為要配合Hibernate的petgroupVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
				MemVO memVO = new MemVO();
				memVO.setMem_Id(grp_MemId);
				petgroupVO.setMemVO(memVO);
				petgroupVO.setGrp_name(grp_name);
				petgroupVO.setGrp_city(grp_city);
				petgroupVO.setGRP_TOWN(GRP_TOWN);
				petgroupVO.setGrp_road(grp_road);
				petgroupVO.setGrp_EndTime(grp_EndTime);
				petgroupVO.setGrp_StartTime(grp_StartTime);
				petgroupVO.setGrp_CreateTime(grp_CreateTime);
				petgroupVO.setGrp_Desc(grp_Desc);
				petgroupVO.setGrp_Long(grp_Long);
				petgroupVO.setGrp_Lat(grp_Lat);
				petgroupVO.setGrp_visible(grp_visible);
				petgroupVO.setGRP_PHOTO(GRP_PHOTO);
               // Send the use back to the form, if there were errors
               if (!errorMsgs.isEmpty()) {
                   req.setAttribute("petgroupVO", petgroupVO); // 含有輸入格式錯誤的petgroupVO物件,也存入req
                   RequestDispatcher failureView = req.getRequestDispatcher("/Heibernate_back-end/petgroup/addPetGroup.jsp");
                   failureView.forward(req, res);
                   return;
               }
               /***************************2.開始新增資料***************************************/
               PetGroupService petgroupSvc = new PetGroupService();
               petgroupVO = petgroupSvc.addPetGroup(
               	grp_MemId
               	,grp_name
               	,grp_city
               	,GRP_TOWN
               	,grp_road
               	,grp_EndTime
               	,grp_StartTime
               	,grp_CreateTime
               	,grp_Desc
               	,grp_Long
               	,grp_Lat
               	,grp_visible
               	,GRP_PHOTO
               ); 
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/Heibernate_back-end/petgroup/listAllPetGroup.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPetGroup.jsp
			successView.forward(req, res);				
		/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Heibernate_back-end/petgroup/addPetGroup.jsp");
			failureView.forward(req, res);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁path: 可能為【/petgroup/listAllPetGroup.jsp】 或  【/dept/listPetGroups_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		try {
			/***************************1.接收請求參數***************************************/
			String grp_Id = new String(req.getParameter("grp_Id"));
			/***************************2.開始刪除資料***************************************/
			PetGroupService petgroupSvc = new PetGroupService();
			PetGroupVO petgroupVO = petgroupSvc.getOnePetGroup(grp_Id);
			petgroupSvc.deletePetGroup(grp_Id);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/
			MemService memSvc = new MemService();
			if(requestURL.equals("/mem/listPetGroups_ByMem_Id.jsp") || requestURL.equals("/mem/listAllMem.jsp")){
			  //req.setAttribute("listPetGroups_ByMem_Id",memSvc.getPetGroupsByMem_Id(petgroupVO.getMem_Id())); // 資料庫取出的list物件,存入request
			  //req.setAttribute("listPetGroups_ByMem_Id",memSvc.getPetGroupsByMem_Id(petgroupVO.getMemVO().getMem_Id())); // 資料庫取出的list物件,存入request
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
