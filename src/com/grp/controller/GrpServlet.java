package com.grp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.grp.model.GrpService;
import com.grp.model.GrpVO;
import com.grpComm.model.GrpCommVO;
import com.hos.model.HosService;
import com.hos.model.HosVO;
import com.hosComm.model.HosCommVO;
import com.hosPhoto.model.HosPhotoVO;
import com.joinlist.model.JoinListVO;

@MultipartConfig
public class GrpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GrpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println(action);
		
		
		if ("insert".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			GrpVO grpVO = new GrpVO();

			try {
				/***********************
				 * 1.
				 *************************/
				String grp_name = req.getParameter("grp_name").trim();
				String grp_MemId = req.getParameter("grp_MemId").trim();

				Timestamp grp_StartTime = null;
				Timestamp grp_EndTime = null;

				String grp_StartTime_str = req.getParameter("grp_StartTime").trim();
				String grp_EndTime_str = req.getParameter("grp_EndTime").trim();

				System.out.println(grp_StartTime_str);
				System.out.println(grp_EndTime_str);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
								
							
				grp_StartTime = new Timestamp(sdf.parse(grp_StartTime_str).getTime());
				grp_EndTime = new Timestamp(sdf.parse(grp_EndTime_str).getTime());
				

				String check = "\\d{1,3}\\.\\d{1,6}";

				Double grp_Lat = new Double(req.getParameter("grp_Lat"));;

				
				//經度緯度不需要輸入時
				
//				if (req.getParameter("grp_Lat").trim().isEmpty()
//						|| !req.getParameter("grp_Lat").trim().matches(check))
				
				if (req.getParameter("grp_Lat").trim().isEmpty()){
					grp_Lat = 0.0;
					errorMsgs.add("經度輸入錯誤");
				} else {
					grp_Lat = new Double(req.getParameter("grp_Lat").trim());
				}

				Double grp_Long = new Double(req.getParameter("grp_Lat"));
				
				 
				if (req.getParameter("grp_Lat").trim().isEmpty()) {
					grp_Long = 0.0;
					errorMsgs.add("緯度輸入錯誤");
				} else {
					grp_Long = new Double(req.getParameter("grp_Long").trim());
				}

				String grp_city = req.getParameter("grp_city").trim();
				String grp_town = req.getParameter("grp_town").trim();
				String grp_road = req.getParameter("grp_road").trim();
				String grp_Desc = req.getParameter("grp_Desc").trim();
//				String grp_visible = req.getParameter("grp_visible").trim();
				String grp_visible = "1";

				Part p = req.getPart("grp_photo");
				InputStream pin = p.getInputStream();
				byte[] grp_photo = new byte[pin.available()];
				pin.read(grp_photo);

				if (grp_photo.length == 0) {
					errorMsgs.add("請上傳一張相片");
				}
				
				System.out.println("grp_MemId"+grp_MemId);
				System.out.println("grp_name"+grp_name);
				System.out.println("grp_city"+grp_city);
				System.out.println("grp_town"+grp_town);
				System.out.println("grp_road"+grp_road);
				System.out.println("grp_EndTime"+grp_EndTime);
				System.out.println("grp_StartTime"+grp_StartTime);
				System.out.println("grp_Desc"+grp_Desc);
				System.out.println("grp_Long"+grp_Long);
				System.out.println("grp_Lat"+grp_Lat);
				System.out.println("grp_visible"+grp_visible);
				System.out.println("grp_photo"+grp_photo);
				
							
				grpVO.setGrp_MemId(grp_MemId);
				grpVO.setGrp_name(grp_name);
				grpVO.setGrp_city(grp_city);
				grpVO.setGrp_town(grp_town);
				grpVO.setGrp_road(grp_road);
				grpVO.setGrp_EndTime(grp_EndTime);
				grpVO.setGrp_StartTime(grp_StartTime);
				grpVO.setGrp_CreateTime(new java.sql.Date(System.currentTimeMillis()));
				grpVO.setGrp_Desc(grp_Desc);
				grpVO.setGrp_Long(grp_Long);
				grpVO.setGrp_Lat(grp_Lat);
				grpVO.setGrp_visible(grp_visible);
				grpVO.setGrp_photo(grp_photo);
								
				String requestURL = req.getParameter("requestURL");
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("grpVO", grpVO); 
					RequestDispatcher failureView = req.getRequestDispatcher(requestURL);
					failureView.forward(req, res);
					return;
				}

				System.out.println("grp_Desc= " + grp_Desc);
				/*************************** 2. ***************************************/
				GrpService empSvc = new GrpService();
				grpVO = empSvc.addGrp(grp_MemId, grp_name, grp_city, grp_town, grp_road, grp_StartTime, grp_EndTime,
						grp_Desc, grp_Long, grp_Lat, grp_visible, grp_photo);

				/***************************
				 * 3.(Send the Success view)
				 ***********/
				String url = null;
				if("/front-end/grp/addGrp_FrontEnd.jsp".equals(requestURL)){
					url="/front-end/grp/listOneGrp_Index.jsp";
				}
				
				if("/back-end/grp/addGrp.jsp".equals(requestURL)){
					url="/back-end/grp/listAllGrp.jsp";
				}
				
				req.setAttribute("includeInfo", "includeInfo");
				req.setAttribute("grpVO", grpVO); 
				
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				req.setAttribute("grpVO", grpVO);
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/grp/addGrp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			
				/***********************	 * 1.	 *************************/
				String grp_Id = req.getParameter("grp_Id").trim();
				
				/*************************** 2. ****************************************/
				GrpService grpSvc = new GrpService();
				GrpVO grpVO = grpSvc.getOneGrp(grp_Id);
				
				/*************************** 2. ****************************************/
				
				/*************************** 3.(Send the Success view) ************/
				
				req.setAttribute("includeInfo", "includeInfo");
				req.setAttribute("grpVO", grpVO); 
				String url = "/front-end/grp/listOneGrp_Index.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
																				// update_emp_input.jsp
				successView.forward(req, res);

			
		}
		
		
		
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************
				 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
				 *************************/
				String grp_Id = req.getParameter("grp_Id").trim();
				System.out.println(grp_Id);
				/*************************** 2.�}�l�d�߸�� ****************************************/
				GrpService grpSvc = new GrpService();
				GrpVO grpVO = grpSvc.getOneGrp(grp_Id);

				/***************************
				 * 3.�d�ߧ���,�ǳ����(Send the Success view)
				 ************/
				req.setAttribute("grpVO", grpVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back-end/grp/update_grp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\���
																				// update_emp_input.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("錯誤:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/grp/listAllGrp.jsp");
				failureView.forward(req, res);
			}

		}

		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			GrpVO grpVO = new GrpVO();

			try {
				/***********************
				 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
				 *************************/
				String grp_Id = req.getParameter("grp_Id").trim();
				String grp_name = req.getParameter("grp_name").trim();
				String grp_MemId = req.getParameter("grp_MemId").trim();

				Timestamp grp_StartTime = null;
				Timestamp grp_EndTime = null;
				Date grp_CreateTime =null;
				
				String grp_StartTime_str = req.getParameter("grp_StartTime").trim();
				String grp_EndTime_str = req.getParameter("grp_EndTime").trim();

				System.out.println(grp_StartTime_str);
				System.out.println(grp_EndTime_str);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							
				grp_StartTime = new Timestamp(sdf.parse(grp_StartTime_str).getTime());
				grp_EndTime = new Timestamp(sdf.parse(grp_EndTime_str).getTime());
				grp_CreateTime = new java.sql.Date(System.currentTimeMillis());

				String check = "\\d{1,3}\\.\\d{1,6}";

				Double grp_Lat = null;

				if (req.getParameter("grp_Lat").trim().isEmpty()
						|| !req.getParameter("grp_Lat").trim().matches(check)) {
					grp_Lat = 0.0;
					errorMsgs.add("經度錯誤.");
				} else {
					grp_Lat = new Double(req.getParameter("grp_Lat").trim());
				}

				Double grp_Long = null;

				if (req.getParameter("grp_Lat").trim().isEmpty()
						|| !req.getParameter("grp_Long").trim().matches(check)) {
					grp_Long = 0.0;
					errorMsgs.add("緯度錯誤.");
				} else {
					grp_Long = new Double(req.getParameter("grp_Long").trim());
				}

				String grp_city = req.getParameter("grp_city").trim();
				String grp_town = req.getParameter("grp_town").trim();
				String grp_road = req.getParameter("grp_road").trim();
				String grp_Desc = req.getParameter("grp_Desc").trim();
				String grp_visible = req.getParameter("grp_visible").trim();

				Part p = req.getPart("grp_photo");
				InputStream pin = p.getInputStream();
				byte[] grp_photo = new byte[pin.available()];
				pin.read(grp_photo);

				if (grp_photo.length == 0) {
					GrpService grpSvc = new GrpService();
					grp_photo = grpSvc.getOneGrp(grp_Id).getGrp_photo();
				}

				grpVO.setGrp_Id(grp_Id);
				grpVO.setGrp_MemId(grp_MemId);
				grpVO.setGrp_name(grp_name);
				grpVO.setGrp_city(grp_city);
				grpVO.setGrp_town(grp_town);
				grpVO.setGrp_road(grp_road);
				grpVO.setGrp_EndTime(grp_EndTime);
				grpVO.setGrp_StartTime(grp_StartTime);
				grpVO.setGrp_CreateTime(grp_CreateTime);
				grpVO.setGrp_Desc(grp_Desc);
				grpVO.setGrp_Long(grp_Long);
				grpVO.setGrp_Lat(grp_Lat);
				grpVO.setGrp_visible(grp_visible);
				grpVO.setGrp_photo(grp_photo);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("grpVO", grpVO); // req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/grp/update_grp_input.jsp");
					failureView.forward(req, res);
					return;
				}

				System.out.println(grp_Desc);
				/*************************** 2.�}�l�s�W��� ***************************************/
				GrpService grpSvc = new GrpService();
				grpVO = grpSvc.updateGrp(grp_Id, grp_MemId, grp_name, grp_city, grp_town, grp_road, grp_StartTime,
						grp_EndTime, grp_CreateTime ,grp_Desc, grp_Long, grp_Lat, grp_visible, grp_photo);

				/***************************
				 * 3.�s�W����,�ǳ����(Send the Success view)
				 ***********/
				String url = "/back-end/grp/listAllGrp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				req.setAttribute("grpVO", grpVO); // req
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/grp/update_grp_input.jsp");
				failureView.forward(req, res);
			}

		}

		// if ("delete".equals(action)) { // 
		//
		// List<String> errorMsgs = new LinkedList<String>();
		// // Store this set in the request scope, in case we need to
		// // send the ErrorPage view.
		// req.setAttribute("errorMsgs", errorMsgs);
		//
		// try {
		// /***************************1.***************************************/
		// String grp_Id = req.getParameter("grp_Id");
		//
		//
		//
		// /***************************2.�}�l�R�����***************************************/
		// GrpService grpSvc = new GrpService();
		// grpSvc.deleteGrp(grp_Id);
		//
		// /***************************3.�R������,�ǳ����(Send the Success
		// view)***********/
		// String url = "/grp/listAllGrp.jsp";
		// RequestDispatcher successView = req.getRequestDispatcher(url);//
		// �R�����\��,���^�e�X�R�����ӷ�����
		// successView.forward(req, res);
		//
		// /***************************��L�i�઺���~�B�z**********************************/
		// } catch (Exception e) {
		// errorMsgs.add("錯誤訊息:"+e.getMessage());
		// RequestDispatcher failureView = req
		// .getRequestDispatcher("/grp/listAllGrp.jsp");
		// failureView.forward(req, res);
		// }
		// }
		
		if ("listComments_ByGrpId".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1. ****************************************/
				String grp_Id = req.getParameter("grp_Id");

				/*************************** 2. ****************************************/
				GrpService grpSvc = new GrpService();
				Set<GrpCommVO> set = grpSvc.getCommentsByGrpId(grp_Id);
				
				/*************************** 3.(Send the Success view) ************/
				req.setAttribute("listComments_ByGrpId", set);    
				req.setAttribute("grpVO", grpSvc.getOneGrp(grp_Id));
				
				String url = null;
				String requestURL = req.getParameter("requestURL");
				
System.out.println(requestURL);
System.out.println("grp_Id="+grp_Id);
				
				if(requestURL.equals("/back-end/grp/listAllGrp.jsp")){
					url="/back-end/grp/listComments_ByGrpId.jsp";
				}
						
				if (requestURL.equals("/front-end/grp/listOneGrp_Index.jsp")){
					url = "/front-end/grp/listComments_ByGrpId_FrontEnd.jsp";   // 從/hos/listOneHos_Index.jsp來的
				}           

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
		
		if ("login".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
			
				String loginMemId = req.getParameter("loginMemId");
								
				String url = null;
				
				req.getSession().setAttribute("loginMemId", loginMemId);
				
				url = "/back-end/grp/listAllGrp.jsp";         

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}	
		
		
		
		if ("listJoinMem_ByGrpId".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1. ****************************************/
				String grp_Id = req.getParameter("grp_Id");

				/*************************** 2. ****************************************/
				GrpService grpSvc = new GrpService();
				Set<JoinListVO> set = grpSvc.getJoinListByGrpId(grp_Id);
				
				/*************************** 3.(Send the Success view) ************/
				req.setAttribute("listJoinMem_ByGrpId", set);    
				req.setAttribute("grpVO", grpSvc.getOneGrp(grp_Id));
				req.setAttribute("includeJoinList","includeJoinList");
				String url = null;
				String requestURL = req.getParameter("requestURL");
				
System.out.println(requestURL);
System.out.println("grp_Id="+grp_Id);
				
//				if(requestURL.equals("/back-end/grp/listAllGrp.jsp")){
//					url="/back-end/grp/listComments_ByGrpId.jsp";
//				}
						
				if (requestURL.equals("/front-end/grp/listOneGrp_Index.jsp")){
					url = "/front-end/grp/listJoinMem_ByGrpId_FrontEnd.jsp";   // 從/hos/listOneHos_Index.jsp來的
				}           

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
		
	}
}
