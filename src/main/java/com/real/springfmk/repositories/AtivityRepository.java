package com.real.springfmk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.real.springfmk.entitys.AtivityEntity;

public interface AtivityRepository extends JpaRepository<AtivityEntity, Long> {
	 List<AtivityEntity> findByUserUserId(Long userId);
}
