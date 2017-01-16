package filters;

import java.io.*;
import javax.servlet.*;

public class Filter_1 implements Filter {

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
		out.println("<font color=red>Filter 1......¶}©l!</font><br>");

		out.println("<font color=red>Filter 1......µ²§ô!</font><br>");
		chain.doFilter(req, res);
	}
}