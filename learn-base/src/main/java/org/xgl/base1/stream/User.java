package org.xgl.base1.stream;

/**
 * @program stream
 * @description 学生类
 * @auther Mr.Xiong
 * @create 2023-10-08 15:56:54
 */
public class User {
    private Integer age;
    private String name;
    private String birthPlace;
    private String school;

    public User() {
    }

    public User(Integer age, String name, String birthPlace, String school) {
        this.age = age;
        this.name = name;
        this.birthPlace = birthPlace;
        this.school = school;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
