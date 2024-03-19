
import java.io.*;
import java.util.*;

/**
 *
 */
public abstract class Minions {

    /**
     * Default constructor
     */
    public Minions() {
    }

    /**
     *
     */
    private String name;

    /**
     *
     */
    private int hp;

    /**
     *
     */
    private TMinion minionType;

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
    public int getHP() {
        // TODO implement here
        return 0;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        // TODO implement here
    }

    /**
     * @param HP
     */
    public void setHP(int HP) {
        // TODO implement here
    }

    /**
     * @return
     */
    public TMinion getMinionType() {
        // TODO implement here
        return null;
    }

    /**
     * @param minion
     */
    public void setMinionType(TMinion minion) {
        // TODO implement here
    }

}