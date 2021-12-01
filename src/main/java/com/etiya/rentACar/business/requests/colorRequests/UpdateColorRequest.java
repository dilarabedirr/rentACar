package com.etiya.rentACar.business.requests.colorRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {
	@NotNull
	@Min(1)
	private int colorId;
	@NotNull
	@Size(min = 5, max = 20)
	private String colorName;
}
