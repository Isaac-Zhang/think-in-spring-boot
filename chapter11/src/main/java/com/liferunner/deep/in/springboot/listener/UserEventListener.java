package com.liferunner.deep.in.springboot.listener;

import com.liferunner.deep.in.springboot.entity.UserEntity;
import com.liferunner.deep.in.springboot.event.CustomGenericEvent;
import org.apache.catalina.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * UserEventListener
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/27
 **/
public class UserEventListener implements ApplicationListener<CustomGenericEvent<UserEntity>> {

    @EventListener
    public void onUserEvent(CustomGenericEvent<UserEntity> event){
        System.out.println("on UserEvent : " + event.getSource());
    }

    @EventListener
    public void onUser(UserEntity event){
        System.out.println("on UserEvent : " + event);
    }

    @Override
    public void onApplicationEvent(CustomGenericEvent<UserEntity> event) {
        System.out.println("onApplicationEvent : " + event.getSource());
    }
}
