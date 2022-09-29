package main.java.modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;

import java.util.ArrayList;

public class Cerveceria{
    private static Cerveceria instance = null;
    private String nombreDelLocal;
    private Administrador administrador;
    ArrayList<Operario> operarios = new ArrayList<>();
    ArrayList<Mozo> mozos = new ArrayList<>();

    //PATRON SINGLETON
    public Cerveceria() {
        this.nombreDelLocal = "CERVECERIA";
        this.administrador = new Administrador("ADMIN", "ADMIN1234");
    }

    public static Cerveceria getInstance() {
        if (instance == null)
            instance = new Cerveceria();
        return instance;
    }

    public Administrador login(String password) throws ErrorDeContrasenaException {

        if (password.equalsIgnoreCase(administrador.getPassword())) {
            return this.administrador;
        }

        throw new ErrorDeContrasenaException("Contrasena invalida: " + password);
    }

    public Operario login(String username, String password) throws ErrorDeUsuarioException, ErrorDeContrasenaException {

        for (Operario operario: operarios) {
            if (operario.getUsername().equalsIgnoreCase(username)) {
                if (operario.getPassword().equalsIgnoreCase(password))
                    return operario;

                throw new ErrorDeContrasenaException("Contrasena invalida: " + password);
            }
        }

        throw new ErrorDeUsuarioException("Nombre de usuario invalido: " + username);
    }

    public static void setInstance(Cerveceria instance) {
        Cerveceria.instance = instance;
    }

    public String getNombreDelLocal() {
        return nombreDelLocal;
    }

    public void setNombreDelLocal(String nombreDelLocal) {
        this.nombreDelLocal = nombreDelLocal;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public ArrayList<Operario> getOperarios() {
        return operarios;
    }

    public void setOperarios(ArrayList<Operario> operarios) {
        this.operarios = operarios;
    }

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public void setMozos(ArrayList<Mozo> mozos) {
        this.mozos = mozos;
    }

    public void agregarMozo(Mozo mozo){
        this.getMozos().add(mozo);
    }

    public void eliminarMozo(Mozo mozoViejo){
        for (int i = 0 ; i < this.getMozos().size() ; i++){
            if (this.getMozos().get(i).equals(mozoViejo)) {
                this.getMozos().remove(i);
                break;
            }
        }
    }
}
