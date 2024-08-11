package org.xgl.base1.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @program fanxing
 * @description 测试
 * @auther Mr.Xiong
 * @create 2021-04-29 21:33:02
 */
public class Test {

    public void fanxing() {
        List<Chushi> chushiList = new ArrayList<>();
        chushiList.add(new Chushi("大厨房", "勺子"));
        chushiList.add(new Chushi("中厨房", "菜刀"));
        chushiList.add(new Chushi("小厨房", "电饭锅"));

        List<YunDongYuan> yunDongYuanList = new ArrayList<>();
        yunDongYuanList.add(new YunDongYuan("100m", "快"));
        yunDongYuanList.add(new YunDongYuan("10m", "慢"));

        List<ChengXuYuan> chengXuYuanList = new ArrayList<>();
        chengXuYuanList.add(new ChengXuYuan("c", "操作系统项目"));
        chengXuYuanList.add(new ChengXuYuan("java", "银行项目"));

        int a = 12;
        List<? extends Parent> list = new ArrayList<>();
        if (a == 10) {
            list = chushiList;
        }
        if (a > 10) {
            list = yunDongYuanList;
        }
        if (a < 10) {
            list = chengXuYuanList;
        }

        List<? extends Parent> resultList = getResult(list, a);
    }

    List<Parent> getResult(List<? extends Parent> list, int a) {
        List<Parent> resultList = new ArrayList<>();
        return resultList;
    }
}
