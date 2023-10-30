package core.apartment;

import core.room.Room;

public interface Apartment {
    void addRoom(Room room);
    void removeRoom(Room room);
    String toString();
}
