package com.autopark.autopark.mapper;

import com.autopark.autopark.domain.Car;
import com.autopark.autopark.dto.CarDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {

    CarDto toDto(Car car);

    List<CarDto> listToDto(List<Car> cars);

}
