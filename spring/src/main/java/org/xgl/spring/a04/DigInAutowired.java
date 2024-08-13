package org.xgl.spring.a04;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.env.StandardEnvironment;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class DigInAutowired {
    public static void main(String[] args) throws Throwable {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerSingleton("bean2", new Bean02());
        beanFactory.registerSingleton("bean3", new Bean03());
        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
        //${}的解析器
        beanFactory.addEmbeddedValueResolver(new StandardEnvironment()::resolvePlaceholders);

        //查找哪些属性、方法加了@Autowired，这称之为InjectionMetadata
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setBeanFactory(beanFactory);

        Bean01 bean01 = new Bean01();
        System.out.println(bean01);

        //执行依赖注入，解析@Autowired @Value

        //processor.postProcessProperties(null, bean01, "bean01");
        Method findAutowiringMetadata = AutowiredAnnotationBeanPostProcessor.class.getDeclaredMethod("findAutowiringMetadata", String.class, Class.class, PropertyValues.class);
        findAutowiringMetadata.setAccessible(true);
        //获取Bean01上加了@Value @Autowired的成员变量和方法
        InjectionMetadata metadata = (InjectionMetadata) findAutowiringMetadata.invoke(processor, "bean01", Bean01.class, null);
        System.out.println(metadata);
        metadata.inject(bean01, "bean01", null);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(bean01);

        Field bean03Field = Bean01.class.getDeclaredField("bean03");
        DependencyDescriptor dd = new DependencyDescriptor(bean03Field, false);
        Object o = beanFactory.doResolveDependency(dd, null, null, null);
        System.out.println(o);
    }
}
