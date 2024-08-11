package org.xgl.base1.fengzhuang;

/**
 * @program fengzhuang
 * @description 人类的顶级父类
 * @auther Mr.Xiong
 * @create 2019-12-23 22:43
 */
public class People {
    private String name;

    private Integer age;

    private String sex;

    private String cardId;

    private Float height;

    private Float weight;

    public People() {
        sleep();
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void eat(String food) {
        System.out.println("吃" + food);
    }

    public void sleep() {
        System.out.println("睡觉");
    }
}
