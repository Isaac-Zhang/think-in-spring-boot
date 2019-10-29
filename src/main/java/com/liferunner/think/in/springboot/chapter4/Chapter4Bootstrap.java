package com.liferunner.think.in.springboot.chapter4;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Chapter2Bootstrap for : TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/10/20
 */
@SpringBootApplication
@RestController
public class Chapter4Bootstrap {

    @GetMapping("/")
    public String index() {
        return "Hello, buddy.";
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter4Bootstrap.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> hello() {
        return route(GET("/hello"),
                request -> ok().body(Mono.just("Hello,webflux"), String.class)
        );
    }

    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return (args -> {
            System.out.println("当前Web server实现类为：" +
                    context.getWebServer().getClass().getName());
        });
    }
}