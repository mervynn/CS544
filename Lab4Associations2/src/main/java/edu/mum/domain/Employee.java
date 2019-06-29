package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Office office;
    public String toString(){
        // cyclically calling cases StackOverFlowError
//        return String.format("id=%s, name=%s, department=%s, office=%s", id, name, department, office);
        return String.format("id=%s, name=%s", id, name);
    }
}
