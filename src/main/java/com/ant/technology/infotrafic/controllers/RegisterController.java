package com.ant.technology.infotrafic.controllers;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.entities.ChauffeurTaxi;
import com.ant.technology.infotrafic.services.AbonneService;
import com.ant.technology.infotrafic.services.ChauffeurTaxiService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private AbonneService abonneService;

	@Autowired
	private ChauffeurTaxiService chauffeurtaxiService;

	@PostMapping("/chauffeur")
	public StringResponse save(@RequestBody ChauffeurTaxi chauffeurtaxi) {

		return chauffeurtaxiService.save(chauffeurtaxi);
	}

	@PostMapping("/abonnee")
	public StringResponse save(@RequestBody Abonnee abonnee) {

		return abonneService.save(abonnee);
	}

}
