package org.xgl.base1.stream;

import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program stream
 * @description java8 stream练习
 * @auther Mr.Xiong
 * @create 2023-10-08 15:56:16
 */
public class StreamLearn {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User(10, "张三", "北京", "北京大学");
        User user2 = new User(10, "李四", "上海", "上海交通大学");
        User user3 = new User(20, "王五", "广州", "北京大学");
        User user4 = new User(10, "张飞", "北京", "北京理工大学");
        User user5 = new User(20, "关羽", "上海", "上海交通大学");
        User user6 = new User(20, "刘备", "北京", "北京大学");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);

        //peek学习
        List<User> peekList = userList.stream().peek(user -> user.setAge(100)).collect(Collectors.toList());
        List<User> peekList2 = userList.stream().peek(user -> user.setAge(110)).collect(Collectors.toList());
        List<User> mapList = userList.stream().peek(user -> user.setAge(100)).collect(Collectors.toList());

        //flatmap
        List<User> list1 = new ArrayList<>();
        list1.add(user1);
        list1.add(user2);

        List<BigDecimal> bigDecimalList = new ArrayList<>();
        bigDecimalList.add(new BigDecimal(100.2));
        bigDecimalList.add(new BigDecimal(100.8));
        bigDecimalList.forEach(a -> {
            user1.setMoney(user1.getMoney().add(a));
        });

        List<User> list2 = new ArrayList<>();
        list2.add(user1);
        list2.add(user3);
        list2.add(user4);
        List<List<User>> listALL = new ArrayList<>();
        listALL.add(list1);
        listALL.add(list2);
        List<User> tempList = listALL.stream().flatMap(a -> a.stream()).collect(Collectors.toList());
        System.out.println("tempList = " + JSONArray.toJSONString(tempList));

        List<User> distinctList = listALL.stream().flatMap(a -> a.stream()).distinct().collect(Collectors.toList());
        System.out.println("distinctList = " + JSONArray.toJSONString(distinctList));


        //list转set
        Set<User> userSet = userList.stream().collect(Collectors.toSet());
        Set<String> userName = userList.stream().map(User::getName).collect(Collectors.toSet());

        //list转map
        Map<Integer, User> userMap = userList.stream().collect(Collectors.toMap(User::getAge, Function.identity(), (v1, v2) -> v1));

        //list通过某个字段值过滤
        List<User> filterUserList = userList.stream().filter(item -> item.getAge() > 15).collect(Collectors.toList());

        //list分组
        Map<Integer, List<User>> groupUser = userList.stream().collect(Collectors.groupingBy(User::getAge));

        //双层嵌套分组
        Map<Integer, Map<String, List<User>>> groupUser2 = userList.stream().collect(
          Collectors.groupingBy(
                  User::getAge,
                  Collectors.groupingBy(
                          User::getSchool
                  )
          )
        );

        //list排序
        List<User> sortUserList = userList.stream().sorted(Comparator.comparing(User::getAge).thenComparing(User::getName, Comparator.reverseOrder())).collect(Collectors.toList());

        //统计北京大学的学生数量
        Long beiJingStudentNum = userList.stream().filter(e -> "北京大学".equals(e.getSchool())).count();
        System.out.println("北京大学学生数量---" + beiJingStudentNum);

        //写一个没有无限增长的整数流，不断打印偶数
        //Stream.iterate(0, n -> n + 1).filter(e -> e%2 == 0).forEach(System.out::println);

        System.out.println("------");
    }
}
