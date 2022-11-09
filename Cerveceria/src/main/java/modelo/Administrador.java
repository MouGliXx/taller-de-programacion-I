package modelo;

import java.io.Serializable;

public class Administrador implements Serializable {
    private String username;
    private String password;

    //CONSTRUCTOR
    public Administrador(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //GETTERS & SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
