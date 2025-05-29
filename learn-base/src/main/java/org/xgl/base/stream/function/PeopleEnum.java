package org.xgl.base.stream.function;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public enum PeopleEnum {
    BABY(1,  "Baby", Baby::doWork),
    STUDENT(2, "Student", Student::doWork),
    TEACHER(3, "Teacher", Teacher::doWork),
    MANAGER(4, "Manager", Manager::doWork),
    ;

    private final Integer type;
    private final String name;
    private final Runnable doWork;

    PeopleEnum(Integer type, String name, Runnable doWork) {
        this.type = type;
        this.name = name;
        this.doWork = doWork;
    }

    public static void main(String[] args) {
        Arrays.stream(PeopleEnum.values()).forEach(peopleEnum -> {
            peopleEnum.doWork.run();
        });
    }
}
