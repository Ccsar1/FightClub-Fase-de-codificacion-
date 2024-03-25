
import java.io.*;
import java.util.*;


public class CharacterEditor {

    private Character character;
    private DataBaseManager dataBase;
    public CharacterEditor(Character character) {
        this.character=character;
    }

    public Character editName(Character character, String name) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setName(name);
            dataBase.saveFiles();
        }
        return null;
    }

    public Character editPower(Character character, int power) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setPower(power);
            dataBase.saveFiles();
        }
        return null;

    }

    public Character editType(Character character, TCharacter type) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setType(type);
            dataBase.saveFiles();
        }

        return null;
    }


    public Character editGold(Character character, int gold) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setGold(gold);
            dataBase.saveFiles();
        }

        return null;
    }


    public Character editSpecialAbilities(Character character, SpecialAbility special) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setSpecialAbilities(special);
            dataBase.saveFiles();
        }
        return null;

    }


    public Character editMinions(Character character, Minions minions) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setMinions(minions);
            dataBase.saveFiles();
        }
        return null;

    }


    public Character editWeapons(Character character, Weapons weapons) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setWeapons(weapons);
            dataBase.saveFiles();
        }
        return null;

    }


    public Character editArmor(Character character, Armor armor) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setArmor(armor);
            dataBase.saveFiles();
        }
        return null;

    }

}