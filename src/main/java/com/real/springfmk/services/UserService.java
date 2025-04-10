package com.real.springfmk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.springfmk.dtos.UserDTO;
import com.real.springfmk.dtos.UserPowerDTO;
import com.real.springfmk.entitys.SuperPowerEntity;
import com.real.springfmk.entitys.UserEntity;
import com.real.springfmk.repositories.SuperPowerRepository;
import com.real.springfmk.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private SuperPowerRepository superPowerRepository;

	   public UserDTO getUserWithAtivities(Long userId) {
	        return userRepository.findUserWithAtivities(userId)
	                .map(UserDTO::new)
	                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	    }
	   
	  



	    @Transactional
	    public UserDTO associatePowerToUser(Long userId, Long powerId) {
	        UserEntity user = userRepository.findUserWithAtivitiesAndPowers(userId)
	                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	        SuperPowerEntity power = superPowerRepository.findById(powerId)
	                .orElseThrow(() -> new RuntimeException("Poder não encontrado"));

	        user.getPowers().add(power);
	        power.getUsers().add(user);

	        userRepository.save(user);

	        return new UserDTO(user);
	    }

	    public List<UserPowerDTO> getAllUserPowers() {
	        return userRepository.findAllUserPowers();
	    }
}
