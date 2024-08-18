package org.xgl.springmvc.a20;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class TokenArgumentResolver implements HandlerMethodArgumentResolver {
    //是否支持某个参数
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Token token = methodParameter.getParameterAnnotation(Token.class);
        return token != null;
    }

    //解析参数
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
       return nativeWebRequest.getHeader("token");
    }
}
