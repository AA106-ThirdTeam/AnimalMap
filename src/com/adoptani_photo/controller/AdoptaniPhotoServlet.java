package com.adoptani_photo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.jsp.PageContext;

import com.adoptani.model.AdoptaniService;
import com.adoptani.model.AdoptaniVO;
import com.adoptani_photo.model.*;


@WebServlet("/adoptani_photo.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 10 * 1024 * 1024, maxRequestSize = 100 * 1024 * 1024)

public class AdoptaniPhotoServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		System.out.println("into AdoptaniPhotoServlet.java");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println(action);
		if ("getOne_For_Display".equals(action)  || "getOne_For_Display_From_listOneAdoptani.jsp".equals(action) || "getOne_For_Display_From_listAllAdoptani.jsp".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			AdoptaniVO adoptaniVO = (AdoptaniVO) req.getAttribute("adoptaniVO"); //AdoptaniVOServlet.java(Concroller), 存入req的adoptaniVO物件
			System.out.println("action:"+action);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("adopt_Ani_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入送養動物編號");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_photo/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer adopt_Ani_Id = null;
				try {
					adopt_Ani_Id = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("送養動物編號格式不正確");
				}
				System.out.println("adopt_Ani_Id:"+adopt_Ani_Id);
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_photo/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				AdoptaniPhotoService adoptaniPhotoSvc = new AdoptaniPhotoService();
				List<AdoptaniPhotoVO> oneAdoptAniPhotoList = adoptaniPhotoSvc.getOneAdoptaniPhoto(str);
				if (oneAdoptAniPhotoList == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_photo/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("oneAdoptAniPhotoList", oneAdoptAniPhotoList); 
				if("getOne_For_Display".equals(action)){
					String url = "/front-end/adoptani_photo/listOneAdoptaniPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
				}
				else if("getOne_For_Display_From_listOneAdoptani.jsp".equals(action)){
					System.out.println("查詢資料完成");
					String url = "/front-end/adoptani/listOneAdoptaniAllPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
				}
				else if("getOne_For_Display_From_listAllAdoptani.jsp".equals(action)){
					System.out.println("查詢資料完成");
					String url = "/front-end/adoptani/listOneAdoptaniAllPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
				}

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/adoptani_photo/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		
		 if ("insert".equals(action) || "insert_FromView".equals(action)) { // 來自addAdoptani.jsp的請求。 insert寫在前面比較好看。
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to send the ErrorPage view.
				System.out.println("here is \"insert\" in Controller (1)");
				req.setAttribute("errorMsgs", errorMsgs);
				
				List<byte[]> picList = new ArrayList();	//用來裝照片
				List<String> picTypeList = new ArrayList();	//用來裝照片類型(大頭貼(0)、or相簿照片(1))
				

				
				
				
				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					System.out.println("here is \"insert\" in Controller (2)");
					String mem_Id = req.getParameter("mem_Id");
					String adopt_Ani_Id = req.getParameter("adopt_Ani_Id");
					String ado_Pic_name = req.getParameter("ado_Pic_name");
					if (ado_Pic_name == null || (ado_Pic_name.trim()).length() == 0) {
						errorMsgs.add("請輸入送養動物名字");
					}
					String ado_Pic_nameEX = req.getParameter("ado_Pic_nameEX");
//					String ado_Pic_type = req.getParameter("ado_Pic_type");
					
					
					Collection<Part> parts = req.getParts();
					
					System.out.println("Total parts : " + parts.size() );
					
					
					
					
					
/*圖片*/				byte[] ado_Ani_Pic = null;
					
					for (Part part : parts) {	//parts裡面包含非圖片資料。
						String picType = part.getContentType();
						System.out.println("part's name : " + part.getName() );
						if("image/jpeg".equals(picType)  || "image/png".equals(picType)){	//圖片的才用二位元資料讀進來
							InputStream in = part.getInputStream();
							ado_Ani_Pic = new byte[in.available()];
							in.read(ado_Ani_Pic);
							picList.add(ado_Ani_Pic);
							in.close();
							if("ado_Ani_Pic_head".equals(part.getName())){
								String ado_Pic_type = "0"; 
								picTypeList.add(ado_Pic_type);
							}else{
								String ado_Pic_type = "1";
								picTypeList.add(ado_Pic_type);
							}
					
							}
						}
					
					System.out.println("picList.size(): "+ picList.size());

					AdoptaniPhotoVO adoptaniPhotoVO = new AdoptaniPhotoVO();
					
					adoptaniPhotoVO.setMem_Id(mem_Id);
					adoptaniPhotoVO.setAdopt_Ani_Id(adopt_Ani_Id);
					adoptaniPhotoVO.setAdo_Pic_name(ado_Pic_name);
					adoptaniPhotoVO.setAdo_Pic_nameEX(ado_Pic_nameEX);
//					adoptaniPhotoVO.setAdo_Pic_type(ado_Pic_type);
										
/*圖片*/				adoptaniPhotoVO.setAdo_Ani_Pic(ado_Ani_Pic);

					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						
						req.setAttribute("adoptaniPhotoVO", adoptaniPhotoVO); // 含有輸入格式錯誤的adoptaniPhotoVO物件,也存入req
						if("insert".equals(action)){
							RequestDispatcher failureView = req
									.getRequestDispatcher("/front-end/adoptani_photo/addAdoptaniPhoto.jsp");
							failureView.forward(req, res);
							return;
						}else if("insert_FromView".equals(action)){
							RequestDispatcher failureView = req
									.getRequestDispatcher("/front-end/adoptani_photo/addAdoptaniPhotoForView.jsp");
							failureView.forward(req, res);
							return;
						}
					}
					
					/***************************2.開始新增資料***************************************/
					AdoptaniPhotoService adoptaniPhotoService = new AdoptaniPhotoService();
					
					for(int i=0 ; i<picList.size() ; i++){
						String ado_Pic_name_insert = ado_Pic_name + i;
					adoptaniPhotoVO = adoptaniPhotoService.addAdoptaniPhoto(adopt_Ani_Id, mem_Id, picList.get(i), ado_Pic_name_insert, ado_Pic_nameEX, picTypeList.get(i));
					}
					
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					
					if("insert".equals(action)){
						String url = "/front-end/adoptani_photo/listAllAdoptaniPhoto.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); 
						successView.forward(req, res);		
					}else if("insert_FromView".equals(action)){
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						//String url = "/front-end/adoptani_photo/adoptani_photo.do?action=getOne_For_Display_From_listOneAdoptani.jsp&adopt_Ani_Id="+adopt_Ani_Id;
						String url ="/front-end/adoptani_photo/successUploadPhoto.jsp?adopt_Ani_Id="+adopt_Ani_Id;
						RequestDispatcher successView = req.getRequestDispatcher(url); 
						successView.forward(req, res);
					}
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add(e.getMessage());
					if("insert".equals(action)){
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/adoptani_photo/addAdoptaniPhoto.jsp");
						failureView.forward(req, res);
					}else if("insert_FromView".equals(action)){
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/adoptani_photo/addAdoptaniPhotoForView.jsp");
						failureView.forward(req, res);
					}
				}
			}

			
			if ("update".equals(action)) { // 來自update_adoptani_input.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
						
				
				
				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String ado_Ani_Pic_No = req.getParameter("ado_Ani_Pic_No");
					AdoptaniPhotoService adoptaniPhotoSvc = new AdoptaniPhotoService();
					AdoptaniPhotoVO adoptaniPhotoVO = adoptaniPhotoSvc.findByPrimaryKey(ado_Ani_Pic_No);
					String ado_Pic_type = req.getParameter("ado_Pic_type");
					
					
					adoptaniPhotoVO.setAdo_Pic_type(ado_Pic_type);
					
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						
						req.setAttribute("adoptaniPhotoVO", adoptaniPhotoVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/adoptani_photo/update_adoptaniPhoto_input.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始修改資料*****************************************/
					adoptaniPhotoSvc.upadaeAdoptaniPhoto(adoptaniPhotoVO);
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					req.setAttribute("adoptaniPhotoVO", adoptaniPhotoVO); // 資料庫update成功後,正確的的empVO物件,存入req
					String url = "/front-end/adoptani_photo/listAllAdoptaniPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
					successView.forward(req, res);
					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_photo/update_adoptaniPhoto_input.jsp");
					failureView.forward(req, res);
				}
			}

			if ("getOne_For_Update".equals(action)) { // 來自listAllAdoptani.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
					/***************************1.接收請求參數****************************************/
					String ado_Ani_Pic_No = new String(req.getParameter("ado_Ani_Pic_No").trim());
					
					/***************************2.開始查詢資料****************************************/
					AdoptaniPhotoService adoptaniPhotoSvc = new AdoptaniPhotoService();
					AdoptaniPhotoVO adoptaniPhotoVO = adoptaniPhotoSvc.findByPrimaryKey(ado_Ani_Pic_No);
					
				
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					req.setAttribute("adoptaniPhotoVO", adoptaniPhotoVO);         // 資料庫取出的adoptaniVO物件,存入req
					String url = "/front-end/adoptani_photo/update_adoptaniPhoto_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_adoptani_input.jsp
					successView.forward(req, res);

					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani/listAllAdoptani.jsp");
					failureView.forward(req, res);
				}
			}
		 
			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
		
				try {
					/***************************1.接收請求參數***************************************/
					String str = req.getParameter("ado_Ani_Pic_No");
					
					/***************************2.開始刪除資料***************************************/
					AdoptaniPhotoService adoptaniPhoto = new AdoptaniPhotoService();
					adoptaniPhoto.deleteAdoptaniPhoto(str);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/front-end/adoptani_photo/listAllAdoptaniPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("刪除資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/adoptani_photo/listAllAdoptaniPhoto.jsp");
					failureView.forward(req, res);
				}
			}
			
			if ("changePhotoToHead".equals(action)) {
				String adopt_Ani_Id = req.getParameter("adopt_Ani_Id");
				String ado_Ani_Pic_No = req.getParameter("ado_Ani_Pic_No");
				
				AdoptaniPhotoService adoptaniPhotoSvc = new AdoptaniPhotoService();
				adoptaniPhotoSvc.changeNomalPhotoToHead(adopt_Ani_Id ,ado_Ani_Pic_No);
				
			}
			
	}

}
