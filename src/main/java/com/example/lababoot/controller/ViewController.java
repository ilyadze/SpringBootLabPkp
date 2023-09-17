package com.example.lababoot.controller;

import com.example.lababoot.converter.CarConverter;
import com.example.lababoot.dto.CarDTO;
import com.example.lababoot.models.Car;
import com.example.lababoot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {

    private final String URL_XML= "/Users/ilyadasko/Documents/Lab_PKP/MavenLab_6/src/main/resources/cars.xml";

    private final CarService carService;

    @Autowired
    public ViewController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/xml")
    public String getCarsFromXml(Model model) {
        List<CarDTO> carsDTO = CarConverter.getCars(URL_XML);
        List<Car> cars = new ArrayList<>();
        for (CarDTO car:carsDTO) {
            try {
                car.validate();
                cars.add(car.toCar());
                System.out.println(car);
            } catch (Exception e) {
                System.out.println("ERROR");
                e.printStackTrace();
            }
        }
        System.out.println("GOOD");
        model.addAttribute("cars", cars);
        return "./templates/index.ftlh";
    }

    @GetMapping("/all")
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "index";
    }
}
