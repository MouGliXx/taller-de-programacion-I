package vista.interfaces;

import modelo.Producto;

public interface IVistaPedido extends IVista {

    void setItemListener();

    void setModelos();

    void inicializaComboBox();

    Producto getProductoSeleccionado();

    int getCantidadSeleccionada();
}
