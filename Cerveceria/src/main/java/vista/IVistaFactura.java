package vista;

import modelo.IPromocion;
import modelo.Pedido;
import java.util.ArrayList;
import java.util.Date;

public interface IVistaFactura extends IVista{

    void setModelos();

    void inicializarListas(ArrayList<Pedido> pedidos, ArrayList<IPromocion> promociones);

    void setDatos(Date fecha, int NMesa, ArrayList<Pedido> pedidos, double total, ArrayList<IPromocion> promociones);

    String getFormaDePago();
}
