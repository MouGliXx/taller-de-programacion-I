package modelo;

public class Administrador {
    private String username; //(10)
    private String password; //(12)

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
