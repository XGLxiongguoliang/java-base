package org.xgl.spring.a16;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class A16 {
    public static void main(String[] args) throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* bar())");
        System.out.println(pointcut.matches(T1.class.getMethod("foo"), T1.class));
        System.out.println(pointcut.matches(T1.class.getMethod("bar"), T1.class));;

        AspectJExpressionPointcut pointcut2 = new AspectJExpressionPointcut();
        pointcut2.setExpression("@annotation(org.springframework.transaction.annotation.Transactional)");
        System.out.println(pointcut2.matches(T1.class.getMethod("foo"), T1.class));
        System.out.println(pointcut2.matches(T1.class.getMethod("bar"), T1.class));

        StaticMethodMatcherPointcut pointcut3 = new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> aClass) {
                MergedAnnotations annotations = MergedAnnotations.from(method);
                //判断接口上是否添加注解
                if (annotations.isPresent(Transactional.class)) {
                    return true;
                }

                //判断类上是否添加注解
                annotations = MergedAnnotations.from(aClass, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);
                if (annotations.isPresent(Transactional.class)) {
                    return true;
                }

                return false;
            }
        };

        System.out.println(pointcut3.matches(T1.class.getMethod("foo"), T1.class));
        System.out.println(pointcut3.matches(T1.class.getMethod("bar"), T1.class));
        System.out.println(pointcut3.matches(T2.class.getMethod("foo"), T2.class));
        System.out.println(pointcut3.matches(T3.class.getMethod("foo"), T3.class));
    }

    static class T1 {
        @Transactional
        public void foo() {

        }

        public void bar() {

        }
    }

    @Transactional
    static class T2 {

        public void foo() {

        }
    }

    @Transactional
    interface I3 {

        void foo();
    }

    static class T3 implements I3 {

        @Override
        public void foo() {

        }
    }
}
