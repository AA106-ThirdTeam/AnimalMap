package com.grpComm.controller;

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

import com.grp.model.GrpService;
import com.grpComm.model.GrpCommService;
import com.grpComm.model.GrpCommVO;


/**
 * Servlet implementation class GrpCommServlet
 */
public class GrpCommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GrpCommServlet() {
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
		String grpComment_MemId = (String) req.getSession().getAttribute("Mem_Id_3");
		
		if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			try {
				req.setAttribute("errorMsgs", errorMsgs);

				// try {
				/***********************
				 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
				 *************************/
				String grpComment_GrpId = req.getParameter("grp_Id").trim();
				String grpComment_content = req.getParameter("grpComment_content").trim();

				System.out.println("servlet insert grpComment_GrpId" + grpComment_GrpId);

				GrpCommVO grpCommVO = new GrpCommVO();

				grpCommVO.setGrpComment_content(grpComment_content);
				grpCommVO.setGrpComment_GrpId(grpComment_GrpId);
				grpCommVO.setGrpComment_MemId(grpComment_MemId);

				if (grpComment_content.equals(""))
					throw new Exception("沒輸入訊息");

				GrpCommService hcSvc = new GrpCommService();
				hcSvc.insert(grpCommVO);
				/***************************
				 * 3.�s�W����,�ǳ����(Send the Success view)
				 ***********/
				String requestURL = req.getParameter("requestURL");
				
				GrpService grpSvc = new GrpService();
				req.setAttribute("listComments_ByGrpId", grpSvc.getCommentsByGrpId(grpComment_GrpId));
				req.setAttribute("grp_Id",grpComment_GrpId);
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("錯誤訊息:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/grp/listAllGrp.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				// /*************************** 1.�����ШD�Ѽ�
				// ***************************************/
				String grpComment_Id = req.getParameter("grpComment_Id").trim();
				String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
						
				// /*************************** 2.�}�l�R�����
				// ***************************************/
				GrpCommService hcSvc = new GrpCommService();
				hcSvc.delete(grpComment_Id);

				// /***************************
				// * 3.�R������,�ǳ����(Send the Success view)
				// ***********/

				String requestURL = req.getParameter("requestURL");

				GrpService grpSvc = new GrpService();
				req.setAttribute("listComments_ByGrpId", grpSvc.getCommentsByGrpId(grpComment_GrpId));

				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				// �R�����\��,���^�e�X�R�����ӷ�����
				 successView.forward(req, res);

				// /*************************** ��L�i�઺���~�B�z
				// **********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/grp/listAllGrp.jsp");
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
				String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
				String grpComment_Id = req.getParameter("grpComment_Id").trim();
							
				System.out.println("servlet updateComment="+grpComment_Id);
							
				/***************************
				 * 3.�s�W����,�ǳ����(Send the Success view)
				 ***********/
				String requestURL = req.getParameter("requestURL");
				
				GrpService grpSvc = new GrpService();
				req.setAttribute("listComments_ByGrpId", grpSvc.getCommentsByGrpId(grpComment_GrpId));
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("����:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/grp/listAllGrp.jsp");
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
				String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
				String grpComment_Id = req.getParameter("forUpdateGrpComment_Id").trim();
				String grpComment_content = req.getParameter("grpComment_content").trim();
				System.out.println("confirmUpdateComment"+grpComment_Id);

				GrpCommVO grpCommVO = new GrpCommVO();
				
				
				grpCommVO.setGrpComment_Id(grpComment_Id);
				grpCommVO.setGrpComment_content(grpComment_content);
				grpCommVO.setGrpComment_GrpId(grpComment_GrpId);
				grpCommVO.setGrpComment_MemId(grpComment_MemId);
				
				System.out.println("setGrpComment_MemId = "+grpCommVO.getGrpComment_MemId());
				
				GrpCommService hcSvc = new GrpCommService();
				hcSvc.update(grpCommVO);
				
				
				/***************************
				 * 3.�s�W����,�ǳ����(Send the Success view)
				 ***********/
				String requestURL = req.getParameter("requestURL");
				
				if(grpComment_content==null){
					throw new Exception("�п�J�ק鷺�e");
				}
				
				
				GrpService grpSvc = new GrpService();
				req.setAttribute("listComments_ByGrpId", grpSvc.getCommentsByGrpId(grpComment_GrpId));
								
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("�ק異��:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/grp/listAllGrp.jsp");
				failureView.forward(req, res);
			}
		}
				
	}

}
