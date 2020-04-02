package com.sxzhongf.think.in.springboot;

import com.sxzhongf.think.in.springboot.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Chapter5Application for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/2
 **/
//@SpringBootApplication(scanBasePackages = "com.sxzhongf.think.in.springboot.config")
public class Chapter5Application {

    public static void main(String[] args) {
        // 直接注入WebConfiguration 类实现
        SpringApplication.run(WebConfiguration.class, args);
    }
}
