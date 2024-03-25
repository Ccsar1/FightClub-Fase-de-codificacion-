
import java.io.*;
import java.util.*;

/**
 *
 */
public class Operator extends User {

    /**
     * Default constructor
     */
    public Operator(String username, String nick, String pass, DataBaseManager db) {
        super(username, nick, pass, TUser.Operator, db);
    }

    /**
     *
     */
    public void editCharacter() {
        // TODO implement here
    }

    /**
     *
     */
    public void addToCharacter() {
        // TODO implement here
    }

    /**
     *
     */
    public void validateChallenge() {
        // TODO implement here
    }

    /**
     *
     */
    public void blockUser() {
        // TODO implement here
    }

    /**
     *
     */
    public void unlockUser() {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean showMenuOperator() {
        // TODO implement here
        return false;
    }

    @Override
    public boolean showMenu() {
        return false;
    }
}