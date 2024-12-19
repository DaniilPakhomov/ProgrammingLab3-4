package Civilizations.ReptileAll;

import Civilizations.SpaceCivilization;
import Civilizations.TypeCiv;
import planet_all.Planet;

public class Reptile extends SpaceCivilization {

    public Reptile(String name, Planet planet, int money){
        super(name, planet);
        super.money = money;
        super.type = TypeCiv.REPTILE;
    }
    public void upgradeSlaves(int moneyForUpgrade){
        for (int i = 0; i < slaves.size(); i++) {
            if (slaves.get(i).getStageOfScience() * slaves.get(i).howManyCities() * 100 <= moneyForUpgrade){
                slaves.get(i).setUpgrade(1);
                moneyForUpgrade -= slaves.get(i).getStageOfScience() * slaves.get(i).howManyCities() * 100;
            }
            if (moneyForUpgrade <= 100){
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "money=" + money +
                ", type=" + type +
                ", slaves=" + slaves +
                ", planetSlaves=" + planetSlaves +
                ", race='" + race + '\'' +
                ", planet=" + planet +
                '}';
    }
}
