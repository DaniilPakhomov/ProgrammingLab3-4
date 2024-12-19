package battle;

import Civilizations.ConfederareAll.Confederates;
import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilization;
import Civilizations.ReptileAll.Reptiles;
import Civilizations.SpaceCivilization;
import Civilizations.TypeCiv;
import planet_all.Planet;
import Spaceship.SpaceShip;

import java.util.ArrayList;
import java.util.Objects;

public class SpaceBattle extends Battle{
    protected ArrayList<SpaceShip> defenseSpace = new ArrayList<SpaceShip>();
    protected ArrayList<SpaceShip> attack = new ArrayList<SpaceShip>();
    PrimitiveCivilization primitiveOnPlanet;
    SpaceCivilization attackCiv = null;
    public SpaceBattle(SpaceCivilization attackCiv, Planet planet) throws NoPrimitiveCivilization {
        super.planet = planet;
        this.attack = attackCiv.getArmy();
        this.attackCiv = attackCiv;
        if (planet.getCivilization().getType() == TypeCiv.PRIMITIVE){
            primitiveOnPlanet = (PrimitiveCivilization) planet.getCivilization();
        }
        else {
            throw new NoPrimitiveCivilization(attackCiv.getRace() + " пытается атаковать космическую цивилизацию");
        }
        if (primitiveOnPlanet.getOwnersName() != null) {
            if (primitiveOnPlanet.getOwnersName().charAt(0) == 'R') {
                for (int i = 0; i < Reptiles.getReptileArrayList().size(); i++) {
                    if (Reptiles.getReptileArrayList().get(i).getSlaves().contains(primitiveOnPlanet)) {
                        defenseSpace = Reptiles.getReptileArrayList().get(i).getArmy();
                        break;
                    }
                }
            }
            else {
                for (int i = 0; i < Confederates.getConfederateArrayList().size(); i++) {
                    if (Confederates.getConfederateArrayList().get(i).getSlaves().contains(primitiveOnPlanet)) {
                        defenseSpace = Confederates.getConfederateArrayList().get(i).getArmy();
                        break;
                    }
                }
            }
        }
    }
    public int battle() throws NoPrimitiveCivilization{
        if ((defenseSpace.size() > 0) && (attack.size() > 0)){
            while ((attack.size() > 0) && (defenseSpace.size() > 0)){
                int allAttackDamage = 0, allDefenseDamage = 0;
                for (int i = 0; i < attack.size(); i++) {
                    allAttackDamage += attack.get(i).getAttack();
                }
                for (int i = 0; i < defenseSpace.size(); i++) {
                    defenseSpace.get(i).setDefense(allAttackDamage / defenseSpace.size());
                    if (defenseSpace.get(i).getArmor() < 0){
                        defenseSpace.remove(i);
                    }
                }
                for (int i = 0; i < defenseSpace.size(); i++) {
                    allDefenseDamage += defenseSpace.get(i).getAttack();
                }
                for (int i = 0; i < attack.size(); i++) {
                    attack.get(i).setDefense(allDefenseDamage / attack.size());
                    if (attack.get(i).getArmor() < 0){
                        attack.remove(i);
                    }
                }
            }
        }
        if (attack.size() > 0){
            if (primitiveOnPlanet == null){
                throw new NoPrimitiveCivilization(attackCiv.getRace() + " пытается атаковать космическую цивилизацию");
            }
                System.out.println("Цивилизация " + attackCiv.getRace() + " победила в космической битве при планете " + primitiveOnPlanet.getPlanet().getName());
                return 1;
        }
        else {
            System.out.println("Цивилизация " + attackCiv.getRace() + " потерпела поражение в космической битве при планете " + primitiveOnPlanet.getPlanet().getName());
            return 0;
        }
    }

    @Override
    public String toString() {
        return "SpaceBattle{" +
                "defenseSpace=" + defenseSpace +
                ", attack=" + attack +
                ", primitiveOnPlanet=" + primitiveOnPlanet +
                ", attackCiv=" + attackCiv +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpaceBattle that = (SpaceBattle) o;
        return Objects.equals(defenseSpace, that.defenseSpace) && Objects.equals(attack, that.attack) && Objects.equals(primitiveOnPlanet, that.primitiveOnPlanet) && Objects.equals(attackCiv, that.attackCiv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), defenseSpace, attack, primitiveOnPlanet, attackCiv);
    }

}
