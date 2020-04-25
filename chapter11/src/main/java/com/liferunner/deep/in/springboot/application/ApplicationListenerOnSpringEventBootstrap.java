package com.liferunner.deep.in.springboot.application;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * ApplicationListenerOnSpringEventBootstrap
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/25
 **/
public class ApplicationListenerOnSpringEventBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new GenericApplicationContext();
        System.out.println("创建Spring 应用上下文：" + context.getDisplayName());

        // 添加 ApplicationListener 非 泛型实现
        context.addApplicationListener(event -> {
            System.out.println("触发事件：" + event.getClass().getSimpleName());
        });

        System.out.println("应用上下文准备初始化...");
        context.refresh();
        System.out.printf("应用上下文初始化完成。");

        System.out.println("应用上下文准备停止启动...");
        context.stop();
        System.out.println("应用上下文已经停止。");

        System.out.println("应用上下文【准备启动】启动...");
        context.start();
        System.out.println("应用上下文已经【准备启动】完成。");

        System.out.println("应用上下文【准备关闭】启动...");
        context.close();
        System.out.println("应用上下文已经【关闭】完成。");
    }
}
