import static org.junit.jupiter.api.Assertions.*;

class DisciplinesTest {
    static Disciplines disciplines;
    @BeforeAll
    static void initializeDisciplines(){
        disciplines= new Disciplines("Name",2,3,10);
    }
    @Test
    void setcost(){
        this.cost=2;
    }
    @Test
    void getcost(){
        assertEquals("disciplines", Disciplines.getCost());
    }
}