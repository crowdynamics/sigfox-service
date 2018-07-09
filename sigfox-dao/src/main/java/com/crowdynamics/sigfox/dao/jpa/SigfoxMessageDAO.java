package com.crowdynamics.sigfox.dao.jpa;

import com.crowdynamics.sigfox.entity.SigfoxMessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SigfoxMessageDAO extends JpaRepository<SigfoxMessagesEntity,Long> {
}
