package com.example.lababoot.models;


public class Car {
    private String enginePower;
    private String bodyType;
    private String color;
    private String manufacture;

    private String model;
    private String price;

    private String yearOfIssue;






    public Car() {}

    public Car(String enginePower, String bodyType, String color, String manufacture, String model, String price, String yearOfIssue) {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "Car{" +
                "enginePower=" + enginePower +
                ", bodyType='" + bodyType + '\'' +
                ", color='" + color + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", yearOfIssue=" + yearOfIssue +
                '}';
    }
}
