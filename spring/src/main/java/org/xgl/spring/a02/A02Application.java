package org.xgl.spring.a02;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A02Application {
    public static void main(String[] args) {
//        testClassPathXmlApplicationContext();
//        testFileSystemXmlApplicationContext();
//        testAnnotationConfigApplicationContext();
        testAnnotationConfigServletWebServerApplicationContext();
    }

    //基于classpath下的xml格式的配置文件来创建
    private static void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("b01.xml");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println("beanName---" + beanName);
        }
        System.out.println(context.getBean(Bean2.class).getBean1());
    }

    //基于磁盘下的xml格式的配置文件来创建
    private static void testFileSystemXmlApplicationContext() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("C:\\software\\project\\learn-java\\base-java\\spring\\src\\main\\java\\resources\\b01.xml");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println("beanName---" + beanName);
        }
    }

    //基于注解
    private static void testAnnotationConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println("beanName---" + beanName);
        }
    }

    //基于java配置类来创建
    private static void testAnnotationConfigServletWebServerApplicationContext() {
        AnnotationConfigServletWebServerApplicationContext context = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println("beanName---" + beanName);
        }
    }

    @Configuration
        static class WebConfig {
        @Bean
        public ServletWebServerFactory servletWebServerFactory() {
            return new TomcatServletWebServerFactory();
        }

        @Bean
        public DispatcherServlet dispatcherServlet() {
            return new DispatcherServlet();
        }

        @Bean
        public DispatcherServletRegistrationBean registrationBean(DispatcherServlet dispatcherServlet) {
            return new DispatcherServletRegistrationBean(dispatcherServlet, "/");
        }

        @Bean("/hello")
        public Controller controller() {
            return new Controller() {
                @Override
                public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
                    httpServletResponse.getWriter().println("Hello");
                    return null;
                }
            };
        }
    }

    @Configuration
    static class Config {
        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }
    }

    static class Bean1 {
    }

    static class Bean2 {
        private Bean1 bean1;

        public Bean1 getBean1() {
            return bean1;
        }

        public void setBean1(Bean1 bean1) {
            this.bean1 = bean1;
        }
    }
}


