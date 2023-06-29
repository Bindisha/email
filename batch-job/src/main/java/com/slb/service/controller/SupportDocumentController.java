package com.slb.service.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v2")
public class SupportDocumentController {

	private Path foundFile;
	
	@GetMapping("/document/{fileName}")
	public ResponseEntity<ByteArrayResource> getDocumentFile(@PathVariable String fileName) throws IOException {
		
		Path uploadPath = Paths.get("D:\\SupportDocuments");
        
		try {
			Files.list(uploadPath)
			.forEach( 
					x-> {
						
						if(x.getFileName().toString().equals(fileName)){
							foundFile = x;
			                return;
					}
				
			});
		} catch (IOException e) {
			log.error(e.getMessage());
		}
        
		if (foundFile != null) {
			
			log.info("INSIDE");
			byte[] fileBytes = Files.readAllBytes(foundFile);
			ByteArrayResource resource = new ByteArrayResource(fileBytes);
			return ResponseEntity
					.ok()
					.contentLength(fileBytes.length)
					.header("Content-type", "application/octet-stream")
					.header("Content-disposition", "attachment; filename=\"" +fileName+ "\"")
					.body(resource);
        }
         
        return null;
	}
}
