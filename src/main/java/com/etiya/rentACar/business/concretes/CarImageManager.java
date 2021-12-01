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

	@Autowired
	public CarImageManager(CarImageDao carImageDao, CloudinaryService cloudinaryService) {
		super();
		this.carImageDao = carImageDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(MultipartFile multipartFile, int carId) {
		var result = this.cloudinaryService.upload(multipartFile);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		CarImage carImage = new CarImage();
		carImage.setImagePath(result.getData().get("url"));
		// carImage.setCarImageId(result.getData().get("carImage_id"));
		carImage.setCarImageDate(result.getData().get("created_at"));
		this.carImageDao.save(carImage);
		return new SuccessResult("photo added");
	}

}