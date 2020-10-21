package com.autopark.autopark.dto;

import com.autopark.autopark.domain.CarType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

    private CarType type;

    private int weight;

    private String color;

    private int price;

}
