package core.city;

public class City {
    private final String name;
    private final String country;
    private final int population;

    public City(String name, String country, int population){
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public String toString(){
        if (population < 1000000){
            return "default city";
        } else {
            return "normally city";
        }
    }
}
