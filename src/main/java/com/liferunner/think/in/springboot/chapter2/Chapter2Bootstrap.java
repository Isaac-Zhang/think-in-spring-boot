package com.liferunner.think.in.springboot.chapter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Chapter2Bootstrap for : TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/10/20
 */
@SpringBootApplication
@RestController
public class Chapter2Bootstrap {

    @GetMapping("/")
    public String index() {
        return "Hello, buddy.";
    }

//    public static void main(String[] args) {
//        SpringApplication.run(Chapter2Bootstrap.class, args);
//    }
}
