package Civilizations;

import planet_all.Planet;

import java.util.Objects;

public abstract class Civilization {
    protected String race = "";
    protected Planet planet;
    protected int percentOfGlobalFreedom = 100;
    protected TypeCiv type;
    public Planet getPlanet() {
        return planet;
    }
    public String getRace(){
        return race;
    }
    public TypeCiv getType(){
        return type;
    }
    public int getPercentOfGlobalFreedom(){
        return percentOfGlobalFreedom;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Civilization that = (Civilization) o;
        return Objects.equals(race, that.race) && Objects.equals(planet, that.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(race, planet);
    }

    @Override
    public String toString() {
        return "Civilization{" +
                "race='" + race + '\'' +
                ", planet=" + planet +
                '}';
    }
}
