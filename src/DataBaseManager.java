
import java.io.*;
import java.util.*;


public class DataBaseManager {

    private ArrayList<Character>charDB= new ArrayList<>();
    private ArrayList<Fight>fightDB= new ArrayList<>();
    private ArrayList<User>userDB= new ArrayList<>();
    private ArrayList<Equipment>equipmentDB= new ArrayList<>();
    private ArrayList<Challenge>challengeDB= new ArrayList<>();
    private ArrayList<User>userBlockDB= new ArrayList<>();

    public void setCharDB(Character character) {
        charDB.add(character);
    }
    public void setFightDB(Fight fight){
        fightDB.add(fight);
    }
    public void setUserDB(User user){
        userDB.add(user);
    }
    public void setEquipmentDB(Equipment equipment){
        equipmentDB.add(equipment);
    }
    public void setChallengeDB(Challenge challenge){
        challengeDB.add(challenge);
    }

    public User getUserByNick(String nick){
        for(User user:userDB){

            if (user.getNick().equals(nick)){
                return user;
            }

        }
        return null;

    }

    public String blockUser(String nick){
        for(User user:userDB){
            if(user.getNick().equals(nick)){
                userDB.remove(user);
                userBlockDB.add(user);
                return ("User has been blocked");
            }
        }
        return ("User don´t exist. Try again.");
    }

    public String unlockUser(String nick){
        for(User user:userDB){
            if(user.getNick().equals(nick)){
                userBlockDB.remove(user);
                userDB.add(user);
                return ("User has been unlocked");
            }
        }
        return ("User don´t exist. Try again.");
    }

    public void getRanking(){
        Collections.sort(charDB, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(o1.getGold(),o2.getGold());
            }
        });
        }

    public String deleteCharacter (String name){
        for (Character character:charDB){
            if(character.getName().equals(name)){
                charDB.remove(character);
                return ("Character deleted");
            }
        }
        return ("Character not found. Try again");
    }

    }


