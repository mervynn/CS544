package edu.mum;

import javax.persistence.*;

@Entity
public class Laptop {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public void setEmployee(Employee e) {
        this.employee = e;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

//    @Override
//    public String toString() {
//        Long emp_id = null;
//        if(this.getEmployee() != null)
//            emp_id = this.getEmployee().getId();
//        return "id: " + this.getId() + ", employee_id: " + emp_id;
//    }

//    @Override
//    public int hashCode(){
//        return 0;
//    }
//
//    @Override
//    public boolean equals(Object o){
//        return true;
//    }
}
