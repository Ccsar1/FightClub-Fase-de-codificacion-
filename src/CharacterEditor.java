
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

    public Character editPower(Character character) {
        // TODO implement here
        return null;
    }

    /**
     * @param character
     * @return
     */
    public Character editType(Character character) {
        // TODO implement here
        return null;
    }

    /**
     * @param character
     * @return
     */
    public Character editGold(Character character) {
        // TODO implement here
        return null;
    }

    /**
     * @param character
     * @return
     */
    public Character editSpecialAbilities(Character character) {
        // TODO implement here
        return null;
    }

    /**
     * @param character
     * @return
     */
    public Character editEquipment(Character character) {
        // TODO implement here
        return null;
    }

    /**
     * @param character
     * @return
     */
    public Character editMinions(Character character) {
        // TODO implement here
        return null;
    }

    /**
     * @param character
     * @return
     */
    public Character editWeapons(Character character) {
        // TODO implement here
        return null;
    }

    /**
     * @param character
     * @return
     */
    public Character editArmor(Character character) {
        // TODO implement here
        return null;
    }

}