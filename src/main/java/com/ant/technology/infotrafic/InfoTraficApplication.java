package com.ant.technology.infotrafic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.ant.technology.infotrafic.repositories.TypeStationRepository;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {SecurityAutoConfiguration.class})
public class InfoTraficApplication  {
	@Autowired
	private TypeStationRepository typeStationRepository;

	public static void main(String[] args) {
		SpringApplication.run(InfoTraficApplication.class, args);
	}

	
}
