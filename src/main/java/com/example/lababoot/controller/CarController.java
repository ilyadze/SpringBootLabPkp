package com.example.lababoot.controller;

import com.example.lababoot.converter.CarConverterDOM;
import com.example.lababoot.dto.CarDTO;
import com.example.lababoot.facade.ConverterFacade;
import com.example.lababoot.models.Car;
import com.example.lababoot.response.MessageResponse;
import com.example.lababoot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final String URL_XML= "/Users/ilyadasko/Documents/Lab_PKP/MavenLab_6/src/main/resources/cars.xml";

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/xml")
    public ResponseEntity<Object> getCarsFromXml() {
        List<CarDTO> carsDTO = ConverterFacade.getCars(URL_XML);
        List<Car> cars = new ArrayList<>();
        for (CarDTO car:carsDTO) {
            try {
                car.validate();
                cars.add(car.toCar());
                System.out.println(car);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/xml/sax")
    public ResponseEntity<Object> getCarsFromXmlSAX() {
        List<CarDTO> carsDTO = null;
        try {
            carsDTO = ConverterFacade.getCarsFromSax(URL_XML);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        List<Car> cars = new ArrayList<>();
        for (CarDTO car:carsDTO) {
            try {
                car.validate();
                cars.add(car.toCar());
                System.out.println(car);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Object> getCars() {
        System.out.println(carService.getAllCars());
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Object> getCar(@PathVariable("carId") Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping("/{carId}/delete")
    public ResponseEntity<MessageResponse> deleteCar(@PathVariable("carId") Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(new MessageResponse("Car was deleted"), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Object> createPost(@RequestBody CarDTO carDTO) {
        Car car = carService.createCar(carDTO);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable("id") Long id, @RequestBody CarDTO carDTO) {
        System.out.println("-=============================");
        System.out.println(carDTO);
        System.out.println("-=============================");
        Car car = carService.updateCar(id, carDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
