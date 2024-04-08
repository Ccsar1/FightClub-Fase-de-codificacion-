import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class Character {
    public Character(String name, int power, int hp, SpecialAbility specialAbility, TCharacter type) {
        this.name = name;
        this.power = power;
        this.hp = hp;
        this.specialAbility = specialAbility;
        this.type = type;
        this.minions = new ArrayList<>();
        this.weapons = new ArrayList<>();
        this.armor = new ArrayList<>();
        this.strengths = new ArrayList<>();
        this.weaknesses = new ArrayList<>();
    }
    private String name;
    private int power;
    private ArrayList<Minions> minions;
    private ArrayList<Weapons> weapons;
    private ArrayList<Armor> armor;
    private TCharacter type;
    private ArrayList<Strengths> strengths;
    private ArrayList<Weaknesses> weaknesses;
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

    public ArrayList<Weaknesses> getWeaknesses() {
        return this.weaknesses;
    }
    public ArrayList<Strengths> getStrengths() {
        return this.strengths;
    }
    public void setWeaknesses(Weaknesses weakness) {
        this.weaknesses.add(weakness);
    }
    public void setStrengths(Strengths strength) {
        this.strengths.add(strength);
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
}