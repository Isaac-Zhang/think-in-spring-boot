package com.liferunner.deep.in.springboot.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

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
    public static class MyEventListener {

        @EventListener(classes = {ContextClosedEvent.class, ContextRefreshedEvent.class})
        public void onEvent() {
            System.out.println("onEvent listener.");
        }

        @EventListener(value = {ContextRefreshedEvent.class, ContextClosedEvent.class})
        public void oneParamter(ApplicationContextEvent event) {
            System.out.println(event.getClass().getSimpleName() + ":" + event.getSource());
        }
    }
}
