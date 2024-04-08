
import java.io.*;
import java.util.*;

public class Hunter extends Character {
    public Hunter(String name, int power, int hp, SpecialAbility specialAbility, int willpower) {
        super(name, power, hp, specialAbility, TCharacter.Hunter);
        this.willpower = willpower;
    }
    private int willpower;

    public int getWillpower() {
        return this.willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower=willpower;
    }

}


