package core.svc.services.roomService;

import core.room.RoomImpl;

public interface RoomService {

    void saveData();
    void readData();

    boolean checkRoomKey(Integer key);

    void setRoom(int id, double width, double height, String name);
    void removeRoom(Integer key);
    RoomImpl getRoom(Integer key);
    void getRooms();

}
