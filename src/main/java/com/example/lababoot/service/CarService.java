package com.example.lababoot.service;

import com.example.lababoot.dto.CarDTO;
import com.example.lababoot.exception.InvalidCarException;
import com.example.lababoot.models.Car;
import com.example.lababoot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(Long postId, CarDTO carDTO, Principal principal) {

        Car car = new Car();
        car.setEnginePower(carDTO.getEnginePower());
        car.setManufacture(carDTO.getManufacture());
        car.setYearOfIssue(carDTO.getYearOfIssue());
        car.setColor(carDTO.getColor());
        car.setModel(carDTO.getModel());
        car.setBodyType(carDTO.getBodyType());
        car.setPrice(carDTO.getPrice());

        carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new InvalidCarException("Car with this id cannot be found"));
    }


    public Car createCar(CarDTO carDTO) {
        Car car = carDTO.toCar();
        return carRepository.save(car);
    }

    public Car updateCar(Long id,CarDTO carDTO) {
        Car car = carDTO.toCar();
        car.setId(id);
        return carRepository.save(car);
    }
}
