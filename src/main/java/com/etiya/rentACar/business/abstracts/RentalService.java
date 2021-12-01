package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.dtos.RentalSearchListDto;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface RentalService {
	DataResult<List<RentalSearchListDto>> getAll();

	Result add(CreateRentalRequest createRentalRequest);

	Result delete(DeleteRentalRequest deleteRentalRequest);

	Result update(UpdateRentalRequest updateRentalRequest);
}
