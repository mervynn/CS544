package edu.mum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "studentId")
    private Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
}
