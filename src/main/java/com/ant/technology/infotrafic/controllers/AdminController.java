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
import com.ant.technology.infotrafic.entities.Admin;

import com.ant.technology.infotrafic.services.AdminService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@GetMapping
	public List<Admin> findAll() {

		return adminService.findAll();
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin')")
	@PostMapping
	public StringResponse save(@RequestBody Admin admin) {

		return adminService.save(admin);
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin')")
	@PutMapping
	public StringResponse update(@RequestBody Admin admin) {

		return adminService.update(admin);
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin')")
	@DeleteMapping(value = "/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return adminService.delete(code);
	}

}
