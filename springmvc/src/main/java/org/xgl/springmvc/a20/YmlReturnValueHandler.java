package org.xgl.springmvc.a20;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.HttpServletResponse;

public class YmlReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        Yml yml = methodParameter.getMethodAnnotation(Yml.class);
        boolean supported = yml != null;
        System.out.println("supportsReturnType: " + supported);
        return supported;
    }

    //返回值
    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        //1、返回对象结果为yaml字符串
        String str = new Yaml().dump(o);
        //将yaml字符串写入响应
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().print(str);

        //告知springmvc请求已经处理完成
        modelAndViewContainer.setRequestHandled(true);
    }
}
