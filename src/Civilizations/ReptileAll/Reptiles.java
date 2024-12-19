package Civilizations.ReptileAll;

import java.util.ArrayList;

public class Reptiles {
    protected static ArrayList<Reptile> reptileArrayList = new ArrayList<Reptile>();

    public static ArrayList<Reptile> getReptileArrayList(){
        return reptileArrayList;
    }
    public static void setReptileArrayList(Reptile reptile){
        reptileArrayList.add(reptile);
    }

    @Override
    public String toString() {
        return "Reptiles{" + reptileArrayList.toString() + "}";
    }
}
