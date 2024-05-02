import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    @Test
    void setAttackModifier() {
        Armor armor = new Armor("espada", 3, 3);
        armor.setAttackModifier(1);
        assertEquals(1, armor.getAttackModifier());
    }

    @Test
    void getAttackModifier() {
        Armor armor = new Armor("espada", 3, 3);
        assertEquals(3, armor.getAttackModifier());
    }

    @Test
    void setDefenseModifier() {
        Armor armor = new Armor("espada", 3, 3);
        armor.setDefenseModifier(2);
        assertEquals(2, armor.getDefenseModifier());
    }

    @Test
    void getDefenseModifier() {
        Armor armor = new Armor("espada", 3, 3);
        assertEquals(3, armor.getDefenseModifier());
    }

    @Test
    void getTypeEquipment() {
        Armor armor = new Armor("espada", 3, 3);
        assertEquals("Armor", armor.getTypeEquipment());
    }

    @Test
    void getName() {
        Armor armor = new Armor("espada", 3, 3);
        assertEquals("espada", armor.getName());
    }

    @Test
    void setName() {
        Armor armor = new Armor("espada", 3, 3);
        armor.setName("cuchillo");
        assertEquals("cuchillo", armor.getName());
    }
}