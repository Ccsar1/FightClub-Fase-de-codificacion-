
import java.io.*;
import java.util.*;

/**
 *
 */
public abstract class User {

    /**
     * Default constructor
     */
    public User(String username, String nick, String pass, TUser userType, DataBaseManager db) {
        this.name = username;
        this.nickname = nick;
        this.password = pass;
        this.type = userType;
        this.dataBase = db;
    }

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String nickname;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private TUser type;

    /**
     *
     */
    protected DataBaseManager dataBase;

    public String getNick() {
        return nickname;
    }

    /**
     * @param pass
     * @return
     */
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    public abstract boolean showMenu();

    public String getName() {
        return name;
    }

}