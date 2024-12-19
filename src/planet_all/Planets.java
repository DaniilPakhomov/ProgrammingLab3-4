package planet_all;

import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilization;
import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilizations;

import java.util.ArrayList;

public class Planets {
    protected static ArrayList<Planet> planetArrayList = new ArrayList<Planet>();

    public static ArrayList<Planet> getPlanetArrayList() {
        return planetArrayList;
    }
    public static void setPlanetArrayList(Planet planet){
        planetArrayList.add(planet);
    }
    public static void planetDestroy(Planet planet){
        planetArrayList.remove(planet);
        PrimitiveCivilization primitiveCivilization = (PrimitiveCivilization) planet.getCivilization();
        PrimitiveCivilizations.planetDestroy(primitiveCivilization);
    }

    @Override
    public String toString() {
        return "Planets{" + planetArrayList + "}";
    }
}
