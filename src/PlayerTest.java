import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class PlayerTest {


    private DataBaseManager database=new DataBaseManager();
    Player player= new Player("Alonso","FernandoALO14","12345678",database);
    Operator admin= new Operator("Lewis","Max33","12345678",database);
    Player player3= new Player("FernandoALO14","Fernando","12345678",database);

    private Game game=new Game(database);
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;



    @Test
    void getCharacters() {
        player.getCharacters();

    }

    @Test
    void getRegisterNumber() {

    }

    @Test
    void showMenu() {

        player.showMenu();


    }

    @Test
    void playRound() {

    }

    @Test
    void setchallengerAttack() {
    }

    @Test
    void setchallengedAttack() {
    }

    @Test
    void setchallengerMinion() {
    }

    @Test
    void setchallengedMinion() {
    }

    @Test
    void getchallengerHP() {
    }

    @Test
    void getchallengedHP() {
    }

    @Test
    void challengerAttack() {
    }

    @Test
    void challengedAttack() {
    }

    @Test
    void minionLiveChallenger() {
    }

    @Test
    void minionLiveChallenged() {
    }

    @Test
    void HPChallenger() {
    }

    @Test
    void HPChallenged() {
    }


    @Test
    void loginCorrectly() {
        String nick="FernandoALO14";
    String pass="12345678";
    game.login(nick,pass);
    }

    @Test
    void loginNickIncorrectly() {
        String nick="FendoALO14";
        String pass="12345678";
        game.login(nick,pass);
    }
    @Test
    void loginPassIncorrectly() {
        String nick="FernandoALO14";
        String pass="123456789";
        game.login(nick,pass);
    }

    @Test
    void loginNull() {
        game.login(null,null);
    }
    @Test
    void registerCorrectly() {
        game.register("FernandoALO14","Fernando","12345678",TUser.Player);
        database.setPlayerDB(player3);
    }
    @Test
    void registerNickIncorrectly() {
        game.register("FernandoALO14","FernandoALO14","12345678",TUser.Player);
        database.setPlayerDB(player3);
    }
    @Test
    void registerIncorrectly() {

        game.register(null,null,null,null);
        database.setPlayerDB(player3);
    }

    @Test
    void getNickCorrectly() {
        String nick="FernandoALO14";
        assertEquals(nick,player.getNick());
    }
    @Test
    void getNickIncorrectly() {
        String nick="FernanALO14";
        assertEquals(nick,player.getNick());
    }
    @Test
    void getNickNull() {
        assertEquals(null,player.getNick());
    }


    @Test
    void checkPasswordCorrectly() {
        String pass="12345678";
        boolean found=player.checkPassword(pass);
        assertEquals(found,true);
    }
    @Test
    void checkPasswordIncorrectly() {
        String pass="123456789";
        boolean found=player.checkPassword(pass);
        assertTrue(found);
    }
    @Test
    void checkPasswordNull() {
        String pass=null;
        boolean found=player.checkPassword(pass);
        assertTrue(found);
    }


    @Test
    void getNameCorrectly() {
        String name="Alonso";
        assertEquals(name,player.getName());
    }
    @Test
    void getNameIncorrectly() {
        String name="Alonso123";
        assertEquals(player.getName(),name);
    }
    @Test
    void getNameNull() {
        String name=null;
        assertEquals(name,player.getName());
    }


    @Test

    void blockUserCorrect() {

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        admin.blockUser();

    }

    @Test
    void blockUserNegative() {

        String input = "-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        admin.blockUser();

    }
    @Test
    void blockUserPlusMax() {

        String input = "150\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        admin.blockUser();

    }
    @Test
    void blockUserLetter() {

        String input = "s\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        admin.blockUser();


    }
    @Test

    void unlockUserCorrect() {

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        admin.unlockUser();

    }

    @Test
    void unlockUserNegative() {

        String input = "-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        admin.unlockUser();

    }
    @Test
    void unlockUserPlusMax() {

        String input = "150\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        admin.unlockUser();

    }
    @Test
    void unlockUserLetter() {

        String input = "s\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        admin.unlockUser();
    }
    @Test
    void validateChallenge() {

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        admin.validateChallenge();
    }
    @Test
    void deleteChallenge() {

        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        admin.validateChallenge();
    }
    @Test
    void incorrectChallenge() {

        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        admin.validateChallenge();
    }
    @Test
    void incorrectLetterChallenge() {

        String input = "s\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        admin.validateChallenge();
    }


}