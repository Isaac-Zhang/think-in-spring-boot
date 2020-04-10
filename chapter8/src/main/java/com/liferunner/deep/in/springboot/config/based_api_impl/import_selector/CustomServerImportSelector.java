package com.liferunner.deep.in.springboot.config.based_api_impl.import_selector;

import com.liferunner.deep.in.springboot.config.based_api_impl.CustomFTPServer;
import com.liferunner.deep.in.springboot.config.based_api_impl.CustomHTTPSever;
import com.liferunner.deep.in.springboot.config.based_api_impl.CustomServer;
import java.util.Map;
import java.util.function.Predicate;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * CustomServerImportSelector for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
public class CustomServerImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 读取 EnableCustomServer 中的所有属性
        // 启动 key 为属性方法名称， value 为属性方法的返回对象
        Map<String, Object> annotationAttributes =
            importingClassMetadata.getAnnotationAttributes(EnableCustomServer.class.getName());
        // 获取名为 type 的属性方法，并且强制转换为 CustomServer.Type 类型
        CustomServer.Type type = (CustomServer.Type) annotationAttributes.get("type");
        annotationAttributes.entrySet().stream().forEach(System.out::println);
        // 导入的类名称数组
        String[] importClassNames = new String[0];
        switch (type) {
            case HTTP: // 当设置类型为 HTTP时，返回 CustomHTTPServer
                importClassNames = new String[]{CustomHTTPSever.class.getName()};
                break;
            case FTP:
                importClassNames = new String[]{CustomFTPServer.class.getName()};
                break;
        }
        return importClassNames;
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
