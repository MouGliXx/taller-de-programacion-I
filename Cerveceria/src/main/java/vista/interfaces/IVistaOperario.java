package vista.interfaces;

import modelo.Comanda;
import modelo.Factura;
import modelo.ProductoEnPromocion;
import modelo.PromocionTemporal;

import javax.swing.event.ListSelectionListener;
import java.awt.event.WindowListener;

public interface IVistaOperario extends IVista{

    void setListSelectionListener();

    void setWindowListener(WindowListener controlador);

    void setNombreLocal();

    void setNombreCompleto(String nombreCompleto);

    void setModelos();

    void inicializarListas();

    Comanda getComandaSeleccionada();

    Factura getFacturaSeleccionada();

    ProductoEnPromocion getProductoEnPromocionSeleccionado();

    PromocionTemporal getPromocionTemporalSeleccionada();

    void cambiarPagina(int pagina);
}
