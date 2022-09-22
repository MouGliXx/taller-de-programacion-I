package modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;

import java.util.ArrayList;

public class Cerveceria {
    private static Cerveceria instance = null;
    private String nombreDelLocal;
    private Administrador administrador;
    ArrayList<Operario> operarios = new ArrayList<>();

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
}
