package com.hanvon.zhaopin.web.utils;

import com.hanvon.zhaopin.types.SessionalUser;
import com.hanvon.zhaopin.utils.TheApp;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * 用户Session类，管理用户Session信息
 * User: kevdmx
 * Change Log
 * Date: 12-6-22 下午1:44 创建
 */
public class SessionUtils {
    public static final String KEY_SESSIONAL_USER = "__sessional_user__";     //用户
    public static final String KEY_SESSIONAL_IMAGE = "__sessional_image__";   //用户照片
    public static final String KEY_SESSION_PROGRESS = "__session_progress__"; //文件上传进度

    /**
     * 获取Session
     * @return Session
     */
    private static Map<String, Object> getSession() {
        ActionContext context = ActionContext.getContext();
        return context.getSession();
    }

    /**
     * 设置session信息
     * @param user 用户
     */
    public static void setSessionalUser(SessionalUser user) {
        Map<String, Object> session = getSession(); //获取当前session
        if (null == session) {
            return;
        }
        session.put(KEY_SESSIONAL_USER, user);
        //设置TheApp中的user信息
        TheApp.setCurrentUser(user);
    }

    /**
     * 清除用户Session，退出登陆
     */
    public static void clearSessionalUser() {
        Map<String, Object> session = getSession();
        if (null == session) {
            return;
        }
        session.remove(KEY_SESSIONAL_USER);

        //清除TheApp中保存的用户session变量
        TheApp.cleanThreadLocal();
        //清除Session
        TheApp.clearSessionLocal();
    }

    /**
     * 获取当前session中保存的用户信息
     * @return 当前用户对象SessionalUser
     */
    public static SessionalUser getSessionalUser() {
        Map session = getSession();
        if (null == session) {
            return null;
        }
        return (SessionalUser) session.get(KEY_SESSIONAL_USER);
    }

    /**
     * 在Session中存放参数
     * @param key 参数名
     * @param value 参数
     */
    public static void setSessionParam(String key, Object value)
    {
        Map<String, Object> session = getSession(); //获取当前session
        if (null == session) {
            return;
        }
        session.put(key,value);
    }

    /**
     * 从Session中获取参数值
     * @param key 参数名
     * @return 参数值
     */
    public static Object getSessionParam(String key)
    {
        Map session = getSession();
        if (null == session) {
            return null;
        }
        return session.get(key);
    }
}
