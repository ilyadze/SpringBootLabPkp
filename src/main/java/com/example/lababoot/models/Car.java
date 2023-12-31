package com.example.lababoot.models;



import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String enginePower;
    @Column
    private String bodyType;
    @Column
    private String color;
    @Column
    private String manufacture;
    @Column
    private String model;
    @Column
    private String price;
    @Column
    private String yearOfIssue;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                "id=" + id +
                ", enginePower=" + enginePower +
                ", bodyType='" + bodyType + '\'' +
                ", color='" + color + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", yearOfIssue=" + yearOfIssue +
                '}';
    }
}
