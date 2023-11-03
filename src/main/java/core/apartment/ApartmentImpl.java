package core.apartment;

import core.city.City;
import core.room.Room;

import java.util.ArrayList;

/**
 * Класс ApartamentImpl, реализующий интерфейс Apartment
 */
public class ApartmentImpl implements Apartment {

    private final ArrayList<Room> roomList;
    private final City city;
    private final int price;
    private final String description;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param city        - city
     * @param description - description
     * @param price       - price
     * @see ApartmentImpl(int, String, String)
     */

    public ApartmentImpl(int price, String description, City city) {
        this.price = price;
        this.description = description;
        this.city = city;
        this.roomList = new ArrayList<Room>();
    }

    /**
     * Переопределение функции addRoom Apartment
     */
    @Override
    public void addRoom(Room room) {
        roomList.add(room);
    }

    /**
     * Переопределение функции removeRoom Apartment
     */
    @Override
    public void removeRoom(Room room) {
        roomList.remove(room);
    }

    @Override
    public double calculateArea() {
        double total = 0;
        for (var room: roomList) {
            total += room.calculateArea();
        }
        return total;
    }

    /**
     * Переопределение функции toString базового класса Object
     */
    public String toString() {
        return description +
                '\n' +
                this.calculateArea() +
                '\n' +
                city.toString();
    }
    /**
     * геттеры для работы с полями класса ApartmentImpl
     */
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
