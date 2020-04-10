package com.liferunner.deep.in.springboot.config.based_api_impl.import_bean_definition_registrar;

import com.liferunner.deep.in.springboot.config.based_api_impl.CustomFTPServer;
import com.liferunner.deep.in.springboot.config.based_api_impl.CustomHTTPSever;
import com.liferunner.deep.in.springboot.config.based_api_impl.CustomServer;
import com.liferunner.deep.in.springboot.config.based_api_impl.import_selector.EnableCustomServer;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * CustomServerImportBeanDefinitionRegistrar for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
public class CustomServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 获取AnnotationAttributes,key为 注解属性名，value为属性返回类型
        Map<String, Object> annotationAttributes =
            importingClassMetadata.getAnnotationAttributes(EnableCustomServer.class.getName());
        CustomServer.Type type = (CustomServer.Type) annotationAttributes.get("type");
        String[] importClassNames = new String[0];
        switch (type) {
            case HTTP:
                importClassNames = new String[]{CustomHTTPSever.class.getName()};
                break;
            case FTP:
                importClassNames = new String[]{CustomFTPServer.class.getName()};
                break;
        }
        // 根据创建的服务名称集合，来创建 Bean
        Stream.of(importClassNames)
            // 将 名称转换为 BeanDefinitionBuilder 对象
            .map(BeanDefinitionBuilder::genericBeanDefinition)
            // 将 BeanDefinitionBuilder 转换为 BeanDefinition
            .map(BeanDefinitionBuilder::getBeanDefinition)
            // 将所有的 BeanDefinition 循环注册
            .forEach(beanDefinition -> {
                // 注册BeanDefinition 到 BeanDefinitionRegistry
                System.out.println("beanDefinition:" + beanDefinition);
                BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
            });
    }
}
