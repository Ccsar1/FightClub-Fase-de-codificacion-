
import java.util.*;


public class PropertiesEditor {

    Scanner scanner = new Scanner(System.in);
    private DataBaseManager dataBase;

    public PropertiesEditor(DataBaseManager dataBase) {
        this.dataBase = dataBase;
    }

    public void showMenu() {
        int input = 0;

        while (input != 6) {
            System.out.println("1. View weapons");
            System.out.println("2. View armors");
            System.out.println("3. View modifiers");
            System.out.println("4. View minions");
            System.out.println("5. View characters");
            System.out.println("6. Go back");

            input = NumReader.readNumber();

            switch (input) {
                case 1:
                    this.menuWeapons();
                    break;
                case 2:
                    this.menuArmors();
                    break;
                case 3:
                    this.menuModifiers();
                    break;
                case 4:
                    this.menuMinions();
                    break;
                case 5:
                    this.menuCharacters();
                    break;
                case 6:
                    break;
                default:
                    System.out.println(input + " is not a valid option");
            }
        }
    }

    private void menuWeapons() {
        boolean goBack = false;
        while (!goBack) {
            ArrayList<Weapons> weaponsArray = this.dataBase.getWeaponsDB();
            System.out.println("0. Create a new weapon");
            int i = 1;
            for (Weapons weapon : weaponsArray) {
                System.out.println(i + ". View " + weapon.getName());
                i++;
            }
            System.out.println(weaponsArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
                if (input < 0 || input > weaponsArray.size() + 1){
                    System.out.println("Not a correct value");
                }
            } while (input < 0 || input > weaponsArray.size() + 1);
            if (input == weaponsArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                this.createWeapon();
            } else {
                this.editWeapon(weaponsArray.get(input - 1));
            }
        }
    }

    private void createWeapon() {
        System.out.println("Write the name of the weapon");
        String name = scanner.nextLine();
        System.out.println("Write the attack value (can be between 1 and 3)");
        int attack;
        do {
            attack = NumReader.readNumber();
            if (attack < 1 || attack > 3){
                System.out.println("Not a correct value");
            }
        } while (attack < 1 || attack > 3);
        System.out.println("Write the defense value (can be between 0 and 3)");
        int defense;
        do {
            defense = NumReader.readNumber();
            if (defense < 0 || defense > 3){
                System.out.println("Not a correct value");
            }
        } while (defense < 0 || defense > 3);
        System.out.println("Is it held with 1 or 2 hands?");
        int type;
        do {
            type = NumReader.readNumber();
            if (type < 1 || type > 2){
                System.out.println("Not a correct value");
            }
        } while (type < 1 || type > 2);
        Weapons weapon = new Weapons(name, attack, defense, type);
        this.dataBase.setWeapon(weapon);
    }

    private void editWeapon(Weapons weapon) {
        int input = 0;

        while (input < 5 || input > 6) {
            System.out.println("The weapon " + weapon.getName() + " has " + weapon.getAttackModifier() + " of attack, " + weapon.getDefenseModifier() + " of defense and is held with " + weapon.getWeaponType() + " hands");

            System.out.println("1. Edit name");
            System.out.println("2. Edit attack value");
            System.out.println("3. Edit defense value");
            System.out.println("4. Edit weapon type");
            System.out.println("5. Delete the weapon");
            System.out.println("6. Go back");

            input = NumReader.readNumber();

            switch (input) {
                case 1:
                    System.out.println("Write the new name");
                    String name = scanner.nextLine();
                    weapon.setName(name);
                    break;
                case 2:
                    System.out.println("Write the new attack value (can be between 1 and 3)");
                    int attack;
                    do {
                        attack = NumReader.readNumber();
                        if (attack < 1 || attack > 3){
                            System.out.println("Not a correct value");
                        }
                    } while (attack < 1 || attack > 3);
                    weapon.setAttackModifier(attack);
                    break;
                case 3:
                    System.out.println("Write the new defense value (can be between 0 and 3)");
                    int defense;
                    do {
                        defense = NumReader.readNumber();
                        if (defense < 0 || defense > 3){
                            System.out.println("Not a correct value");
                        }
                    } while (defense < 0 || defense > 3);
                    weapon.setDefenseModifier(defense);
                    break;
                case 4:
                    System.out.println("Is it held with 1 or 2 hands?");
                    int type;
                    do {
                        type = NumReader.readNumber();
                        if (type < 1 || type > 2){
                            System.out.println("Not a correct value");
                        }
                    } while (type < 1 || type > 2);
                    weapon.setWeaponType(type);
                    break;
                case 5:
                    this.dataBase.removeWeapon(weapon);
                    break;
                case 6:
                    break;
                default:
                    System.out.println(input + " is not a valid option");
            }
        }
    }

    private void menuArmors() {
        boolean goBack = false;
        while (!goBack) {
            ArrayList<Armor> armorsArray = this.dataBase.getArmorsDB();
            System.out.println("0. Create a new armor");
            int i = 1;
            for (Armor armor : armorsArray) {
                System.out.println(i + ". View " + armor.getName());
                i++;
            }
            System.out.println(armorsArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
                if (input < 0 || input > armorsArray.size() + 1){
                    System.out.println("Not a correct value");
                }
            } while (input < 0 || input > armorsArray.size() + 1);
            if (input == armorsArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                this.createArmor();
            } else {
                this.editArmor(armorsArray.get(input - 1));
            }
        }
    }

    private void createArmor() {
        System.out.println("Write the name of the armor");
        String name = scanner.nextLine();
        System.out.println("Write the defense value (can be between 1 and 3)");
        int defense;
        do {
            defense = NumReader.readNumber();
            if (defense < 1 || defense > 3){
                System.out.println("Not a correct value");
            }
        } while (defense < 1 || defense > 3);
        System.out.println("Write the attack value (can be between 0 and 3)");
        int attack;
        do {
            attack = NumReader.readNumber();
            if (attack < 0 || attack > 3){
                System.out.println("Not a correct value");
            }
        } while (attack < 0 || attack > 3);
        Armor armor = new Armor(name, attack, defense);
        this.dataBase.setArmor(armor);
    }

    private void editArmor(Armor armor) {
        int input = 0;

        while (input < 4 || input > 5) {
            System.out.println("The armor " + armor.getName() + " has " + armor.getAttackModifier() + " of attack and " + armor.getDefenseModifier() + " of defense");

            System.out.println("1. Edit name");
            System.out.println("2. Edit attack value");
            System.out.println("3. Edit defense value");
            System.out.println("4. Delete the armor");
            System.out.println("5. Go back");

            input = NumReader.readNumber();

            switch (input) {
                case 1:
                    System.out.println("Write the new name");
                    String name = scanner.nextLine();
                    armor.setName(name);
                    break;
                case 2:
                    System.out.println("Write the new attack value (can be between 0 and 3)");
                    int attack;
                    do {
                        attack = NumReader.readNumber();
                        if (attack < 0 || attack > 3){
                            System.out.println("Not a correct value");
                        }
                    } while (attack < 0 || attack > 3);
                    armor.setAttackModifier(attack);
                    break;
                case 3:
                    System.out.println("Write the new defense value (can be between 1 and 3)");
                    int defense;
                    do {
                        defense = NumReader.readNumber();
                        if (defense < 1 || defense > 3){
                            System.out.println("Not a correct value");
                        }
                    } while (defense < 1 || defense > 3);
                    armor.setDefenseModifier(defense);
                    break;
                case 4:
                    this.dataBase.removeArmor(armor);
                    break;
                case 5:
                    break;
                default:
                    System.out.println(input + " is not a valid option");
            }
        }
    }

    private void menuModifiers() {
        boolean goBack = false;
        while (!goBack) {
            ArrayList<Modifiers> modifiersArray = this.dataBase.getAllModifiers();
            System.out.println("0. Create a new modifier");
            int i = 1;
            for (Modifiers modifier : modifiersArray) {
                System.out.println(i + ". Edit " + modifier.getName());
                i++;
            }
            System.out.println(modifiersArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
                if (input < 0 || input > modifiersArray.size()+1){
                    System.out.println("Not a correct value");
                }
            } while (input < 0 || input > modifiersArray.size() + 1);
            if (input == modifiersArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                this.createModifier();
            } else {
                this.editModifier(modifiersArray.get(input - 1));
            }
        }
    }

    private void createModifier() {
        System.out.println("Write the name of the modifier");
        String name = scanner.nextLine();
        Modifiers modifier = new Modifiers(name);
        this.dataBase.setModifier(modifier);
    }

    private void editModifier(Modifiers modifier) {
        int input = 0;
        while (input != 1 && input != 2) {
            System.out.println("What do you want to do?");
            System.out.println("1. Edit the name");
            System.out.println("2. Delete " + modifier.getName());
            input = NumReader.readNumber();
            if (input != 1 && input != 2) {
                System.out.println(input + " is not a valid option");
            }
        }
        switch (input) {
            case 1:
                System.out.println("Write the new name of " + modifier.getName());
                String name = scanner.nextLine();
                modifier.setName(name);
                break;
            case 2:
                this.dataBase.removeModifier(modifier);
        }

    }

    private void menuMinions() {
        boolean goBack = false;
        while (!goBack) {
            ArrayList<Minions> minionsArray = this.dataBase.getMinions();
            System.out.println("0. Create a new minion");
            int i = 1;
            for (Minions minion : minionsArray) {
                System.out.println(i + ". View " + minion.getName());
                i++;
            }
            System.out.println(minionsArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
                if (input < 0 || input > minionsArray.size() + 1){
                    System.out.println("Not a correct value");
                }
            } while (input < 0 || input > minionsArray.size() + 1);
            if (input == minionsArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                this.createMinion();
            } else {
                this.editMinion(minionsArray.get(input - 1));
            }
        }
    }

    private void createMinion() {
        System.out.println("Write the name of the minion");
        String name = scanner.nextLine();
        System.out.println("Write the health of the minion (can be between 1 and 3");
        int hp;
        do {
            hp = NumReader.readNumber();
            if (hp < 1 || hp > 3){
                System.out.println("Not a correct value");
            }
        } while (hp < 1 || hp > 3);
        System.out.println("What type of minion is it?");
        System.out.println("1. Human");
        System.out.println("2. Ghoul");
        System.out.println("3. Demon");
        int typeIndex;
        do {
            typeIndex = NumReader.readNumber();
            if (typeIndex < 1 || typeIndex > 3){
                System.out.println("Not a correct value");
            }
        } while (typeIndex < 1 || typeIndex > 3);
        Minions minion;
        switch (typeIndex) {
            case 1:
                System.out.println("Write its loyalty");
                System.out.println("1. High");
                System.out.println("2. Normal");
                System.out.println("3. Low");
                int loyalty;
                do {
                    loyalty = NumReader.readNumber();

                    if (loyalty < 1 || loyalty > 3){
                        System.out.println("Not a correct value");
                    }
                } while (loyalty < 1 || loyalty > 3);
                minion = new Humans(name, hp, loyalty);
                this.dataBase.setMinion(minion);
                break;
            case 2:
                System.out.println("Write its dependence (must be between 1 and 5");
                int dependence;
                do {
                    dependence = NumReader.readNumber();
                    if (dependence < 1 || dependence > 5){
                        System.out.println("Not a correct value");
                    }
                } while (dependence < 1 || dependence > 5);
                minion = new Ghouls(name, hp, dependence);
                this.dataBase.setMinion(minion);
                break;
            case 3:
                System.out.println("Write the pact between him and its master");
                String pact = scanner.nextLine();
                minion = new Demons(name, hp, pact);
                this.dataBase.setMinion(minion);
        }
    }

    private void editMinion(Minions minion) {
        int input;
        switch (minion.getType()) {
            case Humans:
                Humans human = (Humans) minion;
                input = 0;

                while (input < 4 || input > 5) {
                    System.out.println("The minion " + human.getName() + " has " + human.getHP() + " and has a " + human.getLoyalty() + " loyalty");

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit health");
                    System.out.println("3. Edit loyalty");
                    System.out.println("4. Delete minion");
                    System.out.println("5. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            human.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new health (can be between 1 and 3");
                            int hp;
                            do {
                                hp = NumReader.readNumber();
                                if (hp < 1 || hp > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (hp < 1 || hp > 3);
                            human.setHP(hp);
                            break;
                        case 3:
                            System.out.println("Write its loyalty");
                            System.out.println("1. High");
                            System.out.println("2. Normal");
                            System.out.println("3. Low");
                            int loyalty;
                            do {
                                loyalty = NumReader.readNumber();
                                if (loyalty < 1 || loyalty > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (loyalty < 1 || loyalty > 3);
                            human.setLoyalty(loyalty);
                            break;
                        case 4:
                            this.dataBase.removeMinion(human);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
            case Ghouls:
                Ghouls ghoul = (Ghouls) minion;
                input = 0;

                while (input < 4 || input > 5) {
                    System.out.println("The minion " + ghoul.getName() + " has " + ghoul.getHP() + " and has a dependence of " + ghoul.getDependence());

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit health");
                    System.out.println("3. Edit dependence");
                    System.out.println("4. Delete minion");
                    System.out.println("5. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            ghoul.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new health (can be between 1 and 3");
                            int hp;
                            do {
                                hp = NumReader.readNumber();
                                if (hp < 1 || hp > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (hp < 1 || hp > 3);
                            ghoul.setHP(hp);
                            break;
                        case 3:
                            System.out.println("Write the new dependence (can be between 1 and 5");
                            int dependence;
                            do {
                                dependence = NumReader.readNumber();
                                if (dependence < 1 || dependence > 5){
                                    System.out.println("Not a correct value");
                                }
                            } while (dependence < 1 || dependence > 5);
                            ghoul.setDependence(dependence);
                            break;
                        case 4:
                            this.dataBase.removeMinion(ghoul);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
            case Demons:
                Demons demon = (Demons) minion;
                input = 0;

                while (input < 5 || input > 6) {
                    System.out.println("The minion " + demon.getName() + " has " + demon.getHP() + " and its pact with his master is: " + demon.getPact());

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit health");
                    System.out.println("3. Edit dependence");
                    System.out.println("4. View its minions");
                    System.out.println("5. Delete minion");
                    System.out.println("6. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            demon.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new health (can be between 1 and 3");
                            int hp;
                            do {
                                hp = NumReader.readNumber();
                                if (hp < 1 || hp > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (hp < 1 || hp > 3);
                            demon.setHP(hp);
                            break;
                        case 3:
                            System.out.println("Write the new pact");
                            String pact = scanner.nextLine();
                            demon.setPact(pact);
                            break;
                        case 4:
                            this.editMinionsList(demon.getMinions(), false, demon.getName());
                            break;
                        case 5:
                            this.dataBase.removeMinion(demon);
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
        }
    }

    private void menuCharacters() {
        boolean goBack = false;
        while (!goBack) {
            ArrayList<Character> charactersArray = this.dataBase.getCharacters();
            System.out.println("0. Create a new character");
            int i = 1;
            for (Character character : charactersArray) {
                System.out.println(i + ". View " + character.getName());
                i++;
            }
            System.out.println(charactersArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
                if (input < 0 || input > charactersArray.size() + 1){
                    System.out.println("Not a correct value");
                }
            } while (input < 0 || input > charactersArray.size() + 1);
            if (input == charactersArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                this.createCharacter();
            } else {
                this.editCharacter(charactersArray.get(input - 1));
            }
        }
    }

    public void createCharacter() {
        System.out.println("Give a name to the new character");
        String charName = scanner.nextLine();
        System.out.println("Write the health with which " + charName + " will start each fight (must be between 1 and 5");
        int hp;
        do {
            hp = NumReader.readNumber();
            if (hp < 1 || hp > 5){
                System.out.println("Not a correct value");
            }
        } while (hp < 1 || hp > 5);
        System.out.println("Write a power value for " + charName + " (must be between 1 and 5");
        int charPower;
        do {
            charPower = NumReader.readNumber();
            if (charPower < 1 || charPower > 5){
                System.out.println("Not a correct value");
            }
        } while (charPower < 1 || charPower > 5);
        System.out.println("What type of character is it?");
        System.out.println("1. Vampire");
        System.out.println("2. Lycanthrope");
        System.out.println("3. Hunter");
        int typeIndex;
        do {
            typeIndex = NumReader.readNumber();
            if (typeIndex < 1 || typeIndex > 3){
                System.out.println("Not a correct value");
            }
        } while (typeIndex < 1 || typeIndex > 3);
        Character newCharacter;
        SpecialAbility specialAbility;
        switch (typeIndex) {
            case 1:
                System.out.println("Write its age");
                int age = NumReader.readNumber();
                System.out.println("Write the name of its discipline");
                String disciplineName = scanner.nextLine();
                System.out.println("Write the attack value of " + disciplineName + " (must be between 1 and 3");
                int disciplineAttack;
                do {
                    disciplineAttack = NumReader.readNumber();
                    if (disciplineAttack < 1 || disciplineAttack > 3){
                        System.out.println("Not a correct value");
                    }
                } while (disciplineAttack < 1 || disciplineAttack > 3);
                System.out.println("Write the defence value of " + disciplineName + " (must be between 1 and 3");
                int disciplineDefence;
                do {
                    disciplineDefence = NumReader.readNumber();
                    if (disciplineDefence < 1 || disciplineDefence > 3){
                        System.out.println("Not a correct value");
                    }
                } while (disciplineDefence < 1 || disciplineDefence > 3);
                System.out.println("Write the blood cost of " + disciplineName + " (must be between 1 and 3");
                int disciplineCost;
                do {
                    disciplineCost = NumReader.readNumber();
                    if (disciplineCost < 1 || disciplineCost > 3){
                        System.out.println("Not a correct value");
                    }
                } while (disciplineCost < 1 || disciplineCost > 3);
                specialAbility = new Disciplines(disciplineName, disciplineAttack, disciplineDefence, disciplineCost);
                newCharacter = new Vampire(charName, charPower, hp, specialAbility, age);
                this.dataBase.setCharDB(newCharacter);
                break;
            case 2:
                System.out.println("Write its height");
                int height = NumReader.readNumber();
                System.out.println("Write its weight");
                int weight = NumReader.readNumber();
                System.out.println("Write the name of its gift");
                String giftName = scanner.nextLine();
                System.out.println("Write the attack value of " + giftName + " (must be between 1 and 3");
                int giftAttack;
                do {
                    giftAttack = NumReader.readNumber();
                    if (giftAttack < 1 || giftAttack > 3){
                        System.out.println("Not a correct value");
                    }
                } while (giftAttack < 1 || giftAttack > 3);
                System.out.println("Write the defence value of " + giftName + " (must be between 1 and 3");
                int giftDefence;
                do {
                    giftDefence = NumReader.readNumber();
                    if (giftDefence < 1 || giftDefence > 3){
                        System.out.println("Not a correct value");
                    }
                } while (giftDefence < 1 || giftDefence > 3);
                System.out.println("Write minimum fury value to use " + giftName+ " (must be between 0 and 3)");
                int giftFury;
                do {
                    giftFury = NumReader.readNumber();
                    if (giftFury < 0 || giftFury > 3){
                        System.out.println("Not a correct value");
                    }
                } while (giftFury < 0 || giftFury > 3);

                specialAbility = new Gift(giftName, giftAttack, giftDefence, giftFury);
                newCharacter = new Lycanthrope(charName, charPower, hp, specialAbility, height, weight);
                this.dataBase.setCharDB(newCharacter);
                break;
            case 3:
                System.out.println("Write the willpower value with which " + charName + " will start each fight (must be between 0 and 3");
                int willpower;
                do {
                    willpower = NumReader.readNumber();
                    if (willpower < 0 || willpower > 3){
                        System.out.println("Not a correct value");
                    }
                } while (willpower < 0 || willpower > 3);
                System.out.println("Write the name of its talent");
                String talentName = scanner.nextLine();
                System.out.println("Write the attack value of " + talentName + " (must be between 1 and 3");
                int talentAttack;
                do {
                    talentAttack = NumReader.readNumber();
                    if (talentAttack < 1 || talentAttack > 3){
                        System.out.println("Not a correct value");
                    }
                } while (talentAttack < 1 || talentAttack > 3);
                System.out.println("Write the defence value of " + talentName + " (must be between 1 and 3");
                int talentDefence;
                do {
                    talentDefence = NumReader.readNumber();
                    if (talentDefence < 1 || talentDefence > 3){
                        System.out.println("Not a correct value");
                    }
                } while (talentDefence < 1 || talentDefence > 3);
                specialAbility = new Talent(talentName, talentAttack, talentDefence);
                newCharacter = new Hunter(charName, charPower, hp, specialAbility, willpower);
                this.dataBase.setCharDB(newCharacter);
        }
    }

    private void editCharacter(Character character) {
        int input;
        switch (character.getType()) {
            case Hunter:
                Hunter hunter = (Hunter) character;
                input = 0;

                while (input < 10 || input > 11) {
                    System.out.println("The character " + hunter.getName() + " has " + hunter.getHp() + " of health, " + hunter.getPower() + " of power and " + hunter.getWillpower() + " of willpower");

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit health");
                    System.out.println("3. Edit power");
                    System.out.println("4. Edit willpower");
                    System.out.println("5. View modifiers list");
                    System.out.println("6. View special ability");
                    System.out.println("7. View minions list");
                    System.out.println("8. View weapons list");
                    System.out.println("9. View armors list");
                    System.out.println("10. Delete character");
                    System.out.println("11. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            hunter.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new health (can be between 1 and 5");
                            int hp;
                            do {
                                hp = NumReader.readNumber();
                                if (hp < 1 || hp > 5){
                                    System.out.println("Not a correct value");
                                }
                            } while (hp < 1 || hp > 5);
                            hunter.setHP(hp);
                            break;
                        case 3:
                            System.out.println("Write the new power (can be between 1 and 5");
                            int power;
                            do {
                                power = NumReader.readNumber();
                                if (power < 1 || power > 5){
                                    System.out.println("Not a correct value");
                                }
                            } while (power < 1 || power > 5);
                            hunter.setPower(power);
                            break;
                        case 4:
                            System.out.println("Write the new willpower (can be between 0 and 3");
                            int willpower;
                            do {
                                willpower = NumReader.readNumber();
                                if (willpower < 1 || willpower > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (willpower < 0 || willpower > 3);
                            hunter.setWillpower(willpower);
                            break;
                        case 5:
                            this.editModifierList(hunter.getModifiers());
                            break;
                        case 6:
                            this.editSpecialAbility(hunter.getSpecialAbilities());
                            break;
                        case 7:
                            this.editMinionsList(hunter.getMinions(), false, "");
                            break;
                        case 8:
                            this.editWeaponsList(hunter.getWeapons());
                            break;
                        case 9:
                            this.editArmorsList(hunter.getArmor());
                            break;
                        case 10:
                            this.dataBase.removeCharacter(hunter);
                            break;
                        case 11:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
            case Lycanthrope:
                Lycanthrope lycanthrope = (Lycanthrope) character;
                input = 0;

                while (input < 11 || input > 12) {
                    System.out.println("The character " + lycanthrope.getName() + " has " + lycanthrope.getHp() + " of health, " + lycanthrope.getPower() + " of power, weights " + lycanthrope.getWeight() + " kgs and is " + lycanthrope.getHeight() + " cms tall");

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit health");
                    System.out.println("3. Edit power");
                    System.out.println("4. Edit height");
                    System.out.println("5. Edit weight");
                    System.out.println("6. View modifiers list");
                    System.out.println("7. View special ability");
                    System.out.println("8. View minions list");
                    System.out.println("9. View weapons list");
                    System.out.println("10. View armors list");
                    System.out.println("11. Delete character");
                    System.out.println("12. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            lycanthrope.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new health (can be between 1 and 5");
                            int hp;
                            do {
                                hp = NumReader.readNumber();
                                if (hp < 1 || hp > 5){
                                    System.out.println("Not a correct value");
                                }
                            } while (hp < 1 || hp > 5);
                            lycanthrope.setHP(hp);
                            break;
                        case 3:
                            System.out.println("Write the new power (can be between 1 and 5");
                            int power;
                            do {
                                power = NumReader.readNumber();
                                if (power < 1 || power > 5){
                                    System.out.println("Not a correct value");
                                }
                            } while (power < 1 || power > 5);
                            lycanthrope.setPower(power);
                            break;
                        case 4:
                            System.out.println("Write the new height");
                            int height = NumReader.readNumber();
                            lycanthrope.setHeight(height);
                            break;
                        case 5:
                            System.out.println("Write the new weight");
                            int weight = NumReader.readNumber();
                            lycanthrope.setWeight(weight);
                            break;
                        case 6:
                            this.editModifierList(lycanthrope.getModifiers());
                            break;
                        case 7:
                            this.editSpecialAbility(lycanthrope.getSpecialAbilities());
                            break;
                        case 8:
                            this.editMinionsList(lycanthrope.getMinions(), false,"");
                            break;
                        case 9:
                            this.editWeaponsList(lycanthrope.getWeapons());
                            break;
                        case 10:
                            this.editArmorsList(lycanthrope.getArmor());
                            break;
                        case 11:
                            this.dataBase.removeCharacter(lycanthrope);
                            break;
                        case 12:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
            case Vampire:
                Vampire vampire = (Vampire) character;
                input = 0;

                while (input < 10 || input > 11) {
                    System.out.println("The character " + vampire.getName() + " has " + vampire.getHp() + " of health, " + vampire.getPower() + " of power and an age of " + vampire.getAge());

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit health");
                    System.out.println("3. Edit power");
                    System.out.println("4. Edit age");
                    System.out.println("5. View modifiers list");
                    System.out.println("6. View special ability");
                    System.out.println("7. View minions list");
                    System.out.println("8. View weapons list");
                    System.out.println("9. View armors list");
                    System.out.println("10. Delete character");
                    System.out.println("11. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            vampire.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new health (can be between 1 and 5");
                            int hp;
                            do {
                                hp = NumReader.readNumber();
                                if (hp < 1 || hp > 5){
                                    System.out.println("Not a correct value");
                                }
                            } while (hp < 1 || hp > 5);
                            vampire.setHP(hp);
                            break;
                        case 3:
                            System.out.println("Write the new power (can be between 1 and 5");
                            int power;
                            do {
                                power = NumReader.readNumber();
                                if (power < 1 || power > 5){
                                    System.out.println("Not a correct value");
                                }
                            } while (power < 1 || power > 5);
                            vampire.setPower(power);
                            break;
                        case 4:
                            System.out.println("Write the new age");
                            int age = NumReader.readNumber();
                            vampire.setAge(age);
                            break;
                        case 5:
                            this.editModifierList(vampire.getModifiers());
                            break;
                        case 6:
                            this.editSpecialAbility(vampire.getSpecialAbilities());
                            break;
                        case 7:
                            this.editMinionsList(vampire.getMinions(), true,"");
                            break;
                        case 8:
                            this.editWeaponsList(vampire.getWeapons());
                            break;
                        case 9:
                            this.editArmorsList(vampire.getArmor());
                            break;
                        case 10:
                            this.dataBase.removeCharacter(vampire);
                            break;
                        case 11:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
        }
    }

    private void editModifierList(ArrayList<ModifierValue> modifierValuesArray) {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("0. Add an existing modifier");
            int i = 1;
            for (ModifierValue modifier : modifierValuesArray) {
                System.out.println(i + ". Remove " + modifier.getModifier().getName() + " with a value of " + modifier.getValue() + " from this list");
                i++;
            }
            System.out.println(modifierValuesArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
            } while (input < 0 || input > modifierValuesArray.size() + 1);
            if (input == modifierValuesArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                ArrayList<Modifiers> modifiersDB = this.dataBase.getAllModifiers();
                int j = 1;
                for (Modifiers modifier : modifiersDB) {
                    System.out.println(j + ". Add " + modifier.getName());
                    j++;
                }
                System.out.println(modifiersDB.size() + 1 + ". Go back");
                int input2;
                do {
                    input2 = NumReader.readNumber();
                } while (input2 < 1 || input2 > modifiersDB.size() + 1);
                if (input2 < modifiersDB.size() + 1) {
                    int modifierType = 0;
                    while (modifierType != 1 && modifierType != 2) {
                        System.out.println("Is it a weakness or a strength");
                        System.out.println("1. Weakness");
                        System.out.println("2. Strength");
                        modifierType = NumReader.readNumber();
                        if (modifierType != 1 && modifierType != 2) {
                            System.out.println(input + " is not a valid option");
                        }
                    }
                    System.out.println("Write the value (can be between 1 and 5)");
                    int modifierValue;
                    do {
                        modifierValue = NumReader.readNumber();
                    } while (modifierValue < 1 || modifierValue > 5);
                    switch (modifierType) {
                        case 1:
                            modifierValuesArray.add(new ModifierValue(modifiersDB.get(input2 - 1), -modifierValue));
                            break;
                        case 2:
                            modifierValuesArray.add(new ModifierValue(modifiersDB.get(input2 - 1), modifierValue));
                            break;
                    }
                }
            } else {
                modifierValuesArray.remove(input - 1);
            }
        }
    }

    private void editSpecialAbility(SpecialAbility specialAbility) {
        int input;
        switch (specialAbility.getTypeAbility()) {
            case Gift:
                Gift gift = (Gift) specialAbility;
                input = 0;

                while (input != 5) {
                    System.out.println("The ability " + gift.getName() + " has an attack value of " + gift.getAttackValue() + ", a defense value of " + gift.getDefenseValue() + " and can be used with a minimum fury of " + gift.getFury());

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit attack value");
                    System.out.println("3. Edit defense value");
                    System.out.println("4. Edit minimum fury");
                    System.out.println("5. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            gift.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new attack value (can be between 1 and 3");
                            int attack;
                            do {
                                attack = NumReader.readNumber();
                                if (attack < 1 || attack > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (attack < 1 || attack > 3);
                            gift.setAttackValue(attack);
                            break;
                        case 3:
                            System.out.println("Write the new defense value (can be between 1 and 3");
                            int defense;
                            do {
                                defense = NumReader.readNumber();
                                if (defense < 1 || defense > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (defense < 1 || defense > 3);
                            gift.setDefenseValue(defense);
                            break;
                        case 4:
                            System.out.println("Write the new minimum fury value (can be between 0 and 3");
                            int fury;
                            do {
                                fury = NumReader.readNumber();
                                if (fury < 0 || fury > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (fury < 0 || fury > 3);
                            gift.setFury(fury);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
            case Disciplines:
                Disciplines disciplines = (Disciplines) specialAbility;
                input = 0;

                while (input != 5) {
                    System.out.println("The ability " + disciplines.getName() + " has an attack value of " + disciplines.getAttackValue() + ", a defense value of " + disciplines.getDefenseValue() + " and has a blood cost of " + disciplines.getCost());

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit attack value");
                    System.out.println("3. Edit defense value");
                    System.out.println("4. Edit blood cost");
                    System.out.println("5. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            disciplines.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new attack value (can be between 1 and 3");
                            int attack;
                            do {
                                attack = NumReader.readNumber();
                                if (attack < 1 || attack > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (attack < 1 || attack > 3);
                            disciplines.setAttackValue(attack);
                            break;
                        case 3:
                            System.out.println("Write the new defense value (can be between 1 and 3");
                            int defense;
                            do {
                                defense = NumReader.readNumber();
                                if (defense < 1 || defense > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (defense < 1 || defense > 3);
                            disciplines.setDefenseValue(defense);
                            break;
                        case 4:
                            System.out.println("Write the blood cost (can be between 1 and 3");
                            int blood;
                            do {
                                blood = NumReader.readNumber();
                                if (blood < 1 || blood > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (blood < 1 || blood > 3);
                            disciplines.setCost(blood);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
            case Talent:
                Talent talent = (Talent) specialAbility;
                input = 0;

                while (input != 4) {
                    System.out.println("The ability " + talent.getName() + " has an attack value of " + talent.getAttackValue() + " and a defense value of " + talent.getDefenseValue());

                    System.out.println("1. Edit name");
                    System.out.println("2. Edit attack value");
                    System.out.println("3. Edit defense value");
                    System.out.println("4. Go back");

                    input = NumReader.readNumber();

                    switch (input) {
                        case 1:
                            System.out.println("Write the new name");
                            String name = scanner.nextLine();
                            talent.setName(name);
                            break;
                        case 2:
                            System.out.println("Write the new attack value (can be between 1 and 3");
                            int attack;
                            do {
                                attack = NumReader.readNumber();
                                if (attack < 1 || attack > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (attack < 1 || attack > 3);
                            talent.setAttackValue(attack);
                            break;
                        case 3:
                            System.out.println("Write the new defense value (can be between 1 and 3");
                            int defense;
                            do {
                                defense = NumReader.readNumber();
                                if (defense < 1 || defense > 3){
                                    System.out.println("Not a correct value");
                                }
                            } while (defense < 1 || defense > 3);
                            talent.setDefenseValue(defense);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println(input + " is not a valid option");
                    }
                }
                break;
        }
    }

    private void editMinionsList(ArrayList<Minions> minionsArray, boolean vampireMaster, String nameMinion) {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("0. Add an existing minion");
            int i = 1;
            for (Minions minion : minionsArray) {
                System.out.println(i + ". Remove " + minion.getName() + " from this list");
                i++;
            }
            System.out.println(minionsArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
            } while (input < 0 || input > minionsArray.size() + 1);
            if (input == minionsArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                boolean goBack2 = false;
                while (!goBack2) {
                    ArrayList<Minions> minionsDB = this.dataBase.getMinions();
                    int j = 1;
                    for (Minions minion : minionsDB) {
                        System.out.println(j + ". Add " + minion.getName());
                        j++;
                    }
                    System.out.println(minionsDB.size() + 1 + ". Go back");
                    int input2;
                    do {
                        input2 = NumReader.readNumber();
                    } while (input2 < 1 || input2 > minionsDB.size() + 1);
                    if (input2 == minionsDB.size() + 1) {
                        goBack2 = true;
                    } else {
                        if (vampireMaster && (minionsDB.get(input2 - 1).getType() == TMinion.Humans)) {
                            System.out.println("You are trying to assign a human minion to a vampire master, that cant end well!!");
                        }else if ((minionsDB.get(input2-1).getName().equals(nameMinion))&&(!nameMinion.equals(""))){
                            System.out.println("You can`t add yourself");
                            return;

                        }else{
                            for (Minions minion: minionsArray){
                                if(minion.equals(minionsDB.get(input2-1))){
                                    System.out.println("Minion already add");
                                    return;
                                }
                            }
                            minionsArray.add(minionsDB.get(input2 - 1));
                        }
                    }
                }
            } else {
                minionsArray.remove(input - 1);
            }
        }
    }

    private void editWeaponsList(ArrayList<Weapons> weaponsArray) {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("0. Add an existing weapon");
            int i = 1;
            for (Weapons weapon : weaponsArray) {
                System.out.println(i + ". Remove " + weapon.getName() + " from this list");
                i++;
            }
            System.out.println(weaponsArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
            } while (input < 0 || input > weaponsArray.size() + 1);
            if (input == weaponsArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                boolean goBack2 = false;
                while (!goBack2) {
                    ArrayList<Weapons> weaponsDB = this.dataBase.getWeaponsDB();
                    int j = 1;
                    for (Weapons weapon : weaponsDB) {
                        System.out.println(j + ". Add " + weapon.getName());
                        j++;
                    }
                    System.out.println(weaponsDB.size() + 1 + ". Go back");
                    int input2;
                    do {
                        input2 = NumReader.readNumber();
                    } while (input2 < 1 || input2 > weaponsDB.size() + 1);
                    if (input2 == weaponsDB.size() + 1) {
                        goBack2 = true;
                    } else {
                        for (Weapons weaponn: weaponsArray){
                            if(weaponn.equals(weaponsDB.get(input2-1))){
                                System.out.println("Weapon already add");
                                return;
                            }
                        }
                        weaponsArray.add(weaponsDB.get(input2 - 1));

                    }
                }
            } else {
                weaponsArray.remove(input - 1);
            }
        }
    }

    private void editArmorsList(ArrayList<Armor> armorsArray) {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("0. Add an existing armor");
            int i = 1;
            for (Armor armor : armorsArray) {
                System.out.println(i + ". Remove " + armor.getName() + " from this list");
                i++;
            }
            System.out.println(armorsArray.size() + 1 + ". Go back");
            int input;
            do {
                input = NumReader.readNumber();
            } while (input < 0 || input > armorsArray.size() + 1);
            if (input == armorsArray.size() + 1) {
                goBack = true;
            } else if (input == 0) {
                boolean goBack2 = false;
                while (!goBack2) {
                    ArrayList<Armor> armorsDB = this.dataBase.getArmorsDB();
                    int j = 1;
                    for (Armor armor : armorsDB) {
                        System.out.println(j + ". Add " + armor.getName());
                        j++;
                    }
                    System.out.println(armorsDB.size() + 1 + ". Go back");
                    int input2;
                    do {
                        input2 = NumReader.readNumber();
                    } while (input2 < 1 || input2 > armorsDB.size() + 1);
                    if (input2 == armorsDB.size() + 1) {
                        goBack2 = true;
                    } else {
                        for (Armor armorr: armorsArray){
                            if(armorr.equals(armorsDB.get(input2-1))){
                                System.out.println("Armor already add");
                                return;
                            }
                        }
                        armorsArray.add(armorsDB.get(input2 - 1));
                    }
                }
            } else {
                armorsArray.remove(input - 1);
            }
        }
    }
}