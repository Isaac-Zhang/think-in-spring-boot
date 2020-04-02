package com.sxzhongf.think.in.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Chapter5ForAutoConfigureApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/2
 **/
@SpringBootApplication
public class Chapter5ForAutoConfigureApplication {

    public static void main(String[] args) {
        new SpringApplication(Chapter5ForAutoConfigureApplication.class)
            //.setWebApplicationType(WebApplicationType.SERVLET)
            .run(args);
    }
}
