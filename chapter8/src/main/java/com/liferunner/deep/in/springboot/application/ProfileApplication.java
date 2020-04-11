package com.liferunner.deep.in.springboot.application;

import com.liferunner.deep.in.springboot.profile.ICalculateService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

/**
 * ProfileApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/11
 **/
@Configuration
@ComponentScan(basePackageClasses = {ICalculateService.class})
public class ProfileApplication {


    static {
        // 通过Java 系统属性 设置 spring profile
        // 以下语句等效于 ConfigurableEnvironment.setActiveProfiles("java7")
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,"java7");
        // 通过Java 系统属性 设置 spring profile
        // 以下语句等效于 ConfigurableEnvironment.setDefaultProfiles("java8")
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME,"java8");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ProfileApplication.class);
        context.refresh();
        ICalculateService calculateService = context.getBean(ICalculateService.class);
        calculateService.sum(1,2,3,4,5);
        context.close();
    }
}
