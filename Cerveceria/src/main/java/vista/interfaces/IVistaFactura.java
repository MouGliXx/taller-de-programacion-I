package vista.interfaces;

import modelo.Pedido;

import modelo.Promocion;
import java.util.ArrayList;
import java.util.Date;

public interface IVistaFactura extends IVista{

    void setModelos();

    void inicializarListas(ArrayList<Pedido> pedidos, ArrayList<Promocion> promociones);

    void setDatos(Date fecha, int NMesa, ArrayList<Pedido> pedidos, ArrayList<Promocion> promociones);

    void setTotal(double total);

    String getFormaDePago();
}
