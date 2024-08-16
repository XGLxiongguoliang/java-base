package org.xgl.spring.a14;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class A14 {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        Target target = new Target();
        proxy.setMethodInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                //return method.invoke(target, args); //反射调用
                //return methodProxy.invoke(target, args); //内部无反射，结合目标用
                return methodProxy.invokeSuper(o, args); //内部无反射，结合代理使用
            }
        });
        proxy.save();
        proxy.save(3);
        proxy.save(100l);
    }
}
