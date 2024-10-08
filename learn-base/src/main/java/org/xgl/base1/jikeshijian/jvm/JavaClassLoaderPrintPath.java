package org.xgl.base1.jikeshijian.jvm;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * @program jikeshijian.jvm
 * @description 打印java启动 类加载器加载的文件路径
 * @auther Mr.Xiong
 * @create 2021-01-10 14:02
 */
public class JavaClassLoaderPrintPath {

    public static void main(String[] args) {
        //启动类加载器
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL url : urls) {
            System.out.println("---->" + url.toExternalForm());
        }

        //扩展类加载器
        printClassLoader("扩展类加载器", JavaClassLoaderPrintPath.class.getClassLoader());

        //应用类加载器
        printClassLoader("应用类加载器", JavaClassLoaderPrintPath.class.getClassLoader());

    }

    private static void printClassLoader(String name, ClassLoader cl) {
        if (null != cl) {
            System.out.println(name + "---ClassLoader---->" + cl.toString());
            printURLForClassLoader(cl);
        } else {
            System.out.println(name + "---ClassLoader---> null");
        }
    }

    private static  void printURLForClassLoader(ClassLoader cl) {
        Object ucp = insightField(cl, "ucp");
        Object path = insightField(ucp, "path");
        ArrayList ps = (ArrayList) path;
        for (Object p : ps) {
            System.out.println("---->" + p.toString());
        }
    }

    private static Object insightField(Object obj, String fName) {
        try {
            Field f;
            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
