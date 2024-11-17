package com.trainingsystem.SyncFusion.repository;

import com.trainingsystem.SyncFusion.model.entity.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPlanRepository extends JpaRepository <TrainingPlan, Long>{
}
