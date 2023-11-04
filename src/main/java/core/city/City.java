package core.city;

import core.apartment.ApartmentImpl;

import java.io.Serializable;

/**
 * Класс City
 */
public class City implements Serializable {
    private final String name;
    private final String country;
    private final int population;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name       - name
     * @param country    - country
     * @param population - population
     * @see City (String, String, int)
     */
    public City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    /**
     * геттеры для работы с полями класса ApartmentImpl
     */
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    /**
     * Переопределение функции toString базового класса Object
     */

    public String toString() {
        if (population < 1000000) {
            return name + ". Default city";
        } else {
            return name + ". Normally city";
        }
    }
}
