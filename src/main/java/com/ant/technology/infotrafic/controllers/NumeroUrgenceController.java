package com.ant.technology.infotrafic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.StringResponse;

import com.ant.technology.infotrafic.entities.NumeroUrgence;

import com.ant.technology.infotrafic.services.NumeroUrgenceService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/numerourgence")
public class NumeroUrgenceController {
	@Autowired
	private NumeroUrgenceService numeroUrgenceService ;
	
	@GetMapping
	public List<NumeroUrgence> findAll() {

		return numeroUrgenceService.findAll();
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@PostMapping
	public StringResponse save(@RequestBody NumeroUrgence numeroUrgence) {

		return numeroUrgenceService.save(numeroUrgence);
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@PutMapping
	public StringResponse update(@RequestBody NumeroUrgence numeroUrgence) {

		return numeroUrgenceService.save(numeroUrgence);
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@DeleteMapping(value = "/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return numeroUrgenceService.delete(code);
	}
}

