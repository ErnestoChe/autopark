package com.autopark.autopark.controllers;

import com.autopark.autopark.AbstractTest;
import com.autopark.autopark.domain.Car;
import com.autopark.autopark.dto.CarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.Collections;
import java.util.List;

import static com.autopark.autopark.controllers.CarController.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTest extends AbstractTest {

    @BeforeEach
    void init(){
        carRepository.save(Car
                .builder()
                .color("red")
                .price(1000)
                .weight(2000)
                .build());

        carRepository.save(Car
                .builder()
                .color("white")
                .price(500)
                .weight(500)
                .build());

        carRepository.save(Car
                .builder()
                .color("black")
                .price(601)
                .weight(500)
                .build());
    }

    @Test
    void getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        testRestTemplate = new TestRestTemplate();
        ResponseEntity<List<CarDto>> responseEntity = testRestTemplate
                .exchange("http://localhost:" + port + CAR_URI + ALL_CARS_URI,
                        HttpMethod.GET,
                        entity,
                        new ParameterizedTypeReference<>() {
                        });

        HttpStatus statusCode = responseEntity.getStatusCode();

        List<CarDto> body = responseEntity.getBody();
        int size = body.size();

        assertEquals(statusCode, HttpStatus.OK);
        assertEquals(size,2);
    }

    @Test
    void getGreaterThanPrice(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        testRestTemplate = new TestRestTemplate();
        ResponseEntity<List<CarDto>> responseEntity = testRestTemplate
                .exchange("http://localhost:" + port + CAR_URI + PRICE_CAR_URI,
                        HttpMethod.GET,
                        entity,
                        new ParameterizedTypeReference<>() {
                        });

        HttpStatus statusCode = responseEntity.getStatusCode();

        List<CarDto> body = responseEntity.getBody();
        String color = body.get(0).getColor();
        int size = body.size();

        assertEquals(statusCode, HttpStatus.OK);

        assertEquals(size,2);
        assertEquals(color, "red");
    }
}