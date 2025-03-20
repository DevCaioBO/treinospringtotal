package com.real.springfmk.dtos;

import com.real.springfmk.entitys.UserEntity;

public class UserDTO {
	
	private String userName;
	
	private String userEmail;
	
	private String userPassword;
	
	
	
	
	
	

	public UserDTO() {
		super();
	}

	public UserDTO(String userName, String userEmail, String userPassword) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
    public UserDTO(UserEntity entity) {
  
        this.userName = entity.getUserName();
        this.userEmail = entity.getUserEmail();
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
