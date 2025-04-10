package com.real.springfmk.dtos;

import com.real.springfmk.entitys.AtivityEntity;

public class AtivityDTO {
	private String nameAtivity;
	private String descriptionAtivity;
	
	
	
	
	public AtivityDTO() {
		super();
	}
	
	public AtivityDTO(String nameAtivity, String descriptionAtivity) {
		super();
		this.nameAtivity = nameAtivity;
		this.descriptionAtivity = descriptionAtivity;
	}
	
	public AtivityDTO(AtivityEntity ativityEntity) {
		super();
		nameAtivity = ativityEntity.getNameAtivity();
		descriptionAtivity = ativityEntity.getDescriptionAtivity();
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
	

	
	
	
}
