package org.xgl.springmvc.a20;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 学习到的要点
 * 1、DispatcherServlet可以设置在启动时进行初始化，不设置，则在第一次请求的时候初始化
 * 2、将变量配置到配置文件中，防止硬编码（如何通过注解的形式获取配置文件中的参数）
 */
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties({WebMvcProperties.class, ServerProperties.class})
public class WebConfig {
    //内嵌的web容器工厂
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(ServerProperties serverProperties) {
        return new TomcatServletWebServerFactory(serverProperties.getPort());
    }
    //创建DispatcherServlet
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
    //注册DispatcherServlet,Spring MVC入口
    @Bean
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet,
                                                                               WebMvcProperties webMvcProperties) {
        DispatcherServletRegistrationBean registrationBean = new DispatcherServletRegistrationBean(dispatcherServlet, "/");
        //DispatcherServlet可以设置在启动时进行初始化，不设置，则在第一次请求的时候初始化
        registrationBean.setLoadOnStartup(webMvcProperties.getServlet().getLoadOnStartup());
        return registrationBean;
    }

    /**
     * 如果用DispatcherServlet初始化时默认添加的组件，并不会作为bean，给测试带来困扰
     * 1、加入RequestMappingHandlerMapping
     * @return
     */
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    /**
     * 添加RequestMappingHandlerAdapter,会替换掉DispatcherServlet默认的四个HandlerAdapter
     * @return
     */
    @Bean
    public MyRequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        MyRequestMappingHandlerAdapter handlerAdapter = new MyRequestMappingHandlerAdapter();

        YmlReturnValueHandler ymlReturnValueHandler = new YmlReturnValueHandler();
        List<HandlerMethodReturnValueHandler> handlerList = new ArrayList<>();
        handlerList.add(ymlReturnValueHandler);

        TokenArgumentResolver tokenArgumentResolver = new TokenArgumentResolver();
        List<HandlerMethodArgumentResolver> resolverList = new ArrayList<>();
        resolverList.add(tokenArgumentResolver);

        handlerAdapter.setCustomArgumentResolvers(resolverList);
        handlerAdapter.setCustomReturnValueHandlers(handlerList);

        System.out.println("Creating custom MyRequestMappingHandlerAdapter");

        return handlerAdapter;
    }
}