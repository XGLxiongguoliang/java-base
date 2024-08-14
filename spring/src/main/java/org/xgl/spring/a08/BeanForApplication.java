package org.xgl.spring.a08;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Scope("application")
@Component
public class BeanForApplication {

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
