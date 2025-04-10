package com.real.springfmk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.real.springfmk.entitys.SuperPowerEntity;

@Repository
public interface SuperPowerRepository extends JpaRepository<SuperPowerEntity, Long> {

}
