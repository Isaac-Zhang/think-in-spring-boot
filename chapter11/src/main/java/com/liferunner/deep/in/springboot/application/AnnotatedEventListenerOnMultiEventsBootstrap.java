package com.liferunner.deep.in.springboot.application;

import java.util.concurrent.ThreadFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * AnnotatedEventListenerOnMultiEventsBootstrap
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/25
 **/
public class AnnotatedEventListenerOnMultiEventsBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyEventListener.class);
        context.refresh();
        context.close();
    }

    // @Async需要激活，否则无效
    @EnableAsync
    public static class MyEventListener {

        @EventListener(classes = {ContextClosedEvent.class, ContextRefreshedEvent.class})
        @Async
        public void onEvent() {
            System.out.println("onEvent listener.当前线程：" + Thread.currentThread().getName());
        }

        @EventListener(value = {ContextRefreshedEvent.class, ContextClosedEvent.class})
        public void oneParamter(ApplicationContextEvent event) {
            System.out.println(event.getClass().getSimpleName() + "：当前线程：" + Thread.currentThread().getName());
        }
    }
}
