package com.ant.technology.infotrafic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.PasswordDTO;
import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Personne;
import com.ant.technology.infotrafic.services.PersonneService;

@RestController
@RequestMapping("/personne")
public class PersonneController {
	@Autowired
	private PersonneService personneService;

	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@PutMapping
	public StringResponse activate(@RequestBody Personne pers) {
		return personneService.activate(pers);
	}

	@PutMapping("/pwd")
	public StringResponse changePassword(@RequestBody PasswordDTO pwdDto) {
		return personneService.changePassword(pwdDto);
	}

	@GetMapping
	public StringResponse checkPassword(@RequestParam("id") int id,@RequestParam("pwd") String pwd) {
		 PasswordDTO pwdDto = new PasswordDTO();
		 pwdDto.setId(id);
		 pwdDto.setOldPassword(pwd);
		return personneService.changePassword(pwdDto);
	}
}
