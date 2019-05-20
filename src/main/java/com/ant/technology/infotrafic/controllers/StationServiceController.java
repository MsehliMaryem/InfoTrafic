package com.ant.technology.infotrafic.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.StationService;
import com.ant.technology.infotrafic.services.StationServiceService;


@RestController
@RequestMapping(value = "/stationService")
public class StationServiceController {
	@Autowired
	private StationServiceService stationServiceService ;
	@GetMapping
	public List<StationService> findAll() {

		return stationServiceService.findAll();
	}
	
	@GetMapping("/findByType")
	public List<StationService> findByTypeStation(@RequestParam("ids") Long[] ids) {

		return stationServiceService.findByTypeStationCodeIn(Arrays.asList(ids));
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@PostMapping
	public StringResponse save(@RequestBody StationService stationService) {

		return stationServiceService.save(stationService);
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@PutMapping
	public StringResponse update(@RequestBody StationService stationService) {

		return stationServiceService.update(stationService);
	}
	@PreAuthorize("hasRole('ROLE_SuperAdmin') or hasRole('ROLE_Admin')")
	@DeleteMapping(value = "/{code}")
	public StringResponse delete(@PathVariable("code") long code) {

		return stationServiceService.delete(code);
	}
}
