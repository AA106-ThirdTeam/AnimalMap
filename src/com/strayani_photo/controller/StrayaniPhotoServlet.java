package com.strayani_photo.controller;

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

import com.strayani.model.StrayaniService;
import com.strayani.model.StrayaniVO;
import com.strayani_photo.model.*;


@WebServlet("/strayani_photo.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 10 * 1024 * 1024, maxRequestSize = 100 * 1024 * 1024)

public class StrayaniPhotoServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		System.out.println("into StrayaniPhotoServlet.java");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println(action);
		if ("getOne_For_Display".equals(action)  || "getOne_For_Display_From_listOneStrayani.jsp".equals(action) || "getOne_For_Display_From_listAllStrayani.jsp".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			StrayaniVO strayaniVO = (StrayaniVO) req.getAttribute("strayaniVO"); //StrayaniVOServlet.java(Concroller), 存入req的strayaniVO物件
			System.out.println("action:"+action);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("stray_Ani_Id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入送養動物編號");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_photo/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer stray_Ani_Id = null;
				try {
					stray_Ani_Id = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("送養動物編號格式不正確");
				}
				System.out.println("stray_Ani_Id:"+stray_Ani_Id);
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_photo/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				StrayaniPhotoService strayaniPhotoSvc = new StrayaniPhotoService();
				List<StrayaniPhotoVO> oneStrayAniPhotoList = strayaniPhotoSvc.getOneStrayaniPhoto(str);
				if (oneStrayAniPhotoList == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_photo/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("oneStrayAniPhotoList", oneStrayAniPhotoList); 
				if("getOne_For_Display".equals(action)){
					String url = "/front-end/strayani_photo/listOneStrayaniPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
				}
				else if("getOne_For_Display_From_listOneStrayani.jsp".equals(action)){
					System.out.println("查詢資料完成");
					String url = "/front-end/strayani/listOneStrayaniAllPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
				}
				else if("getOne_For_Display_From_listAllStrayani.jsp".equals(action)){
					System.out.println("查詢資料完成");
					String url = "/front-end/strayani/listOneStrayaniAllPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); 
					successView.forward(req, res);
				}

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/strayani_photo/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		
		 if ("insert".equals(action) || "insert_FromView".equals(action)) { // 來自addStrayani.jsp的請求。 insert寫在前面比較好看。
				
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
					String stray_Ani_Id = req.getParameter("stray_Ani_Id");
					String str_Pic_name = req.getParameter("str_Pic_name");
					if (str_Pic_name == null || (str_Pic_name.trim()).length() == 0) {
						errorMsgs.add("請輸入送養動物名字");
					}
					String str_Pic_nameEX = req.getParameter("str_Pic_nameEX");
//					String str_Pic_type = req.getParameter("str_Pic_type");
					
					
					Collection<Part> parts = req.getParts();
					
					System.out.println("Total parts : " + parts.size() );
					
					
					
					
					
/*圖片*/				byte[] str_Ani_Pic = null;
					
					for (Part part : parts) {	//parts裡面包含非圖片資料。
						String picType = part.getContentType();
						System.out.println("part's name : " + part.getName() );
						if("image/jpeg".equals(picType)  || "image/png".equals(picType)){	//圖片的才用二位元資料讀進來
							InputStream in = part.getInputStream();
							str_Ani_Pic = new byte[in.available()];
							in.read(str_Ani_Pic);
							picList.add(str_Ani_Pic);
							in.close();
							if("str_Ani_Pic_head".equals(part.getName())){
								String str_Pic_type = "0"; 
								picTypeList.add(str_Pic_type);
							}else{
								String str_Pic_type = "1";
								picTypeList.add(str_Pic_type);
							}
					
							}
						}
					
					System.out.println("picList.size(): "+ picList.size());

					StrayaniPhotoVO strayaniPhotoVO = new StrayaniPhotoVO();
					
					strayaniPhotoVO.setMem_Id(mem_Id);
					strayaniPhotoVO.setStray_Ani_Id(stray_Ani_Id);
					strayaniPhotoVO.setStray_Pic_name(str_Pic_name);
					strayaniPhotoVO.setStray_Pic_nameEX(str_Pic_nameEX);
//					strayaniPhotoVO.setStr_Pic_type(str_Pic_type);
										
/*圖片*/				strayaniPhotoVO.setStray_Ani_Pic(str_Ani_Pic);

					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						
						req.setAttribute("strayaniPhotoVO", strayaniPhotoVO); // 含有輸入格式錯誤的strayaniPhotoVO物件,也存入req
						if("insert".equals(action)){
							RequestDispatcher failureView = req
									.getRequestDispatcher("/front-end/strayani_photo/addStrayaniPhoto.jsp");
							failureView.forward(req, res);
							return;
						}else if("insert_FromView".equals(action)){
							RequestDispatcher failureView = req
									.getRequestDispatcher("/front-end/strayani_photo/addStrayaniPhotoForView.jsp");
							failureView.forward(req, res);
							return;
						}
					}
					
					/***************************2.開始新增資料***************************************/
					StrayaniPhotoService strayaniPhotoService = new StrayaniPhotoService();
					
					for(int i=0 ; i<picList.size() ; i++){
						String str_Pic_name_insert = str_Pic_name + i;
					strayaniPhotoVO = strayaniPhotoService.addStrayaniPhoto(stray_Ani_Id, mem_Id, picList.get(i), str_Pic_name_insert, str_Pic_nameEX, picTypeList.get(i));
					}
					
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					
					if("insert".equals(action)){
						String url = "/front-end/strayani_photo/listAllStrayaniPhoto.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url); 
						successView.forward(req, res);		
					}else if("insert_FromView".equals(action)){
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						//String url = "/front-end/strayani_photo/strayani_photo.do?action=getOne_For_Display_From_listOneStrayani.jsp&stray_Ani_Id="+stray_Ani_Id;
						String url ="/front-end/strayani_photo/successUploadPhoto.jsp?stray_Ani_Id="+stray_Ani_Id;
						RequestDispatcher successView = req.getRequestDispatcher(url); 
						successView.forward(req, res);
					}
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add(e.getMessage());
					if("insert".equals(action)){
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/strayani_photo/addStrayaniPhoto.jsp");
						failureView.forward(req, res);
					}else if("insert_FromView".equals(action)){
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/strayani_photo/addStrayaniPhotoForView.jsp");
						failureView.forward(req, res);
					}
				}
			}

			
			if ("update".equals(action)) { // 來自update_strayani_input.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
						
				
				
				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String str_Ani_Pic_No = req.getParameter("str_Ani_Pic_No");
					StrayaniPhotoService strayaniPhotoSvc = new StrayaniPhotoService();
					StrayaniPhotoVO strayaniPhotoVO = strayaniPhotoSvc.findByPrimaryKey(str_Ani_Pic_No);
					String str_Pic_type = req.getParameter("str_Pic_type");
					
					
					strayaniPhotoVO.setStray_Pic_type(str_Pic_type);
					
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						
						req.setAttribute("strayaniPhotoVO", strayaniPhotoVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-end/strayani_photo/update_strayaniPhoto_input.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始修改資料*****************************************/
					strayaniPhotoSvc.upadaeStrayaniPhoto(strayaniPhotoVO);
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					req.setAttribute("strayaniPhotoVO", strayaniPhotoVO); // 資料庫update成功後,正確的的empVO物件,存入req
					String url = "/front-end/strayani_photo/listAllStrayaniPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
					successView.forward(req, res);
					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_photo/update_strayaniPhoto_input.jsp");
					failureView.forward(req, res);
				}
			}

			if ("getOne_For_Update".equals(action)) { // 來自listAllStrayani.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
					/***************************1.接收請求參數****************************************/
					String str_Ani_Pic_No = new String(req.getParameter("str_Ani_Pic_No").trim());
					
					/***************************2.開始查詢資料****************************************/
					StrayaniPhotoService strayaniPhotoSvc = new StrayaniPhotoService();
					StrayaniPhotoVO strayaniPhotoVO = strayaniPhotoSvc.findByPrimaryKey(str_Ani_Pic_No);
					
				
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					req.setAttribute("strayaniPhotoVO", strayaniPhotoVO);         // 資料庫取出的strayaniVO物件,存入req
					String url = "/front-end/strayani_photo/update_strayaniPhoto_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_strayani_input.jsp
					successView.forward(req, res);

					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani/listAllStrayani.jsp");
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
					String str = req.getParameter("str_Ani_Pic_No");
					
					/***************************2.開始刪除資料***************************************/
					StrayaniPhotoService strayaniPhoto = new StrayaniPhotoService();
					strayaniPhoto.deleteStrayaniPhoto(str);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/front-end/strayani_photo/listAllStrayaniPhoto.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add("刪除資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/strayani_photo/listAllStrayaniPhoto.jsp");
					failureView.forward(req, res);
				}
			}
			
			if ("changePhotoToHead".equals(action)) {
				String stray_Ani_Id = req.getParameter("stray_Ani_Id");
				String str_Ani_Pic_No = req.getParameter("str_Ani_Pic_No");
				
				StrayaniPhotoService strayaniPhotoSvc = new StrayaniPhotoService();
				strayaniPhotoSvc.changeNomalPhotoToHead(stray_Ani_Id ,str_Ani_Pic_No);
				
			}
			
	}

}
