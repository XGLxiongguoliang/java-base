package org.xgl.base.stream.function;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionDemo01 {
    public static void main(String[] args) {
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> addPrefix = s ->  "Hello, " + s;
        System.out.println(toUpperCase.andThen(addPrefix).apply("xgl"));

        Consumer<String> print = System.out::println;
        print.accept("xgl");

        BiFunction<String, String, String> concat = String::concat;
        System.out.println(concat.apply("xgl", " is a good man"));

        BiConsumer<String, String> printConcat = (s1, s2) -> System.out.println(s1 + s2);
        printConcat.accept("xx1", "xx2");
    }
}
