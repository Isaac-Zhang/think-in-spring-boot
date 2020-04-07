package com.liferunner.thinking.in.springboot;

import java.lang.reflect.AnnotatedElement;

/**
 * TransactionalServiceAnnotationReflectionApplication for
 * 利用反射获取 {@link TransactionalService} name()
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/7
 **/
@TransactionalService(name = "isaacTest")
public class TransactionalServiceAnnotationReflectionApplication {

    public static void main(String[] args) {
        //  Class 实现了 AnnotatedElement 接口
        AnnotatedElement annotatedElement = TransactionalServiceAnnotationReflectionApplication.class;

        String name = annotatedElement.getAnnotation(TransactionalService.class).name();

        System.out.println(name);
    }
}
