package vista.interfaces;

import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;

import javax.swing.event.ListSelectionListener;
import java.awt.event.WindowListener;

public interface IVistaAdministrador extends IVista {

    void setKeyListener();

    void setListSelectionListener();

    void setWindowListener(WindowListener controlador);

    void setModelos();

    void actualizaListaOperarios();

    void actualizaListaMozos();

    void actualizaListaProductos();

    void actualizaListaMesas();

    void inicializarListas();

    String getNombreLocal();

    Double getRemuneracion();

    String getTipoEntidadSeleccionada();

    Operario getOperarioSeleccionado();

    Mozo getMozoSeleccionado();

    Producto getProductoSeleccionado();

    Mesa getMesaSeleccionado();

    String getTipoPromocionSeleccionada();

    String getPromocionSeleccionada();

    void cambiarPagina(int pagina);
}
