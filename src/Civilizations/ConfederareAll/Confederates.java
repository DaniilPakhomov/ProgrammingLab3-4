package Civilizations.ConfederareAll;

import java.util.ArrayList;

public class Confederates {
    protected static ArrayList<Confederate> confederateArrayList = new ArrayList<Confederate>();

    public static ArrayList<Confederate> getConfederateArrayList(){
        return confederateArrayList;
    }
    public static void setConfederateArrayListArrayList(Confederate confederate){
        confederateArrayList.add(confederate);
    }

    @Override
    public String toString() {
        return "Confederates{" + confederateArrayList.toString() + "}";
    }

}
