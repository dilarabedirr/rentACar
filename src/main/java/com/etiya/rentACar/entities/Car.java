package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "modelYear")
	private int modelYear;

	@Column(name = "dailyPrice")
	private double dailyPrice;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "brandId")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "colorId")
	private Color color;
	
	@OneToMany(mappedBy="car")
	private List<CarImage> carImages;

//	@OneToMany(mappedBy = "car")
//	private List<Rental> rental;
//	
//	@OneToMany(mappedBy="car")
//	private List<CarImage> carImages;
}
