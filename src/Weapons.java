
import java.io.*;
import java.util.*;

public class Weapons extends Equipment {

    public Weapons(String name, int attack, int defense, int type) {
        super(name, attack, defense, TEquipment.Weapons);
        this.weaponType = type;
    }

    private int weaponType;

    public int getWeaponType() {
        return this.weaponType;
    }

    public void setWeaponType(int newType) {
        this.weaponType = newType;
    }

}