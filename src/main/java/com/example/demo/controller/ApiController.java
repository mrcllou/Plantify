package com.example.demo.controller;

import com.example.demo.logic.MainLogic;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController
{
	MainLogic logic = new MainLogic();

	@GetMapping("/api/run")
	public String run(@RequestParam String input)
	{
		return logic.runLogic(input);
	}

	@GetMapping("/api/mathA")
	public int mathA(@RequestParam int value)
	{
		return logic.mathA(value);
	}
}
