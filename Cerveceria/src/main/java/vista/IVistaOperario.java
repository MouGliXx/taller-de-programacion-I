package vista;

import java.awt.event.WindowListener;

public interface IVistaOperario extends IVista{

    void setWindowListener(WindowListener controlador);

    void setModelos();

    void cambiarPagina(int pagina);
}
