package com.hanvon.zhaopin.web.action;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.hanvon.zhaopin.types.SessionalUser;
import com.hanvon.zhaopin.web.utils.SessionUtils;
import com.opensymphony.xwork2.Action;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 登录Action，采用原型模式(prototype)
 */
@Scope("prototype")
@Controller("loginAction")
public class LoginAction extends BaseAction
{
    public static final String SECRET_KEY = "_SECRET_KEY_"; //存放密钥的名称
    private static final String CHECK_CODE_KEY = "_CHECK_CODE_KEY_";

    LoginAction(){
        System.out.println("loginAction被构造");
    }
    /**
     * 访问主页判断是否登陆，如果没有登陆则转到登陆页面
     */
    public String index()
    {
        //已经登陆
        if (isLogin()) {
            return Action.SUCCESS; //已经登录
        }

        return Action.INPUT; //转到登陆
    }
    /**
     * 执行登录操作，登陆成功后写入session
     */
    String name;
    String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String login()
    {
        setJsonResult("");
        return BaseAction.JSON_RESULT;
    }

    /**
     * 退出登陆
     */
    public String logout()
    {
        SessionUtils.clearSessionalUser();
        setJsonResult("");
        return BaseAction.JSON_RESULT;
    }
}
