
public abstract class Modifiers {

    public Modifiers() {
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
    public void setModifiersType(TModifiers type) {
        this.modifiersType = type;
    }

}