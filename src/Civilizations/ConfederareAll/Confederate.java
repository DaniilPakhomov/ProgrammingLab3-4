package Civilizations.ConfederareAll;

import Civilizations.SpaceCivilization;
import Civilizations.TypeCiv;
import planet_all.Planet;

public class Confederate extends SpaceCivilization {
    public Confederate(String name, Planet planet, int money){
        super(name, planet);
        super.money = money;
        super.type = TypeCiv.CONFEDERATE;
    }

    @Override
    public String toString() {
        return "Confederate{" +
                "money=" + money +
                ", type=" + type +
                ", slaves=" + slaves +
                ", planetSlaves=" + planetSlaves +
                ", race='" + race + '\'' +
                ", planet=" + planet +
                '}';
    }

}
