package com.etiya.rentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.dtos.BrandSearchListDto;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping("getall")
	public DataResult<List<BrandSearchListDto>> getAll() {
		return this.brandService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody CreateBrandRequest createBrandResquest) {
		return this.brandService.add(createBrandResquest);
	}

	@PutMapping("update")
	public Result update(@RequestBody UpdateBrandRequest updateBrandResquest) {
		return this.brandService.update(updateBrandResquest);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteBrandRequest deleteBrandResquest) {
		return this.brandService.delete(deleteBrandResquest);
	}
}
