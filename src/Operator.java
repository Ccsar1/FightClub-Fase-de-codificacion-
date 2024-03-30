
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
    public void createCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a name to the new character");
        String charName = scanner.nextLine();
        System.out.println("Write a power value for " + charName + " (must be between 1 and 5");
        int charPower;
        do {
            charPower = scanner.nextInt();
        } while (charPower < 1 || charPower > 5);
        System.out.println("What type of character is it?");
        System.out.println("1. Vampire");
        System.out.println("2. Lycanthrope");
        System.out.println("3. Hunter");
        int typeIndex;
        do {
            typeIndex = scanner.nextInt();
        } while (typeIndex < 1 || typeIndex > 3);
        Character newCharacter;
        switch (typeIndex) {
            case 1:
                System.out.println("Write the name of its discipline");
                String disciplineName = scanner.nextLine();
                System.out.println("Write the attack value of " + disciplineName + " (must be between 1 and 3");
                int disciplineAttack;
                do {
                    disciplineAttack = scanner.nextInt();
                } while (disciplineAttack < 1 || disciplineAttack > 3);
                System.out.println("Write the defence value of " + disciplineName + " (must be between 1 and 3");
                int disciplineDefence;
                do {
                    disciplineDefence = scanner.nextInt();
                } while (disciplineDefence < 1 || disciplineDefence > 3);
                System.out.println("Write the blood cost of " + disciplineName + " (must be between 1 and 3");
                int disciplineCost;
                do {
                    disciplineCost = scanner.nextInt();
                } while (disciplineCost < 1 || disciplineCost > 3);
                SpecialAbility specialAbility = new Disciplines(disciplineName, disciplineAttack, disciplineDefence, disciplineCost);
                newCharacter = new Vampire(charName, charPower, specialAbility);
                break;
            case 2:
                System.out.println("Write the name of its gift");
                String giftName = scanner.nextLine();
                System.out.println("Write the attack value of " + giftName + " (must be between 1 and 3");
                int giftAttack;
                do {
                    giftAttack = scanner.nextInt();
                } while (giftAttack < 1 || giftAttack > 3);
                System.out.println("Write the defence value of " + giftName + " (must be between 1 and 3");
                int giftDefence;
                do {
                    giftDefence = scanner.nextInt();
                } while (giftDefence < 1 || giftDefence > 3);
                System.out.println("Write minimum fury value to use " + giftName);
                int giftFury = scanner.nextInt();
                SpecialAbility specialAbility = new Gift(giftName, giftAttack, giftDefence, giftFury);
                newCharacter = new Lycanthrope(charName, charPower, specialAbility);
                break;
            case 3:
                System.out.println("Write the name of its talent");
                String talentName = scanner.nextLine();
                System.out.println("Write the attack value of " + talentName + " (must be between 1 and 3");
                int talentAttack;
                do {
                    talentAttack = scanner.nextInt();
                } while (talentAttack < 1 || talentAttack > 3);
                System.out.println("Write the defence value of " + talentName + " (must be between 1 and 3");
                int talentDefence;
                do {
                    talentDefence = scanner.nextInt();
                } while (talentDefence < 1 || talentDefence > 3);
                SpecialAbility specialAbility = new Talent(talentName, talentAttack, talentDefence);
                newCharacter = new Hunter(charName, charPower, specialAbility);
        }
        super.dataBase.setCharacter(newCharacter);
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
        Scanner scanner = new Scanner(System.in);
        ArrayList<Challenge> challengesArray = super.dataBase.getNonValidatedChallenges();
        int i = 0;
        int input;
        do {
            Challenge challenge = challengesArray.get(i);
            System.out.println("The player " + challenge.getChallenger().getNick() + " has bet " + challenge.getGold() + " gold in a challenge against the player " + challenge.getChallenged().getNick());
            System.out.println("Do you want to validate this challenge?");
            System.out.println("1. Validate challenge");
            System.out.println("2. Delete challenge");
            System.out.println("3. Go back");
            do {
                input = scanner.nextInt();
            } while (input < 1 || input > 3);
            switch (input) {
                case 1:
                    challenge.setValid();
                    break;
                case 2:
                    super.dataBase.deleteChallenge(challenge);
                    break;
                case 3:
                    break;
                default:
                    System.out.println(input + " is not a valid option");
            }
            if (input == 1) {
                System.out.println("Choose one of the following strengths to be present in the fight");
                int j = 1;
                ArrayList<Strengths> strengthsArray = super.dataBase.getStrengths();
                for (Strengths strength : strengthsArray) {
                    System.out.println(j + ". " + strength.getName());
                    j++;
                }
                int strengthIndex = scanner.nextInt();
                if (strengthIndex >= 0 && strengthIndex <= strengthsArray.size()) {
                    challenge.setStrength(strengthsArray.get(strengthIndex));
                }
                System.out.println("Choose one of the following weaknesses to be present in the fight");
                j = 1;
                ArrayList<Weaknesses> weaknessesArray = super.dataBase.getWeaknesses();
                for (Weaknesses weakness : weaknessesArray) {
                    System.out.println(j + ". " + weakness.getName());
                    j++;
                }
                int weaknessIndex = scanner.nextInt();
                if (weaknessIndex >= 0 && weaknessIndex <= weaknessesArray.size()) {
                    challenge.setWeakness(weaknessesArray.get(weaknessIndex));
                }
            }
        } while (input != 3);
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
            System.out.println("1. Create a character");
            System.out.println("2. Edit a character");
            System.out.println("3. Validate challenges");
            System.out.println("4. Block players");
            System.out.println("5. Unblock players");
            System.out.println("6. Exit");
            System.out.println("7. Delete user");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    this.createCharacter();
                    break;
                case 2:
                    this.editCharacter();
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