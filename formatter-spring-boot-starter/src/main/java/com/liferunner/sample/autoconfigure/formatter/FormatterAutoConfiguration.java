package com.liferunner.sample.autoconfigure.formatter;

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
    public Formatter defaultFormatter() {
        return new DefaultFormatter();
    }
}
