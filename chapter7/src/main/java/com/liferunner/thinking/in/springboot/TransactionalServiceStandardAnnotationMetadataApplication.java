package com.liferunner.thinking.in.springboot;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

/**
 * TransactionalServiceStandardAnnotationMetadataApplication for 使用Spring 4.0 引入的 {@link
 * AnnotationMetadata#getAnnotationTypes()} 获取所有元注解类型
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/7
 **/
@TransactionalService
public class TransactionalServiceStandardAnnotationMetadataApplication {

    public static void main(String[] args) {
        // 1. 读取 当前标注类的 注解元信息
        AnnotationMetadata annotationMetadata =
            new StandardAnnotationMetadata(TransactionalServiceStandardAnnotationMetadataApplication.class);

        // 2. 查询合并所有的元注解的类型
        Set<String> metaAnnotationTypes = annotationMetadata.getAnnotationTypes().stream()
            .map(annotationMetadata::getMetaAnnotationTypes)
            //合并元注解类型（全类名） 集合
            .collect(LinkedHashSet::new, Set::addAll, Set::addAll);

        // 3. 循环元注解属性名称
        for (String metaAnnotationType : metaAnnotationTypes) {
            // 4. 根据元注解名称查询读取元注解属性信息
            Map<String, Object> annotationAttr = annotationMetadata.getAnnotationAttributes(metaAnnotationType);
            if (!CollectionUtils.isEmpty(annotationAttr)) {
                annotationAttr.forEach((name, value) -> {
//                    System.out.printf("注解 @%s 的属性 %s = %s\n", metaAnnotationType, name, value);
                    System.out.printf("注解 @%s 的属性 %s = %s\n", ClassUtils.getShortName(metaAnnotationType), name, value);
                });
            }
        }
    }
}
