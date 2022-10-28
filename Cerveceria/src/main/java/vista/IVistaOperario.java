package vista;

import modelo.Comanda;
import modelo.Factura;
import modelo.IPromocion;

import java.awt.event.WindowListener;
import java.util.ArrayList;

public interface IVistaOperario extends IVista{

    void setWindowListener(WindowListener controlador);

    void setNombreLocal();

    void setNombreCompleto(String nombreCompleto);

    void setModelos();

    void inicializarListas(ArrayList<Comanda> comandas, ArrayList<Factura> facturas, ArrayList<IPromocion> promociones);

    Comanda getComandaSeleccionada();

    void cambiarPagina(int pagina);
}
