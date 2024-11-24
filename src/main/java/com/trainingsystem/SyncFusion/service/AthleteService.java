package com.trainingsystem.SyncFusion.service;

import com.trainingsystem.SyncFusion.exception.AthleteNotFoundException;
import com.trainingsystem.SyncFusion.model.entity.Athlete;
import com.trainingsystem.SyncFusion.model.dto.AthleteDto;
import com.trainingsystem.SyncFusion.repository.AthleteRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public AthleteService(AthleteRepository athleteRepository, ModelMapper modelMapper) {
        this.athleteRepository = athleteRepository;
        this.modelMapper = modelMapper;
    }

    public AthleteDto createAthlete(AthleteDto athleteDto) {

        Athlete newAthlete = convertToEntity(athleteDto);
        Athlete savedAthlete = athleteRepository.save(newAthlete);

        return convertToDto(savedAthlete);
    }

    public AthleteDto updateAthlete(AthleteDto updateAthleteDto) {
        Athlete existingAthlete = athleteRepository.findById(updateAthleteDto.getId())
                .orElseThrow(() -> new AthleteNotFoundException("Athlete not found with id: " + updateAthleteDto.getId()));


        if (updateAthleteDto.getName() != null) {
            existingAthlete.setName(updateAthleteDto.getName());
        }
        if (updateAthleteDto.getLastname() != null) {
            existingAthlete.setLastname(updateAthleteDto.getLastname());
        }
        if (updateAthleteDto.getSecondLastName() != null) {
            existingAthlete.setSecondLastName(updateAthleteDto.getSecondLastName());
        }
        if (updateAthleteDto.getEmail() != null) {
            existingAthlete.setEmail(updateAthleteDto.getEmail());
        }
        if (updateAthleteDto.getPhone() != null) {
            existingAthlete.setPhone(updateAthleteDto.getPhone());
        }
        if (updateAthleteDto.getAddress() != null) {
            existingAthlete.setAddress(updateAthleteDto.getAddress());
        }
        if (updateAthleteDto.getLogoUrl() != null) {
            existingAthlete.setAddress(updateAthleteDto.getLogoUrl());
        }
        if (updateAthleteDto.getPerformanceLevel() != null) {
            existingAthlete.setPerformanceLevel(updateAthleteDto.getPerformanceLevel());
        }
        Athlete updatedAthlete = athleteRepository.save(existingAthlete);

        return convertToDto(updatedAthlete);
    }

    public Optional<AthleteDto> getAthleteById(Long id) {
        return athleteRepository.findById(id).map(this::convertToDto);
    }

    public Page<AthleteDto> getAllAthletes(Pageable pageable) {
        Page<Athlete> athletes = athleteRepository.findAll(pageable);
        return athletes.map(this::convertToDto);
    }

    public AthleteDto convertToDto(Athlete athlete) {
        return modelMapper.map(athlete, AthleteDto.class);
    }

    public Athlete convertToEntity(AthleteDto athleteDto) {
        return modelMapper.map(athleteDto, Athlete.class);
    }


}
