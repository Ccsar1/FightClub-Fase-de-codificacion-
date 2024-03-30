/**
 *
 */
public abstract class Equipment {

    /**
     * Default constructor
     */
    public Equipment() {
    }

    /**
     *
     */
    private String name;

    /**
     *
     */
    private int attackModifier;

    /**
     *
     */
    private int defenceModifier;

    /**
     * @param i
     */
    public void setAttackModifier(int i) {
        this.attackModifier = i;
    }

    /**
     *
     */
    public int getAttackModifier() {
        return this.attackModifier;
    }

    /**
     * @param i
     */
    public void setDefenceModifier(int i) {
        this.defenceModifier = i;
    }

    /**
     *
     */
    public int getDefenceModifier() {
        return this.defenceModifier;
    }

}