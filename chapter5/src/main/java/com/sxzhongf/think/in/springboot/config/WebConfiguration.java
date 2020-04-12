package com.sxzhongf.think.in.springboot.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * WebConfiguration for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/2
 **/
@Configuration
//@SpringBootApplication
//    @EnableAutoConfiguration(excludeName = {"beanName"})
public class WebConfiguration {

    /**
     * WebFlux 函数式端点（endpoint）代码
     */
    @Bean
    public RouterFunction<ServerResponse> hello() {
        return route(GET("/hello"),
            request -> ok().body(Mono.just("Hello,webflux"), String.class)
        );
    }

    /**
     * {@link ApplicationRunner#run(ApplicationArguments)} 方法在Spring Boot 应用启动后调用
     */
    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return (args -> {
            System.out.println("当前Web server实现类为：" +
                context.getWebServer().getClass().getName());
        });
    }

    @Bean
    public ApplicationRunner runner2(BeanFactory beanFactory) {
        return (args -> {
            System.out.println("helloworld bean 实现类为：" +
                beanFactory.getBean("hello").getClass().getName());

            System.out.println("WebConfiguration bean 实现类为：" +
                beanFactory.getBean(WebConfiguration.class).getClass().getName());
        });
    }
}
