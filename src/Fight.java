
import java.io.*;
import java.util.*;


public class Fight {

    private Player challengerPlayer;
    private Player challengedPlayer;
    private CharacterUser characterChallenger;
    private CharacterUser characterChallenged;
    private int gold;
    private int roundNum;
    private ArrayList<Round> roundList;
    private int result; //0: draw; 1: challenger wins; 2: challenged wins
    private boolean notified;
    public Fight(Player challengerPlayer, Player challengedPlayer, CharacterUser challengerCharacter, CharacterUser challengedCharacter, int gold) {
        this.challengerPlayer = challengerPlayer;
        this.challengedPlayer = challengedPlayer;
        this.characterChallenger=challengerCharacter;
        this.characterChallenged=challengedCharacter;
        this.gold=gold;
        this.roundNum = 0;
        this.roundList = new ArrayList<>();
        this.notified = false;
    }

    public void giveUp(){
        characterChallenged.removeGold(gold);
        characterChallenger.addGold(gold);
        this.result = 1;
    }

    public void startFight() {
        Round round= new Round(this.characterChallenger,this.characterChallenged);

        do {
            round.playRound();
            roundList.add(round);
        }while(characterChallenger.getHP() > 0 && characterChallenged.getHP() > 0);
        if (characterChallenger.getHP() > 0) {
            this.result = 1;
            characterChallenged.removeGold(gold);
            characterChallenger.addGold(gold);
        } else if (characterChallenged.getHP() > 0) {
            this.result = 2;
            characterChallenger.removeGold(gold);
            characterChallenged.addGold(gold);
        } else {
            this.result = 0;
        }
        characterChallenged.resetValues();
        characterChallenger.resetValues();

    }


    public void showResult() {
        if (!this.roundList.isEmpty()) {
            int i = 1;
            for (Round round : this.roundList) {
                System.out.println("Round " + i);
                if (round.challengerAttack()) {
                    System.out.println(challengerPlayer.getNick() + "'s character, " + characterChallenger.getName() + ", deals damage to " + challengedPlayer.getNick() + "'s character, " + characterChallenged.getName());
                }
                if (round.challengedAttack()) {
                    System.out.println(challengedPlayer.getNick() + "'s character, " + characterChallenged.getName() + ", deals damage to " + challengerPlayer.getNick() + "'s character, " + characterChallenger.getName());
                }
                i++;
            }

        } else {
            System.out.println("The player " + this.challengedPlayer + " has paid " + this.gold + " to avoid the fight");
        }
    }

    public boolean getNotified(){
        return notified;
    }
    public void setNotified(){
        this.notified=true;

    }

    public Player getChallenger(){
        return this.challengerPlayer;
    }

    public Player getChallenged() {
        return this.challengedPlayer;
    }

    public void showPayment() {
        switch (this.result) {
            case 1:
                System.out.println(this.challengedPlayer + " pays " + this.gold + " to " + this.challengerPlayer);
            case 2:
                System.out.println(this.challengerPlayer + " pays " + this.gold + " to " + this.challengedPlayer);
        }
    }
}