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
import heibernate_com.mem.model.MemDAO;
import heibernate_com.mem.model.MemVO;

@WebServlet(urlPatterns = { "/front-end/signup" })
public class SignUp extends HttpServlet {
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
		String mem_account = req.getParameter("mem_account");
		String mem_Psw = req.getParameter("mem_Psw");
		String mem_email = req.getParameter("mem_email");
		String mem_Tw_Id = req.getParameter("mem_Tw_Id");
		String mem_birth_date = req.getParameter("mem_birth_date");
		String mem_phone = req.getParameter("mem_phone");
		String mem_profile = req.getParameter("mem_profile");
		String mem_gender = req.getParameter("gender");
		String mem_Intro = req.getParameter("mem_Intro");
		String mem_name = req.getParameter("mem_name");
		

	

		
		// ==== ====
		boolean signLogin = false;

		// ==== 【檢查該帳號 , 密碼是否有效】====
		try{
			System.out.println(mem_gender);
			MemDAO dao = new MemDAO();
			MemVO vo = new MemVO();
			
			vo.setMem_account(mem_account);
			
			System.out.println(mem_birth_date);
			System.out.println();
			java.sql.Date date = java.sql.Date.valueOf(mem_birth_date);
			Long time = date.getTime();
			System.out.println(date.getTime());
			
			java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
			
			vo.setMem_birth_date(timestamp);
			vo.setMem_email(mem_email);
			vo.setMem_gender("男");
			vo.setMem_Intro(mem_Intro);
			vo.setMem_name(mem_name);
			vo.setMem_nick_name(mem_name);
			vo.setMem_phone(mem_phone);
			vo.setMem_profile(mem_profile);
			vo.setMem_Psw(mem_Psw);
			vo.setMem_Tw_Id(mem_Tw_Id);				
			dao.insert(vo);
			signLogin = true;
		}catch (Exception e) {
			signLogin = false;
		}			
		// 將資料轉成JSONObject
		JSONObject json_result = new JSONObject();
		try {
			json_result.put("sign_result", String.valueOf(signLogin));
		} catch (JSONException e) {
//			signLogin = false;
//			e.printStackTrace();
		}
		
		//==== ====
		out.print(json_result);
	}
}