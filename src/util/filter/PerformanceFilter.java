package util.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebFilter(filterName="performance", urlPatterns={"/*"})
public class PerformanceFilter implements Filter {
    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
             FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        chain.doFilter(request, response);
        filterConfig.getServletContext().log("Request process in " +
                (System.currentTimeMillis() - begin) + " milliseconds");
    }

    @Override
    public void destroy() {}
}
