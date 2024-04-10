import java.io.Serializable;

public abstract class Equipment implements Serializable {

    public Equipment(String name, int attack, int defense, TEquipment type) {
        this.name = name;
        this.attackModifier = attack;
        this.defenseModifier = defense;
        this.typeEquipment = type;
    }

    private TEquipment typeEquipment;

    private String name;

    private int attackModifier;

    private int defenseModifier;

    public void setAttackModifier(int i) {
        this.attackModifier = i;
    }

    public int getAttackModifier() {
        return this.attackModifier;
    }

    public void setDefenseModifier(int i) {
        this.defenseModifier = i;
    }

    public int getDefenseModifier() {
        return this.defenseModifier;
    }


    public TEquipment getTypeEquipment() {
        return typeEquipment;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}