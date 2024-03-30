
import java.io.*;
import java.util.*;

/**
 *
 */
public class Challenge {

    /**
     * Default constructor
     */
    public Challenge(Player challengerPlayer, Player challengedPlayer, CharacterUser challengerCharacter, int goldBet) {
        this.challenger = challengerPlayer;
        this.challenged = challengedPlayer;
        this.challengerCharacter = challengerCharacter;
        this.gold = goldBet;
        this.valid = false;
    }

    /**
     *
     */
    private Player challenger;

    /**
     *
     */
    private Player challenged;

    private CharacterUser challengerCharacter;

    /**
     *
     */
    private int gold;

    /**
     *
     */
    private boolean valid;

    /**
     * @return
     */
    public Player getChallenger() {
        return this.challenger;
    }

    /**
     * @return
     */
    public Player getChallenged() {
        return this.challenged;
    }

    public CharacterUser getChallengerCharacter() {
        return this.challengerCharacter;
    }

    /**
     * @return
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * @return
     */
    public boolean getValid() {
        return this.valid;
    }

    /**
     *
     */
    public void setValid() {
        this.valid = true;
    }

}