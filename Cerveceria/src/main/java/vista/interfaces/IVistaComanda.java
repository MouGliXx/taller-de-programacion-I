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

    void inicializaComboBox(ArrayList<Mesa> mesas);

    void inicializarLista(ArrayList<Pedido> pedidos);

    void actualizaLista();

    Pedido getPedidoSeleccionado();
}
