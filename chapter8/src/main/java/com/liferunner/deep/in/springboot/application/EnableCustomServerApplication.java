package com.liferunner.deep.in.springboot.application;

import com.liferunner.deep.in.springboot.config.based_api_impl.CustomServer;
import com.liferunner.deep.in.springboot.config.based_api_impl.CustomServer.Type;
import com.liferunner.deep.in.springboot.config.based_api_impl.import_bean_definition_registrar.CustomServerImportBeanDefinitionRegistrar;
import com.liferunner.deep.in.springboot.config.based_api_impl.import_selector.EnableCustomServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * EnableCustomServerApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
@Configuration
@EnableCustomServer(type = Type.FTP, status = "启动")
public class EnableCustomServerApplication {

    public static void main(String[] args) {
        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(EnableCustomServerApplication.class);
//        context.refresh();

        CustomServer server = context.getBean(CustomServer.class);
        server.start();
        server.stop();
        server.getStatus("a啊啊啊啊");
    }
}
