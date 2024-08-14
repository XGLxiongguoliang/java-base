package org.xgl.spring.a07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class A07Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A07Application.class, args);
        context.close();
    }

    @Bean(initMethod = "init3")
    public Bean11 bean1() {
        return new Bean11();
    }

    @Bean(initMethod = "destroy3")
    public Bean22 bean2() {
        return new Bean22();
    }
}
