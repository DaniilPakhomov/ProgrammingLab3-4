package Civilizations.PrimitiveCivilizationAll;


import CitiesDefense.CitiesDefense;
import Civilizations.Civilization;
import Civilizations.TypeCiv;
import planet_all.Planet;

import java.util.ArrayList;
import java.util.Objects;

public class PrimitiveCivilization extends Civilization {
    protected int stageOfScience, freedom, persentageReligion, people, countCities;
    protected String owner = null;
    //protected SpaceCivilization owner = null;


    public PrimitiveCivilization(String name, Planet planet, int stageOfScience, int freedom, int globalFreedom, int persentageReligion, int people) {
        super.race = name;
        super.planet = planet;
        this.stageOfScience = stageOfScience;
        this.freedom = freedom;
        super.percentOfGlobalFreedom = globalFreedom;
        this.persentageReligion = new PercentageOfReligion(persentageReligion).percentageOfReligion();
        this.people = people;
        super.type = TypeCiv.PRIMITIVE;
        if (people > 500_000){
            countCities = people / 500000;
        }
        else {
            countCities = 1;
        }

    }
    public void setGlobalFreedom(){
        super.percentOfGlobalFreedom = 50;
    }
    public int getProfitOfUsage(){
            int profit = (freedom / 100) * (people / 200) * (stageOfScience + 1);
            if (planet.getCountRecourses() >= profit) {
                planet.setRecourses(profit);
                return profit;
            }
            else {
                System.out.println("На планете " + planet.getName() + " закончились ресурсы");
                if (planet.getCountRecourses() > 0){
                    return planet.getCountRecourses();
                }
                else {
                    return 0;
                }
            }
    }
    public void setOwnersName(String owner){
        this.owner = owner;
    }
    public String getOwnersName(){
        return this.owner;
    }
    public int getPersentageOfReligion(){
        return persentageReligion;
    }
    public TypeCiv getType(){
        return type;
    }
    public void setUpgrade(int upgrade){
        this.stageOfScience += 1;
        this.people += 100_000;
    }
    public int howManyCities(){
        return countCities;
    }
    public int getStageOfScience(){
        return stageOfScience;
    }
    public int getGlobalFreedom(){return super.percentOfGlobalFreedom;}
    public ArrayList<CitiesDefense> citiesBecomeDefense(){
        ArrayList<CitiesDefense> defenseCity = new ArrayList<>();
        for (int i = 0; i < countCities; i++) {
            defenseCity.add(new CitiesDefense(people / 1000 * stageOfScience));
        }
        return defenseCity;
    }
    public String getRace(){
        return super.race;
    }
    public void setPeople(){
        this.people -= people / countCities;
    }
    public void setCountCities(){
        this.countCities -= 1;
    }

    @Override
    public String toString() {
        return "PrimitiveCivilization{" +
                "stageOfScience=" + stageOfScience +
                ", freedom=" + freedom +
                ", religion=" + persentageReligion +
                ", people=" + people +
                ", countCities=" + countCities +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrimitiveCivilization that = (PrimitiveCivilization) o;
        return stageOfScience == that.stageOfScience && freedom == that.freedom && persentageReligion == that.persentageReligion && people == that.people && countCities == that.countCities && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stageOfScience, freedom, persentageReligion, people, countCities, owner);
    }
}
record PercentageOfReligion(int percentageOfReligion) {}
