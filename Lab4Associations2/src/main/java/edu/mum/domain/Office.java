package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class Office {
    @Id
    @GeneratedValue
    private Long id;
    private String location;
    @OneToMany(mappedBy = "office")
    private List<Employee> employees = new ArrayList<Employee>();
    public void addEmployee(Employee e){
        this.employees.add(e);
        e.setOffice(this);
    }
}
