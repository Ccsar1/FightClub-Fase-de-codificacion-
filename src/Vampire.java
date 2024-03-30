
import java.io.*;
import java.util.*;

/**
 *
 */
public class Vampire extends Character {

    /**
     * Default constructor
     */
    public Vampire() {
    }

    /**
     *
     */
    private int blood = 0;

    /**
     *
     */
    private int age;

    /**
     *
     */
    private Disciplines vampireAbility;

    /**
     * @return
     */
    public boolean checkHumanMinion() {
        return (Minions.getMinionType() == Humans);
    }

    /**
     * @return
     */
    public int getBlood() {
        return this.blood;
    }

    /**
     * @param blood
     */
    public void setBlood(int blood) {
        if (blood > 10) {
            this.blood = 10;
        } else if (blood < 0) {
            this.blood = 0;
        } else{
            this.blood = blood;
        }
    }

}