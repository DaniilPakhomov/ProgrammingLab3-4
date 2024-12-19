package Conquers;

import Civilizations.ConfederareAll.Confederates;
import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilization;
import Civilizations.ReptileAll.Reptiles;
import Civilizations.SpaceCivilization;
import planet_all.Planet;
import battle.NoPrimitiveCivilization;
import battle.PlanetBattle;
import battle.SpaceBattle;

import java.util.Objects;

public class AttackConquer implements Conquer{
    protected Planet defenseCiv;
    protected SpaceCivilization attackCiv;


    @Override
    public Planet getDefenseCivil(){
        return defenseCiv;
    }
    @Override
    public SpaceCivilization getAttackCivil(){
        return attackCiv;
    }
    public static void war(SpaceCivilization attackCiv, Planet defenseCiv){
        try {
            SpaceBattle spaceConflict = new SpaceBattle(attackCiv, defenseCiv);
            if (spaceConflict.battle() == 1) {
                PrimitiveCivilization primitiveCivilization = (PrimitiveCivilization) defenseCiv.getCivilization();
                PlanetBattle planetConfilct = new PlanetBattle(attackCiv, defenseCiv);
                if (planetConfilct.battle() == 1) {
                    for (int i = 0; i < Reptiles.getReptileArrayList().size(); i++) {

                        if (Objects.equals(Reptiles.getReptileArrayList().get(i).getRace(), primitiveCivilization.getOwnersName())){
                            Reptiles.getReptileArrayList().get(i).loseSlaves(primitiveCivilization);
                        }
                    }
                    for (int i = 0; i < Confederates.getConfederateArrayList().size(); i++) {
                        if (Objects.equals(Confederates.getConfederateArrayList().get(i).getRace(), primitiveCivilization.getOwnersName())){
                            Confederates.getConfederateArrayList().get(i).loseSlaves(primitiveCivilization);
                        }
                    }
                    attackCiv.addSlaves(primitiveCivilization);
                    primitiveCivilization.setGlobalFreedom();
                }
            }
        }
        catch (NoPrimitiveCivilization ex){
            System.out.println(attackCiv.getRace() + " пытается атаковать другую космическую цивилизацию");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttackConquer that = (AttackConquer) o;
        return Objects.equals(defenseCiv, that.defenseCiv) && Objects.equals(attackCiv, that.attackCiv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defenseCiv, attackCiv);
    }

    @Override
    public String toString() {
        return "AttackConquer{" +
                "defenseCiv=" + defenseCiv +
                ", attackCiv=" + attackCiv +
                '}';
    }
}
