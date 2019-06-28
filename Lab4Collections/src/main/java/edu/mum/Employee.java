package edu.mum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private Set<Laptop> laptops = new HashSet<Laptop>();

    Employee() {
    }

    Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLaptop(Laptop laptop) {
        this.laptops.add(laptop);
        laptop.setEmployee(this);
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + ", name: " + this.getName()
                + ", number of laptops: " + this.getLaptops().size();
    }
}
