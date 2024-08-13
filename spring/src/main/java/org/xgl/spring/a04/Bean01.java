package org.xgl.spring.a04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Bean01 {
    private Bean02 bean02;

    @Autowired
    public void setBean02(Bean02 bean02) {
        System.out.println("@Autowired---生效---" + bean02);
        this.bean02 = bean02;
    }

    private Bean03 bean03;

    @Resource
    public void setBean03(Bean03 bean03) {
        System.out.println("@Resource---生效---" + bean03);
        this.bean03 = bean03;
    }

    private String home;

    @Autowired
    public void setHome(@Value("${JAVA_HOME}") String home) {
        System.out.println("@Value---生效---" + home);
        this.home = home;
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct 生效");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("@PreDestroy 生效");
    }

    @Override
    public String toString() {
        return "Bean01{" +
                "bean02=" + bean02 +
                ", bean03=" + bean03 +
                ", name='" + home + '\'' +
                '}';
    }
}
