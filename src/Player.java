
import java.io.*;
import java.util.*;

/**
 *
 */
public class Player extends User {

    /**
     * Default constructor
     */
    public Player(String username, String nick, String pass, DataBaseManager db) {
        super(username, nick, pass, TUser.Player, db);

        Random rand = new Random();
        StringBuilder newNumber;

        boolean registerExists = false;

        do {
            newNumber = new StringBuilder();

            char letter1 = (char) (rand.nextInt(26) + 'A');
            newNumber.append(letter1);
            int num1 = rand.nextInt(10);
            newNumber.append(num1);
            int num2 = rand.nextInt(10);
            newNumber.append(num2);
            char letter2 = (char) (rand.nextInt(26) + 'A');
            newNumber.append(letter2);
            char letter3 = (char) (rand.nextInt(26) + 'A');
            newNumber.append(letter3);

            //registerExists = super.dataBase.registerNumberExists(newNumber);
        } while (registerExists);

        registerNumber = newNumber.toString();
    }

    /**
     *
     */
    private String registerNumber;

    /**
     *
     */
    private ArrayList<CharacterUser> characters;

    /**
     *
     */
    private boolean block;

    /**
     *
     */
    private void registerCharacter() {
        // TODO implement here
        System.out.println("Not Implemented Yet");
    }

    /**
     *
     */
    private void deleteCharacter() {
        // TODO implement here
        System.out.println("Not Implemented Yet");
    }

    /**
     *
     */
    private void chooseEquipment() {
        // TODO implement here
        System.out.println("Not Implemented Yet");
    }

    /**
     *
     */
    private void createChallenge() {
        // TODO implement here
        System.out.println("Not Implemented Yet");
    }

    /**
     *
     */
    private void showHistory() {
        // TODO implement here
        System.out.println("Not Implemented Yet");
    }

    /**
     * @return
     */
    public boolean showMenuPlayer() {
        // TODO implement here
        return false;
    }

    /**
     *
     */
    private void showRanking() {
        // TODO implement here
        System.out.println("Not Implemented Yet");
    }

    /**
     *
     */
    private void challengeMenu() {
        System.out.println("Not Implemented Yet");
    }

    /**
     * @return
     */
    public CharacterUser getCharacter() {
        // TODO implement here
        return null;
    }

    @Override
    public boolean showMenu() {
        System.out.println("Welcome " + super.getName());
        this.challengeMenu();
        Scanner scanner = new Scanner(System.in);
        int exit = 0;
        while (exit != 1) {
            System.out.println("1. Add a character");
            System.out.println("2. Delete a character");
            System.out.println("3. Choose armor and weapons");
            System.out.println("4. Challenge another player");
            System.out.println("5. Check previous fights");
            System.out.println("6. Check global ranking");
            System.out.println("7. Exit");
            System.out.println("8. Delete user");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    this.registerCharacter();
                    break;
                case 2:
                    this.deleteCharacter();
                    break;
                case 3:
                    this.chooseEquipment();
                    break;
                case 4:
                    this.createChallenge();
                    break;
                case 5:
                    this.showHistory();
                    break;
                case 6:
                    this.showRanking();
                    break;
                case 7:
                    System.out.println("Press 1 to confirm exit");
                    exit = scanner.nextInt();
                    break;
                case 8:
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