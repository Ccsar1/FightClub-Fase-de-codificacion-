
import java.io.*;
import java.util.*;

/**
 *
 */
public abstract class SpecialAbility {

    /**
     * Default constructor
     */
    public SpecialAbility() {
    }

    /**
     *
     */
    private String name;

    /**
     *
     */
    private int attackValue;

    /**
     *
     */
    private int defenceValue;

    /**
     *
     */
    private TAbility typeAbility;

    /**
     * @return
     */
    public int getAttackValue() {
        // TODO implement here
        return 0;
    }

    /**
     * @param attack
     */
    public void setAttackValue(int attack) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getDefenceValue() {
        // TODO implement here
        return 0;
    }

    /**
     * @param defence
     */
    public void setDefenceValue(int defence) {
        // TODO implement here
    }

    /**
     * @return
     */
    public TAbility getTypeAbility() {
        // TODO implement here
        return null;
    }

}