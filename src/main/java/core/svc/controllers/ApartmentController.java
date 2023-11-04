package core.svc.controllers;

import core.svc.services.apatmentService.ApartmentService;
import core.svc.services.cityService.CityService;
import core.svc.services.roomService.RoomService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApartmentController {

    private final ApartmentService apartmentService;
    private final CityService cityService;
    private final RoomService roomService;
    private final Scanner scanner;
    public final ExecutorService service;

    public ApartmentController(ApartmentService apartmentService, CityService cityService, RoomService roomService, Scanner scanner) {
        this.apartmentService = apartmentService;
        this.cityService = cityService;
        this.roomService = roomService;
        this.scanner = scanner;
        service = Executors.newFixedThreadPool(2);
    }

    public int listenInt() {
        return scanner.nextInt();
    }

    public String listenStr() {
        return scanner.next();
    }

    public void saveChanges() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                apartmentService.saveData();
            }
        });
    }

    public void readData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                apartmentService.readData();
            }
        });
    }

    public void closeThread() {
        service.shutdown();
    }

    public void setApartment() {
        System.out.print("id of apartment: ");
        int id = listenInt();
        System.out.print("Price: ");
        int price = listenInt();
        System.out.print("Description: ");
        String description = listenStr();

        cityService.getCities();

        System.out.print("id of city: ");
        int cityId = listenInt();

        apartmentService.setApartment(id, price, description, cityService.getCity(cityId));
    }

    public void addRoom() {
        apartmentService.getApartments();
        System.out.print("id of apartment: ");
        int id = listenInt();

        roomService.getRooms();
        System.out.print("id of room: ");
        int roomId = listenInt();

        apartmentService.addRoom(id, roomService.getRoom(roomId));
    }

    public void removeRoom(){}

    public void getArea() {
        apartmentService.getApartments();
        System.out.print("id of apartment: ");
        int id = listenInt();

        apartmentService.getArea(id);
    }

    public void getApartments() {
        apartmentService.getApartments();
    }

}
