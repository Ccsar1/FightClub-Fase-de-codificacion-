import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HunterTest {

    SpecialAbility talento = new Talent ("talento", 3, 3);
    Hunter cazador = new Hunter("Jose", 3, 4, talento, 3);

    @Test
    void getWillpower() {
        assertEquals(3, cazador.getWillpower());
    }

    @Test
    void setWillpower() {
        cazador.setWillpower(2);
        assertEquals(2, cazador.getWillpower());
    }
}