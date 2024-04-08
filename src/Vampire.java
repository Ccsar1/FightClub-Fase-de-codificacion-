
import java.io.*;
import java.util.*;

/**
 *
 */
public class Vampire extends Character {

    /**
     * Default constructor
     */
    public Vampire(String name, int power, int hp, SpecialAbility specialAbility, int age) {
        super(name, power, hp, specialAbility, TCharacter.Vampire);
        this.age = age;
    }

    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

}