package org.xgl.spring.a07;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bean11 implements InitializingBean {

    @PostConstruct
    public void init1() {
        System.out.println("初始化1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化2");
    }

    public void init3() {
        System.out.println("初始化3");
    }
}
