package org.xgl.spring.a05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

public class ComponentScanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ComponentScan annotation = AnnotationUtils.findAnnotation(Config.class, ComponentScan.class);
        Optional.ofNullable(annotation).ifPresent(a -> {
            for (String s : a.basePackages()) {
                System.out.println("package---" + s);
                String path = "classpath*:" + s.replace(".", "/") + "/**/*class";
                System.out.println("path===" + path);

                CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();

                try {
                    Resource[] resources = new PathMatchingResourcePatternResolver().getResources(path);
                    AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();
                    for (Resource resource : resources) {
                        System.out.println(resource);
                        MetadataReader reader = factory.getMetadataReader(resource);
                        System.out.println("类名---" + reader.getAnnotationMetadata().getClassName());
                        System.out.println("是否有Component---" + reader.getAnnotationMetadata().hasAnnotation(Component.class.getName()));
                        System.out.println("是否有Component 派生---" + reader.getAnnotationMetadata().hasAnnotatedMethods(Component.class.getName()));

                        if (reader.getAnnotationMetadata().hasAnnotation(Component.class.getName()) ||
                                reader.getAnnotationMetadata().hasAnnotatedMethods(Component.class.getName())) {
                            AbstractBeanDefinition db = BeanDefinitionBuilder
                                    .genericBeanDefinition(reader.getClassMetadata().getClassName())
                                    .getBeanDefinition();
                           if (configurableListableBeanFactory instanceof DefaultListableBeanFactory) {
                               DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
                               String name = generator.generateBeanName(db, beanFactory);
                               beanFactory.registerBeanDefinition(name, db);
                           }


                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}
