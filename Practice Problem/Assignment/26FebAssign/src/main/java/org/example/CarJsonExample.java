package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CarJsonExample {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2023);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(car);
        System.out.println(json);
    }
}
