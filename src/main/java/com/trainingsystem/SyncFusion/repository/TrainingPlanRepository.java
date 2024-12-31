package com.trainingsystem.SyncFusion.repository;

import com.trainingsystem.SyncFusion.model.entity.TrainingPlan;
import com.trainingsystem.SyncFusion.util.IntensityLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TrainingPlanRepository extends JpaRepository <TrainingPlan, Long>{

    List<TrainingPlan> findByAthleteId(Long athleteId);

    List<TrainingPlan> findByAthleteIdAndStartDateBetween(Long athleteId, Date startDate, Date endDate);

    @Query("SELECT tp FROM TrainingPlan tp WHERE " +
    " (:athleteId IS NULL OR tp.athlete.id = :athleteId ) AND" +
    " (:intensityLevel IS NULL OR tp.intensityLevel = :intensityLevel) AND " +
    " (:startDate IS NULL OR tp.startDate >= :startDate) AND " +
    " (:endDate IS NULL OR tp.endDate <= :endDate) ")
    Page<TrainingPlan> searchTrainingPlans(
            @Param("athleteId") Long athleteId, @Param("intensityLevel")IntensityLevel intensityLevel,
            @Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate,
            Pageable pageable
            );

}
