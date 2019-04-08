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

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.ChauffeurTaxi;
import com.ant.technology.infotrafic.entities.DemandeTaxi;
import com.ant.technology.infotrafic.services.DemandeTaxiService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/demandetaxi")
public class DemandeTaxiController {
	@Autowired
	private DemandeTaxiService demandetaxiService;

	@GetMapping(value = "/list")
	public List<DemandeTaxi> findAll() {

		return demandetaxiService.findAll();
	}

	@PostMapping(value = "/add")
	public StringResponse save(@RequestBody DemandeTaxi demandetaxi) {

		return demandetaxiService.save(demandetaxi);
	}

	@PutMapping(value = "/update")
	public StringResponse update(@RequestBody DemandeTaxi demandetaxi) {

		return demandetaxiService.save(demandetaxi);
	}

	@DeleteMapping(value = "/delete/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return demandetaxiService.delete(code);
	}

}
