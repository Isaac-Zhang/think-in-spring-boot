package com.liferunner.deep.in.springboot.config.based_annotation_impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorldConfiguration for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/9
 **/
@Configuration
public class HelloWorldConfiguration {

    /**
     * 创建 名称为 helloWorld 的String 类型的 Bean
     * @return
     */
    @Bean
    public String helloWorld(){
        return "hello,world";
    }
}
