package edu.mum.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Student {
    @Id
    private Integer id;
    @Column(name = "studnet_name")
    private String studentName;
    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<Course>();
    public Student(Integer id, String name){
        this.id = id;
        this.studentName = name;
    }
    public void addCourse(Course c) {
        this.courses.add(c);
        c.addStudent(this);
    }

    @Override
    public String toString() {
        return String.format("id=%s, studentName=%s, Courses:%s", id, studentName, courses);
    }
}
