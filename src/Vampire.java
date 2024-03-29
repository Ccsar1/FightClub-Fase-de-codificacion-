
public class Vampire extends Character {

    public Vampire() {
    }

    private int blood;
    private int age;

    private Disciplines vampireAbility;
    public boolean checkHumanMinion() {
        return false;
    }

    public int getBlood() {
        return blood;
    }
    public void setBlood(int blood) {
        this.blood=blood;
    }

}