package com.liferunner.deep.in.springboot.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * ConditionalApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/11
 **/
//@ComponentScan(basePackages = {"com.liferunner.deep.in.springboot.conditional"})
@ComponentScan(basePackageClasses = {ConditionalMessageConfiguration.class})
public class ConditionalApplication {

    public static void main(String[] args) {
        // 设置 系统配置
        System.setProperty("language", "Chinese");
        // 构建 AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(ConditionalMessageConfiguration.class);
        context.register(ConditionalApplication.class);
        context.refresh();

        String message = context.getBean("message", String.class);
        System.out.println(message);
        context.close();
    }
}
