package com.crowdynamics.sigfox.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crowdynamics.sigfox.entity.SigfoxMessagesEntity;

public interface SigfoxRepository extends JpaRepository<SigfoxMessagesEntity,Long> {

	List<SigfoxMessagesEntity> findAll();
	
	List<SigfoxMessagesEntity> findOne(Long id);
}
