package edu.mum.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Data
public class DVD extends Product {
    private String genre;

    public DVD(String name, String description, String genre) {
        super(null, name, description);
        this.genre = genre;
    }
}
