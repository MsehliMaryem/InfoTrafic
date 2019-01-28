package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.repositories.TypeStationRepository;
import com.ant.technology.infotrafic.services.TypeStationService;
import com.ant.technology.infotrafic.services.dto.StringResponse;

@Service
public class TypeStationServiceImpl implements TypeStationService {

	@Autowired
	private TypeStationRepository typeStationRepository;

	@Override
	public StringResponse save(TypeStation typeStatation) {

		List<TypeStation> list = typeStationRepository.findByNomType(typeStatation.getNomType());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom type station déja existe");
		}

		typeStationRepository.save(typeStatation);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(TypeStation typeStatation) {
		List<TypeStation> list = typeStationRepository.findByNomTypeAndCode(typeStatation.getNomType(),
				typeStatation.getCode());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Aucune modification detecté");
		}

		list = typeStationRepository.findByNomType(typeStatation.getNomType());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom type station déja existe");
		}

		typeStationRepository.save(typeStatation);
		

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(long code) {

		List<TypeStation> list = typeStationRepository.findByStationServicesIsNotNull();
		if (!list.isEmpty()) {
			return new StringResponse(false, "Type station service associé a un ou plusieur station");
		}

		typeStationRepository.delete(code);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<TypeStation> findAll() {
		// TODO Auto-generated method stub
		return typeStationRepository.findAll();
	}

}
