package vista.interfaces;

import modelo.*;

import java.awt.event.WindowListener;

public interface IVistaAdministrador extends IVista {

    void setKeyListener();

    void setListSelectionListener();

    void setWindowListener(WindowListener controlador);

    void setModelos();

    void actualizaLista(String nombreLista);

    void inicializarListas();

    String getNombreLocal();

    Double getRemuneracion();

    String getTipoEntidadSeleccionada();

    Operario getOperarioSeleccionado();

    Mozo getMozoSeleccionado();

    Producto getProductoSeleccionado();

    Mesa getMesaSeleccionado();

    String getTipoPromocionSeleccionada();

    ProductoEnPromocion getProductoEnPromocionSeleccionado();

    PromocionTemporal getPromocionTemporalSeleccionada();

    void cambiarPagina(int pagina);
}
