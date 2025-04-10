package com.real.springfmk.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.real.springfmk.entitys.UserEntity;

public class UserDTO {
	
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private LocalDateTime userDateCreate;
    private List<AtivityDTO> ativities; 
    private List<SuperPowerDTO> powers;
    public UserDTO() {
		super();
	}



	public UserDTO(Long userId, String userName, String userEmail, String userPassword, LocalDateTime userDateCreate,
			List<AtivityDTO> ativities, List<SuperPowerDTO> powers) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userDateCreate = userDateCreate;
		this.ativities = ativities;
		this.powers = powers;
	}



	public UserDTO(UserEntity entity) {
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.userEmail = entity.getUserEmail();
        this.userPassword = entity.getUserPassword();
        this.userDateCreate = entity.getUserDateCreate();
        
        this.ativities = entity.getAtivities() != null
                ? entity.getAtivities().stream()
                        .map(AtivityDTO::new)
                        .collect(Collectors.toList())
                : List.of(); 

        // Mapeia os poderes
        this.powers = entity.getPowers() != null
                ? entity.getPowers().stream()
                        .map(SuperPowerDTO::new)
                        .collect(Collectors.toList())
                : List.of();
    }
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public LocalDateTime getUserDateCreate() {
		return userDateCreate;
	}
	public void setUserDateCreate(LocalDateTime userDateCreate) {
		this.userDateCreate = userDateCreate;
	}
	public List<AtivityDTO> getAtivities() {
		return ativities;
	}
	public void setAtivities(List<AtivityDTO> ativities) {
		this.ativities = ativities;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public List<SuperPowerDTO> getPowers() {
		return powers;
	}



	public void setPowers(List<SuperPowerDTO> powers) {
		this.powers = powers;
	}
	
	
	
	
	
	
	
	
	
}
