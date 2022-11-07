package vista.interfaces;

import modelo.Mesa;
import modelo.Pedido;
import java.util.ArrayList;
import java.util.Date;

public interface IVistaComanda extends IVista{

    void setModelos();

    void setListSelectionListener();

    void setAccion(String accion);

    void setFecha(Date fecha);

    void inicializaComboBox(Mesa mesa);

    void inicializarLista(ArrayList<Pedido> pedidos);

    int getNroMesa();

    ArrayList<Pedido> getPedidos();

    void eliminaPedidoEnLista();

    Pedido getPedidoSeleccionado();
}
