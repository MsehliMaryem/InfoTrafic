package com.ant.technology.infotrafic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.PasswordDTO;
import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.dto.StringResponseAdmin;
import com.ant.technology.infotrafic.entities.Personne;
import com.ant.technology.infotrafic.repositories.AbonneRepository;
import com.ant.technology.infotrafic.repositories.AdminRepository;
import com.ant.technology.infotrafic.repositories.ChauffeurRepository;
import com.ant.technology.infotrafic.repositories.PersonneRepository;
import com.ant.technology.infotrafic.services.PersonneService;
import com.ant.technology.infotrafic.utils.CodeGenerator;

@Service
public class PersonneServiceImpl implements PersonneService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ChauffeurRepository chauffeurRepository;
	@Autowired
	private AbonneRepository abonneRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private PersonneRepository personneRepository;

	@Override
	public StringResponse activate(Personne personne) {
		Personne pers = personneRepository.getOne((long) personne.getId());
		pers.setEnabled(personne.isEnabled());
		personneRepository.save(pers);

		if (pers.isEnabled()) {
			return new StringResponse(true, "Compte activé avec succès");
		}

		return new StringResponse(true, "Compte desactivé avec succès");
	}

	@Override
	public StringResponse changePassword(PasswordDTO pwdDto) {

		Personne personne = personneRepository.getOne((long) pwdDto.getId());

		if (personne != null) {

			boolean valid = passwordEncoder.matches(pwdDto.getOldPassword(), personne.getPassword());

			if (!valid) {

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

		if (personne != null) {

			boolean valid = passwordEncoder.matches(pwdDto.getOldPassword(), personne.getPassword());

			if (!valid) {

				return new StringResponse(false, "Mot passe actuel incorrecte");
			}

			return new StringResponse(true, "");

		}
		return new StringResponse(false, "Compte n'existe pas");
	}

	@Override
	public StringResponseAdmin ForgotPassword(String email) {
	
		Personne pers = personneRepository.findByEmail(email);
		if (pers == null) {
			return new StringResponseAdmin(false, "Email incorrecte");
		}
		if(!pers.isEnabled()) {
			return new StringResponseAdmin(false, "Votre compte est desactivé");
		}

		String code = CodeGenerator.generatedCode();

		pers.setCode(code);

		personneRepository.save(pers);
		return new StringResponseAdmin(true, "email envoyé", pers.getCode(), pers.getEmail());
	}

	@Override
	public StringResponse changeForgotPassword(PasswordDTO pwdDto) {

		Personne pers = personneRepository.findByEmailAndCode(pwdDto.getEmail(), pwdDto.getCode());
		if (pers == null) {
			return new StringResponse(false, "Invalid code");
		}

		String pwd = passwordEncoder.encode(pwdDto.getNewPassword());
		pers.setPassword(pwd);

		personneRepository.save(pers);

		return new StringResponse(true, "Mot passe modifié avec succès");

	}

	@Override
	public StringResponse checkCode(String email, String code) {

		Personne pers = personneRepository.findByEmailAndCode(email, code);
		if (pers == null) {
			return new StringResponse(false, "Invalid code");
		}

	

		return new StringResponse(true, "Code valid");
	}
	
	
	@Override
	public StringResponse activateAccount(Personne personne) {
		Personne pers = personneRepository.getOne((long) personne.getId());
		
		if(pers.getCode().equals(personne.getCode())) {
			pers.setActivation(true);
			personneRepository.save(pers);
			return new StringResponse(true, "Compte activé avec succès");
		}
		
		
		

	

		return new StringResponse(false, "Code invalid");
	}

}
