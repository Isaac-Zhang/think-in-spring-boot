package com.liferunner.thinking.in.springboot;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MainApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/5
 **/
public class MainApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("classpath:/META-INF/spring/context.xml");
        //启动上下文
        context.refresh();
        ChineseNamingRepository repository = (ChineseNamingRepository) context.getBean("chineseNamingRepository");
        System.out.println(repository.findAll());
    }
}
