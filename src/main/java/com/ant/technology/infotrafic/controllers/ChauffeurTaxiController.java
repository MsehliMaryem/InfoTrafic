package com.ant.technology.infotrafic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.ChauffeurTaxi;
import com.ant.technology.infotrafic.services.ChauffeurTaxiService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/chauffeurtaxi")
public class ChauffeurTaxiController {
	@Autowired
	private ChauffeurTaxiService chauffeurtaxiService ;
	@GetMapping(value = "/list")
	public List<ChauffeurTaxi> findAll() {

		return chauffeurtaxiService.findAll();
	}
	@PostMapping(value = "/add")
	public StringResponse save(@RequestBody ChauffeurTaxi chauffeurtaxi) {

		return chauffeurtaxiService.save(chauffeurtaxi);
	}

	@PutMapping(value = "/update")
	public StringResponse update(@RequestBody ChauffeurTaxi chauffeurtaxi) {

		return chauffeurtaxiService.save(chauffeurtaxi);
	}
	
	
	
	
	
	
	
	
	
	
	
}
