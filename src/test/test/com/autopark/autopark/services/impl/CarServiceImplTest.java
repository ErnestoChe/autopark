package com.autopark.autopark.services.impl;

import com.autopark.autopark.AbstractTest;
import com.autopark.autopark.domain.Car;
import com.autopark.autopark.dto.CarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CarServiceImplTest extends AbstractTest {

    @Autowired
    CarServiceImpl carService;
    @BeforeEach
    void init(){
        carRepository.save(Car
                .builder()
                .color("red")
                .price(1000)
                .weight(500)
                .build());
        
        carRepository.save(Car
                .builder()
                .color("blue")
                .price(400)
                .weight(1000)
                .build());
    }

    @Test
    void findAllCars() {
        List<CarDto> allCars = carService.findAllCars();
        int size = allCars.size();

        assertEquals(size,1);
    }
    @Test
    void findAllCarsPrice(){
        List<CarDto> priceCars = carService.findAllCarsPriceGreaterThan(500);

        CarDto t = priceCars.get(0);
        assertEquals(t.getColor(), "red");
        assertEquals(priceCars.size(), 1);
    }
}


//@ExtendWith(r)
//class CarServiceImplTest {
//
//    @InjectMocks
//    CarServiceImpl carService;
//
//    @Mock
//    CarRepository carRepository;
//    @Mock
//    CarMapper carMapper;
//
//    @Test
//    void findAllCars() {
//        // when
//        when(carMapper.toDto(anyObject())).thenReturn(new CarDto());
//        when(carRepository.findAll()).thenReturn(Collections.singletonList(new Car()));
//
//        // then
//        List<CarDto> allCars = carService.findAllCars();
//
//        //throw
//        assertEquals(allCars.size(),1);
//    }
//}