package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "individualcustomers")
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
public class IndividualCustomer extends User {
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birthday")
	private String birthday;

	@OneToMany(mappedBy = "individualCustomer")
	private List<Rental> rentals;
}
//jpaignoreproperties{"hibernateLazyInitializer","handler","products"}