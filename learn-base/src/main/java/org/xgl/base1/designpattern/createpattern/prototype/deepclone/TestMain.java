package org.xgl.base1.designpattern.createpattern.prototype.deepclone;

import java.io.*;

public class TestMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student studentA = new Student();
        School school = new School(studentA);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(school);
        oos.close();

        ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(ios);
        School school2 = (School) ois.readObject();
        school2.getStudent().setName("李四");
        school2.getStudent().setAge(17);
        ois.close();

        System.out.println("school：" + school);
        System.out.println("school2：" + school2);
    }
}
