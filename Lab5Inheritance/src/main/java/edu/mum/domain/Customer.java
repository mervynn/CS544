package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<Order>();

    public void addOrder(Order order){
        this.orders.add(order);
        order.setCustomer(this);
    }

}
