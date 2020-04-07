package com.liferunner.thinking.in.springboot;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

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
//            , method -> method.getParameterCount() == 0);// 选择无参数方法
            , method -> !method.getDeclaringClass().equals(Annotation.class)); // 因为所有的注解实现了Annotation接口，因此要过滤掉

        // 获取 TransactionalService 的所有元注解
        Set<Annotation> annotationSet = getAllMetaAnnotations(transactionalService);
        annotationSet.forEach(annotation -> {
            ReflectionUtils.doWithMethods(annotation.annotationType(),
                method -> System.out.printf("反射获取: %s.%s = %s\n",
                    annotation.annotationType().getSimpleName(),
                    method.getName(),//执行Method 反射
                    ReflectionUtils.invokeMethod(method, annotation)
                )
                , method -> !method.getDeclaringClass().equals(Annotation.class)); // 因为所有的注解实现了Annotation接口，因此要过滤掉

        });
    }

    /**
     * 获取 annotation 的所有元注解
     */
    private static Set<Annotation> getAllMetaAnnotations(Annotation annotation) {
        Annotation[] annotations = annotation.annotationType().getAnnotations();
        if (StringUtils.isEmpty(annotation)) {
            return Collections.EMPTY_SET;
        }

        //获取所有非 Java 标准元注解集合
        Set<Annotation> annotationSet = Arrays.stream(annotations).filter(mt -> !Target.class.getPackage().equals(
            mt.annotationType().getPackage()
        )).collect(Collectors.toSet());
        // 递归查找注解上的元注解集合
        Set<Annotation> mtaSet = annotationSet.stream().map(
            TransactionalServiceAnnotationReflectionApplication::getAllMetaAnnotations
        ).collect(HashSet::new, Set::addAll, Set::addAll);

        annotationSet.addAll(mtaSet);
        return annotationSet;
    }
}
