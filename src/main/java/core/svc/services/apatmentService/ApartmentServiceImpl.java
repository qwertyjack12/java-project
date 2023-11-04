package core.svc.services.apatmentService;

import core.apartment.ApartmentImpl;
import core.city.City;
import core.room.RoomImpl;
import core.svc.Deserializator;
import core.svc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class ApartmentServiceImpl implements ApartmentService {

    private Hashtable<Integer, ApartmentImpl> apartmentTable;
    private final String fileName = "src\\main\\java\\core\\usedFile\\Apartment.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(apartmentTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.apartmentTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.apartmentTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkApartmentKey(Integer key) {
        if (apartmentTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong discipline key input!");
            return false;
        }
    }

    @Override
    public void setApartment(int key, int price, String description, City city) {

        apartmentTable.put(key, new ApartmentImpl(price, description, city));
    }

    @Override
    public ApartmentImpl getApartment(Integer key) {
        return apartmentTable.get(key);
    }

    @Override
    public void getApartments() {
        System.out.println(apartmentTable);
    }

    @Override
    public void addRoom(Integer key, RoomImpl room) {
        apartmentTable.get(key).addRoom(room);
    }

    @Override
    public void removeRoom(Integer key, RoomImpl room) {
        apartmentTable.get(key).removeRoom(room);
    }

    @Override
    public void getArea(Integer key) {
        System.out.println(apartmentTable.get(key).calculateArea());
    }
}
