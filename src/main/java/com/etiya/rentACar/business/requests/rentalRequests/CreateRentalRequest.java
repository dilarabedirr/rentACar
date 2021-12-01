package com.etiya.rentACar.business.requests.rentalRequests;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {

	@NotNull
	private int carId;

	@NotNull
	private int individualCustomerId;

	private String rentDate;

	private String returnDate;
}
