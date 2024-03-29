import java.lang.reflect.Modifier;

public abstract class Character {
    public Character() {
    }
    private String name;
    private int power;
    private Minions [ ] minions;
    private Weapons [ ] weapons;
    private Armor [ ] armor;
    private TCharacter type;
    private Modifiers modifiers;
    public int getPower() {
        return power;
    }
    public String getName() {
        return name;
    }

    public Minions[] getMinions() {
        return minions;
    }
    public Weapons getWeapons() {
        return Weapons;
    }

    public Armor[] getArmor() {
        return armor;
    }

    public TCharacter getType() {
        return type;
    }
    public SpecialAbility getSpecialAbilities() {
        return SpecialAbility;
    }
    public void setPower(int power) {
        this.power=power;
    }

    public void setName(String name) {
        this.name=name;
    }
    public void setMinions(Minions minion) {
        this.minion=Minions;
    }
    public void setWeapons(Weapons weapon) {
        this.weapon=Weapons;
    }

    public void setArmor(Armor armor) {
        this.armor=Armor;
    }

    public void setSpecialAbilities(SpecialAbility abilities) {
        this.abilities=SpecialAbility;
    }

    public Modifiers getModifiers() {
        return modifiers;
    }
    public void setModifiers(Modifiers modifiers) {
        this.modifiers= Modifiers;
    }

}