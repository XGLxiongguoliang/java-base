package org.xgl.base1.stream;

import java.util.*;

/**
 * @program stream
 * @description java8 stream练习
 * @auther Mr.Xiong
 * @create 2023-10-08 15:56:16
 */
public class OptionalLearn {

    public static void main(String[] args) {
        //Optional.of()方法中传入null，会报错
        //System.out.println(Optional.of(null));

        //Optional.empty()返回一个value是null的Optional对象
        Optional<String> optionalString = Optional.empty();

        //Optional.ofNullable()
        System.out.println("ofNullable~null---" + Optional.ofNullable(null).isPresent());
        System.out.println("ofNullable~\"\"---" + Optional.ofNullable("").isPresent());

        List<Integer> listA = Arrays.asList(1,2, 3, 4, 5);
        System.out.println("flatMap~list---" + Optional.ofNullable(listA).flatMap(e -> Optional.of(e.size() + 10)));
        System.out.println("map~list---" + Optional.ofNullable(listA).map(e -> e.size()).get());
        System.out.println("filter~list---" + Optional.ofNullable(listA).filter(e ->e.contains(1) && e.contains(8)));

        Optional.ofNullable("xxss").map(String::toUpperCase).ifPresent(s -> System.out.println("xxxxxxxxxxxx"));

        System.out.println("end---------------");
    }

}
