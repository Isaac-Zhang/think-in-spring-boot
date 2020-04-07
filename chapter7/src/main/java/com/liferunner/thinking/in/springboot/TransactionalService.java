package com.liferunner.thinking.in.springboot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TransactionalService for 演示组合注解
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/7
 **/
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Transactional
@Service
public @interface TransactionalService {

    /**
     * @return 服务 bean 名称
     */
    String name() default "";
}
