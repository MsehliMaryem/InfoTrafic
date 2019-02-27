package com.ant.technology.infotrafic.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.repositories.TypeStationRepository;
import com.ant.technology.infotrafic.services.TypeStationService;


@Service
public class TypeStationServiceImpl implements TypeStationService {
	private final Path rootLocation = Paths.get("upload");
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

		List<TypeStation> list = typeStationRepository.findStationAffecter(code);
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
	@Override
	public void store(MultipartFile file) {
		try {
			
		//	Files.createDirectory(rootLocation);
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
