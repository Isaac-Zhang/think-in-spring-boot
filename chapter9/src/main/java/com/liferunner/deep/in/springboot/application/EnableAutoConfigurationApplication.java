package com.liferunner.deep.in.springboot.application;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * EnableAutoConfigurationApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/12
 **/
@EnableAutoConfiguration(exclude = SpringApplicationAdminJmxAutoConfiguration.class)
public class EnableAutoConfigurationApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EnableAutoConfigurationApplication.class)
            .web(WebApplicationType.NONE)
            .run(args)
            .close(); //关闭上下文
    }
}
