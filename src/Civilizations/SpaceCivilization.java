package Civilizations;

import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilization;
import planet_all.Planet;
import planet_all.Planets;
import Spaceship.SpaceShip;

import java.util.ArrayList;
import java.util.Objects;


public class SpaceCivilization extends Civilization{
    protected int patient, money;
    ArrayList<SpaceShip> army = new ArrayList<SpaceShip>();
    protected TypeCiv type;
    protected ArrayList<PrimitiveCivilization> slaves = new ArrayList<PrimitiveCivilization>();
    protected ArrayList<Planet> planetSlaves = new ArrayList<Planet>();
    public SpaceCivilization(String name, Planet planet){
        super.race = name;
        super.planet = planet;
    }
    public ArrayList<Planet> getPlanetSlaves(){
        return planetSlaves;
    }
    public ArrayList<PrimitiveCivilization> getSlaves(){
        return this.slaves;
    }
    public int getMoney(){
        return this.money;
    }
    public void addSlaves(PrimitiveCivilization race){
        this.slaves.add(race);
        race.setOwnersName(this.race);
        this.planetSlaves.add(race.getPlanet());
    }
    public void loseSlaves(PrimitiveCivilization race){
        slaves.remove(race);
    }
    public void createArmy(int moneyForWar, SpaceCivilization race){
        System.out.println("Цивилизация " + race.getRace() + " обновляет армию");
        race.money -= moneyForWar;
        for (int i = 0; i < (100 - race.getArmy().size()); ++i){
            race.getArmy().add(new SpaceShip(moneyForWar / 100));
        }
    }
    public void upgradeArmy(int money, int percentOfArmy, SpaceCivilization race){
        System.out.println("Цивилизация " + race.getRace() + " улучшает армию");
        this.money -= money;
        for (int i = 0; i < percentOfArmy/ 100 * race.getArmy().size(); ++i){
            race.getArmy().get(i).upgrade(money / percentOfArmy/ 100 * race.getArmy().size());
        }
    }
    public Planet findFreePlanet(){
        for (int i = 0; i < Planets.getPlanetArrayList().size(); ++i){
            if ((Planets.getPlanetArrayList().get(i).getCivilization() != null) && ((Planets.getPlanetArrayList().get(i).getCivilization().getType() == TypeCiv.PRIMITIVE) && (Planets.getPlanetArrayList().get(i).getCivilization().getPercentOfGlobalFreedom() == 100)))
                {
                    return Planets.getPlanetArrayList().get(i);
                }

        }
        return null;
    }
    public void getIncome(){
        for (int i = 0; i < slaves.size(); i++) {
            this.money += slaves.get(i).getProfitOfUsage();
        }
    }
    public ArrayList<SpaceShip> getArmy(){
        return army;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpaceCivilization that = (SpaceCivilization) o;
        return patient == that.patient && money == that.money && Objects.equals(army, that.army) && type == that.type && Objects.equals(slaves, that.slaves) && Objects.equals(planetSlaves, that.planetSlaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), patient, money, army, type, slaves, planetSlaves);
    }

    @Override
    public String toString() {
        return "SpaceCivilization{" +
                "patient=" + patient +
                ", money=" + money +
                ", army=" + army +
                ", type=" + type +
                ", slaves=" + slaves +
                ", planetSlaves=" + planetSlaves +
                '}';
    }
}
