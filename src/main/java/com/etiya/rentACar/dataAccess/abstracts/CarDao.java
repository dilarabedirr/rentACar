package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.complexTypes.CarDetail;

public interface CarDao extends JpaRepository<Car, Integer> {

	@Query("Select new com.etiya.rentACar.entities.complexTypes.CarDetail "
			+ "(c.id,b.brandName,cl.colorName,c.dailyPrice,c.description,c.modelYear)"
			+ "From Car c Inner Join c.color cl Inner Join c.brand b ")
	List<CarDetail> getCarWithBrandAndColorDetails();
	
	//List<Car> getByBrand_BrandName(String brandName);
	//List<Car> getByBrandId(int id);
	//List<Car> getByColorId(int id);
}
