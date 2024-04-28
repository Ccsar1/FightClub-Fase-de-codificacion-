
import java.io.*;
import java.util.*;

public class Challenge implements Serializable {

    public Challenge(Player challengerPlayer, Player challengedPlayer, CharacterUser challengerCharacter, int goldBet) {
        this.challenger = challengerPlayer;
        this.challenged = challengedPlayer;
        this.challengerCharacter = challengerCharacter;
        this.gold = goldBet;
        this.valid = false;
    }

    private Player challenger;

    private Player challenged;

    private CharacterUser challengerCharacter;

    private int gold;

    private boolean valid;

    private Modifiers modifier;

    public Player getChallenger() {
        return this.challenger;
    }

    public Player getChallenged() {
        return this.challenged;
    }

    public CharacterUser getChallengerCharacter() {
        return this.challengerCharacter;
    }

    public int getGold() {
        return this.gold;
    }

    public boolean getValid() {
        return this.valid;
    }

    public void setValid() {
        this.valid = true;
    }

    public Modifiers getModifier() {
        return this.modifier;
    }

    public void setModifier(Modifiers modifier) {
        this.modifier = modifier;
    }

    public void removeModifier(Modifiers modifier) {
        this.modifier = null;
    }

}