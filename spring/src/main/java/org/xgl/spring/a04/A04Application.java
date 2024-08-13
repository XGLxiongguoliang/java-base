package org.xgl.spring.a04;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

public class A04Application {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(Bean01.class);
        context.registerBean(Bean02.class);
        context.registerBean(Bean03.class);
        context.registerBean(Bean04.class);

        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());

        //添加多个处理器，处理器默认会排序，注意注解处理的顺序
        //@Autowired @Value生效
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        //@Resource @PostConstruct @PreDestroy生效
        context.registerBean(CommonAnnotationBeanPostProcessor.class);
        //@ConfigurationProperties生效
        ConfigurationPropertiesBindingPostProcessor.register(context.getDefaultListableBeanFactory());

        context.refresh();

        System.out.println(context.getBean(Bean04.class));

        context.close();
    }
}
