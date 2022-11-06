package vista.interfaces;

import modelo.Pedido;

import modelo.Promocion;
import modelo.PromocionTemporal;

import java.util.ArrayList;
import java.util.Date;

public interface IVistaFactura extends IVista{

    void setModelos();

    void inicializarListas(ArrayList<Pedido> pedidos, ArrayList<Promocion> promociones);

    void setDatos(Date fecha, int NMesa, ArrayList<Pedido> pedidos, double total, ArrayList<Promocion> promociones);

    String getFormaDePago();
}
