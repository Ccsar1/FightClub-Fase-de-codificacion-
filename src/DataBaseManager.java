
import java.io.*;
import java.util.*;


public class DataBaseManager implements Serializable{

    private static final long serialVersionUID = 7608283362899377929L;
    private ArrayList<Character> charDB = new ArrayList<>();
    private ArrayList<Fight> fightDB = new ArrayList<>();
    private ArrayList<User> userDB = new ArrayList<>();
    private ArrayList<Equipment> equipmentDB = new ArrayList<>();
    private ArrayList<Challenge> challengeDB = new ArrayList<>();
    private ArrayList<User> userBlockDB = new ArrayList<>();


    public DataBaseManager() {
        loadFiles();

    }


    public void loadFiles() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("datos2.txt"))) {
            DataBaseManager savedData = (DataBaseManager) inputStream.readObject();
            this.userDB = savedData.userDB;
            this.userBlockDB = savedData.userBlockDB;
            this.charDB = savedData.charDB;
            this.fightDB = savedData.fightDB;
            this.challengeDB = savedData.challengeDB;
            this.equipmentDB = savedData.equipmentDB;
        } catch (FileNotFoundException e) {

            this.userDB = new ArrayList<>();
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
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("datos2.txt"))) {
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

    public void setUserDB(User user) {
        for (User usuario : userDB) {
            if (usuario.getNick().equals(user.getNick())) {
                return;
            }
        }
        for (User userBlock : userBlockDB) {
            if (userBlock.getNick().equals(user.getNick())) {
                return;
            }
        }
        userDB.add(user);
        saveFiles();
    }

    public void getUsersDB() {
        for (User user : userDB) {
            System.out.println("Name " + user.getName() + ",nick: " + user.getNick() + ",password: " + user.getPassword() + ",register number: " + user.getRegister_number());
        }
    }

    public void getUsersBlockDB() {
        for (User user : userBlockDB) {
            System.out.println("Name " + user.getName() + ",nick: " + user.getNick() + ",password: " + user.getPassword() + ",register number: " + user.getRegister_number());
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
        for (User user : userDB) {

            if (user.getNick().equals(nick)) {
                return user;
            }

        }
        return null;

    }


    public void blockUser(String nick) {
        for (User user : userDB) {
            if (user.getNick().equals(nick)) {
                userDB.remove(user);
                userBlockDB.add(user);
                saveFiles();
                return;
            }
        }

    }

    public void unlockUser(String nick) {
        for (User user : userBlockDB) {
            if (user.getNick().equals(nick)) {
                userBlockDB.remove(user);
                userDB.add(user);
                saveFiles();
                return;
            }
        }

    }

    public void deleteUser(String nick) {
        Iterator<User> iterator = userDB.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getNick().equals(nick)) {
                iterator.remove();
            }
        }
        Iterator<User> iteratorBlock = userBlockDB.iterator();
        while (iteratorBlock.hasNext()) {
            User user = iteratorBlock.next();
            if (user.getNick().equals(nick)) {
                iteratorBlock.remove();
            }
        }
        saveFiles();
    }

    public void getRanking() {
        Collections.sort(charDB, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(o2.getGold(), o1.getGold());
            }
        });
    }

    public void deleteCharacter(String name) {
        for (Character character : charDB) {
            if (character.getName().equals(name)) {
                charDB.remove(character);
                saveFiles();
                return;
            }

        }

    }

    public boolean isUserBlock (String nick){
        for (User user:userDB){
            if (user.getNick().equals(nick)){
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
}


