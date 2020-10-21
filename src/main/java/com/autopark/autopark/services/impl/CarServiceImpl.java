package com.autopark.autopark.services.impl;

import com.autopark.autopark.dto.CarDto;
import com.autopark.autopark.mapper.CarMapper;
import com.autopark.autopark.repository.CarRepository;
import com.autopark.autopark.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarDto> findAllCars() {
        return carMapper.listToDto(carRepository.findAll());
    }

    @Override
    public List<CarDto> findAllCarsPriceGreaterThan(int price) {
        return carMapper.listToDto(carRepository.findByPriceGreaterThan(price));
    }
}
