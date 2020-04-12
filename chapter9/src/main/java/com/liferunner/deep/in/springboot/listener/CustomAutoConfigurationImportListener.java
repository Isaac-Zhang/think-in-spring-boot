package com.liferunner.deep.in.springboot.listener;

import java.util.List;
import java.util.Set;
import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * CustomAutoConfigurationImportListener for 自定义 自动配置监听器
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/12
 **/
public class CustomAutoConfigurationImportListener implements AutoConfigurationImportListener {

    @Override
    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event) {
        // 获取当前类加载的 classLoader
        ClassLoader classLoader = event.getClass().getClassLoader();
        // 获取 自动装配的 类名单集合
        List<String> candidates = SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, classLoader);
        System.out.println("Spring.factories 文件中的候选类总数：" + candidates.size());
        candidates.stream().forEach(System.out::println);
        // 获取实际装配的类名单
        List<String> configurations = event.getCandidateConfigurations();
        System.out.println("实际装载的候选类总数：" + configurations.size());
        configurations.stream().forEach(System.out::println);
        //  获取排除的自动配置类
        Set<String> exclusions = event.getExclusions();
        System.out.println("自动排除的候选类总数：" + exclusions.size());
        exclusions.stream().forEach(System.out::println);
    }
}
