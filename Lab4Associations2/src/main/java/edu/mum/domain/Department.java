package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Department {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<Employee>();
    public void addEmployee(Employee e){
        this.employees.add(e);
        e.setDepartment(this);
    }
}
