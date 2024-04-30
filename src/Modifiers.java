import java.io.Serializable;

public class Modifiers implements Serializable {

    public Modifiers(String name) {
        this.name = name;
    }

    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}