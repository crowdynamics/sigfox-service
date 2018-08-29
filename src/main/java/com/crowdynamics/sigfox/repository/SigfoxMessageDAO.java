package com.crowdynamics.sigfox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crowdynamics.sigfox.entity.SigfoxMessageEntity;

public interface SigfoxMessageDAO extends JpaRepository<SigfoxMessageEntity,Long> {
}
