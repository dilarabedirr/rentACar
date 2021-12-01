package com.etiya.rentACar.business.requests.rentalRequests;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

	@NotNull
	private int id;

	@NotNull
	private int carId;

	@NotNull
	private int individualCustomerId;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private String rentDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private String returnDate;
}
