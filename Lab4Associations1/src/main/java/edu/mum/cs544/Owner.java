package edu.mum.cs544;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
}
