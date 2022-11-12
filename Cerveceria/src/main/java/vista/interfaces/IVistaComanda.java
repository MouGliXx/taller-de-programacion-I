package vista.interfaces;

import modelo.Mesa;
import modelo.Pedido;
import java.util.ArrayList;
import java.util.Date;

public interface IVistaComanda extends IVista{

    void setListSelectionListener();

    void setAccion(String accion);

    void setFecha(Date fecha);

    void setModelos();

    void inicializaComboBox(Mesa mesa);

    void inicializarLista(ArrayList<Pedido> pedidos);

    int getNroMesa();

    ArrayList<Pedido> getPedidos();

    void eliminaPedidoEnLista();

    Pedido getPedidoSeleccionado();
}
