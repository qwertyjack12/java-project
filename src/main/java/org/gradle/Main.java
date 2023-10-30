package org.gradle;

import core.apartment.ApartmentImpl;
import core.city.City;
import core.room.Room;
import core.room.RoomImpl;

public class Main {
    public static void main(String[] args) {
        City city = new City("Moscow", "Russia", 2500000);
        System.out.println(city.getCountry());
        System.out.println(city.getName());
        System.out.println(city.getPopulation());
        System.out.println(city.toString());

        System.out.println("--------------------");

        RoomImpl room = new RoomImpl(15, 20, "hall");

        System.out.println(room.calculateArea());
        System.out.println(room.getWidth());
        System.out.println(room.getHeight());
        System.out.println(room.getName());
        System.out.println(room.toString());

        System.out.println("--------------------");

        ApartmentImpl apartment = new ApartmentImpl(1500000, "perfect apartment for solo-playing person", city);

        System.out.println(apartment.getPrice());
        System.out.println(apartment.getDescription());
        System.out.println(apartment.getCity());
        System.out.println(apartment.getRoomList());

        apartment.addRoom(room);

        System.out.println(apartment.getRoomList());
    }
}