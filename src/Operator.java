
import java.util.*;

public class Operator extends User {

    public Operator(String username, String nick, String pass, DataBaseManager db) {
        super(username, nick, pass, TUser.Operator, db);
    }

    public void validateChallenge() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Challenge> challengesArray = super.dataBase.getNonValidatedChallenges();
        int i = 0;
        int input;
        if (!challengesArray.isEmpty()) {
            do {
                Challenge challenge = challengesArray.get(i);
                System.out.println("The player " + challenge.getChallenger().getNick() + " has bet " + challenge.getGold() + " gold in a challenge against the player " + challenge.getChallenged().getNick());
                System.out.println("Do you want to validate this challenge?");
                System.out.println("1. Validate challenge");
                System.out.println("2. Delete challenge");
                System.out.println("3. Go back");
                do {
                    input = scanner.nextInt();
                    scanner.nextLine();
                } while (input < 1 || input > 3);
                switch (input) {
                    case 1:
                        challenge.setValid();
                        return;

                    case 2:
                        if (!challengesArray.isEmpty()) {
                            super.dataBase.deleteChallenge(challenge);
                            return;
                        } else {
                            System.out.println("No challenge to manage");


                        }

                        break;
                    case 3:
                        break;
                    default:
                        System.out.println(input + " is not a valid option");
                }
                if (input == 1) {
                    System.out.println("Choose one of the following strengths to be present in the fight");
                    int j = 1;
                    ArrayList<Strengths> strengthsArray = super.dataBase.getAllStrengths();
                    for (Strengths strength : strengthsArray) {
                        System.out.println(j + ". " + strength.getName());
                        j++;
                    }
                    int strengthIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (strengthIndex >= 0 && strengthIndex <= strengthsArray.size()) {
                        challenge.setStrength(strengthsArray.get(strengthIndex - 1));
                    }
                    System.out.println("Choose one of the following weaknesses to be present in the fight");
                    j = 1;
                    ArrayList<Weaknesses> weaknessesArray = super.dataBase.getAllWeaknesses();
                    for (Weaknesses weakness : weaknessesArray) {
                        System.out.println(j + ". " + weakness.getName());
                        j++;
                    }
                    int weaknessIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (weaknessIndex >= 0 && weaknessIndex <= weaknessesArray.size()) {
                        challenge.setWeakness(weaknessesArray.get(weaknessIndex - 1));
                    }
                }
            } while (input != 3);
        }else{
            System.out.println("No challenges to manage");
            return;
        }
    }
    public void blockUser() {
        Scanner scanner = new Scanner(System.in);
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
        i = scanner.nextInt();
        scanner.nextLine();
        if (i >= 1 && i <= playersArray.size()) {
            super.dataBase.blockUser(playersArray.get(i - 1));
        }
    }

    public void unlockUser() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> blockedPlayersArray = super.dataBase.getAllBlock();
        System.out.println("Select a player to unlock its account");
        int i = 1;
        for (Player blockedPlayer : blockedPlayersArray) {
            System.out.println(i + ". " + blockedPlayer.getName());
            i++;
        }
        i = scanner.nextInt();
        scanner.nextLine();
        if (i >= 1 && i <= blockedPlayersArray.size()) {
            super.dataBase.unlockUser(blockedPlayersArray.get(i - 1));
        }
    }

    @Override
    public boolean showMenu() {
        System.out.println("Welcome " + super.getName());
        Scanner scanner = new Scanner(System.in);
        int exit = 0;
        while (exit != 1) {
            System.out.println("1. Create or edit properties of the game");
            System.out.println("2. Validate challenges");
            System.out.println("3. Block players");
            System.out.println("4. Unblock players");
            System.out.println("5. Exit");
            System.out.println("6. Delete user");

            int input = scanner.nextInt();
            scanner.nextLine();

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
                    exit = scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Press 1 to exit and delete your user");
                    exit = scanner.nextInt();
                    scanner.nextLine();
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