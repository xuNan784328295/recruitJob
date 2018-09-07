package com.hanvon.zhaopin.web.listener;


import com.hanvon.zhaopin.types.SessionalUser;
import com.hanvon.zhaopin.utils.TheApp;
import com.hanvon.zhaopin.web.utils.SessionUtils;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Web应用程序监听器：做系统初始化及清理工作
 */
public class WebAppEventListener implements ServletContextListener, ServletRequestListener
{
    /**
     * * Notification that the web application initialization
     * * process is starting.
     * * All ServletContextListeners are notified of context
     * * initialization before any filter or servlet in the web
     * * application is initialized.
     * * ServletContext初始化前执行
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        final ServletContext context = sce.getServletContext();
        // 初始化系统参数
        String path = context.getRealPath("/");
        try {
            TheApp.initlize(path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //初始化Log4j配置
        System.setProperty("logs.dir", TheApp.getLogDirectory()); //设置logs.dir变量：日志目录
        String logPath = context.getRealPath("/WEB-INF/log4j.xml");
        DOMConfigurator.configure(logPath);
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
    }

    /**
     * * Notification that the servlet context is about to be shut down.
     * * All servlets and filters have been destroy()ed before any
     * * ServletContextListeners are notified of context destruction.
     * * ServletContext销毁前执行
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    /**
     * 请求初始化
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre)
    {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        HttpSession session = req.getSession();
        if (null != session) {
            //获取用户session信息
            SessionalUser user = (SessionalUser) session.getAttribute(SessionUtils.KEY_SESSIONAL_USER);
            if (null != user) {
                //设置TheApp中的用户session信息
                TheApp.setCurrentUser(user);
                //设置TheApp中的Session
                TheApp.setSession(session);
            }
        }
    }

    /**
     * 请求结束，释放资源
     * @param sre
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre)
    {
        //清除TheApp中的用户session信息
        TheApp.cleanThreadLocal();
        //清除Session
        TheApp.clearSessionLocal();
    }
}
