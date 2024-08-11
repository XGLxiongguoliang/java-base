package org.xgl.base1.designpattern.createpattern.prototype.deepclone;

import java.io.Serializable;

public class School implements Serializable {
    private Student student;

    public School(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "School{" +
                "student=" + student +
                '}';
    }
}
