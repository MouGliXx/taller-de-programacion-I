package vista.interfaces;

import modelo.Comanda;

import java.awt.event.WindowListener;

public interface IVistaOperario extends IVista{

    void setWindowListener(WindowListener controlador);

    void setNombreLocal();

    void setNombreCompleto(String nombreCompleto);

    void setModelos();

    void inicializarListas();

    Comanda getComandaSeleccionada();

    void cambiarPagina(int pagina);
}
