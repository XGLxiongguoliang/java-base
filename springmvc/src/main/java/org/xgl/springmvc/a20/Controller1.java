package org.xgl.springmvc.a20;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.Yaml;

import java.io.Serializable;

@RestController
public class Controller1 {
    @GetMapping("/test1")
    public ModelAndView test1() {
        System.out.println("test1~~~~~~~~~~~~~~");
        return null;
    }

    @PostMapping("/test2")
    public ModelAndView test2(@RequestParam String param1) {
        System.out.println("test2~~~~~~~~~~~~~~" + param1);
        return null;
    }

    @PutMapping("/test3")
    public ModelAndView test3(@Token String token) {
        System.out.println("test3~~~~~~~~~~~~~~" + token);
        return null;
    }

    @GetMapping("/test4")
    @Yml
    public User test4() {
        System.out.println("test4~~~~~~~~~~~~~~");
        // todo 一直有转换异常未能查询到原因。。。。
        return new User("熊熊", 30);
    }

    public static class User implements Serializable {
        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        String str = new Yaml().dump(new User("熊熊", 30));
        System.out.println(str);
    }
}
