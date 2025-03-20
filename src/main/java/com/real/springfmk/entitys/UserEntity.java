package com.real.springfmk.entitys;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Table(name="tb_users")
@Entity(name="tb_users")
public class UserEntity {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_data_create",updatable = false)
	private LocalDateTime userDateCreate;
	//@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	@JsonManagedReference
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	@OrderBy("idAtivity ASC")
	private Set<AtivityEntity> ativities = new LinkedHashSet<>();
	
	@PrePersist
	protected void onCreate() {
		this.userDateCreate = LocalDateTime.now();
	}

	
	
	
	
	
	
	
	
	public UserEntity() {
		super();
	}


	public UserEntity(Long userId, String userName, String userPassword, String userEmail, LocalDateTime userDateCreate,
			Set<AtivityEntity> ativities) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userDateCreate = userDateCreate;
		this.ativities = ativities;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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









	public Set<AtivityEntity> getAtivities() {
		return ativities;
	}









	public void setAtivities(Set<AtivityEntity> ativities) {
		this.ativities = ativities;
	}









	
	
	
	
	
}
