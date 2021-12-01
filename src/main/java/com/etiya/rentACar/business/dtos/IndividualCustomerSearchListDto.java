package com.etiya.rentACar.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCustomerSearchListDto {
	private int individualId;
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String birthday;
}
