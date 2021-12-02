package com.etiya.rentACar.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import com.etiya.rentACar.core.utilities.results.Result;

public interface CarImageService {
	Result add(MultipartFile multipartFile, int carId);
}
