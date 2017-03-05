package com.hos.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.hos.model.HosService;
import com.hos.model.HosVO;
import com.hosComm.model.HosCommVO;
import com.hosPhoto.model.HosPhotoVO;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class HosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.print("action=" + action);

		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** * 1. *************************/

				String hos_Id = req.getParameter("hos_Id").trim();
				System.out.println(hos_Id);
				/*************************** 2. ****************************************/
				HosService hosSvc = new HosService();
				HosVO hosVO = hosSvc.getOneHos(hos_Id);
				/*************************** 2.�}�l�d�߸�� ****************************************/
				Set<HosPhotoVO> hosPhotoSet = new LinkedHashSet();
				hosPhotoSet = hosSvc.getPhotosByHosId(hos_Id);

				/***************************
				 * 3.�d�ߧ���,�ǳ����(Send the Success view)
				 ************/
				req.setAttribute("hosPhotoSet", hosPhotoSet); // ��Ʈw���X��set����,�s�Jrequest
				req.setAttribute("includeInfo", "includeInfo");
				/***************************
				 * 3.(Send the Success view)
				 ************/

				req.setAttribute("hosVO", hosVO);
				String url = "/front-end/hos/listOneHos_Index.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				// update_emp_input.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("錯誤訊息:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/hos/listOneHos_Index.jsp");
				failureView.forward(req, res);
			}

		}

		if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL");
			System.out.println("requestURL===" + requestURL);

			// try {
			/***********************
			 * 1.
			 *************************/
			String hos_name = req.getParameter("hos_name").trim();
			String hos_MemId = req.getParameter("hos_MemId").trim();

			String hos_StartTime = req.getParameter("hos_StartTime").trim();
			String hos_EndTime = req.getParameter("hos_EndTime").trim();

			if (hos_StartTime.isEmpty() || hos_EndTime.isEmpty())
				errorMsgs.add("營業時間未輸入!");

			Integer Eval = null;
			try {
				// Eval = new Integer(req.getParameter("hos_Eval").trim());
				Eval = 0;
			} catch (NumberFormatException e) {
				Eval = 0;
				errorMsgs.add("評價錯誤");
			}

			String check = "\\d{1,3}\\.\\d{1,6}";

			Double hos_Lat = null;
			try {
				hos_Lat = new Double(req.getParameter("hos_Lat").trim());
				// hos_Lat = 123.22;
				// if (!req.getParameter("hos_Lat").trim().matches(check))
				// throw new NumberFormatException();
			} catch (NumberFormatException e) {
				hos_Lat = 0.0;
				errorMsgs.add("緯度錯誤");
			}

			Double hos_Long = null;
			try {
				hos_Long = new Double(req.getParameter("hos_Long").trim());
				// hos_Long = 111.11;
				// if (!req.getParameter("hos_Long").trim().matches(check))
				// throw new NumberFormatException();
			} catch (NumberFormatException e) {
				hos_Long = 0.0;
				errorMsgs.add("經度錯誤");
			}

			String hos_city = req.getParameter("hos_city").trim();
			String hos_town = req.getParameter("hos_town").trim();
			String hos_road = req.getParameter("hos_road").trim();
			String hos_Desc = req.getParameter("hos_Desc").trim();
			// String hos_visible = req.getParameter("hos_visible").trim();
			String hos_visible = "1";
			// Integer hos_Eval =
			// Integer.valueOf(req.getParameter("hos_Eval").trim());
			Integer hos_Eval = 0;
			String hos_URL = req.getParameter("hos_URL").trim();
			String hos_Tel = req.getParameter("hos_Tel").trim();

			HosVO hosVO = new HosVO();
			hosVO.setHos_MemId(hos_MemId);
			hosVO.setHos_name(hos_name);
			hosVO.setHos_city(hos_city);
			hosVO.setHos_town(hos_town);
			hosVO.setHos_road(hos_road);
			hosVO.setHos_EndTime(hos_EndTime);
			hosVO.setHos_StartTime(hos_StartTime);
			hosVO.setHos_CreateTime(new java.sql.Date(System.currentTimeMillis()));
			hosVO.setHos_Desc(hos_Desc);
			hosVO.setHos_Long(hos_Long);
			hosVO.setHos_Lat(hos_Lat);
			hosVO.setHos_visible(hos_visible);
			hosVO.setHos_Eval(hos_Eval);
			hosVO.setHos_URL(hos_URL);
			hosVO.setHos_Tel(hos_Tel);

			List<HosPhotoVO> photoList = new ArrayList<>();
			Collection<Part> parts = req.getParts();
			int isDisplayPhoto = 0;

			try {
				isDisplayPhoto = Integer.valueOf(req.getParameter("isDisplayPhoto"));
			} catch (NumberFormatException e) {
				isDisplayPhoto = 0;
			}
			int checkDisplay = 0;

			// System.out.println(parts.size());
			// System.out.println("isDisplayPhoto = " +isDisplayPhoto);
			for (Part part : parts) {

				if (getFileNameFromPart(part) != null && part.getContentType() != null) {
					if (part.getContentType().indexOf("image") != (-1)) {
						HosPhotoVO hosPhotoVO = new HosPhotoVO();

						InputStream in = part.getInputStream();
						byte[] buf = new byte[in.available()];
						in.read(buf);
						in.close();

						if ((checkDisplay++) == isDisplayPhoto) {
							hosPhotoVO.setIsDisp_HosPhoto("1");
						} else
							hosPhotoVO.setIsDisp_HosPhoto("0");

						// System.out.println("checkDisplay = " + checkDisplay);

						hosPhotoVO.setHosPhoto_photo(buf);
						photoList.add(hosPhotoVO);
					}

				}
			}

			if (photoList.size() == 0) {
				errorMsgs.add("請加照片");
			}

			// for (HosPhotoVO hpVO : photoList) {
			// System.out.println("hpVO.getIsDisp_HosPhoto()=" +
			// hpVO.getIsDisp_HosPhoto());
			// }

			// Send the use back to the form, if there were errors

			System.out.println(hos_MemId);
			System.out.println(hos_name);
			System.out.println(hos_city);
			System.out.println(hos_town);
			System.out.println(hos_road);
			System.out.println(hos_EndTime);
			System.out.println(hos_StartTime);
			System.out.println(hos_Desc);
			System.out.println(hos_Long);
			System.out.println(hos_Lat);
			System.out.println(hos_visible);
			System.out.println(hos_Eval);
			System.out.println(hos_URL);
			System.out.println(hos_Tel);
			System.out.println(photoList);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("hosVO", hosVO);
				RequestDispatcher failureView = req.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.�}�l�s�W��� ***************************************/
			HosService hosSvc = new HosService();
			hosVO = hosSvc.addHos(hos_MemId, hos_name, hos_city, hos_town, hos_road, hos_EndTime, hos_StartTime,
					hos_Desc, hos_Long, hos_Lat, hos_visible, hos_Eval, hos_URL, hos_Tel, photoList);

			/***************************
			 * 3.(Send the Success view)
			 ***********/
			String url = null;

			if ("/front-end/hos/addHos_FrontEnd.jsp".equals(requestURL)) {
				url = "/front-end/hos/listOneHos_Index.jsp";
				Set<HosPhotoVO> hosPhotoSet = hosSvc.getPhotosByHosId(hosVO.getHos_Id());
				req.setAttribute("hosPhotoSet", hosPhotoSet);
				req.setAttribute("hosVO", hosVO);
				req.setAttribute("includeInfo", "includeInfo");
			}

			if ("/back-end/hos/addHos.jsp".equals(requestURL)) {
				url = "/back-end/hos/listAllHos.jsp";
			}

			RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
			successView.forward(req, res);

			// } catch (Exception e) {
			// errorMsgs.add(e.getMessage());
			// RequestDispatcher failureView =
			// req.getRequestDispatcher("/hos/addHos.jsp");
			// failureView.forward(req, res);
			// }
		}

		if ("getOne_For_Update".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***** 1. *****/
				String hos_Id = req.getParameter("hos_Id").trim();

				/*************************** 2.�}�l�d�߸�� ****************************************/
				HosService hosSvc = new HosService();
				HosVO hosVO = hosSvc.getOneHos(hos_Id);

				/***************************
				 * 3.(Send the Success view)
				 ************/
				req.setAttribute("hosVO", hosVO);

				String url = null;
				String requestURL = req.getParameter("requestURL");
				if (requestURL.equals("/back-end/hos/listAllHos.jsp")) {
					url = "/back-end/hos/update_hos_input.jsp";
				}

				if (requestURL.equals("/front-end/hos/listOneHos_Index.jsp")) {
					url = "/front-end/hos/update_hos_input_FrontEnd.jsp"; // 從/hos/listOneHos_Index.jsp來的
				}

				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\���
																				// update_emp_input.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hos/listAllHos.jsp");
				failureView.forward(req, res);
			}

		}

		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			// try {
			/***********************
			 * 1.
			 *************************/
			String hos_Id = req.getParameter("hos_Id").trim();

			// System.out.println("hos_Id="+hos_Id);

			HosService hosSvc = new HosService();
			HosVO hosVO = hosSvc.getOneHos(hos_Id);

			String hos_MemId = hosVO.getHos_MemId();
			String hos_name = hosVO.getHos_name();
			String hos_city = hosVO.getHos_city();
			String hos_town = hosVO.getHos_town();
			String hos_road = hosVO.getHos_road();
			Integer hos_Eval = hosVO.getHos_Eval();
			String hos_URL = hosVO.getHos_URL();
			String hos_StartTime = hosVO.getHos_StartTime();
			String hos_EndTime = hosVO.getHos_EndTime();
			java.sql.Date hos_CreateTime = null;
			String hos_Tel = hosVO.getHos_Tel();
			String hos_Desc = hosVO.getHos_Desc();
			Double hos_Long = hosVO.getHos_Long();
			Double hos_Lat = hosVO.getHos_Lat();
			String hos_visible = hosVO.getHos_visible();

			String url = null;
			String requestURL = req.getParameter("requestURL");

			if (requestURL.equals("/back-end/hos/listAllHos.jsp")) {

				url = "/back-end/hos/listAllHos.jsp";
				if (req.getParameter("hos_MemId").trim().isEmpty()) {
					errorMsgs.add("請輸入會員編號");
				}

				try {
					hos_Eval = new Integer(req.getParameter("hos_Eval").trim());
				} catch (NumberFormatException e) {
					hos_Eval = 0;
					errorMsgs.add("請輸入評價");
				}

				hos_visible = req.getParameter("hos_visible").trim();
				String check = "\\d{1,3}\\.\\d{1,6}";

				try {
					hos_Lat = new Double(req.getParameter("hos_Lat").trim());
					if (!req.getParameter("hos_Lat").trim().matches(check))
						throw new NumberFormatException();
				} catch (NumberFormatException e) {
					hos_Lat = 0.0;
					errorMsgs.add("緯度不正確");
				}

				try {
					hos_Long = new Double(req.getParameter("hos_Long").trim());
					if (!req.getParameter("hos_Long").trim().matches(check))
						throw new NumberFormatException();
				} catch (NumberFormatException e) {
					hos_Long = 0.0;
					errorMsgs.add("經度不正確");
				}
			}

			System.out.println("requestURL=" + requestURL);

			if (requestURL.equals("/front-end/hos/listOneHos_Index.jsp")) {
				url = "/front-end/hos/listOneHos_Index.jsp"; // 從/hos/listOneHos_Index.jsp來的
				Set<HosPhotoVO> hosPhotoSet = new LinkedHashSet();
				hosPhotoSet = hosSvc.getPhotosByHosId(hos_Id);
				System.out.println(hos_Id);
				/***************************
				 * 3.�d�ߧ���,�ǳ����(Send the Success view)
				 ************/
				req.setAttribute("hosPhotoSet", hosPhotoSet); // ��Ʈw���X��set����,�s�Jrequest
				req.setAttribute("includeInfo", "includeInfo");
				req.setAttribute("hosVO", hosVO);
			}

			System.out.println("url=  " + url);

			if (req.getParameter("hos_name").trim().isEmpty()) {
				errorMsgs.add("請輸入醫院名稱");
			}

			try {
				hos_StartTime = req.getParameter("hos_StartTime").trim();
				hos_EndTime = req.getParameter("hos_EndTime").trim();
				if (hos_StartTime.isEmpty() || hos_EndTime.isEmpty())
					throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				errorMsgs.add("請輸入時間");
			}

			hos_name = req.getParameter("hos_name").trim();
			hos_CreateTime = new java.sql.Date(System.currentTimeMillis());
			hos_city = req.getParameter("hos_city").trim();
			hos_town = req.getParameter("hos_town").trim();
			hos_road = req.getParameter("hos_road").trim();
			hos_Desc = req.getParameter("hos_Desc").trim();
			hos_URL = req.getParameter("hos_URL").trim();
			hos_Tel = req.getParameter("hos_Tel").trim();

			hosVO.setHos_MemId(hos_Id);
			hosVO.setHos_MemId(hos_MemId);
			hosVO.setHos_name(hos_name);
			hosVO.setHos_city(hos_city);
			hosVO.setHos_town(hos_town);
			hosVO.setHos_road(hos_road);
			hosVO.setHos_EndTime(hos_EndTime);
			hosVO.setHos_StartTime(hos_StartTime);
			hosVO.setHos_CreateTime(hos_CreateTime);
			hosVO.setHos_Desc(hos_Desc);
			hosVO.setHos_Long(hos_Long);
			hosVO.setHos_Lat(hos_Lat);
			hosVO.setHos_visible(hos_visible);
			hosVO.setHos_Eval(hos_Eval);
			hosVO.setHos_URL(hos_URL);
			hosVO.setHos_Tel(hos_Tel);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("hosVO", hosVO); // �t����J�榡���~��hosVO����,�]�s�Jreq
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/hos/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.�}�l�s�W��� ***************************************/

			hosVO = hosSvc.updateHos(hos_Id, hos_MemId, hos_name, hos_city, hos_town, hos_road, hos_EndTime,
					hos_StartTime, hos_CreateTime, hos_Desc, hos_Long, hos_Lat, hos_visible, hos_Eval, hos_URL,
					hos_Tel);

			/***************************
			 * 3.�s�W����,�ǳ����(Send the Success view)
			 ***********/
			RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
			successView.forward(req, res);

			/*************************** ��L�i�઺���~�B�z **********************************/
			// } catch (Exception e) {
			//
			// errorMsgs.add(e.getMessage());
			// RequestDispatcher failureView =
			// req.getRequestDispatcher("/hos/update_hos_input.jsp");
			// failureView.forward(req, res);
			// }

		}

		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ***************************************/
				String hos_Id = req.getParameter("hos_Id");

				/*************************** 2.�}�l�R����� ***************************************/
				HosService hosSvc = new HosService();
				hosSvc.deleteHos(hos_Id);

				/***************************
				 * 3.�R������,�ǳ����(Send the Success view)
				 ***********/
				String url = "/hos/listAllHos.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hos/listAllHos.jsp");
				failureView.forward(req, res);
			}
		}

		if ("listPhotos_ByHosId".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String hosId = req.getParameter("hos_Id");

				/*************************** 2.�}�l�d�߸�� ****************************************/
				HosService hosSvc = new HosService();
				Set<HosPhotoVO> set = hosSvc.getPhotosByHosId(hosId);

				/***************************
				 * 3.�d�ߧ���,�ǳ����(Send the Success view)
				 ************/
				req.setAttribute("listPhotos_ByHosId", set);
				req.setAttribute("includePhotos", "includePhotos");

				String url = null;
				String requestURL = req.getParameter("requestURL");
				if (requestURL.equals("/back-end/hos/listAllHos.jsp")) {
					url = "/back-end/hos/listAllHos.jsp";
				}

				if (requestURL.equals("/front-end/hos/listOneHos_Index.jsp")) {
					url = "/front-end/hos/listPhotos_ByHosId_FrontEnd.jsp"; // 從/hos/listOneHos_Index.jsp來的
				}

				System.out.println("requestURL=" + requestURL);

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z ***********************************/
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}

		if ("listHos_BySearchCondition".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String searchCondition = req.getParameter("searchCondition").trim();

				/*************************** 2.�}�l�d�߸�� ****************************************/
				HosService hosSvc = new HosService();
				List<HosVO> list = hosSvc.searchAll(searchCondition);

				if (list.isEmpty()) {
					throw new Exception("查無資料");
				}

				/***************************
				 * 3.�d�ߧ���,�ǳ����(Send the Success view)
				 ************/
				req.setAttribute("listHos_BySearchCondition", list); // ��Ʈw���X��set����,�s�Jrequest

				// for(HosVO h:
				// (List<HosVO>)req.getAttribute("listHos_BySearchCondition")){
				// System.out.println(h.getHos_name());
				// }

				String url = "/back-end/hos/listAllHos.jsp";

				Set<HosPhotoVO> hosPhotoSet = new LinkedHashSet();
				if (list.size() == 1) {
					url = "/front-end/hos/listOneHos_Index.jsp";
					hosPhotoSet = hosSvc.getPhotosByHosId(list.get(0).getHos_Id());
					req.setAttribute("hosPhotoSet", hosPhotoSet);
					req.setAttribute("hosVO", hosSvc.getOneHos(list.get(0).getHos_Id()));
					req.setAttribute("includeInfo", "includeInfo");
				}

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z ***********************************/
			} catch (Exception e) {
				errorMsgs.add("錯誤訊息:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/hos/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("listComments_ByHosId".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1. ****************************************/
				String hos_Id = req.getParameter("hos_Id");

				/*************************** 2. ****************************************/
				HosService hosSvc = new HosService();
				Set<HosCommVO> commentSet = hosSvc.getCommentsByHosId(hos_Id);

				Set<HosPhotoVO> photoSet = hosSvc.getPhotosByHosId(hos_Id);
				/***************************
				 * 3.(Send the Success view)
				 ************/
				req.setAttribute("listComments_ByHosId", commentSet);
				req.setAttribute("listPhotos_ByHosId", photoSet);
				req.setAttribute("includeComments", "includeComments");
				req.setAttribute("hos_Id", hos_Id);

				String url = null;
				String requestURL = req.getParameter("requestURL");
				if (requestURL.equals("/back-end/hos/listAllHos.jsp")) {
					url = "/back-end/hos/listComments_ByHosId.jsp";
				}

				if (requestURL.equals("/front-end/hos/listOneHos_Index.jsp")) {
					url = "/front-end/hos/listComments_ByHosId_FrontEnd.jsp"; // 從/hos/listOneHos_Index.jsp來的
				}

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("錯誤訊息:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/hos/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("listHos_ByCompositeQuery".equals(action)) { // select_page.jsp
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/*************************** 1.Map **********************************/
				// Map<String,String[]> getParameterMap()
				// an immutable java.util.Map
				// Map<String, String[]> map = req.getParameterMap();
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>) session.getAttribute("map");

				if (req.getParameter("whichPage") == null) {
					HashMap<String, String[]> map1 = (HashMap<String, String[]>) req.getParameterMap();
					HashMap<String, String[]> map2 = new HashMap<String, String[]>();
					map2 = (HashMap<String, String[]>) map1.clone();
					session.setAttribute("map", map2);
					map = (HashMap<String, String[]>) req.getParameterMap();
				}

				/*************************** 2.�}�l�ƦX�d�� ***************************************/
				HosService hosSvc = new HosService();
				List<HosVO> list = hosSvc.getAll(map);

				if (list.isEmpty()) {
					errorMsgs.add("查無資料");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/hos/select_page.jsp");
					failureView.forward(req, res);
					return;
				}

				/***************************
				 * 3.�d�ߧ���,�ǳ����(Send the Success view)
				 ************/
				String url = "/back-end/hos/listAllHos.jsp";

				Set<HosPhotoVO> hosPhotoSet = new LinkedHashSet();
				if (list.size() == 1) {
					url = "/front-end/hos/listOneHos_Index.jsp";
					hosPhotoSet = hosSvc.getPhotosByHosId(list.get(0).getHos_Id());
					req.setAttribute("hosPhotoSet", hosPhotoSet);
					req.setAttribute("hosVO", hosSvc.getOneHos(list.get(0).getHos_Id()));
					req.setAttribute("includeInfo", "includeInfo");
				}

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/hos/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("report".equals(action)) {
			
			String hos_Id = req.getParameter("hos_Id");
			String loginMemId = req.getParameter("loginMemId");
			String hos_MemId = req.getParameter("hos_MemId");			
			
			HosService hosSvc = new HosService();
			HosVO hosVO = hosSvc.getOneHos(hos_Id);

			req.setAttribute("loginMemId", loginMemId);
			req.setAttribute("hosVO", hosVO);
			
						
			String url = "/front-end/hos/report.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

	}

	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		// System.out.println("header=" + header); // ���ե�
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		// System.out.println("filename=" + filename); // ���ե�
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
}
