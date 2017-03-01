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
			
				req.setAttribute("errorMsgs", errorMsgs);

				
				String grpComment_GrpId = req.getParameter("grp_Id").trim();
				String grpComment_content = req.getParameter("grpComment_content").trim();

System.out.println("insert grpcomm grpComment_GrpId"+grpComment_GrpId);
System.out.println("insert grpcomm grpComment_content"+grpComment_content);
System.out.println("insert grpcomm grpComment_MemId"+grpComment_MemId);


				GrpCommVO grpCommVO = new GrpCommVO();

				grpCommVO.setGrpComment_content(grpComment_content);
				grpCommVO.setGrpComment_GrpId(grpComment_GrpId);
				grpCommVO.setGrpComment_MemId(grpComment_MemId);

				if (grpComment_content.equals(""))
					errorMsgs.add("錯誤訊息:沒輸入訊息");

				GrpCommService grpCommSvc = new GrpCommService();
				grpCommSvc.insert(grpCommVO);

				GrpService grpSvc = new GrpService();
								
				req.setAttribute("listComments_ByGrpId", grpSvc.getCommentsByGrpId(grpComment_GrpId));
				req.setAttribute("includeComment", "includeComment");
				req.setAttribute("grpVO", grpSvc.getOneGrp(grpComment_GrpId));

				
				String requestURL = req.getParameter("requestURL");
				String url = requestURL;
				
				System.out.println("servlet insert grpComment_GrpId" + grpComment_GrpId);
				System.out.println("insert requestURL="+requestURL);
				
				if(requestURL.equals("/front-end/grp/listComments_ByGrpId_FrontEnd.jsp")){
					url = "/front-end/grp/listOneGrp_Index.jsp";
				}
				
				if(!errorMsgs.isEmpty()){
					RequestDispatcher failureView = req.getRequestDispatcher(url);
					failureView.forward(req, res);
				}				
				
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

		}

		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			
				// /******* 1.****/
				String grpComment_Id = req.getParameter("grpComment_Id").trim();
				String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
						
				// /******* 2.****/
				GrpCommService hcSvc = new GrpCommService();
				hcSvc.delete(grpComment_Id);

				//  3.(Send the Success view)

				GrpService grpSvc = new GrpService();
				
				req.setAttribute("listComments_ByGrpId", grpSvc.getCommentsByGrpId(grpComment_GrpId));
				req.setAttribute("includeComment", "includeComment");
				req.setAttribute("grpVO", grpSvc.getOneGrp(grpComment_GrpId));

				String requestURL = req.getParameter("requestURL");
				String url = requestURL;
				
				if(requestURL.equals("/front-end/grp/listComments_ByGrpId_FrontEnd.jsp")){
					url = "/front-end/hos/listOneHos_Index.jsp";
				}
			
				 if(!errorMsgs.isEmpty()){
						RequestDispatcher failureView = req.getRequestDispatcher(url);
						failureView.forward(req, res);
					}	
				
				RequestDispatcher successView = req.getRequestDispatcher(url);
		    	 successView.forward(req, res);

		}
		

		if ("updateComment".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			
				req.setAttribute("errorMsgs", errorMsgs);

				
				/***** 1.****/
				String grpComment_GrpId = req.getParameter("grpComment_GrpId").trim();
				String grpComment_Id = req.getParameter("grpComment_Id").trim();
							
				System.out.println("servlet updateComment="+grpComment_Id);
							
				/***** 3.(Send the Success view) *****/
				
				GrpService grpSvc = new GrpService();
				
				req.setAttribute("listComments_ByGrpId", grpSvc.getCommentsByGrpId(grpComment_GrpId));
				req.setAttribute("includeComment", "includeComment");
				req.setAttribute("grpVO", grpSvc.getOneGrp(grpComment_GrpId));
				
				
				String requestURL = req.getParameter("requestURL");
				String url = requestURL;
				
System.out.println("updateComment requestURL"+requestURL);
				
				if(requestURL.equals("/front-end/grp/listComments_ByGrpId_FrontEnd.jsp")){
					url = "/front-end/grp/listOneGrp_Index.jsp";
				}
				
				
				 if(!errorMsgs.isEmpty()){
						RequestDispatcher failureView = req.getRequestDispatcher(url);
						failureView.forward(req, res);
					}					
				
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

		}
		
		
		if ("confirmUpdateComment".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			
				req.setAttribute("errorMsgs", errorMsgs);

				// try {
				/****1. *****/
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
				
				
				/** 3.(Send the Success view)***/
				
				if(grpComment_content==null)errorMsgs.add("錯誤訊息:沒輸入訊息");
				
				
				GrpService grpSvc = new GrpService();
				req.setAttribute("listComments_ByGrpId", grpSvc.getCommentsByGrpId(grpComment_GrpId));
				req.setAttribute("includeComment", "includeComment");
				req.setAttribute("grpVO", grpSvc.getOneGrp(grpComment_GrpId));
				
				String requestURL = req.getParameter("requestURL");
				String url = requestURL;
				
				
				
				if(requestURL.equals("/front-end/grp/listComments_ByGrpId_FrontEnd.jsp")){
					url = "/front-end/grp/listOneGrp_Index.jsp";
				}				
				
				if(!errorMsgs.isEmpty()){
					RequestDispatcher failureView = req.getRequestDispatcher(url);
					failureView.forward(req, res);
				}	
								
				RequestDispatcher successView = req.getRequestDispatcher(url); // listAllEmp.jsp
				successView.forward(req, res);

		}
				
	}

}
