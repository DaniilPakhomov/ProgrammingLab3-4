package Conquers;

import Civilizations.ConfederareAll.Confederates;
import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilization;
import Civilizations.ReptileAll.Reptiles;
import Civilizations.SpaceCivilization;
import planet_all.Planet;

import java.util.Objects;

public class religionConquer implements Conquer{
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
    public static boolean canWeBecomeGods(SpaceCivilization attackCiv, Planet defenseCiv){
        PrimitiveCivilization primCiv = (PrimitiveCivilization) defenseCiv.getCivilization();



        if ((primCiv != null) && (attackCiv.getMoney() >= (primCiv.howManyCities() * 200) && (primCiv.getPersentageOfReligion() > 88))) {
            attackCiv.addSlaves(primCiv);
            System.out.println("Цивилизация " + attackCiv.getRace() + " стала богами для цивилизации " + defenseCiv.getCivilization().getRace());

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
            System.out.println("Цивилизация " + attackCiv.getRace() + " не смогла стать богами для цивилизации " + defenseCiv.getCivilization().getRace());
            return false;
        }

    }
}
