package com.example.lababoot.factory;


import com.example.lababoot.dto.CarDTO;

public class CarFactory {

    public static CarDTO createCar(String enginePower,
                                   String bodyType,
                                   String color,
                                   String manufacture,
                                   String model,
                                   String price,
                                   String yearOfIssue) {
        return new CarDTO(enginePower, bodyType, color, manufacture, model, price, yearOfIssue);
//
//        //Ввод производителя
////        System.out.println("Enter manufacture: ");
////        int i = 1;
////        for(Manufacture manufacture : Manufacture.values()) {
////            if(i%2 == 1) {
////                System.out.print("\n" + i++ + ". " + manufacture);
////            }
////            else {
////                System.out.print("\t" + i++ + ". " + manufacture);
////            }
////        }
////        int manufacture = scanner.nextInt() - 1;
//        int manufacture = (int) (Math.random()*Manufacture.values().length);
//
//        //Ввод типа кузова
////        System.out.println("Enter body type: ");
////        i = 1;
////        for(BodyType bodyType : BodyType.values()) {
////            System.out.println(i++ + ". " + bodyType);
////        }
////        int bodyType = scanner.nextInt() - 1;
//        int bodyType = (int) (Math.random() * BodyType.values().length);
//        //Ввод цвета машины
////        System.out.println("Enter color:");
////        i = 1;
////        for(Colors color : Colors.values()) {
////            System.out.println(i++ + ". " + color);
////        }
////        int selectedColor = scanner.nextInt() - 1;
//        int selectedColor = (int) (Math.random() * Colors.values().length);
//
//        // Ввод мощности двигателя
////        System.out.println("Enter engine power: ");
////        int enginePower = scanner.nextInt();
//        int enginePower = (int) (Math.random() * (500 + 1)) + 100;
//
//        // Ввод объёма двигателя
////        System.out.println("Enter engine volume: ");
////        double engineVolume= scanner.nextDouble();
//        double engineVolume = (Math.random() * (2.5)) + 1.5;
//
//        // Ввод типа двигателя
////        System.out.println("Enter engine type: ");
////        int i = 1;
////        for(EngineType engineType : EngineType.values()) {
////            System.out.println(i++ + ". " + engineType);
////        }
//        int engineType = (int) (Math.random() * EngineType.values().length);
//
//        //Ввод года выпуска
////        System.out.println("Enter year of issue: ");
////        int yearOfIssue = scanner.nextInt();
//        int yearOfIssue = (int) (Math.random() * 22) + 2000;
//
//        // Ввод цены
////        System.out.println("Enter price: ");
////        double price = scanner.nextDouble();
//        double price = (Math.random() * 99000) + 1000;
//
//        return new Car(
//                new Engine(enginePower,engineVolume, EngineType.values()[engineType]),
//                BodyType.values()[bodyType],
//                Colors.values()[selectedColor],
//                Manufacture.values()[manufacture],
//                price,
//                yearOfIssue);
//    }
    }


}
