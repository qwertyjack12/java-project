package org.gradle;

import core.apartment.ApartmentImpl;
import core.city.City;
import core.room.Room;
import core.room.RoomImpl;
import core.svc.controllers.ApartmentController;
import core.svc.controllers.CityController;
import core.svc.controllers.RoomController;
import core.svc.services.apatmentService.ApartmentServiceImpl;
import core.svc.services.cityService.CityServiceImpl;
import core.svc.services.roomService.RoomServiceImpl;
import core.svc.view.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        City city = new City("Moscow", "Russia", 2500000);
//        System.out.println(city.getCountry());
//        System.out.println(city.getName());
//        System.out.println(city.getPopulation());
//        System.out.println(city.toString());
//
//        System.out.println("--------------------");
//
//        RoomImpl room = new RoomImpl(15, 20, "hall");
//
//        System.out.println(room.calculateArea());
//        System.out.println(room.getWidth());
//        System.out.println(room.getHeight());
//        System.out.println(room.getName());
//        System.out.println(room.toString());
//
//        System.out.println("--------------------");
//
//        ApartmentImpl apartment = new ApartmentImpl(1500000, "perfect apartment for solo-playing person", city);
//
//        System.out.println(apartment.getPrice());
//        System.out.println(apartment.getDescription());
//        System.out.println(apartment.getCity());
//        System.out.println(apartment.getRoomList());
//
//        apartment.addRoom(room);
//        apartment.addRoom(room);
//
//        System.out.println(apartment.getRoomList());
//
//        System.out.println(apartment.toString());

        ApartmentServiceImpl apartmentService = new ApartmentServiceImpl();
        CityServiceImpl cityService = new CityServiceImpl();
        RoomServiceImpl roomService = new RoomServiceImpl();

        Scanner scanner = new Scanner(System.in);

        ApartmentController apartmentController = new ApartmentController(apartmentService, cityService, roomService, scanner);
        CityController cityController = new CityController(cityService, scanner);
        RoomController roomController = new RoomController(roomService, scanner);

        ConsoleView consoleView = new ConsoleView(apartmentController, cityController, roomController);

        consoleView.readData();
        consoleView.init();
    }
}