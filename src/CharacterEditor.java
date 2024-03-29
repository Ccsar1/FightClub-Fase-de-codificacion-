
import java.io.*;
import java.util.*;


public class CharacterEditor {

    Scanner scanner = new Scanner(System.in);
    private Character character;
    private DataBaseManager dataBase;
    public CharacterEditor() {
    }
    public void showMenuEditor() throws IOException {
        System.out.println("Character editor");


        int exit = 0;

        while (exit != 1) {
            exit = 0;
            System.out.println("1. Edit name");
            System.out.println("2. Edit power");
            System.out.println("3. Edit type");
            System.out.println("4. Edit gold");
            System.out.println("5. Edit special abilities");
            System.out.println("6. Edit equipment");
            System.out.println("7. Edit minions");
            System.out.println("8. Edit modifiers");
            System.out.println("9. Exit");



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
                        this.editGold(character);
                        break;
                    case 5:
                        this.editSpecialAbilities(character);
                        break;
                    case 6:
                        this.editEquipment(character);
                        break;
                    case 7:
                        this.editMinions(character);
                        break;
                    case 8:
                        this.editModifiers(character);
                        break;
                    case 9:
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

    public void showMenuAddProperties() throws IOException {
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
                System.out.println("Name already used, try it again!");
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


    public void editGold(Character character) {
        System.out.println("Write the new amount of gold: ");
        int gold = scanner.nextInt();
        character.setGold(gold);


    }


    public void editSpecialAbilities(Character character) {
        int defence=0,attack=0;
        System.out.println("Write the name of the special ability: ");
        String ability= scanner.nextLine();

        do{
            System.out.println("Write the defence value: ");
             defence=scanner.nextInt();
            System.out.println("Write the attack value: ");
             attack= scanner.nextInt();
             if (((attack<1)||(attack>3)) && ((defence<1)||(defence>3)) ){
                 System.out.println("Write correct values, try it again!");
             }
        }while(((attack<1)||(attack>3)) && ((defence<1)||(defence>3)) );

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
                character.setDisciplines(ability,attack,defence,typeCharacter,value);
                break;
            case Lycanthrope:
                System.out.println("Write the fury value: ");
                value=scanner.nextInt();
                character.setDon(ability,attack,defence,typeCharacter,value);
                break;
            case Hunter:
                character.setTalent(ability,attack,defence,typeCharacter);
                break;
        }

    }


    public void editMinions(Character character) {
        String type;
        TMinion typeMinion;
        boolean found=false;
        System.out.println("Write the name of the minion: ");
        String name = scanner.nextLine();
        System.out.println("Write the health of the minion: ");
        int health = scanner.nextInt();
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
        switch(typeMinion){
            case Demons:

                TCharacter typeCharacter= character.getType();
                TCharacter vampire= TCharacter.Vampire;
                if (typeCharacter!=vampire) {
                    System.out.println("Write the pact: ");
                    String pact = scanner.nextLine();
                    character.setDemons(name, health, pact);
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
                character.setGhouls(name,health,dependency);
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
                character.setHumans(name,health,loyalty);
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
                    do {
                        System.out.println("Write the name of the armor: ");
                        String armor = scanner.nextLine();
                        System.out.println("Write the defence value: ");
                        defenceValue = scanner.nextInt();
                        System.out.println("If you want to add attack value to the armor write 1");
                        int optionAdd= scanner.nextInt();
                        if (optionAdd==1){
                            do{
                            System.out.println("Write the attack value: ");
                            attackValue = scanner.nextInt();
                                if (((attackValue < 1) || (attackValue > 3))) {
                                    System.out.println("Write correct values, try it again!");

                                }
                            }while(((attackValue < 1) || (attackValue > 3)));
                        }
                        if (((defenceValue < 1) || (defenceValue > 3))) {
                            System.out.println("Write correct values, try it again!");

                        } else {
                            character.setArmor(armor, defenceValue, attackValue);
                        }
                    } while (((defenceValue < 1) || (defenceValue > 3)));

                    break;
                case 2:
                    do {
                        System.out.println("Write the name of the weapon: ");
                        String weapon = scanner.nextLine();
                        System.out.println("Write the attack value: ");
                        attackValue = scanner.nextInt();
                        System.out.println("1 or 2 hand: ");
                        int type = scanner.nextInt();
                        System.out.println("If you want to add defence value to the weapom write 1");
                        int optionAdd= scanner.nextInt();
                        if (optionAdd==1){
                            do{
                                System.out.println("Write the attack value: ");
                                defenceValue = scanner.nextInt();
                                if (((defenceValue < 1) || (defenceValue > 3))) {
                                    System.out.println("Write correct values, try it again!");

                                }
                            }while(((defenceValue < 1) || (defenceValue > 3)));
                        }
                        if (((attackValue < 1) || (attackValue > 3))) {
                            System.out.println("Write correct values, try it again!");

                        } else {
                            character.setArmor(weapon,type, defenceValue, attackValue);
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
        int exit=0,value=0;
        while (exit!=1) {
        System.out.println("1. Edit weaknesses");
        System.out.println("2. Edit strengths");
        System.out.println("3. Exit");
        int option=scanner.nextInt();
            switch (option) {
                case 1:
                    do {
                        System.out.println("Write the name of the weakness: ");
                        String weaknesses = scanner.nextLine();
                        System.out.println("Write the value: ");
                        value = scanner.nextInt();
                        if (((value < 1) || (value > 5))) {
                            System.out.println("Write correct values, try it again!");
                        } else {
                            character.setModifiers(weaknesses, value, Weaknesses);
                        }
                    } while (((value < 1) || (value > 5)));

                    break;
                case 2:
                    do {
                        System.out.println("Write the name of the strength: ");
                        String strength = scanner.nextLine();
                        System.out.println("Write the value: ");
                        value = scanner.nextInt();
                        if (((value < 1) || (value > 5))) {
                            System.out.println("Write correct values, try it again!");
                        } else {
                            character.setModifiers(strength, value, Strengths);
                        }
                    } while (((value < 1) || (value > 5)));
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