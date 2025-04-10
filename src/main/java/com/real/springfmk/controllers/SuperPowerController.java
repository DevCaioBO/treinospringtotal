package com.real.springfmk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real.springfmk.dtos.SuperPowerDTO;
import com.real.springfmk.services.SuperPowerService;

@RestController
@RequestMapping("power")
public class SuperPowerController {
	@Autowired
	private SuperPowerService superPowerService; 
	
	@GetMapping("/readAll")
	public 	ResponseEntity<List<SuperPowerDTO>> ReadAllSuperPower(){
		
		return ResponseEntity.ok(superPowerService.ReadAllSuperPower());
	}
	
	@PostMapping("/create")
	public ResponseEntity CreateOneNewSuperPower(@RequestBody SuperPowerDTO superPowerDTO) {
		return ResponseEntity.ok(superPowerService.CreateOneNewSuperPower(superPowerDTO));
		
	}
}
