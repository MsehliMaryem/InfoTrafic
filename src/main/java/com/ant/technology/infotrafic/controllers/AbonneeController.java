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
import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.services.AbonneService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/abonnee")
public class AbonneeController {
	@Autowired
	private AbonneService abonneService;
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@GetMapping
	public List<Abonnee> findAll() {

		return abonneService.findAll();
	}

	

	@PreAuthorize("hasRole('ROLE_Abonnee')")
	@PutMapping
	public StringResponse update(@RequestBody Abonnee abonne) {

		return abonneService.update(abonne);
	}

}
