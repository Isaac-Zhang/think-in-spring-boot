package com.sxzhongf.think.in.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * WebAutoConfiguration for 自动装配web config类
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/2
 **/
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {

}
