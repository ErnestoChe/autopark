package com.autopark.autopark.config;

import com.autopark.autopark.mapper.CarMapper;
import com.autopark.autopark.mapper.CarTypeMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CarMapper getCarMapper(){
        return Mappers.getMapper(CarMapper.class);
    }

    @Bean
    public CarTypeMapper getCarTypeMapper(){
        return Mappers.getMapper(CarTypeMapper.class);
    }

}
