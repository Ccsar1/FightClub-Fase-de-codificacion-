
import java.io.*;
import java.util.*;


public abstract class SpecialAbility {

    private String name;
    private int attackValue;
    private int defenceValue;
    private TAbility typeAbility;
    public SpecialAbility(String name, int attack, int defence, TAbility type) {
        this.name=name;
        this.attackValue=attack;
        this.defenceValue=defence;
        this.typeAbility=type;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setAttackValue(int attack){
        if (attack>=1 && attack<=3){
            this.defenceValue=attack;
        }else{
            throw new IllegalArgumentException("El valor debe estar entre 1 y 3.");
        }
    }
    public int getAttackValue(){
        return this.attackValue;
    }
    public void setDefenceValue(int defence){
        if (defence>=1 && defence<=3){
            this.defenceValue=defence;
        }else{
            throw new IllegalArgumentException("El valor debe estar entre 1 y 3.");
        }
    }
    public int getDefenseValue(){
        return this.defenceValue;
    }
    public void setTypeAbility(TAbility type){
        this.typeAbility=type;
    }
    public TAbility getTypeAbility(){
        return this.typeAbility;
    }

    }
