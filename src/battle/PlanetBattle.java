package battle;

import CitiesDefense.CitiesDefense;
import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilization;
import Civilizations.SpaceCivilization;
import Civilizations.TypeCiv;
import planet_all.Planet;
import planet_all.Planets;
import Spaceship.SpaceShip;

import java.util.ArrayList;
import java.util.Objects;

public class PlanetBattle extends Battle{
    protected ArrayList<CitiesDefense> defense = new ArrayList<CitiesDefense>();
    protected ArrayList<SpaceShip> attack = new ArrayList<SpaceShip>();
    protected PrimitiveCivilization defenseCivilization;
    protected SpaceCivilization attackCivilization;
    public PlanetBattle(SpaceCivilization attack, Planet planet){
        super.planet = planet;
        this.attack = attack.getArmy();
        this.attackCivilization = attack;

        this.defenseCivilization = (PrimitiveCivilization) planet.getCivilization();
    }
    public int battle(){
        boolean canArmagedoning = false;
        int armagedonDamage = 0;
        for (int i = 0; i < attack.size(); i++) {
            armagedonDamage += attack.get(i).getAttack();
        }
        if ((armagedonDamage > 2000) && (attackCivilization.getType() == TypeCiv.CONFEDERATE)){
            canArmagedoning = true;
        }
        while ((attack.size() > 0) && (defense.size() > 0)){
            int allAttackDamage = 0, allDefenseDamage = 0;
            for (int i = 0; i < attack.size(); i++) {
                allAttackDamage += attack.get(i).getAttack();
            }
            for (int i = 0; i < defense.size(); i++) {
                defense.get(i).setDefense(allAttackDamage / defense.size());
                if (defense.get(i).getArmor() < 0){
                    defenseCivilization.setPeople();
                    defense.remove(i);
                    defenseCivilization.setCountCities();
                }
            }
            for (int i = 0; i < defense.size(); i++) {
                allDefenseDamage += defense.get(i).getAttack();
            }
            for (int i = 0; i < attack.size(); i++) {
                attack.get(i).setDefense(allDefenseDamage / attack.size());
                if (attack.get(i).getArmor() < 0){
                    attack.remove(i);
                }
            }
        }
        if (attack.size() > 0){
            System.out.println("Планета " + defenseCivilization.getPlanet().getName() + " захвачена цивилизацией " + attackCivilization.getRace());
            return 1;
        }
        else if (canArmagedoning){
            System.out.println("Планета " + defenseCivilization.getPlanet().getName() + " уничтожена цивилизацией " +  attackCivilization.getRace());
            Planets.planetDestroy(super.planet);
            return 0;
        }
        else {
            System.out.println("Планета " + defenseCivilization.getPlanet().getName() + " не захвачена цивилизацией " +  attackCivilization.getRace());
            return 0;
        }


    }

    @Override
    public String toString() {
        return "PlanetBattle{" +
                "defense=" + defense +
                ", attack=" + attack +
                ", defCiv=" + defenseCivilization +
                ", attackCiv=" + attackCivilization +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlanetBattle that = (PlanetBattle) o;
        return Objects.equals(defense, that.defense) && Objects.equals(attack, that.attack) && Objects.equals(defenseCivilization, that.defenseCivilization) && Objects.equals(attackCivilization, that.attackCivilization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), defense, attack, defenseCivilization, attackCivilization);
    }
}
