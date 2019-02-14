package com.ant.technology.infotrafic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.services.AdminService;
import com.ant.technology.infotrafic.services.TypeStationService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@GetMapping(value = "/list")
	public List<Admin> findAll() {

		return adminService.findAll();
	}
	@PostMapping(value = "/add")
	public StringResponse save(@RequestBody Admin admin) {

		return adminService.save(admin);
	}
	@PutMapping(value = "/update")
	public StringResponse update(@RequestBody Admin admin) {

		return adminService.update(admin);
	}
	@DeleteMapping(value = "/delete/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return adminService.delete(code);
	}

}
