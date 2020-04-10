package com.liferunner.deep.in.springboot.config.based_api_impl.import_selector;

import com.liferunner.deep.in.springboot.config.based_api_impl.CustomServer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * EnableCustomServer for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CustomServerImportSelector.class) // 导入 CustomServerImportSelector
public @interface EnableCustomServer {

    /**
     * 设置 服务器类型
     *
     * @return non-null
     */
    CustomServer.Type type();

    /**
     * 服务状态
     */
    String status();
}
