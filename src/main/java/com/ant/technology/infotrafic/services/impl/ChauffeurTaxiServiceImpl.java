package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.dto.StringResponseAbonnee;
import com.ant.technology.infotrafic.entities.ChauffeurTaxi;
import com.ant.technology.infotrafic.repositories.ChauffeurRepository;
import com.ant.technology.infotrafic.services.ChauffeurTaxiService;
import com.ant.technology.infotrafic.utils.CodeGenerator;

@Service
public class ChauffeurTaxiServiceImpl implements ChauffeurTaxiService {
	@Autowired
	private ChauffeurRepository chauffeurRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public StringResponse save(ChauffeurTaxi chauffeurTaxi) {
		List<ChauffeurTaxi> list = chauffeurRepository.findByLogin(chauffeurTaxi.getEmail());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom d'utilisateur déja existe");
		}

		list = chauffeurRepository.findByEmail(chauffeurTaxi.getEmail());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Email déja existe");
		}
		String code = CodeGenerator.generatedCode();
		chauffeurTaxi.setCode(code);

		String pwd = bCryptPasswordEncoder.encode(chauffeurTaxi.getPassword());
		chauffeurTaxi.setPassword(pwd);

		chauffeurRepository.save(chauffeurTaxi);

		return new StringResponseAbonnee(true, "Opération effectuée avec succès", chauffeurTaxi.getCode(),
				chauffeurTaxi.getEmail());

	}

	@Override
	public StringResponse update(ChauffeurTaxi chauffeurTaxi) {
		List<ChauffeurTaxi> list = chauffeurRepository.findByLoginAndId(chauffeurTaxi.getLogin(),
				chauffeurTaxi.getId());
		if (list.isEmpty()) {
			list = chauffeurRepository.findByLogin(chauffeurTaxi.getLogin());
			if (!list.isEmpty()) {
				return new StringResponse(false, "Nom d'utilisateur déja existe");
			}
		}

		list = chauffeurRepository.findByEmailAndId(chauffeurTaxi.getLogin(), chauffeurTaxi.getId());
		if (list.isEmpty()) {
			list = chauffeurRepository.findByEmail(chauffeurTaxi.getEmail());
			if (!list.isEmpty()) {
				return new StringResponse(false, "Email déja existe");
			}
		}

		ChauffeurTaxi chauffeurTaxi1 = chauffeurRepository.findOne(chauffeurTaxi.getId());
		if (chauffeurTaxi.equals(chauffeurTaxi1)) {
			return new StringResponse(false, "Aucune modification detectée");
		}

		chauffeurRepository.save(chauffeurTaxi);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<ChauffeurTaxi> findAll() {
		return chauffeurRepository.findAll();
	}

	@Override
	public StringResponse activer(long id, String code) {
		ChauffeurTaxi chauffeurTaxi = chauffeurRepository.findOne(id);
		if (code.equals(chauffeurTaxi.getCode())) {
			chauffeurTaxi.setEnabled(true);
			chauffeurRepository.save(chauffeurTaxi);
			return new StringResponse(true, "Opération effectuée avec succès");
		}
		return new StringResponse(false, "Code invalid");
	}

	@Override
	public StringResponse desactiver(long code) {
		ChauffeurTaxi chauffeurTaxi = chauffeurRepository.findOne(code);
		chauffeurTaxi.setEnabled(false);
		chauffeurRepository.save(chauffeurTaxi);
		return new StringResponse(true, "Opération effectuée avec succès");
	}

}
