package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import heibernate_com.mem.controller.MemServlet;
import heibernate_com.mem.model.MemVO;

@WebServlet(urlPatterns = { "/front-end/loginhandler" })
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		System.out.println("======================");

		// ==== ====
		HttpSession session = req.getSession();

		// 【取得使用者 帳號(account) 密碼(password)】
		String MEM_ACCOUNT = req.getParameter("mem_account");
		String MEM_PSW = req.getParameter("mem_Psw");

		// ==== ====
		boolean successLogin = false;

		// ==== 【檢查該帳號 , 密碼是否有效】====
		if (MEM_ACCOUNT.length() > 4 && MEM_PSW.length() > 4) {
			MemServlet mem_servlet = new MemServlet();
			mem_servlet.front_end_list_ByCompositeQuery(req, res, true);
			List<MemVO> mem_list = (List) req.getAttribute("listMems_ByCompositeQuery");

			// ==== ====
			if (mem_list.size() == 1) {
				successLogin = true;
				session.setAttribute("account", mem_list.get(0));
			}
		} else {
		}
		// 將資料轉成JSONObject
		JSONObject json_result = new JSONObject();
		try {
			json_result.put("log_result", String.valueOf(successLogin));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//==== ====
		out.print(json_result);
	}
}