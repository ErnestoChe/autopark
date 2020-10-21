package com.autopark.autopark.controllers;

import com.autopark.autopark.dto.CarDto;
import com.autopark.autopark.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(CarController.CAR_URI)
public class CarController {

    public static final String CAR_URI = "/car";

    public static final String ALL_CARS_URI = "/all";

    public static final String PRICE_CAR_URI = "/byprice";

    private final CarService carService;

    // http/https//:ip:port/car/all

    @GetMapping(ALL_CARS_URI)
    public List<CarDto> getAll(){
        return carService.findAllCars();
    }

    @GetMapping(PRICE_CAR_URI)
    public List<CarDto> getGreaterThanPrice(){
        return carService.findAllCarsPriceGreaterThan(600);
    }
}
