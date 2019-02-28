package com.zywork.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * 容器加载后监听器<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Component
public class StartEndListener implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartEndListener.class);

    @Override
    public void run(String... args) {
        logger.info("系统启动完成");
    }

}
