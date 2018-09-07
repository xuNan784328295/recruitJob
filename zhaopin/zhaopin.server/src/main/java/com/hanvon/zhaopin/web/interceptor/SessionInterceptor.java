package com.hanvon.zhaopin.web.interceptor;

import com.hanvon.zhaopin.types.SessionalUser;
import com.hanvon.zhaopin.utils.TheApp;
import com.hanvon.zhaopin.web.action.BaseAction;
import com.hanvon.zhaopin.web.action.LoginAction;
import com.hanvon.zhaopin.web.utils.SessionUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 检测用户是否登录，未登录
 */
public class SessionInterceptor implements Interceptor
{

    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 对request进行权限验证拦截处理
     */
    public String intercept(ActionInvocation invocation) throws Exception {
        //检查用户是否已经登陆

        SessionalUser user = SessionUtils.getSessionalUser();
        Class clazz = invocation.getAction().getClass();
        boolean isLogin = LoginAction.class.equals(clazz);       //是否是登陆动作
        //未登录 且 不是登陆请求user == null &&
        if( !isLogin ) {


            //return BaseAction.JSON_RESULT;
        }

//        return invocation.invoke(); //继续其他拦截器调用

        String result="";
        try {
            result = invocation.invoke();
        } catch (NoSuchMethodException e) {
            result = Action.NONE;
        }

        System.out.println(result);
        return result;
    }

    /**
     * 拦截器初始化操作：在拦截器创建之后，任何web请求到达之前执行
     */
    public void init() { }

    /**
     * 拦截器被JVM回收前，释放申请的资源
     */
    public void destroy() { }
}
