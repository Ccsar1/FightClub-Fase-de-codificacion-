import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VampireTests {
    SpecialAbility habilidad = new Disciplines("FLY", 3, 3, 1);
    @Test
    public void testGetAge() {
        Vampire vampire = new Vampire("Dracula", 10, 100, habilidad , 200);
        assertEquals(200, vampire.getAge());
    }

    @Test
    public void testSetAge() {
        Vampire vampire = new Vampire("Dracula", 10, 100, habilidad, 200);
        vampire.setAge(300);
        assertEquals(300, vampire.getAge());
    }
}

