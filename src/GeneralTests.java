import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class GeneralTests {


    private DataBaseManager database=new DataBaseManager();
    Player player= new Player("Alonso","FernandoALO14","12345678",database);

    Player player3= new Player("FernandoALO14","Fernando","12345678",database);

    Operator admin= new Operator("admin","admin","12345678",database);

    Player playerCreated= new Player("player121","player121","12345678",database);
    SpecialAbility specialAbility= new SpecialAbility("Demencia",3,3,TAbility.Talent);

    Hunter hunter= new Hunter("Tyler Durden",3,3,specialAbility,4);

    CharacterUser charUser= new CharacterUser(hunter,"Tyler");

    CharacterUser charUser2= new CharacterUser(hunter,"Leo");

    Challenge challenge1= database.getChallengeByChallenged(playerCreated);

    Weapons weapon=new Weapons("Hacha",3,3,1);

    Armor armor= new Armor("Pechera",1,3);
    Modifiers modifier=new Modifiers("modificador");
    private Game game=new Game(database);
@Test
    void minionsMethod(){
        String minionName= "Demon";
        int hp=2;
        String pact="Pacto";
        Demons minionsTest= new Demons(minionName,hp,pact);
        Demons minionsTest2= new Demons("new",hp,pact);
        Ghouls minionsTest3= new Ghouls("new",hp,2);
        Humans minionHuman = new Humans("humano",3,'r');
        minionHuman.setLoyalty(3);
        System.out.println(minionsTest3.getDependence());
        minionsTest.setMinion(minionsTest2);
        ArrayList<Minions> minionsTestSonArray= minionsTest.getMinions();
        for (Minions minion: minionsTestSonArray){
            System.out.println(minion);
        }
        TMinion type=TMinion.valueOf("Demons");
        TMinion typeActualMinion=minionsTest.getType();
        assertEquals(minionsTest.getPact(),"Non Pacto");
        assertEquals(minionsTest.getHP(),2);
        assertEquals(minionsTest.getName(),null);
        assertEquals(type,typeActualMinion);
        assertEquals(minionsTestSonArray,null);
        minionsTest.removeMinion(null);
        ArrayList<Minions> minionsTestSonArray2= minionsTest.getMinions();
        assertEquals(minionsTestSonArray2,null);

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

    }
    @Test
    void registerNickIncorrectly() {
        game.register("FernandoALO14","FernandoALO14","12345678",TUser.Player);

    }
    @Test
    void registerIncorrectly() {

        game.register(null,null,null,null);

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

        String input = "-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        admin.validateChallenge();
    }
    @Test
    void incorrectLetterChallenge() {

        String input = null;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        admin.validateChallenge();
    }

    @Test
    void getCharactersPlayer1() {
        if (playerCreated.getCharacters()==null){
            System.out.println("null");
        }else{
            ArrayList<CharacterUser> characterArray= playerCreated.getCharacters();
            for (CharacterUser chare: characterArray){
                System.out.println(chare.getName());
            }

        }
    }

    @Test
    void getChallengerCharacterIncorrect() {
        CharacterUser player2= challenge1.getChallengerCharacter();
        assertEquals(player2,charUser2);
    }
    @Test
    void getChallengerCharacterCorrect() {
        CharacterUser player2= challenge1.getChallengerCharacter();
        assertEquals(player2,charUser);
    }
    @Test
    void getChallengerCharacterNull() {
        CharacterUser player2= challenge1.getChallengerCharacter();
        assertEquals(player2,null);
    }
    @Test
    void getChallengedCharacterIncorrect() {
        Player player2= challenge1.getChallenged();
        assertEquals(player2,charUser);
    }

    @Test
    void getGold() {
        int gold=challenge1.getGold();
        assertEquals(gold,120);
    }

    @Test
    void setWeapons() {
        hunter.setWeapons(weapon);

    }

    @Test
    void setArmor() {
        hunter.setArmor(armor);

    }

    @Test
    void setSpecialAbilities() {
        hunter.setSpecialAbilities(specialAbility);
    }

    @Test
    void getHp() {
        int n=hunter.getHp();
        assertEquals(n,5);

    }

    @Test
    void numReader() {
    NumReader numReader2= new NumReader();
    String name="1";
    assertTrue(numReader2.isNumeric(name));
    int input=-1;
         input =NumReader.readNumber();


    }

    @Test
    void modifierValue(){

    Modifiers modifier= new Modifiers("modificador");
    ModifierValue modifierValue= new ModifierValue(modifier,2);
    modifierValue.setModifier(null);
    Modifiers modifierList=modifierValue.getModifier();
    modifierValue.getModifier();

    }

    @Test
    void modifier(){
        Modifiers modifier= new Modifiers(null);
        System.out.println(modifier.getName());
        modifier.setName("ModificadorName");
        System.out.println(modifier.getName());
    }

    @Test
    void SpecialAbilityTest(){
    Gift gifts= new Gift("gifted",2,2,2);
    gifts.setFury(1);
    System.out.println(gifts.getFury());

    gifts.setName("specialAbilityName");
    System.out.println(gifts.getName());

    gifts.setAttackValue(2);
    gifts.getAttackValue();
    gifts.setDefenseValue(2);
    gifts.getDefenseValue();
    System.out.println(gifts.getTypeAbility());


    }

    @Test
    void challenge(){
    Challenge challenge= new Challenge(player,player3,charUser,120);


    System.out.println(challenge.getChallenger().getNick());
    System.out.println(challenge.getChallenged().getNick());
    System.out.println(challenge.getChallengerCharacter().getName());
    System.out.println(challenge.getGold());
    System.out.println(challenge.getValid());
    challenge.setModifier(modifier);
    challenge.removeModifier(modifier);
    System.out.println(challenge.getModifier());

    assertTrue(challenge.containsPlayer(player));
    assertTrue(challenge.containsCharacter(null));

    }
    @Test
    void playerTest(){
    Player playerNew= new Player("newPlayer","newPlayer","12345678",database);
    System.out.println(playerNew.getRegisterNumber());
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    ArrayList<CharacterUser> characterArrayList= playerNew.getCharacters();
    for (CharacterUser chara:characterArrayList){
        System.out.println(chara.getName());
    }

    }



}