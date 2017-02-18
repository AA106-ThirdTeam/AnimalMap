package com.hosPhoto.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.hos.model.HosService;
import com.hos.model.HosVO;
import com.hosPhoto.model.HosPhotoService;
import com.hosPhoto.model.HosPhotoVO;

/**
 * Servlet implementation class HosPhotoServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class HosPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HosPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
			
		
		if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			// try {
			/******	 * 1.********/
			String hos_Id = req.getParameter("hos_Id").trim();
			
			List<HosPhotoVO> photoList = new ArrayList<>();
			Collection<Part> parts = req.getParts();

			for (Part part : parts) {

				if (getFileNameFromPart(part) != null && part.getContentType() != null) {
					if (part.getContentType().indexOf("image") != (-1)) {
						HosPhotoVO hosPhotoVO = new HosPhotoVO();

						InputStream in = part.getInputStream();
						byte[] buf = new byte[in.available()];
						in.read(buf);
						in.close();

						hosPhotoVO.setHosPhoto_photo(buf);
						photoList.add(hosPhotoVO);
					}
			   }
			}
			HosPhotoService hpSvc = new HosPhotoService();
			hpSvc.addPhoto(hos_Id, photoList);
			/***************************
			 * 3.(Send the Success view)
			 ***********/
			String requestURL = req.getParameter("requestURL");
			
//			System.out.println("insert requestURL= "+requestURL);
			
			if(requestURL.equals("/front-end/hos/listPhotos_ByHosId_FrontEnd.jsp")){
				requestURL = "/front-end/hos/listOneHos_Index.jsp";
			}
			
			
			
			HosService hosSvc = new HosService();
			
			req.setAttribute("hosVO", hosSvc.getOneHos(hos_Id));
			req.setAttribute("listPhotos_ByHosId", hosSvc.getPhotosByHosId(hos_Id));
			req.setAttribute("includePhoto", "includePhoto");
			
			String url = requestURL;
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}	
		
		
		if ("delete".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ***************************************/
				String hosPhoto_Id = req.getParameter("hosPhoto_Id").trim();
				String hosPhoto_HosId = req.getParameter("hosPhoto_HosId").trim();
				String isDisp_HosPhoto = req.getParameter("isDisp_HosPhoto").trim();
				
				if(isDisp_HosPhoto.equals("1")){
					throw new Exception("請將其他照片設回大頭貼再刪除");
				}
				
				/*************************** 2.�}�l�R����� ***************************************/
				HosPhotoService hpSvc = new HosPhotoService();
				hpSvc.deletePhoto(hosPhoto_Id);

				/***************************
				 * 3.(Send the Success view)
				 ***********/
				
				String requestURL = req.getParameter("requestURL");
				
				if(requestURL.equals("/front-end/hos/listPhotos_ByHosId_FrontEnd.jsp")){
					requestURL = "/front-end/hos/listOneHos_Index.jsp";
				}
				
				
				
				HosService hosSvc = new HosService();
				
				req.setAttribute("hosVO", hosSvc.getOneHos(hosPhoto_HosId));
				req.setAttribute("listPhotos_ByHosId", hosSvc.getPhotosByHosId(hosPhoto_HosId));
				req.setAttribute("includePhoto", "includePhoto");
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除失敗，原因:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hos/listAllHos.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("setDisplayPhoto".equals(action)) { // 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1. ***************************************/
				String hosPhoto_Id = req.getParameter("hosPhoto_Id").trim();
				String hosPhoto_HosId =req.getParameter("hosPhoto_HosId").trim();
						
				
				/*************************** 2. ***************************************/
				HosPhotoService hpSvc = new HosPhotoService();
				hpSvc.setDisplayPhoto(hosPhoto_Id,hosPhoto_HosId);

				/***************************
				 * 3.(Send the Success view)
				 ***********/
				
//				String requestURL = req.getParameter("requestURL");
				String requestURL = req.getParameter("requestURL");
				
				if(requestURL.equals("/front-end/hos/listPhotos_ByHosId_FrontEnd.jsp")){
					requestURL = "/front-end/hos/listOneHos_Index.jsp";
				}
				
				HosService hosSvc = new HosService();
				req.setAttribute("listPhotos_ByHosId", hosSvc.getPhotosByHosId(hosPhoto_HosId));
				req.setAttribute("hosVO", hosSvc.getOneHos(hosPhoto_HosId));
				req.setAttribute("includePhoto", "includePhoto");
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			
			} catch (Exception e) {
				errorMsgs.add("設定大頭貼失敗，原因:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hos/listAllHos.jsp");
				failureView.forward(req, res);
			}
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
