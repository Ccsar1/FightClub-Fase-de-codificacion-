
import java.io.*;
import java.util.*;

/**
 *
 */
public class Round implements Serializable {

    Random random;
    CharacterUser characterChallenger;
    CharacterUser characterChallenged;

    private boolean challengerAttack;
    private boolean challengedAttack;
    private boolean challengerMinion;
    private boolean challengedMinion;
    private int challengerHP;
    private int challengedHP;



    private Modifiers modifier;

    public Round(CharacterUser characterChallenger, CharacterUser characterChallenged, Modifiers modifier) {
        this.random=new Random();
        this.characterChallenger=characterChallenger;
        this.characterChallenged=characterChallenged;
        this.challengerAttack=false;
        this.challengedAttack=false;
        this.challengerMinion=false;
        this.challengedMinion=false;
        this.challengerHP=0;
        this.challengedHP=0;

        this.modifier = modifier;
    }

    public void playRound() {
        int attackChallengerExists=0,defenceChallengerExists=0,attackChallengedExists=0,defenceChallengedExists=0;
        int potentialAttackCharacterChallenger= characterChallenger.calculateAttack(this.modifier);
        int potentialDefenceCharacterChallenger= characterChallenger.calculateDefense(this.modifier);
        int potentialAttackCharacterChallenged= characterChallenger.calculateAttack(this.modifier);
        int potentialDefenceCharacterChallenged= characterChallenger.calculateDefense(this.modifier);
        int [] attackChallenger= new int[potentialAttackCharacterChallenger];
        int [] defenceChallenger= new int[potentialDefenceCharacterChallenger];
        int [] attackChallenged= new int[potentialAttackCharacterChallenged];
        int [] defenceChallenged= new int[potentialDefenceCharacterChallenged];

        for (int i=0; i<potentialAttackCharacterChallenger; i++){
            int randomNumber= random.nextInt(6)+1;
            attackChallenger[i]=randomNumber;
            if (randomNumber==5 || randomNumber==6){
                attackChallengerExists++;
            }
        }
        for (int i=0; i<potentialDefenceCharacterChallenger; i++){
            int randomNumber= random.nextInt(6)+1;
            defenceChallenger[i]=randomNumber;
            if (randomNumber==5 || randomNumber==6){
                defenceChallengerExists++;
            }
        }
        for (int i=0; i<potentialAttackCharacterChallenged; i++){
            int randomNumber= random.nextInt(6)+1;
            attackChallenged[i]=randomNumber;
            if (randomNumber==5 || randomNumber==6){
                attackChallengedExists++;
            }
        }
        for (int i=0; i<potentialDefenceCharacterChallenged; i++){
            int randomNumber= random.nextInt(6)+1;
            defenceChallenged[i]=randomNumber;
            if (randomNumber==5 || randomNumber==6){
                defenceChallengedExists++;
            }
        }

        if (attackChallengerExists>=defenceChallengedExists){
            SetchallengedMinion();
            characterChallenged.doDamage();
            characterChallenged.gainFury();
            characterChallenged.loseWillpower();
            characterChallenger.gainBlood();
            SetchallengerAttack();
        }
        if (attackChallengedExists>=defenceChallengerExists){
            SetchallengerMinion();
            characterChallenger.doDamage();
            characterChallenger.gainFury();
            characterChallenger.loseWillpower();
            characterChallenged.gainBlood();
            SetchallengedAttack();
        }
        GetchallengerHP();
        GetchallengedHP();


    }

    public void SetchallengerAttack(){
        this.challengerAttack=true;
    }

    public void SetchallengedAttack(){
        this.challengedAttack=true;
    }
    public void SetchallengerMinion(){
        this.challengerMinion= characterChallenger.surviveMinionHP();
    }

    public void SetchallengedMinion(){
        this.challengedMinion= characterChallenged.surviveMinionHP();
    }
    public void GetchallengerHP(){
         this.challengerHP=characterChallenger.getHP();
    }

    public void GetchallengedHP(){
        this.challengedHP=characterChallenged.getHP();
    }
    public boolean challengerAttack(){
        return this.challengerAttack;
    }

    public boolean challengedAttack(){
        return this.challengedAttack;
    }

    public boolean minionLiveChallenger(){ return this.challengerMinion;}
    public boolean minionLiveChallenged(){ return this.challengedMinion;}
    public int HPChallenger(){ return this.challengerHP;}
    public int HPChallenged(){ return this.challengedHP;}
}
