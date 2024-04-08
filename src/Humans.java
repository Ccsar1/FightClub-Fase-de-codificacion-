
import java.io.*;
import java.util.*;
public class Humans extends Minions {
    public Humans(String name, int hp, TLoyalty loyalty) {
        super(name, hp, TMinion.Humans);
        this.loyalty = loyalty;
    }
    private TLoyalty loyalty;
    public TLoyalty getLoyalty() {
        return loyalty;
    }
    public void setLoyalty(TLoyalty loyalty) {
        this.loyalty=loyalty;
    }

}