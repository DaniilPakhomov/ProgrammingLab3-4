package battle;

import planet_all.Planet;

import java.util.Objects;

public class Battle {
    protected Planet planet;

    @Override
    public String toString() {
        return "Battle{" +
                "planet=" + planet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battle battle = (Battle) o;
        return Objects.equals(planet, battle.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(planet);
    }
}
