package com.zywork.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解，用于方法上，记录系统日志<br/>
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 用于描述系统日志
     * @return 系统日志描述
     */
    String description() default "";

    /**
     * 用于描述是否保存请求参数
     * @return
     */
    boolean requestParams() default true;

}
