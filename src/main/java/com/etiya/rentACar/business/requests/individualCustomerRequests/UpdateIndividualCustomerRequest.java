package com.etiya.rentACar.business.requests.individualCustomerRequests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequest {
	private int id;
	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;

	@NotNull
	private String email;

	@NotNull
	@Size(min = 4, max = 8)
	private String password;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private String birthday;
}
