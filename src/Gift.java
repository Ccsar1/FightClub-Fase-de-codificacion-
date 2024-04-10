/**
 *
 */
public class Gift extends SpecialAbility {

    private int fury;
    public Gift(String name, int attack, int defence, int fury) {
        super(name,attack,defence,TAbility.Gift);
        this.fury=fury;
    }

    public void setFury(int fury){
        this.fury=fury;
    }

    public int getFury(){
        return this.fury;
    }



}