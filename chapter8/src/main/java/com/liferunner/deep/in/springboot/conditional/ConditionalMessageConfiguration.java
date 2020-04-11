package com.liferunner.deep.in.springboot.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConditionalMessageConfiguration for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/11
 **/
@Configuration
public class ConditionalMessageConfiguration {

    @Bean("message")
    @ConditionalOnSystemProperty(name = "language", value = "Chinese")
    public String chineseMessage() {
        return "你好，若初。";
    }

    @Bean("message")
    @ConditionalOnSystemProperty(name = "language", value = "English")
    public String englishMessage() {
        return "hello, Isaac.";
    }
}
