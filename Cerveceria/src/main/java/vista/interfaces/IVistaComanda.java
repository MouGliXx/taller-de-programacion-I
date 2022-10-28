package vista.interfaces;

import modelo.Pedido;
import java.util.ArrayList;
import java.util.Date;

public interface IVistaComanda extends IVista{

    void setAccion(String accion);

    void setFecha(Date fecha);

    void setModelos();

    void inicializarLista(ArrayList<Pedido> pedidos);

    Pedido getPedidoSeleccionado();
}
