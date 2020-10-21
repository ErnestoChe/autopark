package com.autopark.autopark.services;


import com.autopark.autopark.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> findAllCars();

    List<CarDto> findAllCarsPriceGreaterThan(int price);

}
