package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.StringResponse;

import com.ant.technology.infotrafic.entities.TypeAlerte;

import com.ant.technology.infotrafic.repositories.TypeAlerteRepository;

import com.ant.technology.infotrafic.services.TypeAlerteService;

@Service
public class TypeAlerteServiceImpl implements TypeAlerteService{
	@Autowired
	private TypeAlerteRepository typeAlerteRepository ;

	@Override
	public StringResponse save(TypeAlerte typeAlerte) {
		List<TypeAlerte> list = typeAlerteRepository.findByNom(typeAlerte.getNom());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom type alerte déja existe");
		}

		typeAlerteRepository.save(typeAlerte);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(TypeAlerte typeAlerte) {
		List<TypeAlerte> list = typeAlerteRepository.findByNomAndIdType(typeAlerte.getNom(),
				typeAlerte.getIdType());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Aucune modification detecté");
		}

		list = typeAlerteRepository.findByNom(typeAlerte.getNom());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom type alerte déja existe");
		}

		typeAlerteRepository.save(typeAlerte);
		

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(long code) {
	List<TypeAlerte> list = typeAlerteRepository.findAlerteAffecter(code);
		if (!list.isEmpty()) {
			return new StringResponse(false, "Type alerte associé a un ou plusieur alerte");
		}

		typeAlerteRepository.delete(code);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<TypeAlerte> findAll() {
		// TODO Auto-generated method stub
		return typeAlerteRepository.findAll();
	}

}
