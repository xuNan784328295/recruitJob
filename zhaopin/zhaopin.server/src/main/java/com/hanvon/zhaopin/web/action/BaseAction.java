package com.hanvon.zhaopin.web.action;

import com.hanvon.zhaopin.types.SessionalUser;
import com.hanvon.zhaopin.utils.TheApp;
import com.hanvon.zhaopin.web.utils.SessionUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: gguoling
 * Date: 13-1-11
 * Time: 下午1:05
 * Action类的父类，可以处理Session、HttpServletRequest和HttpServletResponse
 */
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
    protected Map<String, Object> session;  //当前请求的session对象
    private HttpServletRequest request;   //当前请求的request对象
    private HttpServletResponse response; //当前请求的response对象

    /**
     * 存储将要被转换为JSON的对象，由struts2框架负责 "对象=>JSON" 自动转换。
     * 注意：此参数名字不可随意修改！如果修改，这需要修改struts配置文件和拦截器
     */
    private Object jsonResult;
    public static final String JSON_RESULT = "JSON_RESULT"; //返回JSON结果的result名字

    /**
     * 分页数据，前端grid自动传
     */
    protected Integer start; //请求的起始数据行数。例如，每页10行，请求第1页，start=0（从0开始）；第2页，start=10；第3页：start=20。
    protected Integer count; //每页数据条数:pageSize
    protected String sort;   //排序字段

    /**
     * 设置HttpServletRequest对象
     * @param request the HTTP request.
     */
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * 设置HttpServletResponse对象
     * @param response the HTTP response.
     */
    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * 设置请求的session对象
     * @param session a Map of HTTP session attribute name/value pairs.
     */
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * 获取当前用户
     */
    public SessionalUser getSessionUser() {
        if (session == null) {
            return null;
        }

        //web层的SessionUtils工具类
        return (SessionalUser) session.get(SessionUtils.KEY_SESSIONAL_USER);
    }

    /*
    页面跳转
 */
    public void forward(String url)  {
        try {
            RequestDispatcher rd=request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当前用户是否登录
     */
    public boolean isLogin() {
        SessionalUser user = getSessionUser();
        return user != null;
    }

    /**
     * 登录检查，未登录时抛出异常信息
     * @throws Exception
     */
    public void loginCheck() throws Exception {
        if(!isLogin()) {
            throw new Exception("用户未登录或登陆超时！");
        }
    }

    /**
     * 获取分页信息
     * @return DbPager对象
     */

    public Object getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(Object jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    /**
     * 清空缓存图片
     */
    public void clearSessionImage() {
        if (session == null) {
            return;
        }
        session.remove(SessionUtils.KEY_SESSIONAL_IMAGE);
    }

    /**
     * 缓存图片
     * @param key 标识
     * @param img 图片二进制
     */
    public void saveSessionImage(String key, byte[] img) {
        if (session == null) {
            return;
        }
        Map imgMap = (Map) session.get(SessionUtils.KEY_SESSIONAL_IMAGE);
        if (imgMap == null) {
            imgMap = new HashMap<String, byte[]>();
            session.put(SessionUtils.KEY_SESSIONAL_IMAGE, imgMap);
        }
        imgMap.put(key, img);
    }

    /**
     * 清除人员的缓存照片
     */
    public void removeUserCacheImage(String key) {
        if (session == null) {
            return;
        }
        Map imgMap = (Map) session.get(SessionUtils.KEY_SESSIONAL_IMAGE);
        if (imgMap == null) {
            imgMap = new HashMap<String, byte[]>();
            session.put(SessionUtils.KEY_SESSIONAL_IMAGE, imgMap);
        }
        imgMap.remove(key);
    }

    /** 空白图片流 */
    public static InputStream getEmptyImageStream() {
        return new ByteArrayInputStream(new byte[0]);
    }

    /**
     * 获取图片流
     * @param blob 图片二进制编码
     */
    public static InputStream getImageStream(byte[] blob) {
        if (blob == null || blob.length == 0) {
            return getEmptyImageStream();
        }

        ByteBuffer buffer = ByteBuffer.wrap(blob);
        if (buffer.getInt() == blob.length - 4) {
            return new ByteArrayInputStream((Arrays.copyOfRange(blob, 4, blob.length)));
        }
        return new ByteArrayInputStream(blob);
    }

    /**
     * 设置单元格的样式和值
     * @param cell       单元格对象
     * @param style      单元格样式
     * @param cellValue  单元格的值
     */
    protected void setExcelCellValue(XSSFCell cell, XSSFCellStyle style, Object cellValue) {
        String text = cellValue == null ? "" : cellValue.toString();

        cell.setCellStyle(style); //单元格样式
        cell.setCellType(CellType.STRING); //文本类型
        cell.setCellValue(text);
    }

    //将Excel的每个单元格的数据转换成字符串
    protected String cellValueToString(Cell cell) {
        if(cell == null) {
            return null;
        }
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        String cellValue = null; //单元格的值
        int cellType = cell.getCellType();
        switch (cellType) {
            case Cell.CELL_TYPE_STRING: //文本
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC: //数字、日期
                if(DateUtil.isCellDateFormatted(cell)) {
                    cellValue = fmt.format(cell.getDateCellValue()); //日期型
                }
                else {
                    //转换成整数(long)，可以去掉工号后面的".0"，例如 5324.0 => 5324
                    cellValue = String.valueOf((long)cell.getNumericCellValue()); //数字
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN: //布尔型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            default: break;
        }

        return (cellValue != null) ? cellValue.trim() : cellValue;
    }

    /**
     * 是否是空行，遇到空行结束，判断5列即可
     * @param row Excel的一行
     */
    protected boolean isBlankRow(Row row) {
        boolean isBlank = false;
        if(row == null) {
            isBlank = true;
            return isBlank;
        }

        //一共6行数据
        Cell cell0 = row.getCell(0);
        Cell cell1 = row.getCell(1);
        Cell cell2 = row.getCell(2);
        Cell cell3 = row.getCell(3);
        Cell cell4 = row.getCell(4);

        //6列全部为空，才是空行
        isBlank = (cell0 == null || cell0.getCellType() == Cell.CELL_TYPE_BLANK) &&
                (cell1 == null || cell1.getCellType() == Cell.CELL_TYPE_BLANK) &&
                (cell2 == null || cell2.getCellType() == Cell.CELL_TYPE_BLANK) &&
                (cell3 == null || cell3.getCellType() == Cell.CELL_TYPE_BLANK) &&
                (cell4 == null || cell4.getCellType() == Cell.CELL_TYPE_BLANK);

        return isBlank;
    }
}
