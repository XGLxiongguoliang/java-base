package org.xgl.spring.a01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class XglTest001 {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public XglTest001() {
    }

    public void registerUser() {
        System.out.println("user注册");
        eventPublisher.publishEvent(new UserRegisteredEvent(this));
    }
}

