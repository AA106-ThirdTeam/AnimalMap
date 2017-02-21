package com.priv_message.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.priv_message.model.Priv_messageService;
import com.priv_message.model.Priv_messageVO;

/**
 * Servlet implementation class Priv_messageServlet
 */
public class Priv_messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String loginMemId = (String) req.getSession().getAttribute("loginMemId");
		
		
		if("openChat".equals(action)){
			String privMsgRec_MemId = req.getParameter("privMsgRec_MemId");
			String privMsgSend_MemId = loginMemId;
			req.setAttribute("privMsgRec_MemId", privMsgRec_MemId);
			req.setAttribute("privMsgSend_MemId", privMsgSend_MemId);
						
			String url="/front-end/privMes/index.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(url);
			dispatcher.forward(req, res);
			
		}
		
		
		if("insert".equals(action)){
			String privMsgRec_MemId = req.getParameter("privMsgRec_MemId");
			String privMsgSend_MemId = loginMemId;
			String content = req.getParameter("message");
			
			
			Priv_messageVO privMsgVO = new Priv_messageVO();
			privMsgVO.setPrivMsg_content(content);
			privMsgVO.setPrivMsg_SendTime(new Timestamp(System.currentTimeMillis()));
			privMsgVO.setPrivMsg_type("0");
			privMsgVO.setPrivMsgSend_MemId(privMsgSend_MemId);
			privMsgVO.setPrivMsgRec_MemId(privMsgRec_MemId);
			
			System.out.println(content);
						
			Priv_messageService privMsgSvc = new Priv_messageService();		
			
			privMsgSvc.insert(privMsgVO);
			
		}
				
	}

}
