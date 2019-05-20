package com.ant.technology.infotrafic.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ant.technology.infotrafic.services.UploadService;

@RestController
@RequestMapping("/upload")
public class UplaodController {

	@Autowired
	private UploadService uploadService;
	
	@PostMapping("/upload")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			uploadService.store(file);
		
 
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	@RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_GIF_VALUE)
	public ResponseEntity<InputStreamResource> getImage(@RequestParam("fileName") String filename) throws IOException {

		Resource resource = uploadService.loadFile(filename);
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF)
				.body(new InputStreamResource(resource.getInputStream()));
	}

}
