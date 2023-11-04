package core.svc.controllers;

import core.svc.services.roomService.RoomService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomController {

    private final RoomService roomService;

    private final Scanner scanner;
    private final ExecutorService service;

    public RoomController(RoomService roomService, Scanner scanner) {
        this.roomService = roomService;
        this.scanner = scanner;
        this.service = Executors.newSingleThreadExecutor();
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
                roomService.saveData();
            }
        });
    }

    public void readData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                roomService.readData();
            }
        });
    }

    public void closeThread() {
        service.shutdown();
    }

    public void setRoom() {
        System.out.print("id of room: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Width: ");
        int width = listenInt();
        System.out.print("Height: ");
        int height = listenInt();

        roomService.setRoom(id, width, height, name);
    }

    public void removeRoom() {
        roomService.getRooms();
        System.out.print("id of room: ");
        int key = listenInt();
        roomService.removeRoom(key);
    }

    public void getRooms() {
        roomService.getRooms();
    }

}
