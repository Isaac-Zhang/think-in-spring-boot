package com.liferunner.deep.in.springboot.application;

import com.liferunner.deep.in.springboot.entity.UserEntity;
import com.liferunner.deep.in.springboot.event.CustomGenericEvent;
import com.liferunner.deep.in.springboot.listener.UserEventListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * GenericEventListenerBootstrap
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/27
 **/
public class GenericEventListenerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserEventListener.class);
        context.refresh();
        CustomGenericEvent<UserEntity> userEntityCustomGenericEvent = new CustomGenericEvent<>(new UserEntity("zp"));
        context.publishEvent(userEntityCustomGenericEvent);
        context.publishEvent(new UserEntity("张孜寒"));
        context.close();
    }

}
