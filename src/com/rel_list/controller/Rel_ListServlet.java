package com.rel_list.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.mem_dream.model.MemService;
import com.mem_dream.model.MemVO;
import com.rel_list.model.Rel_ListService;
import com.rel_list.model.Rel_ListVO;

/**
 * ��赯蛛蕭嚙踝��� : <br>
 * ���蕭嚙�:嚙踝蕭謚抬蕭蹇蕭����<br>
 * 嚙踝嚙踝蕭嚙�:rel_List<br>
 */
@WebServlet(urlPatterns = { "/rel_list/rel_list.do" })
public class Rel_ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	
	public void checkFriend(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		PrintWriter out = res.getWriter();
		//==== 暐翰新增 ====
		
				
		// ====update====
		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL");
			try {

				/*************************** 1.****************************************/
				String rel_MemId = req.getParameter("rel_MemId").trim();
				String added_MemId = req.getParameter("added_MemId").trim();
				String isBlackList = req.getParameter("isBlackList").trim();
				String isInvited = req.getParameter("isInvited").trim();

				Rel_ListVO rel_listVO = new Rel_ListVO();
				rel_listVO.setRel_MemId(rel_MemId);
				rel_listVO.setAdded_MemId(added_MemId);
				rel_listVO.setIsBlackList(isBlackList);
				rel_listVO.setIsInvited(isInvited);
				
				if (!errorMsgs.isEmpty()) {
					String url = "/front-end/rel_list/update_rel_list_input.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					return;
				}

				/*************************** 2. *****************************************/
				Rel_ListService rel_listSvc = new Rel_ListService();
				rel_listVO = rel_listSvc.updateRel_List(rel_listVO);

				/***************************
				 * 3.(Send the Success view)
				 *************/
				req.setAttribute("rel_listVO", rel_listVO);
				String url = "/front-end/mem_dream/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				
			} catch (Exception e) {
				errorMsgs.add("錯誤訊息:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/rel_list/update_rel_list_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("invite".equals(action)) { // addRel_List.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************
				 * 1.
				 *************************/
				String rel_MemId = req.getParameter("rel_MemId");
				String added_MemId = req.getParameter("added_MemId");

				Rel_ListService relSvc = new Rel_ListService();

				Set<Rel_ListVO> relList = relSvc.getRel_ListByRel_MemId(rel_MemId);

				
				String originalIsBlackList = "undefined";

				String isBlackList = null;
				String isInvited = null;
				

				if (relList.size() != 0) {
					for (Rel_ListVO aRel_ListVO : relList) {
			
						if (aRel_ListVO.getAdded_MemId().equals(added_MemId)) {
							originalIsBlackList = aRel_ListVO.getIsBlackList();
							isBlackList = "2";
							isInvited = "1";
						} else {
							isBlackList = "2";
							isInvited = "1";
						}
					}
				} else {
					isBlackList = "2";
					isInvited = "1";
				}

				Rel_ListVO rel_listVO = new Rel_ListVO();

				rel_listVO.setAdded_MemId(added_MemId);
				rel_listVO.setRel_MemId(rel_MemId);
				rel_listVO.setIsBlackList(isBlackList);
				rel_listVO.setIsInvited(isInvited);

//				System.out.println("rel_MemId=" + rel_MemId);
//				System.out.println("added_MemId=" + added_MemId);
//				System.out.println("isBlackList=" + isBlackList);
//				System.out.println("isInvited=" + isInvited);
//				System.out.println("originalIsBlackList=" + originalIsBlackList);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("rel_listVO", rel_listVO); 
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/mem_dream/listAllMem.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2. ***************************************/
				Rel_ListService rel_listSvc = new Rel_ListService();
				if (originalIsBlackList.equals("2")) {
					System.out.println("do UPDATE");
					rel_listVO = rel_listSvc.updateRel_List(rel_listVO);
				} else{
					System.out.println("do insert");
					rel_listVO = rel_listSvc.addRel_List(rel_listVO);
				}

				/***************************
				 * 3.(Send the Success view)
				 ***********/
//				String url = "/front-end/mem_dream/listAllMem.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); 
//				successView.forward(req, res);
				// 將資料轉成JSONObject
				JSONObject json_result = new JSONObject();
				try {
					json_result.put("profile_result", String.valueOf("invite"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
				//==== ====
				out.print(json_result);				

			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/mem_dream/listAllMem.jsp");
//				failureView.forward(req, res);
				e.printStackTrace();
			}
		}

		if ("cancelFriend".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************
				 * 1.
				 *************************/
				String rel_MemId = req.getParameter("rel_MemId");
				String added_MemId = req.getParameter("added_MemId");

				Rel_ListService relSvc = new Rel_ListService();

				Set<Rel_ListVO> relList = relSvc.getRel_ListByRel_MemId(rel_MemId);

				String isBlackList = null;
				String isInvited = null;

				
				for (Rel_ListVO list : relList) {
					if (list.getAdded_MemId().equals(added_MemId)) {
						isBlackList = "2";
						isInvited = list.getIsInvited();
					}
//					System.out.println("relList.getAdded_MemId=" + list.getAdded_MemId());
//					System.out.println("added_MemId=" + added_MemId);
//					System.out.println("relList.getAdded_MemId().equals(added_MemId)="
//							+ list.getAdded_MemId().equals(added_MemId));
				}

				Rel_ListVO rel_listVO = new Rel_ListVO();

				rel_listVO.setAdded_MemId(added_MemId);
				rel_listVO.setRel_MemId(rel_MemId);
				rel_listVO.setIsBlackList(isBlackList);
				rel_listVO.setIsInvited(isInvited);

//				System.out.println("cancelFriend rel_MemId=" + rel_MemId);
//				System.out.println("cancelFriend added_MemId=" + added_MemId);
//				System.out.println("cancelFriend isBlackList=" + isBlackList);
//				System.out.println("cancelFriend isInvited=" + isInvited);
				// Send the use back to the form, if there were errors
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("rel_listVO", rel_listVO); 
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/mem_dream/listAllMem.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.***************************************/
				Rel_ListService rel_listSvc = new Rel_ListService();
				rel_listVO = rel_listSvc.updateRel_List(rel_listVO);
				
				//取消雙方的好友
				rel_listVO.setAdded_MemId(rel_MemId);
				rel_listVO.setRel_MemId(added_MemId);
				rel_listVO.setIsBlackList(isBlackList);
				rel_listVO.setIsInvited(isInvited);
				
				rel_listSvc.updateRel_List(rel_listVO);

				/***************************
				 * 3.(Send the Success view)
				 ***********/
				String url = "/front-end/mem_dream/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/mem_dream/listAllMem.jsp");
				failureView.forward(req, res);
			}
		}

		if ("confirmAddFriend".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************
				 * 1.
				 *************************/
				String rel_MemId = req.getParameter("sendInviteMemId");
				String added_MemId = req.getParameter("recieveInviteMemId");

				Rel_ListService relSvc = new Rel_ListService();
				
				
				
				Set<Rel_ListVO> relList = relSvc.getRel_ListByRel_MemId(rel_MemId);

				String isBlackList = null;
				String isInvited = null;

				for (Rel_ListVO list : relList) {
					if (list.getAdded_MemId().equals(added_MemId)) {
						isBlackList = "0";
						isInvited = "0";
					}
//					System.out.println("relList.getAdded_MemId=" + list.getAdded_MemId());
//					System.out.println("added_MemId=" + added_MemId);
//					System.out.println("relList.getAdded_MemId().equals(added_MemId)="
//							+ list.getAdded_MemId().equals(added_MemId));
				}

				Rel_ListVO rel_listVO = new Rel_ListVO();

				rel_listVO.setAdded_MemId(added_MemId);
				rel_listVO.setRel_MemId(rel_MemId);
				rel_listVO.setIsBlackList(isBlackList);
				rel_listVO.setIsInvited(isInvited);
				
				Rel_ListVO addedRel_listVO = new Rel_ListVO();
				
							
				addedRel_listVO.setAdded_MemId(rel_MemId);
				addedRel_listVO.setRel_MemId(added_MemId);
				addedRel_listVO.setIsBlackList(isBlackList);
				addedRel_listVO.setIsInvited(isInvited);

//				System.out.println("confirmAddFriend rel_MemId=" + rel_MemId);
//				System.out.println("confirmAddFriend added_MemId=" + added_MemId);
//				System.out.println("confirmAddFriend isBlackList=" + isBlackList);
//				System.out.println("confirmAddFriend isInvited=" + isInvited);
				// Send the use back to the form, if there were errors
				
				/*************************** 2.***************************************/
				
				Rel_ListService rel_listSvc = new Rel_ListService();
				rel_listVO = rel_listSvc.updateRel_List(rel_listVO);
				
				
				Rel_ListVO aRelListVO = relSvc.findByPrimaryKey(added_MemId,rel_MemId);
				
				if(aRelListVO!=null){
					addedRel_listVO = rel_listSvc.updateRel_List(addedRel_listVO);
				}else{
					addedRel_listVO = rel_listSvc.addRel_List(addedRel_listVO);
				}
				
				MemService memSvc = new MemService();
				MemVO memVO = memSvc.getOneMem(rel_MemId);
				/***************************
				 * 3.(Send the Success view)
				 ***********/
				Set<Rel_ListVO> addedMemIdSet = relSvc.getRel_ListByAdded_MemId(rel_MemId);
				Set<Rel_ListVO> relMemIdSet = relSvc.getRel_ListByRel_MemId(added_MemId);
							
				req.setAttribute("rel_list_memVO", memVO);
				req.setAttribute("listRelation_ByAddedMemId", addedMemIdSet);
				req.setAttribute("listRelation_ByMemId", relMemIdSet); 
				
				String url = "/front-end/mem_dream/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/mem_dream/listAllMem.jsp");
				failureView.forward(req, res);
			}
		}

	}
}
