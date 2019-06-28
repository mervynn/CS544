package edu.mum.cs544;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String year;
	private double price;
//    @JoinTable(name = "xxxTable",
//    joinColumns = {@JoinColumn(name = "owner_id")},
//    inverseJoinColumns = {@JoinColumn(name = "car_id")})
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;

}
