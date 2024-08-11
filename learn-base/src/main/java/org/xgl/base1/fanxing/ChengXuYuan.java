package org.xgl.base1.fanxing;

/**
 * @program fanxing
 * @description 程序员
 * @auther Mr.Xiong
 * @create 2021-04-29 21:31:19
 */
public class ChengXuYuan  extends Parent {
    private String yuYan;

    private String xiangMu;

    public String getYuYan() {
        return yuYan;
    }

    public void setYuYan(String yuYan) {
        this.yuYan = yuYan;
    }

    public String getXiangMu() {
        return xiangMu;
    }

    public void setXiangMu(String xiangMu) {
        this.xiangMu = xiangMu;
    }

    public ChengXuYuan(String yuYan, String xiangMu) {
        this.yuYan = yuYan;
        this.xiangMu = xiangMu;
    }
}
