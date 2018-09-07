package com.hanvon.zhaopin.web.action;

import com.hanvon.zhaopin.asm.RecruitAsm;
import com.hanvon.zhaopin.tpm.recruit.Positioninfo;
import com.hanvon.zhaopin.types.SessionalUser;
import com.hanvon.zhaopin.web.utils.SessionUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 登录Action，采用原型模式(prototype)
 */
@Scope("prototype")
@Controller("recruitAction")
public class RecruitAction extends BaseAction
{
    @Autowired
    protected RecruitAsm recruitAsm;

    RecruitAction(){
        System.out.println("recruitAction被构造");
    }
    /**
     * 访问主页判断是否登陆，如果没有登陆则转到登陆页面
     */
    public void searchByTerm( )
    {
        List<Positioninfo> positioninfos = recruitAsm.searchByTerm(search, area, category);
        getRequest().setAttribute("list",positioninfos);
        forward("/recruit/search.jsp");
    }
    public  void single(){

        forward("/recruit/single.jsp");
    }
    String id ;
    String search;  //条件
    String area;    //地区
    String category;    //行业

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
