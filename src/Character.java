
import java.io.*;
import java.util.*;

/**
 *
 */
public abstract class Character {

    /**
     * Default constructor
     */
    public Character() {
    }

    /**
     *
     */
    private string name;

    /**
     *
     */
    private int  {1-5} power;

    /**
     *
     */
    private Minions [ ] minions;

    /**
     *
     */
    private Weapons [ ] weapons;

    /**
     *
     */
    private Armor [ ] armor;

    /**
     *
     */
    private TCharacter type;

    /**
     *
     */
    private Modifiers modifiers;

    /**
     * @return
     */
    public int getPower() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Minions getMinions() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Weapons getWeapons() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Armor getArmor() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public TCharacter getType() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public SpecialAbility getSpecialAbilities() {
        // TODO implement here
        return null;
    }

    /**
     * @param power
     */
    public void setPower(int power) {
        // TODO implement here
    }

    /**
     * @param name
     */
    public void setName(String name) {
        // TODO implement here
    }

    /**
     * @param minion
     */
    public void setMinions(Minions minion) {
        // TODO implement here
    }

    /**
     * @param weapon
     */
    public void setWeapons(Weapons weapon) {
        // TODO implement here
    }

    /**
     * @param armor
     */
    public void setArmor(Armor armor) {
        // TODO implement here
    }

    /**
     * @param abilities
     */
    public void setSpecialAbilities(SpecialAbility abilities) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Modifiers getModifiers() {
        // TODO implement here
        return null;
    }

    /**
     * @param modifiers
     */
    public void setModifiers(Modifiers modifiers) {
        // TODO implement here
    }

}