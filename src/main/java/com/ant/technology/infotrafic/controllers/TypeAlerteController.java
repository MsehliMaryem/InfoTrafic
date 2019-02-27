package com.ant.technology.infotrafic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.TypeAlerte;

import com.ant.technology.infotrafic.services.TypeAlerteService;

@RestController
@RequestMapping(value = "/c")
public class TypeAlerteController {
	@Autowired
	private TypeAlerteService typeAlerteService ;
	@GetMapping
	public List<TypeAlerte> findAll() {

		return typeAlerteService.findAll();
	}

	@PostMapping
	public StringResponse save(@RequestBody TypeAlerte typeAlerte) {

		return typeAlerteService.save(typeAlerte);
	}

	@PutMapping
	public StringResponse update(@RequestBody TypeAlerte typeAlerte) {

		return typeAlerteService.update(typeAlerte);
	}

	@DeleteMapping(value = "/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return typeAlerteService.delete(code);
	}

}
