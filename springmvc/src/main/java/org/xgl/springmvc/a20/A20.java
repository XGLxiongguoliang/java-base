package org.xgl.springmvc.a20;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class A20 {
    public static void main(String[] args) throws Exception {
        AnnotationConfigServletWebServerApplicationContext context = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
        //作用就是解析RequestMapping注解以及一些派生注解，生成路径和控制器方法的映射关系，在初始化的时候就生成
        RequestMappingHandlerMapping handlerMapping = context.getBean(RequestMappingHandlerMapping.class);

        //获取映射结果
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = handlerMapping.getHandlerMethods();
        handlerMethodMap.forEach((k, v) -> {
            System.out.println("k---" + k + "   " + "value---" + v);
        });

        //请求来了，获取控制器方法.返回处理器执行链对象
        //MockHttpServletRequest request = new MockHttpServletRequest("GET", "/test1");
        //MockHttpServletResponse response = new MockHttpServletResponse();

        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/test4");
        request.addHeader("token", "令牌·········");
        MockHttpServletResponse response = new MockHttpServletResponse();

        HandlerExecutionChain chain = handlerMapping.getHandler(request);
        System.out.println("chain---" + chain);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        MyRequestMappingHandlerAdapter handlerAdapter = context.getBean(MyRequestMappingHandlerAdapter.class);
        handlerAdapter.invokeHandlerMethod(request, response, (HandlerMethod) chain.getHandler());

        //检查响应
        byte[] content = response.getContentAsByteArray();
        System.out.println(new String(content, StandardCharsets.UTF_8));


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>所有参数解析器");
        List<HandlerMethodArgumentResolver> argumentResolvers = handlerAdapter.getArgumentResolvers();
        for (HandlerMethodArgumentResolver argumentResolver : argumentResolvers) {
            System.out.println(argumentResolver);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>所有返回值解析器");
        List<HandlerMethodReturnValueHandler> returnValueHandlers = handlerAdapter.getReturnValueHandlers();
        for (HandlerMethodReturnValueHandler returnValueHandler : returnValueHandlers) {
            System.out.println(returnValueHandler);
        }
    }
}
