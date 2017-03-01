package test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Heibernate_back-end/track/track.do" })
public class Image extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/jpeg");
		ServletOutputStream out = res.getOutputStream();
		try {
			BufferedInputStream in = new BufferedInputStream(new Byte[]);
			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = in.read(buf)) != -1) {	//水桶
				out.write(buf, 0, len);
			}
			in.close();
		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("/front-end/adoptani/images/dog_default.jpg");
			byte[] buf = new byte[in.available()]; 	//建立水桶
			in.read(buf);							//把資料放進水桶			
			out.write(buf);							//把水桶裡的資料倒出來
			in.close();
		}
	}
}
