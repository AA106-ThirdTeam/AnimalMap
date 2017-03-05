package weihan_controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.track.model.*;

@WebServlet(urlPatterns = { "/weihan_controller.do" })
public class WeiHan_Controller extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("set_account_null".equals(action)) {
			set_account_null(req, res);
		}
		
		if ("sdfjoisdofjosdjfio".equals(action)) {
			req
			.getRequestDispatcher("/front-end/homepage/nav/AM_nav_message_dropdown.jsp")
			.forward(req, res);
		}		
		
	}
	
	public void set_account_null(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.getSession().setAttribute("account",null);
		res.sendRedirect(req.getParameter("requestURL"));
	}
}
