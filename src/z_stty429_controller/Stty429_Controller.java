package z_stty429_controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import heibernate_com.mem.model.MemVO;
import heibernate_com.mem.model.MemService;
import heibernate_com.track.model.*;

@WebServlet(urlPatterns = { "/Stty429_controller.do" })
public class Stty429_Controller extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("set_account_null".equals(action)) {
			set_account_null(req, res);
		}
	}
	
	public void set_account_null(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.getSession().setAttribute("empVO",null);
		res.sendRedirect(req.getParameter("requestURL"));
	}
}
