package org.xgl.base1.designpattern.createpattern.builder;

public class BuilderCreater implements Builder {

    private House house;

    public BuilderCreater() {
        this.house = new House();
    }

    @Override
    public BuilderCreater buildDiJi() {
        System.out.println("构建地基");
        house.setDiJi("地基");
        return this;
    }

    @Override
    public BuilderCreater buildQiang() {
        System.out.println("构建墙");
        house.setQiang("墙");
        return this;
    }

    @Override
    public BuilderCreater buildWuding() {
        System.out.println("构建屋顶");
        house.setWuding("屋顶");
        return this;
    }

    @Override
    public BuilderCreater buildFenShua() {
        System.out.println("粉刷全屋");
        house.setFenshua("粉刷");
        return this;
    }

    public House getHouse() {
        return this.house;
    }
}
