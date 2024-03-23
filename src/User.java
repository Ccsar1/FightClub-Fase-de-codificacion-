
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
     * @param pass
     * @return
     */
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

}