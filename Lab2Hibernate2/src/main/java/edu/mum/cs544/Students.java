package edu.mum.cs544;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity(name = "edu.mum.cs544.Students")
@Table(name = "students")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Students {

    @Id
    @Column(name = "\"id\"", nullable = false)
    private Integer id;
    @Column(name = "\"name\"", nullable = true)
    private String name;
    @Column(name = "\"email\"", nullable = true)
    private String email;
    @Column(name = "\"password\"", nullable = true)
    private String password;
}