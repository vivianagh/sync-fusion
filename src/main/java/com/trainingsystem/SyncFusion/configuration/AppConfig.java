package com.trainingsystem.SyncFusion.configuration;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //Configure ModelMapper to skip null fields
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        return new ModelMapper();
    }
}
