package com.etiya.rentACar.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "carImages")
@AllArgsConstructor
@NoArgsConstructor
public class CarImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carImageId")
	private int carImageId;
	@Column(name = "imagePath")//photourl
	private String imagePath;
	@Column(name = "carImageDate")
	private String carImageDate;
	
	@ManyToOne
	@JoinColumn(name = "CarId")
	private Car car;
}//cascade = CascadeType.DETACH
