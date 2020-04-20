package com.liferunner.sample.autoconfigure.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FormatterAutoConfiguration for 格式化的自动配置
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/12
 **/
@Configuration
public class FormatterAutoConfiguration {

    @Bean
    @ConditionalOnMissingClass(value = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter defaultFormatter() {
        return new DefaultFormatter();
    }

    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    @ConditionalOnMissingBean(type = "com.fasterxml.jackson.databind.ObjectMapper")
//    @ConditionalOnMissingBean(value = ObjectMapper.class)
    public Formatter jsonFormatter() {
        return new JsonFormatter();
    }

    @Bean
    @ConditionalOnBean(ObjectMapper.class)
    public Formatter objectMapperFormatter(ObjectMapper objectMapper) {
        return new JsonFormatter(objectMapper);
    }
}
