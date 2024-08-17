package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class A18_1 {
   static class Target {
       public void foo() {
           System.out.println("Target----foo()");
       }
   }

   static class Advice1 implements MethodInterceptor {

       @Override
       public Object invoke(MethodInvocation methodInvocation) throws Throwable {
           System.out.println("Advice1----before()");
           Object result = methodInvocation.proceed();
           System.out.println("Advice1----after()");
           return result;
       }
   }

    static class Advice2 implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            System.out.println("Advice2----before()");
            Object result = methodInvocation.proceed();
            System.out.println("Advice2----after()");
            return result;
        }
    }

    static class MyInvocation implements MethodInvocation {

       private Target target;
       private Method method;
       private Object[] args;
       List<MethodInterceptor> methodInterceptorList;
       private Integer count = 1;

        public MyInvocation(Target target, Method method, Object[] args, List<MethodInterceptor> methodInterceptorList) {
            this.target = target;
            this.method = method;
            this.args = args;
            this.methodInterceptorList = methodInterceptorList;
        }

        @Override
        public Method getMethod() {
            return method;
        }

        @Override
        public Object[] getArguments() {
            return args;
        }

        /**
         * 调用每一个环绕通知，没有环绕通知后调用目标方法
         * @return
         * @throws Throwable
         */
        @Override
        public Object proceed() throws Throwable {
            if (count > methodInterceptorList.size()) {
                //返回并结束递归操作
                return method.invoke(target, args);
            }

            //注意调用通知 count + 1
            MethodInterceptor methodInterceptor = methodInterceptorList.get(count++ - 1);
            return methodInterceptor.invoke(this);
        }

        @Override
        public Object getThis() {
            return target;
        }

        @Override
        public AccessibleObject getStaticPart() {
            return method;
        }
    }

    public static void main(String[] args) throws Throwable {
        Target target = new Target();
        List<MethodInterceptor> list = new ArrayList<>();
        list.add(new Advice1());
        list.add(new Advice2());
        MyInvocation invocation = new MyInvocation(target, Target.class.getMethod("foo"), new Object[0], list);
        invocation.proceed();
   }
}
