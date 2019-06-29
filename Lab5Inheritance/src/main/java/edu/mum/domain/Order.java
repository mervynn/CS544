package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "`Order`")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Order {
    @Id
    @GeneratedValue
    private Long oderid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    public String toString() {
        return String.format("orderid=%s, date=%s, orderLines=%s", oderid, date, orderLines);
    }


}
