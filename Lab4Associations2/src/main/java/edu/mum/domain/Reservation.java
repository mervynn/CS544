package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private String note;
    @Temporal(TemporalType.TIMESTAMP)
    private Date reserved_date;
    @ManyToOne
    private Book book;
}
