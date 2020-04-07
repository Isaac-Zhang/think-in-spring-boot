package com.liferunner.thinking.in.springboot;

import java.lang.reflect.AnnotatedElement;
import org.springframework.util.ReflectionUtils;

/**
 * TransactionalServiceAnnotationReflectionApplication for 利用反射获取 {@link TransactionalService} name()
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/7
 **/
@TransactionalService(name = "isaacTest")
public class TransactionalServiceAnnotationReflectionApplication {

    public static void main(String[] args) {
        //  Class 实现了 AnnotatedElement 接口
        AnnotatedElement annotatedElement = TransactionalServiceAnnotationReflectionApplication.class;

        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);

        System.out.println("显示调用name方法：" + transactionalService.name());

        // 完全 Java 反射实现（ReflectionUtils 为 Spring 的反射工具类）
        ReflectionUtils.doWithMethods(TransactionalService.class,
            method -> System.out.printf("反射获取: %s = %s\n",
                method.getName(),//执行Method 反射
                ReflectionUtils.invokeMethod(method, transactionalService)
            )
            , method -> method.getParameterCount() == 0);// 选择无参数方法

    }
}
