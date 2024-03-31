
import java.io.*;
import java.util.*;

/**
 *
 */
public class Round {

    Random random=new Random();
    CharacterUser characterChallenger;
    CharacterUser characterChallenged;

    private boolean challengerAttack=false;
    private boolean challengedAttack=false;


    public Round(CharacterUser characterChallenger, CharacterUser characterChallenged) {
        this.characterChallenger=characterChallenger;
        this.characterChallenged=characterChallenged;

    }

    public void playRound() {
        int attackChallengerExists=0,defenceChallengerExists=0,attackChallengedExists=0,defenceChallengedExists=0;
        int potentialAttackCharacterChallenger= characterChallenger.calculateAttack();
        int potentialDefenceCharacterChallenger= characterChallenger.calculateDefense();
        int potentialAttackCharacterChallenged= characterChallenger.calculateAttack();
        int potentialDefenceCharacterChallenged= characterChallenger.calculateDefense();
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
            characterChallenged.doDamage();
            SetchallengerAttack();
        }
        if (attackChallengedExists>=defenceChallengerExists){
            characterChallenger.doDamage();
            SetchallengedAttack();
        }


    }

    public void SetchallengerAttack(){
        this.challengerAttack=true;
    }

    public void SetchallengedAttack(){
        this.challengedAttack=true;
    }
    public boolean challengerAttack(){
        return this.challengerAttack;
    }

    public boolean challengedAttack(){
        return this.challengedAttack;
    }

}