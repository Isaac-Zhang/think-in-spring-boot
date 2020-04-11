package com.liferunner.deep.in.springboot.conditional;

import java.util.Objects;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * OnSystemPropertyCondition for 自定义条件注解
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/11
 **/
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取当前注解类之上所有的 属性方法的值
        MultiValueMap<String, Object> attributes =
            metadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = String.valueOf(attributes.getFirst("name"));
        String value = String.valueOf(attributes.getFirst("value"));

        // 获取系统属性值
        String systemPropertyValue = System.getProperty(name);
        if (Objects.equals(value, systemPropertyValue)) {
            System.out.printf("系统属性【名称：%s】找到匹配值：%s \n", name, value);
            return true;
        }
        return false;
    }
}
