package com.ant.technology.infotrafic.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.services.TypeStationService;


@RestController
@RequestMapping(value = "/typeStation")
public class TypeStationController {

	@Autowired
	private TypeStationService typeStationService;
	List<String> files = new ArrayList<String>();
//	@RequestMapping(value="/list" ,method=RequestMethod.GET)
	@GetMapping
	public List<TypeStation> findAll() {

		return typeStationService.findAll();
	}

	@PostMapping
	public StringResponse save(@RequestBody TypeStation typeStation) {

		return typeStationService.save(typeStation);
	}

	@PutMapping
	public StringResponse update(@RequestBody TypeStation typeStation) {

		return typeStationService.update(typeStation);
	}

	@DeleteMapping(value = "/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return typeStationService.delete(code);
	}
	
	
	@PostMapping("/upload")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			typeStationService.store(file);
			files.add(file.getOriginalFilename());
 
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
}
