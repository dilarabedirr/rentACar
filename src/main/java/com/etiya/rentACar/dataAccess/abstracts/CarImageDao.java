package com.etiya.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACar.entities.CarImage;

public interface CarImageDao extends JpaRepository<CarImage, Integer>{
	int countByCar_id(int carId);
}
