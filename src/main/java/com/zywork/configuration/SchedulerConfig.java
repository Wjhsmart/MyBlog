package com.zywork.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import com.zywork.job.MyJobFactory;

/**
 * Scheduler配置类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Configuration
public class SchedulerConfig {

    @Autowired
    private MyJobFactory myJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 设置自定义的JobFactory，支持Spring注入
        schedulerFactoryBean.setJobFactory(myJobFactory);
        return schedulerFactoryBean;
    }
}
