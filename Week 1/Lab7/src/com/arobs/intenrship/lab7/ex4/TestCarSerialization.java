package com.arobs.intenrship.lab7.ex4;

import java.io.*;
import java.util.ArrayList;

public class TestCarSerialization {
    public static void main(String[] args) {

        String filename = "cars.ser";
        Car c1 = new Car("Dacia", 10000);
        Car c2 = new Car("Ferrari", 50000);
        Car c3 = new Car("Tesla", 45000);
        ArrayList<Car> serCars = new ArrayList<>();
        serCars.add(c1);
        serCars.add(c2);
        serCars.add(c3);

        serialize(serCars, filename);

        ArrayList<Car> desCars = deserialize(filename);

        assert desCars != null;
        for (Car car : desCars) {
            System.out.println(car.getModel() + " " + car.getPrice());
        }
    }

    public static void serialize(ArrayList<Car> cars, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(cars);
            System.out.println("Serializing: ");
            for (Car car : cars) {
                System.out.println(car.getModel() + " : " + car.getPrice());
            }

            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Car> deserialize(String filename) {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            System.out.println("\nDeserializing:");
            ArrayList<Car> cars = new ArrayList<>();
            cars = (ArrayList<Car>) in.readObject();
            return cars;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("IOE or ClassNotFoundE");
            return null;
        }
    }
}
