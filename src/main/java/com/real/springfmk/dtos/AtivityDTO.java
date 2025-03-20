package com.real.springfmk.dtos;

public class AtivityDTO {
	private String nameAtivity;
	private String descriptionAtivity;
	

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
	public AtivityDTO(String nameAtivity, String descriptionAtivity) {
		super();
		this.nameAtivity = nameAtivity;
		this.descriptionAtivity = descriptionAtivity;
	}
	public AtivityDTO() {
		super();
	}
	
	
	
}
