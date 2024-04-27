
import java.util.*;

public class Operator extends User {

    public Operator(String username, String nick, String pass, DataBaseManager db) {
        super(username, nick, pass, TUser.Operator, db);
    }

    public void validateChallenge() {
        ArrayList<Challenge> challengesArray = super.dataBase.getNonValidatedChallenges();
        int input;
        do {
            if (!challengesArray.isEmpty()) {
                Challenge challenge = challengesArray.get(0);
                System.out.println("The player " + challenge.getChallenger().getNick() + " has bet " + challenge.getGold() + " gold in a challenge against the player " + challenge.getChallenged().getNick());
                System.out.println("Do you want to validate this challenge?");
                System.out.println("1. Validate challenge");
                System.out.println("2. Delete challenge");
                System.out.println("3. Go back");
                do {
                    input = NumReader.readNumber();
                } while (input < 1 || input > 3);
                switch (input) {
                    case 1:
                        challenge.setValid();
                        challengesArray.remove(challenge);
                        break;
                    case 2:
                        super.dataBase.deleteChallenge(challenge);
                        challengesArray.remove(challenge);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println(input + " is not a valid option");
                }
                if (input == 1) {
                    System.out.println("Choose one of the following modifiers to be present in the fight");
                    int j = 1;
                    ArrayList<Modifiers> modifiersArray = super.dataBase.getAllModifiers();
                    for (Modifiers modifier : modifiersArray) {
                        System.out.println(j + ". " + modifier.getName());
                        j++;
                    }
                    int modifierIndex = NumReader.readNumber();
                    if (modifierIndex >= 0 && modifierIndex <= modifiersArray.size()) {
                        challenge.setModifier(modifiersArray.get(modifierIndex - 1));
                    }
                }
            } else {
                System.out.println("There are no more challenges to validate");
                input = 3;
            }
        } while (input != 3);
    }

    public void blockUser() {
        ArrayList<Player> playersArray = super.dataBase.getAllPlayers();
        if (playersArray.isEmpty()){
            System.out.println("No players to block");
            return;
        }
        System.out.println("Select a player to block its account");
        int i = 1;
        for (Player player : playersArray) {
            System.out.println(i + ". " + player.getName());
            i++;
        }
        i = NumReader.readNumber();
        if (i > 1 && i < playersArray.size()) {
            super.dataBase.blockUser(playersArray.get(i - 1));
        }
    }

    public void unlockUser() {
        ArrayList<Player> blockedPlayersArray = super.dataBase.getAllBlock();
        System.out.println("Select a player to unlock its account");
        int i = 1;
        for (Player blockedPlayer : blockedPlayersArray) {
            System.out.println(i + ". " + blockedPlayer.getName());
            i++;
        }
        i = NumReader.readNumber();
        if (i > 1 && i <= blockedPlayersArray.size()) {
            super.dataBase.unlockUser(blockedPlayersArray.get(i - 1));
        }
    }

    @Override
    public boolean showMenu() {
        System.out.println("Welcome " + super.getName());
        int exit = 0;
        while (exit != 1) {
            System.out.println("1. Create or edit properties of the game");
            System.out.println("2. Validate challenges");
            System.out.println("3. Block players");
            System.out.println("4. Unblock players");
            System.out.println("5. Exit");
            System.out.println("6. Delete user");

            int input = NumReader.readNumber();

            switch (input) {
                case 1:
                    PropertiesEditor propertiesEditor = new PropertiesEditor(super.dataBase);
                    propertiesEditor.showMenu();
                    break;
                case 2:
                    this.validateChallenge();
                    break;
                case 3:
                    this.blockUser();
                    break;
                case 4:
                    this.unlockUser();
                    break;
                case 5:
                    System.out.println("Press 1 to confirm exit");
                    exit = NumReader.readNumber();
                    break;
                case 6:
                    System.out.println("Press 1 to exit and delete your user");
                    exit = NumReader.readNumber();
                    if (exit == 1) {
                        return true;
                    }
                default:
                    System.out.println(input + " is not a valid option");
            }
        }
        return false;
    }
}