package core.apartment;

import core.room.Room;

/**
 * Интерфейс для работы с классом ApartamentImpl
 *
 * @version 1.0
 * */
public interface Apartment {
    /**
     * Функция добавляющая Room
     */
    void addRoom(Room room);
    /**
     * Функция удаления Room
     */
    void removeRoom(Room room);
}
