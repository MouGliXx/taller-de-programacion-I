package modelo;

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

    public Administrador login(String password) {

        if (password.equalsIgnoreCase(administrador.getPassword())) {
            return this.administrador;
        }

        return null;
    }

//    public Operario login(String username, String password) {
//
//        for (Operario operario: operarios) {
//            if (operario.getUsername().equalsIgnoreCase(username)) {
//                if (operario.getPassword().equalsIgnoreCase(password))
//                    return operario;
//                else
//                    throw new ;
//            }
//        }
//
//        throw new ;
//    }
}
