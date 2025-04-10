package com.real.springfmk.entitys;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_super_power")
public class SuperPowerEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lg_super_power_id")
	private Long superPowerId;
	
	@Column(name="str_super_power_name")
	private String superPowerName;
	
	@Column(name="lg_super_power_damage")
	private Long superPowerDamage;
	
	@ManyToMany(mappedBy = "powers")
	List<UserEntity> users = new ArrayList<>();
	
	

	public SuperPowerEntity() {
		super();
	}



	public SuperPowerEntity(Long superPowerId, String superPowerName, Long superPowerDamage, List<UserEntity> users) {
		super();
		this.superPowerId = superPowerId;
		this.superPowerName = superPowerName;
		this.superPowerDamage = superPowerDamage;
		this.users = users;
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



	public List<UserEntity> getUsers() {
		return users;
	}



	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	
	
	
	
}
