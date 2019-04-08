package com.ant.technology.infotrafic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@GetMapping
	public List<ChauffeurTaxi> findAll() {

		return chauffeurtaxiService.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ChauffeurTaxi')")
	@PutMapping
	public StringResponse update(@RequestBody ChauffeurTaxi chauffeurtaxi) {

		return chauffeurtaxiService.save(chauffeurtaxi);
	}
	
	
	
	
	
	
	
	
	
	
	
}
