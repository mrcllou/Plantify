package com.ui.Plantify.controller;

import com.ui.Plantify.logic.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController
{
	Data data = new Data();

	@GetMapping("/area")
	public double getArea()
	{
		return data.getArea();
	}

	@GetMapping("/calculate")
	public double costCalculation()
	{
		return data.cost();
	}

	@GetMapping("/forecast")
	public String forecast()
	{
		return data.probability();
	}
}
