package org.xgl.spring.a08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.xgl.spring.a07.Bean11;
import org.xgl.spring.a07.Bean22;

/**
 * Scope：Singleton prototype request session application
 */
@SpringBootApplication
public class A08Application {
    public static void main(String[] args) {
        SpringApplication.run(A08Application.class, args);
    }
}
