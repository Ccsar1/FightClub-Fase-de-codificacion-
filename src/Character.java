import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class Character implements Serializable {
    public Character(String name, int power, int hp, SpecialAbility specialAbility, TCharacter type) {
        this.name = name;
        this.power = power;
        this.hp = hp;
        this.specialAbility = specialAbility;
        this.type = type;
        this.minions = new ArrayList<>();
        this.weapons = new ArrayList<>();
        this.armor = new ArrayList<>();
        this.modifiers = new ArrayList<>();
    }
    private String name;
    private int power;
    private ArrayList<Minions> minions;
    private ArrayList<Weapons> weapons;
    private ArrayList<Armor> armor;
    private TCharacter type;
    private ArrayList<ModifierValue> modifiers;
    private SpecialAbility specialAbility;
    private int hp;
    public int getPower() {
        return power;
    }
    public String getName() {
        return name;
    }

    public ArrayList<Minions> getMinions() {
        return minions;
    }

    public void removeMinion(Minions minion) {
        boolean b = true;
        do {
            b = this.minions.remove(minion);
        } while (b);
    }

    public ArrayList<Weapons> getWeapons() {
        return this.weapons;
    }

    public ArrayList<Armor> getArmor() {
        return this.armor;
    }

    public TCharacter getType() {
        return type;
    }
    public SpecialAbility getSpecialAbilities() {
        return this.specialAbility;
    }
    public void setPower(int power) {
        this.power=power;
    }

    public void setName(String name) {
        this.name=name;
    }
    public void setMinions(Minions minion) {
        this.minions.add(minion);
    }
    public void setWeapons(Weapons weapon) {
        this.weapons.add(weapon);
    }

    public void setArmor(Armor armor) {
        this.armor.add(armor);
    }

    public void setSpecialAbilities(SpecialAbility abilities) {
        this.specialAbility=abilities;
    }

    public int getHp() {
        return this.hp;
    }
    public int getMinionHP() {
        int totalSum = 0;
        for (Minions minion : minions) {
            totalSum += minion.getHP();
        }
        return totalSum;
    }

    public void setHP(int newHP) {
        this.hp = newHP;
    }

    public ArrayList<ModifierValue> getModifiers() {
        return this.modifiers;
    }
}