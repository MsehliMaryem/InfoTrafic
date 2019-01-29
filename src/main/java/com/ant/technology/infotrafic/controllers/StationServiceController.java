package com.ant.technology.infotrafic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.entities.NumeroUrgence;
import com.ant.technology.infotrafic.entities.StationService;
import com.ant.technology.infotrafic.services.NumeroUrgenceService;
import com.ant.technology.infotrafic.services.StationServiceService;
import com.ant.technology.infotrafic.services.dto.StringResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/stationservice")
public class StationServiceController {
	@Autowired
	private StationServiceService stationServiceService ;
	@GetMapping(value = "/list")
	public List<StationService> findAll() {

		return stationServiceService.findAll();
	}
	@PostMapping(value = "/add")
	public StringResponse save(@RequestBody StationService stationService) {

		return stationServiceService.save(stationService);
	}

	@PutMapping(value = "/update")
	public StringResponse update(@RequestBody StationService stationService) {

		return stationServiceService.save(stationService);
	}
	@DeleteMapping(value = "/delete/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return stationServiceService.delete(code);
	}
}
