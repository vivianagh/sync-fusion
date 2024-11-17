package com.trainingsystem.SyncFusion.repository;

import com.trainingsystem.SyncFusion.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository <T extends Person> extends JpaRepository<T, Long> {
}
