/**
 *
 */
public class Lycanthrope extends Character {

    /**
     * Default constructor
     */
    public Lycanthrope() {
        this.height = height;
        this.weight = weight;
        this.fury = fury;
    }

    /**
     *
     */
    private int fury = 0;

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int alt){
        this.height = alt;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int pes){
        this.weight = pes;
    }

    /**
     *
     */

    private int height = 170;

    /**
     *
     */
    private int weight = 70;

    /**
     *
     */
    private Don lycanthropeAbility;

    /**
     * @return
     */
    public int getFury() {
        return this.fury;
    }

    /**
     * @param fury
     */
    public void setFury(int fury) {
        if (fury > 3){
            this.fury = 3;
        } else if (fury < 0) {
            this.fury = 0;
        } else {
            this.fury = fury;
        }
    }

}