package com.ant.technology.infotrafic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.repositories.AbonneRepository;
import com.ant.technology.infotrafic.repositories.TypeStationRepository;
import com.ant.technology.infotrafic.services.TypeStationService;

@SpringBootApplication
public class InfoTraficApplication implements CommandLineRunner {
	@Autowired
	private TypeStationRepository typeStationRepository;

	public static void main(String[] args) {
		SpringApplication.run(InfoTraficApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Abonnee abonne= new Abonnee();
//		abonne.setNom("mariem");
//		abonne.setPrenom("dorra");
//		abonne.setEmail("mourad");
	
	typeStationRepository.findByStationServicesIsNotNull();

	}

}
