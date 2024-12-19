import Civilizations.ConfederareAll.Confederate;
import Civilizations.ConfederareAll.Confederates;
import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilization;
import Civilizations.PrimitiveCivilizationAll.PrimitiveCivilizations;
import Civilizations.ReptileAll.Reptile;
import Civilizations.ReptileAll.Reptiles;
import Civilizations.TypeCiv;
import Conquers.AttackConquer;
import planet_all.Planet;
import planet_all.Planets;
import Conquers.economicConquer;
import Conquers.religionConquer;
import java.lang.Math;

import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Planets.setPlanetArrayList(new Planet("Земля1", "Igo", 300000));
        Planets.setPlanetArrayList(new Planet("Земля2", "Igi", 300000));
        Planets.setPlanetArrayList(new Planet("Нептун1", "Красные", 300000));
        Planets.setPlanetArrayList(new Planet("Нептун2", "Серые", 300000));
        Planets.setPlanetArrayList(new Planet("Юпитер3", "австралопитеки3", 300000));
        Planets.setPlanetArrayList(new Planet("Юпитер2", "австралопитеки2", 300000));
        Planets.setPlanetArrayList(new Planet("Юпитер1", "австралопитеки1", 300000));
        Planets.setPlanetArrayList(new Planet("Марс", "питеки", 300000));

        Reptiles.setReptileArrayList(new Reptile("Igo", Planets.getPlanetArrayList().get(0), 30000));
        Reptiles.setReptileArrayList(new Reptile("Igi", Planets.getPlanetArrayList().get(1), 30000));
        Confederates.setConfederateArrayListArrayList(new Confederate("Красные", Planets.getPlanetArrayList().get(2), 30000));
        Confederates.setConfederateArrayListArrayList(new Confederate("Серые", Planets.getPlanetArrayList().get(3), 30000));
        PrimitiveCivilizations.setPlanetArrayList(new PrimitiveCivilization("питеки", Planets.getPlanetArrayList().get(7), 3, 100, 100, 50, 1_000_000));
        PrimitiveCivilizations.setPlanetArrayList(new PrimitiveCivilization("австралопитеки1", Planets.getPlanetArrayList().get(6), 2, 100, 100, 60, 600_000));
        PrimitiveCivilizations.setPlanetArrayList(new PrimitiveCivilization("австралопитеки2", Planets.getPlanetArrayList().get(5), 2, 100, 100, 60, 1_000_000));
        PrimitiveCivilizations.setPlanetArrayList(new PrimitiveCivilization("австралопитеки3", Planets.getPlanetArrayList().get(4), 2, 100, 100, 60, 600_000));
        Planets.getPlanetArrayList().get(0).setCivilization(Reptiles.getReptileArrayList().get(0));
        Planets.getPlanetArrayList().get(1).setCivilization(Reptiles.getReptileArrayList().get(1));
        Planets.getPlanetArrayList().get(2).setCivilization(Confederates.getConfederateArrayList().get(0));
        Planets.getPlanetArrayList().get(3).setCivilization(Confederates.getConfederateArrayList().get(1));
        Planets.getPlanetArrayList().get(4).setCivilization(PrimitiveCivilizations.getPrimitiveCivilizationArrayListArrayList().get(0));
        Planets.getPlanetArrayList().get(5).setCivilization(PrimitiveCivilizations.getPrimitiveCivilizationArrayListArrayList().get(1));
        Planets.getPlanetArrayList().get(6).setCivilization(PrimitiveCivilizations.getPrimitiveCivilizationArrayListArrayList().get(2));
        Planets.getPlanetArrayList().get(7).setCivilization(PrimitiveCivilizations.getPrimitiveCivilizationArrayListArrayList().get(3));


        for (int time = 0; time < 10; time++) {
            System.out.println((time + 1) + " год");
            int numOfPlanet = (int) Math.round(Math.random() * Planets.getPlanetArrayList().size());
            for (int i = 0; i < Reptiles.getReptileArrayList().size(); i++) {
                Reptile active = Reptiles.getReptileArrayList().get(i);
                Planet planet = null;
                for (int j = 0; j < Planets.getPlanetArrayList().size(); j++) {
                    if ((Objects.equals(Planets.getPlanetArrayList().get(j), active.findFreePlanet()) && (!active.getPlanetSlaves().contains(Planets.getPlanetArrayList().get(j))))) {
                        planet = Planets.getPlanetArrayList().get(j);
                    }
                }


                active.createArmy(active.getMoney() / 10, active);
                if ((planet != null) && (planet.getCivilization() != null) && (active.findFreePlanet() != null)) {


                        if (!religionConquer.canWeBecomeGods(active, planet)) {
                            if (!economicConquer.isTheyBuyOff(active, planet)) {
                                AttackConquer.war(active, planet);
                            }
                        }
                    } else {
                        for (int j = 0; j < Planets.getPlanetArrayList().size(); j++) {
                            //System.out.println(Planets.getPlanetArrayList().get(j).getName());
                            //System.out.println(((!Objects.equals(Planets.getPlanetArrayList().get(j).getIsCivilization(), "NO")) && ((!Objects.equals(Planets.getPlanetArrayList().get(j).getName(), active.getNameOfPlanet()))) && ((!(active.getPlanetSlaves().contains(Planets.getPlanetArrayList().get(j).getName()))))));
                            //System.out.println(j);
                            if (Planets.getPlanetArrayList().get(j).getCivilization().getType() == TypeCiv.PRIMITIVE) {
                                PrimitiveCivilization now = (PrimitiveCivilization) Planets.getPlanetArrayList().get(j).getCivilization();
                                if ((Planets.getPlanetArrayList().get(j).getCivilization() != null) && (Planets.getPlanetArrayList().get(j).getCivilization().getType() == TypeCiv.PRIMITIVE) && (((!Objects.equals(active.getRace(), now.getOwnersName()))))) {
                                    AttackConquer.war(active, Planets.getPlanetArrayList().get(j));
                                    break;
                                }
                            }
                        }
                    }

                active.upgradeSlaves(active.getMoney() / 15);
                active.getIncome();
                active.upgradeArmy(active.getMoney() / 15, 30, active);


            }
//            System.out.println("Рептилии1 " + Reptiles.getReptileArrayList().get(0).getNameOfPlanet());
//            for (int i = 0; i < Reptiles.getReptileArrayList().get(0).getSlaves().size(); i++) {
//                System.out.print(Reptiles.getReptileArrayList().get(0).getSlaves().get(i).getRace() + " ");
//            }
//            System.out.println();
//            System.out.println("Рептилии2 " + Reptiles.getReptileArrayList().get(1).getNameOfPlanet());
//            for (int i = 0; i < Reptiles.getReptileArrayList().get(1).getSlaves().size(); i++) {
//                System.out.print(Reptiles.getReptileArrayList().get(1).getSlaves().get(i).getRace() + " ");
//            }
//            System.out.println(1);

            for (int i = 0; i < Confederates.getConfederateArrayList().size(); i++) {
                Confederate active = Confederates.getConfederateArrayList().get(i);
                Planet planet = null;
                for (int j = 0; j < Planets.getPlanetArrayList().size(); j++) {
                    if ((Objects.equals(Planets.getPlanetArrayList().get(j), active.findFreePlanet()) && (!active.getPlanetSlaves().contains(Planets.getPlanetArrayList().get(j))))) {
                        planet = Planets.getPlanetArrayList().get(j);
                    }
                }
                numOfPlanet = (int) Math.round(Math.random() * Planets.getPlanetArrayList().size());
                active.createArmy(active.getMoney() / 10, active);
                if (((planet != null) && (planet.getCivilization() != null) && (active.findFreePlanet() != null))) {

                    if (!religionConquer.canWeBecomeGods(active, planet)) {
                        if (!economicConquer.isTheyBuyOff(active, planet)) {
                            AttackConquer.war(active, planet);
                        }
                    }
                } else {
                    for (int j = numOfPlanet; j < Planets.getPlanetArrayList().size(); j++) {
//                        System.out.println(Planets.getPlanetArrayList().get(j).getName());
//                        System.out.println(((!Objects.equals(Planets.getPlanetArrayList().get(j).getIsCivilization(), "NO")) && ((!Objects.equals(Planets.getPlanetArrayList().get(j).getName(), active.getNameOfPlanet()))) && ((!(active.getPlanetSlaves().contains(Planets.getPlanetArrayList().get(j).getName()))))));
//                        System.out.println(j);
                        if (Planets.getPlanetArrayList().get(j).getCivilization().getType() == TypeCiv.PRIMITIVE) {
                            PrimitiveCivilization now = (PrimitiveCivilization) Planets.getPlanetArrayList().get(j).getCivilization();
                            if ((Planets.getPlanetArrayList().get(j).getCivilization() != null) && (Planets.getPlanetArrayList().get(j).getCivilization().getType() == TypeCiv.PRIMITIVE) && (((!Objects.equals(active.getRace(), now.getOwnersName()))))) {
                                AttackConquer.war(active, Planets.getPlanetArrayList().get(j));
                                break;
                            }
                        }
                    }
                }

                active.getIncome();
                active.upgradeArmy(active.getMoney() / 15, 30, active);


            }

            for (int i = 0; i < Reptiles.getReptileArrayList().size(); i++) {
                System.out.print("Подчинённые цивилизации " + Reptiles.getReptileArrayList().get(i).getRace() + ": ");
                for (int j = 0; j < Reptiles.getReptileArrayList().get(i).getSlaves().size(); j++) {
                    System.out.print(Reptiles.getReptileArrayList().get(i).getSlaves().get(j).getRace() + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < Confederates.getConfederateArrayList().size(); i++) {
                System.out.print("Подчинённые цивилизации " + Confederates.getConfederateArrayList().get(i).getRace() + ": ");
                for (int j = 0; j < Confederates.getConfederateArrayList().get(i).getSlaves().size(); j++) {
                    System.out.print(Confederates.getConfederateArrayList().get(i).getSlaves().get(j).getRace() + " ");
                }
                System.out.println();
            }

        }
    }
    }
