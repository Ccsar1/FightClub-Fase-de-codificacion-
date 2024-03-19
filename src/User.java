
import java.io.*;
import java.util.*;

/**
 *
 */
public abstract class User {

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String nick;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private DataBaseManager dataBase;

    /**
     * @param password
     * @return
     */
    public Boolean checkPassword(String password) {
        // TODO implement here
        return null;
    }

}