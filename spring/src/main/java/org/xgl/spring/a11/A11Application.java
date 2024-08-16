package org.xgl.spring.a11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class A11Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A11Application.class, args);
        Myservice myservice = context.getBean(Myservice.class);
        System.out.println("myservice class: ---" + myservice.getClass());
        myservice.foo();
    }
}
