
import java.io.*;
import java.util.*;

/**
 *
 */
public class Disciplines extends SpecialAbility {

    private int cost;
    public Disciplines(String name, int attack, int defence,int cost) {
        super(name,attack,defence,TAbility.Disciplines);
        this.cost=cost;
    }

    public void setCost(int value){
        if (value>=1 && value<=3){
            this.cost=value;
        }else{
            throw new IllegalArgumentException("El valor debe estar entre 1 y 3.");
        }
    }

    public int getCost(){
        return this.cost;
    }


}