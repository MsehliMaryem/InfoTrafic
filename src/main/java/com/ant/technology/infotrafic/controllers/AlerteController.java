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
import com.ant.technology.infotrafic.entities.Alerte;
import com.ant.technology.infotrafic.services.AlerteService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/alerte")
public class AlerteController {
	public AlerteController(AlerteService alerteService) {
		super();
		this.alerteService = alerteService;
	}

	@Autowired
	private AlerteService alerteService;

//	@RequestMapping(value="/list" ,method=RequestMethod.GET)
	@GetMapping
	public List<Alerte> findAll() {

		return alerteService.findAll();
	}

	@PostMapping
	public StringResponse save(@RequestBody Alerte alerte) {

		return alerteService.save(alerte);
	}

	@PutMapping
	public StringResponse update(@RequestBody Alerte alerte) {

		return alerteService.update(alerte);
	}

	@DeleteMapping(value = "/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return alerteService.delete(code);
	}
}
