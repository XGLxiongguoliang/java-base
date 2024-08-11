package org.xgl.spring.a03;

import java.util.ArrayList;
import java.util.List;

public class TestMethodTemplate {
    public static void main(String[] args) {
        MyBeanFactory beanFactory = new MyBeanFactory();
        beanFactory.addBeanPostProcessor(bean -> System.out.println("解析 @Autowired"));
        beanFactory.addBeanPostProcessor(bean -> System.out.println("解析 @Resource"));
        beanFactory.getBean();
    }

    static class MyBeanFactory {

        private List<BeanPostProcessor> processors = new ArrayList<>();

        public Object getBean() {
            Object bean = new Object();
            System.out.println("构造：" + bean);
            System.out.println("依赖注入：" + bean);
            for (BeanPostProcessor processor : processors) {
                processor.inject(processor);
            }
            System.out.println("初始化：" + bean);
            return bean;
        }

        public void addBeanPostProcessor(BeanPostProcessor processor) {
            processors.add(processor);
        }
    }

    static interface BeanPostProcessor {
        void inject(Object bean); //依赖注入阶段的扩展
    }
}