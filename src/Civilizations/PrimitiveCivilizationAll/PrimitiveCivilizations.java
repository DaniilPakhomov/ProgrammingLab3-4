package Civilizations.PrimitiveCivilizationAll;


import java.util.ArrayList;

public class PrimitiveCivilizations {
    protected static ArrayList<PrimitiveCivilization> primitiveCivilizationList = new ArrayList<PrimitiveCivilization>();

    public static ArrayList<PrimitiveCivilization> getPrimitiveCivilizationArrayListArrayList() {
        return primitiveCivilizationList;
    }
    public static void setPlanetArrayList(PrimitiveCivilization primitiveCivilization){
        primitiveCivilizationList.add(primitiveCivilization);
    }
    public static void planetDestroy(PrimitiveCivilization primitiveCivilization){
        primitiveCivilizationList.remove(primitiveCivilization);

    }

    @Override
    public String toString() {
        return "PrimitiveCivilizations{" + primitiveCivilizationList.toString() + "}";
    }

}

