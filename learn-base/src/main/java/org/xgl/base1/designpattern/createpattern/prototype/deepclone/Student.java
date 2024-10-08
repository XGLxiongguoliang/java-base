package org.xgl.base1.designpattern.createpattern.prototype.deepclone;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private Integer age;

    public Student() {
        this.name = "张三";
        this.age = 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
