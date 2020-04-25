package com.liferunner.deep.in.springboot.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * AnnotatedEventListenerBootstrap
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/25
 **/
public class AnnotatedEventListenerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyEventListener.class);
        context.refresh();
        context.close();
    }
    public static abstract class MyAbstractEventListener {

        @EventListener(ContextRefreshedEvent.class)
        public void onContextRefreshedEvent(ContextRefreshedEvent event) {
            System.out.println("MyAbstractEventListener:" + event.getClass().getSimpleName());
        }
    }

    public static class MyEventListener extends MyAbstractEventListener {

        @EventListener(ContextClosedEvent.class)
        public boolean onContextClosedEvent(ContextClosedEvent event) {
            System.out.println("MyEventListener:" + event.getClass().getSimpleName());
            return true;
        }
    }
}
