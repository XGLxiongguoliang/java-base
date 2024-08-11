package org.xgl.base1.fanxing;

/**
 * @program fanxing
 * @description 厨师
 * @auther Mr.Xiong
 * @create 2021-04-29 21:25:07
 */
public class Chushi extends Parent {
    private String chuFang;

    private String chuJu;

    public String getChuFang() {
        return chuFang;
    }

    public void setChuFang(String chuFang) {
        this.chuFang = chuFang;
    }

    public String getChuJu() {
        return chuJu;
    }

    public void setChuJu(String chuJu) {
        this.chuJu = chuJu;
    }

    public Chushi(String chuFang, String chuJu) {
        this.chuFang = chuFang;
        this.chuJu = chuJu;
    }
}
