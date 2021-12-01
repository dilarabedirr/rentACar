package com.etiya.rentACar.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.rentACar.business.abstracts.CarImageService;
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.core.utilities.cloudinary.CloudinaryService;
import com.etiya.rentACar.core.utilities.results.ErrorResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CarImageDao;
import com.etiya.rentACar.entities.CarImage;

@Service
public class CarImageManager implements CarImageService {

	private CarImageDao carImageDao;
	private CloudinaryService cloudinaryService;
	private CarService carService;

	@Autowired
	public CarImageManager(CarImageDao carImageDao, CloudinaryService cloudinaryService,CarService carService) {
		super();
		this.carImageDao = carImageDao;
		this.cloudinaryService = cloudinaryService;
		this.carService=carService;
	}

	@Override
	public Result add(MultipartFile multipartFile, int carId) {
		var result = this.cloudinaryService.upload(multipartFile);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		var car=this.carService.getById(carId).getData();
		CarImage carImage = new CarImage();
		carImage.setImagePath(result.getData().get("url"));
		carImage.setCar(car);
		carImage.setCarImageDate(result.getData().get("created_at"));
		this.carImageDao.save(carImage);
		return new SuccessResult("car image added");
	}

}
