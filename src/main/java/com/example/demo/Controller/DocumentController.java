package com.example.demo.Controller;

import java.io.FileNotFoundException;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Repository.DocumentRepository;
import com.example.demo.model.Cours;
import com.example.demo.model.Document;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/document")
public class DocumentController {
	@Autowired
	private DocumentRepository repo;
	public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";
	
	@GetMapping("/listDoc")
	 public List<Document> getDocument() {
		return (List<Document>) repo.findAll();
	 }
	
	@PostMapping("/upload")
	public Document uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Path fileStorage = Paths.get(DIRECTORY,fileName).toAbsolutePath().normalize();
		Files.copy(multipartFile.getInputStream(),fileStorage, StandardCopyOption.REPLACE_EXISTING);
		Document document = new Document();
		document.setName(fileName);
		document.setContent(multipartFile.getBytes());
		document.setSize(multipartFile.getSize());
		document.setUploadTime(new Date());
		return repo.save(document);
	}
	
	@GetMapping("/download/{filename}")
	 public ResponseEntity<Resource> downloadFile(@PathVariable("filename") String filename) throws Exception {
		Path filePath =  Paths.get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
        if(!Files.exists(filePath)) {
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
		}
	
	
}
