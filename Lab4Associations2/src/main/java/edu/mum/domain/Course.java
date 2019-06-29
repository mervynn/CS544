package edu.mum.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "course_name")
    private String courseName;
    public Course(String name){
        this.courseName = name;
    }
    @ManyToMany
    private List<Student> students = new ArrayList<Student>();

    public void addStudent(Student s) {
        this.students.add(s);
    }

    @Override
    public String toString() {
        return String.format("id=%s, courseName=%s", id, courseName);
    }

}
