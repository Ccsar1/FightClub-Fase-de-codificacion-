
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class DataBaseManager implements Serializable{

    private ArrayList<Character> charDB;
    private ArrayList<Fight> fightDB;
    private ArrayList<Modifiers> modifiersDB;
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
            this.modifiersDB = savedData.modifiersDB;
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
            this.modifiersDB = new ArrayList<>();
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
        this.challengeDB.removeIf(challenge -> challenge.containsCharacter(character));
        for (Player player : this.playerDB) {
            player.removeCharacter(character);
        }
        for (Player player : this.userBlockDB) {
            player.removeCharacter(character);
        }
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

    public void setOperatorDB(Operator operator) {
        operatorDB.add(operator);
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
                this.challengeDB.removeIf(challenge -> challenge.containsPlayer(player));
                saveFiles();
                return;
            }
        }
        Iterator<Operator> iteratorOperator = operatorDB.iterator();
        while (iteratorOperator.hasNext()) {
            Operator operator = iteratorOperator.next();
            if (operator.equals(user)) {
                iteratorOperator.remove();
                saveFiles();
                return;
            }
        }
        saveFiles();

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
            System.out.println(posicion+": User: "+character.getUserNick()+", Name: "+character.getName()+",Gold: "+character.getGold());
            posicion++;
        }


    }

    public boolean isUserBlock (String nick){
        for (Player player: userBlockDB){
            if (player.getNick().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public boolean checkExistsNick(String nick){
        for (Player player:playerDB){
            if (player.getNick().equals(nick)){
                return true;
            }
        }
        for (Operator operator:operatorDB){
            if (operator.getNick().equals(nick)){
                return true;
            }
        }
        for (Player playerBlock:userBlockDB){
            if (playerBlock.getNick().equals(nick)){
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
        saveFiles();
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

    public ArrayList<Modifiers> getAllModifiers(){
        return this.modifiersDB;
    }

    public void setModifier(Modifiers modifier){
        this.modifiersDB.add(modifier);
        saveFiles();
    }

    public void removeModifier(Modifiers modifier) {
        this.modifiersDB.remove(modifier);
        for (Challenge challenge : this.challengeDB) {
            challenge.removeModifier(modifier);
        }
        for (Character character : this.charDB) {
            character.removeModifier(modifier);
        }
        saveFiles();
    }

    public void deleteChallenge(Challenge challengeToDelete){
        challengeDB.remove(challengeToDelete);
        saveFiles();
    }
    public ArrayList<Challenge> getAllChallengeDB(){
        return this.challengeDB;
    }

    public ArrayList<Fight> getNotNotifiedFights(Player player){
            ArrayList<Fight>nonNotified=new ArrayList<>();
            for(Fight fights:fightDB){
                if ((!fights.getNotified())&&(fights.getChallenger().equals(player))){
                    nonNotified.add(fights);
                }
            }
            return nonNotified;
    }

    public void blockUser(Player playerBlock) {
        playerDB.remove(playerBlock);
        userBlockDB.add(playerBlock);
        saveFiles();

    }

    public boolean userInChallenge (Player player){

        for (Challenge challenge: challengeDB){
            if(((challenge.getChallenged()==player)|| (challenge.getChallenger()==player))){
                return true;
            }
        }
        return false;

    }
    public void unlockUser(Player playerBlock) {
        playerDB.add(playerBlock);
        userBlockDB.remove(playerBlock);
        saveFiles();

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
        saveFiles();
    }

    public void removeWeapon(Weapons weapon) {
        this.weaponsDB.remove(weapon);
        for (Character character : this.charDB) {
            ArrayList<Weapons> characterWeaponsArray = character.getWeapons();
            characterWeaponsArray.remove(weapon);
        }
        for (Player player : this.playerDB) {
            player.removeWeapon(weapon);
        }
        for (Player player : this.userBlockDB) {
            player.removeWeapon(weapon);
        }
        saveFiles();
    }

    public ArrayList<Armor> getArmorsDB() {
        return this.armorsDB;
    }

    public void setArmor(Armor armor) {
        this.armorsDB.add(armor);
        saveFiles();
    }

    public void removeArmor(Armor armor) {
        this.armorsDB.remove(armor);
        for (Character character : this.charDB) {
            ArrayList<Armor> characterArmorsArray = character.getArmor();
            characterArmorsArray.remove(armor);
        }
        for (Player player : this.playerDB) {
            player.removeArmor(armor);
        }
        for (Player player : this.userBlockDB) {
            player.removeArmor(armor);
        }
        saveFiles();
    }

    public ArrayList<Minions> getMinions() {
        return this.minionsDB;
    }

    public void setMinion(Minions minion) {
        this.minionsDB.add(minion);
        saveFiles();
    }

    public void removeMinion(Minions minion) {
        this.minionsDB.remove(minion);
        for (Minions minions : this.minionsDB) {
            if (minions.getType() == TMinion.Demons) {
                Demons demon = (Demons) minions;
                demon.removeMinion(minion);
            }
        }
        for (Character character : this.charDB) {
            character.removeMinion(minion);
        }
        saveFiles();
    }

}


