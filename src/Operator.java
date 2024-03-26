
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
        // TODO implement here
    }

    /**
     *
     */
    public void addToCharacter() {
        // TODO implement here
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
        // TODO implement here
    }

    /**
     *
     */
    public void unlockUser() {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean showMenuOperator() {
        // TODO implement here
        return false;
    }

    @Override
    public boolean showMenu() {
        System.out.println("Welcome " + super.getName());
        Scanner scanner = new Scanner(System.in);
        int exit = 0;
        while (exit != 1) {
            System.out.println("1. Edit a character");
            System.out.println("2. Add things to a character");
            System.out.println("3. Validate challenges");
            System.out.println("4. Block players");
            System.out.println("5. Unblock players");
            System.out.println("6. Exit");
            System.out.println("7. Delete user");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    this.editCharacter();
                    break;
                case 2:
                    this.addToCharacter();
                    break;
                case 3:
                    this.validateChallenge();
                    break;
                case 4:
                    this.blockUser();
                    break;
                case 5:
                    this.unlockUser();
                    break;
                case 6:
                    System.out.println("Press 1 to confirm exit");
                    exit = scanner.nextInt();
                    break;
                case 7:
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