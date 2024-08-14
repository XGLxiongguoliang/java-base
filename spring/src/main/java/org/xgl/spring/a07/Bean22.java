package org.xgl.spring.a07;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class Bean22 implements DisposableBean {

    @PreDestroy
    public void destroy1() {
        System.out.println("销毁1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁2");
    }

    public void destroy3() {
        System.out.println("销毁3");
    }
}
