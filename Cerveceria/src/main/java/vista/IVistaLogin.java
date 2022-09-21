package vista;

public interface IVistaLogin extends IVista {

    void setKeyListener();

    String getUsername();

    String getPassword();

    void nombreUsuarioInvalido();

    void contrasenaInvalida();
}
