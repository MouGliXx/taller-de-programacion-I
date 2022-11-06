package vista.interfaces;

import modelo.Comanda;

public interface IVistaOperario extends IVista{

    void setItemListener();

    void setListSelectionListener();

    void setNombreLocal();

    void setNombreCompleto(String nombreCompleto);

    void setModelos();

    void inicializaArrays();

    void inicializarMozos();

    void inicializarListas();

    Comanda getComandaSeleccionada();

    void cambiarPagina(int pagina);
}
