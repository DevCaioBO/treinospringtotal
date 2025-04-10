package com.real.springfmk.dtos;

import com.real.springfmk.entitys.SuperPowerEntity;

import jakarta.persistence.Column;

public class SuperPowerDTO {
	
	private Long superPowerId;
	
	private String superPowerName;
	
	private Long superPowerDamage;

	public SuperPowerDTO() {
		super();
	}

	public SuperPowerDTO(Long superPowerId, String superPowerName, Long superPowerDamage) {
		super();
		this.superPowerId = superPowerId;
		this.superPowerName = superPowerName;
		this.superPowerDamage = superPowerDamage;
	}
	
	public SuperPowerDTO(SuperPowerEntity entity) {
		superPowerId = entity.getSuperPowerId();
		superPowerName = entity.getSuperPowerName();
		superPowerDamage = entity.getSuperPowerDamage();
	}

	public Long getSuperPowerId() {
		return superPowerId;
	}

	public void setSuperPowerId(Long superPowerId) {
		this.superPowerId = superPowerId;
	}

	public String getSuperPowerName() {
		return superPowerName;
	}

	public void setSuperPowerName(String superPowerName) {
		this.superPowerName = superPowerName;
	}

	public Long getSuperPowerDamage() {
		return superPowerDamage;
	}

	public void setSuperPowerDamage(Long superPowerDamage) {
		this.superPowerDamage = superPowerDamage;
	}
	
	
}
