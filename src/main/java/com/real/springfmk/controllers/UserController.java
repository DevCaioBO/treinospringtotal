package com.real.springfmk.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real.springfmk.dtos.UserDTO;
import com.real.springfmk.entitys.UserEntity;
import com.real.springfmk.repositories.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("Read")
	public ResponseEntity ReadUsers() {
		List<UserEntity> existentUsers = userRepo.findAll();
		
		return ResponseEntity.ok(existentUsers);
	}
	@PostMapping("creating")
	public ResponseEntity CreateNewUser(@RequestBody UserDTO userDTO) {
		UserEntity myUserEntity = new UserEntity();
		
		myUserEntity.setUserName(userDTO.getUserName());
		myUserEntity.setUserEmail(userDTO.getUserEmail());
		myUserEntity.setUserPassword(userDTO.getUserPassword());
		//myUserEntity.setUserDateCreate(LocalDateTime.now());
		userRepo.save(myUserEntity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(myUserEntity);
		
		
	}
	
}
