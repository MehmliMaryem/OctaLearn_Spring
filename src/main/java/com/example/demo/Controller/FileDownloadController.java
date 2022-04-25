package com.example.demo.Controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.http.HttpHeaders;

import javax.annotation.Resource;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ChapitreService;
import com.example.demo.model.Chapitre;

@RestController
public class FileDownloadController {
private ChapitreService chapitreService;
/*	@GetMapping("/downloadFile/{id}")
public ResponseEntity<?> downloadFile(@PathVariable("id")Long id){
		FileDownloadUtil downloadUtil =new FileDownloadUtil();
		Resource resource =null;
		try {
	  resource =downloadUtil.getFileAsRessource(Long.toString(id));
		
		}catch(IOException e) {
return ResponseEntity.internalServerError().build();		}
		if (resource==null) {
			return new ResponseEntity<>("file not found",HttpStatus.NOT_FOUND);
		}
		String contentType="application/octet-stream";
		String headerValue ="attachement; filename=\"" +resource.getFilename()+"\"";
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,headerValue)
				.body(resource);
	}

	@GetMapping("/dowload/{id}")
	public ResponseEntity<Resource>downloadFile(@PathVariable Long id){
		Chapitre chapitre=null ;
		chapitre = chapitreService.getChapitre(id);
	return ResponseEntity.ok().contentType(MediaType.parseMediaType(chapitre.getFileName()))
			.header(HttpHeaders.CONTENT_DISPOSITION,
					"chapitre ;filename=\""+chapitre.getFileName()+"\"")
			.body(new ByteArrayResource(chapitre.getData()));
	}
	
	*/
}
