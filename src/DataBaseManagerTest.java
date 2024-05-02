import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DataBaseManagerTest {

    static DataBaseManager db;

    @BeforeAll
    static void initializeDB() {
        db = new DataBaseManager();
    }

    @org.junit.jupiter.api.Test
    void charDB() {
        Character character = new Lycanthrope("", 0, 0, new Gift("", 0, 0, 0),
                0, 0);
        db.setCharDB(character);

        assertEquals(character, db.getCharacters().get(0));

        Character character1 = new Hunter("", 0, 0, new Talent("", 0, 0), 0);
        Character character2 = new Vampire("", 0, 0, new Disciplines("", 0, 0,
                0), 0);
        db.setCharDB(character1);
        db.setCharDB(character2);

        db.removeCharacter(character);
        db.removeCharacter(character1);
        db.removeCharacter(character2);

        assertTrue(db.getCharacters().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void userDB() {
        String playerNick = "playerTest";
        Player player = new Player("", playerNick, "", db);
        db.setPlayerDB(player);

        assertEquals(player, db.getUserByNick(playerNick));
        assertEquals(player, db.getPlayerByNick(playerNick));
        assertTrue(db.checkExistsNick(playerNick));

        String operatorNick = "operatorTest";
        Operator operator = new Operator("", operatorNick, "", db);
        db.setOperatorDB(operator);

        assertEquals(operator, db.getUserByNick(operatorNick));
        assertNull(db.getPlayerByNick(operatorNick));
        assertTrue(db.checkExistsNick(operatorNick));

        String wrongNick = "nonExistentUser";

        assertNull(db.getUserByNick(wrongNick));
        assertNull(db.getPlayerByNick(wrongNick));
        assertFalse(db.checkExistsNick(wrongNick));

        db.blockUser(player);

        assertEquals(player, db.getAllBlock().get(0));
        assertTrue(db.getAllPlayers().isEmpty());
        assertTrue(db.isUserBlock(playerNick));

        db.unlockUser(player);

        assertEquals(player, db.getAllPlayers().get(0));
        assertTrue(db.getAllBlock().isEmpty());
        assertFalse(db.isUserBlock(playerNick));

        db.deleteUser(player);

        assertTrue(db.getAllPlayers().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void fightDB() {
        Player player = new Player("", "", "", db);
        Fight fight = new Fight(player, player, new CharacterUser(new Hunter("", 0, 0, new Talent(
                "", 0, 0), 0), ""), new CharacterUser(new Hunter("", 0,
                0, new Talent("", 0, 0), 0), ""), 0, new Modifiers(""));
        db.setFightDB(fight);

        assertEquals(fight, db.getFights(player).get(0));
        assertEquals(fight, db.getNotNotifiedFights(player).get(0));

        fight.setNotified();


        assertTrue(db.getNotNotifiedFights(player).isEmpty());
    }

    @org.junit.jupiter.api.Test
    void registerNumberExists() {
        Player player = new Player("", "", "", db);
        db.setPlayerDB(player);
        assertTrue(db.registerNumberExists(player.getRegisterNumber()));
        assertFalse(db.registerNumberExists("AAAAA"));
    }

    @org.junit.jupiter.api.Test
    void challengeDB() {
        Player player = new Player("", "", "", db);
        Challenge challenge = new Challenge(player, player, new CharacterUser(new Vampire("", 0, 0,
                new Disciplines("", 0, 0, 0), 0), ""), 0);
        db.setChallenge(challenge);

        assertEquals(challenge, db.getAllChallengeDB().get(0));
        assertTrue(db.userInChallenge(player));
        assertEquals(challenge, db.getNonValidatedChallenges().get(0));
        assertNull(db.getChallengeByChallenged(player));

        challenge.setValid();

        assertTrue(db.getNonValidatedChallenges().isEmpty());
        assertEquals(challenge, db.getChallengeByChallenged(player));

        db.deleteChallenge(challenge);

        assertTrue(db.getAllChallengeDB().isEmpty());
        assertFalse(db.userInChallenge(player));
        assertNull(db.getChallengeByChallenged(player));
    }

    @org.junit.jupiter.api.Test
    void modifiersDB() {
        Modifiers modifier = new Modifiers("");

        db.setModifier(modifier);

        assertEquals(modifier, db.getAllModifiers().get(0));

        db.removeModifier(modifier);

        assertTrue(db.getAllModifiers().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void weaponsDB() {
        Weapons weapon = new Weapons("", 0, 0, 0);

        db.setWeapon(weapon);

        assertEquals(weapon, db.getWeaponsDB().get(0));

        db.removeWeapon(weapon);

        assertTrue(db.getWeaponsDB().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void armorsDB() {
        Armor armor = new Armor("", 0, 0);

        db.setArmor(armor);

        assertEquals(armor, db.getArmorsDB().get(0));

        db.removeArmor(armor);

        assertTrue(db.getArmorsDB().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void minionDB() {
        Minions minion = new Demons("", 0, "");

        db.setMinion(minion);

        assertEquals(minion, db.getMinions().get(0));

        db.removeMinion(minion);

        assertTrue(db.getMinions().isEmpty());
    }
}