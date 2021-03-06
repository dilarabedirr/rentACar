package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.dtos.ColorSearchListDto;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface ColorService {
	DataResult<List<ColorSearchListDto>> getAll();

	Result add(CreateColorRequest createColorRequest);

	Result delete(DeleteColorRequest deleteColorRequest);

	Result update(UpdateColorRequest updateColorRequest);
}
