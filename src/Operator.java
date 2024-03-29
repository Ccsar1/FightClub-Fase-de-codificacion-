
import java.io.*;
import java.util.*;

/**
 *
 */
public class Operator extends User {

    /**
     * Default constructor
     */
    public Operator(String username, String nick, String pass, DataBaseManager db) {
        super(username, nick, pass, TUser.Operator, db);
    }

    /**
     *
     */
    public void editCharacter() {
        CharacterEditor characterEditor = new CharacterEditor();
        characterEditor.showMenuEditor();
    }

    /**
     *
     */
    public void validateChallenge() {
        // TODO implement here
    }

    /**
     *
     */
    public void blockUser() {
        ArrayList<Player> playersArray = super.dataBase.getPlayersDB();
        System.out.println("Select a player to block its account");
        int i = 1;
        for (Player player : playersArray) {
            System.out.println(i + ". " + player);
            i++;
        }
        if (i > 1 && i < playersArray.size()) {
            super.dataBase.blockUser(playersArray.get(i - 1));
        }
    }

    /**
     *
     */
    public void unlockUser() {
        ArrayList<Player> blockedPlayersArray = super.dataBase.getUsersBlockDB();
        System.out.println("Select a player to unlock its account");
        int i = 1;
        for (Player blockedPlayer : blockedPlayersArray) {
            System.out.println(i + ". " + blockedPlayer);
            i++;
        }
        if (i > 1 && i < blockedPlayersArray.size()) {
            super.dataBase.unlockUser(blockedPlayersArray.get(i - 1));
        }
    }

    @Override
    public boolean showMenu() {
        System.out.println("Welcome " + super.getName());
        Scanner scanner = new Scanner(System.in);
        int exit = 0;
        while (exit != 1) {
            System.out.println("1. Edit a character");
            System.out.println("2. Validate challenges");
            System.out.println("3. Block players");
            System.out.println("4. Unblock players");
            System.out.println("5. Exit");
            System.out.println("6. Delete user");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    this.editCharacter();
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
                    exit = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Press 1 to exit and delete your user");
                    exit = scanner.nextInt();
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