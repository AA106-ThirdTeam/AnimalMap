package com.emp.controller;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String emp_mail;
	String emp_Pw;
	EmpVO empVO;
	
	
	
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
	  
	  
	 
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html; charset=UTF-8");
    String action = req.getParameter("action");
    HttpSession session = req.getSession();
    
    List<String> errorMsgs = new LinkedList<String>();
	req.setAttribute("errorMsgs", errorMsgs);
	
	//員工登出
	if("login_Out".equals(action)){
		
		session.removeAttribute("empVO"); //session 裡的物件移除
		RequestDispatcher failureView = req.getRequestDispatcher("/back-end/login/back_login.jsp");
		failureView.forward(req, res);
		
	}
    
    
    if ("login".equals(action))  {
    // 【取得使用者 帳號(account) 密碼(password)】
    	
    String account = req.getParameter("account").trim();  
    String password = req.getParameter("password").trim();

    EmpService empSvc=new EmpService();
    empVO=empSvc.getOneUserLogin(account, password);
    
    if(empVO==null){
    	errorMsgs.add("查無資料!! 請再次確認帳密是否輸入正確");
    	
    } else {
    	
    	emp_mail=empVO.getEmp_email();
    	emp_Pw=empVO.getEmp_Pw();
    }
    
  //【帳號 , 密碼無效時】
    if (!errorMsgs.isEmpty()) {
		RequestDispatcher failureView = req.getRequestDispatcher("/back-end/login/back_login.jsp");
		failureView.forward(req, res);
		return;// 程式中斷
	}	 
      	

    // 【檢查該帳號 , 密碼是否有效】
    if (emp_mail.equals(account) && emp_Pw.equals(password)) {   
    	
    	
        session.setAttribute("empVO", empVO);   //*工作1: 才在session內做已經登入過的標識
        
        
        
         try {                                                        
           String location = (String) session.getAttribute("location");
           if (location != null) {
             session.removeAttribute("location");   //*工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
             res.sendRedirect(location);            
             return;
           }
         }catch (Exception ignored) { }

        res.sendRedirect(req.getContextPath()+"/back-end/emp/select_page.jsp");  //*工作3: (-->如無來源網頁:則重導至login_success.jsp)
        
    		} 
		}
	}

	



  
  
  
}