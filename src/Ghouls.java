
import java.io.*;
import java.util.*;

public class Ghouls extends Minions {
    public Ghouls(String name, int hp, int dependence) {
        super(name, hp, TMinion.Ghouls);
        this.dependence = dependence;
    }
    private int dependence;
    public int getDependence() {
        return dependence;
    }

    public void setDependence(int dependence) {
        this.dependence=dependence;
    }

}