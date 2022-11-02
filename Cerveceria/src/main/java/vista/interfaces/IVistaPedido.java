package vista.interfaces;

import modelo.Pedido;
import modelo.Producto;

public interface IVistaPedido extends IVista {

    void setItemListener();

    void setAccion(String accion);

    void setModelos();

    void inicializaComboBox(Pedido pedido);

    Producto getProductoSeleccionado();

    int getCantidadSeleccionada();
}
