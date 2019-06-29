package edu.mum.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Data
public class CD extends Product {
    private String artist;

    public CD(String name, String description, String artist) {
        super(null, name, description);
        this.artist = artist;
    }
}
