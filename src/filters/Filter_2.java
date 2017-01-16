package filters;

import java.io.*;
import javax.servlet.*;

public class Filter_2 implements Filter {

	private FilterConfig config;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<font color=blue>Filter 2......¶}©l!</font><br>");
		out.println("<br><font color=blue>Filter 2......µ²§ô!</font><br>");
		chain.doFilter(req, res);
	}
}