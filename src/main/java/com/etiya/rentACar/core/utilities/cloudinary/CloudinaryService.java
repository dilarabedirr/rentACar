package com.etiya.rentACar.core.utilities.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.etiya.rentACar.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<Map<String, String>> upload(MultipartFile multipartFile);
}
