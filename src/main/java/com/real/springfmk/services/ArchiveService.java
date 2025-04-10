package com.real.springfmk.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.real.springfmk.entitys.ArchiveEntity;
import com.real.springfmk.repositories.ArchiveRepository;




@Service
public class ArchiveService {
	
	@Autowired
	private ArchiveRepository archiveRepository;

	// caio<- pasta comum para o upload (agora universal, relativa e portável)
	private final Path sysUploadDir = initUploadDir();

	// caio<- vamos garantir que a pasta exista em qualquer ambiente (Azure, local, etc.)
	private Path initUploadDir() {
		try {
			Path path = Paths.get("uploads").toAbsolutePath().normalize(); // caio<- sempre na raiz do projeto
			Files.createDirectories(path); // caio<- cria a pasta se não existir
			return path;
		} catch (IOException e) {
			throw new RuntimeException("caio<- erro ao criar diretório de uploads", e);
		}
	}


	// caio<- salvando o arquivo no banco e guardando ele na nossa pasta
	public String saveArchive(MultipartFile archive) throws IOException {
		String originalName = archive.getOriginalFilename(); // caio<- nome original do arquivo
		String extension = "";

		// caio<- pegando a extensão original do arquivo (ex: .png, .jpg)
		if (originalName != null && originalName.contains(".")) {
			extension = originalName.substring(originalName.lastIndexOf("."));
		}

		// caio<- gerando nome seguro pro arquivo com UUID + extensão
		String archiveName = UUID.randomUUID().toString() + extension;

		Path archivePath = sysUploadDir.resolve(archiveName); // caio<- caminho completo do arquivo

		// caio<- transferindo o archive para seu destino
		archive.transferTo(archivePath.toFile());

		// caio<- salvando informações desse nosso arquivo
		ArchiveEntity archiveEntity = new ArchiveEntity();
		archiveEntity.setArchiveName(archiveName); // caio<- nome salvo no disco (seguro)
		archiveEntity.setOriginalName(originalName);
		archiveEntity.setArchivePath(archivePath.toString());
		archiveEntity.setArchiveType(archive.getContentType());
		archiveRepository.save(archiveEntity);

		return archiveName;
	}

	// caio<- Vamos criar um método que busca o arquivo como um recurso
	// caio<- depois vamos entender por que buscar como recurso. 
	// <caio> -> Que é pq transformamos em URL kk
	public Resource collectFileResource(String archiveName) throws IOException {
		Path archivePath = sysUploadDir.resolve(archiveName);
		Resource resource = new UrlResource(archivePath.toUri());

		// caio<- é um arquivo existente e legível? Vamos checar
		if (resource.exists() && resource.isReadable()) {
			return resource;
		}
		throw new IOException("caio<- arquivo não encontrado = " + archiveName);
	}
	
	public List<Map<String, String>> listDownloadableFiles() {
	    return archiveRepository.findAll().stream()
	            .map(archive -> {
	                Map<String, String> fileInfo = new HashMap<>();
	                fileInfo.put("uuid", archive.getArchiveName()); // nome salvo (UUID)
	                fileInfo.put("name", archive.getOriginalName()); // nome real
	                fileInfo.put("type", archive.getArchiveType()); // tipo MIME
	                return fileInfo;
	            })
	            .collect(Collectors.toList());
	}
	
}
