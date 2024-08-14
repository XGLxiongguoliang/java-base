package org.xgl.spring.a10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class A10Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A10Application.class, args);
        Myservice myservice = context.getBean(Myservice.class);
        System.out.println("myservice class: ---" + myservice.getClass());
        myservice.foo();

        //new Myservice().foo();
    }
}
