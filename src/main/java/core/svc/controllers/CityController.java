package core.svc.controllers;

import core.svc.services.cityService.CityService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CityController {

    private final CityService cityService;
    private final Scanner scanner;
    private final ExecutorService service;

    public CityController(CityService cityService, Scanner scanner){
        this.cityService = cityService;
        this.scanner = scanner;
        this.service = Executors.newSingleThreadExecutor();
    }

    public int listenInt() {
        return scanner.nextInt();
    }

    public String listenStr() {
        return scanner.next();
    }

    public void saveChanges(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                cityService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                cityService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setCity() {
        System.out.print("id of city: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Country: ");
        String country = listenStr();
        System.out.print("Population: ");
        int population = listenInt();

        cityService.setCity(id, name, country, population);
    }

    public void removeCity() {
        cityService.getCities();
        System.out.print("id of city: ");
        int key = listenInt();
        cityService.removeCity(key);
    }

    public void getCities() {
        cityService.getCities();
    }

}
