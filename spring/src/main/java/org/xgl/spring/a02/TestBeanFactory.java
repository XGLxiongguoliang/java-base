package org.xgl.spring.a02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

public class TestBeanFactory {
    public static void main(String[] args) {

        /**
         * BeanFactory不会做哪些事情？
         * 1、不会主动调用BeanFactory的后置处理器
         * 2、不会主动添加Bean后置处理器
         * 3、不会主动初始化单例对象
         * 4、不会解析BeanFactory，还不会解析${}和#{}
         *
         * Bean后置处理器会有排序的逻辑
         */

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();
        beanFactory.registerBeanDefinition("config", beanDefinition);

        //可以看出来，注解的类没有被加载
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        //给BeanFactory添加一些常用的后置处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        //可以看出来，加入了一些常用后置处理器之后,注解的类一部分被加载
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values()
                .stream()
                .forEach(
                        beanFactoryPostProcessor -> {
                            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
                        });

        //Bean后置处理器。针对Bean的生命周期的各个阶段提供扩展，例如@Autowired @Resource
        beanFactory.getBeansOfType(BeanPostProcessor.class).values()
                .stream()
                .sorted(beanFactory.getDependencyComparator())
                .forEach(beanPostProcessor -> {
                    System.out.println("====>" + beanPostProcessor);
                    beanFactory.addBeanPostProcessor(beanPostProcessor);
                });

        //可以看出来，加入了所有的后置处理器之后,注解的类都被加载
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        //正常情况，只要在调用的时候才初始换单例对象，该方法可以将单列对象都提前初始化
        beanFactory.preInstantiateSingletons();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");

        //System.out.println(beanFactory.getBean(Bean1.class).getBean2());

        System.out.println(beanFactory.getBean(Bean1.class).getInter());
    }

    @Configuration
    static class Config {
        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }

        @Bean
        public Bean3 bean3() {
            return new Bean3();
        }

        @Bean
        public Bean4 bean4() {
            return new Bean4();
        }
    }

    static class Bean1 {
        @Autowired
        private Bean2 bean2;

        public Bean1() {
            System.out.println("构造bean1----");
        }

        public Bean2 getBean2() {
            return bean2;
        }

        @Autowired
        @Resource(name = "bean4")
        private Inter bean3;

        public Inter getInter() {
            return bean3;
        }
    }

    static class Bean2 {
        //private Bean1 bean1;

        public Bean2() {
            System.out.println("构造bean2----");
        }

        /*public Bean1 getBean1() {
            return bean1;
        }*/
    }

    interface Inter {

    }

    static class Bean3 implements Inter {

    }

    static class Bean4 implements Inter {

    }
}
