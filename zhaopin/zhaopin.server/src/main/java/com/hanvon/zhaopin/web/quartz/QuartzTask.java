package com.hanvon.zhaopin.web.quartz;


import com.hanvon.zhaopin.utils.TheApp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: zhuhaitao
 * Date: 2014-01-01 14:53
 * Function: quartz定时任务
 */
@Service("quartzTask")
public class QuartzTask {
    QuartzTask(){
        System.out.println("QuartzTask()");
    }
    public void sayHello() throws InterruptedException {
    }
}
