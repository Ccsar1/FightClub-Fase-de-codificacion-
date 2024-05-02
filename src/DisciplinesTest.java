import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisciplinesTest {
    static Disciplines disciplines;
    private int cost;
    @BeforeAll
    static void initializeDisciplines(){
        disciplines= new Disciplines("Name",2,3,2);
    }
    @Test
    void getcost(){
        this.cost=2;
        disciplines.setCost(cost);
        assertEquals(cost, disciplines.getCost());
    }
}