package com.liferunner.sample;

import com.liferunner.sample.autoconfigure.formatter.Formatter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * FormatterApplication for 验证自动格式化类
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/12
 **/
//@SpringBootApplication
@EnableAutoConfiguration
public class FormatterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterApplication.class).run(args);
        Formatter formatter = context.getBean(Formatter.class);
        formatter.format("isaac");

        Map<String, String> params = new HashMap<>();
        params.put("name", "zhangpan");
        params.put("age", "18");
        System.out.println(formatter.getClass().getSimpleName() + ":格式化map结果：" + formatter.format(params));

        context.close();
    }
}
