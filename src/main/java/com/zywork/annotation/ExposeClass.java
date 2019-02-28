package com.zywork.annotation;

import java.lang.annotation.*;

/**
 * 暴露class信息的注解<br/>
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExposeClass {

    /**
     * 用于描述类的类型，如 type = "job"
     * @return
     */
    String type() default "";

}
