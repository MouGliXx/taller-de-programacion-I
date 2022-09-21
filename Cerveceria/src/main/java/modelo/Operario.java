package modelo;

public class Operario {
    private String nombreCompleto;
    private String nombreUsuario; //(10)
    private String password; //(12)
    private boolean activo;

    public Operario(String nombreCompleto, String nombreUsuario, String password) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.activo = true;
    }
}
