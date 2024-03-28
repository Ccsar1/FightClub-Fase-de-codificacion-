
import java.io.*;
import java.util.*;


public class CharacterEditor {

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
            System.out.println("8. Edit weapons");
            System.out.println("9. Edit armor");
            System.out.println("10. Exit");


            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            System.out.println("Write the name of the character");
            String nameCharacter = scanner.nextLine();

            switch (input) {
                case 1:
                    this.editName(nameCharacter);
                    break;
                case 2:
                    this.editPower(nameCharacter);
                    break;
                case 3:
                    this.editType(nameCharacter);
                    break;
                case 4:
                    this.editGold(nameCharacter);
                    break;
                case 5:
                    this.editSpecialAbilities(nameCharacter);
                    break;
                case 6:
                    this.editEquipment(nameCharacter);
                    break;
                case 7:
                    this.editMinions(nameCharacter);
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
        }
        System.out.println("---saving database");
    }
    public void editName(String nameCharacter) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setName(name);
            dataBase.saveFiles();
        }

    }

    public void editPower(String nameCharacter) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setPower(power);
            dataBase.saveFiles();
        }


    }

    public void editType(String nameCharacter) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setType(type);
            dataBase.saveFiles();
        }


    }


    public void editGold(String nameCharacter) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setGold(gold);
            dataBase.saveFiles();
        }


    }


    public void editSpecialAbilities(String nameCharacter) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setSpecialAbilities(special);
            dataBase.saveFiles();
        }


    }

    public void editMinions(String nameCharacter) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setMinions(minions);
            dataBase.saveFiles();
        }


    }
    public void editEquipment(String nameCharacter) {
        if (dataBase.checkExistsCharacter(character.getName())){
            character.setMinions(minions);
            dataBase.saveFiles();
        }


    }




}