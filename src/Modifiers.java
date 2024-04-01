/**
 *
 */
public abstract class Modifiers {

    /**
     * Default constructor
     */
    public Modifiers() {
    }

    /**
     *
     */
    private String name;
    private int value;
    private TModifiers modifiersType;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    /**
     * @return
     */
    public TModifiers getModifiersType() {
        return this.modifiersType;
    }

    /**
     * @param type
     */

    public String getName(){
        return this.name;
    }
    public void setModifiersType(TModifiers type) {
        this.modifiersType = type;
    }

}