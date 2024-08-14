package org.xgl.spring.a06;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

public class A06Application {
    public static void main(String[] args) {
        /**
         * Aware接口用于注入一些与容器相关的信息
         * BeanFactoryAware注入BeanFactory容器
         * ApplicationContextAware注入ApplicationContext容器
         * EmbeddedValueResolverAware ${}
         */
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("myBean", MyBean.class);

        //处理器
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        context.registerBean(CommonAnnotationBeanPostProcessor.class);

        context.refresh();
        context.close();

        /**
         * @Autowired可以实现，为什么还要使用Aware接口呢？
         * 简单的说：
         * 1、@Autowired的解析需要 用到bean的后置处理器，属于扩展功能
         * 2、Aware接口属于内置功能，不加任何扩展功能，Spring就能识别，
         * 在一些情况下，扩展功能会失效，而内置功能不会失效
         *
         * eg：Aware注入ApplicationContext成功，@Autowired注入失败
         */
    }
}
