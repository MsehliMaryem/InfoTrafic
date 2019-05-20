package com.ant.technology.infotrafic.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	public void store(MultipartFile file) ;
	public Resource loadFile(String fileName);
}
