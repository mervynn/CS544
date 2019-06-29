package edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Column(name = "PAYDATE")
    private String paydate;
    @Column(name = "AMOUNT")
    private double amount;
}
