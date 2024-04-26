import java.io.Serializable;

public class ModifierValue implements Serializable {

    private Modifiers modifier;

    private int value;

    public ModifierValue(Modifiers modifier, int value) {
        this.modifier = modifier;
        this.value = value;
    }

    public Modifiers getModifier() {
        return modifier;
    }

    public int getValue() {
        return value;
    }

    public void setModifier(Modifiers modifier) {
        this.modifier = modifier;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
