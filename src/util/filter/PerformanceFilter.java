package util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "performance", urlPatterns = { "/sdfsdf.jsp" })
public class PerformanceFilter implements Filter {
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// 【從 session 判斷此user是否登入過】
		HttpSession session = request.getSession();
		heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO) session.getAttribute("account");
		String uri = request.getRequestURI();
		if (uri.endsWith("jsp") && account == null) {
			response.sendRedirect("http://localhost:8081/AnimalMap/front-end/login/index.jsp");
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
	}
}
