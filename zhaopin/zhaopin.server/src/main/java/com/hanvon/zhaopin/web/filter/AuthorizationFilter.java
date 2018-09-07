package com.hanvon.zhaopin.web.filter;

import com.hanvon.zhaopin.web.utils.SessionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: zhuhaitao
 * Date: 2013-05-24 17:21
 * Function:
 */
public class AuthorizationFilter implements Filter
{
    private static final String indexUrl = "/index.html";  //正常入口
    private static final String loginUrl = "/login.html";  //登陆入口

    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    { }

    /**
     * 过滤操作
     * @param servletRequest Servlet的请求对象
     * @param servletResponse Servlet响应对象
     * @param filterChain 过滤器链
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("AuthorizationFilter doFilter");
        //获取请求对象
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession(); //第一次执行时，会创建Session
        String uri = request.getRequestURI(); //获取请求的相对路径
        String contentPath = request.getContextPath(); //网站上下文路径
        System.out.println("uri:" + uri + ", contentPath:" + contentPath);


        if (uri.contains("logout")) {
            session.removeAttribute(SessionUtils.KEY_SESSIONAL_USER);
            return;
        }
        //处理非ajax请求
        if(!isAjaxRequest(request)) {
            //未登录或登陆超时
//            if(session.getAttribute(SessionUtils.KEY_SESSIONAL_USER) == null) {
//                if(!uri.endsWith("/login.html")) {
//                    response.sendRedirect(contentPath + loginUrl);
//                    return;
//                }
//            }else if(uri.endsWith("/") || uri.endsWith("/login.html")) {
//                    response.sendRedirect(contentPath + indexUrl);
//                    return;
//            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    //判断是否时ajax请求
    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return header != null && "XMLHttpRequest".equals(header);
    }

    /**
     * 销毁并释放资源
     */
    @Override
    public void destroy()
    { }
}
