package com.trainingsystem.SyncFusion.repository;

import com.trainingsystem.SyncFusion.model.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    Optional<Athlete> getAthletesById(Long id);
}
