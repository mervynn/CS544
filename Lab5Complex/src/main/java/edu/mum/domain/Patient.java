package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SecondaryTable(name = "Address", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")})
public class Patient {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(table = "Address", name = "STREET")
    private String street;
    @Column(table = "Address", name = "ZIP")
    private String zip;
    @Column(table = "Address", name = "CITY")
    private String city;

}
