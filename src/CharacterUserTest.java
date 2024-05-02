import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterUserTest {

    static CharacterUser characterUser;
    static Character character;

    @BeforeAll
    static void initializeCharacterUser() {
        character = new Hunter("characterName", 2,5, new Talent("", 1,2), 1);
        characterUser = new CharacterUser(character,"playerNick");
    }
    @Test
    void hpTest() {
        assertEquals(5, characterUser.getHP());

        characterUser.doDamage();

        assertEquals(4, characterUser.getHP());

        characterUser.getCharacter().getMinions().add(new Demons("", 1, ""));
        characterUser.resetValues();

        assertTrue(characterUser.surviveMinionHP());

        characterUser.doDamage();

        assertEquals(5, characterUser.getHP());
        assertFalse(characterUser.surviveMinionHP());
    }

    @Test
    void goldTest() {
        assertEquals(150, characterUser.getGold());

        characterUser.removeGold(100);

        assertEquals(50, characterUser.getGold());

        characterUser.addGold(50);

        assertEquals(100, characterUser.getGold());
    }

    @Test
    void getUserNick() {
        assertEquals("playerNick", characterUser.getUserNick());
    }

    @Test
    void calculateAttack() {
        assertEquals(4, characterUser.calculateAttack(null));
    }

    @Test
    void calculateDefense() {
        assertEquals(5, characterUser.calculateDefense(null));
    }

    @Test
    void getName() {
        assertEquals("characterName", characterUser.getName());
    }

    @Test
    void getWeapons() {
        assertTrue(characterUser.getWeapons().isEmpty());

        Weapons weapon = new Weapons("", 2, 2, 2);
        characterUser.getCharacter().getWeapons().add(weapon);

        assertTrue(characterUser.getWeapons().contains(weapon));
    }

    @Test
    void getArmors() {
        assertTrue(characterUser.getArmors().isEmpty());

        Armor armor = new Armor("", 2, 2);
        characterUser.getCharacter().getArmor().add(armor);

        assertTrue(characterUser.getArmors().contains(armor));
    }

    @Test
    void getCharacter() {
        assertEquals(character, characterUser.getCharacter());
    }
}