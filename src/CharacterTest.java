import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    SpecialAbility aullar = new Gift("aullar", 3, 3, 3);
    SpecialAbility luna = new Gift("luna", 2, 3, 1);
    Character lobo = new Lycanthrope("Javier", 4, 5, aullar, 169, 93);
    Minions Lucifer = new Demons("Lucifer", 3, "sangre");
    Armor casco = new Armor("casco", 3, 3);
    Weapons sierra = new Weapons("sierra", 2,3,2);
    Modifiers sol = new Modifiers("sol");

    ArrayList <Minions> minions= new ArrayList<>();
    ArrayList <Armor> armors = new ArrayList<>();
    ArrayList <Weapons> weapons = new ArrayList<>();

    @Test
    void getPower() {
        assertEquals(4, lobo.getPower());
    }

    @Test
    void getName() {
        assertEquals("Javier", lobo.getName());
    }

    @Test
    void getMinions() {
        lobo.setMinions(Lucifer);
        minions.add(Lucifer);
        assertEquals(minions, lobo.getMinions());
    }

    @Test
    void getMinionsNull(){
        assertEquals(minions, lobo.getMinions());
    }

    @Test
    void removeMinion() {
        lobo.setMinions(Lucifer);
        lobo.removeMinion(Lucifer);
        assertEquals(minions, lobo.getMinions());
    }

    @Test
    void getWeapons() {
        lobo.setWeapons(sierra);
        weapons.add(sierra);
        assertEquals(weapons, lobo.getWeapons());
    }

    @Test
    void getWeaponsNull(){
        assertEquals(weapons, lobo.getWeapons());
    }

    @Test
    void getArmor() {
        lobo.setArmor(casco);
        armors.add(casco);
        assertEquals(armors, lobo.getArmor());
    }
    @Test
    void getArmorNull(){
        assertEquals(armors, lobo.getArmor());
    }

    @Test
    void getType() {
        assertEquals(TCharacter.Lycanthrope, lobo.getType());
    }

    @Test
    void getSpecialAbilities() {
        assertEquals(aullar, lobo.getSpecialAbilities());
    }

    @Test
    void setPower() {
        lobo.setPower(2);
        assertEquals(2, lobo.getPower());
    }

    @Test
    void setName() {
        lobo.setName("Mavis");
        assertEquals("Mavis", lobo.getName());
    }

    @Test
    void setMinions() {
        lobo.setMinions(Lucifer);
        minions.add(Lucifer);
        assertEquals(minions, lobo.getMinions());
    }

    @Test
    void setWeapons() {
        lobo.setWeapons(sierra);
        weapons.add(sierra);
        assertEquals(weapons, lobo.getWeapons());
    }

    @Test
    void setArmor() {
        lobo.setArmor(casco);
        armors.add(casco);
        assertEquals(armors, lobo.getArmor());
    }

    @Test
    void setSpecialAbilities() {
        lobo.setSpecialAbilities(luna);
        assertEquals(luna, lobo.getSpecialAbilities());
    }

    @Test
    void getHp() {
        assertEquals(5, lobo.getHp());
    }

    @Test
    void getMinionHP() {
        lobo.setMinions(Lucifer);
        assertEquals(3, lobo.getMinionHP());
    }

    @Test
    void setHP() {
        lobo.setHP(1);
        assertEquals(1, lobo.getHp());
    }

    @Test
    void getModifiers() {
        ArrayList <ModifierValue> mofi = new ArrayList<>();
        assertEquals(mofi, lobo.getModifiers());
    }

    @Test
    void removeModifier() {
    }
}