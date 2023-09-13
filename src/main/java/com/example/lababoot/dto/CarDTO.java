package com.example.lababoot.dto;

import com.example.lababoot.exception.InvalidCarException;
import com.example.lababoot.models.Car;

import java.util.regex.Pattern;

public class CarDTO {
    private String enginePower;
    private String bodyType;
    private String color;
    private String manufacture;

    private String model;
    private String price;

    private String yearOfIssue;

    private static final String MANUFACTURE = "[A-Za-z0-9\\s]+";
    private static final String MODEL = "[A-Za-z0-9\\s]+";
    private static final String PRICE = "\\d{3,6}$";
    private static final String YEAR_OF_ISSUE = "\\d{4}";
    private static final String COLOR = "[A-Za-z\\s]+";
    private static final String BODY_TYPE = "[A-Za-z\\s]+";
    private static final String ENGINE_POWER = "\\d{3}";

    public Car toCar() {
        Car car = new Car();
        car.setColor(this.color);
        car.setBodyType(this.bodyType);
        car.setPrice(this.price);
        car.setModel(this.model);
        car.setManufacture(this.manufacture);
        car.setYearOfIssue(this.yearOfIssue);
        car.setEnginePower(this.enginePower);
        return car;
    }

    public void validate() throws InvalidCarException {
        if (!Pattern.matches(MODEL, model)) {
            throw new InvalidCarException("Invalid model");
        }
        if (!Pattern.matches(MANUFACTURE, manufacture)) {
            throw new InvalidCarException("Invalid manufacture");
        }
        if (!Pattern.matches(COLOR, color)) {
            throw new InvalidCarException("Invalid color");
        }
        if (!Pattern.matches(YEAR_OF_ISSUE, yearOfIssue)) {
            throw new InvalidCarException("Invalid yearOfIssue");
        }
        if (!Pattern.matches(ENGINE_POWER, enginePower)) {
            throw new InvalidCarException("Invalid enginePower");
        }
        if (!Pattern.matches(PRICE, price)) {
            throw new InvalidCarException("Invalid price");
        }
        if (!Pattern.matches(BODY_TYPE, bodyType)) {
            throw new InvalidCarException("Invalid bodyType");
        }
    }

    public CarDTO() {}

    public CarDTO(String enginePower, String bodyType, String color, String manufacture, String model, String price, String yearOfIssue) {
        this.enginePower = enginePower;
        this.bodyType = bodyType;
        this.color = color;
        this.manufacture = manufacture;
        this.model = model;
        this.price = price;
        this.yearOfIssue = yearOfIssue;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(String yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }
}
