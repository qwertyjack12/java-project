package core.svc.services.apatmentService;

import core.apartment.ApartmentImpl;
import core.city.City;
import core.room.Room;
import core.room.RoomImpl;

public interface ApartmentService {
    void saveData();
    void readData();
    boolean checkApartmentKey(Integer key);

    void setApartment(int key, int price, String description, City city);
    ApartmentImpl getApartment(Integer key);
    void getApartments();

    void addRoom(Integer key, RoomImpl room);
    void removeRoom(Integer key, RoomImpl room);
    void getArea(Integer key);
}
