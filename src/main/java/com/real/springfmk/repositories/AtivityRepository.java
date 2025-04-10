package com.real.springfmk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.real.springfmk.entitys.AtivityEntity;

public interface AtivityRepository extends JpaRepository<AtivityEntity, Long> {
    @Query("""
            SELECT a FROM AtivityEntity a WHERE a.user = :userId
        """)
	 List<AtivityEntity> findByUserAndAtivities(Long userId);
}
