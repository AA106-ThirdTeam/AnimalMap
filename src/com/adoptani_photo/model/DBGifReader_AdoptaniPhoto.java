package com.adoptani_photo.model;

import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

public class DBGifReader_AdoptaniPhoto extends HttpServlet {

	Connection con;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/jpeg");
		ServletOutputStream out = res.getOutputStream();
		String ado_Ani_Pic_No = req.getParameter("ado_Ani_Pic_No");
		String ado_Pic_type = req.getParameter("ado_Pic_type");
		System.out.println("into DBGifReader_AdoptaniPhoto.java");
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
				if(ado_Pic_type==null){

					String ado_Ani_Pic_No2 =new String(ado_Ani_Pic_No.getBytes("ISO-8859-1"),"UTF-8");
					rs= stmt.executeQuery(
						"SELECT ado_Ani_Pic FROM ADOPT_ANI_PHOTOS WHERE ado_Ani_Pic_No='"+ado_Ani_Pic_No2+"'");
				}else{
					String adopt_Ani_Id = req.getParameter("adopt_Ani_Id");
					String adopt_Ani_Id2 =new String(adopt_Ani_Id.getBytes("ISO-8859-1"),"UTF-8");
					String ado_Pic_type2 =new String(ado_Pic_type.getBytes("ISO-8859-1"),"UTF-8");
					rs= stmt.executeQuery(
							"SELECT ado_Ani_Pic FROM ADOPT_ANI_PHOTOS WHERE adopt_Ani_Id='"+adopt_Ani_Id2+"'"+"AND ado_Pic_type='"+ado_Pic_type2+"'");
				}
			
			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("ado_Ani_Pic"));
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {	//水桶
					out.write(buf, 0, len);
				}
				in.close();
			} else {
				InputStream in = getServletContext().getResourceAsStream("/images/tomcat.gif");
				byte[] buf = new byte[in.available()]; 	//建立水桶
				in.read(buf);							//把資料放進水桶			
				out.write(buf);							//把水桶裡的資料倒出來
				in.close();
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
			InputStream in = getServletContext().getResourceAsStream("/front-end/adoptani/images/dog_default.jpg");
			byte[] buf = new byte[in.available()]; 	//建立水桶
			in.read(buf);							//把資料放進水桶			
			out.write(buf);							//把水桶裡的資料倒出來
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
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
