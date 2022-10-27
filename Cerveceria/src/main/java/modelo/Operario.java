package main.java.modelo;

public class Operario {
    private String nombreCompleto;
    private String username; //(10)
    private String password; //(12)
    private boolean activo;

    public Operario(String nombreCompleto, String nombreUsuario, String password) {
        this.nombreCompleto = nombreCompleto;
        this.username = nombreUsuario;
        this.password = password;
        this.activo = true;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
