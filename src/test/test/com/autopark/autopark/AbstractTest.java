package com.autopark.autopark;

import com.autopark.autopark.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AbstractTest {

    @LocalServerPort
    protected int port;

    protected TestRestTemplate testRestTemplate;

    @Autowired
    protected CarRepository carRepository;

    @AfterEach
    void flush(){
        carRepository.deleteAll();
        carRepository.flush();
    }
}
