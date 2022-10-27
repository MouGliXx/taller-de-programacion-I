package vista;

import java.awt.event.WindowListener;

public interface IVistaOperario extends IVista{

    void setWindowListener(WindowListener controlador);

    void setNombreCompleto(String nombreCompleto);

    void setModelos();

    void cambiarPagina(int pagina);
}
