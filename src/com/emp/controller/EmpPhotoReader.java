package com.emp.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class EmpPhotoReader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;

	public EmpPhotoReader() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT emp_picture FROM emp WHERE emp_No = " + req.getParameter("emp_No"));

			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("emp_picture"));
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
					
				}
				in.close();
			} else { // 預設圖的設定
				InputStream in = getServletContext().getResourceAsStream("/back-end/emp/images/logo.jpg");
				byte[] buf = new byte[in.available()];
				in.read(buf);
				out.write(buf);
				in.close();
			}

			rs.close();
			stmt.close();
		} catch (Exception e) { // 預設圖的設定
			// System.out.println(e);
			InputStream in = getServletContext().getResourceAsStream("/back-end/emp/images/logo.jpg");
			byte[] buf = new byte[in.available()]; // available() 能讀多少就多少
													// InputStream 的方法
			in.read(buf);
			out.write(buf);
			in.close();
		}
	}

	public void init() throws ServletException {
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
			con = ds.getConnection();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
