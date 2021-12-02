package com.etiya.rentACar.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.rentACar.business.abstracts.CarImageService;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("api/images")
public class CarImagesController {
	private CarImageService carImageService;

	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}

	@PostMapping("add")
	public Result add(@RequestBody MultipartFile carImage, @RequestParam("carId") int carId) {
		return this.carImageService.add(carImage, carId);
	}
}
