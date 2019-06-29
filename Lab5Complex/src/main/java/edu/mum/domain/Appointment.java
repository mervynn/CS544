package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "APPDATE")
    private String appdate;
    @Embedded
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "PATIENT")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "DOCTOR")
    private Doctor doctor;
}
