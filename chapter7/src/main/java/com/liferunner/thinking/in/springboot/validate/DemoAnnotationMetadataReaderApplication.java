package com.liferunner.thinking.in.springboot.validate;

import java.io.IOException;
import java.util.Set;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoAnnotationMetadataReaderApplication for 演示 {@link org.springframework.core.type.AnnotationMetadata}
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/5
 **/
@RestController
public class DemoAnnotationMetadataReaderApplication {

    public static void main(String[] args) throws IOException {
        String clazzName = DemoAnnotationMetadataReaderApplication.class.getName();
        // 构建 MetadataReaderFactory
        MetadataReaderFactory factory = new CachingMetadataReaderFactory();
        // 根据 文件名查找 Resource 信息，转为 MetadataReader
        MetadataReader reader = factory.getMetadataReader(clazzName);
        // 获取全量注解
        AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();
        // 循环注解类型
        annotationMetadata.getAnnotationTypes().forEach(t -> {
            // 循环查找每一个注解的类型
            Set<String> mat = annotationMetadata.getMetaAnnotationTypes(t);
            mat.stream().forEach(s -> {
                System.out.printf("注解 @%s 的元标注 @%s \n", t, s);
            });
        });
    }

}
