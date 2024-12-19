package Conquers;

import Civilizations.ConfederareAll.Confederates;
import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilization;
import Civilizations.ReptileAll.Reptiles;
import Civilizations.SpaceCivilization;
import Civilizations.TypeCiv;
import planet_all.Planet;

import java.util.Objects;

public class economicConquer implements Conquer{
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


    public static boolean isTheyBuyOff(SpaceCivilization attackCiv, Planet defenseCiv){
        PrimitiveCivilization primCiv = (PrimitiveCivilization) defenseCiv.getCivilization();;
        boolean control = false;



        if ((primCiv.getType() == TypeCiv.PRIMITIVE) && (attackCiv.getMoney() >= (primCiv.getPersentageOfReligion() * 500))) {
            System.out.println("Цивилизация " + attackCiv.getRace() + " купила цивилизацию " + defenseCiv.getCivilization().getRace());
            attackCiv.addSlaves(primCiv);
            control = true;
            if (primCiv.getGlobalFreedom() != 100) {
                boolean c = false;
                for (int i = 0; i < Reptiles.getReptileArrayList().size(); i++) {
                    if (Objects.equals(Reptiles.getReptileArrayList().get(i).getRace(), primCiv.getOwnersName())){
                        Reptiles.getReptileArrayList().get(i).loseSlaves(primCiv);
                        c = true;
                        break;
                    }

                }
                if (!c) {
                    for (int i = 0; i < Confederates.getConfederateArrayList().size(); i++) {
                        if (Objects.equals(Confederates.getConfederateArrayList().get(i).getRace(), primCiv.getOwnersName())){
                            Confederates.getConfederateArrayList().get(i).loseSlaves(primCiv);
                            break;
                        }
                    }
                }
            }
            primCiv.setGlobalFreedom();
            return true;
        }
        else {
            System.out.println("Цивилизация " + attackCiv.getRace() + " не смогла купить цивилизацию " + defenseCiv.getCivilization().getRace());
            return false;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        economicConquer that = (economicConquer) o;
        return Objects.equals(defenseCiv, that.defenseCiv) && Objects.equals(attackCiv, that.attackCiv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defenseCiv, attackCiv);
    }

    @Override
    public String toString() {
        return "economicConquer{" +
                "defenseCiv=" + defenseCiv +
                ", attackCiv=" + attackCiv +
                '}';
    }
}

