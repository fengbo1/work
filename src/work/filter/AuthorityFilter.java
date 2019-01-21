package work.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class AuthorityFilter implements Filter{

	private static Logger logger = Logger.getLogger(AuthorityFilter.class);
	private FilterConfig filterConfig;
    //初始化方法实现
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
    //身份认证的过滤
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        ServletContext context = this.filterConfig.getServletContext();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String IP = (String) session.getAttribute("IP");
        String url = req.getRequestURI();
        //登录后才能进入下一步处理，否则直接进入错误提示页面
        if(url.startsWith("/work/page")&&url.endsWith("authorityfailed.jsp"))
        {
        	 res.sendRedirect("./../authorityfailed.jsp");
        }
        else if ((session.getAttribute("username") != null)||url.endsWith("login.action")) {
            context.log("身份认证通过，进入下一步处理 ");
            logger.info(username+"IP:"+IP+"url:"+url);
            chain.doFilter(request, response);
        } else {
            context.log("身份认证失败，直接返回");
            logger.info(username+"IP:"+IP+"url:"+url);
            res.sendRedirect("authorityfailed.jsp");
        }
    }
    //实现销毁方法
    public void destroy() {
        this.filterConfig = null;
    }
	
}
