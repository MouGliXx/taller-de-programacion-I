package vista.interfaces;

import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

public interface IVistaOperario extends IVista{

    void setModelos();

    void setItemListener(ItemListener controlador);

    void setListSelectionListener();

    void setNombreLocal();

    void setNombreCompleto(String nombreCompleto);

    void inicializarMozos();

    void inicializarListas();

    void asignarMesas(HashMap<Mesa, Mozo> mesasAsignadas);

    ArrayList<String> getEstadoMozos();

    Comanda getComandaSeleccionada();

    void cambiarPagina(int pagina);
}
