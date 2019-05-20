package com.ant.technology.infotrafic.services.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ant.technology.infotrafic.services.UploadService;

@Service
public class UploadServiceImpl implements UploadService {
	private final Path rootLocation = Paths.get("upload");

	@Override
	public void store(MultipartFile file) {
		try {

			// Files.createDirectory(rootLocation);
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Resource loadFile(String fileName) {
		try {
			Path file = rootLocation.resolve(fileName);
			System.out.println(file.toAbsolutePath());
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
