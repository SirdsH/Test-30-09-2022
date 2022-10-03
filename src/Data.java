public class Data {
    private String name;
    private String continent;
    private long population;
    private long gdp;

    public Data(String name, String continent, long population, long gdp) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.gdp = gdp;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public long getPopulation() {
        return population;
    }

    public long getGdp() {
        return gdp;
    }
}
