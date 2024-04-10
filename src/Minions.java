
import java.io.*;
import java.util.*;

public abstract class Minions implements Serializable {

    public Minions(String name, int hp, TMinion type) {
        this.name = name;
        this.hp = hp;
        this.type = type;
    }
    private String name;
    private int hp;
    private final TMinion type;
    public String getName() {
        return this.name;
    }
    public int getHP() {
        return this.hp;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setHP(int hp) {
     this.hp=hp;
    }
    public TMinion getType() {
        return this.type;
    }
}