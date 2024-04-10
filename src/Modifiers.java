import java.io.Serializable;

public abstract class Modifiers implements Serializable {

    public Modifiers(String name, int value, TModifiers type) {
        this.name = name;
        this.value = value;
        this.modifiersType = type;
    }

    private String name;
    private int value;
    private TModifiers modifiersType;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public TModifiers getModifiersType() {
        return this.modifiersType;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}