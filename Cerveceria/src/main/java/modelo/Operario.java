package modelo;

import java.io.Serializable;

public class Operario implements Serializable {
    private String nombreCompleto;
    private String nombreUsuario;
    private String contrasena;
    private boolean activo;

    //CONSTRUCTOR
    public Operario(String nombreCompleto, String nombreUsuario, String contrasena, boolean activo) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.activo = activo;
    }

    //GETTERS & SETTERS
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    //FUNCIONALIDADES
    @Override
    public String toString() {
        return "Nombre Completo: '" + nombreCompleto + '\'' +
                " - Nombre de Usuario: '" + nombreUsuario + '\'' +
                " - Activo: " + activo;
    }
}
