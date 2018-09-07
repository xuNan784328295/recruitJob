package com.hanvon.zhaopin.web.listener;

//import com.hanvon.iface.web.socket.utils.DeviceInfoCache;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Author: zhuhaitao
 * Date: 2014-02-28 15:50
 * Function: 此类用于服务器完全启动后初始化一些数据或者执行某些操作。（当Spring将所有Bean加载完毕后执行）
 * 参考文章：
 * http://blog.csdn.net/fatherican/article/details/9130165
 * http://howsun.blog.sohu.com/108803269.html
 * http://yixiandave.iteye.com/blog/1871070
 */
@Component
public class SpringLoadedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        /*
        系统会存在两个容器:一个是root application context，另一个就是我们自己的
        projectName-servlet context（作为root application context的子容器）。
        这种情况下，就会造成onApplicationEvent方法被执行两次。为了避免上面提到的问题，
        我们可以只在root application context初始化完成后调用逻辑代码，其他的容器的初始化完成，则不做任何处理。
        */
        /*if(event.getApplicationContext().getParent() == null) {
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            try {
                DeviceInfoCache.startTask();
            }
            catch (Exception e) {
                logger.error("启动加载设备数据任务发生错误：" + e.getLocalizedMessage());
                e.printStackTrace();
            }
        }*/
    }
}
