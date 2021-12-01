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
import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.dtos.ColorSearchListDto;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		this.colorService = colorService;
	}

	@GetMapping("getall")
	public DataResult<List<ColorSearchListDto>> getAll() {
		return this.colorService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody CreateColorRequest createColorResquest) {
		return this.colorService.add(createColorResquest);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteColorRequest deleteColorResquest) {
		return this.colorService.delete(deleteColorResquest);
	}

	@PutMapping("update")
	public Result update(@RequestBody UpdateColorRequest updateColorResquest) {
		return this.colorService.update(updateColorResquest);
	}

}
