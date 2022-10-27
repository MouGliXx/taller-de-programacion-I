package vista;

import java.awt.event.WindowListener;

public interface IVistaLogin extends IVista {

    void setWindowListener(WindowListener controlador);

    void setKeyListener();

    String getUsername();

    String getPassword();

    void nombreUsuarioInvalido();

    void contrasenaInvalida();
}
