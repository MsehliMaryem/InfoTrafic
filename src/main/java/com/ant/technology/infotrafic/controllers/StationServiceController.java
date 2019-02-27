package com.ant.technology.infotrafic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.StationService;
import com.ant.technology.infotrafic.services.StationServiceService;


@RestController
@RequestMapping(value = "/stationService")
public class StationServiceController {
	@Autowired
	private StationServiceService stationServiceService ;
	@GetMapping
	public List<StationService> findAll() {

		return stationServiceService.findAll();
	}
	@PostMapping
	public StringResponse save(@RequestBody StationService stationService) {

		return stationServiceService.save(stationService);
	}

	@PutMapping
	public StringResponse update(@RequestBody StationService stationService) {

		return stationServiceService.update(stationService);
	}
	@DeleteMapping(value = "/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return stationServiceService.delete(code);
	}
}
