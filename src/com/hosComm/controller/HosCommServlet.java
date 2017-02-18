package com.hosComm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.hos.model.HosService;
import com.hosComm.model.HosCommService;
import com.hosComm.model.HosCommVO;
import com.hosPhoto.model.HosPhotoService;
import com.hosPhoto.model.HosPhotoVO;

/**
 * Servlet implementation class HosCommServlet
 */
public class HosCommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HosCommServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String hosComment_MemId = (String) req.getSession().getAttribute("Mem_Id_3");
		
		if ("insert".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
//			try {
				req.setAttribute("errorMsgs", errorMsgs);

				// try {
				
				/***********************
				 * 1.
				 *************************/
				String hosComment_HosId = req.getParameter("hos_Id").trim();
				String hosComment_content = req.getParameter("hosComment_content").trim();

				System.out.println("servlet insert hosComment_HosId" + hosComment_HosId);

				HosCommVO hosCommVO = new HosCommVO();

				hosCommVO.setHosComment_content(hosComment_content);
				hosCommVO.setHosComment_HosId(hosComment_HosId);
				hosCommVO.setHosComment_MemId(hosComment_MemId);

				if (hosComment_content.equals(""))
					errorMsgs.add("未輸入留言");

				HosCommService hcSvc = new HosCommService();
				hcSvc.insert(hosCommVO);
				/***************************
				 * 3.�s�W����,�ǳ����(Send the Success view)
				 ***********/
				String requestURL = req.getParameter("requestURL");
				
				if(requestURL.equals("/front-end/hos/listComments_ByHosId_FrontEnd.jsp")){
					requestURL = "/front-end/hos/listOneHos_Index.jsp";
				}
				
				HosService hosSvc = new HosService();
				
				req.setAttribute("hosVO", hosSvc.getOneHos(hosComment_HosId));
				req.setAttribute("listComments_ByHosId", hosSvc.getCommentsByHosId(hosComment_HosId));
				req.setAttribute("listPhotos_ByHosId", hosSvc.getPhotosByHosId(hosComment_HosId));
				req.setAttribute("includeComment", "includeComment");
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);

//			} catch (Exception e) {
//				errorMsgs.add("錯誤訊息:" + e.getMessage());
//				RequestDispatcher failureView = req.getRequestDispatcher("/hos/listOneHos_Index.jsp");
//				failureView.forward(req, res);
//			}
		}

		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				// /*************************** 1.�����ШD�Ѽ�
				// ***************************************/
				String hosComment_Id = req.getParameter("hosComment_Id").trim();
				String hosComment_HosId = req.getParameter("hosComment_HosId").trim();
						
				// /***** 2*******//
				HosCommService hcSvc = new HosCommService();
				hcSvc.delete(hosComment_Id);

				// /***************************
				// * 3.�R������,�ǳ����(Send the Success view)
				// ***********/

				String requestURL = req.getParameter("requestURL");
				
				if(requestURL.equals("/front-end/hos/listComments_ByHosId_FrontEnd.jsp")){
					requestURL = "/front-end/hos/listOneHos_Index.jsp";
				}

				HosService hosSvc = new HosService();
				req.setAttribute("hosVO", hosSvc.getOneHos(hosComment_HosId));
				req.setAttribute("listComments_ByHosId", hosSvc.getCommentsByHosId(hosComment_HosId));
				req.setAttribute("listPhotos_ByHosId", hosSvc.getPhotosByHosId(hosComment_HosId));
				req.setAttribute("includeComment", "includeComment");

				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				// �R�����\��,���^�e�X�R�����ӷ�����
				 successView.forward(req, res);

				// /*************************** ��L�i�઺���~�B�z
				// **********************************/
			} catch (Exception e) {
				errorMsgs.add("錯誤訊息:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hos/listAllHos.jsp");
				failureView.forward(req, res);
			}
		}
		

		if ("updateComment".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			try {
				req.setAttribute("errorMsgs", errorMsgs);

				// try {
				/***********************
				 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
				 *************************/
				String hosComment_HosId = req.getParameter("hosComment_HosId").trim();
				String hosComment_Id = req.getParameter("hosComment_Id").trim();
							
				System.out.println("servlet updateComment="+hosComment_Id);
							
				/***************************
				 * 3.(Send the Success view)
				 ***********/
				String requestURL = req.getParameter("requestURL");
				
				if(requestURL.equals("/front-end/hos/listComments_ByHosId_FrontEnd.jsp")){
					requestURL = "/front-end/hos/listOneHos_Index.jsp";
				}
				
				HosService hosSvc = new HosService();
				req.setAttribute("hosVO", hosSvc.getOneHos(hosComment_HosId));
				req.setAttribute("listComments_ByHosId", hosSvc.getCommentsByHosId(hosComment_HosId));
				req.setAttribute("listPhotos_ByHosId", hosSvc.getPhotosByHosId(hosComment_HosId));
				req.setAttribute("includeComment", "includeComment");
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("錯誤訊息:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hos/listAllHos.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("confirmUpdateComment".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			try {
				req.setAttribute("errorMsgs", errorMsgs);

				// try {
				/***********************
				 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
				 *************************/
				String hosComment_HosId = req.getParameter("hosComment_HosId").trim();
				String hosComment_Id = req.getParameter("forUpdateHosComment_Id").trim();
				String hosComment_content = req.getParameter("hosComment_content").trim();
				System.out.println("confirmUpdateComment"+hosComment_Id);

				HosCommVO hosCommVO = new HosCommVO();
				
				
				hosCommVO.setHosComment_Id(hosComment_Id);
				hosCommVO.setHosComment_content(hosComment_content);
				hosCommVO.setHosComment_HosId(hosComment_HosId);
				hosCommVO.setHosComment_MemId(hosComment_MemId);
				
				HosCommService hcSvc = new HosCommService();
				hcSvc.update(hosCommVO);
				
				
				/***************************
				 * 3.�s�W����,�ǳ����(Send the Success view)
				 ***********/
				String requestURL = req.getParameter("requestURL");
				
				if(requestURL.equals("/front-end/hos/listComments_ByHosId_FrontEnd.jsp")){
					requestURL = "/front-end/hos/listOneHos_Index.jsp";
				}
				
				if(hosComment_content==null){
					errorMsgs.add("未輸入訊息");
				}
				
				
				HosService hosSvc = new HosService();
				req.setAttribute("hosVO", hosSvc.getOneHos(hosComment_HosId));
				req.setAttribute("listComments_ByHosId", hosSvc.getCommentsByHosId(hosComment_HosId));
				req.setAttribute("listPhotos_ByHosId", hosSvc.getPhotosByHosId(hosComment_HosId));
				req.setAttribute("includeComment", "includeComment");
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("錯誤訊息:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hos/listAllHos.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		
		
	}

}
