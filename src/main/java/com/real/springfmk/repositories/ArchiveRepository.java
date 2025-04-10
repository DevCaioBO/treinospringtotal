package com.real.springfmk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.real.springfmk.entitys.ArchiveEntity;

@Repository
public interface ArchiveRepository extends JpaRepository<ArchiveEntity, Long> {
	Optional<ArchiveEntity> findByArchiveName(String archiveName);
	 boolean existsByArchiveName(String archiveName);
}
