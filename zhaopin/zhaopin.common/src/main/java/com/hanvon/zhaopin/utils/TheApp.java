package com.hanvon.zhaopin.utils;

import com.hanvon.zhaopin.types.SessionalUser;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TheApp {

    private static String logDirectory = "logs";   //日志目录

    private static String webPath = null;

    public static void initlize(String webPath) throws IOException {

        InputStream is = TheApp.class.getClassLoader().getResourceAsStream("app.properties");
        if (is == null) {
            return;
        }
        Properties p = new Properties();
        p.load(is);
        is.close();

        TheApp.webPath = webPath;
        //日志目录
        logDirectory = p.getProperty("server.log.dir", logDirectory);
        logDirectory = webPath + logDirectory;
    }

    public static String getLogDirectory() {
        return logDirectory;
    }


    /**
     * Threadlocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其他线程所独立的副本。
     * currentSessionalUser用于保存每个线程的用户session信息。
     */
    private static ThreadLocal<SessionalUser> currentSessionalUser = new ThreadLocal<SessionalUser>();
    //设置当前用户的Session值
    public static void setCurrentUser(SessionalUser user) {
        currentSessionalUser.set(user);
    }
    //清除当前用户的Session值
    public static void cleanThreadLocal() {
        currentSessionalUser.remove();
    }


    // Session
    private static ThreadLocal<HttpSession> sessionLocal = new ThreadLocal<HttpSession>();
    public static void setSession(HttpSession session) {
        sessionLocal.set(session);
    }
    public static void clearSessionLocal(){
        sessionLocal.remove();
    }

    //日志处理
    private static Logger loggerMessage;     //消息日志

    public static Logger getLoggerMessage() {
        return loggerMessage;
    }

    static {
        loggerMessage = Logger.getLogger("com.hanvon.zhaopin.logger.message");
    }
}
