package com.real.springfmk.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.real.springfmk.entitys.ArchiveEntity;
import com.real.springfmk.repositories.ArchiveRepository;
import com.real.springfmk.services.ArchiveService;

@RestController
@RequestMapping("/api/archives")
public class ArchiveController {

	@Autowired
	private ArchiveService archiveService;
	
	@Autowired
	private ArchiveRepository archiveRepository;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadArchive(@RequestParam("file") MultipartFile file) {
	    try {
	        String fileName = file.getOriginalFilename();

	        // Verifica se já existe no banco um arquivo com o mesmo nome
	        boolean exists = archiveRepository.existsByArchiveName(fileName);
	        if (exists) {
	            return ResponseEntity
	                    .status(409) // 409 Conflict
	                    .body("Já existe um arquivo com esse nome.");
	        }

	        // Salva o arquivo normalmente
	        String savedFileName =archiveService.saveArchive(file);
	        return ResponseEntity.ok("Arquivo salvo: " + savedFileName);

	    } catch (IOException e) {
	        return ResponseEntity
	                .status(500)
	                .body("Erro ao salvar arquivo: " + e.getMessage());
	    }
	}
	@GetMapping("/download/{archiveName}")
	public ResponseEntity<Resource> downloadArchive(@PathVariable String archiveName){
		try {
			ArchiveEntity archiveEntity = archiveRepository.findByArchiveName(archiveName)
					.orElseThrow(() -> new IOException("caio<- Arquivo não encontrado"));
			Resource resource = archiveService.collectFileResource(archiveName);
			String archiveType = archiveEntity.getArchiveType();
			
			String getDisposition = archiveType.startsWith("image/") || archiveType.equals("application/pdf")
					? "inline":"attachment";
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, getDisposition + "; filename=\"" + archiveName +"\"")
					.contentType(MediaType.parseMediaType(archiveType)).body(resource);
		}
		catch(IOException e) {
			return ResponseEntity.status(404).body(null);
		}
	}
	
	@GetMapping("/list")
	public List<Map<String, String>> listOnlyImages() {
	    return archiveService.listDownloadableFiles();
	}
}
