package org.xgl.base1.designpattern.structure.facade;

public class BaoXianCompany {
    private CheBaoXian cheBaoXian = new CheBaoXian();
    private RenshouBaoXian renshouBaoXian = new RenshouBaoXian();
    private YangLaoBaoXian yangLaoBaoXian = new YangLaoBaoXian();

    public void buyBaoXian() {
        cheBaoXian.cheBaoXian();
        renshouBaoXian.renshouBaoXian();
        yangLaoBaoXian.yangLaoBaoXian();
    }
}
