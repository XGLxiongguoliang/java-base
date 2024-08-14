package org.xgl.spring.a06;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MyConfig2 implements InitializingBean, ApplicationContextAware {

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        System.out.println("注入 Application");
    }

    @Bean
    public BeanFactoryPostProcessor processor1() {
        return beanFactory -> System.out.println("执行 processor1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }
}