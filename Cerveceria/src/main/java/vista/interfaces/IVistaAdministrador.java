package vista.interfaces;

import modelo.*;

public interface IVistaAdministrador extends IVista {

    void setKeyListener();

    void setListSelectionListener();

    void setModelos();

    void actualizarLista(String nombreLista);

    void inicializarListasEntidades();

    void inicializarListasPromociones();

    String getNombreLocal();

    void setNombreLocal(String nombreLocal);

    Double getRemuneracion();

    void setRemuneracion(double remuneracion);

    String getTipoEntidadSeleccionada();

    Operario getOperarioSeleccionado();

    Mozo getMozoSeleccionado();

    Producto getProductoSeleccionado();

    Mesa getMesaSeleccionado();

    String getTipoPromocionSeleccionada();

    PromocionProducto getProductoEnPromocionSeleccionado();

    PromocionTemporal getPromocionTemporalSeleccionada();

    void cambiarPagina(int pagina);
}
