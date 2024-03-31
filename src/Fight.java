
import java.io.*;
import java.util.*;


public class Fight {

    private CharacterUser characterChallenger;
    private CharacterUser characterChallenged;
    private int gold;
    private int roundNum;
    private ArrayList<Round>roundList;
    private int result;
    private boolean notified;
    public Fight(CharacterUser characterChallenger, CharacterUser characterChallenged, int gold ) {
        this.characterChallenger=characterChallenger;
        this.characterChallenged=characterChallenged;
        this.gold=gold;
    }
    //esto se mete en startRound
    //1.llamo calculateAttack y calculateDefense de ambos characterUser
    //2.Hacer lo de los numeros aleatorios que ponen en el enunciado de la practica
    //3.doDamage 1, si el ataque sea mayor que la defensa
    //esto en startfight
    //meter en arraylist round
    //4.compruebo si tienen salud, hago otra ronda

    //en showresult, imprimo el arraylist de las rondas, pongo quien ha ganado al final, y quito el oro en la función que me ha puesto Cesar en Whatsapp; y si la lista esta vacia, pongo que el challenged ha rechazado el desafío

    public void giveUp(){

    }

    public void startFight() {
        int HPChallenger,HPChallenged;
        Round round= new Round(characterChallenger,characterChallenged);

do {
    round.playRound();
    roundList.add(round);
    HPChallenger=getChallenger().getHP();
    HPChallenged=getChallenged().getHP();
}while(HPChallenger>0 && HPChallenged>0);


    }


    public void showResult(TResult state, CharacterUser character) {
        System.out.println("FINISH!!");

        switch (state){
            case Win:
                System.out.println(character+" you win the fight!");
                System.out.println((gold*2)+" earned, congratulations!");
                int goldTotal= character.getGold();
                character.setGold(goldTotal+gold);
                break;
            case Draw:
                System.out.println(character+" you draw the fight!");
                break;
            case Lose:
                System.out.println(character+" you lose the fight!");
                System.out.println((gold)+" remove from your account, sorry!");
                int goldT= character.getGold();
                character.setGold(goldT-gold);
                break;
        }

    }

    public boolean getNotified(){
        return notified;
    }
    public void setNotified(){
        this.notified=true;

    }

    public CharacterUser getChallenger(){
        return this.characterChallenger;
    }
    public CharacterUser getChallenged(){
        return this.characterChallenged;
    }
    public void setChallenger(CharacterUser character){
        this.characterChallenger=character;
    }
    public void setChallenged(CharacterUser character){
        this.characterChallenged=character;
    }

}