package com.etiya.rentACar.business.requests.brandRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
	@NotNull
	@Min(1)
	private int brandId;

	@NotNull
	@Size(min = 3, max = 50)
	private String brandName;
}
