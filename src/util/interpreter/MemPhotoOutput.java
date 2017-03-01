package util.interpreter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class MemPhotoOutput
 */
@WebServlet(urlPatterns = { "/util/memPhotoOutput" })
public class MemPhotoOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB_dream");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("GOT INTO PHOTO OUTPUT");
//		System.out.println("req.getParameter(mem_Id)="+ req.getParameter("mem_Id"));
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		Connection con;
		try {
			con=ds.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
				"SELECT mem_profile FROM mem WHERE mem_Id = " + req.getParameter("mem_Id"));

			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("mem_profile"));
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
				in.close();
			} else {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
