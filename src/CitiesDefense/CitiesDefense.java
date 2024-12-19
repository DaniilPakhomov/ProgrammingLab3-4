package CitiesDefense;

public class CitiesDefense {
    protected int attack, armor;
    public CitiesDefense(int power){
        this.attack = power / 2;
        this.armor = power / 2;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return armor;
    }
    public int getArmor(){
        return armor;
    }

    public void setDefense(int damage) {
        if (damage >= armor){
            armor = -1;
        }
        else {
            armor -= damage;
        }

    }
}
