package com.etiya.rentACar.business.requests.carImageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarImageRequest {
	private int carId;
	private String carImagePath;
	private String carImageDate;
}
