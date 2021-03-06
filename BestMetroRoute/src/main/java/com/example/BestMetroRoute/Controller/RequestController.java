package com.example.BestMetroRoute.Controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BestMetroRoute.services.ExcelToDataBaseService;
import com.example.BestMetroRoute.services.RouteService;

@RestController
public class RequestController {
	
	@Autowired
	RouteService service;
	
	@Autowired
	private ExcelToDataBaseService excelToDataBaseService;
	
	
	@RequestMapping("/")
	public String indexpage() {
		return "Hello to possible metro route project";
	}
	
	@RequestMapping(value = {"/{sourceLoc}/{destLoc}", "/{sourceLoc}/{destLoc}/{time}"})
	public String method(
			@PathVariable("sourceLoc") String sourceLoc,
			@PathVariable("destLoc") String destLoc,
			@PathVariable(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalTime time) {
		excelToDataBaseService.insert_data();
		if (time == null) {
			time = LocalTime.now();
		}		

		String result = service.method(sourceLoc, destLoc, time);		
		return result;
	}

}
