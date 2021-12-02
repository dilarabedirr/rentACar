package com.etiya.rentACar.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.rentACar.business.abstracts.CarImageService;
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carImageRequests.CreateCarImageRequest;
import com.etiya.rentACar.core.utilities.business.BusinessRules;
import com.etiya.rentACar.core.utilities.cloudinary.CloudinaryService;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
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
	private ModelMapperService modelMapperService;

	@Autowired
	public CarImageManager(CarImageDao carImageDao, CloudinaryService cloudinaryService, CarService carService,ModelMapperService modelMapperService) {
		super();
		this.carImageDao = carImageDao;
		this.cloudinaryService = cloudinaryService;
		this.carService = carService;
		this.modelMapperService=modelMapperService;
	}

	@Override
	public Result add(MultipartFile multipartFile, int carId){
		Result businessResult = BusinessRules.run(checkCarImageCount(carId));
		if (businessResult != null) {
			return businessResult;
		}
		var result = this.cloudinaryService.upload(multipartFile);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		var car = this.carService.getById(carId).getData();
		CarImage carImage = new CarImage(); //modelMapperService.forRequest().map(createCarImageRequest,CarImage.class);
		carImage.setImagePath(result.getData().get("url"));
		carImage.setCar(car);
		carImage.setCarImageDate(result.getData().get("created_at"));
		this.carImageDao.save(carImage);
		return new SuccessResult("car image added");
	}
	
	private Result checkCarImageCount(int carId) {
		int carImageCount=this.carImageDao.countByCar_id(carId);
		if (carImageCount>=5) {
			return new ErrorResult("Bir arabanın 5'ten fazla fotoğrafı olamaz.");
		}
		return new SuccessResult();
	}
}
