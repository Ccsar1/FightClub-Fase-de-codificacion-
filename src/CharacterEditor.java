
import java.io.*;
import java.util.*;


public class CharacterEditor {

    Scanner scanner = new Scanner(System.in);
    private Character character;
    private DataBaseManager dataBase;
    public CharacterEditor() {
    }
    public void showMenuEditor() {
        System.out.println("Character editor");


        int exit = 0;

        while (exit != 1) {
            exit = 0;
            System.out.println("1. Edit name");
            System.out.println("2. Edit power");
            System.out.println("3. Edit type");
            System.out.println("4. Edit special abilities");
            System.out.println("5. Edit equipment");
            System.out.println("6. Edit minions");
            System.out.println("7. Edit modifiers");
            System.out.println("8. Exit");



            int input = scanner.nextInt();
            System.out.println("Write the name of the character");
            String nameCharacter = scanner.nextLine();

            if (dataBase.checkExistsCharacter(nameCharacter)) {
                Character character= dataBase.getCharacterByName(nameCharacter);
                switch (input) {
                    case 1:
                        this.editName(character);
                        break;
                    case 2:
                        this.editPower(character);
                        break;
                    case 3:
                        this.editType(character);
                        break;
                    case 4:
                        this.editSpecialAbilities(character);
                        break;
                    case 5:
                        this.editEquipment(character);
                        break;
                    case 6:
                        this.editMinions(character);
                        break;
                    case 7:
                        this.editModifiers(character);
                        break;
                    case 8:
                        System.out.println("Please enter 1 to confirm exit");
                        exit = scanner.nextInt();
                        if (exit == 1) {
                            System.out.println("Byebye!");
                        }
                        break;
                    default:
                        System.out.println(input + " is not a valid option");
                }
            }else{
                System.out.println(nameCharacter+" is not a valid name");
            }
            dataBase.saveFiles();
            System.out.println("---saving in database");
        }

    }
    public void showMenuAddProperties() {
        System.out.println("Character add properties");


        int exit = 0;

        while (exit != 1) {
            exit = 0;
            System.out.println("1. Add equipment");
            System.out.println("2. Add modifiers");
            System.out.println("3. Add minions");
            System.out.println("4. Exit");

            int input = scanner.nextInt();
            System.out.println("Write the name of the character");
            String nameCharacter = scanner.nextLine();

            if (dataBase.checkExistsCharacter(nameCharacter)) {
                Character character= dataBase.getCharacterByName(nameCharacter);
                switch (input) {
                    case 1:
                        this.editEquipment(character);
                        break;
                    case 2:
                        this.editModifiers(character);
                        break;
                    case 3:
                        this.editMinions(character);
                        break;
                    case 4:
                        System.out.println("Please enter 1 to confirm exit");
                        exit = scanner.nextInt();
                        if (exit == 1) {
                            System.out.println("Byebye!");
                        }
                        break;
                    default:
                        System.out.println(input + " is not a valid option");
                }
            }else{
                System.out.println(nameCharacter+" is not a valid name");
            }
            dataBase.saveFiles();
            System.out.println("---saving in database");
        }

    }
    public void editName(Character character) {
        String nameCharacter;
        do {
            System.out.println("Write the new name: ");
             nameCharacter = scanner.nextLine();
             if (dataBase.checkExistsCharacter(nameCharacter)){
                 System.out.println("Name already used, try it again!");
             }
        }while(dataBase.checkExistsCharacter(nameCharacter));
        character.setName(nameCharacter);


    }

    public void editPower(Character character) {
        int power;
        do {
            System.out.println("Write the new power: ");
            power = scanner.nextInt();
            if ((power<1)||(power>5)){
                System.out.println("write the correct values, try it again!");
            }
        }while((power<1) || (power>5));
        character.setPower(power);
    }

    public void editType(Character character) {
        String type;
        TCharacter typeCharacter;
        boolean found=false;
        do {
            System.out.println("Write the new type of character: ");
            type = scanner.nextLine();
            typeCharacter= TCharacter.valueOf(type);
            try {
                character.setType(typeCharacter);
                found=true;
            } catch (IllegalArgumentException e) {
                System.out.println("Write one of the three types, try it again!");
            }
        }while(found);

    }

    public void editSpecialAbilities(Character character) {
        int defence=0,attack=0;
        System.out.println("Write the name of the special ability: ");
        String ability= scanner.nextLine();
        character.getSpecialAbilities().setName(ability);

        do{
            System.out.println("Write the defence value: ");
             defence=scanner.nextInt();
            System.out.println("Write the attack value: ");
             attack= scanner.nextInt();
             if (((attack<1)||(attack>3)) && ((defence<1)||(defence>3)) ){
                 System.out.println("Write correct values, try it again!");
             }
        }while(((attack<1)||(attack>3)) && ((defence<1)||(defence>3)) );
        character.getSpecialAbilities().setAttackValue(attack);
        character.getSpecialAbilities().setDefenceValue(defence);

        TCharacter typeCharacter= character.getType();
        int value=0;

        switch (typeCharacter){
            case Vampire:
                do{
                    System.out.println("Write the cost in blood : ");
                    value=scanner.nextInt();
                    if (((value<1)||(value>3))){
                        System.out.println("Write correct values, try it again!");
                    }
                }while(((value<1)||(value>3)) );
                TAbility tabilityVampire= TAbility.Disciplines;
                character.getSpecialAbilities().setTypeAbility(tabilityVampire);
                Disciplines disciplines= (Disciplines) character.getSpecialAbilities();
                disciplines.setCost(value);
                break;
            case Lycanthrope:
                System.out.println("Write the fury value: ");
                value=scanner.nextInt();
                TAbility tabilityLycanthrope= TAbility.Don;
                character.getSpecialAbilities().setTypeAbility(tabilityLycanthrope);
                Don don= (Don) character.getSpecialAbilities();
                don.setFury(value);
                break;
            case Hunter:
                TAbility tabilityHunter= TAbility.Talent;
                character.getSpecialAbilities().setTypeAbility(tabilityHunter);
                break;
        }

    }


    public void editMinions(Character character) {
        String type;
        TMinion typeMinion;
        boolean found=false;
        System.out.println("Write the name of the minion: ");
        String name = scanner.nextLine();
        character.getMinions().setName(name);
        System.out.println("Write the health of the minion: ");
        int health = scanner.nextInt();
        character.getMinions().setHP(health);
        do {
            System.out.println("Write the type of minion: ");
            type = scanner.nextLine();
            typeMinion= TMinion.valueOf(type);
            try {
                found=true;
            } catch (IllegalArgumentException e) {
                System.out.println("Write one of the three types, try it again!");
            }
        }while(found);
        character.getMinions().setMinionType(typeMinion);
        switch(typeMinion){
            case Demons:

                TCharacter typeCharacter= character.getType();
                TCharacter vampire= TCharacter.Vampire;
                if (typeCharacter!=vampire) {
                    System.out.println("Write the pact: ");
                    String pact = scanner.nextLine();
                    Demons demons= (Demons) character.getMinions();
                    demons.setPact(pact);
                }else{
                    System.out.println("Vampires can´t have minions");
                }
                break;
            case Ghouls:
                int dependency=0;
                do {
                    System.out.println("Write the dependency: ");
                    dependency = scanner.nextInt();
                    if (((dependency < 1) || (dependency > 5))) {
                        System.out.println("Write correct values, try it again!");
                    }
                } while (((dependency < 1) || (dependency > 5)));
                Ghouls ghouls= (Ghouls) character.getMinions();
                ghouls.setDependencies(dependency);
                break;
            case Humans:
                boolean foundLoyalty=false;
                TLoyalty loyalty;
                do {
                    System.out.println("Write the loyalty of minion: ");
                    String loyal = scanner.nextLine();
                    loyalty= TLoyalty.valueOf(loyal);
                    try {
                        foundLoyalty=true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Write one of the three types, try it again!");
                    }
                }while(foundLoyalty);
                Humans humans= (Humans) character.getMinions();
                humans.setLoyalty(loyalty);
                break;
        }
    }
    public void editEquipment(Character character) {
        int exit=0,defenceValue=0,attackValue=0;
        while (exit!=1) {
            System.out.println("1. Edit armor");
            System.out.println("2. Edit weapons");
            System.out.println("3. Exit");
            int option=scanner.nextInt();
            switch (option) {
                case 1:

                        System.out.println("Write the name of the armor: ");
                        String armor = scanner.nextLine();
                        character.getArmor().setName(armor);
                        System.out.println("If you want to add attack value to the armor write 1");
                        int optionAdd= scanner.nextInt();
                        if (optionAdd==1){
                            do{
                            System.out.println("Write the attack value: ");
                            attackValue = scanner.nextInt();
                                if (((attackValue < 1) || (attackValue > 3))) {
                                    System.out.println("Write correct values, try it again!");

                                }else{
                                    character.getArmor().setAttackModifier(attackValue);
                                }
                            }while(((attackValue < 1) || (attackValue > 3)));
                        }do {
                    System.out.println("Write the defence value: ");
                    defenceValue = scanner.nextInt();
                        if (((defenceValue < 1) || (defenceValue > 3))) {
                            System.out.println("Write correct values, try it again!");

                        } else{
                            character.getArmor().setDefenceModifier(defenceValue);

                        }
                    } while (((defenceValue < 1) || (defenceValue > 3)));

                    break;
                case 2:
                    int type=0;

                        System.out.println("Write the name of the weapon: ");
                        String weapon = scanner.nextLine();
                        character.getWeapons().setName(weapon);
                        do {
                            System.out.println("1 or 2 hand: ");
                            type = scanner.nextInt();
                        }while(type!=1 && type!=2);
                        character.getWeapons().setType(weapon);
                        System.out.println("If you want to add defence value to the weapon write 1");
                        int optionAd= scanner.nextInt();
                        if (optionAd==1){
                            do{
                                System.out.println("Write the defence value: ");
                                defenceValue = scanner.nextInt();
                                if (((defenceValue < 1) || (defenceValue > 3))) {
                                    System.out.println("Write correct values, try it again!");

                                }else{
                                    character.getWeapons().setDefenceModifier(defenceValue);
                                }
                            }while(((defenceValue < 1) || (defenceValue > 3)));
                        }
                    do {
                        System.out.println("Write the attack value: ");
                        attackValue = scanner.nextInt();
                        if (((attackValue < 1) || (attackValue > 3))) {
                            System.out.println("Write correct values, try it again!");

                        } else {
                            character.getWeapons().setAttackModifier(attackValue);
                        }
                    } while (((attackValue < 1) || (attackValue > 3)));
                    break;
                case 3:
                    System.out.println("Please enter 1 to confirm exit");
                    exit = scanner.nextInt();
                    if (exit == 1) {
                        System.out.println("Byebye!");
                    }
                    break;
                break;
                default:
                    System.out.println(option + " is not a valid option");


            }
        }
    }




    public void editModifiers(Character character) {
        int exit=0;
        while (exit!=1) {
        System.out.println("1. Edit weaknesses");
        System.out.println("2. Edit strengths");
        System.out.println("3. Exit");
        int option=scanner.nextInt();
            switch (option) {
                case 1:
                    boolean found=false;

                        TModifiers weaknessesModifier= TModifiers.Weaknesses;
                        System.out.println("Write the weakness you want to choose: ");
                        ArrayList<Weaknesses>allWeak=dataBase.getAllWeaknesses();
                        System.out.println(allWeak);
                        String name=scanner.nextLine();
                        do {
                            for (Weaknesses weakness : allWeak) {
                                if (weakness.getName().equals(name)) {
                                    character.getModifiers().setName(weakness.getName());
                                    character.getModifiers().setValue(weakness.getValue());
                                    character.getModifiers().setModifiersType(weaknessesModifier);
                                    found=true;
                                }
                            }
                        }while(found);
                    break;

                case 2:
                    boolean foundStrength=false;

                    TModifiers strengthModifier= TModifiers.Strengths;
                    System.out.println("Write the strength you want to choose: ");
                    ArrayList<Strengths>allStrength=dataBase.getAllStrengths();
                    System.out.println(allStrength);
                    String nameStrength=scanner.nextLine();
                    do {
                        for (Strengths strengths : allStrength) {
                            if (strengths.getName().equals(nameStrength)) {
                                character.getModifiers().setName(strengths.getName());
                                character.getModifiers().setValue(strengths.getValue());
                                character.getModifiers().setModifiersType(strengthModifier);
                                foundStrength=true;
                            }
                        }
                    }while(foundStrength);
                    break;
                case 3:
                    System.out.println("Please enter 1 to confirm exit");
                    exit = scanner.nextInt();
                    if (exit == 1) {
                        System.out.println("Byebye!");
                    }
                    break;
                break;
                default:
                    System.out.println(option + " is not a valid option");


            }
        }



    }




}