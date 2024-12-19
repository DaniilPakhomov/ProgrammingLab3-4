package planet_all;

import Civilizations.Civilization;

import java.util.Objects;

public class Planet {
    protected String name;
    protected Civilization civilization;
    protected int recourses;
    public Planet(String name, String isCivilization, int recources){
        this.name = name;
        this.recourses = recources;
    }
    public int getCountRecourses(){
        return recourses;
    }
    public void setCivilization(Civilization civilization){
        this.civilization = civilization;
    }
    public Civilization getCivilization(){
        return civilization;
    }

    public void setRecourses(int recourses) {
        this.recourses = this.recourses - recourses;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return recourses == planet.recourses && Objects.equals(name, planet.name) && Objects.equals(civilization, planet.civilization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, civilization, recourses);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", isCivilization='" + civilization + '\'' +
                ", recourses=" + recourses +
                '}';
    }
}
