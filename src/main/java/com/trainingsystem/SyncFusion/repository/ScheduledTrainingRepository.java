package com.trainingsystem.SyncFusion.repository;

import com.trainingsystem.SyncFusion.model.entity.ScheduledTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledTrainingRepository extends JpaRepository<ScheduledTraining, Long> {
}
