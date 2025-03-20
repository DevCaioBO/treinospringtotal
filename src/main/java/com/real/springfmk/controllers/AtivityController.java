package com.real.springfmk.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real.springfmk.dtos.AtivityDTO;
import com.real.springfmk.entitys.AtivityEntity;
import com.real.springfmk.entitys.UserEntity;
import com.real.springfmk.repositories.AtivityRepository;
import com.real.springfmk.repositories.UserRepository;

@RestController
@RequestMapping("/ativity")
public class AtivityController {
	
	@Autowired
	private AtivityRepository atvRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/read/{id}")
	public ResponseEntity<List<UserEntity>> CollectFullDataOfOneAtivity(@PathVariable Long id) {
		List<UserEntity> ativities = userRepo.findByUserId(id);
		return ResponseEntity.ok(ativities);
	}
	
    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createActivity(@PathVariable Long userId, @RequestBody AtivityDTO data) {
        Optional<UserEntity> userOptional = userRepo.findById(userId);
        
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }
        
        UserEntity user = userOptional.get();
        AtivityEntity newActivity = new AtivityEntity();
        newActivity.setNameAtivity(data.getNameAtivity());
        newActivity.setDescriptionAtivity(data.getDescriptionAtivity());
        newActivity.setUser(user);

        AtivityEntity savedActivity = atvRepo.save(newActivity);
        return ResponseEntity.status(201).body(savedActivity);
    }

	
	@PutMapping("/updating/{id}")
	public ResponseEntity UpdatingOneAtivity (@PathVariable Long id, @RequestBody AtivityDTO data) {
		Optional<AtivityEntity> ativityBody = atvRepo.findById(id);
		
		if(ativityBody.isPresent()) {
		AtivityEntity ativityUpdating = ativityBody.get();
		ativityUpdating.setNameAtivity(data.getNameAtivity());
		ativityUpdating.setDescriptionAtivity(data.getDescriptionAtivity());
		
		AtivityEntity ativityUpdated = atvRepo.save(ativityUpdating);
		
		return ResponseEntity.ok(ativityUpdated);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Atividade não encontrada");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity DeleteOneTask(@PathVariable Long id) {
		Optional<AtivityEntity> targetTask = atvRepo.findById(id);
		
		if(targetTask.isPresent()) {
			atvRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("excluido com sucesso");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado");
		
	}
}
