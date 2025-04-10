package com.real.springfmk.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.springfmk.dtos.SuperPowerDTO;
import com.real.springfmk.entitys.SuperPowerEntity;
import com.real.springfmk.repositories.SuperPowerRepository;

import jakarta.transaction.Transactional;

@Service
public class SuperPowerService {
	
	@Autowired
	private SuperPowerRepository superPowerRepository;
	
	public List<SuperPowerDTO> ReadAllSuperPower(){
		return superPowerRepository.findAll()
				.stream()
				.map(SuperPowerDTO::new)
				.collect(Collectors.toList());
		
	}
	@Transactional
	public SuperPowerDTO CreateOneNewSuperPower(SuperPowerDTO superPowerDTO) {
		
		SuperPowerEntity superPowerEntity = new SuperPowerEntity();
		superPowerEntity.setSuperPowerName(superPowerDTO.getSuperPowerName());
		superPowerEntity.setSuperPowerDamage(superPowerDTO.getSuperPowerDamage());
		
		SuperPowerEntity savedPowerEntity = superPowerRepository.save(superPowerEntity);
		
		
		return new SuperPowerDTO(savedPowerEntity);
		
	}
}
