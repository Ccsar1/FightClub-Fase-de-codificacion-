
import java.io.Serializable;
import java.util.ArrayList;

public class CharacterUser implements Serializable {

    public CharacterUser(Character character,String nick) {
        this.gold = 150;
        this.character = character;
        this.resetValues();
        this.weaponActive = new ArrayList<>();
        this.userNick=nick;
    }

    private Character character;

    private ArrayList<Weapons> weaponActive;

    private Armor armorActive;

    private int hp;

    private int minionHP;

    private int gold;

    private int blood;

    private int fury;

    private int willpower;

    private String userNick;

    public void doDamage() {
        if (this.minionHP > 0) {
            this.minionHP -= 1;
        } else {
            this.hp -= 1;
        }
    }

    public boolean surviveMinionHP(){
        return this.minionHP>0;
    }
    public void removeGold(int minus) {
        this.gold -= minus;
        if (this.gold < 0) {
            this.gold = 0;

        }
    }

    public String getUserNick(){
        return this.userNick;
    }
    public int getHP() {
        return this.hp;
    }

    public int getGold() {
        return this.gold;
    }

    public int calculateAttack() {

        int attack = 0;
        int equipmentAttack = 0;
        for (Weapons weapon : this.weaponActive){
            equipmentAttack += weapon.getAttackModifier();
        }

        equipmentAttack += this.armorActive.getAttackModifier();

        SpecialAbility ability = character.getSpecialAbilities();
        switch (this.character.getType()){
            case TCharacter.Hunter:
                Hunter hunter = (Hunter) this.character;
                Talent talent = (Talent) ability;
                attack = character.getPower() + this.willpower + equipmentAttack + talent.getAttackValue();
                break;

            case TCharacter.Lycanthrope:
                Gift gift = (Gift) ability;
                int giftAttack = 0;
                if (this.fury >= gift.getFury()) {
                    giftAttack = gift.getAttackValue();
                }
                attack = character.getPower() + giftAttack + equipmentAttack + this.fury;
                break;

            case TCharacter.Vampire:
                Disciplines discipline = (Disciplines) ability;
                int disciplineAttack = 0;
                if (this.blood > discipline.getCost()){
                    disciplineAttack = discipline.getAttackValue();
                    this.blood -= discipline.getCost();
                }
                int extra = 0;
                if (this.blood > 5){
                    extra = 2;
                }
                attack = character.getPower() + disciplineAttack + equipmentAttack + extra;
        }
        return attack;
    }

    public int calculateDefense(){
        int defense = 0;
        int equipmentDefense = 0;
        for (Weapons weapon : this.weaponActive){
            equipmentDefense += weapon.getDefenseModifier();
        }
        equipmentDefense += this.armorActive.getDefenseModifier();

        SpecialAbility ability = this.character.getSpecialAbilities();
        switch (this.character.getType()){
            case TCharacter.Hunter:
                Talent talent = (Talent) ability;
                defense = this.character.getPower() + talent.getDefenseValue() + equipmentDefense + this.willpower;
                break;

            case TCharacter.Vampire:
                Disciplines discipline = (Disciplines) ability;
                int disciplineDefense = 0;
                if (this.blood > discipline.getCost()){
                    disciplineDefense = discipline.getDefenseValue();
                    this.blood -= discipline.getCost();
                }
                int extra = 0;
                if (this.blood > 5){
                    extra = 2;
                }
                defense = this.character.getPower() + disciplineDefense + equipmentDefense + extra;
                break;

            case TCharacter.Lycanthrope:
                Gift gift = (Gift) ability;
                int abilityDefense = 0;
                if (this.fury >= gift.getFury()) {
                    abilityDefense = gift.getDefenseValue();
                }
                defense = character.getPower() + abilityDefense + armorActive.getDefenseModifier() + equipmentDefense + this.fury;
        }
        return defense;
    }

    public String getName() {
        return this.character.getName();
    }

    public ArrayList<Weapons> getWeapons(){
        return this.character.getWeapons();
    }

    public void setWeapons(Weapons weapon){
        this.weaponActive.add(weapon);
    }

    public void deleteWeapons(){
        this.weaponActive = new ArrayList<>();
    }

    public void setArmor(Armor armor){
        this.armorActive = armor;
    }

    public ArrayList<Armor> getArmors(){
        return character.getArmor();
    }

    public void addGold(int more){
        this.gold += more;
    }

    public void resetValues() {
        this.hp = this.character.getHp();
        this.blood = 0;
        this.fury = 0;
        this.minionHP = this.character.getMinionHP();
        if (this.character.getType() == TCharacter.Hunter) {
            Hunter hunter = (Hunter) this.character;
            this.willpower = hunter.getWillpower();
        }
    }

    public void gainBlood() {
        if (this.character.getType() == TCharacter.Vampire) {
            if (this.blood < 10) {
                this.blood += 4;
            }
        }
    }

    public void gainFury() {
        if (this.character.getType() == TCharacter.Lycanthrope) {
            if (this.fury < 3) {
                this.fury += 1;
            }
        }
    }

    public void loseWillpower() {
        if (this.character.getType() == TCharacter.Hunter) {
            if (this.willpower > 0) {
                this.willpower -= 1;
            }
        }
    }

}