package com.liferunner.deep.in.springboot.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * CustomGenericEvent 泛型事件
 *
 * @param <T> 泛型类型
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/27
 **/
public class CustomGenericEvent<T> extends ApplicationEvent
    implements ResolvableTypeProvider {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with which the event is associated (never
     * {@code null})
     */
    public CustomGenericEvent(Object source) {
        super(source);
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
            ResolvableType.forInstance(getSource()));
    }

    @Override
    public T getSource() {
        return (T) super.getSource();
    }
}
