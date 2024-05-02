import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LycanthropeTest {

    SpecialAbility aullar = new Gift("aullar", 3, 3, 3);
    Lycanthrope lobo = new Lycanthrope("Javier", 4, 5, aullar, 169, 93);

    @Test
    void getHeight() {
        assertEquals(169, lobo.getHeight());
    }

    @Test
    void getWeight() {
        assertEquals(93, lobo.getWeight());
    }

    @Test
    void setHeight() {
        lobo.setHeight(170);
        assertEquals(170, lobo.getHeight());
    }

    @Test
    void setWeight() {
        lobo.setWeight(73);
        assertEquals(73, lobo.getWeight());
    }
}