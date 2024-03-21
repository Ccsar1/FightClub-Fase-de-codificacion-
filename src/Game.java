import java.io.*;
import java.util.*;

/**
 *
 */
public class Game {

    /**
     * Default constructor
     */
    public Game() {
    }

    /**
     *
     */
    private User user;

    /**
     *
     */
    private DataBaseManager dataBase;

    /**
     * @param nick
     * @param pass
     */
    private void login(String nick, String pass) {
        //user = dataBase.getUserByNick(nick);
        System.out.println("---searching for user by nickname");
        if (user != null) {
            boolean correctPass = user.checkPassword(pass);
            if (correctPass) {
                boolean deleteAccount = false;
                //deleteAccount = user.showMenu();
                System.out.println("---logging in and showing users menu");
                if (deleteAccount) {
                    this.deleteAccount();
                }
            } else {
                System.out.println("Incorrect password!");
            }
        } else {
            System.out.println("That nickname doesn't exist!");
        }

    }

    /**
     * @param nombre
     * @param nick
     * @param cont
     * @param Type
     * @return
     */
    private boolean register(String nombre, String nick, String cont, TUser Type) {
        // TODO implement here
        System.out.println("Not Implemented Yet");
        return false;
    }

    /**
     *
     */
    public void showWelcome() throws IOException {
        System.out.println("WELCOME TO FIGHT CLUB!!");

        //this.initializeDB();
        System.out.println("---initializing database");

        int exit = 0;

        while (exit != 1) {
            exit = 0;
            System.out.println("1. Log in");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    this.showMenuLogin();
                    break;
                case 2:
                    this.showMenuRegister();
                    break;
                case 3:
                    System.out.println("Please enter 1 to confirm exit");
                    exit = scanner.nextInt();
                    if (exit == 1) {
                        System.out.println("Byebye!");
                    }
                    break;
                default:
                    System.out.println(input + " is not a valid option");
            }
        }
        //dataBase.saveDB();
        System.out.println("---saving database");
    }

    private void initializeDB() throws IOException {

        String filePath = "database.xml";

        File file = new File(filePath);

        if (file.exists()) {
            try {
                //this.dataBase = DataBaseManager.loadDB(filePath);
                System.out.println("---loading database");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            this.dataBase = new DataBaseManager();
        }
    }

    /**
     *
     */
    private void showMenuLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write your nickname: ");
        String nick = scanner.nextLine();
        System.out.print("Write your password: ");
        String pass = scanner.nextLine();
        this.login(nick, pass);
    }

    /**
     *
     */
    private void showMenuRegister() {
        // TODO implement here
        System.out.println("Not Implemented Yet");
    }

    /**
     *
     */
    private void deleteAccount() {
        // TODO implement here
        System.out.println("Not Implemented Yet");
    }
}