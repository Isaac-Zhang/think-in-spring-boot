package com.liferunner.deep.in.springboot.application;

import java.util.stream.Stream;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * ComponentScanDefultPackageApplication for 扫描加载默认包 默认包（Default Package）又称之为 根包 Java 语言规范中的术语为： unnamed package
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/11
 **/
@ComponentScan("")
public class ComponentScanDefultPackageApplication {

    public static void main(String[] args) {
        //1. 注册当前引导类到 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ComponentScanDefultPackageApplication.class
        );
        //2. 打印所有注册到spring 上下文 bean
        String[] beanNames = context.getBeanDefinitionNames();
        Stream.of(beanNames).map(name -> "\t" + name).forEach(System.out::println);
        context.close();

    }

}
