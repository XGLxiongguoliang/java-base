package org.xgl.spring.a01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class A01Application {
    private static final Logger log = LoggerFactory.getLogger(A01Application.class);

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        ConfigurableApplicationContext context = SpringApplication.run(A01Application.class, args);

        /**
         * BeanFactory是什么？
         * 它是ApplicationContext的一个父接口
         * 它是Spring的核心容器，ApplicationContext的主要实现都组合了其功能
         */

        /**
         * BeanFactory能干什么？
         * 接口层面看好像只有getBean
         * 实际上控制返回、基本的依赖注入、直至Bean的生命周期的各种功能，都是由它的实现类提供的
         */

        /**
         * ApplicationContext比BeanFactory多什么？
         * 1、国际化、资源、环境变量、事件
         */

        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);
        map.entrySet().stream()
                .filter(e->e.getKey().startsWith("xglTest"))
                .forEach(e-> System.out.println(e.getKey() + "=" + e.getValue()));


        // 国际化
        System.out.println(context.getMessage("hi", null, Locale.SIMPLIFIED_CHINESE));
        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));
        System.out.println(context.getMessage("hi", null, Locale.JAPANESE));

        //资源
        Resource resource = context.getResource("classpath:messages");
        System.out.println(resource);

        Resource[] resources = context.getResources("classpath.*:META-INF/spring.factories");
        for (Resource resource1 : resources) {
            System.out.println(resource1);
        }

        //环境变量
        System.out.println(context.getEnvironment().getProperty("java_home"));

        //事件
        context.getBean(XglTest001.class).registerUser();

    }
}
