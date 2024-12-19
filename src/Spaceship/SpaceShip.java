package Spaceship;


import java.util.Objects;

public class SpaceShip {
    protected int attack, shield, armor, speed;
    public SpaceShip(int money){
        this.attack = money / 3;
        this.armor = money / 3;
        this.shield = money / 3;
        this.speed = money / 3;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return armor + shield;
    }
    public int getArmor(){
        return armor;
    }

    public void setDefense(int damage) {
        if (damage >= armor + shield){
            armor = -1;
            shield = 0;
        }
        else {
            if (damage > shield){
                armor -= (damage - shield);
                shield = 0;
            }
            else{
                shield -= damage;
            }
        }
    }
    public void upgrade(int money){
        this.attack += money / 3;
        this.armor += money / 3;
        this.shield += money / 3;
        this.speed += money / 3;
    }
    protected void regenShields(){
        shield += 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceShip spaceShip = (SpaceShip) o;
        return attack == spaceShip.attack && shield == spaceShip.shield && armor == spaceShip.armor && speed == spaceShip.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attack, shield, armor, speed);
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "attack=" + attack +
                ", shield=" + shield +
                ", armor=" + armor +
                ", speed=" + speed +
                '}';
    }
}
