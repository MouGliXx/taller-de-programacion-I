package vista.interfaces;

import modelo.Pedido;
import modelo.ProductoEnPromocion;
import modelo.PromocionTemporal;
import java.util.ArrayList;
import java.util.Date;

public interface IVistaFactura extends IVista{

    void setModelos();

    void inicializarListas(ArrayList<Pedido> pedidos, ArrayList<ProductoEnPromocion> productosEnPromocion, ArrayList<PromocionTemporal> promocionesTemporales);

    void setDatos(Date fecha, int NMesa, ArrayList<Pedido> pedidos, double total, ArrayList<ProductoEnPromocion> productosEnPromocion, ArrayList<PromocionTemporal> promocionesTemporales);

    String getFormaDePago();
}
