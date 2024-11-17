package com.trainingsystem.SyncFusion.repository;

import com.trainingsystem.SyncFusion.model.entity.ActivityComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityComponentRepository extends JpaRepository<ActivityComponent, Long> {
}
