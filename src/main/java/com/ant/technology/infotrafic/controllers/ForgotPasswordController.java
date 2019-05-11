package com.ant.technology.infotrafic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.PasswordDTO;
import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.services.PersonneService;

@RestController
@RequestMapping(value = "/reset")
public class ForgotPasswordController {
	@Autowired
	private PersonneService personneService;

	@GetMapping 
	public StringResponse ForgotPassword(@RequestParam("email") String email) {

		return personneService.ForgotPassword(email);
	}

	@PutMapping
	public StringResponse changePasword(@RequestBody PasswordDTO passwordDTO) {

		return personneService.changeForgotPassword(passwordDTO);
	}
	
	@GetMapping("/checkCode") 
	public StringResponse checkCode(@RequestParam("email") String email,@RequestParam("code") String code) {

		return personneService.checkCode(email, code);
	}
}
