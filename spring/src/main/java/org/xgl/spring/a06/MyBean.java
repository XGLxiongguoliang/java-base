package org.xgl.spring.a06;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

public class MyBean implements BeanNameAware, ApplicationContextAware, InitializingBean {

    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean" + this + "    名字叫" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("当前bean" + this + "     容器是" + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("当前bean" + this + "     初始化完成");
    }

    @Autowired
    public void aaa(ApplicationContext applicationContext) {
        System.out.println("当前bean" + this + "  使用@Autowired注入容器：" + applicationContext);
    }

    @PostConstruct
    public void bbb() {
        System.out.println("当前bean" + this + "  使用@PostConstruct初始化");
    }
}