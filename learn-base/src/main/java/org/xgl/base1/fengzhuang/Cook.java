package org.xgl.base1.fengzhuang;

/**
 * @program fengzhuang
 * @description 厨师
 * @auther Mr.Xiong
 * @create 2019-12-23 23:10
 */
public class Cook extends People{
    private String cookStyle;

    public Cook() {
        work();
    }

    public String getCookStyle() {
        return cookStyle;
    }

    public void setCookStyle(String cookStyle) {
        this.cookStyle = cookStyle;
    }

    public void work() {
        System.out.println("我的工作是做饭");
    }
}
