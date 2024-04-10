
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class DataBaseManager implements Serializable{

    private ArrayList<Character> charDB;
    private ArrayList<Fight> fightDB;
    private ArrayList<Weaknesses> weaknessesDB;

    private ArrayList<Strengths> strengthsDB;
    private ArrayList<Player> playerDB;
    private ArrayList<Operator> operatorDB;
    private ArrayList<Challenge> challengeDB;
    private ArrayList<Player> userBlockDB;
    private ArrayList<Weapons> weaponsDB;
    private ArrayList<Armor> armorsDB;
    private ArrayList<Minions> minionsDB;


    public DataBaseManager() {
        loadFiles();

    }


    public void loadFiles() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("FightClub.ser"))) {
            DataBaseManager savedData = (DataBaseManager) inputStream.readObject();
            this.playerDB = savedData.playerDB;
            this.weaknessesDB = savedData.weaknessesDB;
            this.strengthsDB = savedData.strengthsDB;
            this.operatorDB = savedData.operatorDB;
            this.userBlockDB = savedData.userBlockDB;
            this.charDB = savedData.charDB;
            this.fightDB = savedData.fightDB;
            this.challengeDB = savedData.challengeDB;
            this.weaponsDB = savedData.weaponsDB;
            this.armorsDB = savedData.armorsDB;
            this.minionsDB = savedData.minionsDB;

        } catch (FileNotFoundException e) {

            this.playerDB = new ArrayList<>();
            this.weaknessesDB = new ArrayList<>();
            this.strengthsDB = new ArrayList<>();
            this.operatorDB = new ArrayList<>();
            this.userBlockDB = new ArrayList<>();
            this.charDB = new ArrayList<>();
            this.fightDB = new ArrayList<>();
            this.challengeDB = new ArrayList<>();
            this.weaponsDB = new ArrayList<>();
            this.armorsDB = new ArrayList<>();
            this.minionsDB = new ArrayList<>();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveFiles() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("FightClub.ser"))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCharDB(Character character) {
        charDB.add(character);
        saveFiles();

    }

    public void removeCharacter(Character character) {
        this.charDB.remove(character);
    }

    public void setFightDB(Fight fight) {
        fightDB.add(fight);
        saveFiles();

    }

    public void setPlayerDB(Player player) {
        playerDB.add(player);
    }

    public void getPlayersDB() {
        for (Player player : playerDB) {
            System.out.println("Name " + player.getName() + ",nick: " + player.getNick());
        }
    }

    public void setOperatorDB(Operator operator) {
        operatorDB.add(operator);
    }

    public void getOperatorsDB() {
        for (Operator operator : operatorDB) {
            System.out.println("Name " + operator.getName() + ",nick: " + operator.getNick());
        }
    }

    public void setChallengeDB(Challenge challenge) {
        challengeDB.add(challenge);
        saveFiles();
    }

    public User getUserByNick(String nick) {
        for (Player player : playerDB) {

            if (player.getNick().equals(nick)) {
                return player;
            }

        }
        for (Operator operator : operatorDB) {

            if (operator.getNick().equals(nick)) {
                return operator;
            }

        }
        return null;

    }

    public Player getPlayerByNick(String nick) {
        for (Player player : playerDB) {

            if (player.getNick().equals(nick)) {
                return player;
            }

        }
        return null;

    }

    public ArrayList<Player> getAllPlayers (){
        return playerDB;
    }
    public ArrayList<Player> getAllBlock (){
        return userBlockDB;
    }



    public void deleteUser(User user) {
        Iterator<Player> iterator = playerDB.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.equals(user)) {
                iterator.remove();
                return;
            }
        }
        Iterator<Operator> iteratorOperator = operatorDB.iterator();
        while (iteratorOperator.hasNext()) {
            Operator operator = iteratorOperator.next();
            if (operator.equals(user)) {
                iteratorOperator.remove();
                return;
            }
        }

    }



    public Character getCharacterByName(String name){
        for (Character character : charDB) {
           if (character.getName().equals(name)){
               return character;
           }
        }
        return null;
    }
    public void getRanking() {
        ArrayList<CharacterUser>allcharacters= new ArrayList<>();

        for (Player player:playerDB){
            allcharacters.addAll(player.getCharacters());
        }
        Collections.sort(allcharacters, new Comparator<CharacterUser>() {
            @Override
            public int compare(CharacterUser o1, CharacterUser o2) {
                return Integer.compare(o2.getGold(), o1.getGold());
            }
        });
        System.out.println("RANKING");
        System.out.println("--------");
        int posicion=1;
        for (CharacterUser character:allcharacters){
            System.out.println(posicion+": Name: "+character.getName()+",Gold: "+character.getGold());
            posicion++;
        }


    }

    public boolean isUserBlock (String nick){
        for (Player player: playerDB){
            if (player.getNick().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public boolean checkExistsCharacter(String nick){
        for (Character character:charDB){
            if (character.getName().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public boolean checkExistsNick(String nick){
        for (Player player:playerDB){
            if (player.getName().equals(nick)){
                return true;
            }
        }
        for (Operator operator:operatorDB){
            if (operator.getName().equals(nick)){
                return true;
            }
        }
        for (Player playerBlock:userBlockDB){
            if (playerBlock.getName().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public boolean registerNumberExists (String register_number){
        for (Player player: playerDB){
            if (player.getRegisterNumber().equals(register_number)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Character> getCharacters(){
        return charDB;
    }


    public void setChallenge(Challenge challenge){
        for (Challenge chal:challengeDB){
            if ((chal.getChallenged().equals(challenge.getChallenged())) && (chal.getChallenger().equals(challenge.getChallenger()))){
                return;
            }
        }
    challengeDB.add(challenge);
    }

    public Challenge getChallengeByChallenger(Player player){
        for (Challenge challenge: challengeDB){
            if ((challenge.getChallenger().equals(player)) && (challenge.getValid())){
                challengeDB.remove(challenge);
                saveFiles();
                return challenge;
            }
        }
        return null;
    }


    public Challenge getChallengeByChallenged(Player player){
        for (Challenge challenge: challengeDB){
            if ((challenge.getChallenged().equals(player)) && (challenge.getValid())){
                challengeDB.remove(challenge);
                saveFiles();
                return challenge;
            }
        }
        return null;

    }

    public ArrayList<Challenge> getNonValidatedChallenges(){
        ArrayList<Challenge>nonValidatedChallenges=new ArrayList<>();
        for (Challenge challenge: challengeDB){
            if (!challenge.getValid()){
                nonValidatedChallenges.add(challenge);
            }
        }
        return nonValidatedChallenges;

    }

    public ArrayList<Weaknesses> getAllWeaknesses(){
        return weaknessesDB;
    }

    public ArrayList<Strengths> getAllStrengths(){
        return strengthsDB;
    }

    public void setWeaknessesDB(Weaknesses weaknesses){
        weaknessesDB.add(weaknesses);
    }

    public void removeWeakness(Weaknesses weakness) {
        this.weaknessesDB.remove(weakness);
    }

    public void setStrengths(Strengths strengths){
        this.strengthsDB.add(strengths);
    }

    public void removeStrength(Strengths strength) {
        this.strengthsDB.remove(strength);
    }

    public void deleteChallenge(Challenge challengeToDelete){
        for (Challenge challenge: challengeDB){
            if (challenge.equals(challengeToDelete)){
                challengeDB.remove(challenge);
            }
        }
    }

    public ArrayList<Fight> getNotNotifiedFights(Player player){
            ArrayList<Fight>nonNotified=new ArrayList<>();
            for(Fight fights:fightDB){
                if ((!fights.getNotified())&&(fights.getChallenger().getName().equals(player.getName()))){
                    nonNotified.add(fights);
                }
            }
            return nonNotified;
    }

    public void blockUser(Player player) {
        this.playerDB.remove(player);
        this.userBlockDB.add(player);
    }

    public void unlockUser(Player player) {
        this.userBlockDB.remove(player);
        this.playerDB.add(player);
    }

    public ArrayList<Fight> getFights(Player player) {
        ArrayList<Fight> selection = new ArrayList<>();
        for (Fight fight : fightDB) {
            if ((player == fight.getChallenger()) || (player == fight.getChallenged())) {
                selection.add(fight);
            }
        }
        return selection;
    }

    public ArrayList<Weapons> getWeaponsDB() {
        return this.weaponsDB;
    }

    public void setWeapon(Weapons weapon) {
        this.weaponsDB.add(weapon);
    }

    public void removeWeapon(Weapons weapon) {
        this.weaponsDB.remove(weapon);
    }

    public ArrayList<Armor> getArmorsDB() {
        return this.armorsDB;
    }

    public void setArmor(Armor armor) {
        this.armorsDB.add(armor);
    }

    public void removeArmor(Armor armor) {
        this.armorsDB.remove(armor);
    }

    public ArrayList<Minions> getMinions() {
        return this.minionsDB;
    }

    public void setMinion(Minions minion) {
        this.minionsDB.add(minion);
    }

    public void removeMinion(Minions minion) {
        this.minionsDB.remove(minion);
    }
}


