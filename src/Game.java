import java.util.Scanner;

public class  Game {

    public Game(DataBaseManager dataBase) {
        this.dataBase=dataBase;
    }

    private User user;

    private DataBaseManager dataBase;

    public void login(String nick, String pass) {
        this.user = dataBase.getUserByNick(nick);
        if (this.user != null) {
            boolean correctPass = this.user.checkPassword(pass);
            if (correctPass) {
                boolean deleteAccount = user.showMenu();
                if (deleteAccount) {
                    dataBase.deleteUser(this.user);
                }
                this.user = null;
            } else {
                System.out.println("Incorrect password!");
            }
        } else if (dataBase.isUserBlock(nick)) {
            System.out.println("This account has been blocked");

        } else {
            System.out.println("That nickname doesn't exist!");
        }

    }

    public void register(String name, String nick, String pass, TUser type) {
        if (!this.dataBase.checkExistsNick(nick)) {
            switch (type) {
                case Player:
                    this.user = new Player(name, nick, pass, dataBase);
                    Player player = (Player) this.user;
                    this.dataBase.setPlayerDB(player);
                    break;
                case Operator:
                    this.user = new Operator(name, nick, pass, dataBase);
                    Operator operator = (Operator) this.user;
                    this.dataBase.setOperatorDB(operator);
                    break;
            }
        } else {
            System.out.println("That nickname already exists");
        }
    }

    public void showWelcome() {
        System.out.println("WELCOME TO FIGHT CLUB!!");

        this.dataBase = new DataBaseManager();

        int exit = 0;

        while (exit != 1) {
            exit = 0;
            System.out.println("1. Log in");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int input = NumReader.readNumber();

            switch (input) {
                case 1:
                    this.showMenuLogin();
                    break;
                case 2:
                    this.showMenuRegister();
                    break;
                case 3:
                    System.out.println("Please enter 1 to confirm exit");
                    exit = NumReader.readNumber();
                    if (exit == 1) {
                        System.out.println("Byebye!");
                    }
                    break;
                default:
                    System.out.println(input + " is not a valid option");
            }
        }
        this.dataBase.saveFiles();
    }

    private void showMenuLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write your nickname: ");
        String nick = scanner.nextLine();
        System.out.print("Write your password: ");
        String pass = scanner.nextLine();
        this.login(nick, pass);
    }

    private void showMenuRegister() {
        Scanner scanner = new Scanner(System.in);
        TUser userType = null;
        int input;
        while (userType == null) {
            System.out.println("Choose a role:");
            System.out.println("1. Player");
            System.out.println("2. Operator");
            input = NumReader.readNumber();
            switch (input) {
                case 1:
                    userType = TUser.Player;
                    break;
                case 2:
                    userType = TUser.Operator;
                    break;
                default:
                    System.out.println(input + " is not a valid option");
            }
        }
        System.out.print("Write your name: ");
        String name = scanner.nextLine();
        System.out.print("Write your nickname: ");
        String nick = scanner.nextLine();
        String pass, pass2;
        do {
            System.out.print("Write your password: ");
            pass = scanner.nextLine();
            while (8 > pass.length() || pass.length() > 12){
                System.out.println("Your password must be between 8 and 12 characters");
                pass = scanner.nextLine();
            }
            System.out.println("Repeat your password:");
            pass2= scanner.nextLine();
            if (!pass.equals(pass2)){
                System.out.println("Passwords don´t match");
            }
        } while (!pass.equals(pass2));
        this.register(name, nick, pass, userType);
    }
}