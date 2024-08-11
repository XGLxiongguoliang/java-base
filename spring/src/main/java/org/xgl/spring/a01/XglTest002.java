package org.xgl.spring.a01;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class XglTest002 {
    public XglTest002() {
    }

    @EventListener(UserRegisteredEvent.class)
    public void qqq(UserRegisteredEvent event) {
        System.out.println("qqq接收用户注册事件---" + event);
    }
}
