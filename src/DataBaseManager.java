
import java.io.*;
import java.util.*;


public class DataBaseManager implements Serializable{

    private ArrayList<Character> charDB = new ArrayList<>();
    private ArrayList<Fight> fightDB = new ArrayList<>();
    private ArrayList<Player> playerDB = new ArrayList<>();
    private ArrayList<Operator> operatorDB = new ArrayList<>();
    private ArrayList<Equipment> equipmentDB = new ArrayList<>();
    private ArrayList<Challenge> challengeDB = new ArrayList<>();
    private ArrayList<Player> userBlockDB = new ArrayList<>();


    public DataBaseManager() {
        loadFiles();

    }


    public void loadFiles() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("FightClub.ser"))) {
            DataBaseManager savedData = (DataBaseManager) inputStream.readObject();
            this.playerDB = savedData.playerDB;
            this.operatorDB = savedData.operatorDB;
            this.userBlockDB = savedData.userBlockDB;
            this.charDB = savedData.charDB;
            this.fightDB = savedData.fightDB;
            this.challengeDB = savedData.challengeDB;
            this.equipmentDB = savedData.equipmentDB;
        } catch (FileNotFoundException e) {

            this.playerDB = new ArrayList<>();
            this.operatorDB = new ArrayList<>();
            this.userBlockDB = new ArrayList<>();
            this.charDB = new ArrayList<>();
            this.fightDB = new ArrayList<>();
            this.challengeDB = new ArrayList<>();
            this.equipmentDB = new ArrayList<>();
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

    public boolean setCharDB(Character character) {
        for (Character personaje : charDB) {
            if (personaje.equals(character)) {
                return false;
            }
        }
        charDB.add(character);
        saveFiles();
        return true;
    }

    public void setFightDB(Fight fight) {
        fightDB.add(fight);
        saveFiles();

    }

    public void setPlayerDB(Player player) {
        for (Player usuario : playerDB) {
            if (usuario.getNick().equals(player.getNick())) {
                return;
            }
        }
        for (Player userBlock : userBlockDB) {
            if (userBlock.getNick().equals(player.getNick())) {
                return;
            }
        }
        playerDB.add(player);
        saveFiles();
    }

    public void getPlayersDB() {
        for (Player player : playerDB) {
            System.out.println("Name " + player.getName() + ",nick: " + player.getNick() + ",password: " + player.getPassword() + ",register number: " + player.getRegister_number());
        }
    }

    public void setOperatorDB(Operator operator) {
        for (Operator usuario : operatorDB) {
            if (usuario.getNick().equals(operator.getNick())) {
                return;
            }
        }
        operatorDB.add(operator);
        saveFiles();
    }

    public void getOpeartorsDB() {
        for (Operator operator : operatorDB) {
            System.out.println("Name " + operator.getName() + ",nick: " + operator.getNick() + ",password: " + operator.getPassword());
        }
    }

    public void getUsersBlockDB() {
        for (Player player : userBlockDB) {
            System.out.println("Name " + player.getName() + ",nick: " + player.getNick() + ",password: " + player.getPassword() + ",register number: " + player.getRegister_number());
        }
    }

    public void setEquipmentDB(Equipment equipment) {
        equipmentDB.add(equipment);
        saveFiles();
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


    public void blockUser(String nick) {
        for (Player player : playerDB) {
            if (player.getNick().equals(nick)) {
                playerDB.remove(player);
                userBlockDB.add(player);
                saveFiles();
                return;
            }
        }

    }

    public void unlockUser(String nick) {
        for (Player player : userBlockDB) {
            if (player.getNick().equals(nick)) {
                userBlockDB.remove(player);
                playerDB.add(player);
                saveFiles();
                return;
            }
        }

    }

    public void deleteUser(String nick) {
        Iterator<Player> iterator = playerDB.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getNick().equals(nick)) {
                iterator.remove();
            }
        }
        Iterator<Player> iteratorBlock = userBlockDB.iterator();
        while (iteratorBlock.hasNext()) {
            Player player = iteratorBlock.next();
            if (player.getNick().equals(nick)) {
                iteratorBlock.remove();
            }
        }
        saveFiles();
    }

    public Character getCharacterByName(String name){
        for (Player player : playerDB) {
            ArrayList<Character>allCharacter=new ArrayList<>();
            allCharacter.addAll(player.getPersonajes());
            for (Character character: allCharacter) {
                if (character.getName().equals(name)) {
                    return character;

                }

            }
        }
        return null;
    }
    public void getRanking() {
        ArrayList<CharacterUser>allcharacters= new ArrayList<>();

        for (Player player:playerDB){
            allcharacters.addAll(player.getPersonajes());
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
    public void deleteCharacter(String name) {
        boolean found=false;
        for (Player player : playerDB) {
            ArrayList<CharacterUser>allCharacterUser=new ArrayList<>();
            allCharacterUser.addAll(player.getPersonajes());
            for (CharacterUser character: allCharacterUser){
                if (character.getName().equals(name)) {
                    allCharacterUser.remove(character);
                    found=true;
                }

            }
            if (found){
                playerDB.setPersonajes(allCharacterUser);
                saveFiles();
                return;
            }

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
            if (character.getNick().equals(nick)){
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
            if (challenge.getValid()==false){
                nonValidatedChallenges.add(challenge);
            }
        }
        return nonValidatedChallenges;

    }


}


