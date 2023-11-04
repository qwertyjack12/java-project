package core.svc.services.cityService;

import core.city.City;
import core.svc.Deserializator;
import core.svc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class CityServiceImpl implements CityService {

    private Hashtable<Integer, City> cityTable;
    private final String fileName = "src\\main\\java\\core\\usedFile\\City.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(cityTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.cityTable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.cityTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkCityKey(Integer key) {
        if (cityTable.containsKey(key)) {
            return true;
        } else {
            System.out.println("Wrong city key input!");
            return false;
        }
    }

    @Override
    public void setCity(int id, String name, String country, int population) {
        cityTable.put(id, new City(name, country, population));
    }

    @Override
    public City getCity(Integer key) {
        return cityTable.get(key);
    }

    @Override
    public void removeCity(Integer key) {
        if ((cityTable.size() != 0) & (cityTable.containsKey(key))) {
            cityTable.remove(key);
        }
    }

    @Override
    public void getCities() {
        System.out.println(cityTable);
    }
}
