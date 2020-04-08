package com.liferunner.thinking.in.springboot;

import java.util.Map;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.SimpleTransactionStatus;

/**
 * TransactionalServiceBeanApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/8
 **/
@Configuration
@ComponentScan(basePackageClasses = TransactionalService.class)
@EnableTransactionManagement // 激活事务管理
public class TransactionalServiceBeanApplication {

    public static void main(String[] args) {
        // 注册当前引导类作为 Configuration Class
        ConfigurableApplicationContext configurableApplicationContext =
            new AnnotationConfigApplicationContext(TransactionalServiceBeanApplication.class);
        // 获取所有类型为 TransactionalServiceBean 的Bean ，其中 Key 为 Bean 名称
        Map<String, TransactionalServiceBean> map =
            configurableApplicationContext.getBeansOfType(TransactionalServiceBean.class);

        map.forEach((beanName, transactionalServiceBean) -> {
            System.out.printf("Bean 名称 ： %s，对象 ： %s\n", beanName, transactionalServiceBean);
            transactionalServiceBean.save();
        });

        configurableApplicationContext.close();
    }

    @Bean("txManager")
    public PlatformTransactionManager txManager() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager: 事务提交");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {

            }
        };
    }

    @Bean("txManager2")
    public PlatformTransactionManager txManager2() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager2: 事务提交");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {

            }
        };
    }
}
