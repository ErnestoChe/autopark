package com.autopark.autopark.repository;

import com.autopark.autopark.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByPriceGreaterThan(int price);
}
