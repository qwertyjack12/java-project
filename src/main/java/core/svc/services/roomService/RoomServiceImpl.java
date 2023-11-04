package core.svc.services.roomService;

import core.room.RoomImpl;
import core.svc.Deserializator;
import core.svc.Serializator;


import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class RoomServiceImpl implements RoomService {

    private Hashtable<Integer, RoomImpl> roomTable;
    private final String fileName = "src\\main\\java\\core\\usedFile\\Room.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(roomTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.roomTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.roomTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkRoomKey(Integer key) {
        if (roomTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong room key input!");
            return false;
        }
    }

    @Override
    public void setRoom(int id, double width, double height, String name) {
        roomTable.put(id, new RoomImpl(width, height, name));
    }

    @Override
    public void removeRoom(Integer key) {
        if ((roomTable.size() != 0) & (roomTable.containsKey(key))) {
            roomTable.remove(key);
        }
    }

    @Override
    public RoomImpl getRoom(Integer key) {
        return roomTable.get(key);
    }

    @Override
    public void getRooms() {
        System.out.println(roomTable);
    }
}
