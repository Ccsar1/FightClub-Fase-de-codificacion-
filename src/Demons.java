
import java.io.*;
import java.util.*;

public class Demons extends Minions {


    public Demons(String name, int hp, String pact) {
        super(name, hp, TMinion.Demons);
        this.pact = pact;
        minions = new ArrayList<>();
    }
    private String pact;
    private ArrayList<Minions> minions;
    public String getPact() {
        return this.pact;
    }
    public void setPact(String pact) {
        this.pact=pact;
    }
    public void setMinion(Minions minion) {
        this.minions.add(minion);
    }
    public ArrayList<Minions> getMinions() {
        return minions;
    }

    public void removeMinion(Minions minion) {
        boolean b = true;
        do {
            b = this.minions.remove(minion);
        } while (b);
    }

    @Override
    public int getHP() {
        int totalSum = 0;
        for (Minions minion : minions) {
            totalSum += minion.getHP();
        }
        totalSum += super.getHP();
        return totalSum;
    }
}