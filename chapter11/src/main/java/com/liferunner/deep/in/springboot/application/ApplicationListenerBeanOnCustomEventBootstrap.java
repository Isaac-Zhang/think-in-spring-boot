package com.liferunner.deep.in.springboot.application;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * ApplicationListenerBeanOnCustomEventBootstrap
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/25
 **/
public class ApplicationListenerBeanOnCustomEventBootstrap {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(MyCustomApplicationListener.class);
        context.refresh();

        context.publishEvent(new MyCustomApplicationEvent("Hello World."));
        context.close();

        // 为了验证 spring 上下文关闭后，依然可以发布事件
        // （结论，虽然可以发布事件，但是被关联
        // 的 ApplicationListener 被移除了，因此，已经无法被监听到了MyCustomApplicationEvent事件了）
        context.publishEvent(new MyCustomApplicationEvent("After Close Context"));
    }

    public static class MyCustomApplicationEvent extends ApplicationEvent {

        /**
         * Create a new {@code ApplicationEvent}.
         *
         * @param source the object on which the event initially occurred or with which the event is associated (never
         * {@code null})
         */
        public MyCustomApplicationEvent(Object source) {
            super(source);
        }
    }

    public static class MyCustomApplicationListener implements
        ApplicationListener<MyCustomApplicationEvent> {

        @Override
        public void onApplicationEvent(MyCustomApplicationEvent event) {
            System.out.println(event.getClass().getSimpleName());
        }
    }
}
