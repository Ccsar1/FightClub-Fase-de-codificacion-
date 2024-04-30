
import java.io.*;
import java.util.*;

public class Player extends User {

    public Player(String username, String nick, String pass, DataBaseManager db) {
        super(username, nick, pass, TUser.Player, db);

        Random rand = new Random();
        StringBuilder newNumber;

        boolean numberExists = false;

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

            this.registerNumber = newNumber.toString();

            numberExists = super.dataBase.registerNumberExists(registerNumber);
        } while (numberExists);

        characters = new ArrayList<>();
    }

    private String registerNumber;

    private ArrayList<CharacterUser> characters;

    private void registerCharacter() {
        ArrayList<Character> characterArray = super.dataBase.getCharacters();
        int input = 1;
        int i;
        if (characterArray.isEmpty()) {
            System.out.println("There are no characters available");
        } else {
            do {
                System.out.println("Choose your character");
                i = 1;
                for (Character character : characterArray) {
                    System.out.println(i + ". " + character.getName());
                    i++;
                }
                input = NumReader.readNumber();
                if (input < 1 || input > characterArray.size()) {
                    System.out.println(input + " is not a valid option");
                }

            } while (input < 1 || input > characterArray.size());
            Character selectedCharacter = characterArray.get(input - 1);
            CharacterUser newCharacter = new CharacterUser(selectedCharacter, super.getNick());
            this.characters.add(newCharacter);
            addEquipment(newCharacter);
        }}

        private void addEquipment (CharacterUser selectedCharacter){
            int i,input;
            selectedCharacter.deleteWeapons();
            ArrayList<Weapons> posibleWeapons = selectedCharacter.getWeapons();
            System.out.println("Select a weapon");
            i = 1;
            for (Weapons weapon : posibleWeapons) {
                System.out.println(i + ". " + weapon.getName());
                i++;
            }
            input = NumReader.readNumber();
            if (input < 1 || input > posibleWeapons.size()) {
                System.out.println(input + " is not a valid option, no weapon was chosen");
            } else {
                Weapons selectedWeapon = posibleWeapons.get(input - 1);
                selectedCharacter.setWeapons(selectedWeapon);
                if (selectedWeapon.getWeaponType() == 1) {
                    ArrayList<Weapons> oneHandWeapons = new ArrayList<>();
                    for (Weapons weapon : posibleWeapons) {
                        if (weapon.getWeaponType() == 1) {
                            oneHandWeapons.add(weapon);
                        }
                    }
                    System.out.println("Select a secondary weapon");
                    i = 1;
                    for (Weapons weapon : oneHandWeapons) {
                        System.out.println(i + ". " + weapon.getName());
                        i++;
                    }
                    input = NumReader.readNumber();
                    if (input < 1 || input > oneHandWeapons.size()) {
                        System.out.println(input + " is not a valid option, no secondary weapon was chosen");
                    } else {
                        Weapons secondaryWeapon = oneHandWeapons.get(input - 1);
                        selectedCharacter.setWeapons(secondaryWeapon);
                    }
                }
            }

            ArrayList<Armor> posibleArmors = selectedCharacter.getArmors();
            System.out.println("Select an armor");
            i = 1;
            for (Armor armor : posibleArmors) {
                System.out.println(i + ". " + armor.getName());
                i++;
            }
            input = NumReader.readNumber();
            if (input < 1 || input > posibleArmors.size()) {
                System.out.println(input + " is not a valid option, no armor was chosen");
            } else {
                Armor selectedArmor = posibleArmors.get(input - 1);
                selectedCharacter.setArmor(selectedArmor);
            }
        }
        private void deleteCharacter () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the character you want to delete");
            int i = 1;
            for (CharacterUser character : this.characters) {
                System.out.println(i + ". " + character.getName());
                i++;
            }
            int input = NumReader.readNumber();
            if (input >= 1 && input <= this.characters.size()) {
                this.characters.remove(input - 1);
            } else {
                System.out.println(input + " is not a valid option, so no character was deleted");
            }
        }

        private void chooseEquipment () {

            int input = 1;
            int i;
            do {
                System.out.println("Select a character to change its equipment");
                i = 1;
                for (CharacterUser character : this.characters) {
                    System.out.println(i + ". " + character.getName());
                    i++;
                }
                input = NumReader.readNumber();
                if (input < 1 || input > this.characters.size()) {
                    System.out.println(input + " is not a valid option");
                }
            } while (input < 1 || input > this.characters.size());
            CharacterUser selectedCharacter = this.characters.get(input - 1);
            addEquipment(selectedCharacter);
        }

        private void createChallenge () {
            if (!this.characters.isEmpty()) {
                if (!super.dataBase.userInChallenge(this)) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Write the nickname of the player you want to fight: ");
                    String challengedNick = scanner.nextLine();
                    Player challengedPlayer = super.dataBase.getPlayerByNick(challengedNick);

                    if (challengedPlayer != null && challengedPlayer != this) {
                        if (!challengedPlayer.getCharacters().isEmpty()) {
                            int input = 1;
                            int i;
                            do {
                                System.out.println("Choose your character");
                                i = 1;
                                for (CharacterUser character : this.characters) {
                                    System.out.println(i + ". " + character.getName());
                                    i++;
                                }
                                input = NumReader.readNumber();
                                if (input < 1 || input > this.characters.size()) {
                                    System.out.println(input + " is not a valid option");
                                }
                            } while (input < 1 || input > this.characters.size());
                            CharacterUser challengerCharacter = this.characters.get(input - 1);
                            ArrayList<CharacterUser> charactersChallengedNeed = challengedPlayer.getCharacters();
                            int goldBet = 0;
                            boolean foundPossibility = false;
                            do {
                                System.out.println("How much gold do you want to bet? You have " + challengerCharacter.getGold());
                                goldBet = NumReader.readNumber();
                                if (goldBet < 0 || goldBet > challengerCharacter.getGold()) {
                                    System.out.println(goldBet + " is not a valid amount");
                                } else {
                                    for (CharacterUser characterTest : charactersChallengedNeed) {
                                        if (characterTest.getGold() >= goldBet) {
                                            foundPossibility = true;
                                        }
                                    }
                                    if (!foundPossibility) {
                                        System.out.println("None of the characters of " + challengedNick + " has the amount of the gold bet");
                                        return;
                                    }
                                }
                            } while (goldBet < 0 || goldBet > challengerCharacter.getGold());
                            Challenge newChallenge = new Challenge(this, challengedPlayer, challengerCharacter, goldBet);
                            super.dataBase.setChallenge(newChallenge);
                        } else {
                            System.out.println("The player " + challengedNick + " does not have any character");
                        }
                    } else if (challengedPlayer == this) {
                        System.out.println("You can't challenge yourself");

                    }else {
                        System.out.println("The player " + challengedNick + " does not exist");
                        return;
                    }
                } else {
                    System.out.println("You have already send a challenge");
                }
            }else{
                System.out.println("You should create at least one character before you enter a fight");
            }

        }

        private void showHistory () {
            ArrayList<Fight> fightArray = super.dataBase.getFights(this);
            for (Fight fight : fightArray) {
                fight.showPayment();
            }
        }

        private void showRanking () {
            super.dataBase.getRanking();
        }

        private void challengeMenu () {
            Challenge challenge;
            int input;
            do {
                challenge = super.dataBase.getChallengeByChallenged(this);
                if (challenge != null) {
                    System.out.println(challenge.getChallenger().getNick() + " has challenged you to a fight!");
                    do {
                        System.out.println("Do you accept? 1. Yes 2. No");
                        input = NumReader.readNumber();
                    } while (input != 1 && input != 2);
                    if (input == 1) {
                        int i;
                        do {
                            System.out.println("Choose your character");
                            i = 1;
                            for (CharacterUser character : this.characters) {
                                if (challenge.getGold() <= character.getGold()) {
                                    System.out.println(i + ". " + character.getName());

                                } else {
                                    System.out.println(i + ". Not choose");
                                }
                                i++;
                            }
                            input = NumReader.readNumber();
                            if (input < 1 || input > this.characters.size()) {
                                System.out.println(input + " is not a valid option");
                            }
                        } while (((input < 1 || input > this.characters.size()) || (this.characters.get(input - 1).getGold() < challenge.getGold())));
                        CharacterUser selectedCharacter = this.characters.get(input - 1);

                        this.addEquipment(selectedCharacter);

                        Fight newFight = new Fight(challenge.getChallenger(), challenge.getChallenged(), challenge.getChallengerCharacter(), selectedCharacter, challenge.getGold(), challenge.getModifier());
                        newFight.startFight();
                        newFight.showResult();
                        super.dataBase.setFightDB(newFight);
                    } else {
                        int i;
                        do {
                            System.out.println("Choose a character that will pay for not fighting");
                            i = 1;
                            for (CharacterUser character : this.characters) {
                                System.out.println(i + ". " + character.getName());
                                i++;
                            }
                            input = NumReader.readNumber();
                            if (input < 1 || input > this.characters.size()) {
                                System.out.println(input + " is not a valid option");
                            }
                        } while (input < 1 || input > this.characters.size());
                        CharacterUser selectedCharacter = this.characters.get(input - 1);

                        Fight newFight = new Fight(challenge.getChallenger(), challenge.getChallenged(), challenge.getChallengerCharacter(), selectedCharacter, challenge.getGold() / 10, challenge.getModifier());
                        newFight.giveUp();
                        newFight.showResult();
                        super.dataBase.setFightDB(newFight);
                    }
                }
            } while (challenge != null);
        }

        private void notifyFightResult () {
            ArrayList<Fight> fightsArray = super.dataBase.getNotNotifiedFights(this);
            for (Fight fight : fightsArray) {
                fight.showResult();
                fight.setNotified();
            }
        }

        public ArrayList<CharacterUser> getCharacters () {
            return characters;
        }

        public String getRegisterNumber () {
            return this.registerNumber;
        }

        public void removeWeapon(Weapons weapon) {
            for (CharacterUser characterUser : this.characters){
                characterUser.removeWeapon(weapon);
            }

        }

        public void removeArmor(Armor armor) {
            for (CharacterUser characterUser : this.characters) {
                characterUser.removeArmor(armor);
            }
        }

        public void removeCharacter(Character characterToEliminate) {
            this.characters.removeIf(character -> character.getCharacter() == characterToEliminate);
        }

        @Override
        public boolean showMenu () {
            System.out.println("Welcome " + super.getName());
            this.notifyFightResult();
            this.challengeMenu();
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

                int input = NumReader.readNumber();

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
                        exit = NumReader.readNumber();
                        break;
                    case 8:
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
