package com.liferunner.deep.in.springboot.application;

import com.liferunner.deep.in.springboot.config.based_annotation_impl.EnableHelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * EnableHelloWorldApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/9
 **/
@EnableHelloWorld
@Configuration
public class EnableHelloWorldApplication {

    public static void main(String[] args) {
        // 构建 Annotation 配置驱动的 ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前引导类（被 @Configuration 标注）到 Spring 上下文
        context.register(EnableHelloWorldApplication.class);
        // 启动上下文
        context.refresh();
        // 获取helloWorld Bean
        String helloWorldBean = context.getBean("helloWorld", String.class);
        System.out.printf("helloWorldBean = %s\n", helloWorldBean);
        context.close();
    }
}
