package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
