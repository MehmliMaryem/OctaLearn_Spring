package com.example.demo.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.ChapitreRepository;
import com.example.demo.model.Chapitre;

@Service

public class ChapitreServiceImpl {
 /*   private final Path fileStorageLocation = null;
 	@Autowired
	private ChapitreRepository chapitreRepository;

	private static String uploadDirectory = "C:\\Users\\mehml\\OneDrive\\Documents\\octa";

	public List<Chapitre> getAllChapitre() {
		return chapitreRepository.findAll();
	}

	public Chapitre saveChapitre(MultipartFile file) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println(fileName);
		try {
			if (fileName.contains("..")) {
				throw new Exception("Filename contains invalid path sequence" + fileName);
			}
			Chapitre chapitre = new Chapitre(fileName, file.getContentType(), file.getBytes());
			System.out.println(file.getBytes());
			System.out.println(fileName);
			return chapitreRepository.save(chapitre);
		} catch (Exception e) {
			throw new Exception("could not save File:" + fileName);
		}

	}
	
	/*
	 public Resource getFile(String filename) {
	        try {
	            Path file = fileStorageLocation.resolve(filename).normalize();
	            Resource resource = new UrlResource(file.toUri());
	            if (resource.exists() || resource.isReadable()) {
	                return resource;
	            } else {
	                throw new RuntimeException("Could not read file: " + filename);
	            }
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("Could not retrieve file " + filename, e);
	        }
	    }
	public Chapitre getChapitre(Long id) throws Exception {
		return chapitreRepository.findById(id)
				.orElseThrow(()->new Exception("file not found with id"+id));
	}
	*/


}
