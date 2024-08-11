package org.xgl.base1.fengzhuang;

/**
 * @program fengzhuang
 * @description 程序员
 * @auther Mr.Xiong
 * @create 2019-12-23 22:55
 */
public class Developer extends People{
    private String computerLanguage;

    private String workCity;

    private Float salary;

    public Developer() {
    }

    public String getComputerLanguage() {
        return computerLanguage;
    }

    public void setComputerLanguage(String computerLanguage) {
        this.computerLanguage = computerLanguage;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public void work() {
        System.out.println("我的工作是写代码");
    }
}
