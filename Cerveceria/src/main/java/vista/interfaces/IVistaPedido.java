package vista.interfaces;

import modelo.Pedido;
import modelo.Producto;

public interface IVistaPedido extends IVista {

    void setItemListener();

    void setModelos();

    void inicializaComboBox(Pedido pedido);

    Producto getProductoSeleccionado();

    int getCantidadSeleccionada();
}
