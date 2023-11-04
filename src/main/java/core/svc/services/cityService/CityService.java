package core.svc.services.cityService;

import core.city.City;

public interface CityService {

    void saveData();
    void readData();
    boolean checkCityKey(Integer key);

    void setCity(int id, String name, String country, int population);
    City getCity(Integer key);
    void removeCity(Integer key);
    void getCities();

}
