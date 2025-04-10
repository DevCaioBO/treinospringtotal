package com.real.springfmk.entitys;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
@Entity
@Table(name="tb_atividade")
public class AtivityEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ativity")
	private Long idAtivity;
	
	
	@Column(name="name_ativity")
	private String nameAtivity;
	
	@Column(name="description_ativity")
	private String descriptionAtivity;
	
	@Column(name="date_create_ativity",updatable = false)
	private LocalDateTime dateCreateAtivity;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	
	
	
	
	
	
	
	public AtivityEntity() {
		super();
	}


	public AtivityEntity(Long idAtivity, String nameAtivity, String descriptionAtivity, LocalDateTime dateCreateAtivity,
			UserEntity user) {
		super();
		this.idAtivity = idAtivity;
		this.nameAtivity = nameAtivity;
		this.descriptionAtivity = descriptionAtivity;
		this.dateCreateAtivity = dateCreateAtivity;
		this.user = user;
	}
	
	


	@PrePersist
	protected void onCreate() {
		this.dateCreateAtivity = LocalDateTime.now();
	}

	public Long getIdAtivity() {
		return idAtivity;
	}

	public void setIdAtivity(Long idAtivity) {
		this.idAtivity = idAtivity;
	}

	public String getNameAtivity() {
		return nameAtivity;
	}

	public void setNameAtivity(String nameAtivity) {
		this.nameAtivity = nameAtivity;
	}

	public String getDescriptionAtivity() {
		return descriptionAtivity;
	}

	public void setDescriptionAtivity(String descriptionAtivity) {
		this.descriptionAtivity = descriptionAtivity;
	}

	public LocalDateTime getDateCreateAtivity() {
		return dateCreateAtivity;
	}

	public void setDateCreateAtivity(LocalDateTime dateCreateAtivity) {
		this.dateCreateAtivity = dateCreateAtivity;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	


	
	
	
	
	
	
	
	
	
}
