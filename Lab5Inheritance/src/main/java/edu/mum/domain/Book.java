package edu.mum.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Data
public class Book extends Product {
    private String title;

    public Book(String name, String description, String title) {
        super(null, name, description);
        this.title = title;
    }
}
