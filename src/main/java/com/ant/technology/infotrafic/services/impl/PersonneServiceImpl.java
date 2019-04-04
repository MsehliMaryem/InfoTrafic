package com.ant.technology.infotrafic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.PasswordDTO;
import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Personne;
import com.ant.technology.infotrafic.repositories.PersonneRepository;
import com.ant.technology.infotrafic.services.PersonneService;

@Service
public class PersonneServiceImpl implements PersonneService {
	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public StringResponse activate(Personne personne) {

		personneRepository.save(personne);

		if (personne.isEnabled()) {
			return new StringResponse(true, "Compte activé avec succès");
		}

		return new StringResponse(true, "Compte desactivé avec succès");
	}

	@Override
	public StringResponse changePassword(PasswordDTO pwdDto) {

		Personne personne = personneRepository.getOne((long) pwdDto.getId());
		
		if(personne !=null) {
			
			boolean valid = passwordEncoder.matches(pwdDto.getOldPassword(), personne.getPassword());
			
			if(!valid) {
				
				return new StringResponse(false, "Mot passe actuel incorrecte");
			}
			
			String pwd = passwordEncoder.encode(pwdDto.getNewPassword());
			personne.setPassword(pwd);
			
			personneRepository.save(personne);
			
			return new StringResponse(true, "Mot passe modifié avec succès");
			
		}
		return new StringResponse(false, "Compte n'existe pas");
	}

	@Override
	public StringResponse checkPassword(PasswordDTO pwdDto) {
	Personne personne = personneRepository.getOne((long) pwdDto.getId());
		
		if(personne !=null) {
			
			boolean valid = passwordEncoder.matches(pwdDto.getOldPassword(), personne.getPassword());
			
			if(!valid) {
				
				return new StringResponse(false, "Mot passe actuel incorrecte");
			}
			
		
			
			return new StringResponse(true, "");
			
		}
		return new StringResponse(false, "Compte n'existe pas");
	}

}
