package com.zywork.listener;

import com.zywork.common.BeanUtils;
import com.zywork.common.redis.InfoRedisUtils;
import com.zywork.dto.InfoDTO;
import com.zywork.service.InfoService;
import com.zywork.vo.InfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * App监听器<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@WebListener
public class AppListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(AppListener.class);

    private InfoRedisUtils infoRedisUtils;

    private InfoService infoService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("MyBlog应用启动...");
        logger.info("开始删除缓存的系统信息...");
        infoRedisUtils.del();
        logger.info("已删除缓存的系统信息...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("MyBlog应用关闭...");
    }

    @Autowired
    public void setInfoRedisUtils(InfoRedisUtils infoRedisUtils) {
        this.infoRedisUtils = infoRedisUtils;
    }

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

}
