package com.etiya.rentACar.ws;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.dtos.CarSearchListDto;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.complexTypes.CarDetail;

@RestController
@RequestMapping("api/cars")
public class CarsController {
	private CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("getall")
	public DataResult<List<CarSearchListDto>> getAll() {
		return this.carService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateCarRequest createCarResquest) {
		return this.carService.add(createCarResquest);
	}

	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateCarRequest updateCarResquest) {
		return this.carService.update(updateCarResquest);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteCarRequest deleteCarResquest) {
		return this.carService.delete(deleteCarResquest);
	}

	@GetMapping("detailedCars")
	public DataResult<List<CarDetail>> getDetailedCars() {
		return this.carService.getCarWithBrandAndColorDetails();
	}

}

//@GetMapping("getByBrandId")
//public DataResult<List<CarSearchListDto>> getByBrandId(@RequestParam("id") int id) {
//	return this.carService.getByBrandId(id);
//}
//
//@GetMapping("getByColorId")
//public DataResult<List<CarSearchListDto>> getByColorId(@RequestParam("id") int id) {
//	return this.carService.getByColorId(id);
//}