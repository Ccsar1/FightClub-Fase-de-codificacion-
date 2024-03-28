
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
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setSpecialAbilities(special);
            dataBase.saveFiles();
        }


    }

    public void editMinions(Character character) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setMinions(minions);
            dataBase.saveFiles();
        }


    }
    public void editEquipment(Character character) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setMinions(minions);
            dataBase.saveFiles();
        }


    }




}