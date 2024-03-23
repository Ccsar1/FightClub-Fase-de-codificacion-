
import java.io.*;
import java.util.*;

/**
 *
 */
public class Don extends SpecialAbility {

    private int fury;
    public Don(String name, int attack, int defence, TAbility type, int fury) {
        super(name,attack,defence,type);
        this.fury=fury;
    }

    public void setFury(int fury){
        this.fury=fury;
    }

    public int getFury(){
        return this.fury;
    }

    @Override
    public void execute() {

    }

}