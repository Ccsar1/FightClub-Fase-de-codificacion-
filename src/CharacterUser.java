
import java.util.Random;
import java.util.ArrayList;

/**
 *
 */
public class CharacterUser {

    /**
     * Default constructor
     */
    public CharacterUser() {
    }

    private Character character;

    private ArrayList<Weapons> weaponActive;

    private Armor armorActive;

    private int hp = 5;

    private int gold = 150;


    public void doDamage(int dam) {
        this.hp = this.hp - dam;
    }

    public void removeGold(int minus) {
        this.gold = this.gold - minus;
    }

    public int getHP() {
        return this.hp;
    }

    public int getGold() {
        return this.gold;
    }

    public int[] calculateAttack(Character character) {

        switch (character.getType()){
            case Hunter:
                Hunter hunter = new Hunter();
                int attack = character.getPower() + Equipment.getAttackModifier() + hunter.getWillPower();


            case Lycanthrope:
                int furia = 0;
                Don don = new Don();
                if (don.getFury() >= Lycanthrope.getFury()){
                    furia = don.getFury();
                    Lycanthrope.setFury(Lycanthrope.getFury() - don.getFury());
                } else {
                    break;
                }
                int attack = character.getPower() + furia + Equipment.getAttackModifier() + Lycanthrope.getFury();


            case Vampire:
                if (Disciplines.getCost() > Vampire.getBlood()){
                    int disciplina = 0;
                } else {
                    int disciplina = Disciplines.getCost();
                    Vampire.setBlood(Vampire.getBlood() - disciplina);
                }

                if (Vampire.getBlood() < 5){
                    int extra = 0;
                } else {
                    int extra = 2;
                }

                int attack = character.getPower() + Equipment.getAttackModifier() + disciplina + extra;

        }
        return attack;
    }

    public int calculateDefense(){
        switch (character.getType()){

            case Hunter:
                int defense = character.getPower() + talento + Equipment.getDefenceModifier() + Hunter.getWillPower();

            case Vampire:
                if (Disciplines.getCost() > Vampire.getBlood()){
                    int disciplina = 0;
                } else {
                    int disciplina = Disciplines.getCost();
                    Vampire.setBlood(Vampire.getBlood() - disciplina);
                }

                if (Vampire.getBlood() < 5){
                    int extra = 0;
                } else {
                    int extra = 2;
                }
                int defense = character.getPower() + disciplina + Equipment.getDefenceModifier() + extra;

            case Lycanthrope:
                if (Don.getFury() > Lycanthrope.getFury()){
                    int furia = 0;
                } else {
                    int furia = Don.getFury();
                    Lycanthrope.setFury(Lycanthrope.getFury() - Don.getFury());
                }
                int defense = character.getPower() + furia + Equipment.getDefenceModifier() + Lycanthrope.getFury();

        }


        return defense;
    }

    public String getName() {
        String name = character.getName();
        return name;
    }


    public void setGold(int gold) {
        this.gold = gold;
    }

    public Weapons getWeapons(){
        Weapons armas = character.getWeapons();
        return armas;
    }

    public Weapons setWeapons(Weapons arma){
        weaponActive.add(arma);
    }

    public void deleteWeapons(){
        weaponActive = new ArrayList<>();
    }

    public void setArmor(Armor armor){
        this.armorActive = armor;
    }
}