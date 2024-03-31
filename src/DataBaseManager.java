
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class DataBaseManager implements Serializable{

    private ArrayList<Character> charDB = new ArrayList<>();
    private ArrayList<Fight> fightDB = new ArrayList<>();
    private ArrayList<Weaknesses> weaknessesDB = new ArrayList<>();

    private ArrayList<Strengths> strengthsDB = new ArrayList<>();
    private ArrayList<Player> playerDB = new ArrayList<>();
    private ArrayList<Operator> operatorDB = new ArrayList<>();
    private ArrayList<Challenge> challengeDB = new ArrayList<>();
    private ArrayList<Player> userBlockDB = new ArrayList<>();


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

        } catch (FileNotFoundException e) {

            this.playerDB = new ArrayList<>();
            this.weaknessesDB = new ArrayList<>();
            this.strengthsDB = new ArrayList<>();
            this.operatorDB = new ArrayList<>();
            this.userBlockDB = new ArrayList<>();
            this.charDB = new ArrayList<>();
            this.fightDB = new ArrayList<>();
            this.challengeDB = new ArrayList<>();

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

    public void setFightDB(Fight fight) {
        fightDB.add(fight);
        saveFiles();

    }

    public void setPlayerDB(Player player) {
        playerDB.add(player);
        saveFiles();
    }

    public void getPlayersDB() {
        for (Player player : playerDB) {
            System.out.println("Name " + player.getName() + ",nick: " + player.getNick());
        }
    }

    public void setOperatorDB(Operator operator) {
        operatorDB.add(operator);
        saveFiles();
    }

    public void getOpeartorsDB() {
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

    public void blockUser(Player player) {
                playerDB.remove(player);
                userBlockDB.add(player);
                saveFiles();


    }

    public void unlockUser(Player player) {
                userBlockDB.remove(player);
                playerDB.add(player);
                saveFiles();

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
        Iterator<Player> iteratorBlock = userBlockDB.iterator();
        while (iteratorBlock.hasNext()) {
            Player player = iteratorBlock.next();
            if (player.equals(user)) {
                iteratorBlock.remove();
                return;
            }
        }
        Iterator<Operator> iteratorOperator = operatorDB.iterator();
        while (iteratorBlock.hasNext()) {
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

    public void setStrengthsDBDB(Strengths strengths){
        strengthsDB.add(strengths);
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
}


