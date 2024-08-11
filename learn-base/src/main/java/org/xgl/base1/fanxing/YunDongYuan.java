package org.xgl.base1.fanxing;

/**
 * @program fanxing
 * @description 运动员
 * @auther Mr.Xiong
 * @create 2021-04-29 21:30:05
 */
public class YunDongYuan extends Parent {
    private String tiaoGao;

    private String youYong;

    public String getTiaoGao() {
        return tiaoGao;
    }

    public void setTiaoGao(String tiaoGao) {
        this.tiaoGao = tiaoGao;
    }

    public String getYouYong() {
        return youYong;
    }

    public void setYouYong(String youYong) {
        this.youYong = youYong;
    }

    public YunDongYuan(String tiaoGao, String youYong) {
        this.tiaoGao = tiaoGao;
        this.youYong = youYong;
    }
}
