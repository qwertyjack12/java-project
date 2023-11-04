package core.svc.view;

import core.svc.controllers.*;

import java.util.Scanner;

public class ConsoleView implements View {
    private  final ApartmentController apartmentController;
    private  final CityController cityController;
    private  final RoomController roomController;
    private boolean flag;

    public ConsoleView(ApartmentController apartmentController, CityController cityController, RoomController roomController) {
        this.flag = true;
        this.apartmentController = apartmentController;
        this.cityController = cityController;
        this.roomController = roomController;
    }

    @Override
    public int listen() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void init() {
        while (this.flag) {
            showMenu();
        }
    }

    @Override
    public void saveChanges() {
        apartmentController.saveChanges();
        cityController.saveChanges();
        roomController.saveChanges();
    }

    @Override
    public void readData() {
        apartmentController.readData();
        cityController.readData();
        roomController.readData();
    }

    @Override
    public void closeThread() {
        apartmentController.closeThread();
        cityController.closeThread();
        roomController.closeThread();
    }

    @Override
    public void showMenu() {

        System.out.println("Menu:");
        System.out.println("-> 1: Apartment");
        System.out.println("-> 2: City");
        System.out.println("-> 3: Room");
        System.out.println("-> 4: Save");
        System.out.println("-> 0: Close app");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                this.flag = false;
                this.closeThread();
                return;
            }
            case 1 -> showApartments();
            case 2 -> showCities();
            case 3 -> showRooms();
            case 4 -> this.saveChanges();
            default -> showMenu();
        }

    }

    @Override
    public void showApartments() {
        System.out.println("Apartments Menu:");
        System.out.println("-> 1: Add apartment");
        System.out.println("-> 2: Add room for apartment");
        System.out.println("-> 3: Get area for apartment");
        System.out.println("-> 4: Show apartments");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> apartmentController.setApartment();
            case 2 -> apartmentController.addRoom();
            case 3 -> apartmentController.getArea();
            case 4 -> apartmentController.getApartments();
            default -> showApartments();
        }
    }
    @Override
    public void showCities() {
        System.out.println("Cities Menu:");
        System.out.println("-> 1: Add city");
        System.out.println("-> 2: Remove city");
        System.out.println("-> 3: Show Cities");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> cityController.setCity();
            case 2 -> cityController.removeCity();
            case 3 -> cityController.getCities();
            default -> showCities();
        }
    }

    @Override
    public void showRooms() {
        System.out.println("Rooms Menu:");
        System.out.println("-> 1: Add room");
        System.out.println("-> 2: Remove room");
        System.out.println("-> 3: Show Rooms");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> roomController.setRoom();
            case 2 -> roomController.removeRoom();
            case 3 -> roomController.getRooms();
            default -> showRooms();
        }
    }
}
