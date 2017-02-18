package login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = { "/front-end/loginhandler" })
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 【檢查使用者輸入的帳號(account) 密碼(password)是否有效】
	// 【實際上應至資料庫搜尋比對】
	protected boolean allowUser(String account, String password) {
		if ("t".equals(account) && "t".equals(password))
			return true;
		else
			return false;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		// 【取得使用者 帳號(account) 密碼(password)】
		String account = req.getParameter("account");
		String password = req.getParameter("password");

		// 【檢查該帳號 , 密碼是否有效】
		if (!allowUser(account, password)) { // 【帳號 , 密碼無效時】
			out.println("Login faild");
		} else { // 【帳號 , 密碼有效時, 才做以下工作】
			HttpSession session = req.getSession();
			session.setAttribute("account", account); // *工作1:
														// 才在session內做已經登入過的標識
			try {
				out.println("Login Success");
				String location = (String) session.getAttribute("location");
				if (location != null) {
					session.removeAttribute("location");
					return;
				}
			} catch (Exception ignored) {
			}
		}
	}
}