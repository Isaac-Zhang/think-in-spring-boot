package com.liferunner.deep.in.springboot.web_auto_config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * SpringWebMvcServletInitializer for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
public class SpringWebMvcServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * DispatcherServlet 配置 Bean
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
//        return new Class[0];
        return of(SpringWebMvcConfiguration.class);
    }

    /**
     * DispatcherServlet URL Pattern 映射
     */
    @Override
    protected String[] getServletMappings() {
//        return new String[0];
        return of("/*");
    }

    /**
     * 遍历 API，减少 new T[] 代码
     */
    private static <T> T[] of(T... values) {
        return values;
    }
}
