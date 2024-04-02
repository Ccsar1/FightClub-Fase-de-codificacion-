
import java.io.*;
import java.util.*;

public abstract class Minions {

    public Minions() {
    }
    private String name;
    private int hp;
    private TMinion minionType;
    public String getName() {
        return name;
    }
    public int getHP() {
        return hp;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setHP(int HP) {
     this.hp=hp;
    }
    public TMinion getMinionType() {
        return minionType;
    }
    public void setMinionType(TMinion minion) {
        this.minionType=TMinion;
    }

}