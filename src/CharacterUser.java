
import java.util.Random;
import java.util.ArrayList;

/**
 *
 */
public class CharacterUser {

    /**
     * Default constructor
     */
    public CharacterUser(Character character1) {
        this.gold = 150;
        this.resetHp();
        this.character = character1;
    }

    private Character character;

    private ArrayList<Weapons> weaponActive;

    private Armor armorActive;

    private int hp;

    private int gold;


    public void doDamage() {
        this.hp = this.hp - 1;
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

    public int calculateAttack() {

        int attack = 0;
        int attacker = 0;
        for (Weapons weapon : this.weaponActive){
            int att_mod = weapon.getDefenceModifier();
            attacker = attacker + att_mod;
        }
        SpecialAbility hability = character.getSpecialAbilities();
        switch (character.getType()){
            case Hunter:
                Hunter hunter = (Hunter)character;
                Talent talent = (Talent)hability;
                attack = character.getPower() + hunter.getWillpower() + armorActive.getAttackModifier() + attacker + talent.getAttackValue();


            case Lycanthrope:
                int furia = 0;
                Don don = (Don)hability;
                Lycanthrope lycanthrope = (Lycanthrope)character;

                if (don.getFury() >= lycanthrope.getFury()){
                    furia = 0;
                } else {
                    furia = don.getAttackValue();
                }
                attack = character.getPower() + furia + armorActive.getAttackModifier()+ attacker + lycanthrope.getFury();


            case Vampire:
                Vampire vampire = (Vampire) character;
                Disciplines discipline = (Disciplines)hability;
                int extra;
                int disciplina;
                if (discipline.getCost() > vampire.getBlood()){
                    disciplina = 0;
                } else {
                    disciplina = discipline.getAttackValue();
                    vampire.setBlood(vampire.getBlood() - discipline.getCost());
                }

                if (vampire.getBlood() < 5){
                    extra = 0;
                } else {
                    extra = 2;
                }

                attack = character.getPower() + disciplina + armorActive.getAttackModifier() + attacker + extra;

        }
        return attack;
    }

    public int calculateDefense(){
        int defense = 0;
        int defender = 0;
        for (Weapons weapon : this.weaponActive){
            int def_mod = weapon.getDefenceModifier();
            defender = defender + def_mod;
        }
        SpecialAbility hability = character.getSpecialAbilities();
        switch (character.getType()){
            case Hunter:
                Hunter hunter = (Hunter)character;
                Talent talento = (Talent)hability;
                defense = character.getPower() + talento.getDefenceValue() + armorActive.getDefenceModifier() + defender + hunter.getWillpower();

            case Vampire:
                Vampire vampire = (Vampire)character;
                int disciplina;
                int extra;
                Disciplines discipline = (Disciplines)hability;
                if (discipline.getCost() > vampire.getBlood()){
                    disciplina = 0;
                } else {
                    disciplina = discipline.getDefenceValue();
                    vampire.setBlood(vampire.getBlood() - discipline.getCost());
                }

                if (vampire.getBlood() < 5){
                    extra = 0;
                } else {
                    extra = 2;
                }
                defense = character.getPower() + disciplina + armorActive.getDefenceModifier() + defender + extra;

            case Lycanthrope:
                Lycanthrope lycanthrope = (Lycanthrope)character;
                int furia;
                Don don = (Don)hability;
                if (don.getFury() > lycanthrope.getFury()){
                    furia = 0;
                } else {
                    furia = don.getDefenceValue();
                }
                defense = character.getPower() + furia + armorActive.getDefenceModifier() + defender + lycanthrope.getFury();

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

    public ArrayList<Weapons> getWeapons(){
        ArrayList <Weapons> armas = character.getWeapons();
        return armas;
    }

    public void setWeapons(Weapons arma){
        weaponActive.add(arma);
    }

    public void deleteWeapons(){
        weaponActive = new ArrayList<>();
    }

    public void setArmor(Armor armor){
        this.armorActive = armor;
    }

    public Armor getArmor(){
        return character.getArmor();
    }

    public void addGold(int more){
        this.setGold(this.gold + more);
    }

    public void resetHp() {
        this.hp = this.character.getHp();
    }
}