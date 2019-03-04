package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.dto.StringResponseAbonnee;
import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.repositories.AbonneRepository;
import com.ant.technology.infotrafic.services.AbonneService;
import com.ant.technology.infotrafic.utils.CodeGenerator;

@Service
public class AbonneServiceImpl implements AbonneService {
	@Autowired
	private AbonneRepository abonneRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public StringResponse save(Abonnee abonnee) {
		// TODO Auto-generated method stub
		List<Abonnee> list = abonneRepository.findByLogin(abonnee.getLogin());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom d'utilisateur déja existe");
		}

		list = abonneRepository.findByEmail(abonnee.getEmail());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Email déja existe");
		}
		String code = CodeGenerator.generatedCode();
		abonnee.setCode(code);
		
		String pwd = bCryptPasswordEncoder.encode(abonnee.getPassword());
		abonnee.setPassword(pwd);
		
		
		abonneRepository.save(abonnee);

		return new StringResponseAbonnee(true, "Opération effectuée avec succès", abonnee.getCode(),
				abonnee.getEmail());
	}

	@Override
	public StringResponse update(Abonnee abonnee) {

		List<Abonnee> list = abonneRepository.findByLoginAndId(abonnee.getLogin(), abonnee.getId());
		if (list.isEmpty()) {
			list = abonneRepository.findByLogin(abonnee.getLogin());
			if (!list.isEmpty()) {
				return new StringResponse(false, "Nom d'utilisateur déja existe");
			}
		}

		list = abonneRepository.findByEmailAndId(abonnee.getEmail(), abonnee.getId());
		if (list.isEmpty()) {
			list = abonneRepository.findByEmail(abonnee.getEmail());
			if (!list.isEmpty()) {
				return new StringResponse(false, "Email déja existe");
			}
		}

		Abonnee abonnee1 = abonneRepository.findOne(abonnee.getId());
		if (abonnee.equals(abonnee1)) {
			return new StringResponse(false, "Aucune modification detectée");
		}

		abonneRepository.save(abonnee);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse activer(long id, String code) {

		Abonnee abonnee = abonneRepository.findOne(id);
		if (code.equals(abonnee.getCode())) {
			abonnee.setEnabled(true);
			abonneRepository.save(abonnee);
			return new StringResponse(true, "Opération effectuée avec succès");
		}
		return new StringResponse(false, "Code invalid");
	}

	@Override
	public StringResponse desactiver(long id) {

		Abonnee abonnee = abonneRepository.findOne(id);

		abonnee.setEnabled(false);

		abonneRepository.save(abonnee);
		return new StringResponse(true, "Opération effectuée avec succès");

	}

	@Override
	public List<Abonnee> findAll() {

		return abonneRepository.findAll();
	}

}
