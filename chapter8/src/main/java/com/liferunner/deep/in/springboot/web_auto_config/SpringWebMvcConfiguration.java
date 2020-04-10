package com.liferunner.deep.in.springboot.web_auto_config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * SpringWebMvcConfiguration for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {SpringWebMvcConfiguration.class})
public class SpringWebMvcConfiguration {

}
