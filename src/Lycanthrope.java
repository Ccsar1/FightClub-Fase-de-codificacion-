/**
 *
 */
public class Lycanthrope extends Character {

    /**
     * Default constructor
     */
    public Lycanthrope() {
    }

    /**
     *
     */
    private int fury = 0;

    /**
     *
     */

    private int height;

    /**
     *
     */
    private int weight;

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