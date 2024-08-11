package org.xgl.base1.temp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program temp
 * @description 学生类
 * @auther Mr.Xiong
 * @create 2021-04-15 21:05:57
 */
public class Student {
    private String name;

    private String addr;

    private String sex;

    private Integer age;

    public Student(String name, String addr, String sex, Integer age) {
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student stu1 = new Student("李四", "beijing", "男", 200);
        Student stu2 = new Student("张三", "henan", "男", 400);
        Student stu3 = new Student("王五", "tianjin", "女", 10);
        Student stu4 = new Student("王五", "tianjin", "女", 700);
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        studentList.add(stu4);

        studentList.sort((o1,o2) -> {
            try {
                String key1 = getGetMethod(Student.class, "age").invoke(o1).toString();
                String key2 = getGetMethod(Student.class, "age").invoke(o2).toString();
                return key1.compareTo(key2);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return -1;
        });
        studentList.forEach(n -> {
            System.out.println("age--" + n.getAge());
        });
    }

    private static Method getGetMethod(Class objectClass, String fieldName) {
        StringBuffer sb = new StringBuffer();
        sb.append("get");
        sb.append(fieldName.substring(0, 1).toUpperCase());
        sb.append(fieldName.substring(1));
        try {
            return objectClass.getMethod(sb.toString());
        } catch (Exception e) {
        }
        return null;
    }
}
