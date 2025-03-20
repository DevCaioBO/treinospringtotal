package com.real.springfmk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.real.springfmk.entitys.AtivityEntity;
import com.real.springfmk.entitys.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	List<UserEntity> findByUserId(Long userId);
}
