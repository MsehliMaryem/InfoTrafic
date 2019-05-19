package com.ant.technology.infotrafic.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.entities.ChauffeurTaxi;
import com.ant.technology.infotrafic.entities.Personne;
import com.ant.technology.infotrafic.services.AbonneService;
import com.ant.technology.infotrafic.services.ChauffeurTaxiService;
import com.ant.technology.infotrafic.services.PersonneService;
import com.ant.technology.infotrafic.services.TypeStationService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private TypeStationService typeStationService;
	@Autowired
	private AbonneService abonneService;

	@Autowired
	private ChauffeurTaxiService chauffeurtaxiService;
	@Autowired
	private PersonneService personneService;

	@PostMapping("/chauffeur")
	public StringResponse save(@RequestBody ChauffeurTaxi chauffeurtaxi) {

		return chauffeurtaxiService.save(chauffeurtaxi);
	}

	@PostMapping("/abonnee")
	public StringResponse save(@RequestBody Abonnee abonnee) {

		return abonneService.save(abonnee);
	}
	@PostMapping("/activateAccount")
	public StringResponse activate(@RequestBody Personne personne) {

		return personneService.activateAccount(personne);
	}
	
	
	
	 @GetMapping("/files")
	  public ResponseEntity<Resource> getFile(@RequestParam("fileName") String filename) {
		
	    Resource file = typeStationService.loadFile(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
	        .body(file);
	  }
}
