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
import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.services.AbonneService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/abonnee")
public class AbonneeController {
	@Autowired
	private AbonneService abonneService;

	@GetMapping(value = "/list")
	public List<Abonnee> findAll() {

		return abonneService.findAll();
	}

	@PostMapping(value = "/add")
	public StringResponse save(@RequestBody Abonnee abonnee) {

		return abonneService.save(abonnee);
	}

//	@DeleteMapping(value = "/deleteAbonnee/{code}")
//	public StringResponse delete(@PathVariable("code") long code) {
//
//		return abonneService.delete(code);
//	}

	@PutMapping(value = "/update")
	public StringResponse update(@RequestBody Abonnee abonne) {

		return abonneService.update(abonne);
	}

}
