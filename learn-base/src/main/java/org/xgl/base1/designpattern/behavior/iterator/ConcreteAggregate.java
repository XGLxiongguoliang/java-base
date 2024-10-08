package org.xgl.base1.designpattern.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @program designpattern.behavior.iterator
 * @description 聚合具体类
 * @auther Mr.Xiong
 * @create 2022-03-05 11:41:04
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> objectList = new ArrayList<>();

    @Override
    public void add(Object object) {
        objectList.add(object);
    }

    @Override
    public void remove(Object object) {
        objectList.remove(object);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(objectList);
    }
}
