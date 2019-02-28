package com.zywork;

import com.zywork.enums.ResponseStatusEnum;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 系统启动类<br/>
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 * @see ResponseStatusEnum
 */
@SpringBootApplication
@MapperScan("com.zywork.dao")
@ServletComponentScan
public class MyBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}

}
