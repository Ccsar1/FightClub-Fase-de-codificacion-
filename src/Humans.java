
import java.io.*;
import java.util.*;
public class Humans extends Minions {
    public Humans(String name, int hp, int loyalty) {
        super(name, hp, TMinion.Humans);
        switch (loyalty) {
            case 1:
                this.loyalty = TLoyalty.High;
                break;
            case 2:
                this.loyalty = TLoyalty.Normal;
                break;
            case 3:
                this.loyalty = TLoyalty.Low;
        }
    }
    private TLoyalty loyalty;
    public TLoyalty getLoyalty() {
        return this.loyalty;
    }
    public void setLoyalty(int loyalty) {
        switch (loyalty) {
            case 1:
                this.loyalty = TLoyalty.High;
                break;
            case 2:
                this.loyalty = TLoyalty.Normal;
                break;
            case 3:
                this.loyalty = TLoyalty.Low;
        }
    }
}