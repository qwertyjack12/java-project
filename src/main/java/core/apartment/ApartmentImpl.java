package core.apartment;

import core.city.City;
import core.room.Room;

import java.util.ArrayList;

public class ApartmentImpl implements Apartment {

    private final ArrayList<Room> roomList;
    private final City city;
    private final int price;
    private final String description;

    public ApartmentImpl(int price, String description, City city){
        this.price = price;
        this.description = description;
        this.city = city;
        this.roomList = new ArrayList<Room>();
    }

    @Override
    public void addRoom(Room room) {
        roomList.add(room);
    }

    @Override
    public void removeRoom(Room room) {
        roomList.remove(room);
    }

    @Override
    public String toString(){
        return description +
                '\n' +
                city.toString();
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getCity() {
        return city.getName();
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }
}
