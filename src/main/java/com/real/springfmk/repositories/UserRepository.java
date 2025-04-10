package com.real.springfmk.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.real.springfmk.dtos.UserPowerDTO;
import com.real.springfmk.entitys.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	List<UserEntity> findByUserId(Long userId);
	
	@Query("""
	        SELECT u FROM UserEntity u JOIN FETCH u.ativities WHERE u.userId = :userId
	       """)
	Optional<UserEntity> findUserWithAtivities(@Param("userId") Long userId);
	
	@Query("""
			SELECT u FROM UserEntity u 
			JOIN 
			FETCH u.ativities 
			LEFT
			JOIN 
			FETCH u.powers WHERE u.userId = :userId
			""")
    Optional<UserEntity> findUserWithAtivitiesAndPowers(@Param("userId") Long userId);

    @Query("SELECT new com.real.springfmk.dtos.UserPowerDTO(u.userId, u.userName, p.superPowerId, p.superPowerName) " +
           "FROM UserEntity u JOIN u.powers p")
    List<UserPowerDTO> findAllUserPowers();
}
